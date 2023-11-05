# README

## Project 2 [Metro State](https://www.metrostate.edu/) Fall 2023 Class ICS 625 Service Oriented Architecture and Web Services


This application allows a person to manage educational courses.  It's run via a SOAP servcie using Spring Boot.  Also, H2 will be used for a database.  

Using the H2 console, or SOAP service, a person can:  

* get all offered courses
* get all courses
* get course by ID
* get course by number
* get course by title
* add new course
* delete a course by ID
* update a course (can only update title and description)


A course consists of the following information:

* id (long) – auto generated
* number (string)
* title (string)
* description (string)
* offered (boolean)


Sample Course Data:

```xml
	<course>
	  <id>212</id>
	  <number>ICS 141</number>
	  <title>Introduction to Programming</title>
	  <description>
		 Students will learn basic programming and problem solving.
	  </description>
	  <offered>true</offered>
	</course>
```

## Security  

Stretch goal per [Professor Cheng Thao](https://www.metrostate.edu/about/directory/cheng-thao)


"If we do cover WS Security next week, do add user authentication to your web service.  It should check that a user exists in the database to be allowed to add or delete a course."


## Unit Testing 

Unit testing will be conducted using SOAP UI.  

