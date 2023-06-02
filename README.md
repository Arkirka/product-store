# product-store
# Инструкция по запуску
## Через докер
Ввести в терминале в корне проекта команды
```
docker-compose build
docker-compose up
```
## Через maven
Ввести в терминале в корне проекта команду
```
mvn clean package
```
После этого соберется jar-файл по пути target\computer-store-0.0.1-SNAPSHOT.jar. 
Далее ввести команду запуска собранного jar-файла
```
java -jar .\target\computer-store-0.0.1-SNAPSHOT.jar
```
# Дополнительно
## Материалы
При запуске выполняется добавление [этих записей](https://github.com/Arkirka/product-store/blob/master/src/main/resources/data.sql) в базу данных
## Взаимодействие с API
Для удобства взаимодействия я подключил swagger.
После запуска swagger будет доступен по пути /swagger-ui. Таким образом, при запуске на localhost путь будет выглядеть следующим образом 
```
http://localhost:8080/swagger-ui
```
## Схематическое изображение связей таблиц базы данных
![alt text](https://github.com/Arkirka/product-store/blob/material/images/products.png)
