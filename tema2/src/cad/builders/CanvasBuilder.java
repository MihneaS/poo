/*
 * POO - tema 2
 * SERBAN Mihnea
 * 321CA
 */

package cad.builders;

import cad.interfaces.IBuilder;
import cad.interfaces.IShape;
import cad.shapes.Canvas;

public final class CanvasBuilder implements IBuilder {
    private static CanvasBuilder ourInstance = new CanvasBuilder();

    public static CanvasBuilder getInstance() {
        return ourInstance;
    }

    private CanvasBuilder() { }

    @Override
    public IShape build(final String[] args) {
       int height, weigth, color;
       Parser parser = new Parser(args);
       height = parser.nextInt();
       weigth = parser.nextInt();
       color = parser.nextColor();
       return new Canvas(height, weigth, color);
    }
}
