# 📚 Resource Query Manager (Java)

This Java console application manages user queries to different resources. The program allows loading data from a file, handling queries, and displaying statistics about resource usage.

## 📦 Project Structure
- **Aplicacio/UsaLlistaPersones.java**: Main application class. Manages the user menu, data loading, and user interaction.  
- **Dades/LlistaPersones.java**: Stores and manages a list of `Persona` objects. Includes functions to add, delete, or query data.  
- **Dades/Persona.java**: Represents a person with attributes like query date, alias, and resource consulted.  
- **LlistaPersones.txt**: Input file with initial data for the application.

## 🚀 Main Features
Through the application menu, the user can:
- Add data: Register a new user query.  
- Delete data by resource: Remove all queries associated with a resource.  
- Delete data by date and resource: Remove queries for a resource on a specific date.  
- Show users per resource: See which users queried a given resource.  
- Show users per resource and date: Show users who queried a resource on a specific date.  
- Show the most queried resource.  
- Show resources consulted by a specific user.  
- Check if a user has accessed a specific resource.  
- Exit the program.

## 🛠️ Requirements
- Java 8 or higher.  
- `LlistaPersones.txt` file in the same folder as the project or specify the correct path in the code.

## ▶️ How to Run
1. Compile the Java files: `javac Aplicacio/UsaLlistaPersones.java Dades/LlistaPersones.java Dades/Persona.java`  
2. Run the program: `java Aplicacio.UsaLlistaPersones`

## 📝 About
This project demonstrates how to manage user queries with Java, combining file input, object-oriented programming, and console-based menus. It emphasizes modularity and clear structure while providing useful operations for querying, updating, and analyzing resource usage. The application serves as a practical example of integrating Java classes, file handling, and user interaction in a console environment.
