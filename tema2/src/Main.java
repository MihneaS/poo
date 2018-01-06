/*
 * POO - tema 2
 * SERBAN Mihnea
 * 321CA
 */


import cad.formain.Factory;
import cad.formain.PaintingQueue;
import cad.interfaces.IShape;
import decodedfileio.implementations.FileReader;
import decodedfileio.interfaces.IReader;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public final class Main {
    private Main() { }

    public static void main(final String[] args) {
        String inputPath;
        PaintingQueue paintingQueue = new PaintingQueue();
        if (args.length == 1) {
            inputPath = args[0];
        } else {
            inputPath = "/home/mihnea/facultate/poo/tema2/src/input/test30.in";
        }

        try {
            IReader input = new FileReader(inputPath);
            File output = new File("drawing.png");
            int n = input.nextInt();
            String shapeName;
            String[] shapeArgs;

            for (int i = 0; i < n; ++i) {
                shapeName = input.nextWord();
                shapeArgs = input.restOfTheLine();
                IShape nextShape = Factory.getInstance().build(
                        shapeName, shapeArgs);
                paintingQueue.add(nextShape);
            }

            paintingQueue.drawAll();
            input.close();
            ImageIO.write(paintingQueue.getBufferedImage(), "PNG", output);
        } catch (IOException var13) {
            var13.printStackTrace();
        }
    }
}

