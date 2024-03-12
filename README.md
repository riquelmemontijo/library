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
* Technologies
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
git clone git@github.com:riquelmemontijo/library.git
```
<hr>

* After that, in the path of the project, start the postgre's container with docker-compose:
```bash
docker-compose up -d
```

<hr>

* The application has an email service, so it's necessary to configure this part in application.properties.
In the section "#email configuration" you need to insert the properties of your email.

* I recommend to use Gmail, because it's very simple to get the password for applications. Just read this tutorial:
https://support.google.com/mail/answer/185833?hl=en

```properties
#email configuration
spring.mail.host=[INSERT YOUR HOST HERE]
spring.mail.port=[INSERT YOUR PORT HERE]
spring.mail.username=[INSERT YOUR USERNAME HERE]
spring.mail.password=[INSERT YOUR APP PASSWORD HERE]
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true
```

In the classes SendMailToNotifyBorrowExpiration and UserService you need to set the email that calls the email service.

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

<hr>

* In the section "#security configuration", the token secret is "secret", but if you want more security for some reason, you can create an environment variable "SECRET_JWT".

```properties
#security configuration
api.security.token.secret=${SECRET_JWT:secret}
```

<hr>

* The V10 file of Flyway, I inserted a default user to sign in on the app. In an HTTP request of POST type, for the url http://localhost:8080/user/login send this body:
```json
{
  "username":"master.master",
  "password":"masterpassword"
}
```

The response will be the token and the role of the user.

<hr>

Documentation
=================

To access the documentation, just paste this url in your browser while the app is running in your machine: http://localhost:8080/swagger-ui/index.html

<hr>

Tecnologies
=================

* Java 17
* Spring Boot
* Spring Security
* Spring Data JPA
* Spring Mail
* SpringDoc
* Docker
* Apache Maven
* PostgreSQL
* Flyway
* JUnit
* MapStruct
* Bean Validation

<hr>

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

- [x] Lending of books to students
- [x] Debit generation if there is a delay in the returning of books
- [x] Payment of debits

* Tasks

- [x] Send mail to student when the period of borrow is about to expire

* Security

- [x] Password reset with token
