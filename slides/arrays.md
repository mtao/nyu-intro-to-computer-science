---
layout: presentation
title: Arrays
permalink: /slides/arrays/
---

class: center, middle

# Arrays

> Days of absence, sad and dreary, clothed in sorrow's dark array. Days of absence, I am weary; she, I love, is far away.
>
> -[Jean-Jacques Rousseau](https://en.wikipedia.org/wiki/Jean-Jacques_Rousseau), Days of Absence

---

# Agenda

1. [Overview](#concept)
1. [Creation](#creation)
1. [Array Length](#length)
1. [Arrays Utility Class](#arrays-class)
1. [Search an Array](#binary-search)
1. [Challenges](#challenges)
1. [ArrayList Class](#arraylist)
1. [Java Is Pass By Value Language](#pass-by-value)
1. [Basic Usage Examples](#examples)
1. [Conclusions](#conclusions)

---

name: overview

# Overview

Arrays are a grouping data structure.

- Multiple values or references can be stored within an array.
- Arrays can store any other data type or data structure, including arrays.

---

name: creation

# Creation

--

## The old-fashioned way

Arrays can be created using the `new` keyword.

- The `new` keyword causes Java to allocate a certain amount of memory for this array, even before it has been populated.

```java
char[] myFavoriteCharacters = new char[3];
myFavoriteCharacters[0] = 'f';
myFavoriteCharacters[1] = 'o';
myFavoriteCharacters[2] = 'o';
```

- In this case, Java knows that each `char` value consumes 16 bits, so it reserves enough memory space for 3 of them.

- The length of the array cannot be modified once memory has been allocated for an array of a specific length.

---

template: creation
name: creation-2

## Using syntactic sugar

Arrays can be created using `syntactic sugar`, or shorthand syntax that is converted to the longer-form automatically by Java upon compilation.

- This can be useful if you know the values you want to put into the array up-front.

```java
char[] myFavoriteCharacters = { 'f', 'o', 'o' };
```

- Note that both operations - declaring the variable and allocating and populating the array - must be done in one statement with this style.

---

template: creation
name: creation-3

## Using String's split function

Arrays can easily be made from text that contains a particular separator.

```java
String myMessageToYou = "Don't worry about a thing";
String[] words = myMessageToYou.split(" ");
// now you have an array { "Don't", "worry", "about", "a", "thing" }
```

--

You can also use [regular expressions syntax](https://docs.oracle.com/javase/tutorial/essential/regex/) to split by one of several separators:

```java
String myMessageToYou = "Don't, worry?about-a .thing";
String[] words = myMessageToYou.split("[ ,?-.]+");
// now you have an array { "Don't", "worry", "about", "a", "thing" }
```

---

name: length

# Array Length

--

## Counting elements in an array

The `length` property of any array counts its members.

```java
Scanner scn = new Scanner(System.in);
String[] veggies; // reference to an as-yet unallocated array
int num = 0;
while (num < 1) {
    System.out.println("Enter your favorite vegetables, separated by commas: ");
    String response = scn.nextLine();
    veggies = response.split(","); // array is now allocated and populated
    num = veggies.length;
}
```

- Note that **arrays in Java are fixed length**. New positions cannot be added or nor existing positions removed from an array, although the values at each position can be modified.

---

name: arrays-class

# Arrays Utility Class

--

## Useful array-related functions

The Arrays utility class is part of the Java API

- provides useful methods for manipulating arrays
- `import java.util.Arrays`

---

template: arrays-class
name: arrays-class-2

## Convert array contents to String

`Arrays.toString()` prints out the contents of the array _inelegantly_.

- Good for debugging.

```java
String[] arrVar = { "hello", "and", "good", "morning" };
String contents = Arrays.toString(arrVar); // -> "[hello,and,good,morning]"
```

--

... and for multi-dimensional arrays, use `.deepToString()`:

```java
String[][] arrVar = {
    {"hello", "world"},
    {"goodbye", "world"}
}; // a two-dimensional array
String contents = Arrays.deepToString(arrVar); // -> "[[hello,world],[goodbye,world]]"
```

---

template: arrays-class
name: arrays-class-3

## Comparing values in two arrays

`Arrays.equals()` determines whether two arrays have the same set of values:

```java
String[] arrVar1 = { "hello", "and", "good", "morning" };
String[] arrVar2 = { "hello", "and", "good", "morning" }; // a separate array with the same values as arrVar1 but at a different location in memory
boolean sameValues = Arrays.equals(arrVar1, arrVar2); // -> true!
```

--

... and for multi-dimensional arrays, use `.deepEquals()`:

```java
String[][] arrVar1 = { {"hello", "world"}, {"goodbye", "world"} }; // a two-dimensional array
String[][] arrVar2 = { {"hello", "world"}, {"goodbye", "world"} }; // a separate array with the same values as arrVar1 but at a different location in memory
boolean sameValues = Arrays.deepEquals(arrVar1, arrVar); // -> true!
```

---

template: arrays-class
name: arrays-class-4

## Sorting the values in an array

Put them in order.

```java
int[] arrVar = {134, 5, 3636, 34, 8};
Arrays.sort(arrVar);
// arrVar now holds {5, 8, 34, 134, 3636}
```

--

It is also possible to sort a subset of the array:

```java
int[] arrVar = {134, 5, 3636, 34, 8};
int startIndex = 1;
int endIndex = 4;
Arrays.sort(arrVar, startIndex, endIndex);
// arrVar now holds {134, 5, 34, 3636, 8}
```

---

template: arrays-class
name: arrays-class-6

## Copying an array

Use `Arrays.copyOf()` to make a clone:

```java
int newArrLength = 10;
Arrays.copyOf(arrVar, newArrLength); // copy into array of different length
```

--

name: arrays-class-copy

... or `.copyOfRange()` to clone a subset of the values in an array:

```java
int startIndex = 0;
int endIndex = 3;
Arrays.copyOfRange(arrVar, startIndex, endIndex); // copy only a subset
```

---

template: arrays-class
name: arrays-class-7

## Filling an array

`Arrays.fill()` places default values into an array:

```java
String defaultValue = "foo";
Arrays.fill(arrVar, defaultValue);
```

---

name: binary-search

# Search an array

--

## Overview

The two most common ways of searching for a value within an array are:

- linear search
- binary search

Each has its advantages and disadvantages.

---

template: binary-search

## Linear search

The most basic and reliable way to search for a value in an array is **linear search**, a.k.a. **the brute-force approach**, where we simply loop through each value in the array and compare it to the value we are looking for.

```java
String[] words = {"good", "how", "morning", "are", "you"};
String searchTerm = "morning";
int pos = -1; // start out with a value that indicates we haven't found the searched-for value yet
for (int i=0; i < words.length; i++) {
    if (words[i] == searchTerm) {
        pos = i; // we have found the value at the position i
    }
}
// i -> 2
```

--

_For a large array, this can be an inefficient way of searching, since we often have to loop through almost every value in the array before concluding the search._

---

template: binary-search

## The binary search algorithm

The binary search algorithm **more efficiently** searches for a value in an array as follows:

1. The values in the array are sorted
2. The value in the middle of the array of interest is compared to the value we are searching for.
   - If the value in the middle is the value we are looking for, the search is finished
   - If the value in the middle is greater than the value we are looking for, we repeat step 2, but looking only at a subset with the first half of the values in the original array
   - If the value in the middle is less than the value we are looking for, we repeat step 2, but looking only at a subset with the second half of the values in the original array

--

_This algorithm is only beneficial for arrays of values that can be sorted._

---

template: binary-search

## Binary search from scratch

An example of a **recursive** implementation of a binary search algorithm.

```java
public static int binarySearch(int arr[], int startPos, int endPos, int searchTerm) {
    if (endPos >= startPos) {
        int midPos = startPos + (endPos - startPos) / 2; // find the middle position of the array
        int middleValue = arr[midPos] // the value at the middle position

        if (middleValue == searchTerm) {
            // if the value we're looking for is exactly in the middle, return it
            return midPos; // return it if so
        }
        else if (searchTerm < middleValue) {
            // if the searchTerm is smaller than the middle value, it can only be present in the left half subset of the array
            return binarySearch(arr, startPos, midPos-1, searchTerm); // return the result of a binary search on only the left half
        }
        else {
            // otherwise, if the searchTerm is larger than the middle value, the searchTerm can only be in the right half
            return binarySearch(arr, midPos+1, endPos, searchTerm); // return the result of a binary search on only the right half
        }
    }
    return -1; // if we haven't yet returned anything, the value is not present in the array
}
```

---

template: binary-search

## Binary search using the Arrays utility class

Binary search can be performed using the `Arrays.binarySearch()` method:

```java
int[] numbers = {2456, 35, 25986, 10, 12};
int searchTerm = 10;
int pos = Arrays.binarySearch(numbers, searchTerm); // -> 3
```

---

name: challenges

# Challenges

--

## Overview

Due to the **fixed-length** nature of arrays, it is not possible to add or remove values to an array "on-the-fly".

--

However, when it is desired to **"add" a new value to an array**, it is possible to:

1. Create a new array that is one longer than the old array
1. Copy the values from the old array into the new array (using a for loop or methods in the [Arrays utility class](#arrays-class-6).)
1. Add the new value into the last empty spot of the new array

--

Similarly, it is possible to **"remove" a value from an array** by:

1. Create a new array that is one shorter than the old array
1. Copy the values you want to keep into the new array, but don't copy the one you want to remove (using a for loop or methods in the [Arrays utility class](#arrays-class-copy).)

---

template: challenges
name: challenges-solution

## Solution: Copy data into a new array one bigger

An example of simulating "adding" new values on-the-fly to an array. Here we take an arbitrary number of inputs from the user and store whatever they enter into an array.

```java
String[] veggies = new String[1]; // start with an array to hold just one value
Scanner scn = new Scanner(System.in);
boolean keepGoing = true;
while (keepGoing) {
    System.out.println("Please enter a vegetable you like: ");
    String response = scn.nextLine();
    veggies[veggies.length-1] = response; // add the user's response to the last spot in the array
    if (response.equals("stop")) {
        keepGoing = false;
    }
    else {
        String[] newVeggies = new String[veggies.length + 1]; // create a new array one bigger than the last
        for (int i=0; i < veggies.length; i++) {
            newVeggies[i] = veggies[i]; // copy each value from the old array to the new
        }
        veggies = newVeggies; // reassign the variable to point to the new longer array
    }
}
System.out.println(Arrays.toString(veggies));
```

---

template: challenges

## Solution: Use Apache Commons Lang's ArrayUtiles

A second solution to the problem of "adding" elements to an existing array is to use [Apache Commons Lang](https://commons.apache.org/proper/commons-lang/)'s `ArrayUtils` class.

- This requires first downloading and installing the Commons Lang library `.jar` file into a project's dependencies directory (often the `lib` directory) and then importing it using `import org.apache.commons.lang3.ArrayUtils;`

```java
int[] fibb = {0, 1, 2, 3, 5, 8};
fibb = ArrayUtils.add(fibb, 13);
System.out.println(Arrays.toString(fibb)); // outputs "[0, 1, 2, 3, 5, 8, 13]"
```

--

- Note that this technique only works with arrays of primitive data types.

---

name: arraylist

# ArrayList Class

--

## Overview

The `ArrayList` class, part of the `java.util` package, is designed to give programmers a more dynamic array-like expeirence than the primitive arrays can do.

- an `ArrayList` does not have a fixed length

--

- an `ArrayList` can have new members added to it at any time

--

- an `ArrayList` can have existing members removed from it at any time

--

- `ArrayList` is not a primitive data type or data structure in Java - it is not built into the language as a native type

--

- `ArrayList` is a reference type, as are all non-primitive data types or data structures

---

template: arraylist

## Example

```java
ArrayList<String> veggies = new ArrayList<String>(); // initialize an ArrayList that will hold Strings
veggies.add("avocado"); // add avocado (a fruit) to our list of vegetables
veggies.add("tomato"); // add tomato (a fruit) to our list of vegetables
veggies.add("crispy lettuce"); // add crispy lettuce to our list of vegetables
veggies.add("ketchup"); // add ketchup (a sweetened condiment) to our list of vegetables
veggies.add("bacon"); // add bacon (an animal product) to our list of vegetables
veggies.remove("avocado"); // remove avocado from our list of vegetables
int pos = veggies.indexOf("ketchup"); // returns 3, since "ketchup" is at position 3
String sweetStuff = veggies.get(pos); // returns "ketchup", which is at position 3
```

--

- Here we have seen some of the most useful methods in the `ArrayList` class.
- See the [full set of methods in ArrayLists](https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html).

---

template: arraylist

## Another example

An example of adding new values on-the-fly to an `ArrayList`. Here we take an arbitrary number of inputs from the user and store whatever they enter into an `ArrayList`.

```java
ArrayList<String> veggies = new ArrayList<String>(); // create a blank ArrayList
Scanner scn = new Scanner(System.in);
boolean keepGoing = true;
while (keepGoing) {
    System.out.println("Please enter a vegetable you like: ");
    String response = scn.nextLine();
    if (response.equals("stop")) {
        keepGoing = false;
    }
    else {
        veggies.add(response); // add what the user entered into the ArrayList
    }
}
System.out.println(veggies);
```

--

Compare this to performing the same task [using primitive arrays](#challenges-solution).

---

name: pass-by-value

# Java Is A Pass By Value Language

--

## The word on the street

Some textbooks and online discussions say, "[Java is a 'pass by value' language!](https://stackoverflow.com/questions/40480/is-java-pass-by-reference-or-pass-by-value)" What does this mean?

- This refers to what exactly is passed to a method when it is invoked with arguments.

---

template: pass-by-value
name: pass-by-value-2

## Primitives are value types

When a _value type_ (e.g. a primitive data type value) is passed as an argument to a function, the situation is straightforward.

- A copy of the argument's _value_ is passed to the function!
- Primitive values are called '**value types**' for this reason.

---

template: pass-by-value
name: pass-by-value-3

## Passing value types as arguments to methods

Take the following example:

```java
public static void doSomething(int x) {
    x = 10;
}
public static void main(String[] args) {
    int x = 5;
    doSomething(x); // the value 5 is passed to the function
    System.out.println(x);
}
```

The output of the above program is `5`, since the local variable within the main function is never reassigned to refer to anything other than 5.

- `doSomething()` is invoked and passed a copy of the value `5` (the value the main function's local variable `x`).
- `doSomething()` creates its own local parameter variable `x` which refers to this value, `5`.
- `doSomething()` reassigns its local variable `x` to refer to `10` instead.
- `doSomething()` completes and control flows back to the main method, where the main method's local varible `x` still is assigned the value `5`.

---

template: pass-by-value
name: pass-by-value-5

## Passing reference types as arguments to methods

When a _reference type_ (e.g. an array or object) is passed as an argument to a function, the situation is straightforward.

```java
public static void doSomething(int[] x) {
    x = {25, 30, 35}; // the local variable is re-assigned to point to a different memory address
}
public static void main(String[] args) {
    int x[] = {5, 10, 15, 20};
    doSomething(x); // the memory address of the array is passed to the function
    System.out.println( Arrays.toString(x) );
}
```

The output of the above program is `[ 5, 10, 15, 20 ]`, since the local variable within the main function is never reassigned to refer to anything other than that array, and that array has never had its contents modified.

- `doSomething()` is invoked and passed a copy of the memory address of the array referred to by the main method's variable `x` (the "value" the main function's local variable `x`).
- `doSomething()` creates its own local parameter variable `x` which refers to this "value" - the memory address of that array.
- `doSomething()` reassigns its local variable `x` to refer to the memory address of a different array instead.
- `doSomething()` completes and control flows back to the main method, where the main method's local varible `x` still is assigned the "value" of the memory address of the original array.

---

template: pass-by-value
name: pass-by-value-4

## Arrays and objects are reference types

When an _array_ or an _object_ is passed as an argument to a function, the situation is a bit less straightforward.

- A copy of the argument's _reference_ - the memory address at which the array or object is stored - is passed to the function, not the values encapsulated within the array or object.
- Arrays and objects are called '**reference types**' for this reason.

---

template: pass-by-value
name: pass-by-value-6

## Arrays and objects are reference types (continued)

But consider the following example:

```java
public static void doSomething(int[] x) {
    x[2] = 555; // the third spot within the array is re-assigned to refer to a different integer
}
public static void main(String[] args) {
    int x[] = {5, 10, 15, 20};
    doSomething(x); // the memory address of the array is passed to the function
    System.out.println( Arrays.toString(x) );
}
```

The output of the above program is `[ 5, 10, 555, 20 ]`, since the local variable within the doSomething function is an alias of the variable within the main function - they both refer to the same array in the same memory location and that array's inner values have been modified.

---

template: pass-by-value
name: pass-by-value-6

## Doesn't this mean Java is both a 'pass by value' and 'pass by reference' language?

The phrase, "Java is a 'pass by value' language is thus a bit confusing.

- Arguments that are value types (i.e. primitives) are passed as values
- Arguments that are reference types (i.e. arrays and objects) as values, but the values in this case are memory addresses (called "references" by most normal people).

The trick to this is that the **references are themselves passed as values** - the value being the integer memory address at which the array or object resides.

---

name: conclusions

# Conclusions

--

You now have a basic understanding of arrays in Java.

--

- Thank you. Bye.
