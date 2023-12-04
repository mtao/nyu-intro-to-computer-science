---
layout: presentation
title: Abstract Classes
permalink: /slides/abstract-classes/
---

class: center, middle

# Abstract Classes

> Abstraction can provide stumbling blocks for people of strange intelligence.
>
> –[Gustave Flaubert](https://en.wikipedia.org/wiki/Gustave_Flaubert), in his unfinished satirical work, Bouvard et Pécuchet

---

# Agenda

1. [Overview](#concept)
1. [Cannot Instantiate](#no-instantiate)
1. [Pick Your Abstraction](#picking)
1. [Mixing Abstractions](#mixing)
1. [Conclusions](#conclusions)

---

name: overview

# Overview

--

## Concept

An **abstract class** is a Java class that has been _declared as abstract_.

--

```java
public abstract class Foo {

  /* some stuff here */

}
```

---

template: overview

## Similarity to concrete classes

Code-wise, an abstract class can encapsulate _all the same properties and methods as a concrete class_.

--

- private, protected, or public properties and methods

--

- static or non-static properties and methods

--

- constants and non-constants

--

- etc.

---

template: overview

## Difference from concrete classes

The only two differences between an abstract class and a concrete class are...

--

- abstract classes _can contain abstract methods_ - i.e. method signatures without their corresponding implementation.

--

```java
public abstract class Foo {

  public abstract int getRandom(int lowerBound, int upperBound);

}
```

--

- abstract classes _can never be instantiated_

--

```java
Foo f = new Foo(); // a good view of a compilation error!
```

---

template: overview

## Legacy

Since abstract classes can contain abstract methods and because an abstract class cannot be instantiated...

--

- any non-abstract child class _must implement any abstract methods_ declared in an abstract parent or other ancestor class.

--

```java
public abstract class Foo {

  // an abstract method, for example
  public abstract int getRandom(int lowerBound, int upperBound);

}
```

--

```java
public class Bar extends Foo {

  // this class *must* contain a concrete implementation of the abstract method
  public int getRandom(int lowerBound, int upperBound) {
    return rand = ( (int) Math.random() * (upperBound - lowerBound) ) + lowerBound;
  }

}
```

---

template: overview

## Frequently asked questions

There are three questions that commonly arise in relation to abstract classes:

--

1. Why can you not instantiate an abstract class?

--

1. When would you use an abstract class over an interface, and vice-versa?

---

name: no-instantiate

# Cannot Instantiate

--

## Justification

An abstract class cannot be instantiated because any object made from it would potentially be missing the implementation of one or more methods.

--

- For example, given the following abstract class...

```java
public abstract class Foo {

  // an abstract method, for example
  public abstract int getRandom(int lowerBound, int upperBound);

}
```

--

- Imagine instantiating and calling this method... what would happen?

```java
Foo f = new Foo();
int num = f.getRandom(1, 10); // not allowed - this method has no concrete implementation!
```

---

name: picking

# Picking an Abstraction

--

## Deciding between abstract classes and interfaces

Given both abstract classes and interfaces have the ability to encapsulate abstract methods, _how do you pick between the two_?

--

- It's easy:

--

- Interfaces are used to enforce a common set of behavioral capabilities on otherwise-disparate classes with very little code in common.

--

- Abstract classes are used to enforce a common set of behavioral capabilities on classes that share a significant amount of code in common.

---

template: picking

## Deciding between abstract and concrete classes

Given that abstract classes can share all the same sorts of code as a concrete class, and more, _how do you pick between the two_?

--

- It's easy:

--

- Use an abstract class if it makes no conceptual sense for the class to ever be instantiated.

--

- Use a concrete class if it does make sense.

--

- For example, dogs and cats share a lot of internals in common - they are both mammals. Imagine writing code representing them... you might create a Mammal class that encapsulates what Dog and Cat have in common and have Mammal be inherited by each.

--

- Would it make sense to be able to instantiate a Mammal object? Or might it be better to create an abstract Mammal class that contains a lot of code shared in common by two concrete child classes, Dog and Cat.

---

name: mixing

# Mixing Abstractions

--

## Choices

When dealing with inheritance, polymorphism, interfaces, and abstract classes, we often study them in isolation. However, in reality, a single class might take advantage of all of these.

--

Imagine, for example, the following scenarios:

--

- a single class can use class-based inheritance (whether from an abstract class or a concrete class) as well as implement an interface

--

- a single class might implement multiple interfaces

--

- a single class might implement an interface that inherits from another interface

--

- a single class might inherit from an abstract class that implements multiple interfaces

---

name: conclusions

# Conclusions

--

Abstract classes can be useful, when implemented with tact. You now have an understanding of the various ways in which this might be the case.

--

- Thank you. Bye.
