---
layout: presentation
title: Starter code
permalink: /slides/starter-code/
---

class: center, middle

# Starter code

---

# Agenda

1. [Assumptions](#assumptions)
1. [Starter code](#starter-code)
1. [Better starter code](#better-code)
1. [Even better starter code](#even-better-code)
1. [Soliciting input](#input)
1. [Data types](#data-types)
1. [Conclusions](#conclusions)

---

name: assumptions

# Assumptions

---

template: assumptions

## Ability to run \*NIX commands

In order to run Unix or Linux commands (collectively known as \*NIX), you will need a UNIX terminal emulator:

- OS X users already have the Terminal app we will use for this purpose.
- Windows users must have [Git for Windows](https://gitforwindows.org/) installed.

---

template: assumptions

## Ability to execute Java programs

You will need to have the [Java Development Kit](https://www.oracle.com/technetwork/java/javase/downloads/) (JDK) installed.

If you have any terminal emulators open (such as Terminal or Git Bash), close them and reopen them after installing the JDK.

---

template: assumptions

## Understanding of plain text

Plain text is a term frequently used to mean one data on a computer that is represented as codes in the ASCII encoding system or the Unicode encoding system, a successor to ASCII.

These coding systems map specific numeric codes to every text character. For example, the letter `a` is 97, `b` is 98, and so on and so forth.

---

template: assumptions

## Understanding of plain text

When you as a human see plain text on your screen or type text characters on your keyboard, chances are the computer behind the scenes will store that text's numeric codes (in binary) according to one of these two encoding systems.

A plain text file is a file that has nothing but numeric codes that map out to characters in one of these systems. Unicode is today's standard and includes all the Anglocentric characters ASCII did, plus characters of all other languages.

---

template: assumptions

## Ability to edit plain text

Computer programming code is plain text. In order to edit code, you will need a decent plain text editor program.

--

Just about any code editor or Integrated Development Environment (IDE), such as [Visual Studio Code](https://code.visualstudio.com), is a good plain text editor.

--
- For this class we are using [Eclipse](https://eclipse.org).
  - Built for Java, but can be used for other languages.
  - Used in subsequent classes so best to get used to it now.
  - Tutors are only expected to know how to use this (Don't forget to see the graders).

---

template: assumptions

## Warnings about text editor quality

- Never use TextEdit on OS X to edit code.
- Never use Notepad on Windows to edit code.
- Do not use Microsoft Word or Google Docs to edit code

---

template: assumptions

## Command line text editors

Emacs is a plain text editor that can be run from the command line. Vim is another.

If you want to have the most fun with the \*NIX command line, use Emacs/Vim instead of Eclipse.


---

template: assumptions

## Recommendations about editors

- Know your editor.
- Learn shortcuts, at least a few.
- Use the debugger!

---

name: starter-code

# Starter code

---

template: starter-code

## Create a file

Use the command line to make a new plain text file with the `.java` extension somewhere you know you can find it later.

```bash
foo@bar$ cd ~
foo@bar$ mkdir first_try
foo@bar$ cd first_try
foo@bar$ touch MyFirstJavaProgram.java
```

---

template: starter-code

## Add starter Java code to the file

Edit the text file you just created using a text editor of your choice.

```bash
foo@bar$ code MyFirstJavaProgram.java
```

Add the following code:

```java
public class MyFirstJavaProgram {
	public static void main(String[] args) {
		// put the main contents of your program below here
		System.out.println("Welcome to Java from the command line!");
	}
}
```

---

template: starter-code

## Save your file

Know the shortcut. Do it frequently!

- Windows: `Ctrl-s`
- Mac: `Command-s`

---

template: starter-code

## Compile the Java source code

Java code must be compiled to byte code before it can be run. Use the `javac` command to do this.

```bash
foo@bar$ javac MyFirstJavaProgram.java
```

Note the full name of the .java file to compile.

The compiler will now have automatically created a file named MyFirstJavaProgram.class in the same directory.

---

template: starter-code

## Execute the Java byte code

The Java byte code can now be executed by the JVM, Java's interpreter, using the `java` command.

```bash
foo@bar$ java MyFirstJavaProgram
Welcome to Java from the command line!
```

Note the command does not require the `.java` or `.class` file extension.

---

name: better-code

# Better starter code

---

template: better-code

## Add a package

Java code can be organized into "packages" of related files.

Add a similar package declaration to your source code file in an editor of your choice, but replace `ab1234` with your own NYU Net ID.

```java
package edu.nyu.cs.ab1234;

public class MyFirstJavaProgram {
	public static void main(String[] args) {
		// put the main contents of your program below here
		System.out.println("Welcome to Java from the command line!");
	}
}
```

---

template: better-code

## Move the file to the proper location

Sadly, with a package identifier, the `.java` and `.class` files must now be located in a directory that matches the package or the JVM will not execute them.

Create an appropriate set of sub-directories, and move both files at once (replace `ab1234` with your own NYU Net ID):

```bash
foo@bar$ mkdir edu
foo@bar$ mkdir edu/nyu
foo@bar$ mkdir edu/nyu/cs
foo@bar$ mkdir edu/nyu/cs/ab1234
foo@bar$ mv MyFirstJavaProgram.* edu/nyu/cs/ab1234
```

Of course there is a way to create all these sub-directories at once using the `-p` flag to the `mkdir` command:

```bash
foo@bar$ mkdir -p edu/nyu/cs/ab1234
foo@bar$ mv MyFirstJavaProgram.* edu/nyu/cs/ab1234
```

---

template: better-code

## Recompile the Java source code.

Sadder still, the Java source code must now be re-compiled, since the byte code is no longer up to date.

```bash
foo@bar$ javac edu/nyu/cs/ab1234/MyFirstJavaProgram.java
```

This will overwrite the file named `MyFirstJavaProgram.class` in the appropriate directory.

---

template: better-code

## Re-execute the Java byte code

At this point, you have two files named `MyFirstJavaProgram.java` (source code) and `MyFirstJavaProgram.class` (byte code) in the directory `edu/nyu/cs/ab1234`, where `ab1234` is replaced with your own NYU Net ID.

Now try running it. Here we will tell the JVM that it should look in the current working directory (nicknamed `.` in UNIX) and any sub-directories for the appropriate .class files within the indicated package.

```bash
foo@bar$ java -classpath . edu.nyu.cs.ab1234.MyFirstJavaProgram
Better welcome to Java from the command line!
```

---

name: even-better-code

# Even better starter code

--

## How could it be any better?!

We can do even better than our [better starter code](#better-code) by putting Java source code into a `src/` directory and compiling our Java byte code into a separate `bin/` directory.

--

```bash
project-directory/
       |
       |----------> src/ (Java source code)
       |
       |----------> lib/ (external dependencies)
       |
       |----------> bin/ (compiled byte code)
```

--

We need to modify our compile and execute commands:

```bash
foo@bar$ javac -d bin src/edu/nyu/cs/ab1234/MyFirstJavaProgram.java
```

```bash
foo@bar$ java -cp bin edu.nyu.cs.ab1234.MyFirstJavaProgram
```

---

name: input

# Soliciting input

--

## Scanner

In order to easily receive keyboard input from a user, a Java program must import `java.util.Scanner`.

```java
package edu.nyu.cs.ab1234;

import java.util.Scanner;

public class AgreeableBot {

	public static void main(String[] args) {
		System.out.println("What's on your mind? ");

		Scanner scnr = new Scanner(System.in);
		String response = scnr.nextLine();

		System.out.println("I'm also thinking about " +  response + "!");

		scnr.close();
	}
}
```

---

template: input

## Scanner's built-in functions

Scanner has a few different functions for fetching the user input as different data types, e.g.:

- `nextLine()` - returns a `String` with the user's input up to the newline (i.e. `\n`) character they type
- `nextInt()` - returns an `int` with the user's input, if they entered an integer; otherwise crashes
- `nextDouble()` - returns a `double` with the user's input, if they entered a number; otherwise crashes

---

template: input

## Scanner weirdness

Using any of the functions besides `nextLine()` creates complication. For example:

```java
package edu.nyu.cs.ab1234;
import java.util.Scanner;

public class LookHowGreatJavaIs {
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		// get user's age
		System.out.println("Please enter your age: ");
		int ageAsInt = scnr.nextInt(); // an int
		// get user's name
		System.out.println("Please enter your name: ");
		String name = scnr.nextLine(); // a String
		// print out a friendly welcome message
		System.out.println("Welcome, " +  name + "! You are " + ageAsInt/7 + " years old in dog years!");
		scnr.close(); // close the Scanner to conserve resources
	}
}
```

--

This program will always output, `Welcome, !` no matter what you do!

---

template: input

## Avoiding Scanner weirdness

One way to avoid Scanner's weirdness, when asking the user for data types besides String, is to use `nextLine()` for all input and then convert the String it returns to other data types.

```java
public class StickToScanningStrings {
    public static void main(String[] args) throws Exception {
		Scanner scnr = new Scanner(System.in);
		// get user's age
		System.out.println("Please enter your age: ");
		String ageAsString = scnr.nextLine(); // a String... avoid nextInt() and nextDouble!
        int ageAsInt = Integer.parseInt(ageAsString); // and for doubles use Double.parseDouble(age)
		// get user's name
		System.out.println("Please enter your name: ");
		String name = scnr.nextLine(); // a String
		// print out a friendly welcome message
		System.out.println("Welcome, " +  name + "! You are " + ageAsInt/7 + " years old in dog years!");
		scnr.close();
    }
}
```
---

name: input

## Reading a file

Everything in Unix is a file

--

- `System.in` is a "file"

--

- We can also pass in a file

--

```java
package edu.nyu.cs.ab1234;

import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;

public class AgreeableBot {

	public static void main(String[] args) throws FileNotFoundException {
        Scanner inScanner = new Scanner(System.in);
        Scanner dictScanner = new Scanner(new File("dictionary.txt"));
    }
}
```

---

name: input

## Reading a file


```java
package edu.nyu.cs.ab1234;

import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;

public class AgreeableBot {

	public static void main(String[] args) throws FileNotFoundException {
        Scanner dictScanner = new Scanner(new File("dictionary.txt"));
        while(dictScanner.hasNextLine()) {
            String word = dictScanner.nextLine();
            if("ajax".equals(word)) {
                System.out.println("Word ajax was found!");
                dictScanner.close();
                return;
            }
        }
        dictScanner.close();
        System.out.println("ajax not found");
	}
}
```

---

name: data-types

# Data types

--

## Overview

Java natively supports 8 fundamental [primitive data types](http://docs.oracle.com/javase/tutorial/java/nutsandbolts/datatypes.html):

- `byte` = 8-bit signed integer
- `short` = 16-bit signed signed integer
- `int` = 32-bit signed integer (**the default** for integer literals)
- `long` = 64-bit signed floating-point number
- `float` = 32-bit floating point floating-point number
- `double` = 64-bit floating point number (**the default** for floating point literals)
- `char` = 16-bit Unicode character code
- `boolean` = 1-bit true (1) or false (0) value
- **arrays**, while not a data type, are a fundamental data structure in Java

---

template: data-types

## Overview (continued)

Observations:

- `float` and `double` are fundamentally inaccurate. Use `java.math.BigDecimal` for accuracy if required.
- there is no `String` primitive data type in Java. `String` is a `class` that is written in Java code.
- because it contains "primitive" data types that are not only `class` types, _Java is not a purely object-oriented language_.

---

template: data-types

## Utility/Helper/Wrapper classes

The Java API (a set of `classes` written in Java that are distributed with Java) offers a set of utility classes to help manipulate data of the fundamental primitive data types and structures.

- `Byte`
- `Short`
- `Integer`
- `Long`
- `Float`
- `Double`
- `Character`
- `Boolean`
- `Arrays`

--

- These classes are especially helpful when converting a value of one data type to another.

---

template: data-types

## Utility/Helper/Wrapper classes (continued)

Observations:

- Utility classes contain useful methods for manipulating the types of data usually stored as fundamental primitive data types.
- They are often called "wrapper" or "helper" classes because they offer additional functionality built around primitive data types.
- These are fully-**objected-oriented** correlates of the fundamental primitive data types.

---

template: data-types

## Apache Commons Lang

Due to the limitations of working with primitive data types and the conservative nature of the Java API's included Utility/HelperWrapper/ classes, the [Apache Software Foundation](https://apache.org) sponsors a project called [Commons Lang](https://commons.apache.org/proper/commons-lang/) that aims to provide functionality that many programmers regret is not present in the Java API. This library includes additional helper classes, such as:

- `NumberUtils`
- `CharUtils`
- `BooleanUtils`
- `ArrayUtils`
- ... and [many more](https://commons.apache.org/proper/commons-lang/apidocs/index.html) for dealing with data of non-primitive types.

--

- Commons Lang is perhaps most well-known for its `String`-related helper classes: `StringUtils`, `WordUtils`, and `StringEscapeUtils`.

---

template: data-types

## Strings

The `==` operator performs a comparison of the position in memory where two values are stored in memory.

- It does not compare the values stored at those locations of memory

```java
String x = "hello";
String y = "hello";
boolean theSameMemoryAddress = (x == y); // -> most likely true, but not guaranteed to be so
```

```java
Scanner scn = new Scanner(System.in);
String x = "hello";
String y = scn.nextLine(); // let's imagine the user enters the same text, "hello"...
boolean theSameMemoryAddress = (x == y); // -> most likely false!, but not guaranteed to be so
```

---

template: data-types

## Strings (again)

`String` is not a primitive data type, it's an object-oriented `class`.

- Only primitive data types can be compared with `==`
- Two Strings with the same value may be stored in different spots in memory
- The `==` operator may not always result in a `true`, when comparing two Strings, even those with the same text.
- Use the `.equals()` method for Strings instead.

```java
String x = "hello";
String y = "hello";
boolean theSameMemoryAddress = x.equals(x); // -> true if they contain the same text, false otherwise
```

---

template: data-types

## Strings (once more)

There is also a `StringBuilder` class, which is a utility class for the `String` class.

- Even though `String` is actually fully object-oriented, Strings are immutable.
- The `StringBuilder` class is a convenient mutable equivalent of the String class.

```java
StringBuilder str = new StringBuilder();
str.append("goodbye");
str.append("foo");
str.append("world!");
str.delete(7,10); // remove the characters at index positions 7-9, i.e. "foo"
str.insert(" ", 7); // insert a space at index position 7
str.replace(0, 7, "hello"); // replaces the characters at index positions 0-6 (i.e. "goodbye) with "hello"
String result = str.toString(); // -> "hello world!";
System.out.println(result);
```

---

template: data-types

## Converting data types

Double to int:

```java
Double dbl = new Double(5.0);
int integer = dbl.intValue();
```

---

template: data-types

## Converting data types

Integer to String:

```java
String str = Integer.toString(5);
// or
String str = ""  +  5;
```

---

template: data-types

## Converting data types

Double to String:

```java
String str = Double.toString(5.0);
```

---

template: data-types

## Converting data types

Long to String:

```java
String str = Long.toString(50L);
```

---

template: data-types

## Converting data types

Float to String:

```java
String str = Float.toString(5.0F);
```

---

template: data-types

## Converting data types

String to Integer:

```java
int i = Integer.valueOf("5").intValue();
// or
int i = Integer.parseInt("5");
```

---

template: data-types

## Converting data types

String to Double:

```java
double d = Double.valueOf(str).doubleValue();
// or
double d = Double.parseDouble(str);
```

---

template: data-types

## Converting data types

String to Long:

```java
long l = Long.valueOf("5").longValue();
// or
long l = Long.parseLong("5");
```

---

template: data-types

## Converting data types

String to Float:

```java
float f = Float.valueOf("5").floatValue();
```

---

template: data-types

## Converting data types

Decimal to Binary:

```java
String bin = Integer.toBinaryString(50);
```

---

template: data-types

## Converting data types

Decimal to Hexadecimal:

```java
String hexstr = Integer.toHexString(50);
//or
String hexstr = Integer.toString(50, 16);
```

---

template: data-types

## Converting data types

Hexadecimal to Decimal:

```java
int i = Integer.valueOf("B8DA3", 16).intValue();
//or
int i = Integer.parseInt("B8DA3", 16);
```

---

template: data-types

## Converting data types

Char to String:

```java
String s = String.valueOf('c');
```

---

template: data-types

## Converting data types

Integer to ASCII code:

```java
int i  = (int) 'A';
```

---

template: data-types

## Converting data types

Use **exception handling** to handle any problems encountered while attempting to convert one data type to another.

```java
String aString = "foo bar baz bum"; //  a string that has no obvious int equivalent

try{
	// try to do the conversion...
	i = Integer.parseInt(aString); // will fail and produce an Exception
}
catch(NumberFormatException e) {
	// this block of code will run if there was a failure
	System.out.println(e); // will output the Exception but not crash the program
}
```

---

name: conclusions

# Conclusions

--

We can now use the command line to write and compile Java source code into Java byte code and then execute that byte code using the JVM interpreter. We also understand a bit about data types in Java.
