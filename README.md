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