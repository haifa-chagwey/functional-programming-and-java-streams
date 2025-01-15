# Lambda Expressions
Lambda expression is, essentially, an anonymous or unnamed method. The lambda expression does not execute on its own. Instead, it is used to implement a method defined by a functional interface.

## How to define lambda expression in Java?

Here is how we can define lambda expression in Java.

```
(parameter list) -> lambda body
```
The new operator (->) used is known as an arrow operator or a lambda operator. The syntax might not be clear at the moment. Let's explore some examples,

double getPiValue() {
return 3.1415;
}

## Types of Lambda Body

### A body with a single expression

```
import java.lang.FunctionalInterface;

// this is functional interface
@FunctionalInterface
interface MyInterface{

    // abstract method
    double getPiValue();
}

public class Main {

    public static void main( String[] args ) {

    // declare a reference to MyInterface
    MyInterface ref;
    
    // lambda expression
    ref = () -> 3.1415;
    
    System.out.println("Value of Pi = " + ref.getPiValue());
    } 
}
```
In the above example,

We have created a functional interface named MyInterface. It contains a single abstract method named getPiValue()
Inside the Main class, we have declared a reference to MyInterface. Note that we can declare a reference of an interface but we cannot instantiate an interface.
We then assigned a lambda expression to the reference.
Finally, we call the method getPiValue() using the reference.

```
import java.lang.FunctionalInterface;

// this is functional interface
@FunctionalInterface
interface MyInterface{

    // abstract method
    double getPiValue();
}

public class Main {

    public static void main( String[] args ) {

    // declare a reference to MyInterface
    MyInterface ref;
    
    // lambda expression
    ref = () -> System.out.println("Lambdas are great");
    
    System.out.println("Value of Pi = " + ref.getPiValue());
    } 
}
```
```
import java.lang.FunctionalInterface;

// this is functional interface
@FunctionalInterface
interface MyInterface{

    // abstract method
    double getPiValue();
}

public class Main {

    public static void main( String[] args ) {

    // declare a reference to MyInterface
    MyInterface ref;
    
    // lambda expression
    ref = () -> 3.1415;
    
    System.out.println("Value of Pi = " + ref.getPiValue());
    } 
}
```
### A body that consists of a block of code.
```
import java.lang.FunctionalInterface;

// this is functional interface
@FunctionalInterface
interface MyInterface{

    // abstract method
    double getPiValue();
}

public class Main {

    public static void main( String[] args ) {

    // declare a reference to MyInterface
    MyInterface ref;
    
    // lambda expression
    ref = () -> {
        double pi = 3.1415;
        return pi;
    };
    
    System.out.println("Value of Pi = " + ref.getPiValue());
    } 
}
```
    
```
@FunctionalInterface
interface MyInterface {

    // abstract method
    String reverse(String n);
}

public class Main {

    public static void main( String[] args ) {

        // declare a reference to MyInterface
        // assign a lambda expression to the reference
        MyInterface ref = (str) -> {

            String result = "";
            for (int i = str.length()-1; i >= 0 ; i--)
            result += str.charAt(i);
            return result;
        };

        // call the method of the interface
        System.out.println("Lambda reversed = " + ref.reverse("Lambda"));
    }

}
```
## Lambda Expression and Stream API

The new java.util.stream package has been added to JDK8, which allows Java developers to perform operations like search, filter, map, reduce, or manipulate collections like Lists.

For example, we have a stream of data (in our case, a List of String) where each string is a combination of the country name and place of the country. Now, we can process this stream of data and retrieve only the places from Nepal.

For this, we can perform bulk operations in the stream by the combination of Stream API and Lambda expression.

```
import java.util.ArrayList;
import java.util.List;

public class StreamMain {

    // create an object of list using ArrayList
    static List<String> places = new ArrayList<>();

    // preparing our data
    public static List getPlaces(){

        // add places and country to the list
        places.add("Nepal, Kathmandu");
        places.add("Nepal, Pokhara");
        places.add("India, Delhi");
        places.add("USA, New York");
        places.add("Africa, Nigeria");

        return places;
    }

    public static void main( String[] args ) {

        List<String> myPlaces = getPlaces();
        System.out.println("Places from Nepal:");
        
        // Filter places from Nepal
        myPlaces.stream()
                .filter((p) -> p.startsWith("Nepal"))
                .map((p) -> p.toUpperCase())
                .sorted()
                .forEach((p) -> System.out.println(p));
    }

}
```

Yes, a lambda expression in Java is an object. However, it does not have a concrete type like a class or interface that you define explicitly. Instead, it is an instance of a functional interface, which is an interface with a single abstract method (SAM).