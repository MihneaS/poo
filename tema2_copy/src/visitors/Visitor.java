package visitors;

import figures.Circle;
import figures.Diamond;
import figures.Line;
import figures.Polygon;
import figures.Rectangle;
import figures.Square;
import figures.Triangle;

public interface Visitor {

    void visit(Line li);
    
    void visit(Square sq);
    
    void visit(Rectangle re);
    
    void visit(Circle ci);
    
    void visit(Triangle tr);
    
    void visit(Diamond di);
    
    void visit(Polygon po);
    
}
