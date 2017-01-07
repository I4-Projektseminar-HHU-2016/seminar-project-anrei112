# Rezepte_DB

This project is a program which allows a user to specify which ingredients he has just ahead 
or what ingredients he wants to use for cooking.
It is possible to choose vegetables and a side order (rice, potatoes or pasta).
After selecting the ingredients the program displays recipes matching to the selected ingredients.
It is also possible to display the whole list of ingredients of a recipe.

## Features

- [x] GUI
- [x] database
- [x] function "Rezepte_anzeigen" to request the selected ingredients and to to display the names of matching recipes
- [x] function "Zutaten_anzeigen" to display the whole list of ingredients of a recipe
- [x] function "initialize" to set the connection to the SQLite-database
- [x] function "aktualisieren" to fill the ComboBox

## Getting Started

These instructions will get you a copy of the project up and running on your local machine

### Prerequisities

- The Java-code was written and tested with the editor NetBeans IDE 8.1.
  You can get this from [https://netbeans.org/downloads/](https://netbeans.org/downloads/).
  
- The GUI was created with the tool JavaFX Scene Builder 1.1.
  You can get this from [http://www.oracle.com/technetwork/java/javase/downloads/javafxscenebuilder-info-2157684.html](http://www.oracle.com/technetwork/java/javase/downloads/javafxscenebuilder-info-2157684.html).
  
- The database was generated and filled with the tool SQLite 3.9.0.
  You can get this from [https://sqlite.org/download.html](https://sqlite.org/download.html).
  
- For the connection of the Java-code and the database was the SQLite JDBC Driver 3.8.11.2 used.
  You can get this from [https://bitbucket.org/xerial/sqlite-jdbc/downloads](https://bitbucket.org/xerial/sqlite-jdbc/downloads).

### Installing

To run the script you have to download the folder "Rezepte_DB".
Now open the command line (CMD) and navigate to the folder, where the downloaded folder is.
Use the command "cd" to navigate.
Then navigate to the folder "Rezepte_DB", then to the folder "src".
After that you can run the script by using the command "java FXMLDocumentController.java".
Finally the GUI should be shown successively.

Optionally you can open the project with an editor and run the script.

## Versioning

I use the distributed revision control system [Git](https://git-scm.com/) for versioning.

## Authors

* **Annika Reich** - [anrei112](https://github.com/anrei112)

## License

This project is licensed under the MIT License - see the [LICENSE.md](https://github.com/I4-Projektseminar-HHU-2016/seminar-project-anrei112/blob/master/LICENSE.md) file for details.

## Acknowledgments

* [README.md](https://github.com/I4-Projektseminar-HHU-2016/seminar-project-anrei112/blob/master/README.md) inspired by [M4urice](https://github.com/I4-Projektseminar-HHU-2016/info/blob/master/README-TEMPLATE.md)

