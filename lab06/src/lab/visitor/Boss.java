package lab.visitor;

import java.util.LinkedList;
import java.util.List;

public class Boss extends Employee {
    protected float bonus;
    protected List<Visitable> list = new LinkedList<>();

    public Boss(final String name, final float salary, final float newBonus) {
        super(name, salary);
        this.bonus = newBonus;
    }

    public Boss(final String name,
                final float salary,
                final float extraHours,
                final float newBonus) {
        super(name, salary, extraHours);
        this.bonus = newBonus;
    }

    public final float getBonus() {
        return bonus;
    }

    public final void setBonus(final float newBonus) {
        this.bonus = newBonus;
    }

    public final LinkedList<Visitable> getSubordinates() {
        return (LinkedList<Visitable>) list;
    }

    public final void addSubordinate(final Visitable subordinate) {
        list.add(subordinate);
    }

    //TODO ex1b - remove accept
    @Override
    public final void accept(final Visitor v) {
        v.visit(this);
    }
}
