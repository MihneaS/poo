package figures;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import algorithms.Algorithms;

public class MyCanvas{

    int height;
    int width;

    static BufferedImage image;
    Graphics2D graphics;

    public MyCanvas(final String[] specs) {
        height = Integer.parseInt(specs[0]);
        width = Integer.parseInt(specs[1]);

        image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

            //System.out.println(specs[2]);

        int r = Integer.valueOf(specs[2].substring(1, 3), 16);
        int g = Integer.valueOf(specs[2].substring(3, 5), 16);
        int b = Integer.valueOf(specs[2].substring(5, 7), 16);

            //System.out.println(r + " " + g + " " + b);

        int alpha = Integer.parseInt(specs[3]);

            //System.out.println(alpha);

        Color c = new Color(r, g, b, alpha);

        //graphics = (Graphics2D) image.getGraphics();

        //graphics.setPaint (c);
        //graphics.fillRect (0, 0, image.getWidth(), image.getHeight());
        //graphics.dispose();
        
        Algorithms.floodFill(0, 0, c, c);
        
            //String[] specs2 = {"50", "50", "500", "6000"};
        
            //System.out.println(specs2[2]);
        
            //Line line = new Line(specs2);

    }
    
    public static BufferedImage getCanvas() {
        return image;
    }

    public void printCanvas() throws IOException {

//        createWindow();

        File outputfile = new File("drawing.png");
        ImageIO.write(image, "png", outputfile);

    }

    void createWindow() {

        JFrame frame = new JFrame();
        frame.getContentPane().setLayout(new FlowLayout());
        frame.getContentPane().add(new JLabel(new ImageIcon(image)));
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

}
