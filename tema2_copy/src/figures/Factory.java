package figures;

public final class Factory {
    
    private static Factory instance = new Factory();

    private Factory() { }
    
    public static Factory getInstance() {
        return instance;
    }
    
    public void confirmExistence() {
        System.out.println("I think therefore I am");
    }

    public static Figure createForm(final String type, final String[] specs) {

        switch (type) {
        case "LINE":
            return new Line(specs);

        case "SQUARE":
            return new Square(specs);
            
        case "RECTANGLE":
            return new Rectangle(specs);
            
        case "CIRCLE":
            return new Circle(specs);
            
        case "TRIANGLE":
            return new Triangle(specs);
            
        case "DIAMOND":
            return new Diamond(specs);
            
        case "POLYGON":
            return new Polygon(specs);

        default:
            return null;
        }

    }

}
