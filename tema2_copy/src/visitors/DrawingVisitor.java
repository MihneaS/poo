package visitors;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import algorithms.Algorithms;
import figures.Circle;
import figures.Diamond;
import figures.Line;
import figures.MyCanvas;
import figures.Polygon;
import figures.Rectangle;
import figures.Square;
import figures.Triangle;

public class DrawingVisitor implements Visitor {

    @Override
    public void visit(Line li) {
        
        int x1;
        int y1;
        
        int x2;
        int y2;
        
        int colorARGB;
        
        String rgbString;
        String alphaString;
        
        String[] specs = li.getFigureArguments();
        
        x1 = Integer.parseInt(specs[0]);
        y1 = Integer.parseInt(specs[1]);
        
        x2 = Integer.parseInt(specs[2]);
        y2 = Integer.parseInt(specs[3]);
        
        rgbString = specs[4];
        alphaString = specs[5];

        Color color = Algorithms.getColor(rgbString, alphaString);

        colorARGB = color.getRGB();

        Algorithms.bresenham(x1, y1, x2, y2, colorARGB); 

    }

    @Override
    public void visit(Square sq) {

        int x;
        int y;
        int length;

        int colorARGB1;
        int colorARGB2;

        String rgbString1;
        String alphaString1;
        String rgbString2;
        String alphaString2;

        String[] specs = sq.getFigureArguments();
        
        x = Integer.parseInt(specs[0]);
        y = Integer.parseInt(specs[1]);
        length = Integer.parseInt(specs[2]);
        
        rgbString1 = specs[3];
        alphaString1 = specs[4];
        rgbString2 = specs[5];
        alphaString2 = specs[6];
        
        Color color1 = Algorithms.getColor(rgbString1, alphaString1);
        Color color2 = Algorithms.getColor(rgbString2, alphaString2);
        
        colorARGB1 = color1.getRGB();
        colorARGB2 = color2.getRGB();
        
        //Draw sides
        Algorithms.bresenham(x, y, (x + length - 1), y, colorARGB1);
        Algorithms.bresenham((x + length - 1), y, (x + length - 1), (y + length - 1), colorARGB1);
        Algorithms.bresenham((x + length - 1), (y + length - 1), x, (y + length - 1), colorARGB1);
        Algorithms.bresenham(x, (y + length - 1), x, y, colorARGB1);
        
        
        //Fill rectangle
        Algorithms.floodFill(x + 1, y + 1, color1, color2);
    }

    @Override
    public void visit(Rectangle re) {
        
        int x;
        int y;
        int height;
        int width;
        
        int colorARGB1;
        int colorARGB2;
        
        String rgbString1;
        String alphaString1;
        String rgbString2;
        String alphaString2;
        
        String[] specs = re.getFigureArguments();
        
        x = Integer.parseInt(specs[0]);
        y = Integer.parseInt(specs[1]);
        
        height = Integer.parseInt(specs[2]);
        width = Integer.parseInt(specs[3]);
        
        rgbString1 = specs[4];
        alphaString1 = specs[5];
        rgbString2 = specs[6];
        alphaString2 = specs[7];
        
        Color color1 = Algorithms.getColor(rgbString1, alphaString1);
        Color color2 = Algorithms.getColor(rgbString2, alphaString2);
        
        colorARGB1 = color1.getRGB();
        colorARGB2 = color2.getRGB();
        
        //Draw sides
        Algorithms.bresenham(x, y, (x + width - 1), y, colorARGB1);
        Algorithms.bresenham((x + width - 1), y, (x + width - 1), (y + height - 1), colorARGB1);
        Algorithms.bresenham((x + width - 1), (y + height - 1), x, (y + height - 1), colorARGB1);
        Algorithms.bresenham(x, (y + height - 1), x, y, colorARGB1);
        
        //Fill rectangle
        Algorithms.floodFill(x + 1, y + 1, color1, color2);
    }

    @Override
    public void visit(Circle ci) {
        
        int xc;
        int yc;
        int r;
        
        int colorARGB1;
        int colorARGB2;
        
        String rgbString1;
        String alphaString1;
        String rgbString2;
        String alphaString2;
        
        String[] specs = ci.getFigureArguments();
        
        xc = Integer.parseInt(specs[0]);
        yc = Integer.parseInt(specs[1]);
        r = Integer.parseInt(specs[2]);
        
        rgbString1 = specs[3];
        alphaString1 = specs[4];
        rgbString2 = specs[5];
        alphaString2 = specs[6];
        
        Color color1 = Algorithms.getColor(rgbString1, alphaString1);
        Color color2 = Algorithms.getColor(rgbString2, alphaString2);
        
        colorARGB1 = color1.getRGB();
        colorARGB2 = color2.getRGB();
        
        //Draw circle
        Algorithms.circleBresenham(xc, yc, r, colorARGB1);
        
        //Fil circle
        Algorithms.floodFill(xc, yc, color1, color2);
        
    }

    @Override
    public void visit(Triangle tr) {
         
        int x1;
        int y1;
        int x2;
        int y2;
        int x3;
        int y3;
        
        int xg;
        int yg;
        
        int colorARGB1;
        int colorARGB2;
        
        String rgbString1;
        String alphaString1;
        String rgbString2;
        String alphaString2;
        
        String[] specs = tr.getFigureArguments();
        
        x1 = Integer.parseInt(specs[0]);
        y1 = Integer.parseInt(specs[1]);
        
        x2 = Integer.parseInt(specs[2]);
        y2 = Integer.parseInt(specs[3]);
        
        x3 = Integer.parseInt(specs[4]);
        y3 = Integer.parseInt(specs[5]);
        
        rgbString1 = specs[6];
        alphaString1 = specs[7];
        rgbString2 = specs[8];
        alphaString2 = specs[9];
        
        Color color1 = Algorithms.getColor(rgbString1, alphaString1);
        Color color2 = Algorithms.getColor(rgbString2, alphaString2);
        
        colorARGB1 = color1.getRGB();
        colorARGB2 = color2.getRGB();
        
        xg = x1 + x2 + x3;
        yg = y1 + y2 + y3;
        
        xg = Math.floorDiv(xg, 3);
        yg = Math.floorDiv(yg, 3);
        
        //Draw triangle
        Algorithms.bresenham(x1, y1, x2, y2, colorARGB1);
        Algorithms.bresenham(x2, y2, x3, y3, colorARGB1);
        Algorithms.bresenham(x3, y3, x1, y1, colorARGB1);
        
        //Fill triangle

        Algorithms.floodFill(xg, yg, color1, color2);
        
    }

    @Override
    public void visit(Diamond di) {

        int xc;
        int yc;

        int dx;
        int dy;

        int xg;
        int yg;

        int colorARGB1;
        int colorARGB2;

        String rgbString1;
        String alphaString1;
        String rgbString2;
        String alphaString2;

        String[] specs = di.getFigureArguments();

        xc = Integer.parseInt(specs[0]);
        yc = Integer.parseInt(specs[1]);
        
        dx = Integer.parseInt(specs[2]);
        dy = Integer.parseInt(specs[3]);
        
        rgbString1 = specs[4];
        alphaString1 = specs[5];
        rgbString2 = specs[6];
        alphaString2 = specs[7];
        
        Color color1 = Algorithms.getColor(rgbString1, alphaString1);
        Color color2 = Algorithms.getColor(rgbString2, alphaString2);
        
        colorARGB1 = color1.getRGB();
        colorARGB2 = color2.getRGB();
        
        int dxs = Math.floorDiv(dx, 2);
        int dys = Math.floorDiv(dy, 2);
        
        int p1x, p1y, p2x, p2y, p3x, p3y, p4x, p4y;
        
        p1x = xc;
        p1y = yc - dys;
        
        p2x = xc + dxs;
        p2y = yc;
        
        p3x = xc;
        p3y = yc + dys;
        
        p4x = xc - dxs;
        p4y = yc;
        
        xg = p1x + p2x + p3x + p4x;
        yg = p1y + p2y + p3y + p4y;
        
        xg = Math.floorDiv(xg, 4);
        yg = Math.floorDiv(yg, 4);
        
        //Draw diamond
        Algorithms.bresenham(xc, yc - dys, xc + dxs, yc, colorARGB1);
        Algorithms.bresenham(xc, yc + dys, xc + dxs, yc, colorARGB1);
        Algorithms.bresenham(xc, yc + dys, xc - dxs, yc, colorARGB1);
        Algorithms.bresenham(xc - dxs, yc, xc, yc - dys, colorARGB1);
        
        //Fill diamond
        Algorithms.floodFill(xg, yg, color1, color2);
        
    }

    @Override
    public void visit(Polygon po) {

        int nrPoints;
        
        int xp1;
        int yp1;
        int xp2;
        int yp2;
        
        int xg = 0;
        int yg = 0;

        int colorARGB1;
        int colorARGB2;
        
        int i;

        String rgbString1;
        String alphaString1;
        String rgbString2;
        String alphaString2;

        String[] specs = po.getFigureArguments();

        nrPoints = Integer.parseInt(specs[0]);

        rgbString1 = specs[2 * nrPoints + 1];
        alphaString1 = specs[2 * nrPoints + 2];
        rgbString2 = specs[2 * nrPoints + 3];
        alphaString2 = specs[2 * nrPoints + 4];

        Color color1 = Algorithms.getColor(rgbString1, alphaString1);
        Color color2 = Algorithms.getColor(rgbString2, alphaString2);

        colorARGB1 = color1.getRGB();
        colorARGB2 = color2.getRGB();

        ArrayList<Integer> xCoords = new ArrayList<Integer>();
        ArrayList<Integer> yCoords = new ArrayList<Integer>();

        for (i = 0; i < nrPoints; i++) {

            xCoords.add(Integer.parseInt(specs[2 * i + 1]));
            yCoords.add(Integer.parseInt(specs[2 * i + 2]));

            xg += Integer.parseInt(specs[2 * i + 1]);
            yg += Integer.parseInt(specs[2 * i + 2]);

        }
        
        //Draw polygon
        int x1, y1, x2, y2;
        
        for(i = 0; i < nrPoints - 1; i++) {
            
            x1 = xCoords.get(i);
            y1 = yCoords.get(i);
            
            x2 = xCoords.get(i + 1);
            y2 = yCoords.get(i + 1);
            
            Algorithms.bresenham(x1, y1, x2, y2, colorARGB1);
            
        }
        
        x1 = xCoords.get(0);
        y1 = yCoords.get(0);
        
        x2 = xCoords.get(nrPoints - 1);
        y2 = yCoords.get(nrPoints - 1);
        
        Algorithms.bresenham(x1, y1, x2, y2, colorARGB1);
        
        //Fill polygon
        
        xg = Math.floorDiv(xg, nrPoints);
        yg = Math.floorDiv(yg, nrPoints);
        
        Algorithms.floodFill(xg, yg, color1, color2);
        
    }

}
