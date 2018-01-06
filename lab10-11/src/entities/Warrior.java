package entities;

public class Warrior extends Hero {
    int damage;

    @Override
    public void attack() {
        System.out.println("Warrior attacked!");
    }
    @Override
    public String toString() {
        return "Warrior,d:" + damage;
    }
}
//extra attribute: damage (aka strength)
