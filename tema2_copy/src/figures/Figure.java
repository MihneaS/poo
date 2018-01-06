package figures;

import visitors.Visitor;

public interface Figure {

    void accept(Visitor v);
    
}
