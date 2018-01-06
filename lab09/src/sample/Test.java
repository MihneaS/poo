package sample;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;

import java.util.LinkedList;

public class Test {
    private Zoo zoo;

    @Before
    public void setup() {
        zoo = new Zoo();
    }

    @org.junit.Test
    public void testAddAnimal() {
        Animal leu = new Animal("LEU");
        zoo.addAnimal(leu);

        Assert.assertEquals(zoo.getLastAnimal(),leu);
    }

    @org.junit.Test
    public void testRemoveAnimal() {
        Animal leu = new Animal("LEU");
        zoo.addAnimal(leu);

        zoo.removeAnimal(leu);

        Assert.assertTrue(!zoo.containsAnimal(leu));
    }

    @org.junit.Test
    public void testAreAnimals() {
        Animal leu = new Animal("LEU");
        zoo.addAnimal(leu);

        if(zoo.areAnimals() == false) {
            Assert.fail();
        }
    }

    @org.junit.Test
    public void testgetAnimals() {
        Animal leu = new Animal("LEU");
        Animal leu2 = new Animal("LEU");
        zoo.addAnimal(leu);
        zoo.addAnimal(leu2);
        LinkedList<Animal> lei = zoo.getAnimals();
        Assert.assertFalse(lei.size() != 2);
    }

    @After
    public void tearDown() {
        zoo = null;
    }

}


