# Digital-Library-Book-Management-System
Assignment by tacnique:
# 📚 Library Management System  

A simple Java-based **Library Management System** that allows librarians to **add, update, search, and remove books** while maintaining their availability status.  

---

## 🚀 Setup & Installation  

### Prerequisites  
- **Java 8 or higher**  
- Any **Java IDE** (e.g., IntelliJ IDEA, Eclipse, VS Code)  
- Terminal or Command Prompt  

### Running the Program  

#### Option 1: Using an IDE (Recommended)  
1. Clone or download the project.  
2. Open the project in **IntelliJ IDEA, Eclipse, or VS Code**.  
3. Navigate to `Main.java` and **Run** the file.  

#### Option 2: Running via Terminal  
1. Open a terminal and navigate to the `src/` directory:  
   ```sh
   cd path/to/Digital-Library-Book-Management-System/src

Compile the Java files:
javac *.java

Run the program:
sh
java Main


Challenges Faced & Improvements
Challenges:
1.Input Validation & Looping:
Initially, the program moved to the next input even if the title or author was left blank.This was fixed by adding a loop to ensure the program keeps prompting users until a valid input is provided.

2.Handling Different Availability Inputs:
Users should be able to enter "1", "Available", "available", or "Checked Out" without issues.This required additional logic to interpret various input formats correctly.

3.Avoiding Code Repetition:
To maintain DRY (Don't Repeat Yourself) principles, input validation and book-related operations were modularized into separate methods.

Future Improvements:
1.Persistent Data Storage:
Currently, books exist only in memory during runtime.Future versions could integrate a database (MySQL, SQLite, or MongoDB) or file-based storage to retain books after the program exits.

2.Graphical User Interface (GUI):
A GUI using JavaFX or Swing would make the system more user-friendly instead of using a command-line interface (CLI).

3.User Authentication
Adding a login system so that only authorized librarians can modify the catalog.

4.Bulk Import/Export
The ability to import/export books from/to a CSV file would be useful for larger libraries.


