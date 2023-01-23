---
layout: presentation
title: Basic Computer Concepts
permalink: /slides/basic-computer-concepts/
---

class: center, middle

# Basic computer concepts

---

# Agenda

1. [Desktop Analogy](#desktop_analogy)
1. [Exception Handling](#handling)
1. [Custom Exceptions](#custom)
1. [Conclusions](#conclusions)

???

Here is a quick outline of a minimal set of concepts which you must
familiarize yourself with immediately in order to be ready to learn to
be literate in usage of computers in general, not just for any given
course.


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

## Hiding Folders

- Searching for files in folders on a computer is slow
 - "Indexers" make searching for files extremely fast
- Modern systems prioritize a search bar to find files
- Files and folders still exist underneath 

---

## Types of files

- We might think of there as being many types of files, associated with differenet applications

<img src="https://raw.githubusercontent.com/KDE/breeze-icons/master/icons/mimetypes/64/x-office-address-book.svg" \>
<img src="https://raw.githubusercontent.com/KDE/breeze-icons/master/icons/mimetypes/64/x-office-calendar.svg" \>
<img src="https://raw.githubusercontent.com/KDE/breeze-icons/master/icons/mimetypes/64/x-office-contact.svg" \>
<img src="https://raw.githubusercontent.com/KDE/breeze-icons/master/icons/mimetypes/64/x-office-document.svg" \>
<img src="https://raw.githubusercontent.com/KDE/breeze-icons/master/icons/mimetypes/64/x-office-drawing.svg" \>
<img src="https://raw.githubusercontent.com/KDE/breeze-icons/master/icons/mimetypes/64/x-office-presentation.svg" \>
<img src="https://raw.githubusercontent.com/KDE/breeze-icons/master/icons/mimetypes/64/x-office-spreadsheet.svg" \>

- Underneath, there are two fundamental kinds of files:
 - Text files
 - Binary files.

--
- Text files still use binary

---
## Text files

- Lines of human-readable characters, potentially separated into lines
- "Plain"
 - No colors
 - No formatting (italics/bold/etc)
 - No images/media
- Easy to manipulate with a wide variety of software
  - Notepad
  - VI/VIM/Neovim
  - Sublime Text
  - VSCode
  - Eclipse
- Writing software (source code) almost always involve manipulating text files.

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


## Creating and editing files

### Code files are text files

Files for writing computer programs are usually created and edited on
your personal computer. Text files, including any source code you write
in a high level programming language, are created and edited using a
simple [text editor](http://en.wikipedia.org/wiki/Text_editor), a
program that deals exclusively with text files.

### Text editors edit only text

Two good quality free to use text editors for Windows or Mac are
[Sublime Text](https://www.sublimetext.com/) and [Visual Studio
Code](https://code.visualstudio.com/).

An amazing free/libre text editor that comes pre-installed on most Unix
and Linux machines is [emacs](https://www.gnu.org/software/emacs/).
Another popular option for \*NIX machines is
[vim](<https://en.wikipedia.org/wiki/Vim_(text_editor)>).

The text editors that typically come with computers, such as Notepad on
Windows and TextEdit on Mac, are generally not good quality text editors
and should be avoided at all costs.

Word processing software like Microsoft Word and Apple Pages are not
text editors at all - they write much more than plain text data into the
files they save, including formatting instructions, image rendering
data, and other non-text data.

### Binary file editors

The software used to create or edit binary files depends on the sub-type
of binary file. For example, we typically use software such as [Adobe
Photoshop]https://knowledge.kitchen/Category:Photoshop) or [Adobe
Illustrator]https://knowledge.kitchen/Category:Illustrator) when dealing with image
files and audio editing software such as
[Audacity](https://knowledge.kitchen/Category:Audio) when editing audio files.

## File names

In today's world of inter-networked computers, it's important to
follow some basic 'lowest common denominator' file naming conventions
to make sure your files work equally well on whatever type of computer
they happen to be copied to.

**Capitalization**. File names are case-sensitive on \*NIX-based
systems. Windows and Mac systems use filenames that are sometimes
case-sensitive and sometimes not. So, as a general rule, it's best to
assume that the capitalization of your file names is important. A file
named **Foo.bar** is not the same file as one named **foo.bar** on most
computers. So, as a general rule, do not use capital letters in your
file names, except where absolutely necessary. End of story.

**Spaces and special characters**. Operating systems are inconsistent in
how they treat spaces. Even a single type of operating system will be
inconsistent in how its different versions treat spaces in file names.
Even a single computer may be inconsistent between how its GUI treats
spaces vs. how its command-line shell treats spaces. For this reason, do
not use spaces at all in the name of any file you make.

The same applies to special characters. Besides alphabetic and numeric
characters, do not use any special character except the underscore `_`
character and the period `.` character.

## File extensions

As sophisticated computer users, we must always know the exact names of
the files we are dealing with.

A [file extension](http://en.wikipedia.org/wiki/Filename_extension) is
simply a suffix attached to the name of a file. For example, an image
file named "monkey" may have an extension named ".jpg" to indicate
the sub-variety of image data that is stored in the file. So the
complete file name, as far as the operating system is concerned, would
be"monkey.jpg". UNIX, Windows, and Mac each support using file
extensions. Recent versions of Windows and Mac OS X operating systems
hide extensions from you by default. But be warned - the file extension
might be there! To use a computer effectively, you must [change your
operating system's settings so that file extensions are always
visible](File_extension_settings_under_Windows_and_Mac).

The extension typically indicates to the operating system what type of
data is in the file. So image files typically have ".jpg", ".gif",
or ".png" extensions, which indicate the sort of binary image format
which was used to create the image file. Text files written in HTML code
typically have a ".html" or ".htm" file extension, and text files
written in Java usually have a ".java" extension appended to their
file name, etc.

### Default applications for file extensions

The operating system may be programmed to 'know' what to do with a
file when it is double-clicked or executed based on this extension.
However, what the operating system thinks is the correct action to take
on a file when double-clicked is not necessarily the action you as an
expert computer user will want it to take. So you should open files in
the applications you deem correct, rather than accepting what the
operating system thinks is correct.

## File permissions

The file systems on all popular operating systems implement permissions
that restrict who can read, write, and execute any given file or folder.
In general, permissions are granted to three different classes of
potential users:

- user: the user who 'owns' the file or folder... every file or
  folder is owned by one user
- group - a group of users who assigned to
  the file or folder
- others - everyone else not including the user or
  the group

File permissions can be adjusted either through the options in the [file browsing application](#browsing-files)
of an operating system's [Graphical User
Interface](https://knowledge.kitchen/Popular_operating_systems_and_trends#Graphical_User_Interface),
such the 'Properties' context menu in Windows Explorer on Windows or
the 'Info' context menu in Finder on Mac, or [through the UNIX command
line](https://knowledge.kitchen/Basic_UNIX/Linux_file_management#Change_permissions_of_any_file_or_directory).

## Compressed files

There is often a need to reduce the size of files, meaning reducing the
number of bits in them. This might be done in order to preserve limited
hard-drive space, or to make files faster to download over a slow
network connection. There are many different [compression
algorithms](https://en.wikipedia.org/wiki/Data_compression) that are
specialized for reducing the file size of specific kinds of files:
images, videos, music, etc. And there are other algorithms that offer
general-purpose compression that is pretty good for all types of files.
Each of these algorithms takes the original file, compresses the data in
it, and saves this new compressed data into a new file, usually adding a
file extension that indicates which type of compression was used.

Common compression formats:

\- Zip files are one such type of general-purpose compressed type of
file. It is capable of compressing many files and even folders into a
single, smaller, file. This zipped file usually has the .zip file
extension. Most [operating
systems](https://knowledge.kitchen/Popular_operating_systems_and_trends) come built in
with software to create zip files. - There are several very common
compression formats for raster images published on the web, such as
JPEG, GIF, and PNG. These usually have the file extensions .jpg, .gif,
and .png, respectively. - Music is very often compressed using the
mediocre MPEG 3 algorithm, leading to files with .mp3 file extensions. -
Video compression formats include MPEG 4 (.mp4), Quicktime (.mov),
Windows Media (.wmv), and many others.

### Lossy compression

In the process of reducing the amount of space the data takes, some
compression algorithms will actually cut out and lose parts of the data.
These are known as [lossy
compression](https://wikipedia.org/Lossy_compression) formats. Lossy
compression, by its nature, leads to a lower fidelity reproduction of
the original data. Examples of lossy compression algorithms are MP3 and
JPG and many other popular audio, video, and image compression formats.

Lossy compression might be valuable when reducing file size is more
important than maintaining fidelity. For example, an audio track
streamed from web service to a consumer might use lossy compression to
reduce the file size and increase the speed with which the user can
download the audio to their own device. According to the research of
[psychoacoustics](https://en.wikipedia.org/wiki/Psychoacoustics#Limits_of_perception),
an audio track may contain audio data that a human is not possible of
perceiving - this data can thus be safely removed, reducing the amount
of data that needs to be transferred, without the risk of the human
noticing the difference.

### Lossless compression

In some cases, it is undesirable to lose any of the data in the original
medium. In these cases, a variety of [lossless
compression](https://wikipedia.org/Lossless_compression) algorithms are
available. An example of a lossless compression format is the ZIP
format. Zipping up files does not lose any of their data. PNG and GIF
are lossless raster image compression formats, and many others in the
world of audio, video, and image compression exist as well.

### Lossiness versus quality

When it comes to audio, video, and imagery, where exact replicas of
original content are not necessary, bear in mind that lossless
compression, perhaps counterintuitively, does not always equate to
higher quality. For example, converting a highly detailed image from a
digital camera to a low bit-depth but lossless format, such as GIF, will
always make the image appear lower quality than converting to a lossy
but higher bit depth compression format, such as JPG. And removing data
from a media file that is imperceptible from a human will not lead to a
perceived loss of quality, whereas slower download of streaming video or
audio leading to interruptions of the sound or video feed most certainly
will.

Conversely, when retaining the integrity of the data is of utmost
importance, a lossless compression format is the only choice. For
example, when sending files over a network from one computer to another,
such as sharing a written document or a folder full of documents, a
lossless compression such as ZIP, will always be preferable to lossy
compression where some of the data gets lost along the way and the files
become corrupted and unusable.

## Operating systems

[Operating systems](https://knowledge.kitchen/Popular_operating_systems_and_trends)
define the ways in which you, the human, access the resources available
on a computer. And they also make sure that the hardware resources of
the computer are shared nicely among all the different programs that are
running. Personal computers generally have one of three flavors of
operating system: Mac OS X, Windows, or a variety of UNIX/Linux
(sometimes written collectively as \*NIX). Each provides more or less
the same functionality for our purposes, but do so in slightly different
ways.

If you ever become a software developer, you may have to deal, at some
point, with each of these types of operating systems. Most web servers,
which are the computers where you store websites, such as the computer
which stores this site, run a variety of
[UNIX](http://en.wikipedia.org/wiki/Unix). Most people who use the
internet do so on personal computers running [Microsoft
Windows](http://en.wikipedia.org/wiki/Microsoft_windows). Apple Macs,
which are generally more expensive than Windows computers, use the
operating system [OS X](http://en.wikipedia.org/wiki/Mac_OS_X), and are
used by a small but significant minority or internet users, including a
large proportion of design professionals. Most people accessing the
internet on mobile devices use Google's [Android operating
system](<https://wikipedia.org/Android_(operating_system)>), a variant of
Linux, with most other mobile users having Apple's [iOS operating
system](https://wikipedia.org/iOS), a variant of OS X.

The computer you are using right now to view this document is, I am 99%
sure, a personal computer running Windows or OS X. If you"re, in fact,
using UNIX or Linux right now, you are an unusual character.

## Applications

Applications are simply programs that depend upon on a particular
operating system in order to be able to run. For example, Microsoft Word
is an application that requires a specific operating system to run.
There is a version of Microsoft Word for Mac OS X and another version of
Microsoft Word for Windows 10. Since each operating system has a
slightly different GUI and a slightly different way of handling the
hardware resources of the computer, the applications have to be created
with a specific operating system in mind in order to be able to take
advantage of those features of the operating system.

## Browsing files

On your personal computers, you will often have to find the files you
downloaded, created, or copied so that you can use them or edit them.
Finding files (and losing them) is a big problem for the typical person,
even those who use computers every day. But if you have organized your
files into clearly labeled folders, and understand the structure of the
computer"s file system, managing files will be a simple job.

Finding files is basically the same, whether you are using Windows or
Mac OS X. [Windows
Explorer](http://en.wikipedia.org/wiki/Windows_Explorer) is the tool you
use on a Windows PC. [Mac
Finder](http://en.wikipedia.org/wiki/Finder_29) is the tool you use on a
Mac OS X computer.

Files are stored on a computer hierarchically. What this means is that
files on the computer are organized in folders, and these folders can be
put into other folders. Mac Finder illustrates this nicely:

![Mac Finder shows the hierarchy of
folders](./content/images/basics/Picture-1-300x127.png "Mac Finder shows the hierarchy of folders")

In this screenshot of Mac Finder, you can see that each folder on a
drive can contains several sub-folders, and those sub-folders can
contain their own sub-folders. Files can be stored within any folder,
even if that folder also contains other sub-folders as well.

Windows Explorer looks very similar. All folders and files are nested
inside of a drive just as in the Mac. Although it is less intuitive, the
concept behind Windows Explorer is the same as with Mac Finder: it
allows you to navigate through folders within folders within folders" a
filing cabinet metaphor being stretched thin"

## Opening files

When you double-click a file on a standard computer, the operating
system reads the file's extension, and uses that to determine which
Application it should run in order to open the file you clicked on. In
order to do this, the operating system keeps a mapping of which file
extensions are used by each Application. For example, if you
double-click a file ending in .docx, a computer that has Microsoft Word
installed on it will most likely open that file in Microsoft Word,
because the operating system has a mapping between the file extension
.docx and the application Microsoft Word.

Very often, as an educated computer user, you want to open a file in a
different Application than what the operating system launches by
default. The solution to this is simple - stop double-clicking files
that you want to open! Rather, open the application that you want to use
first. Then, from within that application, open the file you're
interested in by using the application's File menu.

## The working directory

When browsing files on a hard drive, only one directory on your file
system is being actively looked at at any given time. This is known as
your "current working directory", or just "working directory". This
is the case whether you are browsing the files on your hard drive using
the command line, a graphical user interface, or a program you've
written.

## Clients and servers

### in general

The terms "client" and "server" are often used to describe the roles
of any two computers that are communicating with one-another on a
network. A client computer requests data from a server computer. A
server serves data to a client.

These roles can switch. A computer that is a client one minute, may
become a server the next minute, and vice versa.

![client and server](./content/images/basics/Client_and_server_diagram.png)

### on the web

Your personal computer, the one you use to browse the web and read this
amazing site, is often called a
'[client](http://en.wikipedia.org/wiki/Client_29)'. This term is used
to differentiate your desktop computer or mobile device from the web
'[servers](http://en.wikipedia.org/wiki/Server_29)' that permanently
store the web pages (which are simply [text files](./text-files) with [ HTML
code]https://knowledge.kitchen/Category:HTML) in them) that you visit.

Web servers make the data stored on them available to the public by
allowing any other computer to connect to them and ask for the files.
Your personal computers probably don't give your files to anonymous
creeps on the Internet (euphemistically called
['others'](#file-permissions) internally on the server), so
it does not usually act as a web server, although it could be set up as
one.

This website, like all other websites, consists of a bunch of data
stored on a web server. Servers are computers dedicated to hosting and
serving data when they are requested by clients. Thus the [World Wide
Web](https://en.wikipedia.org/wiki/World_Wide_Web), at a high level, is
composed of two types of computers: clients and servers.

### hardware vs software clients

The [software products you use to connect to
servers](#Web_browsers) are also sometimes referred to as
clients. Thus the term client can either refer to the computer you use
to request data from a server, or the particular software product you
use to do so, depending on the context of the conversation. The point
being that the client is the "thing" you use to access the content
available on the server.

### uploading and downloading

- Uploading is the transfer of data from a client to a server
- Downloading is the transfer of data from a server to a client

### A note about peer-to-peer networks

There are some situations, such as with [Peer-to-peer file
sharing](http://en.wikipedia.org/wiki/Peer-to-peer_file_sharing), where
any given computer simultaneously acts as both client and server. Even
in such circumstances, we generally talk about each computer as working
either as a client or a server, depending on the context of the
discussion.

### in sum

Servers "serve" files to clients. Clients request a particular web
page file from the server, and the server responds with the contents of
that file.

![peer-to-peer](./content/images/basics/Peer_to_peer_network_diagram.png)

## Web browsers

A web browser is a piece of software that runs on the client computer.
It allows the user of the client machine (i.e. _you_) to browse files
(i.e. web pages) that are stored on web servers (i.e. computers)
connected to the Internet and [made available to anyone to
view](https://knowledge.kitchen/Basic_UNIX/Linux_file_management#Change_permissions_of_any_file_or_directory).

## The internet vs. the web

The [internet](http://en.wikipedia.org/wiki/Internet) and the
[web](http://en.wikipedia.org/wiki/World_Wide_Web) are two separate but
related things.

The "internet" refers to the global network of interconnected
computers. It is the infrastructure that allows computers around the
globe to communicate with each other.

The "web" refers to the vast number of interlinking
[hypertext](http://en.wikipedia.org/wiki/Hypertext) documents that exist
on the internet. Thus the web generally refers to only those parts of
the internet that are accessible via the
[HTTP](http://en.wikipedia.org/wiki/Hypertext_Transfer_Protocol) or
HTTPS protocol.

The web is just one usage of the internet, and HTTP is just one of many
protocols supported by the internet. Other technologies that rely upon
the internet but are not directly related to the web include email
([IMAP](http://en.wikipedia.org/wiki/Internet_Message_Access_Protocol)
and [POP](http://en.wikipedia.org/wiki/Post_Office_Protocol) protocols),
file transfer
([FTP](http://en.wikipedia.org/wiki/File_Transfer_Protocol) and
[SSH](http://en.wikipedia.org/wiki/Secure_Shell) protocols),
[VoIP](http://en.wikipedia.org/wiki/Voice_over_Internet_Protocol),
streaming media such as webcams and internet radio, and
[P2P](http://en.wikipedia.org/wiki/Peer-to-peer) file sharing
([RTP](http://en.wikipedia.org/wiki/Real-time_Transport_Protocol)
protocol and other proprietary protocols), among others.
