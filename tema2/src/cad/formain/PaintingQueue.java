package cad.formain;

import cad.fundamental.Canvas;
import cad.interfaces.IShape;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class PaintingQueue {
    public static final String NAME = "PaintingQueue";
    private Canvas canvas;
    private List<IShape> queue = new ArrayList<IShape>();

    public PaintingQueue(final Canvas canvas) {
        this.canvas = canvas;
    }

    public void add(final IShape shape) {
        queue.add(shape);
    }

    public void drawAll() {
        for (IShape shape: queue) {
            shape.drawOn(canvas);
        }
    }

    /**
     * Returns the internal BufferedImage of the canvas.
     * This shall be used only for writing the image into a file
     */
    public BufferedImage getImage() {
        return canvas.getImage();
    }
}
