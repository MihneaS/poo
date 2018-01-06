/*
 * POO - tema 2
 * SERBAN Mihnea
 * 321CA
 */

package cad.builders;

import cad.interfaces.IBuilder;
import cad.interfaces.IShape;
import cad.shapes.Circle;

public final class CircleBuilder implements IBuilder {
    private static CircleBuilder ourInstance = new CircleBuilder();

    public static CircleBuilder getInstance() {
        return ourInstance;
    }

    private CircleBuilder() { }

    @Override
    public IShape build(final String[] args) {
        Parser parser = new Parser(args);
        int x = parser.nextInt();
        int y = parser.nextInt();
        int radius = parser.nextInt();
        int colorEdge = parser.nextColor();
        int colorInterior = parser.nextColor();
        return new Circle(x, y, radius, colorEdge, colorInterior);
    }
}
