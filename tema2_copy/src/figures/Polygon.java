package figures;

import visitors.Visitor;

public class Polygon implements Figure {

    String[] figureArguments;

    public Polygon(final String[] specs) {
        figureArguments = specs;
    }
    
    public String[] getFigureArguments() {
        return figureArguments;
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }

}
