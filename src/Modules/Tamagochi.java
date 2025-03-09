package Modules;

import java.util.Random;

public class Tamagochi {



    private static final int MAX_ENERGY = 100;
    private static final int MAX_HUNGER = 100;
    private static final int SAD_HUNGER = 50;
    private static final int VERY_HUNGRY = 70;
    private static final int OLD_AGE = 50;


    private String name;
    private int age = 0;
    private String mood;
    private int hunger = 0;
    private int energy = 50;
    private boolean isDead = false;

    // random til sleep() method
    Random randon = new Random();


    public Tamagochi(String name) {
        this.name = name;

    }


    // makeSound method til at lave lyd, bliver overrided i child methods.
    public void makeSound(){
        System.out.println("Rabble!");
    }
    public boolean getIsDead() {
        return isDead;
    }

    // play method
    public void play() {
        if (!isDead) { // check of Tamagochi er død og ellers udfør play
            int randomNumber = randon.nextInt(1, 25);
            energy -= randomNumber; // opdater stats med et random nummer
            hunger += randomNumber;
            if (randomNumber > 10) { // fortæl bruger om det er meget eller lidt
                System.out.println(getName() + " Runs a lot!");
            } else {
                System.out.println(getName() + " plays a little");
            }
            age += 1; // tick for age increase

            checkStatus(); // check tamagochi stats og om den dør
            if (energy <= 0) {
                isDead = true;
                System.out.println(getName() + " has died.");
            }
        } else {
            System.out.println(getName() + " is dead"); // ellers er tamagochi død
        }


    }

    public void feed() {

        if (!isDead) {
            int randomNumber = randon.nextInt(1, 25);
            energy += randomNumber;
            hunger -= randomNumber; // giv tamagochi random nummer for hvor meget energi increase
            if (randomNumber > 10) {
                System.out.println(getName() + "eats a lot!"); // fortæl bruger om det er meget eller lidt
            } else {
                System.out.println(getName() + "eats a little");
            }
            age += 1; // age tick increase
            checkStatus(); // check stats
        } else {
            System.out.println(getName() +" is dead"); // ellers er tamagochi død
        }

    }

    public void sleep() {
        if (!isDead) {
            int randomNumber = randon.nextInt(1, 10); // giv tamagochi random nummer for at opdatere stats
            hunger += randomNumber;
            System.out.println(getName() + " sleeps " + randomNumber + " hours"); // giv bruger antal af stat increase i timer.
            energy += 10; // energy increase
            age += 1; // age tick increase
            checkStatus(); // chats stats
        } else {
            System.out.println(getName() + " is dead"); // ellers er tamagochi død
        }
    }

    // check stats
    public void checkStatus() {

        // tamagochi energy og mood relation
        if (energy >= MAX_ENERGY && hunger < SAD_HUNGER) {
            mood = "happy";
            System.out.println(getName() + " is " + mood);

        } else if (energy >= MAX_ENERGY / 2 && hunger < SAD_HUNGER) {
            mood = "groggy";
            System.out.println(getName() + " is " + mood);

        } else {
            mood = "very sad";
            System.out.println(getName() + " is " + mood);
        }


        if (energy < 0) {
            isDead = true;
            System.out.println(getName() + " has died from exhaustion.");
        }

        // age logic
        if (age >= OLD_AGE) {
            isDead = true;
            System.out.println(getName() + " has died of old age.");
        }


        // hunger logic
        if (hunger > SAD_HUNGER && hunger <= VERY_HUNGRY) {
            System.out.println(getName() + " is hungry.");
        }
        if (hunger > VERY_HUNGRY && hunger <= MAX_HUNGER) {
            System.out.println(getName() + " is very hungry.");
        }
        if (hunger > MAX_HUNGER) {
            isDead = true;
            System.out.println(getName() + " has died from hunger.");
        }
    }


    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }


    public String getMood() {
        return mood;
    }


    public int getEnergy() {
        return energy;
    }



    public String toString() {
        return name + age + mood + energy + isDead;
    }



}