[CmdletBinding()]
param ([Parameter(Mandatory=$true)][int]$Squashing)

. "$PSScriptRoot/git.ps1"

if (!(Test-GitHead)) {
    return
}

$revs = (git rev-list --parents -1 HEAD) -split ' '
if ($LASTEXITCODE) {
    throw "git rev-list failed (exit code = ${LASTEXITCODE})."
}

[string]$head = $revs[0]
[string[]]$parents = $revs | Select-Object -Skip 1

Write-Host "HEAD = $head"
Write-Host "parents = $parents"
