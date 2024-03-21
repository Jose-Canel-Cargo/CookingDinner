import java.util.Scanner;

public class BackyardBBQ implements Meal_Cook {

    // Below are initialized and declared variables that will be used throughout the class methods. //
    public Scanner scanner; // Declares the scanner to be used. //

    private int menuChoice; // Integer variable that will contain the choice of menu. //
    private int mealChoice; // Integer variable that will contain the meal of choice. //
    private int grillChoice; // Integer variable that will contain the grill of choice. //

    private String menuChoiceString = ""; // String variable that will contain the chosen menu. //
    private String mealChoiceString = ""; // String variable that will contain the meal chosen. //
    private String grillChoiceString = ""; // String variable that will contain the grill of choice. //
    private String menuToDisplay = ""; // String variable that will contain the options from the chosen menu. //
    private String backyardFoodStatus = ""; // String variable that will contain the string returned by the cook method. //
    
    private String backyardMenuOptions = "\n1. Regular Meals\n2. Gluten Free Meals\n"; // Options for the type of menu to choose a meal from. //
    private String backyardMenu = "\n1. Ribs\n2. Hamburgers\n3. Chicken Kebabs\n4. BBQ Wings\n"; // The meal options inside the Regular Meal menu. //
    private String backyardGlutenFreeMenu = "\n1. Grilled Buttermilk Chicken\n2. Grilled Corn with Chipotle Lime Sauce\n3. Grilled Vegetable Plate\n4. Grilled Tilapia Piccata\n"; // The meal options inside the Gluten Free menu. //
    private String grillOptions = "\n1. Charcoal Grill\n2. Propane Grill\n"; // The grill options on which to cook the chosen meal. //

    String[] regularMealsArray = {"Ribs", "Hamburgers", "Chicken Kebabs", "BBQ Wings"}; // Array with the meal options in the Regular Meal menu. //
    String[] glutenFreeMealsArray = {"Grilled Buttermilk Chicken", "Grilled Corn with Chipotle Lime Sauce", "Grilled Vegetable Plate", "Grilled Tilapia Piccata"}; // Array with the meal options in the Gluten Free Meals menu. //
    String[] chosenMenuArray; // Empty array that will copy the array pertaining to the meal menu chosen by the user. //

    // Constructor method with a Scanner as a parameter. //
    public BackyardBBQ(Scanner scanner) {

        this.scanner = scanner;
    }

    // Setter method for the menu choice. //
    private void setBackyardMenuChoice(){

        // Variables used by the method. //
        int menuChoiceInput; // Integer variable that will contain the user's input. //

        boolean validMenuOption = false; // Boolean for the while method below. //

        // String variables that prompts the user to pick one of the menus and one to display an error message if the input is invalid. //
        // Used to remove clutter of repetitive text in the method.                                                                     //
        String menuOptionsString = "\nChoose which meals to show: " + backyardMenuOptions + "\nEnter a number to select one of the above: ";
        String menuErrorString = "\nYour Input was Invalid. Enter 1 for Regular Menu or 2 for Gluten Free Menu.\n";

        // Prompts the user to pick one of the two menu options available then prints the options. //
        System.out.print("\nCraving for some food to eat in your backyard without having to go to the kitchen? Then here is a selection of Regular Meals and Gluten Free Meals to pick from.\n");
        System.out.print(menuOptionsString);

        // While loop that runs until the input is valid and boolean is true. //
        while (!validMenuOption) {

            // If statement that makes sure the input is an integer. //
            if (scanner.hasNextInt()) {

                menuChoiceInput = scanner.nextInt(); // Assigns the integer input. //
                scanner.nextLine(); // Used to take care of an issue where prompting for input was skipped. //
                
                // If statement that runs if the input is either 1 or 2. //
                if (menuChoiceInput == 1 || menuChoiceInput == 2) {

                    // Allows the user to correct their input using a method from the extra InputCorrection class before assigning to the menu choice variable. //
                    // The method accepts a range to use so the input is only accepted if within that range.                                                    //
                    menuChoice = InputCorrection.integerInputCorrection("Menu Option", menuChoiceInput, 1, 2);

                    // Switch statement that uses the menu choice for the cases. //
                    switch (menuChoice) {

                        case 1: // Runs when the input is 1. //

                            menuChoiceString = "Regular Menu"; // The name of the chosen menu. //
                            menuToDisplay = backyardMenu; // Copies the meals inside the chosen menu. //
                            chosenMenuArray = regularMealsArray; // Copies the array for the chosen meal menu. //
                            validMenuOption = true; // Sets boolean to true. //
                            break;

                        case 2: // Runs when the input is 1. //

                            menuChoiceString = "Gluten Free Menu"; // The name of the chosen menu. //
                            menuToDisplay = backyardGlutenFreeMenu; // Copies the meals inside the chosen menu. //
                            chosenMenuArray = glutenFreeMealsArray; // Copies the array for the chosen meal menu. //
                            validMenuOption = true; // Sets boolean to true. //
                            break;
                    }

                } else {

                    // Prints an error string and the menu options when the user's input is invalid. //
                    System.out.print(menuErrorString + menuOptionsString);

                }

                
            } else {

                // Prints an error string and the menu options when the user's input is invalid. //
                System.out.print(menuErrorString + menuOptionsString);
                scanner.nextLine(); // Used to avoid an issue where the program would stop. //

            }
        }

    }

    // Getter method for the menu of choice. //
    public String getBackyardMenuChoice() {        

        return menuChoiceString;
    }

    // Setter method for the meal of choice. //
    private void setBackyardMealChoice() {

        // Variables used by the method. //
        int mealChoiceInput; // Integer variable that will contain their meal of choice. //

        boolean validMealInput = false; // Boolean for the while method below. //

        // String variables that prompts the user to pick one of the meals from their chosen menu and one to display an error message if the input is invalid. //
        // Used to remove clutter of repetitive text in the method.                                                                                            //
        String chosenMenuString = "\nThe " + menuChoiceString + " options are:\n" + menuToDisplay + "\nEnter a number to select a meal: ";
        String mealErrorString = "\nYour Input was Invalid. Enter a number from 1-4 to make your selection.\n";

        // Prompts the user to select a meal from their chosen menu and prints the menu options. //
        System.out.print(chosenMenuString);

        // While loop that runs until the input is valid and boolean is true. // 
        while (!validMealInput) {

            // If statement that makes sure the input is an integer. //
            if (scanner.hasNextInt()) {

                mealChoiceInput = scanner.nextInt(); // Assigns the integer input. //
                scanner.nextLine(); // Used to take care of an issue where prompting for input was skipped. //

                // If statement that runs if the input is within the range of 1 and 4. //
                if (mealChoiceInput >= 1 && mealChoiceInput <= 4) {

                    // Allows the user to correct their input using a method from the extra InputCorrection class before assigning to the menu choice variable. //
                    // The method accepts a range to use so the input is only accepted if within that range.                                                    //
                    mealChoice = InputCorrection.integerInputCorrection("Meal", mealChoiceInput, 1, 4);

                    // Substracting the input by 1, the correct meal is chosen from the menu. //
                    mealChoiceString = chosenMenuArray[mealChoice - 1];

                    validMealInput = true; // Sets boolean to true. //

                } else {

                    // Prints an error and the meal options if the user's input was invalid. //
                    System.out.print(mealErrorString + chosenMenuString);

                }

            } else {

                // Prints an error and the meal options if the user's input was invalid. //
                System.out.print(mealErrorString + chosenMenuString);
                scanner.nextLine(); // Used to avoid an issue where the program would stop. //

            }
        }
    }

    // Gets the meal of choice. //
    public String getBackyardMealChoice() {

        return mealChoiceString;
    }

    // Setter method for the grill of choice. //
    private void setBackyardGrill() {

        // Variables used by the method. //
        int grillChoiceInput; // Integer variable that will contain the grill of choice. //

        boolean validGrillInput = false; // Boolean for the while method below. //

        // String variables that prompts the user to pick one of the grills to cook their meal and one to display an error message if the input is invalid. //
        // Used to remove clutter of repetitive text in the method.                                                                                         //
        String grillOptionsString = "\nTo make " + mealChoiceString + " what type of grill do you prefer?\n" + grillOptions + "\nEnter a number to select a grill: ";
        String grillErrorString = "\nYour Input was Invalid. Enter 1 for Charcoal Grill or 2 for Propane Grill\n";

        // Prompts the user to select a grill and prints the grill options. //
        System.out.print(grillOptionsString);

        // While loop that runs until the input is valid and boolean is true. //
        while (!validGrillInput) {

            // If statement that makes sure the input is an integer. //
            if (scanner.hasNextInt()) {

                grillChoiceInput = scanner.nextInt(); // Assigns the integer input. //
                scanner.nextLine(); // Used to take care of an issue where prompting for input was skipped. //

                // If statement that runs if the input is either 1 or 2. //
                if (grillChoiceInput == 1 || grillChoiceInput == 2) {

                    // Allows the user to correct their input using a method from the extra validation class before assigning to the menu choice variable. //
                    // The method accepts a range to use so the input is only accepted if within that range.                                               //
                    grillChoice = InputCorrection.integerInputCorrection("Grill Option", grillChoiceInput, 1, 2);

                    // Switch statement similar to that in setBackyardMenuChoice but for the grills. //
                    switch (grillChoice) {

                        case 1 : // Runs if the input is 1. //

                            grillChoiceString = "Charcoal Grill"; // The name of the chosen grill. //
                            validGrillInput = true; // Sets boolean to true. //
                            break;

                        case 2 : // RUns if the input is 2. //

                            grillChoiceString = "Propane Grill"; // The name of the chosen grill. //
                            validGrillInput = true; // Sets boolean to true. //
                            break;
                    }

                } else {

                    // Prints an error string and the menu options when the user's input is invalid. //
                    System.out.print(grillErrorString + grillOptionsString );
                    
                }

            } else {

                // Prints an error string and the menu options when the user's input is invalid. //
                System.out.print(grillErrorString + grillOptionsString );
                scanner.nextLine(); // Used to avoid an issue where the program would stop. //
            }
        }

    }

    // Getter method for the grill of choice. //
    public String getBackyardGrill() {

        return grillChoiceString;

    }

    // Method that calls all the setter methods. //
    public void backyardFoodPreparation() {

        setBackyardMenuChoice();
        setBackyardMealChoice();
        setBackyardGrill();

    }

    // toString method that displays the options selected by the user. //
    public String toString() {

        return "\n*Backyard BBQ Selections*\n" + "\nMenu: " + getBackyardMenuChoice() + "\nMeal: " +
                getBackyardMealChoice() + "\nGrill: " + getBackyardGrill() + "\n";
    }

    // Implemented cook method from Meal_Cook that returns the meal selected and its preparation status. //
    @Override
    public String cook(String whatIsBeingCooked) {

        String backyardFoodPreparation = ""; // String variable that will be returned with the meal and its preparations status. //

        // If statement that runs if the chosen menu was Regular Menu. Uses a switch statement to choose preparations status to display. //
        if (menuChoiceString.matches("Regular Menu")) {

            // Switch statement that uses the meal passed to the method to select the correct case and the preparation status to display. //
            switch (whatIsBeingCooked) {

                case "Ribs": // Runs if the chosen meal was Ribs. //

                    // Assigns the preparation status for Ribs. //
                    backyardFoodPreparation = "\nCovered in a dry rub the 8 hours before cooking. Carefully cooked for 2 hours in a " + grillChoiceString + " on Medium-Low heat." +
                                              "\nBrushed with a mixture of BBQ sauce, Worcestershire sauce, and brown sugar then grilled for 5 more minutes." +
                                              "\nServed with a side of beans and garlic bread.\n";

                    break; 
    
                case "Hamburger": // Runs if the chosen meal was Hamburger. //
    
                    // Assigns the preparation status for Hamburger. //
                    backyardFoodPreparation = "\nCooked on a " + grillChoiceString + " for 5 minutes. Then flipped and cooked for 4 more minutes." +
                                              "\nServed on a toasted bun with lettuce, tomato, onions, mayo, ketchup, and a side of French Fries.\n";

                    break;                   
    
                case "Chicken Kebabs": // Runs if the chosen meal was Chicken Kebabs. //

                    // Assigns the preparation status for Chicken Kebabs. //
                    backyardFoodPreparation = "\nChicken pieces are seasoned with salt, pepper, garlic powder, cumin, paprika, and oregano then skewered with mixed vegetables." + 
                                              "\nAfterwards its grilled in a " + grillChoiceString + " for 8 minutes then both sides are brushed with BBQ sauce and cooked for 1 minute." + 
                                              "\nServed with a side of garlic bread.\n";

                break; 
    
                case "BBQ Wings": // Runs if the chosen meal was BBQ Wings. //

                    // Assigns the preparation status for BBQ Wings. //
                    backyardFoodPreparation = "\nSeasoned with Salt, Pepper, Garlic Powder, Cumin, Paprika, and Oregano. Covered in oil and cooked on a " + grillChoiceString + 
                                              ".\nCook on Medium heat for 20 minutes and flip occasionally, then brush BBQ sauce during the last 3 minutes. Served with french fries and celery.\n";

                    break; 
                
            }

        // Runs if the chosen menu was Gluten Free Menu. Uses a switch statement to choose preparations status to display. //
        } else if (menuChoiceString.matches("Gluten Free Menu")) {

            // Switch statement that uses the meal passed to the method to select the correct case and the preparation status to display. //
            switch (whatIsBeingCooked) {

                case "Grilled Buttermilk Chicken": // Runs if the chosen meal was Grilled Buttermilk Chicken. //

                    // Assigns the preparation status for Grilled Buttermilk Chicken. //
                    backyardFoodPreparation = "\nMarinated in buttermilk, thyme springs, garlic, and salt then refrigerated overnight with occasional turning." +
                                              "\nAfter marinating, the chicken is grilled in a " + grillChoiceString + " on Medium heat for 5 minutes per side." +
                                              "\nServed with salad and grilled corn.\n";

                    break;         
    
                case "Grilled Corn with Chipotle Lime Sauce": // Runs if the chosen meal was Grilled Corn with Chipotle Lime Sauce. //
    
                    // Assigns the preparation status for Grilled Corn with Chipotle Lime Sauce. //
                    backyardFoodPreparation = "\nEars of corn in husks are soaked in cold water for 30 minutes then grilled on medium heat for 25 minutes on a " + grillChoiceString + 
                                              ".\nWhen done, the husks are peeled back and corn is covered in a mixture of butter, grated lime zest, cilantro, chipotle pepper, and salt." +
                                              "\nServed with salad and mixed grilled vegetables.\n";

                    break;                   
    
                case "Grilled Vegetable Plate": // Runs if the chosen meal was Grilled Vegetable Plate. //

                    // Assigns the preparation status for Grilled Vegetable Plate. //
                    backyardFoodPreparation = "\nMarinated for 1 hour in oil, honey, balsamic vinegar, oregano, salt, and pepper. Grilled on Medium heat for 12 minutes on a " + grillChoiceString +
                                              ".\nWhen vegetables are crisp-tender, they are drizzled with the rest of the marinade and served with a side of grilled corn.\n";
                    break;         

    
                case "Grilled Tilapia Piccata": // Runs if the chosen meal was Grilled Tilapia Piccata. //

                    // Assigns the preparation status for Grilled Tilapia Piccata. //
                    backyardFoodPreparation = "\nTilapia is brushed in a mixture of lemon zest, lemon juice, olive oil, garlic, capers, and basil then sprinkled with salt and pepper." + 
                                              "\nAfter sitting for 5 minutes, tilapia is grilled on Medium heat for 3-4 minutes per side on a " + grillChoiceString + "." +
                                              "\nWhen cooked, the tilapia is drizzled with 2 tablespoons of the lemon mixture and sprinkled with basil. Served with diced tomatoes and a lemon wedge.\n";
                    break; 
                
            }

        }

        // Concatenates the chosen meal with its preparation method to be returned by the method. //
        backyardFoodStatus = "\n*BBQ Dinner Status*\n\n" + whatIsBeingCooked + ":\n" + backyardFoodPreparation + "\n";

        return backyardFoodStatus;
    }
    
}
