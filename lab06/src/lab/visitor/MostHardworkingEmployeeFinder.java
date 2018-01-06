package lab.visitor;

/**
 * Visitor for finding if the average number of extra hours for bosses is higher
 * than the one for employees.
 * <p>
 * Interns are not taken into consideration.
 */
class MostHardworkingEmployeeFinder implements Visitor {

    int emph=0;
    int bossh=0;

    @Override
    public void visit(final Employee e) {
        if (emph < e.extraHours)        if (emph < e.extraHours)
            emph = (int) e.extraHours;
            emph = (int) e.extraHours;
    }

    @Override
    public void visit(final Boss b) {
        if (bossh < b.extraHours)
            bossh = (int) b.extraHours;
    }

    public boolean isBossHardWorking() {

        return bossh > emph;
    }
}
