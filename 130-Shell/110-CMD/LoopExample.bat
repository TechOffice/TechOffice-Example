@echo off
setlocal

rem for /l: Loop through a range [1st: start; 2nd: increment; 3rd max]
for /l %%x in (1, 20, 100) do (
   echo %%x
)

rem for /r: Loop through current folder 
for /r . %%x in (*) do (
	echo %%x
)
