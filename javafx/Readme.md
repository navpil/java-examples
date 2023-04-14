# JavaFX

JavaFX was removed from Java SE and is now a separate module called OpenFX.

It's not particularly active, but it still works.

Please note - Swing is still a part of Java SE distribution.

Personal note: Java is predominantly a server side language, but if you want to write some basic Frontend in Java, 
Swing would be a safer option.

## How to run

In order to run the programs, use the maven plugin:

    mvn javafx:run

There are two Main classes:

 - JavaFXTest
 - FXMLTableView

These are configured directly in the `pom.xml` file.

## Other

A nice article about state of Frontend development in Java (it's actually a series):

 - https://blog.frankel.ch/state-jvm-desktop-frameworks/1/