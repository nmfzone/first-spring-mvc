# Features History
It's my explanation about the history of features that i use in my application

### Accessing Database
```
    To acccess Database in Spring, it have several ways. In my code, i prefered to use DAO Design
    Pattern. On the other hand, you can use such as JpaRepository or CrudRepository to access database that have less code to work with and also more simple.

    http://www.tutorialspoint.com/design_pattern/data_access_object_pattern.htm

    The most important thing is, no matter what way you choose, you will need Hibernate to
    communicate using ORM (yes, because i'm prefered to use Hibernate).
```

### Spring Boot Starter
```
    The most interesting when you use Spring, Spring provide fast configuration by using
    Spring Boot Starter. It's very nice when you need Spring configuration out-of-the-box.
```

### Remove Features
#### slf4j and log4j
```
It's logging features.

Reason :
Because Google Gson has more complex as i needed.

To use :
compile('org.slf4j:slf4j-api')
compile('org.slf4j:slf4j-simple')

compile('log4j:log4j')
```
#### Hibernate
```
It's ORM Database.

Reason :
Because by using Spring boot starter data JPA, it's also pull all of this.

To use :
# Core
compile('org.hibernate:hibernate-core:5.0.7.Final')

# Validator
compile('javax.validation:validation-api:1.1.0.Final')
compile('org.hibernate:hibernate-validator:5.2.1.Final')
```
#### DBCP
```
It's Database Connection Pool provided by Apache. It's support Connection
using older Driver based on jdbc implementation.
http://commons.apache.org/proper/commons-dbcp/api-1.2.2/index.html

Reason :
Because it isn't

To use :
compile('commons-dbcp:commons-dbcp:1.4')
```
#### @ConfigurationProperties
```
It's annotation to make configuration so that we can have any value that
we want from application.properties or application.yml

Reason :
Because it's can be simply by using org.springframework.core.env.Environment;
env.getProperty("config.db.host")
Or for now (24 Jan 2015), simply by use @Value annotation

To use :
- Make @Component for each @ConfigurationProperties
It's containt name of config value. Also setter and getter for each config value.
import org.springframework.boot.context.properties.ConfigurationProperties;
- If it have nested properties, use @NestedConfigurationProperty
import org.springframework.boot.context.properties.NestedConfigurationProperty;
- Don't forget to @EnableConfigurationProperties so that it will works
import org.springframework.boot.context.properties.EnableConfigurationProperties;
```
#### @EnableAutoConfiguration and @ComponentScan
```
See explanation in :
https://spring.io/guides/gs/securing-web/

Reason :
Because if using Spring Boot, it's can simply by using @SpringBootApplication
annotation, it's automatic adds all of that. The explanation :

------
@SpringBootApplication is a convenience annotation that adds all of the following:

    @Configuration tags the class as a source of bean definitions for
    the application context.

    @EnableAutoConfiguration tells Spring Boot to start adding beans based on
    classpath settings, other beans, and various property settings.

    Normally you would add @EnableWebMvc for a Spring MVC app, but Spring Boot adds it automatically when it sees spring-webmvc on the classpath. This flags the application
    as a web application and activates key behaviors such as setting up a DispatcherServlet.

    @ComponentScan tells Spring to look for other components, configurations,
    and services in the hello package.
------
```


## Keep DRY, KISS, and YAGNI
