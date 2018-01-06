/*
 * POO - tema 2
 * SERBAN Mihnea
 * 321CA
 */

package cad.shapes;

import cad.fundamental.Image;
import cad.interfaces.IShape;

public class Circle implements IShape {
    private final int x;
    private final int y;
    private final int radius;
    private final int edgeColor;
    private final int fillColor;

    public Circle(final int xP, final int yP, final int radiusP,
                     final int edgeColorP, final int fillColorP) {
        this.x = xP;
        this.y = yP;
        this.radius = radiusP;
        this.edgeColor = edgeColorP;
        this.fillColor = fillColorP;
    }

    @Override
    public final void draw(final Image image) {
        image.drawCircle(x, y, radius, edgeColor);
        image.floodFill(x, y, edgeColor, fillColor);
    }
}
