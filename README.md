Library Management System
This project is a basic console-based Library Management System written in Java. 
It allows you to add books, add users, issue books, return books, and view all books using a simple menu-driven program.

Features
Add Book  Enter book ID, title, and author to save a new book.
Add User Enter user ID and name to register a new user.
Show Books  Display all books currently stored in the library with their status (Issued / Not Issued).
Issue Book  Issue a book to a user by entering book ID and user ID.
Return Book  Return a book by entering book ID and user ID.
Exit  Close the program.

How It Works
The program runs in a loop and shows a menu with options (Show,Add Book,Add User,Issue,Return,Exit).
You choose an option by typing a number (1–6).
Based on your choice:
Add Book → Creates a new Book object and adds it to the library list.
Add User → Creates a new User object and adds it to the user list.
Show Books → Prints all book details stored in the library.
Issue Book → Finds a book by ID and issues it to the user.
Return Book → Finds a book by ID and returns it to the library.
Exit → Stops the program.

Code Structure
Book Class
Holds book details: ID, Title, Author, and Issued Status.
Provides methods: issueBook(), returnBook(), getId(), and toString().
User Class
Holds user details: ID, Name, and list of issued books.
Provides methods: issueBook(), returnBook(), getUserId(), and toString().
Library Class
Contains lists (ArrayList) to store books and users.
Provides methods: addBook(), addUser(), issueBook(), returnBook(), showBooks().
Uses helper methods findBook() and findUser() to loate records.
Main Class
Runs the menu-driven program using a Scanner for user input.
Provides options for all operations in a loop until exit.
