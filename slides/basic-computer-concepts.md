---
layout: presentation
title: Basic Computer Concepts
permalink: /slides/basic-computer-concepts/
---

class: center, middle

# Basic computer concepts

---

# Agenda

1. [Computers](#computers)
  - [Hardware](#hardware)
  - [Operating Systems](#operating_systems)
  - [Applications](#applications)
1. [Desktop Analogy](#desktop_analogy)
  - Files and good practices
1. [Networks](#networks)
1. [Conclusions](#conclusion)

???

Here is a quick outline of a minimal set of concepts which you must
familiarize yourself with immediately in order to be ready to learn to
be literate in usage of computers in general, not just for any given
course.


---


## Computers

Several levels:
- Computer hardware
- Operating system
- Applications


---

name: hardware
## Computer Hardware

CPU


Storage
- Memory
- Drives

Input
- Mouse
- Keyboard
- Camera
- Microphone

Output
- Video
- Speakers/Headphones

I/O
- Network


---

## Busses


Motherboard connect all of the components together via busses
- Playstation 5 traces are quite nicely visible (from [here](https://twitter.com/austinnotduncan/status/1578764005350338560/photo/1))
  - Most traces move between components and CPU
  - Both sides visible [here](https://youtu.be/CaAY-jAjm0w?t=295)
  - Interesting to look at [this teardown](https://www.ifixit.com/Teardown/PlayStation+5+Teardown/138280)

<img src="https://pbs.twimg.com/media/FejleAtXkAEEiDz?format=jpg&name=4096x4096" width=600 />

---


## CPU
Manages much of the data from busses
- Controls memory
- Can read and execute commands
- Modern processors schedule commands between multiple cores

<img src="https://pbs.twimg.com/media/FCvOcnYXIAInJhh?format=jpg&name=4096x4096" width=800/>

---

## Memory

Data is stored in a complex sequence of switches called _bits_

--

Computers work 8 bits at a time called a _byte_
- In many languages a "character" is 1 byte

--

It's the easiest place to store data in programs
- Variables and "state" are typically stored in memory
- CPUs have faster memory in "cache" (10x)
  - but humans are bad at managing them
- Drives can store much more, but are much slower (~1000x)

Cache < Memory < Disk

(numbers according to [Chandler Carruth in 2014](https://www.youtube.com/watch?v=fHNmRkzxHWs&t=2201))

---

## System-on-Chip

Some computers combine parts together
- Makes bus traces shorter
<p><a href="https://commons.wikimedia.org/wiki/File:Apple_M1.jpg#/media/File:Apple_M1.jpg"><img src="https://upload.wikimedia.org/wikipedia/commons/thumb/8/83/Apple_M1.jpg/1200px-Apple_M1.jpg" width="300" alt="Illustration of an M1 processor"></a><br>By &lt;a href="//commons.wikimedia.org/wiki/User:Henriok" title="User:Henriok"&gt;Henriok&lt;/a&gt; - &lt;span class="int-own-work" lang="en"&gt;Own work&lt;/span&gt;, <a href="http://creativecommons.org/publicdomain/zero/1.0/deed.en" title="Creative Commons Zero, Public Domain Dedication">CC0</a>, <a href="https://commons.wikimedia.org/w/index.php?curid=96026688">Link</a></p>

---
## System-on-Chip

Some computers combine parts together
<img src="https://cdn.arstechnica.net/wp-content/uploads/2020/11/Mac-M1-diagram.png"/>
<a href="https://arstechnica.com/gadgets/2020/11/apple-dishes-details-on-its-new-m1-chip/">ars technica</a>

---

name: operating_systems


## Operating systems


Sits between hardware and users
- Handles data input / output
- Schedules which software has access to different resources and when

Most provide more or less the same "basic" functionality but can have different
- code
- ethical principles
- communities

---

## Operating systems

![](https://raw.githubusercontent.com/EG-tech/digipres-posters/master/OS_kernel_timeline.jpg)


---

## Applications

Process data
- Multimedia
  - Input: file on disk/URL
  - Output: display on screen or play through speakers
- Games
  - Input: keyboard/mouse inputs
  - Output: display content to screen and audio through speakers
- File decompression
  - Input: file on disk
  - Output: one or multiple files/directories on disk
- Documents
  - Input: file on disk + keyboard/mouse inputs
  - Output: updated document


---

## Python example

read from keyboard input
```python
input_file = input("What file should I open?")
```
request a representation for a file on the drive
```python
with open(input_file,"r") as in_fd:
```
transfer data from disk to memory
```python
    lines = in_fd.readlines()
```
```python
    for line in lines:
```
modify the data in memory
```python
        line = line.lower()
```
output the data in memory to the screen
```python
        print(line)
```


---

name: desktop_analogy

## Desktop Metaphor
- How do computers store data?
 - All 0's and 1's, but we organize them using software so other software can derive meaning
 - We already had systems for organizing data at our desks, so we modeled off of them

<a href="https://www.youtube.com/watch?v=1UtlOgkOGy4"><img src="../../content/assets/apple_desktop.png" alt="drawing" width="350"/></a>
<a href="http://toastytech.com/guis/a2desk.html"><img src="http://toastytech.com/guis/a2calc.gif" width=350\></a>
  
.right[images are links to sources]


---

name: files_and_folders
## Files and folders

- Paper analogy
  - Files:

<img src="https://raw.githubusercontent.com/KDE/breeze-icons/master/icons/mimetypes/64/x-office-address-book.svg" \>
<img src="https://raw.githubusercontent.com/KDE/breeze-icons/master/icons/mimetypes/64/x-office-calendar.svg" \>
<img src="https://raw.githubusercontent.com/KDE/breeze-icons/master/icons/mimetypes/64/x-office-contact.svg" \>
<img src="https://raw.githubusercontent.com/KDE/breeze-icons/master/icons/mimetypes/64/x-office-document.svg" \>
<img src="https://raw.githubusercontent.com/KDE/breeze-icons/master/icons/mimetypes/64/x-office-drawing.svg" \>
<img src="https://raw.githubusercontent.com/KDE/breeze-icons/master/icons/mimetypes/64/x-office-presentation.svg" \>
<img src="https://raw.githubusercontent.com/KDE/breeze-icons/master/icons/mimetypes/64/x-office-spreadsheet.svg" \>

  - Folders / Directories:

<img src="https://raw.githubusercontent.com/KDE/breeze-icons/master/icons/places/96/folder-blue.svg" width="10%"\>
<img src="https://wiki.gnome.org/Apps/Files/Header?action=AttachFile&do=get&target=logo.png" width="10%"\>

.right[Icons from [KDE Breeze icon set](https://github.com/KDE/breeze-icons) and cabinet from [Gnome Nautilus](https://wiki.gnome.org/action/show/Apps/Files?action=show&redirect=Apps%2FNautilus)]

???

With the desktop analogy we have the paper analogy.
Traditionally we would store data on paper, and use folders and filing cabinets to store that data.
Directories were tools to help us look up files and folders.

Data on computers is stored in files, and files are organized together into folders and directories to organize the data.
You'd be surprised howe much of computer science comes down to how to organize data, and that's what CS102 is all about.


---

## Hiding Folders in Modern Operating Systems

Searching for files in folders on a computer is slow
-  "Indexers" make searching for files extremely fast

Modern systems prioritize a search bar to find files

Files and folders still exist underneath

---

## Types of files

We might think of there as being many types of files, associated with differenet applications

<img src="https://raw.githubusercontent.com/KDE/breeze-icons/master/icons/mimetypes/64/x-office-address-book.svg" \>
<img src="https://raw.githubusercontent.com/KDE/breeze-icons/master/icons/mimetypes/64/x-office-calendar.svg" \>
<img src="https://raw.githubusercontent.com/KDE/breeze-icons/master/icons/mimetypes/64/x-office-contact.svg" \>
<img src="https://raw.githubusercontent.com/KDE/breeze-icons/master/icons/mimetypes/64/x-office-document.svg" \>
<img src="https://raw.githubusercontent.com/KDE/breeze-icons/master/icons/mimetypes/64/x-office-drawing.svg" \>
<img src="https://raw.githubusercontent.com/KDE/breeze-icons/master/icons/mimetypes/64/x-office-presentation.svg" \>
<img src="https://raw.githubusercontent.com/KDE/breeze-icons/master/icons/mimetypes/64/x-office-spreadsheet.svg" \>

Underneath, there are two fundamental kinds of files:
- Text files
- Binary files.

--

Text files still use binary

---
## Text files

Lines of human-readable characters, potentially separated into lines
"Plain"
- No colors
- No formatting (italics/bold/etc)
- No images/media

Writing software (source code) almost always involve manipulating text files.

--

Easy to manipulate with a wide variety of software

---
## Creating and editing text files

Multi-platform
- Visual Studio Code
- [Vi](https://ex-vi.sourceforge.net/) ( [VIM](www.vim.org) , [NeoVim](neovim.io))
- [Emacs](gnu.org/software/emacs) 
- [Sublime Text](sublimetext.com) (free evaluation)
- [QtCreator](www.qt.io/product/development-tools)

Windows
- [Visual Studio](https://visualstudio.microsoft.com/)
- [Notepad++](https://notepad-plus-plus.org/)

OSX
- [XCode](developer.apple.com/xcode)
- [TextMate](macromates.com)

Language-specific
- [JetBrains](jetbrains.com) products (IntelliJ IDEA, PyCharm, CLion, etc...)
- [Eclipse](eclipse.org)

... and many more


---

## Encoding Text Files

- Text is "just" binary data
  - How do computers know what it means?
- Text files follow an encoding for what each character means
- Commonly:
  - ASCII ('A' = 65 = 1000001, 'B' = 66 = 1000010)
  - UTF-8
- Other common encodings (that I haven't personally handled)
  - [link](https://en.wikipedia.org/wiki/Character_encoding#Common_character_encodings)
- Different computers define new lines differently
  - [link](https://en.wikipedia.org/wiki/Newline#Representation)

---

## Examples of Text Files

Source Code
```java
class HelloWorld {
    public static void main(String[] args) {
        System.out.println("hello!");
    }
}
```
json
```json
{
    "class": "CSCI-UA-2022",
    "professor": "Michael Tao",
    "building": "GCASL",
    "room": 275
}
```
---

## Binary files
- There are many other ways to store data

 - Numbers (from wiki on float32)
<img src="https://upload.wikimedia.org/wikipedia/commons/thumb/d/d2/Float_example.svg/590px-Float_example.svg.png" width="60%"\>

 - Colors (from wiki on bitmap encoding)
<img src="https://upload.wikimedia.org/wikipedia/commons/4/48/BitfieldsSLN.svg" width="60%"\>
- Specialized software might choose their own custom data to a file.
  - Saves space
  - Faster/easier for computers to read
  - Makes it difficult to open files without the right software
- Examples:
  - Multimedia (.png/.jpg/.tif/.mp4) (not .svg!)
  - Programs (.exe)
  - Microsoft Office files (.docx/.xlsx/.pptx)

---

## Surprising Example of a Text File

```xml
<svg id="Layer_1" data-name="Layer 1" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 135 46" width="135" height="46">
  <path class="cls-1" d="M57.88,9.71h5.28l12.26,16v-16H81V35.78H76.1L63.5,19.08v16.7H57.88Z"></path>
  <path class="cls-1" d="M94,25.56l-10-15.85h6.64l6.3,10.56,6.3-10.56h6.46l-10,15.68V35.78H93.8V25.56Z"></path>
  <path class="cls-1" d="M112.19,24.7v-15H118V24.53c0,4.26,2,6.48,5.61,6.48s5.62-2.05,5.62-6.31v-15H135V24.53c0,7.84-4.43,11.76-11.41,11.76C116.44,36.29,112.19,32.37,112.19,24.7Z"></path>
  <path class="cls-1" d="M46,46H0V0H46V46ZM21.45,40.55c0,.34.68.51.85,0l1.53-12.78H19.92l1.53,12.78ZM25.2,26.92V25H18.56v1.88ZM23.32,24c8.34.34,9-7.32,9-10.22h0c-.17.68-1.37,2.73-4.43,4.09A7.38,7.38,0,0,0,23.32,24Zm-.85-.51c1.36-6.3,6.47-6.47,7-7.67.68-1.87-.68-5.28-1-5.62h-.17A11.15,11.15,0,0,1,25.54,14c-1,.85-5.45,4.26-3.07,9.54Zm-1,.34c-2.89-6,2.89-9.88,3.75-10.73.17-.17.17-.17.17-.34A15.55,15.55,0,0,0,24,7.33h-.17c-.51,1.87-3.06,4.6-3.57,5.28-4.43,5.11-3.41,8.35,1.19,11.24ZM20.26,24c-4.77-2.89-4.26-6.81-2.21-9.71V14a7.46,7.46,0,0,0-1.2-2.9c0-.17-.17-.17-.17,0,0,.86-1,2.9-2.38,5.12-1.36,2.38-1.36,7.66,6,7.83Z"></path>
</svg>
```

--

<a href="https://nyu.edu"><img src="../../content/assets/nyu.svg" alt="drawing" width="250"/></a>

--

```xml
<svg id="Layer_1" data-name="Layer 1" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 135 46" width="135" height="46">
  <path class="cls-1" d="M57.88,9.71h5.28l12.26,16v-16H81V35.78H76.1L63.5,19.08v16.7H57.88Z"></path>
  <path class="cls-1" d="M94,25.56l-10-15.85h6.64l6.3,10.56,6.3-10.56h6.46l-10,15.68V35.78H93.8V25.56Z"></path>
  <path class="cls-1" d="M112.19,24.7v-15H118V24.53c0,4.26,2,6.48,5.61,6.48s5.62-2.05,5.62-6.31v-15H135V24.53c0,7.84-4.43,11.76-11.41,11.76C116.44,36.29,112.19,32.37,112.19,24.7Z"></path>
</svg>
```

<img src="../../content/assets/nyu_words.svg" alt="drawing" width="250"/>

---




### Binary file editors


Images
- Raster (Pixel-based)
  - Photoshop (necessary for .psd files)
  - Gimp
  - Paint
- Vector (line/curve based)
  - Illustrator (necessary for .ai files)
  - Inkscape

Microsoft Office files
- Better buy Office
- Reverse engineered in OpenOffice / Google Workspace / Apple Pages
  - Occasional inconsistencies / issues
  - Missing features

PDF Files
- Better use Adobe software
- Reverse engineered in libpoppler (okular/evince) or OSX Preview 
  - Occasional inconsistencies / issues
  - Missing features


---

## Good File Naming Conventions

Try to use lowercase without spaces
```bash
file.zip
file.Zip
file.ZIP
FiLe.ZiP
```


Avoid spaces in file names.
```bash
important_document.js less_important_document.txt # 2 files
important document.js less important document.txt # 5 files?
```
--

Or follow whatever <a href="https://en.wikipedia.org/wiki/Naming_convention_(programming)#Examples_of_multiple-word_identifier_formats">conventions</a> your group, OS, or language uses.

---

## File extensions

How does your computer which software opens a file?
```bash
doc.docx
doc.cpp
doc.ai
doc.pdf
```

--

This is all a convention, it's up to software to detect inappropriate files

```python
for filename in ["doc.docx", "doc.cpp", "doc.ai", "doc.pdf"]:
    with open(filename, "r") as fd
        print(fd.readlines())
```

--

Computer manages a list of default extensions

---

## File permissions

Computers are all designed by multiple "users"
- The computer itself
- Administrators
- Normal users

--

Every file and folder controls who can read/write/execute a file

- user: the user who 'owns' the file or folder... every file or
  folder is owned by one user
- group - a group of users who assigned to
  the file or folder
- others - everyone else not including the user or
  the group

---



## Software is Input/Output


Inputs:
- Files
- User Inputs
  - Mouse
  - Keyboard
  - Microphone
  - Camera
- Network data
Outputs:
- Files
- Visuals (through monitors/screens)
- Sound (through headphones/screens)
- Network data

---

## The Environment

Software needs some context for how it should run

- Arguments
  - The input data that the user provided
  - Which input files/locations to open
  - What data should be generated?
  - Where/how should that be data stored?

--

- Working Directory
  - Software is run from a particular directory for user convenience
  - "Relative paths"

--

- Environment variables
  - Other data that the user or operating system has set
  - Which type of output is available
  - what encoding data comes in
  - what other software to use


---

## Networks

Modern computer usage errs away from files on disks

--

- Majority of computation is done on the internet

--

- How does that work?


---

## Clients and servers

Our computer ("client") prepares messages and sends it through cable or wifi to a remote destination according to an address.
- https://google.com
  - Protocol: https
  - Location: google.com

--

A computer ("server") reads the message and returns an output message
- contents of the webpage "https://google.com"

---

## Web browsers

Client for interacting with web data

For a user on a client computer:
- Input: a URL / link, clicks a link, interacts with a webpage

- Output: Visualizes web page data according to the action


For a remote server computer:
- Input: A request for a webpage using the [HTTP](http://en.wikipedia.org/wiki/Hypertext_Transfer_Protocol) or
HTTPS protocol.
- Output: [HTML](https://en.wikipedia.org/wiki/HTML) data sent with the HTTP/HTTPS protocol.

--

This input/output relationship is complex due to programs that run in web browsers
- Almost an operating system of its own (i.e Chrome OS)

---

## The internet vs. the web

Just like binary files, html is just one encoding of data
Internet transfers all sorts of data



- ([IMAP](http://en.wikipedia.org/wiki/Internet_Message_Access_Protocol)
and [POP](http://en.wikipedia.org/wiki/Post_Office_Protocol) protocols),
file transfer
- ([FTP](http://en.wikipedia.org/wiki/File_Transfer_Protocol) and [SSH](http://en.wikipedia.org/wiki/Secure_Shell) protocols),
- [VoIP](http://en.wikipedia.org/wiki/Voice_over_Internet_Protocol),
streaming media such as webcams and internet radio, and
- [P2P](http://en.wikipedia.org/wiki/Peer-to-peer) file sharing
- ([RTP](http://en.wikipedia.org/wiki/Real-time_Transport_Protocol)
protocol and other proprietary protocols)
- etc


---

## Conclusion

An idea for how components of a computer operate

A more general view of what files on a computer are

A brief overview of the internet connections

