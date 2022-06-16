package c02.ex05to07;

class Main {
    public static void main(String[] args) {
        Point p1 = new Point(3, 4).translate(1, 3).scale(0.5);
        System.out.println(p1);
        Point p2 = new Point(3, 3).translate(3, 4).scale(0.5);
        System.out.println(p2);
    }
}
