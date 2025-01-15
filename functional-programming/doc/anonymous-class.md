# Java Anonymous Class

A nested class that does not have any name is known as an anonymous class.

```
class outerClass {

    // defining anonymous class
    object1 = new Type(parameterList) {
         // body of the anonymous class
    };
}
```
Anonymous classes usually extend subclasses or implement interfaces.  
Here, Type can be
1. a superclass that an anonymous class extends
2. an interface that an anonymous class implements

The above code creates an object, object1, of an anonymous class at runtime.

### Anonymous Class Extending a Class

```
package com.haifachagwey;

class Animal {
    void eat() {
        System.out.println("Animal is eating");
    }
    void sleep() {
        System.out.println("Animal is sleeping");
    }
}

class Cat extends Animal {
    @Override
    void eat() {
        System.out.println("Cat is eating");
    }

    @Override
    void sleep() {
        System.out.println("Cat is sleeping");
    }
}

public class AnonymousClasses {

    public static void main(String[] args) {
        Animal cat = new Cat();
        cat.eat();
        cat.sleep();
    }
}
```
Or we can use an anonymous class to extend the Animal class.
```
package com.haifachagwey;

interface Animal {
    void eat();
    void sleep();
}

public class AnonymousClasses {

    public static void main(String[] args) {
        Animal cat = new Animal() {
            @Override
            public void eat() {
                System.out.println("Cat is eating");
            }

            @Override
            public void sleep() {
                System.out.println("Cat is sleeping");
            }
        };
        cat.eat();
        cat.sleep();
    }
}
```
When we run the program, an object cat of the anonymous class is created. The cat object then calls the display() method of the anonymous class.
### Anonymous Class Implementing an Interface

```
package com.haifachagwey;

interface Animal {
    void eat();
    void sleep();
}

class Cat implements Animal {
    @Override
    public void eat() {
        System.out.println("Cat is eating");
    }

    @Override
    public void sleep() {
        System.out.println("Cat is sleeping");
    }
}

public class AnonymousClasses {
    public static void main(String[] args) {
        Animal cat = new Cat();
        cat.eat();
        cat.sleep();
//        Cat is eating
//        Cat is sleeping
    }
}
```
Or we can use an anonymous class to implement the Animal interface.
```
package com.haifachagwey;

interface Animal {
    void eat();
    void sleep();
}

public class AnonymousClasses {
    public static void main(String[] args) {
        Animal cat = new Animal() {
            @Override
            public void eat() {
                System.out.println("Cat is eating");
            }

            @Override
            public void sleep() {
                System.out.println("Cat is sleeping");
            }
        };
        cat.eat();
        cat.sleep();
//        Cat is eating
//        Cat is sleeping
    }
}

```

### Advantages of Anonymous Classes
Anonymous classes are useful to implement functional interfaces.
In anonymous classes, objects are created whenever they are required. That is, objects are created to perform some specific tasks.

Anonymous classes also help us to make our code concise.
