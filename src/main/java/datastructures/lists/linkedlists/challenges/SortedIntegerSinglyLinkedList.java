package main.java.datastructures.lists.linkedlists.challenges;

public class SortedIntegerSinglyLinkedList {

    private IntegerNode head;
    private int size;

    public void insertSorted(int integerToAdd){
        IntegerNode integerNode = new IntegerNode(integerToAdd);
        if (head == null || head.getNumber() >= integerToAdd) {
            integerNode.setNext(head);
            head = integerNode;
        } else {
            IntegerNode current = head.getNext();
            IntegerNode previous = head;
            while (current != null && current.getNumber() <= integerToAdd) {
                previous = current;
                current = current.getNext();
            }
            integerNode.setNext(current);
            previous.setNext(integerNode);
        }
        size++;
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return head == null;
    }

    public void printLinkedList() {
        IntegerNode current = head;
        System.out.print("HEAD -> ");
        while (current != null){
            System.out.print(current);
            System.out.print(" -> ");
            current = current.getNext();
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        SortedIntegerSinglyLinkedList sortedIntegerSinglyLinkedList = new SortedIntegerSinglyLinkedList();
        sortedIntegerSinglyLinkedList.insertSorted(4);
        sortedIntegerSinglyLinkedList.printLinkedList();
        sortedIntegerSinglyLinkedList.insertSorted(3);
        sortedIntegerSinglyLinkedList.printLinkedList();
        sortedIntegerSinglyLinkedList.insertSorted(5);
        sortedIntegerSinglyLinkedList.printLinkedList();
        sortedIntegerSinglyLinkedList.insertSorted(20);
        sortedIntegerSinglyLinkedList.printLinkedList();
        sortedIntegerSinglyLinkedList.insertSorted(15);
        sortedIntegerSinglyLinkedList.printLinkedList();
        sortedIntegerSinglyLinkedList.insertSorted(12);
        sortedIntegerSinglyLinkedList.printLinkedList();
        sortedIntegerSinglyLinkedList.insertSorted(13);
        sortedIntegerSinglyLinkedList.printLinkedList();
        System.out.println("How many items are in the LinkedList currently? " + sortedIntegerSinglyLinkedList.getSize());
    }


}
