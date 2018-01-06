package figures;

import visitors.Visitor;

public class Triangle implements Figure {
    
    String[] figureArguments;

    public Triangle(final String[] specs) {
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
