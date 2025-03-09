package Modules;

public class Dog extends Tamagochi{

    public Dog(String name) {
        super(name);

    }

    // override play method med en besked
    public void play() {
        if (!getIsDead()) {
            System.out.println("Wags tail");

        }
        super.play();
    }


    @Override
    public void makeSound(){
        System.out.println("Wuph!");
    }

    @Override
    public String toString() {
        return getName() + " " + getAge() + " " + getMood() + " " + getEnergy() + " " + getIsDead();
    }
}