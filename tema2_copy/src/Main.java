
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import algorithms.Algorithms;
import figures.Factory;
import figures.Figure;
import figures.MyCanvas;
import visitors.DrawingVisitor;
import visitors.Visitor;

public final class Main {

    private Main() { }

    public static void main(final String[] args) throws IOException {

        String s;
        if (args.length == 1) {
            s = args[0];
        } else {
            s = "/home/mihnea/facultate/poo/tema2_copy/src/input/test30.in ";
        }

        File input = new File(s);

        int nrFigures;
        int i;

        String inputString;
        
        MyCanvas finalImage = null;

        Scanner scanner = new Scanner(input);

        nrFigures = Integer.parseInt(scanner.nextLine());

        String figureType;
        
        DrawingVisitor visitor = new DrawingVisitor();

        for (i = 0; i < nrFigures; i++) {

            inputString = scanner.nextLine();

            figureType = inputString.substring(0, inputString.indexOf(" "));
            inputString = inputString.substring(inputString.indexOf(" ") + 1);


            String[] tokens = inputString.split(" ");

            if (figureType.equals("CANVAS")) {

                finalImage = new MyCanvas(tokens);

            } else {

                Factory figureFactory = Factory.getInstance();
                
                    //figureFactory.confirmExistence();
                
                Figure figure = figureFactory.createForm(figureType, tokens);
                
                figure.accept(visitor);

            }

        }
        
        finalImage.printCanvas();

        scanner.close();
    }

}
