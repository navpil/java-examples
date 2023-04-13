# Nashorn

JSR 223

Replaces Rhino engine and uses the invokedynamic (introduced in Java 7, 2011)

Rhino was introduced in Java 6 (2006).

Node.js comes only in 2009

## CLI tools

jjs and jrunscript

`jjs` is for JavaScript only, `jrunscript` supports many other languages including Java itself in case you have the engine

### JJS

If `jjs` is ran without arguments you get the nashorn REPL shell with Java interop.

    Java.type("java.util.HashMap")

You can load scripts from shell:

    D:\projects\testapps\java-tutorial\common\src\main\resources\ua\lviv\navpil\scripts> jjs
    
    jjs> load("factorial.js")
   
You may use some es6 with the -language=es6 flag, though not all (generator functions are not implemented even in Java 10)

### JJS -scripting

`jjs` can run scripts, also in -scripting mode or `jjs` can be used in shebang (`#!/bin/jjs`) line for scripts (`-scripting` is implied then)

    D:\projects\testapps\nashorn>jjs -scripting script.js -- Dima
    
    dmytro-mint ~/projects/testapps/nashorn> ./script.js Dima
    
### JJS -fx

Special support for JavaFX

    D:\projects\testapps\nashorn>jjs -fx fxscript.js

### jrunscript

It is experimental and unsupported. Different supported scripts can be found here:

    https://github.com/scijava/javax-scripting
    
Examples:

    D:\projects\testapps\javax-scripting\engines\scheme\bin>scheme.bat Script.scheme
    
    D:\projects\testapps\javax-scripting\engines\java\bin>java.bat Script.java Dima

Yes, you can write scripts in Java. How to call it then? Isn't it true JavaScript?

## Programmatic interface

There is a quite good interoperability between JavaScript and Java.

    ua.lviv.navpil.script.CallJs

### Calling JavaScript    
 
 - Direct evaluation
 - Loading the .js file through direct evaluation
 - Loading through the reader

You can call methods through the Invokable interface. You can even call methods on JavaScript objects.

### Other languages support

SPI mechanism

    ua.lviv.navpil.script.JavaScript
    
Look inside jars:
    
    lib/jruby.jar

## Use cases

Why do I actually need it?

1. CLI in Javascript
2. Shared code between Server and Client
3. Dynamic code reload
4. Other (any other JavaScript/Java interoperability for whatever reason)

### CLI in javascript

https://dzone.com/articles/build-clis-with-nashorn-in-java-9 (https://github.com/mubee-tech/nashorn-data-streamer)
 
    d:\projects\testapps\nashorn-data-streamer\
    
However very similar thing can be done in nodejs mush simpler.

    dmytro-mint ~/projects/testapps/node> nodejs streamer.js test.csv test.js

If you have some Java library you want to use in scripting, then this is a way to go.    
    
### Shared code between server and client

Validation example:

    nashornwar> mvn jetty:run
    http://localhost:7899/car.html
    
More advanced React example:

https://www.n-k.de/riding-the-nashorn/ (https://github.com/dasniko/ozark-react)
    
    D:\projects\testapps\ozark-react>
    
    http://localhost:8080/ozark-react/ozark/react


### Dynamic code reload

Sometimes settings are not enough. You need to change functions.

    nashornwar> mvn jetty:run
    http://localhost:7899/acceptPerson?name=John&age=19&reload=true

Change the c:\Users\dmp\nashornwar.js

    http://localhost:7899/acceptPerson?name=John&age=19&reload=true

Even though theoretically it can be done with Compiler API and Java code

### Other

Usually it's quite specific and you know when you need it.

https://www.reddit.com/r/java/comments/618206/why_is_nashorn_not_as_popular_as_it_deserves_to_be/

https://medium.com/@stephenrussett/interesting-uses-of-nashorn-javascript-until-project-detroit-v8-arrives-on-the-jvm-f6d7483f5af8

## Alternatives

Node.js

Graal and truffle languages

http://openjdk.java.net/jeps/330