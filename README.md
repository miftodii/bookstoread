In the previous section, we discussed that test methods are no longer required to be public in JUnit 5. A test method can be either protected or package protected. The preferred is to use package protected as that leads to less typing.

Tests in JUnit 5 must be annotated with org.junit.jupiter.api.Test annotation. This is different from the annotation used in JUnit 4.
