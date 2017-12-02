call runcrud.bat
if "%ERRORLEVEL%" == "0" goto runchrome
goto fail

:runchrome
start chrome http://localhost:8080/crud/v1/task/getTasks
if "%ERRORLEVEL%" == "0" goto end
echo Unable to run Google Chrome
goto defaultbrowser

:fail
echo Error executing runcrud.bat
goto exit

:end
echo Launching web browser: done.
goto exit

:defaultbrowser
start http://localhost:8080/crud/v1/task/getTasks
if "%ERRORLEVEL%" == "0" goto end
echo Unable to run default web browser.
goto exit

:exit
echo Exiting.