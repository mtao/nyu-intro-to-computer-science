---
layout: presentation
title: Inheritance & Polymorphism
permalink: /slides/inheritance/
---

class: center, middle

# Inheritance & Polymorphism

> The problem with object-oriented languages is they’ve got all this implicit environment that they carry around with them. You wanted a banana but what you got was a gorilla holding the banana and the entire jungle.
>
> –[Joe Armstrong](https://en.wikipedia.org/wiki/Joe_Armstrong_%28programmer%29), creator of Erlang, a functional programming language

---

# Agenda

1. [Overview](#concept)
1. [Basic Implementation](#implementation)
1. [Multi-Level Inheritance](#multi-level)
1. [Polymorphism](#polymorphism)
1. [Similarity & Difference](#difference)
1. [Inheritance vs. Composition](#composition)
1. [Is Inheritance Evil?](#evils)
1. [Conclusions](#conclusions)

---

name: overview

# Overview

--

## Concept

**Inheritance** is a mechanism for basing one object or a class on another object or class when the two objects or classes include similar implementations of their behaviors.

--

- Properties and methods of one object or class are automatically "passed down" to the objects or classes that inherit from it.

---

template: overview

## Historical tangent

Inheritance was first implemented in Norway in 1969 for [Simula](https://en.wikipedia.org/wiki/Simula), considered the first fully object-oriented programming language. Simula included now-standard, pedestrian, object-oriented features such as:

- Objects

--

- Classes

--

- Constructors

--

- Inheritance

--

- Garbage collection

--

Think about that next time you hear someone say technology develops at lightning-speed rates of innovation.

---

template: overview

## Benefits

The touted benefits of inheritance include:

--

- Code reuse

--

- Less code redundancy

--

- Easier code maintenance

--

- Conceptual clarity

---

name: implementation

# Basic Implementation

--

## Abstract Example

Imagine we had the following class, `A` with just a single property, `message`, and its `getter` and `setter` methods.

```java
public class A {
    // no-args constructor
    public A() {
        System.out.println( "A new A object is born!" );
        this.message = "Hello!";
    }

    // just one property to keep it simple
    private String message;

    // getter + setter methods
    public String getMessage() {
        return this.message;
    }
    public void setMessage(String message) {
        if (msg.length > 0) this.message = message;
    }
}
```

---

template: implementation

## Abstract Example (continued)

Another class, `B`, could inherit the properties and methods of `A` by using the `extends` keyword.

```java
public class B extends A {

}
```

- A `B` object could be instantiated with no further code and it would automatically inherit the public interface defined by `A`.

```java
B bObj = new B();
System.out.println( bObj.getMessage() );
```

- [Try it!](https://repl.it/repls/DemandingSizzlingSpreadsheet)

---

template: implementation

## Abstract Example (continued again)

We often create UML diagrams indicating class relationships, where the arrow points from parent to child.

![Class inheritance UML diagram](../files/oop-inheritance-simple.png)

--

- In almost all cases, the child class would contain its own unique additional properties and methods that make it different in some way from the parent... we have kept class `B` blank just to focus on the inherited properties and methods.

---

template: implementation

## Abstract Example (continued once more)

When this program is run, two lines are output:

```
A new A object is born!
Hello!
```

--

- The first line above, '_A new A object is born!_' is output by the `A` class's constructor function, which our code does not explicitly call.

--

- All classes, including our `B` class, are given a default **no-args constructor** by Java if no other constructor is defined within them.

--

- This no-args constructor automatically calls **super()**.

--

- If we were to write this constructor for `B` ourselves, it would look like:

```java
public B() {
        super();
}
```

--

- The **super** keyword is a reference to the code in the parent class.

---

template: implementation

## Abstract Example (continued the final time)

The second line output above, '_Hello!_', is a result of the call to the `B` object's `getMessage()` method.

--

- This method, like all other **public properties and methods**, is inherited from the parent class, `A`, into the child class, `B`.

--

- **Private properties and methods** are not inherited by a child class, but can be accessed through public getter and setter methods.

---

template: implementation

## Visibility

By definition, the _private_ property, `message`, of the `A` class is not visible from the `B` class.

--

- Yet, the `A` class's getter for that property, `getMessage()`, is public and thus is visible from within the `B` class.

---

name: multi-level

# Multi-Level Inheritance

--

## Concept

We can continue our example by giving `B` its own child, `C`.

--

```java
public class C extends B {

    // a no-args constructor
    public C() {
      super(); // call B's no-args constructor
    }

    // an overloaded constructor that accepts a message
    public C( String message) {
        super(); // call B's no-args constructor
        System.out.println( "A new C object is born!" );
        this.setMessage( message );
    }
}
```

---

template: multi-level

## Concept (continued)

A UML diagram showing multi-class inheritance.

![Multi-class inheritance UML diagram](../files/oop-inheritance-multi.png)

--

- As with `B`, we would normally add some unique public methods to child classes like `C` that make them behave differently from their parent, but we are not doing that here just to focus on the inherited components.

---

template: multi-level

## Analysis

`C` is now a child of `B`, which itself is a child of `A`.

--

- All the **public** properties and methods of `A` are inherited by `B`.

--

- All the **public** properties and methods of `B`, including those inherited from `A`, are inherited by `C`.

--

- Thus, `C` implements the **public interface** of both `A` and `B`.

--

- What would the following code output?

```java
C cObj = new C( "Welcome!!" );
System.out.println( cObj.getMessage() );
```

--

[Try it!](https://repl.it/repls/CraftyRawStrategy)

---

name: polymorphism

# Polymorphism

--

## Concept

An object or class can assume more than one 'shape'.

--

- In our example, a `C` object implements the public interfaces of `C`, `B`, and an `A`.

--

- We could say that our `C` object _is_ a `C` object, as well as a `B` object, and an `A` object.

--

- It's possible to verify this in code using the `instanceof` operator.

```java
if (cObj instanceof C && cObj instanceof B && cObj instanceof A) {
    System.out.println("It's a C, B, and A object all-in-one!");
}
```

---

template: polymorphism

## Application

Polymorphism can be useful when we want to store a bunch of related objects of different-but-related types into an array or other grouping data structure in order to perform some kind of batch operation on them.

--

```java
A[] myObjs = {
    new A(),
    new B(),
    new C("Welcome!!")
};

for (A myObj : myObjs) {
    String message = myObj.getMessage();
    System.out.println(message);
}
```

--

- [Try it!](https://repl.it/repls/PeriodicAliveHypotenuse)

---

template: polymorphism

## Overriding

It is often desireable to have child classes implement the instance methods defined in the parent class somewhat differently.

--

- A child class can define methods with the same signatures as the instance methods in the parent class - this is called **[overriding](https://coderanch.com/wiki/659959/Overriding-Hiding)**.

--

- For example, each of our `A`, `B`, and `C` classes could contain different implementations of the `getMessage()` method.

--

- It is possible for a child class's overridden method to call the parent class's version of that same method.

--

- A child class can call any public method as-defined in its parent class's code by using the keyword **super**, e.g.

```java
super.getMessage();
```

--

- [Try it!](https://repl.it/repls/HiddenJumboObjectcode)

---

name: difference

# Similarity & Difference

--

## Concept

In real applications, child classes almost invariably do something different from their parent classes, whether by overriding some parent methods or implementing their own unique methods that are not present in the parent. This difference gives the child class a reaason to exist.

--

- We'll take a look at the similarity and difference in two simple classes we'll call `A` and `B`.

---

template: difference

## Example classes

The parent class:

```java
public class A {
    public void doSomething() {
        System.out.println("An A object doing something.");
    }
}
```

The child class:

```java
public class B extends A {
    public void doSomethingDifferent() {
        System.out.println("A B object doing something *different*.");
    }
}
```

---

template: difference

## Similarity

Since `B` inherits from `A`, both classes encapsulate `A`'s `doSomething()` method.

--

- `doSomething()` can be called on any `A` object, since it is defined within the `A` class.

```java
A myA = new A();
myA.doSomething();
```

--

- and it can be called on any `B` object, since `B` objects inherit it.

```java
B myB = new B();
myB.doSomething();
```

---

template: difference

## Similarity (continued)

Both `A` and `B` objects can be considered `A` objects, since `B` implements `A`'s public interface. So we can take advantage of **polymorphism** to perform a batch operation on both objects.

--

```java
// instantiate an A and a B object
A myA = new A();
B myB = new B();
```

--

```java
// put them both into an A-typed array
A[] myObjects = { myA, myB };
```

--

```java
// loop through all objects in array
for (A myObj : myObjects) {
    myObj.doSomething(); // works fine, since they both have this method
}
```

--

- [Try it!](https://repl.it/repls/DarkorangeCarefreePreprocessor)

---

template: difference

## Difference

`B` objects, of course, have their own unique `doSomethingDifferent()` method that `A` objects do not have.

--

- In a polymorphic context, we can perform a batch operation on both objects using a loop, as done previously, but also have `B` objects do their own unique behavior, if desired, by using the `instanceof` operator.

--

```java
// loop through all objects in array
for (A myObj : myObjects) {
    myObj.doSomething(); // works fine, since they both have this method from A

    // have any B-type objects do their special behavior...
    if (myObj instanceof B) {
        // first cast to B-type
        B sameObjsAsBType = (B) myObj;
        // now call B-type's unique method
        sameObjsAsBType.doSomethingDifferent();
    }
}
```

--

- [Try it](https://repl.it/repls/GuiltyIcyLeads)

---

name: composition

# Inheritance vs. Composition

--

## In context

The goals of inheritance are to reuse code, reduce redundancy, and provide conceptual clarity in code.

--

- A child class can be based on, and inherit all public properties and methods of, a parent class.

--

- **Composition**, in contrast is the practice of storing an object of one type as a property of an object of another type.

--

- Composition can be useful when the two objects are do not share method implementation code in common, but one of the objects nevertheless benefits from being able to access some methods of the other.

---

template: composition

## Example

For example, when using the **Processing** animation framework, the **PApplet** class contains lots of useful animation-related public properties and methods.

--

- To use that framework, we want one of our classes to inherit those useful functions and thus represent the app window.

```java
public class App extends PApplet { ... }
```

--

- `App` objects now will have `PApplet` behaviors, such as popping open a new animation window, drawing ellipses, detecting mouse clicks and key presses, having its `draw()` method called 60 times per second, etc.

--

- In our animations we may want to have donkeys floating across the screen, so we might create a `Donkey` class to encapsulate all things related to donkeys - their width, height, x position, y position, etc.

```java
public class Donkey { ... }
```

---

template: composition

## Example (continued)

Our `Donkey` objects don't need to pop open windows, draw ellipses, detect mouse clicks, key presses, or do the other things that the `PApplet` class can do. Our `Donkey` class represents donkeys, not app windows.

--

- But our `Donkey` objects will want to make themselves appear within a PApplet window once in a while using just PApplet's `image()` method.

--

- This is a good candidate for composition, not inheritance - the vast majority of the `PApplet` code is unrelated and undesireable to `Donkey`.

--

```java
public class Donkey {
    private App app; // will hold an App object, which is our child class of PApplet

    public Donkey(App app) {
        this.app = app; //store the App object composed within this Donkey
    }

    public void drawMeToScreen() {
        this.app.image( ... ); // use the App object's image method to draw to screen
    }
    // ...

```

---

template: composition

## Example (continued again)

The App class can instantiate a Donkey object and pass itself to its constructor for the Donkey to hold a reference to.

```java
public class App extends PApplet {

    private Donkey myDonkey; // will hold a Donkey object

    public void setup() {
        // pass this App object as an argument to the Donkey constructor
        this.myDonkey = new Donkey(this); // the Donkey will now have a reference to the App object
    }

    public void draw() {
        // the donkey can now draw itself to the screen
        this.myDonkey.drawMeToScreen();
    }
}
```

--

- We would normally use a `setter` to set the value of the `myDonkey` property, but have simplified this code in order to focus on the conceptual point.

---

name: evils

# Criticisms of Inheritance

--

## Concept

There are certainly those who criticise object-oriented progrmaming, and some specifically who disapprove of Java's inheritance model.

--

- The main criticism rests upon Java's inability to handle inheritance from multiple classes.

--

- This inability can lead to convoluted and undesireable code.

---

template: evils

## Example scenario

Take, for example, the ["Diamond-problem" scenario](https://medium.com/@cscalfani/goodbye-object-oriented-programming-a59cda4c0e53).

--

- Imagine an `ElectronicDevice` class that has some behaviors that all electronic devices have, such as powering on and off.

--

- Next, imagine a `Scanner` class - a document scanner is an electronic device, so it makes sense to inherit the code from `ElectronicDevice` class.

--

- Next, imagine a `Printer` class - a document printer is also an electronic device, so it makes sense also to inherit the code from `ElectronicDevice` class.

---

template: evils

## Example scenario (continued)

The following UML diagram shows our classes so far, with some example properties and methods.

![Evil inheritance setup](../files/oop-inheritance-evil-setup.png)

---

template: evils

## Example scenario (continued again)

So far so good. But what if we added a `Copier` to the mix?

--

- A `Copier` has behaviors of both a `Scanner` and a `Printer`. Ideally, it would inherit the public interfaces of both.

![Evil inheritance problem](../files/oop-inheritance-evil-problem.png)

---

template: evils

## The problem

In Java, and many other languages, inheritance from multiple classes is impossible.

--

- The only working solution would be to use **composition** rather than inheritance.

--

```java
public class Copier {
    private Scanner scanner;
    private Printer printer;

    public Copier(Scanner scanner, Printer printer) {
        this.scanner = scanner;
        this.printer = printer;
    }
}
```

--

- Why this limitation?

--

- Because what if `Scanner` and `Printer` had a method by the same name, let's say `start()`. Which version would `Copier` inherit?

---


## Example problems

Declare a class called `Product` that has a name, brand, and price.
* Write members
* Write getters/setters.
* Write a constructor

Declare a class called `Bag` that is a `Product` that also stores its volume in liters.
* Write members
* Write Write getters/setters
* Write a constructor that fills all members in

Declare a class called `Umbrella` that is a `Product` that also stores its diameter.
* Write members
* Write Write getters/setters
* Write a constructor that fills all members in
---


## Example problems

Declare a class called `ProductInventory` that has stores a dynamic array of products
* Write members
* Write a constructor that initializes all members
* Write addProduct that adds a product to the inventory
* Write addBag that adds a bag to the inventory by taking in all parameters of a bag
* Write addUmbrella that adds an umbrella to inventory by taking all parameters of the inventory
* Write getProduct that takes in the name of the product and returns it.

---


name: conclusions

# Conclusions

--

You have now extended your understanding of object-oriented programming to include class-based inheritance and polymorphism.

--

- Thank you. Bye.
