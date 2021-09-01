@rem put this project path into PATH_FROM
setlocal
set PATH_FROM=D:\Documents\programming\mindustry\Mindustrial-Thermodynamics
@rem put your mindustry local path into PATH_TO
setlocal
set PATH_TO=C:\Users\yuchan\AppData\Roaming\Mindustry
@rem put your minudstry *jar* path into MINDUSTRY
setlocal
set MINDUSTRY=D:\Documents\programming\mindustry\Mindustry.jar

if exist %PATH_TO%\mods\MIT.jar del %PATH_TO%\mods\MIT.jar
xcopy %PATH_FROM%\build\libs\MIT.jar %PATH_TO%\mods\ /k
del %PATH_FROM%\build\libs\MIT.jar
java -jar %MINDUSTRY% -XX:+CreateCoredumpOnCrash