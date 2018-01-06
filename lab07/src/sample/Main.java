package sample;

import java.awt.*;
import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

import static java.lang.Math.*;

public class Main {

    public static void main(String[] args) {
        Set<Student> set = new HashSet<Student>();

        Student s = new Student("ana", 10);

        set.add(s);
        if(set.add(new Student("ana", 5)) == false) {
            System.err.println("exista deja");
        }

        Iterator<Student> it = set.iterator();
        Student s2 = it.next();
        if (s != s2) {
            System.err.println("Bad Student nu e acelasi");
        }

        Student s10 = new Student("maria", 5);
        set.add(s10);
        Student s11 = new Student("ana-maria", 5);
        set.add(s11);

        for (Student s3: set) {
            System.out.println(s3.equals(s3));
            System.out.println(((Object)s3).equals(s3));
        }


        Gradebook gradebook = new Gradebook(new GradeComparator());

        gradebook.add(s10);
        gradebook.add(s2);
        gradebook.add(s);
        gradebook.add(s11);

        BiConsumer<Integer, LinkedList<Student>> ordonator = new BiConsumer<Integer, LinkedList<Student>>() {
            @Override
            public void accept(Integer integer, LinkedList<Student> students) {
                Collections.sort(students);
            }
        };

        gradebook.forEach(ordonator);

        BiConsumer<Integer, LinkedList<Student>> printer = new BiConsumer<Integer, LinkedList<Student>>() {
            @Override
            public void accept(Integer integer, LinkedList<Student> students) {
                for (Student s: students) {
                    System.out.println(integer + ": " + s.nume);
                }
            }
        };

        gradebook.forEach(printer);

        My my1 = new My();
        My my2 = new My();

        my1.add(3);
        my2.add(4);
        my2.add(4);
        my2.add(5);

        my1.addAll(my2);

        System.out.println(my1.total);
        Ny ny1 = new Ny();
        Ny ny2 = new Ny();

        ny1.add(3);
        ny2.add(4);
        ny2.add(4);
        ny2.add(5);

        ny1.addAll(ny2);

        System.out.println(ny1.total);


    }
}


class Student implements Comparable{
    final String nume;
    final float medie;

    Student(String nume, float medie) {
        this.nume = nume;
        this.medie = medie;
    }

    @Override
    public String toString() {
        return nume + "are media " + medie;
    }

    @Override
    public int hashCode() {
        return toString().hashCode();
    }

    @Override
    public boolean equals(Object o) {
        return toString().equals(o.toString());
    }

    public boolean equals(Student other) {
        return false;
    }

    @Override
    public int compareTo(Object o) {
        return compareTo((Student) o);
    }
    public int compareTo(Student s) {
        return this.nume.compareTo(s.nume);
    }
}

class Gradebook extends TreeMap<Integer, LinkedList<Student>> {

    Gradebook(Comparator cmp) {
        super(cmp);
    }

    public LinkedList<Student> put(Float aFloat, Student s) {
        if (aFloat < 0 || aFloat > 10) {
            System.err.println("Medie proasta");
            return  null;
        }
        if (super.get(round(aFloat)) == null) {
            super.put(round(aFloat), new LinkedList<Student>());
        }
        super.get(round(aFloat)).add(s);
        return super.get(round((aFloat)));
    }

    public void add(Student s) {
        put(s.medie, s);
    }

    @Override
    public void forEach(BiConsumer<? super Integer, ? super LinkedList<Student>> biConsumer) {
        super.forEach(biConsumer);
    }


}

class GradeComparator implements Comparator<Integer> {

    @Override
    public int compare(Integer o1, Integer o2) {

        // descending order (ascending order would be:
        // o1.getGrade()-o2.getGrade())
//        return (int) (o2.medie - o1.medie);
        return o2 - o1;
    }

}



class My extends HashSet<Integer> {
    public int total;

    @Override
    public boolean add(Integer integer) {
        total++;
        return super.add(integer);
    }

    @Override
    public boolean addAll(Collection<? extends Integer> collection) {
        boolean ret = true;
        for (Integer i: collection) {
            if (add(i) == false) {
                ret = false;
            }
        }
        return ret;
    }
}
class Ny extends LinkedList<Integer> {
    public int total;

    @Override
    public boolean add(Integer integer) {
        total++;
        return super.add(integer);
    }

    @Override
    public boolean addAll(Collection<? extends Integer> collection) {
        boolean ret = true;
        for (Integer i: collection) {
            if (add(i) == false) {
                ret = false;
            }
        }
        return ret;
    }
}
