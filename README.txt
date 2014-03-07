BT coding exercise

The program was writen in Java with JDK 7

this java program can only be run from command line 

following are the steps to run the program

1: open command line interface (command prompt or terminal)

2: change directory to point the folder with Main.class

3: complie the java program with 

   "javac Main.java"

4: run the program with " java Main searchparameters  < surnames.txt"

   eg: java Main Jones < surnames.txt
  
       java Main Jones Winton Smith < surnames.txt


SAMPLE OUTPUT:

with single parameter:

Input:

java Main Jones < surnames.txt

Output:

Jones:Jonas,Johns,Johnson,Saunas

with multiple parameters:

Input:

java Main Jones Winton Smith < surnames.txt

Output:

Jones:Jonas,Johns,Johnson,Saunas
Winton:Van Damme
Smith:Smith,Smyth,Smythe,Smid,Schmidt

with non matching parameter:

Input:

java Main Ferido < surnames.txt

Output:

Ferido: No match found
