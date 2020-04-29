package DesignPatternMultiThread.chap2.practice;

public class Line {
    private final Point startPoint;
    private final Point endPoint;

    public Line(int startx, int starty, int endx, int endy) {
        this.startPoint = new Point(startx, starty);
        this.endPoint = new Point(endx, endy);
    }

    public Line(Point startPoint, Point endPoint) {
//        this.startPoint = startPoint;
//        this.endPoint = endPoint;
        this.startPoint = new Point(startPoint.x, startPoint.y);
        this.endPoint = new Point(endPoint.x, endPoint.y);
    }

    public int getStartX() {
        return startPoint.getX();
    }

    public int getStartY() {
        return startPoint.getY();
    }

    public int getEndX() {
        return endPoint.getX();
    }

    public int getEndY() {
        return endPoint.getX();
    }

    @Override
    public String toString() {
        return "Line{" +
                "startPoint=" + startPoint +
                ", endPoint=" + endPoint +
                '}';
    }
}
