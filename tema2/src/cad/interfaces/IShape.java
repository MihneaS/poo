/*
 * POO - tema 2
 * SERBAN Mihnea
 * 321CA
 */

package cad.interfaces;

import cad.formain.PaintingQueue;
import cad.fundamental.Image;

public interface IShape {
    default void draw(PaintingQueue paintingQueue) {
        draw(paintingQueue.getImage());
    }

    void draw(Image image);
}
