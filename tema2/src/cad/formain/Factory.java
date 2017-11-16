package cad.formain;

import cad.shapes.*;
import cad.fundamental.Canvas;
import cad.interfaces.IShape;

import java.util.Arrays;

public class Factory {
    private static final Factory instance = new Factory();

    private Factory() { }

    public static Factory getInstance() {
        return instance;
    }

    public PaintingQueue buildQueue (final int height, final int width) {
        PaintingQueue returnObject;
        Canvas canvas = new Canvas(height, width);
        returnObject = new PaintingQueue(canvas);
        return returnObject;
    }

    public IShape build(String shapeName, int... args) {
        IShape returnObject = null;

        if (shapeName.equals(BackGround.NAME)) {
            returnObject = new BackGround(args[0]);
        } else if (shapeName.equals(Square.NAME)) {
            returnObject = new Square(args[0], args[1], args[2],
                    args[3], args[4]);
        } else if (shapeName.equals(Rectangle.NAME)) {
            returnObject = new Rectangle(args[0], args[1], args[2],
                    args[3], args[4], args[5]);
        } else if (shapeName.equals(Line.NAME)) {
            returnObject = new Line(args[0], args[1], args[2],
                    args[3], args[4]);
        } else if (shapeName.equals(Circle.NAME)) {
            returnObject = new Circle(args[0], args[1], args[2],
                    args[3], args[4]);
        } else if (shapeName.equals(Polygon.NAME)
                || shapeName.equals(Polygon.TRIANGLE_NAME)
                || shapeName.equals(Polygon.DIAMOND_NAME)) {
            int[] xs;
            int[] ys;
            xs = Arrays.copyOfRange(args, 1, 1 + args[0]);
            ys = Arrays.copyOfRange(args, 1 + args[0], 1 + 2*args[0]);
            returnObject = new Polygon(xs, ys,
                    args[args.length-2], args[args.length - 1]);
        }

        return returnObject;
    }

}
