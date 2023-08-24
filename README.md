# Library API

## REST API to manage a library

<h4> 
	🚧 Library API 🚀 In construction...  🚧
</h4>

Index
=================
<!--ts-->
* [About](#about)
* [Requirements](#requirements)
* [Configuration](#configuration)
* [Documentation](#documentation)
* [Features](#features)
* [Tecnologies](#tecnologies)
<!--te-->

<hr>

Requirements
=================

* JDK or JRE (version 17 - download on https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html) 
* Docker (download on https://www.docker.com/products/docker-desktop/)

<hr>

Configuration
=================
First, clone the repository in your machine.

```bash
git clone git@github.com:riquelmemontijo/biblioteca.git
```

After that, in the path of the project, start the postgre's container with docker-compose:

```bash
docker-compose up
```

It's not necessary to create a newdatabase, because application.properties have a property (spring.datasource.url=jdbc:postgresql://localhost:5431/library?createDatabaseIfNotExist=true) that make this.
Anyway, if you want to make something in the database, run this command:
```bash
docker exec -it db_library psql -U admin
```

The application have an email service, so it's necessary to configure this part in application.properties.
In the section "#email configuration" you need to insert the properties of your email.

I recommend Gmail, because it's very simple to get the password for applications. Just read this tutorial:
https://support.google.com/mail/answer/185833?hl=en

```
#email configuration
spring.mail.host= [INSERT YOU HOST HERE]
spring.mail.port= [INSERT THE PORT HERE]
spring.mail.username= [INSERT THE USERNAME HERE]
spring.mail.password= [INSERT THE APP PASSWORD HERE]
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true
```

In the section "#security configuration", the token secret is "secret", but if you wanna more security for any reason, you can create an environment variable "SECRET_JWT".

```
#security configuration
api.security.token.secret=${SECRET_JWT:secret}
```


