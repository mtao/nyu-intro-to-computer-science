---
layout: presentation
title: Interfaces
permalink: /slides/interfaces/
---

class: center, middle

# Interfaces

> As far as the customer is concerned, the interface is the product.
>
> –[Jef Raskin](https://en.wikipedia.org/wiki/Jef_Raskin), initial creator of the Apple Macintosh

---

# Agenda

1. [Overview](#concept)
1. [Raison D'Etre](#raison-detre)
1. [Example](#example)
1. [Differences From Classes](#differences)
1. [Methods With Implementations](#implemented-methods)
1. [Implementing Multiple Interfaces](#multiples)
1. [Polymorphism](#Polymorphism)
1. [Inheritance](#inheritance)
1. [Conclusions](#conclusions)

---

name: overview

# Overview

--

## Concept

An **interface**, like a class, is a Java reference type.

--

```java
public interface Foo {

  /* some stuff here */

}
```

---

template: overview

## Similarity to classes

Like classes, interfaces can contain...

--

- properties

--

- methods

--

```java
public interface Foo {

  // a property
  public int x = 10;

  // a method
  public static void y() {
    System.out.println("Hello!");
  }

}
```

---

template: overview

## False advertising

But all is not as it seems.

--

- Interfaces are intended to _solve a very different problem_ than classes.

--

- Because of their intended use, there are very specific _limitations_ on what kinds of properties and methods can be placed within an interface.

---

name: raison-detre

# Raison d'être

--

## Concept

Interfaces serve as a sort of contract.

--

- An interfaces defines a **public interface** - a set of behaviors - that any class can agree to adhere to.

--

- Java will _not compile_ the code if any class that agreed to adhere to an interface does not properly implement its public interface.

---

template: raison-detre

## Contractual agreement

--

At their core, interfaces specify a set of **method signatures**.

--

- Any class can declare that it _implements_ an interface, meaning it agrees to implement the behaviors the interface specifies.

--

- This contractually _guarantees_ that the class will implement the methods specified in the interface.

--

- Other code can rely on the fact that the class will be able to perform the behaviors the interface specifies.

---

name: example

# Example

--

## A facetious interface

For example, imagine the following interface:

```java
// your mileage may vary
public interface IdealEmployee {
  public abstract void enjoyEatingMealsInCubicle();
  public abstract void rarelyLeaveBuildingOrCampus();
  public abstract void playSillyGamesInOffice();
  public abstract void readilyAcceptAFancyJobTitleInsteadOfIncreasedPay();
}
```

--

Any class can "sign on" to this interface using the **implements** keyword.

--

```java
public class RecentGrad implements IdealEmployee {
  /* some stuff here */
}
```

---

template: example

## Abiding by the contract

Classes that implement an interface _must_ implement the methods declared within the interface. The code won't compile otherwise.

--

```java
public class RecentCollegeGrad implements IdealEmployee {
  public void enjoyEatingMealsInCubicle() {
    // implementation goes here
  }
  public void rarelyLeaveBuildingOrCampus() {
    // implementation goes here
  }
  public void playSillyGamesInOffice() {
    // implementation goes here
  }
  public void readilyAcceptAFancyJobTitleInsteadOfIncreasedPay() {
    // implementation goes here
  }
}
```

--

- The class may contain other properties and methods in addition to those specified in the interface.

---

template: example

## Ensuring consistent behavior across classes

The value of an interface is that it can _ensure the same set of behaviors_ across several different classes.

--

```java
public class OfficePuppy implements IdealEmployee {
  public void enjoyEatingMealsInCubicle() {
    // implementation goes here
  }
  public void rarelyLeaveBuildingOrCampus() {
    // implementation goes here
  }
  public void playSillyGamesInOffice() {
    // implementation goes here
  }
  public void readilyAcceptAFancyJobTitleInsteadOfIncreasedPay() {
    // implementation goes here
  }
}
```

--

- The expectation would be that the implementation of these behaviors is significantly different among the different classes that implement them.

---

name: differences-from-classes

# Differences from classes

--

## Concept

Unlike classes, interfaces are intended to be **abstract** and not include implementation details of the behaviors they specify.

--

- all methods are _abstract_ by default, even if that is not written explicitly into the code.

--

- all properties and methods in an interface are _public_, even if that is not written explicitly into the code.

--

- all properties are furthermore _static and constant_, even if that is not written explicitly into the code.

---

name: implemented-methods

# Methods With Implementations

--

## Default methods

It is possible to include an _instance method with an implementation_ in an interface. This is called a **default** method and serves one specific use case, and no other.

--

- Imagine our example interface is already in use - developers have writen code abiding by its contractual rules.

--

- Now, imagine the creators of the interface decide to add a new abstract method

```java
public abstract void acceptCutsToCompensationWithNoComplaints();
```

--

- If the developers using the old interface upgraded to the new version, their _code would immediately break_ and not compile.

--

- A **default method** solves this problem by including a new method in an interface that includes its own default implementation - a placeholder until the developers can write their own.

---

template: implemented-methods

## Default methods (continued)

For example, version 2 of our interface might add the new method, including a default implementation.

--

--

```java
public interface IdealEmployee {
  // assume all the methods specified in v1 of the interface are still placed here

  // the new method, with a default implementation so existing class code doesn't break
  public default void acceptCutsToCompensationWithNoComplaints() {
    System.out.println("Thank you so much for giving me this opportunity!");
  }

}
```

--

- In this way, developers using `v1` of the interface can upgrade to `v2` with no worry about their code breaking.

---

template: implemented-methods

## Static methods

Interfaces can also contain implementations of static methods.

--

```java
public interface IdealEmployee {
  // assume all the methods previously discussed are still placed here

  // a behavior shared by all IdealEmployee objects
  public static void speakDeferrentially(String message) {
    String protocol = "I'm so sorry to disturb you... I know you're very busy... But";
    String output = String.format("%s %s", protocol, message);
  }

}

```

---

name: multiples

# Implementing Multiple Interfaces

--

## Direct implementation of multiples

Unlike with class-based inheritance, it is possible for a class to implement more than one interface.

--

- Imagine we had a second interface called `IndependentThinker`.

--

- A single class could implement both the `IdealEmployee` and `IndependentThinker` interfaces.

--

```java
public class RecentCollegeGrad implements IdealEmployee, IndependentThinker {

  // all abstract methods from IdealEmployee must be implemented in this class

  // all abstract methods from IndependentThinker must also be implemented in this class

}
```

---

template: multiples

## Indirect implementation of multiples

Interfaces can also inherit from one-another.

--

- For example, let's imagine a simple parent interface:

```java
public interface Thinker {
  public abstract void pauseBeforeRespondingToQuestion();
  public abstract void considerAllPossibleImplications(BigEvent bigEvent);
}
```

--

- And a child interface:

```java
public interface IndependentThinker extends Thinker {
  public abstract void lookAskanceTowardsHorizon();
  public abstract void mumbleToOneself();
}
```

--

- As with class-based inheritance, a child interface inherits all the methods and properties of the parent, including abstract methods.

---

template: multiples

## Indirect implementation of multiples (continued)

A class that implements an interface has to implement any abstract methods in the interface, including those passed down from ancestor interfaces.

--

```java
public class OfficePuppy implements IndependentThinker {

  // must implement all abstract methods from IndependentThinker interface
  public void lookAskanceTowardsHorizon() {
    // implementation goes here
  }
  public void mumbleToOneself() {
    // implementation goes here
  }

  // must also implement all abstract methods from Thinker interface
  public void pauseBeforeRespondingToQuestion() {
    // implementation goes here
  }
  public void considerAllPossibleImplications() {
    // implementation goes here
  }

}
```

---

name: polymorphism

# Polymorphism

--

## Concept

Objects that implement a given interface in Java can polymorphically be considered to be of the interface type.

--

- For example, a `RecentCollegeGrad` object could be referenced by a `IdealEmployee`-typed variable.

--

```java
// instantiate an object and reference with variable of interface type
IdealEmployee pat = new RecentCollegeGrade("Pat", 21, "Computer Science");
```

---

template: polymorphism

## Batch operations

As with all polymorphism, this can be useful for batch operations.

--

- Create an array data structure with a bunch of objects that all implement the interface

```java
IdealEmployee[] employees = {
  new RecentCollegeGrade("Pat", 21, "Computer Science"),
  new OfficePuppy("Fido", "German Shepherd", 4)
};
```

--

- Loop through them and trigger some behaviors they all have in common.

```java
// iterate through each object
for (IdealEmployee emp : employees) {
  emp.acceptCutsToCompensationWithNoComplaints();
}
```

---
## Example problems

* Write a class `DoubleSlider` that satisfies this interface using a double as a member
* Write a class `DiscreteSlider` that satisfies this interface but only accepts a discrete number of values. This method should store an integer `n` for the interface as well as a min value, max value, and step size to store the range and step size for the integer parameter.
    * getValue should be `min + step * n`
    * setValue should round `n`.

```java
public interface Slider {

    public abstract double getValue();
    public abstract void setValue(double value);

}
```
---
## Example problems

* Write a class that stores two sliders to represent the width and depth of a rectangle. By default it should make the depth a `DoubleSlider` and the width as a `DiscreteSlider` with min of 24 units, max of 60 units, step of 6 units.
* It should have setters that let the users change the type of the `Slider`.
* It should also have a second constructor that lets the user set the sliders.
* It should have a members that lets the user set the values of the two sliders
* It should have a function that computes the area of the rectangle.


---
## Example problems

* Write classes that satisfies the following interface:
```java
public interface RangeInterface{
    // Presents the current value in the range
    public abstract int getValue();
    // Increments the range to the next value
    public abstract void increment();
    // Indicates if the range is done
}
```
* `Range` where we iterate through the values larger than `start`, it should be constructed by `Range(int start)`.
* `FibonacciRange` which prints out fibonacci numbers smaller than an integer argument passed in.
* `FactorialRange` which prints out factorial numbers that never finishes.



---
## Example problems

* Write a function that takes in a RangeInterface and prints out the output the values in the range indefinitely
* Write a class `SquareRange` that implements RangeInterface that returns the square of a different RangeInterface object. It is passed this object in its constructor.
* Add a function  `boolean finished()` to the interface to make sure these functions finish.
* Edit the RangeInterface to have a function called `incrementAndCheck` that increments and then returns if the iteration is finished.
    * Rewrite the first function to use this updated interface.
* Update `Range` where we iterate through the values between two integers start and end, it should be constructed by `Range(int start, int end)`.
* Update `FibonacciRange` to stop when the number is over some value.
* Update `SquareRange` to stop when the number is over some value.


---

name: conclusions

# Conclusions

--

As you have seen, interfaces in Java offer an alternative form of inheritance in Java with some similarities - and many differences - with class-based inheritance.

--

- Thank you. Bye.
