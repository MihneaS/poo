package figures;

import visitors.Visitor;

public class Diamond implements Figure {

    String[] figureArguments;

    public Diamond(final String[] specs) {
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
