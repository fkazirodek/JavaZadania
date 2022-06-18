package c02.ex16_17;

class Main {
    public static void main(String[] args) {
        Queue<String> queue = new Queue<>();

        queue.add("First");
        queue.add("Second");
        queue.add("Third");

        Queue<String>.Iterator iterator = queue.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println("Remove elements");

        queue.remove();
        queue.remove();

        iterator = queue.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
