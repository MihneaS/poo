package figures;

import visitors.Visitor;

public class Circle implements Figure {
    
    String[] figureArguments;

    public Circle(final String[] specs) {
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
