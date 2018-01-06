package entities;

public class Mage extends Hero {

    @Override
    public void attack() {
        System.out.println("Mage attacked!");
    }

    public void magicAttack() {
        System.out.println("Mage attacked magicly!");
    }

    @Override
    public String toString() {
        return "Mage";
    }
}
