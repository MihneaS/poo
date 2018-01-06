/*
 * POO - tema 2
 * SERBAN Mihnea
 * 321CA
 */

package cad.builders;

import cad.interfaces.IBuilder;
import cad.interfaces.IShape;
import cad.shapes.Line;

public final class LineBuilder implements IBuilder {
    private static LineBuilder ourInstance = new LineBuilder();

    public static LineBuilder getInstance() {
        return ourInstance;
    }

    private LineBuilder() { }

    @Override
    public IShape build(final String[] args) {
        Parser parser = new Parser(args);
        int x1 = parser.nextInt();
        int y1 = parser.nextInt();
        int x2 = parser.nextInt();
        int y2 = parser.nextInt();
        int color = parser.nextColor();
        return new Line(x1, y1, x2, y2, color);
    }
}
