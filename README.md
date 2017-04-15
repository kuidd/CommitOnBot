# CommitOnBot

Telegram Bot для уведомления об изменениях в репозиториях.


Инструкция по установке:
1. Необходимо установить Postgresql https://www.postgresql.org/download/windows/
2. Создать базу данных, например telegram.
3. Открыть файл src/main/resources/config.properties и настроить поля:

datasource.jdbcUrl
datasource.user
datasource.password

4. Запустить сервер с помощью Jetty, Tomcat


API сервера:
* /telegram/send?text=Hello - отправка сообщения "Hello" в общий чат
