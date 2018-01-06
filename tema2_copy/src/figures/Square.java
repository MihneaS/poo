package figures;

import visitors.Visitor;

public class Square implements Figure {
    
    String[] figureArguments;

    public Square(final String[] specs) {
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
