In the previous section, we discussed that test methods are no longer required to be public in JUnit 5. A test method can be either protected or package protected. The preferred is to use package protected as that leads to less typing.

Tests in JUnit 5 must be annotated with org.junit.jupiter.api.Test annotation. This is different from the annotation used in JUnit 4.
As with test class constructors , test methods can also take parameters in JUnit 5.
Another thing to note here is that JUnit 5 changed the order of message parameter. In JUnit 4, the message used to be the first argument, but in JUnit 5 message it is the last argument. 
