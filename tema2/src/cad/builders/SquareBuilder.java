/*
 * POO - tema 2
 * SERBAN Mihnea
 * 321CA
 */

package cad.builders;

import cad.interfaces.IBuilder;
import cad.interfaces.IShape;
import cad.shapes.Rectangle;

public final class SquareBuilder implements IBuilder {
    private static SquareBuilder ourInstance = new SquareBuilder();

    public static SquareBuilder getInstance() {
        return ourInstance;
    }

    private SquareBuilder() { }

    @Override
    public IShape build(final String[] args) {
        Parser parser = new Parser(args);
        int xMin = parser.nextInt();
        int yMin = parser.nextInt();
        int length = parser.nextInt();
        int colorEdge = parser.nextColor();
        int colorInterior = parser.nextColor();
        return new Rectangle(xMin, yMin, length, length, colorEdge, colorInterior);
    }
}
