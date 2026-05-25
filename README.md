# Hospital Priority Queue - Binary Heap

Hospital triage system using a Priority Queue implemented with a Binary Heap in Java.

---

# Project Structure

```text
07-priority-queue-heap/
│
├── src/
│   └── br/
│       └── univali/
│           └── hospitalqueue/
│               ├── app/
│               │   └── Main.java
│               │
│               ├── datastructure/
│               │   └── HeapPriorityQueue.java
│               │
│               ├── model/
│               │   ├── Person.java
│               │   └── Patient.java
│               │
│               └── test/
│                   └── HeapPriorityQueueTest.java
│
├── docs/
├── README.md
└── .gitignore
```

# Project Description

The Hospital **"São Binário"** needs to modernize its emergency room triage system.

Instead of using a simple FIFO queue (First In, First Out), patients must now be attended according to their clinical priority.

This project implements a **Priority Queue using a Binary Heap** to organize patient attendance based on:

1. Urgency Level
2. Waiting Time
3. Vulnerable Group

The implementation was developed for the Data Structures course at UNIVALI.

---

# Priority Rules

Patients are prioritized according to the following criteria:

## 1. Higher Urgency Level

| Level | Classification |
| ----- | -------------- |
| 5     | Immediate      |
| 4     | Very Urent     |
| 3     | Urgent         |
| 2     | Low Urgency    |
| 1     | Non-Urgent     |

## 2. Longer Waiting Time

If two patients have the same urgency level, the one waiting longer receives higher priority.

## 3. Vulnerable Group

If urgency level and waiting time are equal, vulnerable patients are prioritized.

A patient is considered vulnerable if:

* under 12 years old
* over 65 years old

---

# Technologies

* Java 17+
* Binary Heap
* Object-Oriented Programming
* GitHub
* Javadoc

# Requirements

* Java JDK 17 or higher
* Git installed (optional)

Check installed Java version:

```bash
java --version
```

---

# Compilation

Compile all project files from the project root folder:

## Windows

```bash
javac -d bin src/br/univali/hospitalqueue/model/*.java src/br/univali/hospitalqueue/datastructure/*.java src/br/univali/hospitalqueue/app/*.java src/br/univali/hospitalqueue/test/*.java
```

## Linux / MacOS

```bash
javac -d bin $(find src -name "*.java")
```

# Application Execution

Run the interactive hospital system:

```bash
java -cp bin br.univali.hospitalqueue.app.Main
```

The application includes the following operations:

* Insert patient
* Remove patient
* Search patient
* List patients

---

# Test Execution

Run the heap validation test:

```bash
java -cp bin br.univali.hospitalqueue.test.HeapPriorityQueueTest
```

# Expected Test Output

```text
=========== SERVICE ORDER ===========

1 -> Maria               | Urgency: 5  | Wait:   5 min | Vulnerable: NO
2 -> Pedro               | Urgency: 5  | Wait:   2 min | Vulnerable: NO
3 -> Beatriz             | Urgency: 3  | Wait:  35 min | Vulnerable: YES
4 -> João                | Urgency: 3  | Wait:  20 min | Vulnerable: NO
5 -> Helena              | Urgency: 2  | Wait:  45 min | Vulnerable: YES
6 -> Carlos              | Urgency: 2  | Wait:  45 min | Vulnerable: NO

=====================================
```

# Heap Operations Implemented

The project implements the classic Binary Heap operations:

* Enqueue (`heapUp`)
* Dequeue (`heapDown`)
* Swap
* Max-Heap organization

# Javadoc

Generate Javadoc documentation:

## Windows

```bash
javadoc -d docs src/br/univali/hospitalqueue/model/*.java ^
src/br/univali/hospitalqueue/datastructure/*.java
```

## Linux / MacOS

```bash
javadoc -d docs src/br/univali/hospitalqueue/model/*.java \
src/br/univali/hospitalqueue/datastructure/*.java
```

The generated documentation will be available inside the `docs/` folder.

# Author

Developed for the Data Structures course — UNIVALI.
