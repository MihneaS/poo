package figures;

import visitors.Visitor;

public class Line implements Figure {
    
    String[] figureArguments;

    public Line(final String[] specs) {
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
