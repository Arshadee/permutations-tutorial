# MyPermutationCalc Application

A highly flexible, architecture-driven Java application designed to calculate all possible permutations of a given sequence—supporting both **full set** generation and specialized **subset pruning**.

Unlike standard textbook examples, this project implements multiple tree-search traversal strategies and introduces a unique data structure design to overcome traditional permutation limitations.

## 🌟 Key Features

* **Advanced Strategy Pattern:** Built using an interface-driven design (`IPermutateCalc`) that allows seamless, dynamic switching between different tree-search implementations with zero code changes.
* **Duplicate Value & Multi-Character Support:** By mapping user-supplied elements to a proxy map (`seqMap`), the algorithm tracks unique index combinations. This allows input sequences to contain duplicate entries (e.g., `['A', 'A', 'B']`) and multi-character strings cleanly.
* **Textbook Alternative (Manual State Management):** Implements an iterative approach that bypasses Java's automatic JVM call stack. By pushing snapshots to a manual data structure on the Java Heap, it mitigates the risk of hitting a `StackOverflowError` during deep tree traversals.

---

## 🛠️ Supported Algorithms

The application provides three distinct tree search algorithm implementations to explore the permutation space:

1. **Recursive Depth-First Search (REC):** The traditional textbook implementation of a permutation tree.
2. **Iterative Depth-First Search (ITR):** A custom, manual stack-based LIFO (`ArrayDeque`) framework that mimics recursion safely on the memory heap.
3. **Iterative Breadth-First Search (ITRB):** A queue-based FIFO (`LinkedList`) framework that systematically walks the tree level-by-level instead of branch-by-branch.

---

## 📐 How the Pruning Logic Works

The mathematical formulation for generating total full permutations is $n!$. When a subset constraint ($r$) is specified, the tree structure is dynamically clipped using the formula:

$$\frac{n!}{(n-r)!}$$

### Visualization of Subset Pruning (Subset size of 2 out of 3 elements)

              _____________________________________
             |               root                  |
             |_____________________________________|
                               |
                       (We cut @ length 2)
             ___________/______|______\___________
            /                  |                  \
          [a]                 [b]                 [c]     <- Depth Level 1
         /   \               /   \               /   \
      a[b]   a[c]         b[a]   b[c]         c[a]   c[b]   <- Depth Level 2 (Cut!)

Results:   ab     ac           ba     bc           ca     cb    => Total: 6 Permutations

---

## 🚀 Getting Started

### Prerequisites
* Java 8 or higher installed on your machine.

### Compilation
Compile the application via your terminal:

Bash
```
javac Main.java
```

### Execution Format
The executable supports fluid execution flags via command-line arguments:

Bash
```
java Main size{subset_number} [element1 element2 ... elementN] [Algorithm Key]
```
* **Subset Configuration:** To limit calculation to a specific subset, the first argument must start with the keyword `size` or `SIZE` followed directly by an integer (e.g., `size3`). If omitted, the application defaults to executing a full-set permutation.
* **Algorithm Selection:** Append `REC`, `ITR`, or `ITRB` at the very end of your instruction to choose your engine. If left blank, **Recursive Depth-First Search** runs by default.

### 💡 Usage Examples
Example 1: Full Set Permutation using Iterative DFS

Bash
```
java Main a b c d ITR
```
Output:
```
Iterative Depth First Search
sequenceList size = 4
subset size = 4
Sequence [a, b, c, d]
results size = 24
-----------------------------------------------
[abcd, abdc, acbd, acdb, adbc, adcb, bacd, badc, bcad, bcda, bdac, bdca, cabd, cadb, cbad, cbda, cdab, cdba, dabc, dacb, dbac, dbca, dcab, dcba]
-----------------------------------------------
```

Example 2: Subset Permutation using Breadth-First Search

Bash
```
java Main size2 a b c d ITRB
```


Output:
```
Iterative Breadth First Search
sequenceList size = 4
subset size = 2
Sequence [a, b, c, d]
results size = 12
-----------------------------------------------
[ab, ac, ad, ba, bc, bd, ca, cb, cd, da, db, dc]
-----------------------------------------------
```

## 📂 Project Architecture

* [cite_start]**`IPermutateCalc.java`**: The core interface defining behavioral expectations and hosting default display logic. [cite: 19]
* **`PermGen.java`**: Generic coordinator leveraging Java Generics to adapt inputs seamlessly across `String`, `String[]`, and `List<String>` data objects.
* [cite_start]**`PermutationREC.java`**: Recursive DFS solver. [cite: 19]
* [cite_start]**`PermutationITR.java`**: Iterative Stack-based DFS engine incorporating explicit `State` snapshot tracking objects. [cite: 19]
* [cite_start]**`PermutationBFS_ITR.java`**: Iterative Queue-based BFS engine variation. [cite: 19]
* **`Main.java`**: Entry point coordinating system runtime loops via `UserInput.java`. [cite: 16, 17, 19]

---

## 👨‍💻 Author

Designed and maintained by **arshadmayet**.

