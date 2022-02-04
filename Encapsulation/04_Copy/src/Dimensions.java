public class Dimensions {
    private final double width;
    private final double heigth;
    private final double length;

    public Dimensions(){
        width = 0;
        heigth = 0;
        length = 0;
    }
    public Dimensions(double width, double height, double length) {
        this.width = width;
        this.heigth = height;
        this.length = length;
    }

    public Dimensions setDimension(double width, double heigth, double length){
        return new Dimensions(width,heigth,length);
    }

    public double canculateVolume(){
        return width * heigth * length;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return heigth;
    }

    public double getLength() {
        return length;
    }
}
