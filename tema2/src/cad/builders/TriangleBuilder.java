/*
 * POO - tema 2
 * SERBAN Mihnea
 * 321CA
 */

package cad.builders;

import cad.interfaces.IBuilder;
import cad.interfaces.IShape;
import cad.shapes.Polygon;

public final class TriangleBuilder implements IBuilder {
    private static TriangleBuilder ourInstance = new TriangleBuilder();

    public static TriangleBuilder getInstance() {
        return ourInstance;
    }

    private TriangleBuilder() { }

    @Override
    public IShape build(final String[] args) {
        Parser parser = new Parser(args);
        int n = 3;
        int[] xs = new int[n];
        int[] ys = new int[n];
        parser.parsePointsVector(xs, ys, n);
        int edgeColor = parser.nextColor();
        int fillColor = parser.nextColor();
        return new Polygon(xs, ys, edgeColor, fillColor);
    }
}
