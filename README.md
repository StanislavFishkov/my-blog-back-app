# my-blog-back-app

## Запуск

1. Соберите проект через команду 
```bash
./mvnw clean package
```
Итоговый артефакт (executable fat jar) будет в папке "target/".
2. Запустите executable fat jar командой:
```bash
   java -jar myblogbackapp-<version>.jar
```
Текущая версия проекта указана в pom.xml:
```xml
<version>0.0.1-SNAPSHOT</version>
```
Итоговый артефакт в этом случае назывался бы так:
```
   myblogbackapp-0.0.1-SNAPSHOT.jar
```
3. Приложение стартует по умолчанию на порте 8080.