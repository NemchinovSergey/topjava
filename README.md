Моя стажировка в Java Enterprise Online Project 
===============================

### <a href="http://topjava.herokuapp.com/" target=_blank>Демо разрабатываемого приложения</a>

## Описание и план проекта

####   Разработка полнофункционального Spring/JPA Enterprise приложения c авторизацией и правами доступа на основе ролей с использованием <a href="http://zeroturnaround.com/rebellabs/java-tools-and-technologies-landscape-for-2014/" target="_blank">наиболее популярных инструментов и технологий Java</a>: Maven, Spring MVC, Security, JPA(Hibernate), REST(Jackson), Bootstrap (css,js), datatables, jQuery + plugins, Java 8 Stream and Time API
-  Основное внимание уделяется способам решения многочисленных проблем разработки в Spring/JPA, а также структурному (красивому и надежному) java кодированию и архитектуре приложения.
-  Большое внимание уделяется тестированию кода: в проекте почти 90 тестов (JUnit).
-  Несмотря на относительно небольшой размер, приложение разрабатывается с нуля как большой проект (например, используется кэш 2-го уровня Hibernate, настраивается Jackson для работы с ленивой загрузкой
Hibernate, делаются конверторы для типов LocalDateTime (Java 8 time API), которые еще не поддерживаются ни JPA/Hibernate, ни Jackson/json).
            Разбираются архитектурные паттерны: слои приложения и как правильно разбивать логику по слоям, когда нужно применять Data Transfer Object.
            Т.е на выходе получается не учебный проект, а хорошо маштабируемый шаблон для большого проекта на всех пройденных технологиях.
-   Большое внимание уделяется деталям: популяция базы, использование транзакционности, тесты сервисов и REST
            контроллеров, насторойка EntityManagerFactory,
            выбор реализации пула коннектов. Особое внимание уделяется работе с базой: через Spring JDBC, Spring ORM и
            Spring Data Jpa.
-   Используются самые востребованные на сегодняшний момент фреймворки: Maven, Spring Security 4
            вместе с Spring Security Test, наиболее удобный для работы с базой проект Spring Data Jpa, библиотека логирования logback, реализующая SLF4J, повсеместно используемый Bootstrap и jQuery.


## План проекта
### Архитектура проекта. Персистентность.
-  <a href="https://drive.google.com/file/d/0B9Ye2auQ_NsFSUNrdVc0bDZuX2s">Системы управления версиями</a>
-  <a href="http://www.youtube.com/watch?v=_PDIVhEs6TM">Java 8: Lambda</a>, Stream API
-  Обзор используемых в проекте технологий и инструментов.
-  <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFSlZMTXBJRXJpakU">Инструмент сборки Maven.</a>
-  WAR. Веб-контейнер Tomcat. Сервлеты.
-  Логирование.
-  Обзор стандартных библиотек. Apache Commons, Guava
-  Слои приложения. Создание каркаса приложения.
-  Обзор Spring Framework. Spring Context.
-  Тестирование через JUnit.
-  <a href="https://drive.google.com/file/d/0B9Ye2auQ_NsFai1veG9qaFZlZ2s/view">Spring Test</a>
-  Базы данных. PostgreSQL. Обзор NoSQL и Java persistence solution без ORM.
-  Настройка Database в IDEA.
-  Скрипты инициализации базы. Spring Jdbc Template.
-  <a href="https://drive.google.com/file/d/0B9Ye2auQ_NsFU0Z2R190eDllYmM/view">Spring: инициализация и популирование DB</a>
-  ORM. Hibernate. JPA.
-  Поддержка HSQLDB
-  Транзакции
-  Профили Maven и Spring
-  <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFTWJOdHduOWtNcTA">Пул коннектов</a>
-  Spring Data JPA
-  Кэш Hibernate

### Разработка WEB
-  Spring кэш
-  Spring Web
-  JSP, JSTL, i18n
-  Tomcat maven plugin. JNDI
-  Spring Web MVC
-  Spring Internationalization
-  Тестирование Spring MVC
-  REST контроллеры
-  Тестирование REST контроллеров. Jackson.
-  jackson-datatype-hibernate. Тестирование через матчеры.
-  Тестирование через SoapUi. UTF-8
-  WebJars.
-  Bootstrap. jQuery datatables.
-  AJAX. jQuery. Notifications.
-  Spring Security
-  Spring Binding/Validation
-  Работа с datatables через Ajax.
-  Spring Security Test
- [Кастомизация JSON (@JsonView) и валидации (groups)](https://drive.google.com/open?id=0B9Ye2auQ_NsFRTFsTjVHR2dXczA)
-  Encoding password
-  <a href="https://drive.google.com/file/d/0B9Ye2auQ_NsFNDlPZGdUNThzNUU/view">CSRF (добавление в проект защиты от межсайтовой подделки запроса)</a>
-  form-login. Spring Security Taglib
-  Handler interceptor
-  Spring Exception Handling
-  Смена локали
-  Фильтрация JSON через @JsonView
-  Защита от XSS (Cross Site Scripting)
-  <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFZkpVM19QWFBOQ2c">Деплой в Heroku</a>
-  Локализация datatables, ошибок валидации
-  Обработка ошибок 404 (NotFound)
-  Доступ к AuthorizedUser

Просто полезные ресурсы
===============================

#### HTML, JavaScript, CSS 
- [Изучение JavaScript в одном видео уроке за час](https://www.youtube.com/watch?v=QBWWplFkdzw)
- <a href="http://www.w3schools.com/default.asp">HTML, CSS, JAVASCRIPT, SQL, JQUERY, BOOTSTRAP</a>
- <a href="https://www.youtube.com/watch?v=j0ycGQKqMT4">Введение в программирование на JavaScript</a>
- <a href="http://anton.shevchuk.name/javascript/html-css-javascript-standarts/">Стандарты кодирования для HTML, CSS и JavaScript’a</a>
- <a href="http://www.intuit.ru/studies/courses/1102/134/info">Основы работы с HTML/CSS/JavaScript</a>
- <a href="http://itchief.ru/lessons/javascript/94-javascript-introduction">JavaScript - Основы</a>
- <a href="http://learn.javascript.ru/first-steps">Основы JavaScript</a>
- <a href="http://itchief.ru/lessons/bootstrap-3/19-introduction-to-twitter-bootstrap-3">Bootstrap 3 - Основы</a>
- <a href="http://anton.shevchuk.name/jquery/">jQuery для начинающих</a>

#### Java (базовые вещи)
- <a href="http://www.intuit.ru/studies/courses/16/16/info">Интуит. Программирование на Java</a>
- <a href="https://github.com/JavaOPs/masterjava#Первое-занятие-многопоточность">1й урок MasterJava: Многопоточность</a>
- <a href="http://ggenikus.github.io/blog/2014/05/04/gc/">Основы Java garbage collection</a>
- <a href="https://habrahabr.ru/post/134102/">Размер Java объектов</a>
- <a href="http://www.quizful.net/post/java-reflection-api">Введение в Java Reflection API</a>
- <a href="https://habrahabr.ru/users/tarzan82/topics/">Структуры данных в картинках</a>
- <a href="https://habrahabr.ru/company/luxoft/blog/157273/">Обзор java.util.concurrent.*</a>
- <a href="http://www.skipy.ru/technics/synchronization.html">Синхронизация потоков</a>
- <a href="http://java67.blogspot.ru/2014/08/difference-between-string-literal-and-new-String-object-Java.html">String literal pool</a>
- <a href="https://habrahabr.ru/post/132241/">Маленькие хитрости Java</a>
-  <a href="https://github.com/winterbe/java8-tutorial">A Guide to Java 8</a>

### Туториалы, разное
[Что нужно знать о бэкенде новичку в веб-разработке](https://tproger.ru/translations/backend-web-development)
[Туториалы: Spring Framework, Hibernate, Java Core, JDBC](http://proselyte.net/tutorials/)

#### Сервлеты
-  <a href="http://devcolibri.com/4284">Как создать Servlet? Полное руководство.</a>
-  <a href="https://danielniko.wordpress.com/2012/04/17/simple-crud-using-jsp-servlet-and-mysql/">Простое CRUD приложение на JSP и сервлетах</a>

#### JDBC, SQL
- <a href="https://habrahabr.ru/post/123636/">Основы SQL на примере задачи</a>
-  <a href="https://www.youtube.com/playlist?list=PLIU76b8Cjem5qdMQLXiIwGLTLyUHkTqi2">Уроки по JDBC</a>
-  <a href="https://www.codecademy.com/learn/learn-sql">Learn SQL</a>
-  <a href="http://www.intuit.ru/studies/courses/5/5/info">Интуит. Основы SQL</a>
-  <a href="http://campus.codeschool.com/courses/try-sql/contents">Try SQL</a>
-  <a href="https://stepic.org/course/Введение-в-базы-данных-551">Курс "Введение в базы данных"</a>

#### Разное
-  <a href="http://jeeconf.com/materials/intellij-idea/">Эффективная работа с кодом в IntelliJ IDEA</a>
-  <a href="http://www.quizful.net/test">Quizful- тесты онлайн</a>
-  <a href="https://stepic.org/course/Введение-в-Linux-73">Введение в Linux</a>

#### Книги
-  <a href="http://www.ozon.ru/context/detail/id/24828676/">Джошуа Блох: Java. Эффективное программирование. Второе издание</a>
-  <a href="http://www.labirint.ru/books/87603/">Гамма, Хелм, Джонсон: Приемы объектно-ориентированного проектирования. Паттерны проектирования</a>
-  <a href="http://www.bookvoed.ru/book?id=639284">Редмонд Э.: Семь баз данных за семь недель. Введение в современные базы данных и идеологию NoSQL</a>
-  <a href="http://www.ozon.ru/context/detail/id/3174887/">Brian Goetz: Java Concurrency in Practice</a>
-  <a href="http://bookvoed.ru/book?id=2593572">G.L. McDowell: Cracking the Coding Interview</a>
