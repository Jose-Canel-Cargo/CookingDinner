import java.util.Scanner;

public class ThanksgivingDinner implements Meal_Cook {
    
    // Below are initialized and declared variables that will be used throughout the class methods. //
    public Scanner scanner; // Declares scanner to be used. //

    private int firstSideChoice; // Integer variable that will contain the choice of first side. //
    private int secondSideChoice; // Integer variable that will contain the choice of second side. //

    private String firstSideChoiceString = ""; // String variable that will contain the first side. //
    private String secondSideChoiceString = ""; // String variable that will contain the second side. //
    private String firstSideString = ""; // String variable that will contain the first side passed to the cook method. //
    private String secondSideString = ""; // String variable that will contain the second side passed to the cook method. //
    private String firstSideStatus = ""; // String variable that will contain the preparation status of the first side. //
    private String secondSideStatus = ""; // String variable that will contain the preparation status of the second side. //
    private String thanksgivingFoodStatus = ""; // String variable that will contain the sides chosen and their preparation status to be returned by the cook method. //
    
    // String variable that contains a list of the side options. //
    private String thanksgivingSidesMenu = "\n1. Crab Stuffed Mushrooms\n2. Mashed Potatoes\n3. Cranberry Ginger Relish\n4. Pumpkin Bread\n";

    // Array with the side options. //
    String[] sidesMenuArray = {"Crab Stuffed Mushrooms", "Mashed Potatoes", "Cranberry Ginger Relish", "Pumpkin Bread"};

    // Constructor method with a Scanner as a parameter. //
    public ThanksgivingDinner(Scanner scanner) {

        this.scanner = scanner;
    }

    // Setter method for the first side choice. //
    public void setFirstSideDishChoice() {

        // Variables used by the method. //

        int firstSideChoiceInput; // Integer variable that will contain the user's input. //
        
        boolean validSideInput = false; // Boolean for the while method below. // 

        // String variables that prompts the user to pick the first side and one to display an error message if the input is invalid. //
        // Used to remove clutter of repetitive text in the method.                                                                   //
        String sideDishMenuString = "\nThe side dish options are:\n" + thanksgivingSidesMenu + "\nEnter a number to select the first side dish: ";
        String sideErrorString = "\nYour Input was Invalid. Enter a number from 1-4 to make your selection.\n";

        // Prompts the user to pick the first side and then prints the options. //
        System.out.println("\nIt's that time of the year to gobble gobble up some food with the family! To go along with the Turkey, choose two sides you would like to accompany it for Thanksgiving Dinner\n");
        System.out.print(sideDishMenuString);

        // While loop that runs until the input is valid and boolean is true. //
        while (!validSideInput) {

            // If statement that makes sure the input is an integer. //
            if (scanner.hasNextInt()) {

                firstSideChoiceInput = scanner.nextInt(); // Assigns the integer input. //
                scanner.nextLine(); // Used to take care of an issue where prompting for input was skipped. //

                // If statement that runs if the input is within the range of 1 and 4. //
                if (firstSideChoiceInput >= 1 && firstSideChoiceInput <= 4) {

                    // Allows the user to correct their input using a method from the extra InputCorrection class before assigning to the menu choice variable. //
                    // The method accepts a range to use so the input is only accepted if within that range.                                                    //
                    firstSideChoice = InputCorrection.integerInputCorrection("First Side Dish", firstSideChoiceInput, 1, 4);

                    // Substracting the input by 1, the correct side is chosen from the menu. //
                    firstSideChoiceString = sidesMenuArray[firstSideChoice - 1];

                    validSideInput = true; // Sets boolean to true. //

                } else {

                    // Prints an error and the meal options if the user's input was invalid. //
                    System.out.print(sideErrorString + sideDishMenuString);

                }

            } else {

                // Prints an error and the meal options if the user's input was invalid. //
                System.out.print(sideErrorString + sideDishMenuString);
                scanner.nextLine(); // Used to avoid an issue where the program would stop. //


            }
        }
    }

    // Getter method for the first side choice. //
    public String getFirstSideDishChoice() {

        return firstSideChoiceString;
    }

    // Setter method for the second side choice. //
    public void setSecondSideDishChoice() {

        // Variables used by the method. //
        int secondSideChoiceInput; // Integer variable that will contain their second side of choice. //

        boolean validSideInput = false; // Boolean for the while method below. //

        // String variables that prompts the user to pick the second side from the menu, one to display an error message if they chose the same option as the first side, and another to display //
        // an error message if their input is invalid. Used to remove clutter of repetitive text in the method.                                                                                  //       
        String sideDishMenuString = "\nNow for the second side dish (Pick a different side than your first choice):\n" + thanksgivingSidesMenu + "\nEnter a number to select the second side dish: ";
        String sameSideErrorString = "\nYou already selected " + firstSideChoiceString + " as your first side. Choose another side as your second.\n";
        String invalidSideErrorString = "\nYour Input was Invalid. Enter a number from 1-4 to make your selection.\n";

        // Prompts the user to select their second side and prints the menu options. //
        System.out.print(sideDishMenuString);

        // While loop that runs until the input is valid and boolean is true. // 
        while (!validSideInput) {

            // If statement that makes sure the input is an integer. //
            if (scanner.hasNextInt()) {

                secondSideChoiceInput = scanner.nextInt(); // Assigns the integer input. //
                scanner.nextLine(); // Used to take care of an issue where prompting for input was skipped. //

                // If statement that checks if the input is within the range of 1 and 4. Also checks to make sure the input isn't the same as the first side. //
                if (secondSideChoiceInput >= 1 && secondSideChoiceInput <= 4 && secondSideChoiceInput != firstSideChoice) {

                    // Allows the user to correct their input using a method from the extra InputCorrection class before assigning to the menu choice variable. //
                    // The method accepts a range to use so the input is only accepted if within that range.                                                    //
                    secondSideChoice = InputCorrection.integerInputCorrection("Second Side Dish", secondSideChoiceInput, 1, 4);

                    // If method that runs if the chosen side is not the same as the first side. //
                    if (secondSideChoice != firstSideChoice) {

                        // Substracting by 1, the correct side is chosen. //
                        secondSideChoiceString = sidesMenuArray[secondSideChoice - 1];

                        validSideInput = true; // Sets boolean to true. //

                    } else {

                        // Prints an error and the menu if the chosen side was the same as the first side. //
                        System.out.print(sameSideErrorString + sideDishMenuString);

                    }

                // Runs if the input was the same as the first side. //
                } else if (secondSideChoiceInput == firstSideChoice) {

                    // Prints an error and the menu if the chosen side was the same as the first side. //
                    System.out.print(sameSideErrorString + sideDishMenuString);

                } else {

                    // Prints an error and the menu if the input was invalid. //
                    System.out.print(invalidSideErrorString + sideDishMenuString);

                }

            } else {

                // Prints an error and the menu if the input was invalid. //
                System.out.print(invalidSideErrorString + sideDishMenuString);
                scanner.nextLine();  // Used to avoid an issue where the program would stop. //

            }
        }
    }

    // Getter method for the second side. //
    public String getSecondSideDishChoice() {

        return secondSideChoiceString;

    }

    // Method that calls all  the setter methods. //
    public void thanksgivingFoodPreparation() {

        setFirstSideDishChoice();
        setSecondSideDishChoice();
        
    }

    // toString method that displays the options selected by the user. //
    public String toString() {

        return "\n*Thanksgiving Sides Selections*\n" + "(Sides served along with Pan Roasted Turkey)\n" + "\nFirst Side: " + 
        getFirstSideDishChoice() + "\nSecond Side: " + getSecondSideDishChoice() + "\n";

    }    

    // Implemented cook method from Meal_Cook that returns the sides selected and their preparation status. //
    @Override
    public String cook(String whatIsBeingCooked) {

        // String showing the preparation status of the turkey that will be concatenated with the returned string. //
        String turkeyStatus = "\nBefore roasting, the oven is preheated to 165° and the turkey is rinsed after left brining in salt water, the neck and giblets are removed, and then patted dry." +
                              "\nThen, the turkey is seasoned inside and outside with a mix of thyme, rosemary, sage, parsley, paprika, salt, pepper, garlic powder, and onion powder." +
                              "\nAfterwards, a butter herb mixture of butter, lemon zest, thyme, and rosemary is used to coat it; Then stuffed with homemade stuffing and left to bake for 2-3 hours." +
                              "\nWhen done, the turkey is left to rest for 30 minutes before it is served on a large plate and ready to carve.\n";

        // String array that will take the string of both sides passed to the cook method and split them up, assigning them to 0 and 1 in the array. //
        String[] selectedSideDishes = whatIsBeingCooked.split(" and ");

        // Assigns the chosen sides from the array as the first and second side strings. //
        firstSideString = selectedSideDishes[0];
        secondSideString = selectedSideDishes[1];

        // Calls the sideDishPreparation that will assign the correct preparation status to the strings. //
        firstSideStatus = sideDishPreparation(firstSideString);
        secondSideStatus = sideDishPreparation(secondSideString);

        // String to be returned by the method displaying all the preparation statuses. //
        thanksgivingFoodStatus = "\n*Thanksgiving Dinner Status*\n\nTurkey:\n" + turkeyStatus + "\n\nFirst Side(" + firstSideString + "):\n" + firstSideStatus +
                                 "\n\nSecond Side(" + secondSideString + "):\n" + secondSideStatus + "\n";

        return thanksgivingFoodStatus;
    }

    // Method used to assign the correct preparation status to the variables inside the cook method. //
    private String sideDishPreparation(String sideDish) {

        // String that will be returned with the preparation status. //
        String sideDishPreparationString = "";

        // Switch statement that uses the side passes to the method to select the correct case and the preparation status to return. //
        switch(sideDish) {

            case "Crab Stuffed Mushrooms": // Runs if the chosen side was Crab Stuffed Mushrooms. //
                
                // Assigns the preparation status for Crab Stuffed Mushrooms. //
                sideDishPreparationString = "\nFirst, the stuffing is made with a mixture of crabmeat, mayonnaise, green onions, parmesan cheese, thyme, oregano, ground savory, salt and pepper." +
                                            "\nAfter cleaning, the mushrooms are stuffed with the homemade stuffing, baked in a preheated oven for 15 minutes at 350°F, and later served in a large plate.\n";

                break;

            case "Mashed Potatoes": // Runs if the chosen side was Mashed Potatoes. //

                // Assigns the preparation status for Mashed Potatoes. //
                sideDishPreparationString = "\nThe potatoes are peeled, cut in quarters, and boiled in a large pot with salted water for about 15 minutes until they are tender yet firm." +
                                            "\nAfter draining, they return to the pot in low heat for 1-2 minutes while adding parmesan cheese, cream cheese, chives, butter, garlic, salt, and pepper." +
                                            "\nUsing a potato masher, they are mashed until smooth and later served in a large bowl.\n";

                break;
                
            case "Cranberry Ginger Relish": // Runs if the chosen side was Cranberry Ginger Relish. //

                // Assigns the preparation status for Cranberry Ginger Relish. //
                sideDishPreparationString = "\nIn a large saucepan, cranberries, sugar, ginger, and 2 tablespoons of water are heated until boiling at which point its reduced to Meadium Low heat." +
                                            "\nIt's left to simmer for 10 to 15 minutes until most cranberries have popped, then it is stirred with vinegar and left to cool to room temperature and served in a bowl.\n";

                break;

            case "Pumpkin Bread": // Runs if the chosen side was Pumpkin Bread. //

                // Assigns the preparation status for Pumpkin Bread. //
                sideDishPreparationString = "\nFirst, butter and sugar are mixed in a large bowl using a mixer for around 7 minutes at which point it should be fluffy, then the eggs and vanilla are added." +
                                            "\nWhen done, mixer is set on low a flour mixture of gluten free flour, baking powder, baking soda, salt, cinnamon, and nutmeg are added alongside pumpkin and buttermilk." +
                                            "\nAfter the mix is ready, its transfered to a lightly buttered loaf pan and baked in an oven set to 350° for about an hour, left to cool for 15 minutes, and served on a plate.\n";

                break;

        }

        return sideDishPreparationString;
    }
    
}
