# java-socket-networking
Java socket networking exercises including Daytime servers, concurrency models, and port scanning.
# Java Socket Networking Experiments

## Overview

This project contains a collection of Java networking exercises exploring socket programming and concurrency models.
It demonstrates client-server communication, multiple server architectures, and basic network scanning.

Developed as part of coursework focused on understanding TCP/IP communication and concurrent server design.

## Components

### DayTimeClient

Connects to a Daytime Protocol server and retrieves the current time.

### DayTimeServer

Basic single-threaded server responding with the current date/time.

### MultiDayTimeServer

Sequential server variant introducing simulated delay.

### FinalMultithreadedDayTimeServer

Thread-per-client implementation allowing multiple simultaneous connections.

### PooledDaytimeServer

Uses a fixed thread pool via `ExecutorService` to handle client requests efficiently.

### LowPortScanner

Scans low-numbered ports on a host to detect active services.

## Concepts Demonstrated

* TCP socket communication
* Client-server architecture
* Thread-per-connection design
* Thread pooling
* Java concurrency utilities
* Network service discovery

## How to Run

Compile:

```
javac -d out src/ie/atu/sw/*.java
```

Run examples:

```
java -cp out ie.atu.sw.DayTimeServer
java -cp out ie.atu.sw.DayTimeClient
java -cp out ie.atu.sw.LowPortScanner
```

## Author

Eoghan Fallon

---

Part of my software development learning portfolio.
