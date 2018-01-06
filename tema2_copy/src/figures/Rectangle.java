package figures;

import visitors.Visitor;

public class Rectangle implements Figure {
    
    String[] figureArguments;

    public Rectangle(final String[] specs) {
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
