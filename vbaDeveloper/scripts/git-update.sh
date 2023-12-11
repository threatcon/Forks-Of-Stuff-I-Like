#!/bin/bash
# Source this script.
# It implements a process that fast-forwards a repository, if possible.
# There are some cases where user input is required for decisions.
this_script_dir=$(cd -- "$( dirname -- "${BASH_SOURCE[0]}" )" &> /dev/null && pwd)

source ${this_script_dir}/git-utils.sh

msg "Checking for updates"

git fetch
# Set the origin/HEAD ref
# This is normally done by clone, but this repo might've been copied without the clone command. 
git remote set-head origin -a

# Check if the default branch is being used
current_branch=$(git rev-parse --abbrev-ref HEAD)
default_branch=$(basename $(git rev-parse --abbrev-ref origin/HEAD))
if [[ "$current_branch" != "$default_branch" ]]; then
    msg "Current branch ($current_branch) differs from default branch ($default_branch)."
    prompt "Assuming developer and aborting update. Hit <Enter> to continue."
    return 1
fi

# If there are no differences between the local default
# and the remote default, no update required.
if git diff --quiet --exit-code HEAD..origin/HEAD; then
    msg "No updates."
    return 1
fi

# Get the number of commits that origin/HEAD is ahead of HEAD
ahead=$(git rev-list --left-right --count origin/HEAD...HEAD | gawk '{print $2}')
if [[ $ahead -ne 0 ]]; then
    prompt "HEAD is ahead of origin by $ahead commits. Assuming developer and aborting update. Hit <Enter> to continue."
    return 1
fi
unset ahead

# Check for uncommitted changes
if ! git diff --quiet --exit-code HEAD; then
    msg "You have uncommitted changes to the following files."
    git diff --name-only HEAD
    if prompt-yn "Keep your changes and defer update?"; then
        msg "Deferring update."
        sleep 2s
        return 1
    else
        msg "Resetting uncommitted changes."
        git reset --hard HEAD
    fi
fi

msg "The following commits can be applied."
git log --no-decorate origin/HEAD...HEAD
if ! prompt-yn "Do you want to apply them?"; then
    msg "Deferring update."
    sleep 2s
    return 1
fi

if git merge --ff-only; then
    msg "Fast-forward complete."
else
    prompt +2 "A problem occurred while fast-forwarding. Hit <Enter> to continue."
    return 1
fi

if git submodule update; then
    msg "Submodule update complete."
else
    prompt +2 "A problem occurred while updating submodule. Hit <Enter> to continue."
    return 1
fi

msg "Update successful."
return 0
