# Автоматизация тестирования мобильного приложения "В Хосписе"

Данный дипломный проект тестирует мобильное приложение, которое имеет функционал по работе с претензиями хосписа и включает в себя:

-   информацию о претензиях и функционал для работы с ними;
-   новостную сводку хосписа;
-   тематические цитаты.

![main](https://raw.githubusercontent.com/MironovED/diploma_QA/master/pic/Screenshot_1.png)

## Документация

[План проекта](https://github.com/MironovED/diploma_QA/blob/master/docs/Plan.md)

[Чек-лист](https://github.com/MironovED/diploma_QA/blob/master/docs/Check.xlsx)

[Тест-кейсы](https://github.com/MironovED/diploma_QA/blob/master/docs/Cases.xlsx)

[Отчет по итогам тестирования](https://github.com/MironovED/diploma_QA/blob/master/docs/Result.md)

[Результат прогона тестов(Allure) ](https://github.com/MironovED/diploma_QA/blob/master/docs/allure-results.zip)

## Начало работы

Для получения копии существующего [проекта](https://github.com/MironovED/diploma_QA.git) необходимо сделать следующее:

1. Создать папку на локальном компьютере и открыть терминал по адресу папки
2. Для создания локального Git-репозитория ввести команду
    > **\***git init**\***
3. Что бы скопировать проект в созданную директорию в командной строке ввести
    > **\***git clone https://github.com/MironovED/diploma_QA.git**\***

## Prerequisites

Для запуска проекта и тестов требуется наличе установленных на ПК программ:

1. Android Studio + эмулятор на API 29
2. Java 11 версии
3. Allure

## Установка и запуск

1. Открыть проект fmh-android в Android Studio.
2. Запустить эмулятор (API 29) или подключить устройство для тестирования.
3. Запустить все тесты в директории app\src\androidTest\java\ru\iteco\fmhandroid\ui\tests
4. Сохранить каталог /data/data/ru.iteco.fmhandroid/files/allure-results при помощи Device File Explorer в директорию с проектом.
5. В терминале выполнить команду из дериктории проекта
    > **\***allure serve**\***
