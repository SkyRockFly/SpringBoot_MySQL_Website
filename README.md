Функции: 

-Регистрация, авторизация, аутентификация(админ и пользователей) пользователей; 

-Запрет доступа к страницам для неавторизованных пользователей, доступ к личной странице пользователя ограничен только им; 

-Создание заказов, их отображение в личной странице пользователя; 

-Список пользователей для админа; 

-Помещение информации о пользователях, заказах в MySQL Database. 

--------------------------------------------

При создании использовалось: 
-Java, Spring Boot(Spring Web, Security, Data Jpa, Validation, MySQL Driver), Lombok, Thymeleaf.

--------------------------------------------

В проекте 7 директорий:

-Configuration

Настройка для Spring security, запрет доступа для неавторизованных пользователей, выдача доступа к странице с данными о пользователях аккаунту с ролью ADMIN.

-Controller

Выдаёт веб-страницу в зависимости от веб-адреса.

-dto

Преобразовывает объекты из MySQL Database в удобную для основного кода форму;

-Entity

Объекты, которые используются на веб-страницах и соединенные с таблицами в MySDL Database;

-Repository

Позволяет отправлять запросы к MySQL Database, используя Hibernate. С помощью их мы получаем информацию из таблиц в датабазе.

-Security

Загрузка пользователя из датабазы и его роли.

-Service

Выполняет загрузку, добавление объектов в MySQL Database.

--------------------------------------------------------

Скрипты содержаться в MySQL Scripts:

RegisterLoginTables - создание таблиц пользователей (users), ролей(roles) и таблица для связи many to many(users_roles).

OrderTableScript - создание таблиц заказов(orders) и дополнений к заказам(upgrades).

