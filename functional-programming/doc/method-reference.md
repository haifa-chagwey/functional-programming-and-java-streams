### Types of Method References

There are four kinds of method references:

- **Static Method Reference:**   
**Syntax**: ClassName::staticMethod  
**Example**:  
Math::abs (equivalent to x -> Math.abs(x))
Integer::parseInt (equivalent to x -> Integer.parseInt(x))
  
- **Instance Method of a Particular Object:**    
**Syntax**: instance::instanceMethod  
**Example**: 
System.out::println (equivalent to x -> System.out.println(x))
```
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        // Create a specific object
        StringBuilder sb = new StringBuilder("Hello");

        // Reference to an instance method of a specific object
        Function<String, String> reverser = str -> sb.reverse().toString();

        // Apply the function
        String result = reverser.apply("doReverse");

```
```
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        // Create a specific object
        StringBuilder sb = new StringBuilder("Hello");

        // Reference to an instance method of a specific object
        Supplier<String> reverser = sb::reverse;

        // Apply the method reference
        String result = reverser.get();
        System.out.println(result); // Output: olleH
    }
}

```
- **Instance Method of an Arbitrary Object of a Particular Type:**  
**Syntax**: ClassName::instanceMethod  
**Example**: 
String::toUpperCase (equivalent to x -> x.toUpperCase())   
String::length (equivalent to x -> x.length())  

- **Constructor Reference:**  
**Syntax**: ClassName::new  
**Example**: ArrayList::new (equivalent to () -> new ArrayList<>())

### When to Use Method References
Use method references when a lambda expression just calls an existing method.