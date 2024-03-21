// Course:     COP-2805C-86399 Java Advanced                                                                                  //
// Assignment: Project 4: Demonstrate OOP principles for interfaces                                                           //
// Date:       March 3rd, 2024                                                                                                //
// Name:       Jose A. Cañellas Torres                                                                                        //
// Purpose:    The purpose of this program is to allow an user to choose a meal from each of the 3 different classes,         //
//             BackyardBBQ, ThanksgivingDinner, and HeartyStew. All of them must properly implement the interface Meal_Cook.  //
//             Each of the dinner classes include various meals of which to choose, BackyardBBQ includes a regular and a      //
//             gluten free menu with 4 meals each, ThanksgivingDinner has 4 sides options but allows to pick 2 to go along    //
//             with the turkey, and HeartyStew has a Crocktop and Stovetop menu with 4 meals each. All of these have their    //
//             own preparation that will display with the cook() method from Meal_Cook at the end of the program.             //

import java.util.Scanner;

public class CookingDinner {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);// Initializes the scanner to be used throughout the program and other classes //

        System.out.println("\n**Course: COP-2805C-86399**\n**Assignment: Project 4: Demonstrate OOP principles for interfaces**\n**Date: March 3rd, 2024**\n**Name: Jose A. Canellas Torres**\n");

        // Welcomes the user and explains the purpose of the program while displaying the 3 different dinner types //
        System.out.println("Welcome! In this program you'll be able to choose from a selection of meals for 3 different types of dinner:\n\n" +
                           "**A Backyard BBQ**\n**Thanksgiving Dinner**\n**And a Hearty Stew**\n");

        // Creates objects for all 3 classes and passes a scanner to each //
        BackyardBBQ bbq = new BackyardBBQ(scanner);
        ThanksgivingDinner thanksgiving = new ThanksgivingDinner(scanner);
        HeartyStew heartyStew = new HeartyStew(scanner);

        // Calls the preparation method that calls all the setter methods for BackyardBBQ and then //
        // prints the selections made for the user to see.                                         //
        bbq.backyardFoodPreparation(); 
        System.out.println(bbq);

        // Calls the preparation method that calls all the setter methods for ThanksgivingDinner and //
        // then prints out the selections made for the user to see.                                  //
        thanksgiving.thanksgivingFoodPreparation();
        System.out.println(thanksgiving);

        // Calls the preparation method that calls all the setter methods for HeartyStew and then prints //
        // out the selections made for the user to see.                                                  //
        heartyStew.heartyStewFoodPreparation();
        System.out.println(heartyStew);

        // Below, a series of string variables are initialized that will contain the chosen meals, sides,     //
        // and stews that will be passed into the cook method used by all 3 classes. Since ThanksgivingDinner //
        // has the user pick two different sides to accompany the turkey, the selections are concatenated and //
        // split by its cook method to get both sides.                                                        //
        String bbqChosenMeal = bbq.getBackyardMealChoice();
        String thanksgivingFirstSide = thanksgiving.getFirstSideDishChoice();
        String thanksgivingSecondSide = thanksgiving.getSecondSideDishChoice();
        String thanksgivingSides = thanksgivingFirstSide + " and " + thanksgivingSecondSide;
        String heartyStewChoice = heartyStew.getStewChoice();

        // Will print the food and preparation methods from each class by calling their cook methods. //
        System.out.println(bbq.cook(bbqChosenMeal));
        System.out.println(thanksgiving.cook(thanksgivingSides));
        System.out.println(heartyStew.cook(heartyStewChoice));
        
        // Closes the scanner. //
        scanner.close();
    }
}
