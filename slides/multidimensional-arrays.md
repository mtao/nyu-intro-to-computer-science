---
layout: presentation
title: Multi-Dimensional Arrays
permalink: /slides/arrays-multidimensional/
---

class: center, middle

# Multidimensional Arrays

> The universe is not a stagnant place where technology stands still and only the few govern its destiny. Rather, it is a multidimensional dynamic entity that interacts with all things, even the very smallest. And what part we each place in it and the effect we have on it is a matter of our own choice.
>
> -[R.G. Risch](https://www.goodreads.com/book/show/5618917-beyond-mars), Beyond Mars: Crimson Fleet

---

# Agenda

1. [Overview](#concept)
1. [Truth](#truth)
1. [Ragged Arrays](#ragged)
1. [Rows & Columns](#rows-columns)
1. [Conclusions](#conclusions)

---

name: overview

# Overview

---

template: overview
name: overview-1

## Concept

Multidimensional arrays are arrays that store other arrays nested within them.

--

- An array that stores arrays is called a two-dimensional array

--

- An array that stores arrays that themselves store arrays is called a three-dimensional array

--

- An array that stores arrays that themselves store arrays that in turn also store arrays is called a four-dimensional array

--

- and so on.

---

template: overview
name: overview-2

## Two-dimensional example

A two-dimensional array - an array that stores inner arrays of type `int`.

- Note the **two** sets of square brackets after the data type declaration.

```java
int[][] numbers = {
        { 10, 9, 8 },
        { 1, 2, 3 },
        { 6, 5, 4 },
};
```

---

template: overview
name: overview-3

## Two-dimensional example (continued)

To output the third value in the second inner array - 3

```java
System.out.println( numbers[1][2] );
```

--

The syntax to modify one of the values in a two dimensional array is the same.

```java
// modify the third value in the second inner array
numbers[1][2] = 11;
```

--

The entire inner array can also be replaced with a different one.

```java
numbers[1] = new int[]{ 13, 12, 11 };
```

---

template: overview
name: overview-4

## Three-dimensional example

A three-dimensional array - an array that stores inner arrays of type `String`.

- Note the **three** sets of square brackets after the data type declaration.

```java
String[][][] words = {
        {
            {"who", "what", "when", "why", "how"},
            {"whither", "whence", "wherefore"}
        },
        {
            {"there", "that", "then"},
            {"thence", "hence", "heretofore"}
        }
};
```

--

To output the third value in the second child array of the first inner array - 'wherefore'.

```java
System.out.println( words[0][1][2] );
```

---

name: truth

# Truth

--

## It's all a lie!

Multidimensional arrays do not exist in Java.

--

- In a true multidimensional array, all elements within the array occupy a continuous block of memory.

--

- This is not the case in Java.

--

- Java two-dimensional arrays are arrays of pointers - references to other memory locations where the inner arrays are kept, separately from the outer array.

---

template: truth
name: truth-1d

## It's all a lie! (continued)

![the truth](../files/arrays-multidimensional-truth.png)

---

name: ragged

# Ragged Arrays

--

## Concept

Inner arrays may have different lengths... such arrays are called **ragged** arrays.

```java
int[][] numbers = {
        { 10, 9, 8, 7, 6 },
        { 1, 2 },
        { 6, 5, 4, 4, 3, 2, 1 }
};
```

---

template: ragged
name: ragged-2

## Without syntactic sugar

When not using array syntactic sugar, it is possible to leave the length of all but the first dimension blank in the allocation statement to allow for ragged arrays.

```java
int[][] numbers = new int[3][]; // blank second dimension

// now populate each inner array with whatever length you prefer
numbers[0] = { 10, 9, 8, 7, 6};
numbers[1] = { 1, 2 };
numbers[2] = { 6, 5, 4, 4, 3, 2, 1 };
```

---

name: rows-columns

# Rows & Columns

--

## Concept

It is best to think of two-dimensional arrays as rows and columns of data, like a spreadsheet or table.

- It is helpful to even write each row on a separate line and align the columns

```java
String[][] naughtsAndCrosses = {
    { "X", "O", "X" }, // first row
    { "X", "O", "X" }, // second row
    { "X", "O", "X" }  // third row
};
```

---

template: rows-columns
name: rows-columns-2

## Looping through rows with syntactic sugar

To loop through each row, remember that each row of a two-dimensional array is itself a one-dimensional array.

Using `for` loop syntactic sugar.

```java
// iterate through each row in the outer array
for (String[] row : naughtsAndCrosses ) {

    // print out the row
    System.out.println( Arrays.toString(row) );

}
```

---

template: rows-columns
name: rows-columns-3

## Looping through rows with a counter

If you insist on using an accumulator-style `for` loop, that also works, of course.

Using `for` loop accumulator syntax.

```java
// iterate through each index value in the outer array
for ( int i=0; i<naughtsAndCrosses.length; i++ ) {

    // get the row at this index
    String[] row = naughtsAndCrosses[i];

    // print out the row
    System.out.println( Arrays.toString(row) );

}
```

---

template: rows-columns
name: rows-columns-4

## Looping through each column within each row

It's easy enough to iterate through each column within each row.

- Recall that each value in the inner array - each column - is a String.

Using `for` loop syntactic sugar syntax.

```java
// iterate through each row in the outer array
for (String[] row : naughtsAndCrosses ) {

    // iterate through each column within the current wor
    for (String col : row) {

        // print out the column value
        System.out.print( col );

    }

}
```

---

template: rows-columns
name: rows-columns-5

## Looping through each column within each row (the hard way)

The same can be done without syntactic sugar

Using `for` loop accumulator syntax.

```java
// iterate through each index value in the outer array
for ( int i=0; i<naughtsAndCrosses.length; i++ ) {

    // get the row at this index
    String[] row = naughtsAndCrosses[i];

    // iterate through each index value of the inner array
    for (int j=0; j<row.length; j++) {

        // print out the column value
        System.out.println( row[j] );

    }

}
```

---

name: conclusions

# Conclusions

--

You now have a basic understanding of multidimensional arrays - especially two-dimensional arrays - in Java.

--

- Thank you. Bye.
