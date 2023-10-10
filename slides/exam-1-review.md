---
layout: presentation
title: Exam 1 Review
permalink: /slides/exam-1-review/
---

class: center, middle

# Exam 1 Review

Intro to Computer Science

---

# Agenda

1. [Basic Computer Concepts](#concepts)
1. [Unix](#unix)
1. [The Java Paradigm](#java-paradigm)
1. [Branching](#branching)
1. [Loops](#loops)
1. [Methods](#methods)
1. [arrays](#arrays)

---



name: concepts

#  Basic Computer Concepts

--


- Computation decomposes tasks into inputs and outputs
--

  - Not only input, but also hardware like mice/keyboard/displays

--

- Busses communicate information between functional components

--

- CPU executes commands and memory stores data from your programs

--

- The basic unit is a bit, computers work 8 bits at a time in a byte 

--

- Desktop metaphor: we model data in files/folders to mimic desks

--

- Two types of files binary and text (which is also binary)
--

  - Text is human readable and good for small amounts of data


---

name: unix

# Unix

--

- Shell lets us navigate our filesystem and run programs

--

- Working directory is whre your shell "is"
--

  - `.` refers to the current directory, `..` refers to teh directory above it
--
  
  - Use `pwd` to print out the working directory

--

- `cd` navigates between directories
--

   - Paths that start with `/` are absolute from the root directory
   - Paths are otherwise relative to the working directory


--

- `ls` lists the contents of the working directory
--

 - Can also add a path to list that directory

--

--

- Each file/folder has permissions on who can access it and how
--

 - Three types of permissions (read/write/execute) denoted r/w/x respectively
--

 - Three types of Users (user/group/other) denoted u/g/o respectively
--

  - Know how to read `ls -l`


---

# (more) Unix commands

- `mv` moves a file between two paths
 - Also used to rename

--

- `cp` to copy a file

--

- `touch` to create a new empty file

--

- `mkdir` to create a new folder
 - `mkdir -p` to create required subdirectories

--

- `rm` to delete a file


--

- `rmdir` to delete an empty folder

--

  - `rm -rf` to delete an empty folder

---

name: java-paradigm

# The Java Paradigm 

--


- Programs execute sequences of instructions

--

- There's a spectrum of abstractions
--

 - low level (machine/assembly languages)
 - high level (Java/Python/C++/Go/Rust/...)


--

- Each processor can read series of binary machine instructions
--

  - Assembly languages are mnemonics to help us understand each machine instruction

--

- High level programming languages abstract these instructions with fancy features
--

 - Like looping (for/while)/branching (if/switch)/functions

---

# The Java Paradigm (continued)

- Compiled vs interpreted languages
--

 - Compiled languages are compiled to machine code to run on a particular type of processor
   - compilation takes time, code can be more efficient, static analysis

--

 - Interpretted languages are translated to machine code and executed at runtime
   - runs immediately, not as fast, trouble identifying errors

--

- Java is both compiled and interpretted
--

  - Compiled to java byte-code. the Java Virtual Machine (JVM) interprets byte-code.

---



name: java-compilation

# Building Hello World

--

```java
// File Midterm.java
public class Midterm {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}
```

--

- Compile with `javac`
--

- Produces `Midterm.java`
--

- Run with `java Midterm`

---

name: java-compilation

# Java Basics

--

- Primitives:

```java
byte,short,int,long,float,double,char,boolean
```

--

- Primitives:

```java
Byte,Short,Integer,Long,Float,Double,Character,Boolean

```

--

- Scanner inputs

```java

Scanner scnr = new Scanner(System.in);
String line = scnr.nextLine();
```
--

- Comparison operations: `==` `!=` `Object.equals(Object)`
--
 
  - `==` on objects (String) returns addresses 


---


name: branching

# Branching



- `if` `else`
```java
if(CONDITION) {
} else if(CONDITION2) {
} else {
}
```

--

- `switch/case`

```java
switch(VALUE) {
    case CASE0: f(); break;
    case CASE1: g(); break;
    case CASE2:
    default: h(); break;
}

switch(VALUE) {
    case CASE0: return 0;
    case CASE1: return 1;
}
```


---

name: loops

# Loops

--

- `while`

```java
bool flag = true;
while(flag) {
    if(CONDITION) {
    flag = false
    }
}
```
--

```java
int counter = 0;
while(counter < 45) {

    ++counter;
}
```

--

- `for`

```java
for(int index = 0; index < count; ++index) {

}
```

--

```java
for(int index: array) {

}
```

---

name: methods

# Methods

--

```java
public static void f() {
}

public static String g() {
}

public static String g(int a, String b, char c) {
}
```

--

- Return by value (`a,b,c` above are not the same variables as what the caller used)

- Overloading (`g` has two definitions with different parameters)

---

name: arrays

# Arrays

--

- Initialization

```java
int n = 30;
int[] arr = new int[n];

char[] arr2 = {'h','e','l','l','o'};
```

--

- String split

```java
String sentence = "hello world";
String[] words = sentence.split();// words.length == 2;
```

--

- Sorting

```java
arr.sort();
```

---

name: arrays

# ArrayList

--

- Initialization

```java
ArrayList<String> arr = new ArrayList<String>();
arr.add("words");
arr.add("and");
```

--

- Access

```java
arr.get(2);
arr.get(arr.size()-1);
```

--

- To normal array

```java
String[] normalArr;
String[] normalArr = arr.toArray(normalArr);// weird pattern
```
