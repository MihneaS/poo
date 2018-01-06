/*
 * POO - tema 2
 * SERBAN Mihnea
 * 321CA
 */

package cad.formain;

import cad.builders.*;
import cad.interfaces.IBuilder;
import cad.interfaces.IShape;

import java.util.HashMap;
import java.util.StringTokenizer;

import static cad.formain.Factory.Shapes.*;

public final class Factory {
    enum Shapes {
        CANVAS, SQUARE, RECTANGLE, LINE,
        CIRCLE, POLYGON, TRIANGLE, DIAMOND
    }

    private static final Factory INSTANCE = new Factory();
    private static final HashMap<Shapes, IBuilder> BUILDERS
            = new HashMap<Shapes, IBuilder>() {{
        put(CANVAS, CanvasBuilder.getInstance());
        put(SQUARE, SquareBuilder.getInstance());
        put(RECTANGLE, RectangleBuilder.getInstance());
        put(LINE, LineBuilder.getInstance());
        put(CIRCLE, CircleBuilder.getInstance());
        put(POLYGON, PolygonBuilder.getInstance());
        put(TRIANGLE, TriangleBuilder.getInstance());
        put(DIAMOND, DiamondBuilder.getInstance());
    }};

    private Factory() { }

    public static Factory getInstance() {
        return INSTANCE;
    }

    public IShape build(final String shapeName, final String[] args) {
        return BUILDERS.get(Shapes.valueOf(shapeName)).build(args);
    }
}

