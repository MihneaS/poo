/*
 * POO - tema 2
 * SERBAN Mihnea
 * 321CA
 */

package cad.shapes;

import cad.fundamental.Image;
import cad.interfaces.IShape;

public class Line implements IShape {
    private final int x1;
    private final int y1;
    private final int x2;
    private final int y2;
    private final int color;

    public Line(final int x1P, final int y1P,
                final int x2P, final int y2P, final int colorP) {
        this.x1 = x1P;
        this.y1 = y1P;
        this.x2 = x2P;
        this.y2 = y2P;
        this.color = colorP;
    }

    @Override
    public final void draw(final Image image) {
        image.drawLine(x1, y1, x2, y2, color);
    }
}
