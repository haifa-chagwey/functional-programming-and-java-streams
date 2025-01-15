# Functional Interface

### What is a functional interface?

If a Java interface contains one and only one abstract method then it is termed as functional interface.
This only one method specifies the intended purpose of the interface.

For example, the Runnable interface from package java.lang;is a functional interface because it constitutes only one
method i.e. run().

Example:
```
import java.lang.FunctionalInterface;

@FunctionalInterface
public interface MyInterface{
    // the single abstract method
    double getValue();
}
```
In the above example, the interface MyInterface has only one abstract method getValue(). Hence, it is a functional interface.  
The annotation @FunctionalInterface forces the Java compiler to indicate that the interface is a functional interface. Hence, does not allow to have more than one abstract method. However, it is not compulsory though.

In Java 7, functional interfaces were considered as Single Abstract Methods or SAM type. SAMs were commonly implemented with anonymous classes in Java 7.

### Implementing a functional interface using anonymous class

```
public class FunctionInterfaceTest {
    public static void main(String[] args) {

        // anonymous class
         Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("I just implemented the Runnable Functional Interface.");
            }
        };
        runnable.run();
        // new Thread(runnable).start();
        
        // Or 
        
        // anonymous class
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("I just implemented the Runnable Functional Interface.");
            }
        }).start();
    }
}
```
Here, we can pass an anonymous class to a method. This helps to write programs with fewer codes in Java 7. However, the syntax was still difficult and a lot of extra lines of code were required.

Java 8 extended the power of a SAMs by going a step further. Since we know that a functional interface has just one method, there should be no need to define the name of that method when passing it as an argument. Lambda expression allows us to do exactly that.

### Implementing Functional Interface using Lambda Expression

```
public class FunctionInterfaceTest {
    public static void main(String[] args) {

        // lambda expression
        Runnable runnable = () -> System.out.println("I just implemented the Runnable Functional Interface.");
        runnable.run();
        // new Thread(runnable).start();
        
        // Or
        
        new Thread(() -> System.out.println("I just implemented the Runnable Functional Interface.")).start();

    }
}
```
### Generic Functional Interface

Till now we have used the functional interface that accepts only one type of value. For example:
```
@FunctionalInterface
interface MyInterface {
    String reverseString(String n);
}
```
The above functional interface only accepts String and returns String. However, we can make the functional interface generic, so that any data type is accepted. If you are not sure about generics, visit Java Generics.
Example: Generic Functional Interface

```
// GenericInterface.java
@FunctionalInterface
interface GenericInterface<T> {

    // generic method
    T func(T t);
}

// GenericLambda.java
public class Main {

    public static void main( String[] args ) {

        // declare a reference to GenericInterface
        // the GenericInterface operates on String data
        // assign a lambda expression to it
        GenericInterface<String> reverse = (str) -> {

            String result = "";
            for (int i = str.length()-1; i >= 0 ; i--)
            result += str.charAt(i);
            return result;
        };

        System.out.println("Lambda reversed = " + reverse.func("Lambda"));

        // declare another reference to GenericInterface
        // the GenericInterface operates on Integer data
        // assign a lambda expression to it
        GenericInterface<Integer> factorial = (n) -> {

            int result = 1;
            for (int i = 1; i <= n; i++)
            result = i * result;
            return result;
        };

        System.out.println("factorial of 5 = " + factorial.func(5));
    }
}
```