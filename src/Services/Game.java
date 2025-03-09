package Services;

import Modules.*; // import Modules og alt indhold
import java.util.Scanner;


public class Game {
    // instatiate cat og dog uden for main for at gøre det global
    static Cat cat;
    static Dog dog;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // call choiceLogic
        choiceLogic(scanner);

        scanner.close();
    }

    public static void choiceLogic(Scanner scanner) {
        System.out.println("Choose cat or dog");

        // infinite loop, med prompt for cat eller dog, og navn.
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("cat") || input.equals("dog")) {
                System.out.println("input name");
                String name = scanner.nextLine();
                if (input.equals("cat")) {
                    // hvis der allerede findes en cat eller en dog, hop direkte til gameLogic
                    if (cat == null) {
                        cat = new Cat(name);
                        System.out.println("Creating a new cat named " + name);
                        gameLogic(scanner, cat);
                    } else {
                        gameLogic(scanner, cat);
                    }
                    break;
                } else {
                    if (dog == null) {
                        dog = new Dog(name);
                        System.out.println("created a new dog named " + name);
                        gameLogic(scanner, dog);
                    } else {
                        gameLogic(scanner, dog);
                    }
                    break;
                }
            } else {
                // efter check må alt andet være forkert input
                System.out.println("wrong input");
            }
        }
    }

    public static void gameLogic(Scanner scanner, Tamagochi pet) {

        // infinite loop med choices,
        while (true) {
            System.out.print("play");


            // hvis der findes to objekter, giv bruger mulighed for interaction
            if (cat != null && dog != null) {
                System.out.print(" | play together");
            }

            System.out.println(" | feed | sleep | switch | exit");

            String input = scanner.nextLine();

            if (input.equals("play")) {
                pet.play();
            } else if (input.equals("play together") && cat != null && dog != null) {
                System.out.println(cat.getName() + " and " + dog.getName() + " are playing together!");
                cat.play();
                dog.play();
            } else if (input.equals("feed")) {
                pet.feed();
            } else if (input.equals("sleep")) {
                pet.sleep();
            } else if (input.equals("switch")) {
                switchLogic(scanner, pet);
                return;
            } else if (input.equals("exit")) {
                System.out.println("Exiting game...");
                break;
            } else {
                System.out.println("Wrong input");
            }
        }
    }

    // method for switch logic
    public static void switchLogic(Scanner scanner, Tamagochi currentPet) {
        System.out.println("Switching...");


        // check for hvilken objekt vi bruger
        // hvis vi bruger Cat lav dog, og omvendt.
        if (currentPet instanceof Cat) {
            if (dog == null) {
                System.out.println("No existing dog found, creating a new one...");
                System.out.println("Enter dog's name: ");
                String name = scanner.nextLine();
                dog = new Dog(name);
                System.out.println("Created a new dog named " + name);
            }
            System.out.println("Switching to dog: " + dog.getName());
            gameLogic(scanner, dog);

        } else {
            if (cat == null) {
                System.out.println("No existing cat found, creating a new one...");
                System.out.println("Enter cat's name: ");
                String name = scanner.nextLine();
                cat = new Cat(name);
                System.out.println("Created a new cat named " + name);
            }
            System.out.println("Switching to cat: " + cat.getName());
            gameLogic(scanner, cat);
        }
    }
}