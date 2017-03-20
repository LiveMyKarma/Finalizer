# Finalizer
Demonstrate overhead of finalizers in Java. Other examples explaining problems with Finalizers.

## Installation

To build the project run following command from project root:

mvn clean install 

## Usage

There are 2 main Classes 

[SimpleBenchmark.java](src/main/java/com/livemykarma/gc/finalizer/SimpleBenchmark.java) which is a simple example creating finalizable classes. This is to demonstrate worse case scenario.

[BenchmarkWithGCProfiler.java](src/main/java/com/livemykarma/gc/finalizer/BenchmarkWithGCProfiler.java) which is a more detailed example creating finalizable classes with added CPU instruction cycle to demonstrate the real world scenario.

##Benchmark Result

Environment: 

I7 Quad Core processor 3.1 GHz

16 GB RAM

Initial Heap 1 GB

Max Heap 4GB

GC: G1GC

Finalizer - Time (ns) per instance creation
![alt tag](http://i.imgur.com/5YC9IDo.jpg)

Finalizer - Average GC Time
![alt tag](http://i.imgur.com/whXoGS1.jpg)
