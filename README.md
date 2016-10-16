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

You need an editor like "NetBeans IDE" to run this script.
If you have installed it, you can continue as follows:
First open the project in the editor.
For opening it you have to open the editor. Then click on "file" and "open project" and choose the project "Rezepte_DB".
Afterwards you have to execute the programm by clicking on the green arrow or "run" and "run project".
The GUI will open up.

## Versioning

I use the distributed revision control system [Git](https://git-scm.com/) for versioning.

## Authors

* **Annika Reich** - [anrei112](https://github.com/anrei112)

## License

This project is licensed under the MIT License - see the [LICENSE.md](https://github.com/I4-Projektseminar-HHU-2016/seminar-project-anrei112/blob/master/LICENSE.md) file for details.

## Acknowledgments

* [README.md](https://github.com/I4-Projektseminar-HHU-2016/seminar-project-anrei112/blob/master/README.md) inspired by [M4urice](https://github.com/I4-Projektseminar-HHU-2016/info/blob/master/README-TEMPLATE.md)

