/*
 * POO - tema 2
 * SERBAN Mihnea
 * 321CA
 */

package cad.shapes;

import cad.formain.PaintingQueue;
import cad.fundamental.Image;
import cad.interfaces.IShape;

public class Canvas implements IShape {
    private final int height;
    private final int width;
    private final int color;

    public Canvas(final int... args) {
        this.height = args[0];
        this.width = args[1];
        this.color = args[2];
    }

    @Override
    public final void draw(final PaintingQueue paintingQueue) {
        paintingQueue.setImage(height, width);
        draw(paintingQueue.getImage());
    }

    @Override
    public final void draw(final Image image) {
        image.fillAll(color);
    }
}
