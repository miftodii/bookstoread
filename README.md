In the previous section, we discussed that test methods are no longer required to be public in JUnit 5. A test method can be either protected or package protected. The preferred is to use package protected as that leads to less typing.

Tests in JUnit 5 must be annotated with org.junit.jupiter.api.Test annotation. This is different from the annotation used in JUnit 4.
As with test class constructors , test methods can also take parameters in JUnit 5.
Another thing to note here is that JUnit 5 changed the order of message parameter. In JUnit 4, the message used to be the first argument, but in JUnit 5 message it is the last argument. 
assertAll() lists all of the individual failed assertions

There are multiple ways we can ignore execution of test cases. We could remove the @Test annotation from the method/class. But, this will stop not only the execution of the test but also the discovery of the test. The test case will no longer be reported in JUnit statistics. It is far better to disable the test explicitly by using the @Disabled annotation rather than to delete it or remove the @Test annotation.
JUnit 5 provides the @Nested annotation to provide a logical grouping of test cases in the form of static inner member classes. Each of the static inner classes can have its own life cycle methods. These methods will be executed in hierarchical order. Additionally, the nested classes can be marked with @DisplayName, giving us all the benefits of proper test names. There is no limit on the level of nesting you can do.
The DI API allows us to inject values into all phases of the JUnit life cycle. If there is a parameter in a test method annotated with @BeforeAll, @BeforeEach, @Test, @AfterEach, or @AfterAll, the framework would try to determine its value and inject it.

For each of these test life cycle stages JUnit 5 provides an extension interface .
*BeforeAllCallback: This extension is executed before all the test methods are executed.
*AfterAllCallback: This extension is executed after all the test methods are executed.
*BeforeEachCallback: This extension is executed before each test method is executed.
*AfterEachCallback: This extension is executed after each test method is executed.
*BeforeTestExecutionCallback: This extension is executed immediately before the test is executed.
*AfterTestExecutionCallback: This extension is executed immediately after the test is executed.

The order of execution for a test class which has all extensions and life cycle methods is:
*BeforeAllCallback
*BeforeAll
*BeforeEachCallback
*BeforeEach
*BeforeTestExecution
*Test
*AfterTestExecution
*AfterEach
*AfterEachCallback
*AfterAll
*AfterAllCallback 

As mentioned in the JavaDoc of the TestInstancePostProcessor interface, the canonical example of this extension is injecting dependencies into the test instance.
There are situations in which we would like to control whether we should run a test case or not. JUnit 5 provides the ExecutionCondition extension interface for implementing this use case.
TestExecutionExceptionHandler extension can be used to alter the behavior of a test when it encounters an exception.
