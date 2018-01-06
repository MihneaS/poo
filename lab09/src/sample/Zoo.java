package sample;

import java.util.LinkedList;

public class Zoo {
    LinkedList<Animal> list = new LinkedList<>();

    public void addAnimal(Animal a) {
        list.add(a);
    }

    public Animal getLastAnimal() {
        return list.getLast();
    }

    public void removeAnimal(Animal a) {
        list.remove(a);
    }

    public boolean containsAnimal(Animal a) {
        return list.contains(a);
    }

    public boolean areAnimals() {
        return !list.isEmpty();
    }

    public LinkedList<Animal> getAnimals() {
        return list;
    }

    public int size() {
        return list.size();
    }
}
