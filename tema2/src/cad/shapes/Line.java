package cad.shapes;

import cad.fundamental.Canvas;
import cad.interfaces.IShape;

public class Line implements IShape {
    public static final String NAME = "LINE";
    private final int x1;
    private final int y1;
    private final int x2;
    private final int y2;
    private final int color;

    public Line(int x1, int y1, int x2, int y2, int color) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.color = color;
    }

    @Override
    public void drawOn(Canvas canvas) {
        canvas.drawLine(x1, y1, x2, y2, color);
    }
}
