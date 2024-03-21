import java.util.Scanner;

public class InputCorrection {

    public static Scanner scanner = new Scanner(System.in);
    
    // Method use for input correction, accepts a parameter for the variable's name and the input for it //
    public static String inputCorrection(String fieldName, String userInput ){

        // Variables for the method //
        boolean finishedCorrection = false; // boolean used in the first while loop //
        String inputToCorrect = userInput; // String that is returned after the input is corrected, if necessary //
        String confirmInput; // String variable used for confirmation of needs for correction //

        // While loop that stops when the user confirms no further need of correction //
        while(!finishedCorrection){

            // Prompts the user to confirm if they want to make corrections or not //
            System.out.print("\nThe " + fieldName + " you chose was [" + userInput + "]. Do you wish to make changes?\n" + 
            "(Type 'Yes' to make changes or 'No' to continue): ");
            String yesOrNoInput = scanner.nextLine().trim();

            // If loop that runs if the user indicated they need to make corrections //
            if (yesOrNoInput.equalsIgnoreCase("yes")) {

                boolean correctedInput = false;// Boolean used in the while loop below //

                // While loop that allows user to make corrections, exits when the user indicates no further corrections are needed //
                while(!correctedInput) {

                    // Prompts user for the corrected input //
                    System.out.print("\nEnter the correct " + fieldName + ": ");
                    inputToCorrect = scanner.nextLine();

                    // Shows user their entered correction and asks to confirm if it is now correct or not //
                    System.out.print("\nYou chose [" + inputToCorrect + "] for " + fieldName + ". Is this correct?" + "\n(Type 'Yes' to Confirm or 'No' to Re-Enter): ");
                    confirmInput = scanner.nextLine().trim();

                    // If user confirms it is correct, correctedInput is set to true and exits the while loop //
                    if(confirmInput.equalsIgnoreCase("yes")) {

                        correctedInput = true;

                    // If user indicates it is still not correct, it loops back to ask for the correct input //
                    } else if (confirmInput.equalsIgnoreCase("no")) {

                        correctedInput = false; // Placed simply to show that the boolean remains as false, not necessary //

                    
                    } else {
                        
                        // Error displayed if the user enters something other than yes or no when asked for confirmation //
                        System.out.print("\nYour input was invalid. Please enter either 'Yes' or 'No'.\n");
                        correctedInput = false;
                    }
                }

                finishedCorrection = true; // Sets Boolean to true if corrections are done //

            } else if (yesOrNoInput.equalsIgnoreCase("no")) {

                finishedCorrection = true; // Sets Boolean to true if no corrections were needed //

            } else {

                // Error displayed if the user enters something other than yes or no when asked for confirmation //
                System.out.print("\nYour input was invalid. Please enter either 'Yes' or 'No'.\n");
            }
        }        
        return inputToCorrect; // Returns the input after correction or as is if no corrections were needed //     
    } 
    
    // Method used for input correction of integers, accepts a parameter for the variable's name, the input for it,  //
    public static int integerInputCorrection(String fieldName, int userInput, int minRange, int maxRange) {

        // Variables for the method //

        boolean finishedCorrection = false; // boolean used in the first while loop //
        int inputToCorrect = userInput; // Input that is returned after the input is corrected, if necessary //
        String confirmInput; // String variable used for confirmation of needs for correction //
    
        // While loop that stops when the user confirms no further need of correction //
        while (!finishedCorrection) {

            // Prompts the user to confirm if they want to make corrections or not //
            System.out.print("\nThe " + fieldName + " you chose was [" + userInput + "]. Do you wish to make changes?\n" +
                            "\n(Type 'Yes' to make changes or 'No' to continue): ");

            String yesOrNoInput = scanner.nextLine().trim();
    
            // If loop that runs if the user indicated they need to make corrections //
            if (yesOrNoInput.equalsIgnoreCase("yes")) {

                boolean correctedInput = false; // Boolean used in the while loop below //
    
                // While loop that allows user to make corrections, exits when the user indicates no further corrections are needed //
                while (!correctedInput) {

                    // Prompts user for the corrected input //
                    System.out.print("\nEnter the correct " + fieldName + ": ");
    
                    boolean validInput = false; // Boolean used in the inner while loop below//
    
                    // While loop that verifies validity of the corrected input, makes sure its an integer before assigning //
                    while (!validInput) {

                        // If statement that makes sure the input is an integer //
                        if (scanner.hasNextInt()) {

                            inputToCorrect = scanner.nextInt(); // Assigns the corrected integer input //
                            scanner.nextLine();
    
                            // If statement to make sure the corrected input is within the range passed to the method //
                            if (inputToCorrect >= minRange && inputToCorrect <= maxRange) {

                                validInput = true; // Input is within the specified range

                            } else {

                                // If the input is outside of the range the following error message is printed and the user is prompted for input again //
                                System.out.println("\nYour input was invalid. Please enter a numerical value within the range " + minRange + " to " + maxRange + ".\n");
                                System.out.print("\nEnter the correct " + fieldName + ": ");

                            }

                        } else {

                            // If the input is not an integer the following error message is printed and the user is prompted for input again //
                            System.out.println("\nYour input was invalid. Please enter a numerical value.\n");
                            System.out.print("\nEnter the correct " + fieldName + ": ");
                            scanner.nextLine();

                        }
                    }
    
                    // Shows user their entered correction and asks to confirm if it is now correct or not //
                    System.out.print("\nYou chose [" + inputToCorrect + "] for " + fieldName + ". Is this correct?\n" +
                                    "\n(Type 'Yes' to Confirm or 'No' to Re-Enter): ");

                    confirmInput = scanner.nextLine().trim();
    
                    // If user confirms it is correct, correctedInput is set to true and exits the while loop //
                    if (confirmInput.equalsIgnoreCase("yes")) {

                        correctedInput = true; // Sets boolean to true so loop can be escaped //

                    } else if (confirmInput.equalsIgnoreCase("no")) {

                        correctedInput = false; // Placed simply to show that the boolean remains as false, not necessary //

                    } else {

                        // Error displayed if the user enters something other than yes or no when asked for confirmation //
                        System.out.print("\nYour input was invalid. Please enter either 'Yes' or 'No'.\n");
                        correctedInput = false;

                    }
                }
    
                finishedCorrection = true; // Sets Boolean to true if corrections are done //

            } else if (yesOrNoInput.equalsIgnoreCase("no")) {

                finishedCorrection = true; // Sets Boolean to true if no corrections were needed //

            } else {

                // Error displayed if the user enters something other than yes or no when asked for confirmation //
                System.out.print("Your input was invalid. Please enter either 'Yes' or 'No'.");

            }
        }

        return inputToCorrect; // Returns the input after correction or as is if no corrections were needed //
    }
    
}
