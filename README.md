# Finalizer
Demonstrate overhead of finalizers in Java

There are 2 main Classes 
[SimpleBenchmark.java](src/main/java/com/livemykarma/gc/finalizer/SimpleBenchmark.java) which is a simple example creating finalizable classes. This is to demonstrate worse case scenario.

[BenchmarkWithGCProfiler.java](src/main/java/com/livemykarma/gc/finalizer/BenchmarkWithGCProfiler.java) which is a more detailed example creating finalizable classes with added CPU instruction cycle to demonstrate the real world scenario.
