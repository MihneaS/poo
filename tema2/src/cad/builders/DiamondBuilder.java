/*
 * POO - tema 2
 * SERBAN Mihnea
 * 321CA
 */

package cad.builders;

import cad.interfaces.IBuilder;
import cad.interfaces.IShape;
import cad.shapes.Polygon;

public final class DiamondBuilder implements IBuilder {
    private static DiamondBuilder ourInstance = new DiamondBuilder();

    public static DiamondBuilder getInstance() {
        return ourInstance;
    }

    private DiamondBuilder() { }

    @Override
    public IShape build(final String[] args) {
        Parser parser = new Parser(args);
        int n = 4;
        int xc = parser.nextInt();
        int yc = parser.nextInt();
        int horizontalDiag = parser.nextInt();
        int verticalDiag = parser.nextInt();
        int[] xs = new int[n];
        int[] ys = new int[n];
        int i = 0;
        xs[i] = xc;
        ys[i] = yc + verticalDiag / 2;
        ++i;
        xs[i] = xc + horizontalDiag / 2;
        ys[i] = yc;
        ++i;
        xs[i] = xc;
        ys[i] = yc - verticalDiag / 2;
        ++i;
        xs[i] = xc - horizontalDiag / 2;
        ys[i] = yc;
        int edgeColor = parser.nextColor();
        int fillColor = parser.nextColor();
        return new Polygon(xs, ys, edgeColor, fillColor);
    }
}
