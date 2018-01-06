/*
 * POO - tema 2
 * SERBAN Mihnea
 * 321CA
 */

package cad.fundamental;

import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.Iterator;
import java.util.LinkedHashSet;

import static java.lang.Math.abs;
import static java.lang.Math.signum;

public final class Image {

    private final BufferedImage image;

    public Image(final int height, final int width) {
        image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
    }

    public void fillAll(final int color) {
        for (int i = 0; i < image.getWidth(); ++i) {
            for (int j = 0; j < image.getHeight(); ++j) {
                image.setRGB(i, j, color);
            }
        }
    }

    private int getX0(final int minX) {
        return Math.max(minX, 0);
    }
    private int getXMax(final int maxX) { //TODO getXMax si getYMax seamana prea tare la denumire
        return Math.min(maxX, image.getWidth() - 1);
    }
    private int getY0(final int minY) {
        return getX0(minY);
    }
    private int getYMax(final int maxY) {
        return Math.min(maxY, image.getHeight() - 1);
    }

    private void setRGBIfInBounds(final int x, final int y, final int color) {
        if (x >= 0 && x < image.getWidth()
                && y >= 0 && y < image.getHeight()) {
            image.setRGB(x, y, color);
        }
    }

    /**
     * bresenham algorithm.
     */
    public void drawLine(final int x1, final int y1,
                         final int x2, final int y2, final int color) {
        int x, y, deltaX, deltaY, s1, s2, error;
        boolean interchanged;
        x = x1;
        y = y1;
        deltaX = abs(x2 - x1);
        deltaY = abs(y2 - y1);
        s1 = (int) signum(x2 - x1);
        s2 = (int) signum(y2 - y1);
        if (deltaY > deltaX) {
            int aux = deltaX;
            deltaX = deltaY;
            deltaY = aux;
            interchanged = true;
        } else  {
            interchanged = false;
        }
        error = 2 * deltaY - deltaX;
        for (int i = 0; i <= deltaX; ++i) {
            setRGBIfInBounds(x, y, color);

            while (error > 0) {
                if (interchanged) {
                    x = x + s1;
                } else {
                    y = y + s2;
                }
                error = error - 2 * deltaX;
            }

            if (interchanged) {
                y = y + s2;
            } else  {
                x = x + s1;
            }

            error = error + 2 * deltaY;
        }
    }

    public void drawRectangle(final int minX, final int minY,
                              final int maxX, final int maxY, final int color) {
        for (int i = minX; i <= maxX; ++i) {
            setRGBIfInBounds(i, minY, color);
            setRGBIfInBounds(i, maxY, color);
        }
        for (int j = minY; j <= maxY; ++j) {
            setRGBIfInBounds(minX, j, color);
            setRGBIfInBounds(maxX, j, color);
        }

    }
    public void fillRectangle(final int minX, final int minY,
                              final int maxX, final int maxY, final int color) {
        int x0, xMax, y0, yMax;
        x0 = getX0(minX);
        xMax = getXMax(maxX);
        y0 = getY0(minY);
        yMax = getYMax(maxY);

        for (int i = x0; i <= xMax; ++i) {
            for (int j = y0; j <= yMax; ++j) {
                image.setRGB(i, j, color);
            }
        }
    }
    private void drawCirclePoints(final int xc, final int yc,
                                  final int deltaX, final int deltaY,
                                  final int color) {
        setRGBIfInBounds(xc + deltaX, yc + deltaY, color);
        setRGBIfInBounds(xc + deltaX, yc - deltaY, color);
        setRGBIfInBounds(xc - deltaX, yc + deltaY, color);
        setRGBIfInBounds(xc - deltaX, yc - deltaY, color);
        setRGBIfInBounds(xc + deltaY, yc + deltaX, color);
        setRGBIfInBounds(xc + deltaY, yc - deltaX, color);
        setRGBIfInBounds(xc - deltaY, yc + deltaX, color);
        setRGBIfInBounds(xc - deltaY, yc - deltaX, color);
    }
    public void drawCircle(final int xc, final int yc, final int radius,
                           final int color) {
        int deltaX = 0;
        int deltaY = radius;
        int decisionParameter;
        decisionParameter = 3 - 2 * radius;
        while (deltaY >= deltaX) {
            drawCirclePoints(xc, yc, deltaX, deltaY, color);
            ++deltaX;
            if (decisionParameter < 0) {
                decisionParameter += 4 * deltaX + 6;
            } else {
                --deltaY;
                decisionParameter += 4 * (deltaX - deltaY) + 10;
            }
            drawCirclePoints(xc, yc, deltaX, deltaY, color);
        } //while (x < y);
    }

    private boolean isInBounds(final int x, final int y) {
        return x >= 0 && x < image.getWidth()
                && y >= 0 && y < image.getHeight();
    }

    public void floodFill(final int x, final int y,
                          final int edgeColor, final int fillColor) {
        class Flooder {
            private final LinkedHashSet<Point> queue
                    = new LinkedHashSet<Point>();
            private final int edgeColor;
            private final int fillColor;
            private final Image canvas;

            private Flooder(final int x, final int y,
                            final int edgeColorP, final int fillColorP,
                            final Image canvasP) {
                this.edgeColor = edgeColorP;
                this.fillColor = fillColorP;
                this.canvas = canvasP;

                add(x, y);
            }

            private void add(final int x, final int y) {
                if (isInBounds(x, y)
                        && canvas.getRGB(x, y) != edgeColor
                        && canvas.getRGB(x, y) != fillColor) {
                    queue.add(new Point(x, y));
                }
            }

            private void flood() {
                while (!queue.isEmpty()) {
                    Iterator it = queue.iterator();
                    Point p = (Point) it.next();
                    canvas.setRGBIfInBounds(p.x, p.y, fillColor);
                    add(p.x + 1, p.y);
                    add(p.x - 1, p.y);
                    add(p.x, p.y + 1);
                    add(p.x, p.y - 1);
                    queue.remove(p);
                }
            }
        }

        Flooder flooder = new Flooder(x, y, edgeColor, fillColor, this);
        flooder.flood();
    }

    public void drawPolygon(final int[] xs, final int[] ys, final int color) {
        // assert : xs.length == ys.length
        for (int i = 0; i < xs.length - 1; ++i) {
            drawLine(xs[i], ys[i], xs[i + 1], ys[i + 1], color);
        }
        drawLine(xs[xs.length - 1], ys[xs.length - 1], xs[0], ys[0], color);
    }

    private int getRGB(final int x, final int y) {
        return image.getRGB(x, y);
    }

    /**
     * Returns the internal BufferedImage.
     * This shall be used only for writing the image into a file
     */
    public BufferedImage getImage() {
        return image;
    }
}
