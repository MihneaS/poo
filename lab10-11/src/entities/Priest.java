package entities;

public class Priest extends Hero {
    int knowledge;

    @Override
    public void attack() {
        System.out.println("Priest attacked!");
    }
    @Override
    public String toString() {
        return "Prist,k:" + knowledge;
    }
}

