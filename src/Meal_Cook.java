/*
This file: Meal_Cook.java
Provided in support of Project 4: CookingDinner

Demonstrate OOP principles for interfaces; include formal documentation. (100)
Write a Java program with four classes in four separate source code files.
The first class is BackyardBBQ. You use a charcoal or propane grill to cook backyard BBQ.
The second class is ThanksgivingDinner. You use an oven and a roasting pan to cook a turkey.
The third class is HeartyStew. You use a crockpot or stovetop pot to cook stew.
Each of these three classes must implement the interface Meal_Cook that is supplied with this assignment. You are free to select any attributes and methods you like for these classes, so long as you follow good practices for encapsulation and include a proper toString() method.
The fourth class is CookingDinner. This will include a runnable main() method. When run, the program should print out the course, assignment, date, and student name to the screen. Then instantiate an object of each type of dinner and print the status of each object to the screen.

*/
public interface Meal_Cook {

  /* method cook() accepts a String of the meal being cooked
   returns a String with a message describing the cooking process
   for example:
     System.out.println(Obj.cook("Hamburgers"));
     // prints to screen: "Hamburgers cooked on the grill for 4 minutes, flipped and cooked for 4 more minutes. Put on bun and served."
  */ 
  public abstract String cook(String whatIsBeingCooked);


  } // end Meal_Cook 