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

## Keep DRY, KISS, and YAGNI
