# Design Pattern
It's all about my explanation of Application Design Pattern that i use in here

### Accessing Database
```
    To acccess Database in Spring, it have several ways. In my code, i prefered
    to use DAO Design Pattern. On the other hand, you can use such as
    JpaRepository or CrudRepository to access database that have less
    code to work with and also more simple.

    http://www.tutorialspoint.com/design_pattern/data_access_object_pattern.htm

    The most important thing is, no matter what way you choose, you will
    need Hibernate to communicate using ORM.

    By using DAO Design Pattern, we must create at least 3 files.
    The first file is abstract class that use Hibernate SessionFactory to
    establish communication with database. The second is interface
    and the third class is the implementation of the second class.
```

### Spring Boot Starter
```
    The most interesting when you use Spring is Spring provide fast
    configuration by using Spring Boot Starter. It's very nice when you
    need configuration out-of-the-box.
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

## Keep DRY, KISS, and YAGNI
