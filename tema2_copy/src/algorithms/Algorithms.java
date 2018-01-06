package algorithms;

import java.awt.Color;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.Queue;

import figures.MyCanvas;

public final class Algorithms {

    private Algorithms() { }
    
    public static String getColorInt(String rgb, String alpha) {
        
        String colorString;
        
        rgb = rgb.substring(1);
        alpha = Integer.toHexString(Integer.parseInt(alpha));
        
        colorString = alpha + rgb;
        
        return colorString;
    }
    
    public static Color getColor(String rgb, String alpha) {
        
        int r = Integer.valueOf(rgb.substring(1, 3), 16);
        int g = Integer.valueOf(rgb.substring(3, 5), 16);
        int b = Integer.valueOf(rgb.substring(5, 7), 16);
        
        int a = Integer.parseInt(alpha);
        
        Color color = new Color(r, g, b, a);
        
        return color;
    }
    
    public static void floodFill(int x, int y, Color borderColor, Color color) {
        BufferedImage image = MyCanvas.getCanvas();
        
        boolean[][] hits = new boolean[image.getHeight()][image.getWidth()];

        Queue<Point> queue = new LinkedList<Point>();
        queue.add(new Point(x, y));

        while (!queue.isEmpty()) {
            Point p = queue.remove();

            if(floodFillImageDo(image,hits,p.x,p.y, borderColor.getRGB(), color.getRGB())) {     
                queue.add(new Point(p.x,p.y - 1)); 
                queue.add(new Point(p.x,p.y + 1)); 
                queue.add(new Point(p.x - 1,p.y)); 
                queue.add(new Point(p.x + 1,p.y)); 
            }
        }
    }
    
    private static boolean floodFillImageDo(BufferedImage image, boolean[][] hits,int x, int y, int borderColor, int tgtColor)  {
        if (y < 0) return false;
        if (x < 0) return false;
        if (y > image.getHeight() - 1) return false;
        if (x > image.getWidth() - 1) return false;

        if (hits[y][x]) return false;

        if (image.getRGB(x, y) == borderColor)
            return false;

        // valid, paint it
        image.setRGB(x, y, tgtColor);
        hits[y][x] = true;
        return true;
    }
    
    public static void bresenham(final int x1, final int y1, final int x2, final int y2, final int color) {
        
        int x;
        int y;

        int deltaX;
        int deltaY;

        int temp;
        int error;
        
        int s1;
        int s2;

        int i;

        boolean interchanged = false;
        BufferedImage canvas = MyCanvas.getCanvas();
        
            //System.out.println("S-a apelat bresenham");
        
        x = x1;
        y = y1;
        
        deltaX = Math.abs(x2 - x1);
        deltaY = Math.abs(y2 - y1);
        
        s1 = (int)Math.signum(x2 - x1);
        s2 = (int)Math.signum(y2 - y1);
        
        if (deltaY > deltaX) {

            temp = deltaX;
            deltaX = deltaY;
            deltaY = temp;
            interchanged = true;

        }
        
        error = 2 * deltaY - deltaX;
        
        for (i = 0; i <= deltaX; i++) {
            
            if(validateCoords(x, y)) {
                canvas.setRGB(x, y, color);
            }
                
                while (error > 0) {
                
                    if(interchanged) {
                        x += s1;
                    } else {
                        y += s2;
                    }
                
                    error -= 2 * deltaX; 
                }
                
                if (interchanged) {
                    y += s2;
                } else {
                    x += s1;
                }
            
                error += 2 * deltaY;
        
        }
        
    }
    
    public static void circleBresenham(final int xc, final int yc, final int r, final int color) {
        
        int x;
        int y;
        int d;
        
        x = 0;
        y = r;
        
        d = 3 - 2 * r;
        
        while (y >= x) {
            
            drawCircle(xc, yc, x, y, color);
            x++;
            
            if (d > 0) {
                y--;
                d += 4 * (x - y) + 10;
            } else {
                d += 4 * x + 6;
            }
            
            drawCircle(xc, yc, x, y, color);
        }
        
        
      
    }
    
    public static void drawCircle(final int xc, final int yc, final int x, final int y, final int color) {
        
        BufferedImage canvas = MyCanvas.getCanvas();
        
        
        //Set 1
        if(validateCoords(xc + x, yc + y)) {
            canvas.setRGB(xc + x, yc + y, color);
        }
        
        if(validateCoords(xc - x, yc + y)) {
            canvas.setRGB(xc - x, yc + y, color);
        }
        
        if(validateCoords(xc + x, yc - y)) {
            canvas.setRGB(xc + x, yc - y, color);
        }
        
        if(validateCoords(xc - x, yc - y)) {
            canvas.setRGB(xc - x, yc - y, color);
        }
        
        //Set 2
        if(validateCoords(xc + y, yc + x)) {
            canvas.setRGB(xc + y, yc + x, color);
        }
        
        if(validateCoords(xc - y, yc + x)) {
            canvas.setRGB(xc - y, yc + x, color);
        }
        
        if(validateCoords(xc + y, yc - x)) {
            canvas.setRGB(xc + y, yc - x, color);
        }
        
        if(validateCoords(xc - y, yc - x)) {
            canvas.setRGB(xc - y, yc - x, color);
        }
        
        //canvas.setRGB(xc + x, yc + y, color);
        //canvas.setRGB(xc - x, yc + y, color);
        //canvas.setRGB(xc + x, yc - y, color);
        //canvas.setRGB(xc - x, yc - y, color);
        //canvas.setRGB(xc + y, yc + x, color);
        //canvas.setRGB(xc - y, yc + x, color);
        //canvas.setRGB(xc + y, yc - x, color);
        //canvas.setRGB(xc - y, yc - x, color);
        
    }
    
    public static boolean validateCoords(final int x, final int y) {
        
        BufferedImage canvas = MyCanvas.getCanvas();
        
        if(x < canvas.getWidth() && x >= 0 && y < canvas.getHeight() && y >= 0) {
            return true;
        }
        
        return false;
    }
    
}
