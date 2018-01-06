/*
 * POO - tema 2
 * SERBAN Mihnea
 * 321CA
 */

package cad.builders;

import cad.interfaces.IBuilder;
import cad.interfaces.IShape;
import cad.shapes.Rectangle;

public final class RectangleBuilder implements IBuilder {
    private static RectangleBuilder ourInstance = new RectangleBuilder();

    public static RectangleBuilder getInstance() {
        return ourInstance;
    }

    private RectangleBuilder() { }

    @Override
    public IShape build(final String[] args) {
        Parser parser = new Parser(args);
        int xMin = parser.nextInt();
        int yMin = parser.nextInt();
        int height = parser.nextInt();
        int width = parser.nextInt();
        int colorEdge = parser.nextColor();
        int colorInterior = parser.nextColor();
        return new Rectangle(xMin, yMin, height, width, colorEdge, colorInterior);
    }
}
