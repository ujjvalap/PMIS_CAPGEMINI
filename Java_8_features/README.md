# Java 8 Complete Examples

This project contains one standalone Java source file per Java 8 concept/example.

## Requirements
- JDK 8 or newer
- No external dependencies

## Run an example
From the project root, compile and run a class. Example (Windows PowerShell):

```powershell
javac -d out src/main/java/com/example/java8/01_LambdaExpressions.java
java -cp out com.example.java8.LambdaExpressions
```

Because Java class names cannot begin with digits, the filenames are descriptive but the public class names omit the numeric prefix. For a simple workflow, open the folder in IntelliJ IDEA and run each class's `main` method.

## Contents
- Lambda expressions
- Functional interfaces: Predicate, Function, Consumer, Supplier, BiPredicate, BiFunction, UnaryOperator, BinaryOperator
- Method references and constructor references
- Stream creation, intermediate and terminal operations, flatMap, collectors
- Optional
- Default and static interface methods
- Date and Time API, including time zones
- forEach
- Primitive streams
- Parallel streams
- Base64 and StringJoiner
- CompletableFuture
- Lazy evaluation and stream pipelines
- Employee stream practice

## Java version note
The examples are written to be compatible with Java 8. They avoid later methods such as `List.of()`, `Stream.toList()`, `Optional.isEmpty()`, `takeWhile()`, and `dropWhile()`.
