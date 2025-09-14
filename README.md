# my-blog-back-app

## Запуск

1. Соберите проект через команду 
```bash
./gradlew clean build
```
2. Скопируйте war-артефакт из папки "build/libs" и переименуйте его в ROOT.war
3. ROOT.war переместите в папку "webapps" внутри корневой папки сервера Tomcat
4. При настройках по умолчанию Tomcat в conf/server.xml для localhost:
```xml
<Host name="localhost"  appBase="webapps"
   unpackWARs="true" autoDeploy="true">
    ...
</Host>
```
    произойдет автоматическая распаковка и загрузка артефакта,
    и его ендпоинты станут доступны по "localhost:8080/"