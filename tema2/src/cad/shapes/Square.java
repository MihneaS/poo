package cad.shapes;

import cad.fundamental.Canvas;

public class Square extends Rectangle{
    public final static String NAME = "SQUARE";

    public Square(final int x, final int y, final int length,
                  final int edgeColor, final  int fillColor) {
        super(x, y, length, length, edgeColor, fillColor);
    }
}
