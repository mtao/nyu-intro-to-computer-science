---
layout: presentation
title: Object Orientation
permalink: /slides/object-orientation/
---

class: center, middle

# Object-Oriented Programming

> Object-oriented programming is an exceptionally bad idea which could only have originated in California.
>
> –[Edsger Dijkstra](https://www.quora.com/Why-did-Dijkstra-say-that-%E2%80%9CObject-oriented-programming-is-an-exceptionally-bad-idea-which-could-only-have-originated-in-California-%E2%80%9D)

---

# Agenda

1. [Overview](#concept)
1. [Black Box](#black-box)
1. [Files](#example-1)
1. [Dogs](#example-2)
1. [Creating Difference](#difference)
1. [Controlling Belongingness](#belongingness)
1. [Comparing Sameness](#comparisons)
1. [Stringification](#stringification)
1. [The 4 Pillars of Object-Orientation](#pillars)
1. [Alternative Paradigms](#alternative-paradigms)
1. [Conclusions](#conclusions)

---

name: overview

# Overview

---

template: overview
name: overview-1

## Concept

Object-Oriented Programming (OOP), first experimented with in the 1950's, is today the standard programming paradigm. Nearly all major contemporary programming languages offer the ability to program with objects.

--

- code is written to represent virtual _things_.

--

- each thing has certain **properties** (i.e. variables) that belong to it.

--

- each thing has certain **actions** (i.e. methods) that it can perform.

---

template: overview
name: overview-2

## Concept (continued)

With object-oriented programming, a developer writes a _description_ of things of a certain type.

--

- This acts as a fixed plan or _concept_ for things of this type - a **class**.

--

- Things are then created that _embody_ the abstract concept - **objects**.

---

template: overview
name: concept-digression

## Digression

In the 5th century, B.C., the astonishingly brilliant philsopher, Plato, described what we now call the [Theory of Forms](https://philosophynow.org/issues/90/Plato_A_Theory_of_Forms).

--

- In this theory, **forms** are the non-physical essences of all things, of which **objects** in the physical world are merely imitations or stand-ins.

--

- Things, transient as they are, are not as **real** or true as the eternal concepts or blueprints from whence they come.

--

- So, for example, any given **tree** is not as real as the concept of Tree.

--

- But we cannot **encounter** forms directly, only through the objects that embody them, however imperfectly.

--

- It took us only 2.5 thousand years to begin to code in that direction.

---

template: overview
name: overview-2

## Understand this: it's imperative!

Object-oriented programming is a variety of **imperative programming**.

--

- With imperative programming, we instruct the computer **how** to solve the tasks.

--

- Programs make heavy use of memory and **control flow**: loops, conditional statements with branching, and so on, to establish the sequence of steps necessary to solve the problem.

--

- An alternative to imperative programming would be **declarative programming**, where a desired end goal is declared, but the implementation details of how to achieve it are not. **SQL** is an example of a declarative language.

---

name: black-box

# Black Box Metaphor

---

template: black-box
name: black-box-1

## Smoke and mirrors

Despite being a form of imperative-style programming, specifying in detail how problems are to be solved, object-orientation nevertheless attempts to put to practice the [black box metaphor](https://en.wikipedia.org/wiki/Black_box) of engineering, where, provided particular inputs, a machine produces a predictable output and _the user of it doesn't have to know the implementation details_, even though they are written in the code.

![Black box metapahor](../files/oop-black-box-metaphor.png)

---

template: black-box
name: black-box-2

## Digression

The black box approach transcends any one discipline. For example, it was popular in the [Behaviorist school of psychology](https://en.wikipedia.org/wiki/Behaviorism), which held that human psychology could be defined by the empirically observed responses to given stimuli, regardless of the internal psychological thought patterns internal to the person.

--

- It modeled humans as input-output machines.... black boxes where it was not necessary to understand the internal psychology of the person.

--

- A pioneer of this movement was [B.F. Skinner](https://en.wikipedia.org/wiki/B._F._Skinner), who purportedly raised his own children in literal black boxes!

---

template: black-box
name: black-box-2c

## Digression (continued)

The "Skinner Box":

![Skinner box](../files/oop-skinner-box.jpg)

---

name: example-1

# Example 1 - Files

---

template: example-1
name: example-1a

## Concept

Imagine you wanted to write code that represented **files** on a computer's hard drive.

---

template: example-1
name: example-1b

## Properties

Every file on the hard drive might have some properties, e.g.

- the data stored within the file
- metadata: filename, size, date modified, etc.

--

The values these properties hold collectively represent the _internal state_ of any given file at any given moment in time.

---

template: example-1
name: example-1c

## Actions...

If we say a file is in control of its own destiny (a big if), we could say a file has a few actions it could take, e.g.:

- update the data it holds
- change its filename
- save itself to a particular location on the hard drive

---

template: example-1
name: example-1d

## ... and their consequences

These actions represent a _public interface_ through which other code can interact with any given file and instruct it what actions to take.

--

```java
// telling the thing what to do...
myFile.setFilename("foobar.txt");
myFile.storeData(someData);
```

--

Calling these methods automatically updates the internal state of the _thing_.

--

```java
// ...causes an internal update of its state - i.e. the values of the properties
filename = "foobar.txt";
data = someData;
```

---

template: example-1
name: example-1d

## UML class diagram

There is a standardized way of representing such _things_, called the Unified Modeling Language (UML). Here is an example of a UML '**class**' diagram:

![UML file example](../files/oop-uml-file-example.png)

---

template: example-1
name: example-1e

## Class definition

This diagram can be translated into code as such:

```java
public class File {
    // properties
    private byte[] data;
    private String filename;
    private int size;
    private int modifiedDate;

    // actions
    public byte[] getData() { ... };
    public void setData(byte[] data) { ... };
    public String getFilename() { ... };
    public void setFilename(String filename) { ... };
    public void saveTo(String filePath) { ... };
}
```

---

template: example-1
name: example-1f

## Intention

A **class** definition is a template from which as many **objects** can be made as we like.

--

- Each specific File object has its own copy of the properties and methods defined in the File class - these are termed **instance properties ** and **instance methods**.

--

- Each specific File object can have its own specific set of values for the properties defined in the class.

--

- Each specific File object will respond to calls to it using any of the methods defined in the class.

--

- The internal state of each object is hidden by making the properties private. Code written inside other class definitions cannot see them.

---

name: example-2

# Example 2 - Dogs

---

template: example-2
name: example-2a

## Concept

Imagine **dog**, the concept.

---

template: example-2
name: example-2b

## Properties

Every dog might have some properties, e.g.

- name
- age
- breed
- weight

--

Different dogs will probably have different values for each of these properties.

--

- The value of each dog's properties at any given moment in time repesents that dog's **internal state**.

---

template: example-2
name: example-2c

## Actions...

If we say a dog is in control of its own destiny (a big if), we could say a dog has a few actions it could take, e.g.:

--

- bark

--

- fetch

--

- sleep

---

template: example-2
name: example-2d

## ... and their complications

Two dogs with different internal states might implement these same actions differently.

--

- For example, a lightweight lap dog might have a rapid fire tinny yapping sort of bark, whereas a heavy shepherd might occasionally produce a mellow deep woof sound.

--

- A young dog might generally successfully fetch an object, while an elderly dog might generally fail at this.

--

- A breed known for its abilities as a guard dog might bark more often and more fiercely than others.

---

template: example-2
name: example-2g

## UML class diagram

A UML class diagram for this dog thing:

![UML dog example](../files/oop-uml-dog-example.png)

---

template: example-2
name: example-2h

## Class definition

This diagram can be translated into code as such:

```java
public class Dog {
    // properties
    private String name;
    private int age;
    private String breed;
    private int weight;

    // actions
    public void bark() { ... };
    public void fetch() { ... };
    public void sleep() { ... };
}
```

---

template: example-2
name: example-2i

## Intention

This Dog **class** definition is a template from which as many Dog **objects** can be made as we like.

---

template: example-2i
name: example-2j

- Each specific Dog object has its own specific values for each of the properties the class defines.

---

template: example-2j
name: example-2k

- Each specific Dog object will respond to calls to any of the methods that the File class defines.

---

template: example-2k
name: example-2l

- The actions produced by these method calls may differ slightly, depending upon the internal state of each Dog object

---

name: difference

# Difference

---

template: difference
name: difference-1

## Constructing different objects from the same class

Our intention in creating a class is to be able to instantiate multiple distinct objects from that class template.

---

template: difference-1
name: difference-2

- We typically want these objects to have some differences from one-another.

---

template: difference
name: difference-2

## No difference

The following code, _placed in the code of some other class definition_, would instantiate two Dog objects from our Dog class.

```java
Dog dog1 = new Dog();
Dog dog2 = new Dog();
```

---

template: difference-2
name: difference-2a

These are different _things_ in memory. [See for yourself.](https://repl.it/repls/QuizzicalBubblyChapter)

```java
(dog1 == dog2) // false... they are different references
```

--

But they do not have any difference in terms of their _internal states_.

--

- `String name` -> `null` by default
- `int age` -> `0` by default
- `String breed` -> `null` by default
- `int weight` -> `0` by default

---

template: difference
name: difference-3

## Difference!

If the internal properties of each Dog object were **public** or **protected** (which they are not), it might be possible to give each object distinct values:

--

```java
Dog dog1 = new Dog();
// the following won't work, since the Dog's properties are all private
dog1.name = "Fido";
dog1.breed = "Bugle";
dog1.age = 10;

Dog dog2 = new Dog();
// the following won't work, since the Dog's properties are all private
dog2.name = "Tobik";
dog2.breed = "German Shepherd";
dog2.age = 3;
```

--

But this requires us to make visible the internal properties of the object, which goes against the black box metaphor and imperative-style programming.

---

template: difference
name: difference-3

## Difference! (continued)

If we were able to set each Dog's name, breed, and age to different internal states, while retaining hidden internal properties for each object, then we would achieve our goal.

--

We would like to be able to do something like this:

```java
Dog dog1 = new Dog("Fido", "Bugle", 10);
Dog dog2 = new Dog("Tobik", "German Shepherd", 3);
```

--

At the moment, our class definition provides no mechanism for setting a given object's internal properties.

---

template: difference
name: difference-4

## Constructors

In order to be able to set each object's properties discretely, we need to modify the Dog class to have a special **constructor** function.

--

```java
public class Dog {

    // a constructor function!
    public Dog(String name, String breed, int age) {
        // set this object's internal properties
        this.name = name;
        this.breed = breed;
        this.age = age;
    }

    // properties
    private String name;
    private int age;
    private String breed;
    // and so on...
//...
```

---

template: difference
name: difference-5

## Constructors (continued)

Note that constructor functions do not specify a return type.

```java
public class Dog {
    //...
    public Dog(String name, String breed, int age) {
        //...
    }
    //...
}
```

---

template: difference
name: this

## This, not that

The `this` keyword is used to indicate which object we are talking about it.

--

- Since a single class is a blueprint that can be used to create many objects, Java needs to know which object we are referring to.

--

- So `this` always automatically refers to the object upon whom the current method is being called.

Imagine we defined the `Dog` class's bark method:

```java
public class Dog {
    //...
    public void bark() {
        System.out.printf( "%s says, 'Woof!' ", this.name );
    }
    //...
```

--

- Which dog's name will be output when this method is called?

---

template: difference

## This, not that (continued)

The answer is, "whichever dog the method is called upon".

--

If somewhere we call that method on a dog named Fido, then Fido's name will be output.

```java
Dog dog1 = new Dog("Fido", "Bugle", 10);

//...

dog1.bark(); // outputs "Fido says, 'Woof!' "
```

--

Whereas, if we were to call that method on a dog named Tobik, then Tobik's name would be output.

```java
Dog dog2 = new Dog("Tobik", "German Shepherd", 3);

//...

dog2.bark(); // outputs "Tobik says, 'Woof!' "
```

---

template: difference
name: difference-5

## Instantiating objects

With constructor functions, we can instantiate as many objects as we like with whatever property values we want them to have.

--

```java
Dog dog1 = new Dog("Fido", "Bugle", 10);
Dog dog2 = new Dog("Tobik", "German Shepherd", 3);
```

[Try it](https://repl.it/repls/AcidicOrangeredProcess)

---

template: difference
name: difference-6

## Instantiating objects (continued)

We could make 101 Dalmatians with random names and ages, if we wanted...

```java
// let's make a random mix of names and ages objects
String[] names = "Patch,Lucky,Cadpig,Roly Poly,Penny,Freckles,Pepper".split(",");
int[] ages = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14 };

Dog[] dogs = new Dog[101]; // will hold 101 Dalmatians

for (int i=0; i<dogs.length; i++) {
    // assign each dog random property values from these arrays
    String randomName = names[ (int) (Math.random() * names.length) ];
    int randomAge = ages[ (int) (Math.random() * ages.length) ];

    dogs[i] = new Dog( randomName, "Dalmatian", randomAge ); // instantiate a Dog object

    dogs[i].bark(); // make each dog bark

}
```

[Try it!](https://repl.it/repls/ExtraneousAdolescentConnection)

---

template: difference
name: difference-7

## Changing internal state

Constructors allow us to set up an object's internal state at the moment of its creation. But what if we wanted to update those values at some later date?

--

- For example, what if one of the 101 Dalmatians has a [happy] birthday and is now a year older... can we not update the age property?

--

- In other words, we would like to be able to do something like this:

```java
// instantiate an object with an initial internal statee
Dog dog1 = new Dog("Fido", "Bugle", 10);

// do some very important significant stuff...

// update the object's internal state at some later point
dog1.age = dog1.age + 1; // happy birthday!

```

--

By now, you know that this is not possible. The internal properties are **private** and cannot be accessed from 'user' code in a different class.

---

template: difference
name: difference-8

## Setters

To change an object's internal state, we need a '**setter**' function to allow us to set the value of an existing object.

--

```java
public class Dog {
    // ...etc etc

    // a setter function
    public void setAge(int age) {
        // first validate the value, and then use it if good
        if (age > 0 && this.age < 15) this.age = age;
    }

    // ...and so on and so forth
// ...
```

--

- Note that the setter method performs **validation** - it only allows good values to be placed into the property - this is typical of setters.

--

- Note also that the method is _public_, so it can be called from code outside the `Dog` class.

---

template: difference
name: difference-9

## Setters (continued)

With setters, it is possible to set the values of properties on existing objects.

--

Assuming we have created a Dog object...

```java
Dog dog1 = new Dog("Roly Poly", "Dalmatian", 10); // instantiate a dog
```

--

...we can now update its age using the setter

```java
dog1.setAge(11);
```

---

template: difference

## Setters (continued again)

If setters are present, they should _always_ be used whenever an object's property values need to be changed.

--

- if a **constructor** sets an object's initial starting property values, it should do so by calling the object's setters.

--

- if **any other method** adjusts an object's property values, it should do so by calling the object's setters.

--

- this guarantees that any **validation** performed within the setter function is always used, and this validation logic is written in only one place in the code - in the setter.

---

template: difference
name: difference-9

## Accessing internal state

What if you wanted to know a particular Dog's age... how could you find that out programmatically?

--

- For example, instead of hard-coding `11` in the statement `dog1.setAge(11);`, could we have programmatically determined `dog1`'s current age and simply added one to that?

--

- We certainly cannot do the following, since the age property is _private_ and cannot be read from code outside the `Dog` class:

```java
dog1.setAge ( dog1.age + 1 )
```

---

template: difference
name: difference-10

## Getters

Of course, we can allow access to an object's internal state. But we need to create '**getter**' functions to do so.

--

```java
public class Dog {
    // ...etc etc

    // a getter function
    public int getAge() {
        // simply return the value of the age property
        return this.age;
    }

    // ...and so on and so forth
// ...
```

--

- Note that this function simply returns the value of a private property of the object. It may seem a bit redundant, but this is typical of getters.

--

- Note also that the method is _public_, so it can be called from code outside the `Dog` class.

---

template: difference
name: difference-11

## Getters (continued)

With a getter function, we can read the current value of a property of an object...

--

```java
System.out.println ( dog1.getAge() ); // will output dog1's age
```

--

... and use that information to help us understand that object's internal state

```java
dog1.setAge( dog1.getAge() + 1 );
```

--

Knowledge of an object's internal state can help us make decisions

```java
if ( dog1.getBreed().equals("Dalmation") && dog1.getName().equals("Pepper") ) {
    // use your imagination
}
```

---

name: belongingness

# Controlling Belongingness

--

## Non-static properties and methods

Neither _setters_ nor _getters_, nor even the methods that represent actions of the object (e.g. _bark_, _fetch_, _sleep_) were declared with the keyword `static` in their method signatures. Neither were any of the properties (e.g. _name_, _breed_, _age_).

--

- The keyword, `static`, is used to indicate that a method or property _belongs to the class as a whole_, not to each particular object independently.

--

- Thus, properties and methods that we want to _belong to each object individually_ do not use the `static` keyword.

--

- Each dog has its own _name_, _breed_, _age_, and each dog does its own _barking_, _fetching_, and _sleeping_. So it makes sense that these properties and methods would not be static.

--

- Making such properties and methods static would indicate that all dogs share them - _one name for all_, _one breed for all_, _one age for all_, all _fetching as one_, _sleeping as one_, _eating as one_, etc.

---

template: belongingness

## Shared concerns

There are, of course, cases where it makes sense for a property or method to belong to the class as a whole... i.e. for it to be declared as `static`.

--

- For example, imagine that you wanted to keep track of how many dog objects had been instantiated from the Dog class.

--

- You could create a `static` property named `numDogs` that is incremented each time a Dog is instantiated.

---

template: belongingness

## Shared concerns (continued)

```java
public class Dog {
    //...
    public Dog(String name, String breed, int age) {
        //...
        Dog.numDogs++; // increment the static property
        //...
    }
    //...
    private static int numDogs = 0;

//...
```

--

- Note that we refer to the property as `Dog.numDogs`, rather than `this.numDogs`.

--

- `this.numDogs` would suggest that the `numDogs` property belongs only to the Dog being instantiated, which is not correct - an error!

--

- `Dog.numDogs` clearly communicates that the `numDogs` property belongs to the `Dog` class as a whole - correct!

---

template: belongingness

## Shared concerns (continued again)

Every time we instantiate a new `Dog` object, the counter will be incremented.

```java
Dog dog1 = new Dog("Fido", "Bugle", 10);
Dog dog2 = new Dog("Tobik", "German Shepherd", 3);
```

--

- Because the counter was declared as `private`, we cannot see how many dogs have been made from code outside the `Dog` class.

--

- if were to make a `public` _getter_ method for the `numDogs` property defined within the `Dog` class, we would be able to call it from outside the `Dog` class to find out how many dogs had been made.

--

```java
System.out.printf( "There exist %d dogs in our world.\n", Dog.getNumDogs() );
```

[Try it!](https://repl.it/repls/FirsthandUnlawfulPaint)

---

name: comparisons

# Comparing Sameness

--

## Different kinds of difference

There are a few ways we can compare two objects.

--

- by whether they are, in fact, the same object in memory

--

- by whether their internal states are the same or similar

---

template: comparisons

## Identity comparison

To check whether two supposedly-separate objects are, in fact, the same object, use the `==` operator.

--

```java
if (dog1 == dog2) {
    System.out.printf("%s is actually the same dog as %s!\n", dog1.getName(), dog2.getName);
}
```

--

- Objects in Java are **reference types**, meaning that a variable assigned to point to an object holds the memory address of that object.

--

- The `==` operator, when used with a reference type, thus compares memory addresses.

---

template: comparisons

## Objects as reference types

Because objects are reference types, when they are passed as arguments to a method, the memory address is what is passed.

--

- For example, imagine a method that changes any dog's name to "Dog"...

```java
public void rename(Dog d) {
        d.setName("Dog");
}
```

--

- ... and let's say we call that method from some other method.

```java
Dog dog1 = new Dog("Fido", "Bugle", 10);
rename(dog1);
System.out.println ( dog1.getName() )
```

--

- The dog object referred to within the `rename` method as `d` is the same dog object referred to by the calling method as `dog1` - they are **aliases**.

--

- So the printed output will be "Dog", not "Fido".

---

template: comparisons

## Internal state comparison

To check whether two objects share the same internal state, even if they are different objects in memory, we have to roll our own solution.

--

- Conventionally, this would be done by defining a method named `equals` that performs the comparison.

--

name: tedium

```java
public class Dog {
        //...

        public boolean equals(Object that) {
            return that instanceof Dog && equals((Dog) that);
        }

        public boolean equals(Dog that) {
            boolean sameName = this.name.equals( that.getName() ); // are the names the same?
            boolean sameAge = ( this.age == that.getAge() ); // same age?
            boolean sameBreed = ( this.breed.equals( that.getBreed() ) );
            boolean sameWeight = ( this.weight == that.getWeight() );
            return sameName && sameAge && sameBreed && sameWeight; // true if all the same, false otherwise
        }
        //...
```

---

template: comparisons

## Internal state comparison (continued)

To compare two dogs, you would use one of those dogs' `equals()` method.

```java
if ( dog1.equals(dog2) ) {
    System.out.printf("%s and %s have the same internal state!\n", dog1.getName(), dog2.getName);
}
```

---

template: comparisons

## EqualsBuilder

Since object's properties are often of many different types, writing a custom [].equals()](#tedium) method must be done carefully and tediously. Fortunately, [Apache Commons Lang](https://commons.apache.org/proper/commons-lang/)'s `EqualsBuilder` class can make object comparisons easier and less prone to silly errors.

```java
public class Dog {
        //...
        public boolean equals(Object that) {
            return that instanceof Dog && equals((Dog) that);
        }

        public boolean equals(Dog that) {
            return new EqualsBuilder()
                            .append(this.name, that.name)
                            .append(this.age, that.age)
                            .append(this.breed, that.breed)
                            .append(this.weight, that.weight)
                            .isEquals();
        }
        //...
```

---

template: comparisons

## EqualsBuilder

- To use `EqualsBuilder`, Commons Lang's main `.jar` file must be downloaded and added as a project dependency, for example by placing it within a project's `lib` directory.
- The library must then be imported with `import org.apache.commons.lang3.SystemUtils;`.

---

name: stringification

# Stringification

--

## Concept

Converting an object to a String usually leads to unwanted text.

--

```java
// instantiate a Dog object
Dog dog2 = new Dog("Tobik", "German Shepherd", 3);

// do something that requires the object to be converted to a String
String text = String.format("The dog as a string looks like: %s", dog2);

// see what you get...
System.out.println(text);
```

--

By default, the output would show the **class** name of the object and a **[hashcode](https://coderanch.com/t/321515/java/HashCode)** - random-looking text that is not probably what you hoped for.
[Try it!](https://repl.it/repls/MysteriousNormalLoaderprogram)

```
The dog as a string looks like: Dog@63961c42
```

--

Wouldn't it be nice if we could instead output something descriptive, like,

```
The dog as a string looks like: Tobik, a 3-year-old German Shepherd
```

---

template: stringification

## Fulfilling our desires

Java allows an object to describe how it should be converted to a String with a special method named `toString()` that returns the String equivalent of the object.

--

```java
public class Dog {
    //...
    public String toString() {
        String myself = String.format( "%s, a %d-year-old %s", this.getName(), this.getAge(), this.getBreed() );
        return myself;
    }
    //...
}
```

--

Now, converting the object to a String will result in something more descriptive, such as:

```
Tobik, a 3-year-old German Shepherd
```

[Try it!](https://repl.it/repls/UnusualDistantPostscript)

---

name: pillars

# The 4 Pillars of Object-Orientation

--

## Concept

No university course would pass the censors unless it mentioned at least one set of immutable laws students must memorize despite their better judgment.

--

- Our course is no different. So here they are.

--

The **four pillars of object-oriented programming**:

--

1. Abstraction

--

2. Encapsulation

--

3. Inheritance

--

4. Polymorphism

---

template: pillars

## Abstraction

> abstract (adjective): disassociated from any specific instance
>
> -[Mirriam-Webster](https://www.merriam-webster.com/dictionary/abstract)

--

Abstraction is thus the _process of making something abstract_ or _the state of being abstracted_.

--

- The **black box metaphor** encourages abstraction.

--

- **Hiding implementation details** of code encourages abstration

--

- **Classes** are abstractions of the objects that are instantiated from them.

--

- **Static properties and methods** are abstractions, as they are not tied to any instance.

---

template: pillars

## Encapsulation

> encapsulate (verb): to enclose in or as if in a capsule
>
> -[Mirriam-Webster](https://www.merriam-webster.com/dictionary/encapsulate)

--

Encapsulation is thus the _process of enclosing some things within other things_.

--

- **Instance properties and methods** are encapsulated within the objects to which they belong.

--

- **Static properties and methods** are encapsulated within the class to which they belong.

--

- **Classes** are encapsulated within the packages to which they belong.

--

- **Packages** may be encapsulated within parent packages.

---

template: pillars

## Inheritance

> inherit (verb): to receive from an ancestor
>
> -[Mirriam-Webster](https://www.merriam-webster.com/dictionary/inherit)

--

Inheritance is thus _that which is inherited from an ancestor_.

--

- **Classes**, and the objects instantiated from them, can inherit properties and methods from ancestor classes (we have not discussed this yet).

--

- **Classes**, and the objects instantiated from them, can inherit properties and methods from ancestor interfaces (we have not discussed this yet).

---

template: pillars

## Polymorphism

> polymorphism (noun): the quality or state of existing in or assuming different forms
>
> -[Mirriam-Webster](https://www.merriam-webster.com/dictionary/polymorphism)

--

- **Objects** can be instances of more than one class (we have not discussed this yet).

--

--

- **Objects** can also be instances of one or more interfaces (we have not discussed this yet).

---

name: alternative-paradigms

# Alternative Paradigms

--

## Free choice

There is currently no major threat to object-oriented programming, since it is so widespread. However, other programming paradigms do exist:

--

- **Functional programming** is focused on _data flow_ (i.e. immutable values being used in formulae to compute other values) , rather than control flow (i.e. "Do this, then do that!" and where variables are not values but rather memory locations with changing values over time). Popular languages for functional programming are **Excel** and **Haskell**. There is growing interest in this 70-year-old style! [Learn more!](https://www.infoq.com/presentations/Taming-Effect-Simon-Peyton-Jones/)

--

- **Procedural programming** was the standard paradigm before object-oriented programming took over. It is still what is taught 70 years later in many entry-level programming courses, where the instructors are perhaps afraid to talk (or think) abstractly. The problem to be solved by a program is decomposed into sub-problems, and procedures (a.k.a. functions) to solve each problem are written and executed in sequence.

---

template: alternative-paradigms

## The future

- Many see a **multi-paradigm future**, and some see a multi-paradigm present, where paradigms are mixed and matched, and each is used for its unique strengths.

---


## Example problems

Write a class that stores the state of a simple amplifier that has a volume slider with a mute button. 
* Write members
* Write getters/setters. If the volume is below 0 or above 1 its value is clamped to be within [0,1].
* Write a constructor that lets the user pass in the default volume to .5 and another that lets the user pass in the volume and mute state.
* Write a function called "effective" volume that is 0 if muted, and the value of the volume knob otherwise.
* Write a function called "amplify" that takes in a double and multiplies the value by the effective volume
* Write a function called "amplify" that returns that amplifies the values of a double array. Input and output are double arrays.
* Write a function so the volume knob's state can be printed (Either to output "Muted" or ".5" if it is muted or the volume is .5 respectively)
* Write a function to check if two amplifiers have the same state.

---

## Example problems

Write a class that stores the username and password of a user. The class should keep track of the last 5 passwords the user used so they cannot update their password to be a previous one.
* Write members
* Write getters/setters. Although setters usually do not return anything, the setter should return false if the password is a prior password and the password should not change in that case.
* Write a constructor that sets the username and password.
* Write a function tryLogin that checks that the password is correct.

---

## Example problems

Write a class for fractions, storing an integral numerator and denominator.
* Write members
* Write getters/setters. Denominator cannot be 0.
* Write a constructor that sets the members and a constructor that takes in the numerator and assumes the denominator is 1.
* Write a function that prints out "3 / 6" if the numerator is 3 / denominator is 6
* Write a function to check if two fractions are equal to one another.
---


name: conclusions

# Conclusions

--

You now have a basic understanding of object-oriented programming in Java. Well done.

--

- Thank you. Bye.
