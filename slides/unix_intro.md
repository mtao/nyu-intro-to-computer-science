---
layout: presentation
title: Intro to Unix commands
permalink: /slides/unix-intro/
---

class: center, middle

# Basic UNIX Commands

for those who don't know

---

# Agenda

1. [Assumptions](#assumptions)
1. [Navigating with \*NIX](#navigation)
1. [Managing files](#files)
1. [Permissions](#permissions)
1. [Running Java](#java)
1. [Conclusions](#conclusions)

---

name: assumptions

# Assumptions

---

# Assumptions

## Ability to run \*NIX commands

In order to run Unix or Linux commands, you will need a terminal emulator:

- OS X users already have the Terminal app we will use for this purpose.
- Windows users must have [WSL](https://learn.microsoft.com/en-us/windows/wsl/install) or [Git for Windows](https://gitforwindows.org/) installed.

---

name: navigation

# Navigating with \*NIX

---

# Navigating with \*NIX

## Overview

Unix commands are necessary in order to be able to navigate directories/folders in a UNIX-like system.

- all Unix commands are run in the command-line interface, such as that offered by Terminal on OS X or Git Bash on Windows.

<!--Review [basic Unix commands](./unix-intro).-->

---

# Navigating with \*NIX

## Where am I?

At any point in time, you are actively within one specific directory, known as the current working directory. To determine which directory that is at any point, run the `pwd` command:

```bash
foo@bar$ pwd
/Users/foo
```

It's fine to read about this, but you'll learn better if you try it out yourself.

Read more about the [current working directory](https://nyu-python-programming.github.io/course-material/basic-computer-concepts#the-working-directory).

---

# Navigating with \*NIX

## How do I go up one level

To navigate up one level in the directory structure of your hard drive, use the `..` shortcut no matter where you currently are.

```bash
foo@bar$ pwd
/Users/foo
```

```bash
foo@bar$ cd ..
foo@bar$ pwd
/Users
```

```bash
foo@bar$ cd ..
foo@bar$ pwd
/
```

We have now navigated to the root directory, represented by the symbol `/`.

---

# Navigating with \*NIX

## How do I get to the top?

To navigate to the top-most directory of your hard drive, known as the "root directory", use the `cd` command with the `/` symbol indicating root directory as the desired destination.

```bash
foo@bar$ cd /
foo@bar$ pwd
/
```

The current working directory is now the root directory.

---

# Navigating with \*NIX

## How do I see what directories and files are within the current working directory?

Use the `ls` command to show non-hidden files and directories that are within the current working directory.

```bash
foo@bar$ ls
dir1    dir4    file2
dir2    dir5
dir3    file1
```

This listing contains a mix of files and directories - there is no way to tell which is which simply based on their names. In order to distinguish between them, we need some metadata on each item in this listing.

---

# Navigating with \*NIX

## How do I see what hidden directories and files are within the current working directory?

Hidden files and directoriess simply begin with the '.' character. To view a listing of files and directories including them, use the `a` flag on the `ls` command.

```bash
foo@bar$ ls -a
.hidden_dir1    dir1    dir4    file2
.hidden_dir2    dir2    dir5
.hidden_file1   dir3    file1
```

Both files and directories may be hidden by naming them prefixed with a period,`.`.

---

# Navigating with \*NIX

## File listing with metadata

To view a listing of files and directories including metadata about each item, use the `l` flag on the `ls` command.

```bash
foo@bar$ ls -a
drwx------+ 10 foo  bar   320 Sep  4 10:41 dir1
drwx------+ 19 foo  bar   608 Aug 30 21:38 dir2
drwx------+  8 foo  bar   256 Nov 27  2017 dir3
drwx------+  4 foo  bar   128 Dec 31  2016 dir4
drwx------+ 19 foo  bar   611 Aug 21 21:38 dir5
-rwx------+ 10 foo  bar   320 Sep  4 10:41 file1
-rwx------+ 19 foo  bar   608 Aug 30 21:38 file2
```

To include hidden files in the listing, combine the `-l` and `-a` flags.

```bash
foo@bar$ ls -la
...
```

---

# Navigating with \*NIX

## What does all that metadata mean?

```bash
foo@bar$ ls -a
drwx------+ 10 foo  bar   320 Sep  4 10:41 dir1
drwx------+ 19 foo  bar   608 Aug 30 21:38 dir2
drwx------+  8 foo  bar   256 Nov 27  2017 dir3
drwx------+  4 foo  bar   128 Dec 31  2016 dir4
drwx------+ 19 foo  bar   611 Aug 21 21:38 dir5
-rwx------+ 10 foo  bar   320 Sep  4 10:41 file1
-rwx------+ 19 foo  bar   608 Aug 30 21:38 file2
```

The metadata included in a long listing of files and directories in the working directory indicates a few different things, including:

- directories are indicated by a `d` at the beginning of the line, files show `-` instead.
- the user who owns each of the items can read, write and execute each of them, indicated by the `rwx` letters in each line. No other users can do any of these things with these items.
- the single user `foo` owns all these items
- the group of users named `bar` owns all these items

---

# Navigating with \*NIX

## How do I drill down?

To navigate to sub-directory that is within the current directory, use the `cd` command with the name of the sub-directory that is the desired destination.

```bash
foo@bar$ cd bar
foo@bar$ pwd
/bar
```

Note that writing `cd /bar`, with the forward slash, would navigate to a directory named `bar` that is a sub-directory of the root directory, if any such directory exists, which is not what you wanted.

You can, of course drill down several levels of directories at once.

```bash
foo@bar$ cd bar/baz/blue
foo@bar$ pwd
/bar/baz/blue
```

---

# Navigating with \*NIX

## How do I jump to a directory from anywhere

If you kmow the full path of a directory to which you want to navigate, type it after the `cd` command.

```bash
foo@bar$ pwd
/bar/baz/blue
foo@bar$ cd /Users/foo/Documents/my_favorite_ice_cream
foo@bar$ pwd
/Users/foo/Documents/my_favorite_ice_cream
```

---

name: files-and-folders

# Managing files and folders

---

# Managing files and folders

## Create a blank new file

The `touch` command is useful for creating a blank file with a given name.

```bash
foo@bar$ touch environmental_cosmetology.txt
```

To open up this new file in the notorious `emacs` command-line text editor:

```bash
foo@bar$ emacs environmental_cosmetology.txt
```

---

# Managing files and folders

## Rename or move a file

Renaming is a variety of moving, using the `mv` command to move a file from one name to another.

```bash
foo@bar$ mv environmental_cosmetology.txt ecdp.txt
```

Or keep its current name, but move it to an entirely different directory:

```bash
foo@bar$ mv environmental_cosmetology.txt /Users/foo/Documents/
```

Or rename it and move it to an entirely different directory up two levels and down from there into a subdirectory named `baz`:

```bash
foo@bar$ mv /Users/foo/Documents/environmental_cosmetology.txt ../../baz/ecdp.txt
```

---

# Managing files and folders

## Delete a file

The `rm` command deletes files.

Delete a file in the current working directory:

```bash
foo@bar$ rm heme_rich_foods.csv
```

Delete a file in a sub-directory of the current working directory:

```bash
foo@bar$ rm meat/fillers/heme_rich_foods.csv
```

Delete a file in a subdirectory of the root directory:

```bash
foo@bar$ rm /meat/fillers/heme_rich_foods.csv
```

---

# Managing files and folders

## Delete a directory

The `rmdir` command deletes empty directories, while the `rm` command can be used to delete non-empty directories.

Delete an empty sub-directory named `meat`:

```bash
foo@bar$ rmdir meat
```

Delete a non-empty directory with the `r` and `f` flags of the `rm` command:

```bash
foo@bar$ rm -rf meat
```

---

# Managing files and folders

## Create a directory

The `mkdir` command creates an empty directory.

Make a new sub-directory named `vegetables`:

```bash
foo@bar$ mkdir vegetables
```

Make a sub-directory of the parent directory:

```bash
foo@bar$ mkdir ../arugula
```

Make a new directory somewhere totally different on the hard drive:

```bash
foo@bar$ mkdir /Users/foo/Photos/compromising/nudes
```

---

# Managing files and folders

## Create multiple directories

The `mkdir` command by default will only create one directory at a time.

The `-p` flag allows it to create a series of directories and sub-directories in one command, e.g.:

```bash
foo@bar$ mkdir -p vegetables/arugula/baby
```

---

name: permissions

# Permissions

---

# Permissions

## Users

It is possible to control who can access any file or folders.

Users who have access to a file or folder fall into one of three categories:

- an individual user who "owns" the file or directory
- a group of users who collectively have access to the file or directory
- everyone else

---

# Permissions

## Access types

There are three types of access to a file or foldeer:

- read
- write
- execute

---

# Permissions

## Example

```bash
-rwxr-xr--+ 10 foo  bar   320 Sep  4 10:41 file1.sh
```

Given the file metadata above, we can see the following permission settings:

- the user who owns the file, named `foo` can read, write and execute the file.
- the group who owns the file, named `bar` can read and execute the file, but cannot write to it.
- everyone else can only read the file, but not write or execute it.

---

# Permissions

## Revoke permissions

Revoke permissions with the `-` sign. In this case we revoke the user `foo`'s execute permission:

```bash
foo@bar$ chmod u-x file1.sh
```

---

# Permissions

## Grant permissions

Grant permissions with the `+` sign. In this case we grant the group `bar` write permission:

```bash
foo@bar$ chmod g+w file1.sh
```

---

# Permissions

## Others

All other users besides the user and group who own the file are known as 'others' and can have permissions granted or revoked as well:

```bash
foo@bar$ chmod o+wx file1.sh
```

---

name: java

# Running Java

--

## Directory structure

A well-organized Java project might consist of a project directory with at least 3 sub-directories:

```bash
project-directory/
       |
       |----------> src/
       |
       |----------> lib/
       |
       |----------> bin/
```

--

- **src/** - holds the Java source code files

--

- **lib/** - holds any dependencies (i.e. external libraries your code refers to)

--

- **bin/** - holds compiled Java byte code files

---

template: java

## Compiling

Before a Java project can be run, any Java source code in the `src/` directory must be compiled into Java byte code in the `bin/` directory.

--

Assuming the current working directory is the project directory:

```bash
foo@bar$ javac -d bin src/foo/bar/SomeFile.java
```

--

- `javac` is the Java compiler command.

--

- This command would produce a Java byte code file, `SomeFile.class` in the `bin/foo/bar/` sub-directory.

---

template: java

## Executing

To run the Java project, you can execute the Java byte code file in the `bin/` directory.

--

Assuming the current working directory is the project directory:

```bash
foo@bar$ java -cp bin foo.bar.SomeFile
```

--

- `java` is the Java runtime engine that executes Java programs.

--

- the `-cp bin` flag indicates that Java should add the `bin/` directory to the "classpath" - the list of directories where Java looks for executables

--

- `foo.bar.SomeFile` is the complete name of the code to execute, including any **package** name (e.g. `foo.bar`) and the file name without the extension (e.g. `SomeFile`).

---

name: conclusions

# Conclusions

--

- We can now do basic file management on the UNIX command line.

--

- Thank you. Bye.
