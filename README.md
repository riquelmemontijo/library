# Library API

## REST API to manage a library

<h4> 
	🚧 Library API 🚀 In construction...  🚧
</h4>

Index
=================
<!--ts-->
* Requirements
* Configuration
* Documentation
* Tecnologies
* Features
<!--te-->

<hr>

Requirements
=================

* JDK or JRE (version 17 - download on https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html) 
* Docker (download on https://www.docker.com/products/docker-desktop/)

<hr>

Configuration
=================
* First, clone the repository in your machine.
```bash
git clone git@github.com:riquelmemontijo/biblioteca.git
```

* After that, in the path of the project, start the postgre's container with docker-compose:
```bash
docker-compose up
```

* It's not necessary to create a newdatabase, because application.properties have a property (spring.datasource.url=jdbc:postgresql://localhost:5431/library?createDatabaseIfNotExist=true) that make this.
Anyway, if you want to make something in the database, run this command:
```bash
docker exec -it db_library psql -U admin
```

* The application have an email service, so it's necessary to configure this part in application.properties.
In the section "#email configuration" you need to insert the properties of your email.

* I recommend to use Gmail, because it's very simple to get the password for applications. Just read this tutorial:
https://support.google.com/mail/answer/185833?hl=en

```
#email configuration
spring.mail.host= [INSERT YOUR HOST HERE]
spring.mail.port= [INSERT THE PORT HERE]
spring.mail.username= [INSERT THE USERNAME HERE]
spring.mail.password= [INSERT THE APP PASSWORD HERE]
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true
```

In the classes SendMailToNotifyBorrowExpiration and UserService you need to set the email that call the email service.

In SendMailToNotifyBorrowExpiration
```java
@Scheduled(cron = "0 0 6 * * *")
private void getStudentsWithDelay(){
    var borrows = borrowRepository.findBorrowDueToday();
    borrows.ifPresent(n -> n.forEach(record ->
    emailService.sendSimpleMail(new Email(getSubject(),
                                "your.email@email.com",
                                record.email(),
                                getContent(record.name())))));
}
```

In EmailService
```java
public void forgotPassword(UserForgotPasswordDTO data) throws Exception {
        UserDomain userDomain = userRepository.findByEmail(data.email())
                                              .orElseThrow(
                                                      () -> new RecordNotFoundException(data.email())
                                              );

        String token = tokenResetService.generateToken(userDomain);

        String subject = "Change Password";
        String from = "your.email@email.com";
        String to = data.email();
        String content = getTextForEmailResetPassword(userDomain, token);

        var email = new Email(subject, from, to, content);

        emailService.sendMimeMail(email, content);
}
```

In the section "#security configuration", the token secret is "secret", but if you wanna more security for some reason, you can create an environment variable "SECRET_JWT".

```
#security configuration
api.security.token.secret=${SECRET_JWT:secret}
```

Documentation
=================

To access the documentation, just paste this url in your browser: http://localhost:8080/swagger-ui/index.html

Tecnologies
=================

* Java 17
* Spring Boot
* Spring Security
* Spring Data JPA
* Spring Mail
* Docker
* Apache Maven
* Postgresql
* Flyway
* JUnit
* MapStruct
* Bean Validation

Features
=================

* CRUD of:

- [x] Book
- [x] Author
- [x] Bookcase
- [x] Borrow
- [x] Genre
- [x] Hall
- [x] Student
- [x] User

* Business flow

- [x] Borrow of books to students
- [x] Debit generation if there is a delay in returning books
- [x] Payment of debits

* Tasks

- [x] Send mail to student when the period of borrow is about to expire

* Security

- [x] Password reset with token
