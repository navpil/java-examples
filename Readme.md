# Checking out Java technologies

Some of the technologies which were checked in this project are now or removed.

These are:

 - [Security Manager](https://openjdk.org/jeps/411)
 - [Nashorn](https://openjdk.org/jeps/372) and other scripting engines

## Polyglot

Module `jscript` shows how to execute javascript code in Java and its interoperability.
It works, but probably it's better to have a look at `Graal VM` with `Truffle`.

Please also read `Readme.md` in the `nashornwar` module, which shows how to use javascript on Java backend.

TODO: look at [Graal VM](https://www.graalvm.org/)

## Instrumentation

Requires to add this as a VM options:

    --add-opens java.base/java.lang=ALL-UNNAMED

`build-and-run.md` describes how to do it.

## Compile Stack Overflow

This module (`compilestackoverflow`) is not included into the build, because compilation fails on StackOverflow.

## Maven Demo

A simple mvn application with profiles and ant run plugin

## SPI

In the past in order to inject some implementation people relied on compiling against one .jar file
but running against another.
Example of this is `PreSPIWay` which is compiled against `idogs` but is run against `angry-dogs`.
`idogs.jar` is excluded from the application and `angry-dogs` is included, which has same structure,
but different implementation.
Please run the `Main` class in `pre-spi-test` to check this out.
Note that `PreSPIWayTest` will fail with `UnsupportedOperationException`.

After SPI came onto scene this is much simpler.
Interfaces are declared and coded against.
Jar files which wish to be discovered for these interfaces indicate it by creating a file in
`META-INF/services`. 
Please check `spiimpl` and the related interface `Dictionary` and class `Dictionaries`.
