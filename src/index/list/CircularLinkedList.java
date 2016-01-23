package index.list;

public class CircularLinkedList {

    private LinkedNode header;
    private LinkedNode tail;

    public void addNode(int id) {
        LinkedNode node = new LinkedNode();
        node.setId(id);
        if (header == null) {
            node.setNext(node);
            header = node;
            tail = node;
        } else {
            node.setNext(header);
            tail.setNext(node);
            tail = node;
        }
    }

    public void deleteNode(int id) {
        if (header.getId() == id) {
            header = header.getNext();
            tail.setNext(header);
        } else {
            LinkedNode temp = getNode(header, id);
            LinkedNode target = temp.getNext();
            
            if (target == tail) {
                temp.setNext(header);
                tail = temp;
            } 
            else{
                temp.setNext(target.getNext());
            }
        }
    }

    private LinkedNode getNode(LinkedNode temp, int id) {
        if (temp.getNext().getId() == id) {
            return temp;
        } else {
            return getNode(temp.getNext(), id);
        }
    }

    public void printNode(LinkedNode temp) {
        if (temp == null) {
            temp = header;
        }
        System.out.print(temp.getId() + " ");
        if (temp != tail) {
            printNode(temp.getNext());
        } else {
            System.out.println();
        }
    }
    
    public void printNode(int id) {
        LinkedNode temp = getNode(header, id);
        LinkedNode target = temp.getNext();
        System.out.print(target.getId() + " ");
        printNode(target.getNext(), target.getId());
    }
    
    public void printNode(LinkedNode temp, int id) {
        if (temp.getId() != id) {
            System.out.print(temp.getId() + " ");
            printNode(temp.getNext(), id);
        } else {
            System.out.println();
        }
    }

}
