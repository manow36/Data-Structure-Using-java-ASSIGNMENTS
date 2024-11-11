package Mankey;


    public class LinkedStack<T> {

        private int count;
        private Node<T> top;  // head

        private static class Node<T> {
            private T element;
            private Node<T> next;

            public Node(T element) {
                this.element = element;
                this.next = null;
            }

            public T getElement() {
                return element;
            }

            public Node<T> getNext() {
                return next;
            }

            public void setNext(Node<T> next) {
                this.next = next;
            }
        }

        public LinkedStack() {
            count = 0;
            top = null;
        }

        // Operations
        public int size() {
            return count;
        }

        public boolean isEmpty() {
            return count == 0; // top == null;
        }

        public void push(T element) {
            Node<T> newNode = new Node<>(element);
            newNode.setNext(top);
            top = newNode;
            count++;
        }

        public T pop() {
            if (isEmpty()) {
                System.out.println("Empty Stack!");
                return null;
            }
            T removedElement = top.getElement();
            top = top.getNext();
            count--;
            return removedElement;
        }

        public T peek() {
            if (isEmpty()) {
                System.out.println("Empty Stack!");
                return null;
            }
            return top.getElement();
        }

        public void display() {
            if (isEmpty()) {
                System.out.println("Stack is empty!");
            } else {
                Node<T> current = top;
                while (current != null) {
                    System.out.println(current.getElement());
                    current = current.getNext();
                }
            }
        }

        // Remove elements based on conditions
        public void removeCenter() {
            if (isEmpty()) {
                System.out.println("Stack is empty! No elements to remove.");
                return;
            }
            if (count == 1 || count == 2) {
                System.out.println("Cannot remove elements. Stack has " + count + " element(s).");
                return;
            }

            if (count == 4) {
                // Remove two center elements
                Node<T> current = top;
                Node<T> previous = null;
                int index = 0;

                // Find the first middle element (index 1)
                while (current != null && index < 1) {
                    previous = current;
                    current = current.getNext();
                    index++;
                }

                // Remove first middle element
                if (previous != null) {
                    previous.setNext(current.getNext());
                    System.out.println("Removed middle element: " + current.getElement());
                    count--;
                }

                // Adjust current to point to the new first middle
                current = previous.getNext(); // This now points to the second middle element

                // Remove second middle element
                if (current != null) {
                    previous.setNext(current.getNext());
                    System.out.println("Removed middle element: " + current.getElement());
                    count--;
                }
            } else if (count == 3) {
                // Remove only the center element
                Node<T> current = top;
                Node<T> previous = null;
                int index = 0;

                // Find the middle element (index 1)
                while (current != null && index < 1) {
                    previous = current;
                    current = current.getNext();
                    index++;
                }

                // Remove the middle element
                if (previous != null) {
                    previous.setNext(current.getNext());
                    System.out.println("Removed middle element: " + current.getElement());
                    count--;
                }
            }
        }

        // Main method for testing
        public static void main(String[] args) {
            LinkedStack<String> names = new LinkedStack<>();
            names.push("Ali");
            names.push("Ahmed");
            names.push("Gedi");
            names.push("Hawa");

            System.out.println("Original Stack:");
            names.display();

            // Attempt to remove center elements
            names.removeCenter(); // Should remove 2 center elements
            // Attempt to remove center elements again
            names.removeCenter(); // Should remove 1 center element now
            System.out.println("Stack after removing center element:");
            names.display();
        }
    }

