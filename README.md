# MOM
Mega Object Mapper - simply convert objects

## Introduction
A high performance, low-overhead, zero dependency, thread-safe object mapper.

## How to Use

```java
SimpleObjectMaper objectMaper = new SimpleObjectMaper();
ClassB instanceOfClassB = objectMaper.map(instanceOfClassA, ClassB.class);
  

```

## How to install

```java
mvn clean install
