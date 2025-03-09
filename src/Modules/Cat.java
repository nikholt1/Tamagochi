package Modules;



public class Cat extends Tamagochi {
    public Cat(String name) {
        super(name);

    }

    // override method med en besked
    public void play() {
        if (!getIsDead()) {
            System.out.println("Purrs");

        }
        super.play();
    }

    @Override
    public void makeSound() {
        System.out.println("Mi ow!");
    }


    @Override
    public String toString() {
        return getName() + " " + getAge() + " " + getMood() + " " + getEnergy() + " " + getIsDead();
    }


}