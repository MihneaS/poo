package sample;

public class Animal {
    String name;
    int nrCrt;
    static int n;

    Animal(String name) {
        this.name = name;
        ++n;
        nrCrt = n;
    }

    @Override
    public String toString() {
        return name;
    }
}
