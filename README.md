# DVD Inventory Program

A simple Java Swing application to manage a DVD inventory. This program allows users to view, add, modify, delete, search, and save DVD records.

---

## Features

- Navigate through DVD items (First, Previous, Next, Last)
- Add new DVD records with title, stock units, price, and runtime
- Modify existing DVD records
- Delete DVD records
- Search DVDs by title (case-insensitive)
- Save the inventory data to a file (`c:\data\inventory.dat`)

---

## Requirements

- Java Development Kit (JDK) 8 or higher
- No OS-specific dependencies; update the file path in `Inventory.java` to a valid location on your system before running

---

## Usage

1. Compile all source files in the `test` package (e.g., `Inventory.java`, `DVDRuntime.java`, `InventoryApp.java`, `DVD.java`,).

```bash
javac test/*.java
