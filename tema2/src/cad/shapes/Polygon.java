package cad.shapes;

import cad.fundamental.Canvas;
import cad.interfaces.IShape;

public class Polygon implements IShape {
    public static final String NAME = "POLYGON";
    public static final String TRIANGLE_NAME = "TRIANGLE";
    public static final String DIAMOND_NAME = "DIAMOND";
    private final int[] xs;
    private final int[] ys;
    private final int edgeColor;
    private final int fillColor;
    private final int sumX;
    private final int sumY;

    public Polygon(int[] xs, int[] ys, int edgeColor, int fillColor) {
        this.xs = xs;
        this.ys = ys;
        this.edgeColor = edgeColor;
        this.fillColor = fillColor;

        int s = 0;
        for (int x: xs) {
            s += x;
        }
        sumX = s;
        s = 0;
        for (int y: ys) {
            s += y;
        }
        sumY = s;
    }

    @Override
    public void drawOn(Canvas canvas) {
        canvas.drawPolygon(xs, ys, edgeColor);
        canvas.fludFill(sumX/xs.length, sumY/ys.length, edgeColor, fillColor);
    }
}
