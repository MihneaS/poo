/*
 * POO - tema 2
 * SERBAN Mihnea
 * 321CA
 */

package cad.shapes;

import cad.fundamental.Image;
import cad.interfaces.IShape;

public final class Polygon implements IShape {
    private final int[] xs;
    private final int[] ys;
    private final int edgeColor;
    private final int fillColor;
    private final int sumX;
    private final int sumY;

    public Polygon(final int[] xsP, final int[] ysP,
                   final int edgeColorP, final int fillColorP) {
        this.xs = xsP;
        this.ys = ysP;
        this.edgeColor = edgeColorP;
        this.fillColor = fillColorP;

        int s = 0;
        for (int x: xs) {
            s += x;
        }
        sumX = s;
        s = 0;
        for (int y: ys) {
            s += y;
        }
        sumY = s;
    }

    @Override
    public void draw(final Image image) {
        image.drawPolygon(xs, ys, edgeColor);
        image.floodFill(sumX / xs.length, sumY / ys.length,
                edgeColor, fillColor);
    }
}
