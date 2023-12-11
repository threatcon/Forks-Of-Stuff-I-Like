@echo off
setlocal
if not "%~1"=="" set GIT_DIR=%~1
if not defined GIT_DIR set GIT_DIR=%~dp0..\..\.git
if not exist "%GIT_DIR%" (
    echo>&2 Git directory "%GIT_DIR%" not found.
    echo>&2 Re-run with Git directory path specified as the first argument.
    exit /b 1
)
robocopy /mir "%~dp0." "%GIT_DIR%\hooks" /xf install.cmd /xf *.sample
::
:: The return code from Robocopy is a bitmap, defined as follows:
::
::     Hex   Decimal  Meaning if set
::
::     0x00   0       No errors occurred, and no copying was done.
::                    The source and destination directory trees are
::                    completely synchronized.
::
::     0x01   1       One or more files were copied successfully (that
::                    is, new files have arrived).
::
::     0x02   2       Some Extra files or directories were detected.
::                    No files were copied.
::
::     0x04   4       Some Mismatched files or directories were detected.
::                    Examine the output log. Housekeeping might be required.
::
::     0x08   8       Some files or directories could not be copied
::                    (copy errors occurred and the retry limit was exceeded).
::                    Check these errors further.
::
::     0x10  16       Serious error. Robocopy did not copy any files.
::                    Either a usage error or an error due to insufficient
::                    access privileges on the source or destination
::                    directories.
::
:: These can be combined, giving a few extra exit codes:
::
::     0x03   3       (2+1) Some files were copied. Additional files were
::                    present. No failure was encountered.
::
::     0x05   5       (4+1) Some files were copied. Some files were
::                    mismatched. No failure was encountered.
::
::     0x06   6       (4+2) Additional files and mismatched files exist. No
::                    files were copied and no failures were encountered.
::                    This means that the files already exist in the
::                    destination directory.
::
::     0x07   7       (4+1+2) Files were copied, a file mismatch was present,
::                    and additional files were present.
::
:: Any value greater than 7 indicates that there was at least one failure
:: during the copy operation.
::
:: Copyright SS64.com 1999-2020. Some rights reserved
:: Source & credit: https://ss64.com/nt/robocopy-exit.html
::
if errorlevel 8 exit /b 1
exit /b 0
