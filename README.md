# TicTacToe

### Introduction and Setup
  This is a recreation of the classic game, TicTacToe, written in Java. Since this program is written in Java you will need the latest 
version of Java SE Runtime Environment (JRE). if you wish to expand beyond just running the program and into editing it, you will need the 
Java Development Kit. The Java Development Kit (JDK) is not a physical kit but just another installation of Java intended for developers. 
After installing either the JRE or JDK, simply download the TicTacToe.Jar file. After the file has downloaded double click it to start the 
program.

### Writing the Program - Step by Step
  Although the outside of the program appears simple and straight forward, under the hood this program is a very complex.By writing this 
game out in Java, it became apparent how many steps there are to check if a game of TicTacToe is lost or won. Every square of the board 
has to be scanned in order, from left to right, up and down, and diagonally. Then with every click of every box,each box had to be 
assigned a name, and the character inside the box had to be updated. The scanning of each box and updating each box from every click is 
performed until there is a win, a loss or a tie.

### Writing the Program - Names and Communication
  While the steps of the program are an imporant part of the process. Naming every variable and function so that it is easy to read and 
understand can be a very difficult process. The goal of writing a program is to make it work, but the goal of writing a good program is to 
make the code easy to understand without comments. The best example of this is in the Model.Java file which says 
"gameWindow.OpenWindow();" without any comment, this piece of the program is easy to understand. Having easy to interpret code means this 
program can be visited or revisted at any time by anyone so that they can edit and alter the code without having to poke and prod at it to 
determine what each part of the program does.

### Organizing the Program
  In addition to the overcoming the hurdles of the steps needed to properly execute this program, this project was written with Model, 
View and Controller files alongside the Main file. By splitting this program into seperate files the program is easier to navigate for 
anyone else who wishes to view the code. This is a fantastic organization tool as the program can be revisted at a later date without 
needing to try and search for parts of the program. It's a simple streamlining process, but it can be hard to think around from time to 
time, it really all depends on the objective at hand.
