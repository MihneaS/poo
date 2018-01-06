package sample;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Main{

    public static void main(String[] args) {
        MyHashMap<Integer, Mama> salariiToMame = new MyHashMap<>();
        salariiToMame.put(1000, new Mama(40, "Mihaela"));
        salariiToMame.put(2000, new Mama(30, "Marioara"));
        salariiToMame.put(3000, new Mama(20, "Miruna"));
        salariiToMame.put(4000, new Mama(15, "Alice"));

        System.out.println(salariiToMame.get(4000).nume + " castiga mult");
    }
}



class Mama {
    Integer varsta;
    String nume;


    Mama(Integer varsta, String nume) {
        this.varsta = varsta;
        this.nume = nume;
    }

    @Override
    public int hashCode() {
        return (super.hashCode() + varsta.hashCode() + nume.hashCode())/3;
    }
}

class MyHashMap <K, T> {
    List<Entry<K, T>> list = new LinkedList<Entry<K, T>>();
    List<K> existing = new LinkedList<K>();

    class Entry <K, T> {
        K key;
        T value;

        Entry (K key, T value) {
            this.key = key;
            this.value = value;
        }
    }

    public void put(K key, T value) {
        existing.add(key);
        while (list.size() <= key.hashCode()) {
            list.add(new Entry<>(key, value));
        }
        list.add(key.hashCode(), new Entry<K, T>(key, value));
    }

    public T get(K key) {
        if(existing.contains(key)) {
            return list.get(key.hashCode()).value;
        } else {
            return new LinkedList<Entry<K, T>>().get(2).value;
        }
    }

    interface Sumabil <Integer> {
        void addValue(Sumabil value);

        Iterator<Number> iterator();
    }

    abstract class BasicSumabil<Integer> implements Sumabil{
        List<? extends java.lang.Integer> vector;


        public void addValue(Sumabil v2) {
            Iterator<? extends java.lang.Integer> it1 = vector.iterator();
            Iterator<? extends java.lang.Integer> it2 = v2.iterator();
            List<? extends java.lang.Integer> newVector = new ArrayList<>();
            while(it1.hasNext()) {
                int nr1 = (int) it1.next();
                int nr2 = (int) it2.next();
                int sum = nr1 + nr2;
                newVector.add(sum);
            }

            vector = newVector;
        }


    }

    class Myvector3 extends BasicSumabil implements Sumabil {
        ArrayList<Integer> vector = new ArrayList<>(3);

        Myvector3(Integer x, Integer y, Integer z) {
            vector.add(x);
            vector.add(y);
            vector.add(z);
        }

        @Override
        public Iterator<Integer> iterator() {
            vector.iterator();
        }
    }
    class MyMatrix extends BasicSumabil implements Sumabil {
        ArrayList<Integer> vector = new ArrayList<>(16);

        MyMatrix(
                Integer i00, Integer i01, Integer i02, Integer i03,
                Integer i10, Integer i11, Integer i12, Integer i13,
                Integer i20, Integer i21, Integer i22, Integer i23,
                Integer i30, Integer i31, Integer i32, Integer i33,
                 ) {
            vector.add(i00);
            vector.add(i01);
            vector.add(i02);
            vector.add(i03);
            vector.add(i10);
            vector.add(i11);
            vector.add(i12);
            vector.add(i13);
            vector.add(i20);
            vector.add(i21);
            vector.add(i22);
            vector.add(i23);
            vector.add(i30);
            vector.add(i31);
            vector.add(i32);
            vector.add(i33);
        }

        @Override
        public Iterator<Integer> iterator() {
            vector.iterator();
        }
    }

}