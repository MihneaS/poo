package cad.shapes;

import cad.fundamental.Canvas;
import cad.interfaces.IShape;

public class BackGround implements IShape {

    public static final String NAME = "BACKGROUND";
    private final int color;

    public BackGround(final int... args) {
        this.color = args[0];
    }

    @Override
    public final void drawOn(final Canvas canvas) {
        canvas.fillAll(color);
    }
}
