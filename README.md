# Media Inventory Manager

A Java-based inventory management application showcasing foundational data handling, sorting algorithms, and persistence techniques. Designed with modular, object-oriented principles, this project serves as a practical example of data organization and algorithmic processing relevant to AI research workflows.

---

## Overview

This program allows users to manage a collection of media items (DVDs) with capabilities to:

- Add, modify, delete, and search inventory records
- Navigate records efficiently through intuitive controls
- Sort inventory items alphabetically using a classic bubble sort algorithm
- Persist inventory data to local storage for reproducibility and further processing

---

## Key Features

- **Robust Data Structures:**  
  Uses ArrayLists and custom classes (`DVDRuntime`, `Inventory`) to encapsulate item properties and behaviors, mirroring typical dataset object representations in AI.

- **Algorithmic Implementation:**  
  Demonstrates bubble sort for ordering data, a fundamental sorting technique often explored as a baseline in algorithm analysis and optimization.

- **Data Persistence:**  
  Implements file-based saving/loading, exemplifying the importance of data reproducibility and state preservation in experimental AI pipelines.

- **Search and Retrieval:**  
  Supports case-insensitive search by title, illustrating basic text matching techniques akin to string preprocessing tasks.

---

## Research Relevance and AI Applications

While primarily a media inventory tool, this project encapsulates core concepts valuable in AI and data science domains:

- **Data Preparation and Management:**  
  Effective dataset structuring and access patterns are critical for AI model training and evaluation. This program models how to organize and manipulate structured data efficiently.

- **Algorithm Understanding:**  
  Bubble sort, though simple, forms the foundation for understanding more advanced sorting and data ordering algorithms vital in AI data preprocessing.

- **Reproducibility:**  
  The ability to save and restore data states aligns with the scientific rigor required in AI experiments, ensuring consistent evaluation conditions.

- **Extensibility for AI Integration:**  
  This codebase can be extended to integrate machine learning models, such as predicting inventory needs or optimizing stock based on historical data.

- **GUI for Data Labeling:**  
  The user interface offers a potential platform for manual data labeling or annotation tasks, which are often necessary in supervised learning pipelines.

---

## Code Insights: AI & Data Science Principles

- **`Inventory` Class:**  
  Manages collections using an ArrayList — a dynamic data structure commonly used for flexible dataset handling. Its methods for adding, deleting, and searching mimic CRUD operations in data management.

- **Sorting Implementation:**  
  The bubble sort in `Inventory.sort()` serves as a didactic example of algorithmic complexity and optimization challenges faced in large-scale AI datasets.

- **Data Value Computation:**  
  Methods like `value()` and `total()` demonstrate aggregation of quantitative data, a frequent operation in feature engineering and statistical summarization.

- **File Operations:**  
  The save functionality models persistent storage techniques, highlighting error handling and directory management—important for robust data engineering.

---

## Requirements

- Java Development Kit (JDK) 8 or higher
- Modify the file path in `Inventory.java` (`save()` method) to an appropriate writable directory on your system

---

## Usage

1. Compile all source files in the `test` package:

    ```bash
    javac test/*.java
    ```

2. Run the application through the main class (e.g., `InventoryApp`).

---

## Potential Enhancements for AI Research

- Implement machine learning models to forecast inventory trends or optimize stock levels
- Extend the GUI for data annotation or real-time data visualization
- Replace file persistence with database or cloud-based storage for scalable datasets
- Incorporate more sophisticated sorting/search algorithms to handle large datasets efficiently

---

## License

This project is open-source and welcomes contributions and enhancements aligned with AI research and data science best practices.

---





