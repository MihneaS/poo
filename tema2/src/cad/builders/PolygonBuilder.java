/*
 * POO - tema 2
 * SERBAN Mihnea
 * 321CA
 */

package cad.builders;

import cad.interfaces.IBuilder;
import cad.interfaces.IShape;
import cad.shapes.Polygon;

public final class PolygonBuilder implements IBuilder {
    private static PolygonBuilder ourInstance = new PolygonBuilder();

    public static PolygonBuilder getInstance() {
        return ourInstance;
    }

    private PolygonBuilder() { }

    @Override
    public IShape build(final String[] args) {
        Parser parser = new Parser(args);
        int n = parser.nextInt();
        int[] xs = new int[n];
        int[] ys = new int[n];
        parser.parsePointsVector(xs, ys, n);
        int edgeColor = parser.nextColor();
        int fillColor = parser.nextColor();
        return new Polygon(xs, ys, edgeColor, fillColor);
    }
}
