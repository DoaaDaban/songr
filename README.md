# songr

## Architecture

The programing language used to build this project is Java and using the Spring MVC Data and Thymeleaf.


## Lab-11: Building Full-Stack Web Apps

### Overview

This lab about how to set up a basic webapp that built with the Spring MVC Data and Thymeleaf.

### Routers:

#### MainController Class

##### [http://localhost:8080/hello](http://localhost:8080/hello)

* `@GetMapping("/hello") String helloWorld()`: Go to the hello.html that contain **Hello world**.

##### [http://localhost:8080/capitalize/hello](http://localhost:8080/capitalize/hello)

* ` @GetMapping("/capitalize/{id}") String hello(Model model, @PathVariable("id") String id)`: This router go to the HelloWorld.html page and this router contain `id` parameter, so in the html page it will render the text that store in the `id` parameter in upper case.

##### [http://localhost:8080/](http://localhost:8080/)

* This is route for home page (root page).


#### AlbumController Class

##### [http://localhost:8080/albums](http://localhost:8080/albums)

* `@GetMapping("/albums") public String albums( Model model)` : This router go to the album.html page and this page contains the albums.

#### Album Class

The Album class contains 5 variables:

1. `String title`: To stor the album title.

2. `String artist`: To store the artist name.

3. `int songCount`: To stor the number of song in the album.

4. `long length` : To store the total lenght of song in seconds.

5. `String imageUrl` : To store the album image URL.

* Create a constructor and its parameters are all variables above. And also create a getter and setter methods for all variables.

## Lab-12: Spring and REST

### Overview

The requirement for this lab is how the user can add albums to the albums page by fill the forms.

### Router:

#### [http://localhost:8080/albums](http://localhost:8080/albums)

* This route is for a page that contains a form that users fill in to add albums to the album page.

### Getting Started

To run the app you shoud follow the folloing steps:

1. [Getting started with Spring](https://spring.io/guides/gs/serving-web-content/) : This website show you how to build an application by **Spring**.

    * This is the dependencies build.gradle    file
    ```
       dependencies {
	   implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
	   runtimeOnly('org.postgresql:postgresql')
	   implementation 'org.springframework. boot:spring-boot-starter-thymeleaf'
	   implementation 'org.springframework.boot:spring-boot-starter-web'
	   developmentOnly 'org.springframework.boot:spring-boot-devtools'
	   testImplementation 'org.springframework.boot:spring-boot-starter-test'
       }
      ```


2. In **application.properties** file you shode put thess lines:

```spring.datasource.port=8080
spring.datasource.url=jdbc:postgresql://localhost:5432/<<put the postgres name>>
spring.datasource.username=<<username>
spring.datasource.password=<<postgres password>>
spring.jpa.database=POSTGRESQL
spring.jpa.show-sql=true
spring.jpa.generate-ddl=true
spring.jpa.hibernate.ddl-auto=create-drop
spring.jpa.properties.hibernate.format_sql=true
spring.jpa.properties.hibernate.jdbc.lob.non_contextual_creation=true
spring.jpa.database-platform=org.hibernate.dialect.PostgreSQL9Dialect
spring.sql.init.platform=postgres
```

3. You should run the POSTGRESQL on the trminal by using these commands"

    * sudo service postgresql start

    * sudo -i -u postgres

    * psql

    * \connect <<`database name`>>

    * \dt

    * select * from album;

## Lab-13: Related Resources and Integration Testing

### Overview

The requirement for this lab is how the user can add a song to the specific album by fill the forms.

### Router:

#### [http://localhost:8080/addSong](http://localhost:8080/addSong)

* This route is for **added song** page. The page contains a form to add a song to the specific album by fill it by the user.

### [http://localhost:8080/songs](http://localhost:8080/songs)

* This route for **song** page. The page contains the songs that are added by the user.