import cad.formain.Factory;
import cad.formain.PaintingQueue;
import cad.interfaces.IShape;
import decodedfileio.implementations.FileReader;
import decodedfileio.interfaces.IReader;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public final class Main {
    private static final int HEX_BASE = 16;
    private static final int ALPHA_FIRST_POSITION = 24;

    private Main() { }

    private static int ParseColorInput(IReader input) throws IOException {
        String rgb = input.nextWord();
        int alpha = input.nextInt();
        int aux = Integer.parseInt(rgb.substring(1), 16);
        aux += alpha << 24;
        return aux;
    }

    private static int[] parseCanvasArgsFrom(IReader input) throws IOException {
        int height = input.nextInt();
        int width = input.nextInt();
        int color = ParseColorInput(input);
        int[] returnArray = new int[]{height, width, color};
        return returnArray;
    }

    private static int[] parseSquareArgsFrom(IReader input) throws IOException {
        int xMin = input.nextInt();
        int yMin = input.nextInt();
        int length = input.nextInt();
        int colorEdge = ParseColorInput(input);
        int colorInterior = ParseColorInput(input);
        return new int[]{xMin, yMin, length, colorEdge, colorInterior};
    }

    private static int[] parseRectangleArgsFrom(IReader input) throws IOException {
        int xMin = input.nextInt();
        int yMin = input.nextInt();
        int height = input.nextInt();
        int width = input.nextInt();
        int colorEdge = ParseColorInput(input);
        int colorInterior = ParseColorInput(input);
        return new int[]{xMin, yMin, height, width, colorEdge, colorInterior};
    }

    private static int[] parseLineArgsFrom(IReader input) throws IOException {
        int x1 = input.nextInt();
        int y1 = input.nextInt();
        int x2 = input.nextInt();
        int y2 = input.nextInt();
        int color = ParseColorInput(input);
        return new int[]{x1, y1, x2, y2, color};
    }

    private static int[] parseCircleArgsFrom(IReader input) throws IOException {
        int x = input.nextInt();
        int y = input.nextInt();
        int radius = input.nextInt();
        int colorEdge = ParseColorInput(input);
        int colorInterior = ParseColorInput(input);
        return new int[]{x, y, radius, colorEdge, colorInterior};
    }

    private static int[] parsePointsVector(int[] vect, int posStart, int n, IReader input) throws IOException {
        for(int i = 0; i < n; ++i) {
            vect[posStart + i] = input.nextInt();
            vect[posStart + i + n] = input.nextInt();
        }

        return vect;
    }

    private static int[] parseColorsToEndOfVector(int[] vect, IReader input) throws IOException {
        int colorEdge = ParseColorInput(input);
        int colorInterior = ParseColorInput(input);
        vect[vect.length - 2] = colorEdge;
        vect[vect.length - 1] = colorInterior;
        return vect;
    }

    private static int[] parsePolygonArgsFrom(IReader input) throws IOException {
        int n = input.nextInt();
        int[] returnArray = new int[2 * n + 3];
        returnArray[0] = n;
        parsePointsVector(returnArray, 1, n, input);
        parseColorsToEndOfVector(returnArray, input);
        return returnArray;
    }

    private static int[] parseTriangleArgsFrom(IReader input) throws IOException {
        int n = 3;
        int[] returnArray = new int[2 * n + 3];
        returnArray[0] = n;
        parsePointsVector(returnArray, 1, n, input);
        parseColorsToEndOfVector(returnArray, input);
        return returnArray;
    }

    private static int[] parseDiamondArgsFrom(IReader input) throws IOException {
        int n = 4;
        int xc = input.nextInt();
        int yc = input.nextInt();
        int horizontalDiag = input.nextInt();
        int verticalDiag = input.nextInt();
        int[] returnArray = new int[2 * n + 3];
        int i = 1;
        returnArray[0] = n;
        returnArray[i] = xc;
        returnArray[i + n] = yc + verticalDiag / 2;
        ++i;
        returnArray[i] = xc + horizontalDiag / 2;
        returnArray[i + n] = yc;
        ++i;
        returnArray[i] = xc;
        returnArray[i + n] = yc - verticalDiag / 2;
        ++i;
        returnArray[i] = xc - horizontalDiag / 2;
        returnArray[i + n] = yc;
        parseColorsToEndOfVector(returnArray, input);
        return returnArray;
    }

    public static void main(String[] args) {
        int i = 0;
        String inputPath;
        if (args.length == 1) {
            inputPath = args[0];
        } else {
            inputPath = "/home/mihnea/facultate/poo/tema2/src/input/test30.in";
        }

        try {
            IReader input = new FileReader(inputPath);
            File output = new File("drawing.png");
            int n = input.nextInt();
            String shapeName = input.nextWord();
            if (shapeName.equals("CANVAS")) {
                int[] canvasArgs = parseCanvasArgsFrom(input);
                PaintingQueue paintingQueue = Factory.getInstance().buildQueue(canvasArgs[0], canvasArgs[1]);
                paintingQueue.add(Factory.getInstance().build("BACKGROUND", canvasArgs[2]));
                ++i;

                for(; i < n; ++i) {
                    shapeName = input.nextWord();
                    IShape nextShape = null;
                    int[] shapeArgs;
                    if (shapeName.equals("SQUARE")) {
                        shapeArgs = parseSquareArgsFrom(input);
                        nextShape = Factory.getInstance().build(shapeName, shapeArgs);
                    } else if (shapeName.equals("RECTANGLE")) {
                        shapeArgs = parseRectangleArgsFrom(input);
                        nextShape = Factory.getInstance().build(shapeName, shapeArgs);
                    } else if (shapeName.equals("LINE")) {
                        shapeArgs = parseLineArgsFrom(input);
                        nextShape = Factory.getInstance().build(shapeName, shapeArgs);
                    } else if (shapeName.equals("CIRCLE")) {
                        shapeArgs = parseCircleArgsFrom(input);
                        nextShape = Factory.getInstance().build(shapeName, shapeArgs);
                    } else if (shapeName.equals("POLYGON")) {
                        shapeArgs = parsePolygonArgsFrom(input);
                        nextShape = Factory.getInstance().build(shapeName, shapeArgs);
                    } else if (shapeName.equals("TRIANGLE")) {
                        shapeArgs = parseTriangleArgsFrom(input);
                        nextShape = Factory.getInstance().build(shapeName, shapeArgs);
                    } else if (shapeName.equals("DIAMOND")) {
                        shapeArgs = parseDiamondArgsFrom(input);
                        nextShape = Factory.getInstance().build(shapeName, shapeArgs);
                    }

                    paintingQueue.add(nextShape);
                    paintingQueue.drawAll();
                }

                paintingQueue.drawAll();
                input.close();
                ImageIO.write(paintingQueue.getImage(), "PNG", output);
            } else {
                System.err.println("CANVAS WAS NOT INITIALIZED ON FIRST LINE");
            }
        } catch (IOException var13) {
            var13.printStackTrace();
        }

    }
}

