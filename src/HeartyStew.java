import java.util.Scanner;

public class HeartyStew implements Meal_Cook {

    // Below are initialized and declared variables that will be used throughout the class methods. //
    public Scanner scanner; // Declares scanner to be used. //

    private int menuChoice; // Integer variable that will contain the chosen menu. //
    private int stewChoice; // Integer variable that will contain the stew of choice. //

    private String stewMenuChoiceString = ""; // String variable that will contain the menu of choice. //
    private String stewChoiceString = ""; // String variable that will contain the stew of choice. //
    private String menuToDisplay = ""; // String variable that will contain the menu to display. //
    private String stewFoodStatus = ""; // String variable that will contain the status of the chosen stew that will be returned by the cook method. //
    
    private String stewMenuOptions = "\n1. Crockpot Stews\n2. Stovetop Stews\n"; // Options for the type of menu to choose a stew from. //
    private String crockpotStewMenu = "\n1. Chicken Stew\n2. Slow Cooker Beef Stew\n3. Italian Bean Stew\n4. Cachupa Stew\n"; //Options for the stews inside the Crockpot Menu. //
    private String stovetopStewMenu = "\n1. Fish Stew\n2. Chickpea Stew\n3. Kale and White Bean Stew\n4. Herbed Chicken and Potato Stew\n"; //Options for the stews inside the Stovetop Menu. //

    String[] crockpotStewArray = {"Chicken Stew", "Slow Cooker Beef Stew", "Italian Bean Stew", "Cachupa Stew"}; // Array with the stews inside the Crockpot Menu. //
    String[] stovetopStewArray = {"Fish Stew", "Chickpea Stew", "Kale and White Bean Stew", "Herbed Chicken and Potato Stew"}; // Array with the stews inside the Stovetop Menu. //
    String[] chosenStewMenuArray; // Empty array that will copy the array pertaining to the stew menu chosen by the user. //


    // Constructor method with a Scanner as a parameter. //
    public HeartyStew(Scanner scanner) {

        this.scanner = scanner;
    }

    // Setter method for the menu choice. //
    private void setStewMenuChoice(){

        // Variables used by the method. //
        int menuChoiceInput; // Integer variable that will contain the user's input. //

        boolean validMenuOption = false; // Boolean for the while loop below. //

        // String variables that prompts the user to pick one of the menus and one to display an error message if the input is invalid. //
        // Used to remove clutter of repetitive text in the method.                                                                     //
        String menuOptionsString = "\nChoose which stews to show: " + stewMenuOptions + "\nEnter a number to select one of the above: ";
        String menuErrorString = "\nYour Input was Invalid. Enter 1 for Crockpot Stews or 2 for Stovetop Stews.\n";

        // Prompts the user to pick one of the two menu options available then prints the options. //
        System.out.print("\nHungry for a stew to heat you up on a cold day? Then pick one from this selection of Crockpot or Stovetop Stews.\n");
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

                            stewMenuChoiceString = "Crockpot Stews"; // The name of the chosen menu. //
                            menuToDisplay = crockpotStewMenu; // Copies the meals inside the chosen menu. //
                            chosenStewMenuArray = crockpotStewArray; // Copies the array of the chosen menu. //
                            validMenuOption = true; // Sets boolean to true. //
                            break;

                        case 2: // Runs when the input is 1. //

                            stewMenuChoiceString = "Stovetop Stews"; // The name of the chosen menu. //
                            menuToDisplay = stovetopStewMenu; // Copies the meals inside the chosen menu. //
                            chosenStewMenuArray = stovetopStewArray; // Copies the array of the chosen menu. //
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
    public String getStewMenuChoice() {        

        return stewMenuChoiceString;
    }

    // Setter method for the stew of choice. //
    private void setStewChoice() {

        // Variables used by the method. //
        int stewChoiceInput; // Integer variable that will contain the user's input. //

        boolean validStewInput = false; // Boolean for the while loop below. //

        // String variables that prompts the user to pick one of the meals and one to display an error message if the input is invalid. //
        // Used to remove clutter of repetitive text in the method.                                                                     //
        String chosenMenuString = "\nThe " + stewMenuChoiceString + " options are:\n" + menuToDisplay + "\nEnter a number to select a meal: ";
        String stewErrorString = "\nYour Input was Invalid. Enter a number from 1-4 to make your selection.\n";

        // Prompts the user to select a meal from their chosen menu and prints the menu options. //
        System.out.print(chosenMenuString);

        // While loop that runs until the input is valid and boolean is true. // 
        while (!validStewInput) {

            // If statement that makes sure the input is an integer. //
            if (scanner.hasNextInt()) {

                stewChoiceInput = scanner.nextInt(); // Assigns the integer input. //
                scanner.nextLine(); // Used to take care of an issue where prompting for input was skipped. //

                // If statement that runs if the input is within the range of 1 and 4. //
                if (stewChoiceInput >= 1 && stewChoiceInput <= 4) {

                    // Allows the user to correct their input using a method from the extra InputCorrection class before assigning to the menu choice variable. //
                    // The method accepts a range to use so the input is only accepted if within that range.                                                    //
                    stewChoice = InputCorrection.integerInputCorrection("Stew", stewChoiceInput, 1, 4);

                    // Substracting the input by 1, the correct stew is chosen from the menu. //
                    stewChoiceString = chosenStewMenuArray[stewChoice - 1];

                    validStewInput = true; // Sets boolean to true. //

                } else {

                    // Prints an error and the meal options if the user's input was invalid. //
                    System.out.print(stewErrorString + chosenMenuString);

                }

            } else {

                // Prints an error and the meal options if the user's input was invalid. //
                System.out.print(stewErrorString + chosenMenuString);
                scanner.nextLine(); // Used to avoid an issue where the program would stop. //

            }
        }
    }

    // Getter method for the stew of choice. //
    public String getStewChoice() {

        return stewChoiceString;
    }

    // Method that calls all the setter methods. //
    public void heartyStewFoodPreparation() {

        setStewMenuChoice();
        setStewChoice();
        
    }

    // toString method that displays the options selected by the user. //
    public String toString() {

        return "\n*Hearty Stew Selections*\n" + "\nMenu: " + getStewMenuChoice() + "\nStew: " + getStewChoice() + "\n";

    }    


    // Implemented cook method from Meal_Cook that returns the stew selected and its preparation status. //
    @Override
    public String cook(String whatIsBeingCooked) {
        
        String stewFoodPreparation = ""; // String that will contain the preparation status of the chosen stew. //
        
        // If statement that runs if the chosen menu was the Crockpot Menu. Uses a switch statement to choose preparation status to display. //
        if (stewMenuChoiceString.matches("Crockpot Stews")) {

            // Switch statement that uses the stew passed to the method to select the correct case and the preparation status to display. //
            switch (whatIsBeingCooked) {

                case "Chicken Stew": // Runs if the chosen meal was Chicken Stew. //

                    // Assigns the preparation status for Chicken Stew. //
                    stewFoodPreparation = "\nSeasoned with salt and pepper, the chicken is browned in a skillet with olive oil until no longer pink, at which point it is transferred to a crockpot." +
                                     "\nCarrots, onions, garlic, potatoes, coconut aminos, rosemary, salt, oregano, bay leave, and chicken broth are added to the crockpot and cooked on low for 6 hours." +
                                     "\nAfter the 6 hours have passed, a mixture of milk and cornstarch are stirred into the crockpot then cooked on high." +
                                     "\nThe stew is cooked for another 30 minutes and when thickened its then served on a bowl with a side of White Rice.\n";

                    break; 
    
                case "Slow Cooker Beef Stew": // Runs if the chosen meal was Slow Cooker Beef Stew. //
    
                    // Assigns the preparation status for Slow Cooker Beef Stew. //
                    stewFoodPreparation = "\nSeasoned with salt and pepper, cubed beef is browned on an oiled skillet then added to a crockpot alongsided onions, celery, potatoes, carrots, and beef broth." +
                                     "\nSalt, pepper, tomato paste, and Worcestershire sauce, garlic, bay leaves, and dried thyme are added and stirred together; Then left to cook on low heat for 6 hours." +
                                     "\nSome of the broth in the stew is mixed with cornstarch and added once more to thicken the stew and left to cook further for 30 more minutes." +
                                     "\nWhen ready, the stew is served on a bowl with a side of Brown Rice.\n";

                    break;                   
    
                case "Italian Bean Stew": // Runs if the chosen meal was Italian Bean Stew. //

                    // Assigns the preparation status for Italian Bean Stew. //
                    stewFoodPreparation = "\nSausage is browned and broken into chunks on an oiled crockpot then tomatoes, soaked beans, chicken stock, and italian seasoning are mixed together are cooked on high heat until boiling." +
                                     "\nWhen boiled, stew is cooked for an hour on low heat with occassional stirring. After the hour has passed, chopped kale and parmesan rind are added and simmered for an additional 30 minutes." +
                                     "\nAfterwards, the stew is seasoned with salt and pepper then served on bowls along with Cilantro Lime Rice.\n ";

                    break; 
    
                case "Cachupa Stew": // Runs if the chosen meal was Cachupa Stew. //

                    // Assigns the preparation status for Cachupa Stew. //
                    stewFoodPreparation = "\nWhile on low heat, corn, red beans, onions, garlic, bay leaves, chopped pork loins, potatoes, sliced sausage, tomatoes, and bacon are added to an oiled crockpot." +
                                     "\nAfter stirring well, the pot is covered and left to cook on low heat for 7 hours at which point the meat and vegetables are tender." +
                                     "\nWhen the stew is ready the bay leaves are discarded and its served on a bowl with a side of Jagacinda, a traditional rice from Cape Verde.\n";

                    break; 
                
            }


        // Runs if the chosen menu was the Stovetop Menu. Uses a switch statement to choose preparation status to display. //
        } else if (stewMenuChoiceString.matches("Stovetop Stews")) {

            // Switch statement that uses the stew passed to the method to select the correct case and the preparation status to display. //
            switch (whatIsBeingCooked) {

                case "Fish Stew": // Runs if the chosen meal was Fish Stew. //

                    // Assigns the preparation status for Fish Stew. //
                    stewFoodPreparation = "\nThe stew is prepared on a pot with oil over medium heat where onions, potatoes, butter, tomato paste, and crushed red peppers are cooked then mixed with chickpeas and stock." +
                                     "\nWhen everything is mixed together, they're cooked on medium heat for 10 minutes after which the fish is placed on top of the soup, drizzled with olive oil, then cooked for 8 minutes." +
                                     "\nWhen ready, the stew is topped with parsley and lemon juice and served on a bowl with slices of toasted bread on the side.\n";

                    break;         
    
                case "Chickpea Stew": // Runs if the chosen meal was Chickpea Stew. //
    
                    // Assigns the preparation status for Chickpea Stew. //
                    stewFoodPreparation = "\nChopped onions, celery, are cooked on an oiled crockpot on low heat for 5 minutes then ginger, garlic, red pepper flakes, cumin and turmeric are added." +
                                     "\nWhen the fragant aroma of the spices is released, tomatoes, sweet potato, chickpeas, water, salt and pepper are added and cooked on medium heat for 20 minutes." +
                                     "\nAfter cooked, and the stew has thickened, the stew is served in a bowl with a side of naan bread.\n";

                    break;                   
    
                case "Kale and White Bean Stew": // Runs if the chosen meal was Kale and White Bean Stew. //

                    // Assigns the preparation status for Kale and White Bean Stew. //
                    stewFoodPreparation = "\nSausage is cooked and broken up for 2 minutes on an oiled crockpot for 2 minutes, then onions and kale are added and cooked for 3 minute." +
                                     "\nWhen the vegetables are tender, grated garlic, tomatoes, salt, and pepper are stirred into the mix then cooked for 15 minutes." +
                                     "\nAfter the 15 minutes have passed, cannellini beans are added and cooked on low heat for an extra 5 minutes, then served on a bowl with a side of Brown Rice.\n";
                    break;         

    
                case "Herbed Chicken and Potato Stew": // Runs if the chosen meal was Herbed Chicken and Potato Stew. //

                    // Assigns the preparation status for RiHerbed Chicken and Potato Stew. //
                    stewFoodPreparation = "\nOn an oiled crockpot set to medium high heat, garlic, potatoes, celery, carrots, onion, mushrooms, dill, parsley, thyme, salt, and pepper are added and cooked for 15 minutes." +
                                     "\nWhen the mix has softened, two cups of the vegetable mixture are blended together with chicken broth and flour, then added back to the stew with chopped chicken and cooked for 10 minutes." +
                                     "\nAfter the chicken is ready, the stew is served on a bowl with a side of bread.\n";
                    break; 
                
            }

        }

        // Concatenates the chosen stew with its preparation method to be returned by the method. //
        stewFoodStatus =  "\n*Hearty Stew Status*\n\n" + whatIsBeingCooked + ":\n" + stewFoodPreparation + "\n";

        return stewFoodStatus;
    }
    
}