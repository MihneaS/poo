/*
 * POO - tema 2
 * SERBAN Mihnea
 * 321CA
 */

package cad.formain;

import cad.fundamental.Image;
import cad.interfaces.IShape;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public final class PaintingQueue {
    private Image image;
    private List<IShape> queue = new ArrayList<IShape>();

    public PaintingQueue() { }

    public void add(final IShape shape) {
        queue.add(shape);
    }

    public void setImage(final int height, final int width) {
        this.image = new Image(height, width);
    }

    public Image getImage() {
        return image;
    }

    public void drawAll() {
        for (IShape shape: queue) {
            shape.draw(this);
        }
    }

    /**
     * Returns the internal BufferedImage of the image.
     * This shall be used only for writing the image into a file
     */
    public BufferedImage getBufferedImage() {
        return image.getImage();
    }
}
