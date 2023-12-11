function Test-GitHead()
{
    [bool](git show-ref --head --heads ?)
}

function Get-GitNameStatusChanges($commit1, $commit2)
{
    $changes =
        git diff-tree -r --name-status "${commit1}..${commit2}" |
        % {
            $status, $name = $_ -split '\t'
            New-Object pscustomobject -Property @{ Name = $name; Status = $status }
        }

    if ($LASTEXITCODE) {
        throw "git diff-tree (${commit1}..${commit2}) failed (exit code = ${LASTEXITCODE})."
    }

    return $changes
}
