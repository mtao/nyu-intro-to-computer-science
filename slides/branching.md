---
layout: presentation
title: Branching
permalink: /slides/branching/
---

class: center, middle

# Branching

> Two roads diverged in a yellow wood,
>
> And sorry I could not travel both
>
> ...

-Robert Frost, [The Road Not Taken](https://www.poetryfoundation.org/poems/44272/the-road-not-taken)

---

# Agenda

1. [Overview](#concept)
1. [Flow Charts](#flow-charts)
1. [If/Else if/Else](#ifs)
1. [Switch/Case](#switch-case)
1. [The Ternary Operator](#ternary)
1. [Conclusions](#conclusions)

---

name: concept

# Overview

--

## Concept

The flow of a program can be controlled such that it deviates from its '_normal_' path.

--

- What is a program's 'normal' path?

--

- By default, a program will execute statements in the order written, from top to bottom.

--

- Some branches are _unconditional_ - the control will always break out of this sequential flow every time the program is executed.

--

- Other branches are _conditional_ - certain contextual conditions must be met if the control of the program is to break out of its usual flow.

--

- Conditional branches are our focus here.

---

name: flow-charts

# Flow Charts

--

## Concept

Understanding the flow of a program's control can be visualized easily with diagrams, irrespective of the programming language and code.

--

- Writing code is precarious, laborious, and error-prone.

--

- Creating such flow diagrams can help understand and communicate the problem being solved without such burden.

--

- The [Unified Modeling Language](https://en.wikipedia.org/wiki/Activity_diagram) (UML) has attempted to define the "Activity Diagram" - a standard for how such diagrams should be drawn.

--

- In practice, people often use parts of the UML Activity Diagram style mixed with their own personal styles.

---

template: flow-charts
name: flow-charts-6

## Example

A virtual card game program randomly picks two cards, from 1 to 11.

- If those two cards add up to 21, the program outputs the text "Blackjack!"
- Otherwise, the program outputs the text, "Maybe next time!"

---

template: flow-charts
name: flow-charts-7

## Example

![Blackjack example diagram](../files/selections_blackjack_card_draw.png)

---

template: flow-charts
name: activity-diagrams

## UML Activity Diagram Rules

UML Activity Diagrams follow a few basic rules:

--

- program control starts at the top of the diagram and ends at the bottom.

--

- the start point is indicated with just filled circle, the end with a filled circle with a line around it

--

- any process is indicated with an ellipse (or a rounded rectangle)

--

- if any process being diagrammed is so complex it makes the diagram complex and difficult to understand, make a separate activity diagram for that sub-process, and represent it as a single process in this diagram.

--

- any decision point leading to more than one branch is indicated with a diamond shape (also called a rhombus)

--

- branches should have simple annotations indicating in what decision context they are followed

---

name: ifs

# If/Else if/Else

--

## Isolated ifs

_if_ statements on their own either execute a particular branch or not.

```java
int card1 = (int) (Math.random() * 11) + 1; // number from 1 to 11
int card2 = (int) (Math.random() * 11) + 1; // number  from 1 to 11

if (card1 + card2 == 21) {
    // if the cards add up to 21...
    System.out.println("Blackjack!");
}
```

---

template: ifs
name: ifs-2

## Binary choice

_if_ statements followed by _else_ blocks can have control flow into one of two branches, depending on a single condition being met or not.

```java
int card1 = (int) (Math.random() * 11) + 1; // number from 1 to 11
int card2 = (int) (Math.random() * 11) + 1; // number  from 1 to 11

if (card1 + card2 == 21) {
    // if the cards add up to 21...
    System.out.println("Blackjack!");
}
else {
    // otherwise...
    System.out.println("Maybe next time!");
}
```

---

template: ifs
name: ifs-3

## n-ary

_if_ statements followed by one or more _else if_ blocks can have control flow into one of several different branches, depending on multiple conditions.

```java
int card1 = (int) (Math.random() * 11) + 1; // number from 1 to 11
int card2 = (int) (Math.random() * 11) + 1; // number  from 1 to 11

if (card1 + card2 == 21) {
    // if the cards add up to 21...
    System.out.println("Blackjack!");
}
else if (card1 == 1 && card2 == 1) {
    // otherwise if the cards are both ones...
    System.out.println("Snake eyes!");
}
else {
    // otherwise...
    System.out.println("Maybe next time!");
}
```

---

template: ifs
name: ifs-4

## UML Activity Diagram

![Blackjack example diagram](../files/selections_blackjack_card_draw_three_branches.png)

---

name: switch-case

# Switch/Case

--

## Concept

In Java, an alternative to if/else if/else statements is switch/case statements.

--

- these can be easier to read and write in particular situations.

--

- such as when the branch followed depends upon the value of a single variable

--

- and when multiple conditions lead to the same branch

---

template: switch-case
name: switch-case-5

## Example

Imagine a program that recommends how to dress.

![UML activity diagram for weather program](../files/selections_switch_weather.png)

---

template: switch-case
name: switch-case-6

## Not using switch / case

This could be handled by if/else if/else statements with some boolean operators thrown in.

```java
Scanner scn = new Scanner(System.in);
String weather = scn.nextLine();

if ( weather.equals("very sunny") || weather.equals("raining") ) {
    // if it's raining or very sunny...
	System.out.println("Take an umbrella");
}
else if (weather.equals("snowing") ) {
    // otherwise, if it's snowing...
	System.out.println("Wear a hat!");
}
else {
    // otherwise...
	System.out.println("Good luck!");
}
```

---

template: switch-case
name: switch-case-7

## Using switch / case

Using switch/case would remove the need for boolean operations and provide more readable code.

```java
Scanner scn = new Scanner(System.in);
String weather = scn.nextLine();

switch (weather) {
    case "raining":
    case "very sunny":
        // if it's raining or very sunny...
        System.out.println("Take an umbrella!");
        break;
    case "snowing":
        // otherwise, if it's snowing...
        System.out.println("Wear a hat!");
        break;
    default:
        // otherwise...
        System.out.println("Good luck!");
}
```

---

name: ternary

# The Ternary Operator

--

## Concept

It is often the case that we use if/else statements to control setting the value of a variable.

```javascript
if (breakfastWasServed && breakfastWasEaten) {
  satiationLevel = "full";
} else {
  satiationLevel = "hungry";
}
```

--

The ternary operator, `?`, thankfully allows us to simplify such syntax:

--

```javascript
satiationLevel = breakfastWasServed && breakfastWasEaten ? "full" : "hungry";
```
---

name: example
## Example problems

Given the length of a rope and a distance it must span across (in inches), determine if the rope is sufficiently long. The rope will be tied into knots at each end and the knots will take 2 inches, so the "effective" length of rope is 4 inches less than the given length.


```java
public static boolean ropeLength(double ropeLength, double distance) {

















}
```
---

## Example problems

Given two numbers `x,y` determine the range between them, without using any built-in functions. That is, if `x > y` then return `y - x`, otherwise return `y - x`.

```java
public static int range(int x, int y) {
















}
```


---

## Example problems

Given three numbers determine if they form a right triangle or not (this is equivalent to detecting if the Pythagorean theorem applies to these three numbers.
First identify the largest number by checking, for each number, if the other two numbers are smaller than it, and then check if `x*x + y*y = z*z`.
```java
public static boolean isRightTriangle(int x, int y, int z) {















}
```

---
## Example problems

Write a function that checks if an input string is `"yes"` or `"ye"` or `"yup"` using a switch case. If it is one of those three inputs return true, otherwise return false.


```java
public static boolean isYes (String input) {



















}
```

---

name: conclusions

# Conclusions

--

You now have a basic understanding of UML activity diagrams, if/else if/else statements, and switch/case statements.

--

- Thank you. Bye.
