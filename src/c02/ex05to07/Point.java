package c02.ex05to07;

class Point {

    private double x;
    private double y;

    public Point() {
    }

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    /**
     * Moves the point by the given values
     * @param moveX shift in the x direction
     * @param moveY shift in the y direction
     * @return new Point shifted by given values
     */
    public Point translate(double moveX, int moveY) {
        return new Point(x + moveX, y + moveY);
    }

    /**
     * Scaled the point by the given values
     * @param s the values by which points are scaled
     * @return new Point scaled by given value
     */
    public Point scale(double s) {
        return new Point(x * s, y * s);
    }

    /**
     * Moves the point by the given values
     * @param moveX shift in the x direction
     * @param moveY shift in the y direction
     */
    public void translate_modify(double moveX, int moveY) {
        this.x = x + moveX;
        this.y = y + moveY;
    }

    /**
     * Scaled the point by the given values
     * @param s the values by which points are scaled
     */
    public void scale_modify(double s) {
        this.x = x * s;
        this.y = y * s;
    }

    @Override
    public String toString() {
        return "Point [x=" + x + ", y=" + y + "]";
    }

}
