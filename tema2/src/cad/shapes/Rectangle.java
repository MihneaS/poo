package cad.shapes;

import cad.fundamental.Canvas;
import cad.interfaces.IShape;

public class Rectangle implements IShape {
    public final static String NAME = "RECTANGLE";
    private final int minX;
    private final int maxX;
    private final int minY;
    private final int maxY;
    private final int edgeColor;
    private final int fillColor;

    public Rectangle(final int x, final int y, final int height, final int width,
                     final int edgeColor, final int fillColor) {
        if (width >= 0) {
            minX = x;
            maxX = x + width - 1;
        } else {
            maxX = x;
            minX = x + width - 1;
        }
        if (height >= 0) {
            minY = y;
            maxY = y + height - 1;
        } else {
            maxY = y;
            minY = y + height - 1;
        }
        this.edgeColor = edgeColor;
        this.fillColor = fillColor;
    }

    @Override
    public void drawOn(Canvas canvas) {
        canvas.drawRectangle(minX, minY, maxX, maxY, edgeColor);
        canvas.fillRectangle(minX + 1, minY + 1, maxX - 1, maxY - 1,
                fillColor);
    }
}
