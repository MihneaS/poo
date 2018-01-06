/*
 * POO - tema 2
 * SERBAN Mihnea
 * 321CA
 */

package cad.shapes;

import cad.fundamental.Image;
import cad.interfaces.IShape;

public final class Rectangle implements IShape {
    private final int minX;
    private final int maxX;
    private final int minY;
    private final int maxY;
    private final int edgeColor;
    private final int fillColor;

    public Rectangle(final int xP, final int yP,
                     final int heightP, final int widthP,
                     final int edgeColorP, final int fillColorP) {
        if (widthP >= 0) {
            minX = xP;
            maxX = xP + widthP - 1;
        } else {
            maxX = xP;
            minX = xP + widthP - 1;
        }
        if (heightP >= 0) {
            minY = yP;
            maxY = yP + heightP - 1;
        } else {
            maxY = yP;
            minY = yP + heightP - 1;
        }
        this.edgeColor = edgeColorP;
        this.fillColor = fillColorP;
    }

    @Override
    public void draw(final Image image) {
        image.drawRectangle(minX, minY, maxX, maxY, edgeColor);
        image.fillRectangle(minX + 1, minY + 1, maxX - 1, maxY - 1,
                fillColor);
    }
}
