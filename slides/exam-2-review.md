---
layout: presentation
title: Exam 2 Review
permalink: /slides/exam-2-review/
---

class: center, middle

# Exam 2 Review

Intro to Computer Science

---

# Agenda

1. [ArrayList](#arraylist)
1. [Multidimensional Arrays](#multidimensional-arrays)
1. [Object-Oriented Programming](#oop)
1. [Pillars](#pillars)
1. [Patterns](#patterns)
1. [Strings](#strings)
1. [Inheritance](#inheritance)
1. [This is Super](#this-super)
1. [Conclusions](#conclusions)

---

name: structure

# Structure

--


name: arraylist

# ArrayList

--

## Main themes

- a class in the Java API (i.e. `java.util.ArrayList`)
- behaves similarly to the fundamental primitive array data structure, but has a malleable length and stores only objects
- easy to `add()`, `remove()`, and `get()` objects to/from an `ArrayList`.
- odd syntax, e.g. `ArrayList<Alien> = new ArrayList<Alien>()`, which we won't talk about (called Java "generics")

---

name: multidimensional-arrays

# Multidimensional Arrays

--

## Main themes

- must first understand one-dimensional arrays
- two-dimensional arrays can be visualized as tables with rows and columns
  - first dimension is like the rows
  - second dimension is like the columns
- declaring, allocating, and assigning values
- looping through multi-dimensional arrays
  - the 'standard' way using nested counter-based loops
  - using the **foreach** type of loop (e.g. `for (String[] val : values) { /* ... */ }`)
- ragged arrays exist
- passing arrays as arguments to methods

---

name: #oop

# Object-Oriented Programming

--

## Main themes

Basic object-oriented programming

- Classes are essentially custom data types.
- Classes are reference types in Java.
- Objects are instances of a class.
- Defining a class
- Constructors
- Instance methods and properties
- Static methods and properties
- Instantiating an object


---


name: patterns

# Patterns


## Main themes:

- `private` for instance properties and methods
- getters and setters to provide public access for `private` properties, where desired
- perform validation in setters
- always use those setters, even within the same class file
- overloaded methods and contructors provide multiple variants of the same action
- `static` for shared properties and methods
- `final` for values that never change
- inheritance vs. composition

---

name: strings

# Strings

--

## Main themes:

- `String` is a class in the Java API, not a fundamental primitive data type.
- because different objects are stored at different locations in memory, compare the value of two `String` objects with its custom `.equals()` method, not `==`.
- `String` is designed following the principle of object-oriented abstraction (e.g. `.length()` rather than `.length`)
- Encapsulated within every `String` is a `char` array.

---

name: inheritance

# Inheritance

--

## Main themes:

- Child classes inherit properties and methods of parent classes, except...
  - `private` properties and methods are not inherited...
  - ...but `private` properties are still accessible via any inherited `public` getters and setters
  - constructors are not inherited, but are accessible via the `super` keyword
- use of the `super` keyword to refer to code belonging to the parent class

---

template: inheritance

## Polymorphism

Polymorphism goes hand-in-hand with inheritance.

- child objects can be considered to be of their parent class.
- e.g., if `B` inherits from `A`, then a `B` object can be referred to as both a `B` and an `A` object.
- can be useful when storing objects of a variety of child types into a single array typed as the parent type.
- that allows you to easily loop through them all.
- `instanceof` operator allows you to check whether an object is of a given type.

---

template: inheritance

## Processing

Processing as a case study in inheritance:

- inheritance of many useful properties (e.g. `width`, `height`, `mouseX`, `mouseY`)
- inheritance of many useful methods (e.g. `ellipse()`, `rect()`, `image()`, etc)
- inheritance of behaviors (e.g. `draw()` method magically called every 1/60th second, `mouseX` and `mouseY` automagically assigned the mouse position values)
- abstraction: we don't need to know _how_ it works, just how to use it
- some poor quality design (e.g. we should not be able to directly access `width`, `height`, `mouseX` and `mouseY` - we should be using getters)

---

name: this-super

# This is Super

--

## Main themes:

- the `this` keyword, when used within a method, refers to the object upon which that method was called.
- you cannot use the `this` keyword within a `static` method, since that method can never be called on an object.
- the `super` keyword, when used within a method, refers to code in the parent class.
- a call to the parent class's constructor can be added to a child class constructor, if useful (e.g. `super()` or `super(someArgs)`

---

name: conclusions

# Conclusions

--

- Thanks. Bye.
