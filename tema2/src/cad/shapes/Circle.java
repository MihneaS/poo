package cad.shapes;

import cad.fundamental.Canvas;
import cad.interfaces.IShape;

public class Circle implements IShape {
    public static final String NAME = "CIRCLE";
    private final int x;
    private final int y;
    private final int radius;
    private final int edgeColor;
    private final int fillColor;

    public Circle(final int x, final int y, final int radius,
                     final int edgeColor, final int fillColor) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.edgeColor = edgeColor;
        this.fillColor = fillColor;
    }

    @Override
    public void drawOn(Canvas canvas) {
        canvas.drawCircle(x, y, radius, edgeColor);
        canvas.fludFill(x, y, edgeColor, fillColor);
    }
}
