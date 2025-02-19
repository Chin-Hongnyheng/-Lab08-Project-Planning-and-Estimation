package com.nyheng;

import java.util.Scanner;

public class ANSI {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Display welcome message
        System.out.println(" __       __            __                                                      __                     __       __                      __              __                                          ________                                            __     __      __                            ________                    __            __ \r\n" + //
                        "|  \\  _  |  \\          |  \\                                                    |  \\                   |  \\     /  \\                    |  \\            |  \\                                        |        \\                                          |  \\   |  \\    |  \\                          |        \\                  |  \\          |  \\\r\n" + //
                        "| $$ / \\ | $$  ______  | $$  _______   ______   ______ ____    ______         _| $$_    ______        | $$\\   /  $$  ______    ______  | $$   __   ____| $$  ______   __   __   __  _______        | $$$$$$$$______    ______   ______ ____    ______ _| $$_ _| $$_    \\$$ _______    ______         \\$$$$$$$$______    ______  | $$  _______ | $$\r\n" + //
                        "| $$/  $\\| $$ /      \\ | $$ /       \\ /      \\ |      \\    \\  /      \\       |   $$ \\  /      \\       | $$$\\ /  $$$ |      \\  /      \\ | $$  /  \\ /      $$ /      \\ |  \\ |  \\ |  \\|       \\       | $$__   /      \\  /      \\ |      \\    \\  |      \\   $$ \\   $$ \\  |  \\|       \\  /      \\          | $$  /      \\  /      \\ | $$ /       \\| $$\r\n" + //
                        "| $$  $$$\\ $$|  $$$$$$\\| $$|  $$$$$$$|  $$$$$$\\| $$$$$$\\$$$$\\|  $$$$$$\\       \\$$$$$$ |  $$$$$$\\      | $$$$\\  $$$$  \\$$$$$$\\|  $$$$$$\\| $$_/  $$|  $$$$$$$|  $$$$$$\\| $$ | $$ | $$| $$$$$$$\\      | $$  \\ |  $$$$$$\\|  $$$$$$\\| $$$$$$\\$$$$\\  \\$$$$$$\\$$$$$$\\$$$$$$  | $$| $$$$$$$\\|  $$$$$$\\         | $$ |  $$$$$$\\|  $$$$$$\\| $$|  $$$$$$$| $$\r\n" + //
                        "| $$ $$\\$$\\$$| $$    $$| $$| $$      | $$  | $$| $$ | $$ | $$| $$    $$        | $$ __| $$  | $$      | $$\\$$ $$ $$ /      $$| $$   \\$$| $$   $$ | $$  | $$| $$  | $$| $$ | $$ | $$| $$  | $$      | $$$$$ | $$  | $$| $$   \\$$| $$ | $$ | $$ /      $$| $$ __| $$ __ | $$| $$  | $$| $$  | $$         | $$ | $$  | $$| $$  | $$| $$ \\$$    \\  \\$$\r\n" + //
                        "| $$$$  \\$$$$| $$$$$$$$| $$| $$_____ | $$__/ $$| $$ | $$ | $$| $$$$$$$$        | $$|  \\ $$__/ $$      | $$ \\$$$| $$|  $$$$$$$| $$      | $$$$$$\\ | $$__| $$| $$__/ $$| $$_/ $$_/ $$| $$  | $$      | $$    | $$__/ $$| $$      | $$ | $$ | $$|  $$$$$$$| $$|  \\ $$|  \\| $$| $$  | $$| $$__| $$         | $$ | $$__/ $$| $$__/ $$| $$ _\\$$$$$$\\ __ \r\n" + //
                        "| $$$    \\$$$ \\$$     \\| $$ \\$$     \\ \\$$    $$| $$ | $$ | $$ \\$$     \\         \\$$  $$\\$$    $$      | $$  \\$ | $$ \\$$    $$| $$      | $$  \\$$\\ \\$$    $$ \\$$    $$ \\$$   $$   $$| $$  | $$      | $$     \\$$    $$| $$      | $$ | $$ | $$ \\$$    $$ \\$$  $$\\$$  $$| $$| $$  | $$ \\$$    $$         | $$  \\$$    $$ \\$$    $$| $$|       $$|  \\\r\n" + //
                        " \\$$      \\$$  \\$$$$$$$ \\$$  \\$$$$$$$  \\$$$$$$  \\$$  \\$$  \\$$  \\$$$$$$$          \\$$$$  \\$$$$$$        \\$$      \\$$  \\$$$$$$$ \\$$       \\$$   \\$$  \\$$$$$$$  \\$$$$$$   \\$$$$$\\$$$$  \\$$   \\$$       \\$$      \\$$$$$$  \\$$       \\$$  \\$$  \\$$  \\$$$$$$$  \\$$$$  \\$$$$  \\$$ \\$$   \\$$ _\\$$$$$$$          \\$$   \\$$$$$$   \\$$$$$$  \\$$ \\$$$$$$$  \\$$\r\n" + //
                        "                                                                                                                                                                                                                                                                                    |  \\__| $$                                                    \r\n" + //
                        "                                                                                                                                                                                                                                                                                     \\$$    $$                                                    \r\n" + //
                        "                                                                                                                                                                                                                                                                                      \\$$$$$$                                                     ");

        System.out.print("Enter the text you want to format: ");
        String userInput = scanner.nextLine();

        boolean continueFormatting = true;
        String formattedText = userInput;

        // Loop to allow the user to format the text multiple times
        while (continueFormatting) {
            //Display formatting options
            System.out.println("Choose a formatting option:");
            System.out.println("1. Bold");
            System.out.println("2. Italic");
            System.out.println("3. Color");
            System.out.println("4. Highlighted");
            System.out.println("5. Underlined");
            System.out.println("6. Hidden");
            System.out.println("7. Strikethrough");
            System.out.println("8. Heading 1");
            System.out.println("9. Heading 2");
            System.out.println("10. Exit");

            //Get user's choice
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            //Apply formatting based on user's choice
            switch (choice) {
                case 1:
                    formattedText = "\u001B[1m" + formattedText + "\u001B[0m";
                    break;
                case 2:
                    formattedText = "\u001B[3m" + formattedText + "\u001B[0m";
                    break;
                case 3:
                    // Display color options
                    System.out.println("Choose a color:");
                    System.out.println("1. Red");
                    System.out.println("2. Green");
                    System.out.println("3. Yellow");
                    System.out.println("4. Blue");
                    System.out.println("5. Magenta");
                    System.out.println("6. Cyan");
                    System.out.println("7. White");
                    System.out.println("8. Black");

                    int colorChoice = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    switch (colorChoice) {
                        case 1:
                            formattedText = "\u001B[31m" + userInput + "\u001B[0m";
                            break;
                        case 2:
                            formattedText = "\u001B[32m" + userInput + "\u001B[0m";
                            break;
                        case 3:
                            formattedText = "\u001B[33m" + userInput + "\u001B[0m";
                            break;
                        case 4:
                            formattedText = "\u001B[34m" + userInput + "\u001B[0m";
                            break;
                        case 5:
                            formattedText = "\u001B[35m" + userInput + "\u001B[0m";
                            break;
                        case 6:
                            formattedText = "\u001B[36m" + userInput + "\u001B[0m";
                            break;
                        case 7:
                            formattedText = "\u001B[37m" + userInput + "\u001B[0m";
                            break;
                        case 8:
                            formattedText = "\u001B[30m" + userInput + "\u001B[0m";
                            break;
                        default:
                            System.out.println("Invalid color choice.");
                    }
                    break;
                case 4:
                    formattedText = "\u001B[47m" + formattedText + "\u001B[0m";
                    break;
                case 5:
                    formattedText = "\u001B[4m" + formattedText + "\u001B[0m";
                    break;
                case 6:
                    formattedText = "\u001B[8m" + formattedText + "\u001B[0m";
                    break;
                case 7:
                    formattedText = "\u001B[9m" + formattedText + "\u001B[0m";
                    break;
                case 8:
                    formattedText = "# " + formattedText;// Won't change the text size in the terminal but will be displayed as a heading in markdown.
                    break;
                case 9:
                    formattedText = "## " + formattedText;// Won't change the text size in the terminal but will be displayed as a heading in markdown.
                    break;
                case 10:
                    continueFormatting = false;
                    break;
                default:
                    System.out.println("Invalid choice.");
                    System.out.print("Do you want to continue? (yes/no): ");
                    String response = scanner.nextLine(); // line reads the user's response.
                    if (!response.equalsIgnoreCase("yes")) { // line checks if the user's response is not equal to "yes". If it is not equal to "yes", the program will stop.
                        continueFormatting = false;
                    }
            }
            //Display the formatted text if continuing
            if (continueFormatting) {
                System.out.println("Formatted text: " + formattedText);
            }
        }

        scanner.close();
    }
}