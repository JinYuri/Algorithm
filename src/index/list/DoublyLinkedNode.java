package index.list;

public class DoublyLinkedNode {
    private int id;
    private DoublyLinkedNode prev;
    private DoublyLinkedNode next;
    public DoublyLinkedNode getPrev() {
        return prev;
    }
    public void setPrev(DoublyLinkedNode prev) {
        this.prev = prev;
    }
    public DoublyLinkedNode getNext() {
        return next;
    }
    public void setNext(DoublyLinkedNode next) {
        this.next = next;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
}
