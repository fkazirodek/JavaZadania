package c02.ex16_17;

import java.util.NoSuchElementException;
import java.util.Objects;

class Queue<T> {
    private Node<T> head;
    private Node<T> tail;

    void add(T value) {
        Node<T> node = new Node<T>(value, null, null);
        if (isEmpty()) {
            head = node;
        } else {
            tail.next = node;
            node.previous = tail;
        }
        tail = node;
    }

    void remove() {
        if (head == null) throw new IllegalStateException("Queue is empty");

        if (head.next != null) {
            head.next.previous = null;
        }
        head = head.next;
    }

    Node<T> getHead() {
        return head;
    }

    Node<T> getTail() {
        return tail;
    }

    boolean isEmpty() {
        return head == null;
    }

    Iterator iterator() {
        return new Iterator();
    }

    class Iterator {
        private Node<T> next = head;

        T next() {
            if (next == null) throw new NoSuchElementException("No more elements");
            T value = next.value;
            next = next.next;
            return value;
        }

        boolean hasNext() {
            return next != null;
        }
    }

    static class Node<T> {
        private Node<T> next;
        private Node<T> previous;
        private T value;

        Node(final T value, final Node<T> previous, final Node<T> next) {
            this.next = next;
            this.previous = previous;
            this.value = value;
        }

        @Override
        public boolean equals(final Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            final Node<?> node = (Node<?>) o;
            return Objects.equals(next, node.next) && Objects.equals(previous, node.previous) && Objects.equals(value, node.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(next, previous, value);
        }

        @Override
        public String toString() {
            return "Node{" +
                    "next=" + next +
                    ", value=" + value +
                    '}';
        }
    }
}
