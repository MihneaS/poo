package lab.visitor;

/**
 * Visitor for tree traversal - separate the concerns: a visitor for data
 * operations (e.g. compute average percentage) and this visitor for traversing
 * the nodes and applying the operation visitor.
 */
class TreeVisitor implements Visitor {

    private Visitor baseVisitor;

    TreeVisitor(final Visitor newBaseVisitor) {
        this.baseVisitor = newBaseVisitor;
    }

    @Override
    public void visit(final Employee e) {
        e.accept(getBaseVisitor());
    }

    @Override
    public void visit(final Boss b) {
        if (b != null)
        for (Visitable e: b.getSubordinates()) {
            e.accept(getBaseVisitor());
        }
        b.accept(getBaseVisitor());

    }

    public Visitor getBaseVisitor() {
        return baseVisitor;
    }
}
