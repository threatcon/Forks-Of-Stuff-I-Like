[CmdletBinding()]
param ([Parameter(Mandatory=$true)][string]$PrevHead,
       [Parameter(Mandatory=$true)][string]$NewHead,
       [Parameter(Mandatory=$true)][int]$ChangingBranches)

. "$PSScriptRoot/git.ps1"

if (!(Test-GitHead)) {
    return
}

$changes = Get-GitNameStatusChanges $prevHead $newHead
