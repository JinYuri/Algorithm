package index.list;

public class LinkedList {
    private LinkedNode header;
    private LinkedNode tail;

    public void addNode(int id) {
        LinkedNode node = new LinkedNode();
        node.setId(id);
        if (header == null) {
            header = node;
            tail = node;
        } else {
            tail.setNext(node);
            tail = node;
        }
    }

    public void deleteNode(int id) {
        if (header.getId() == id) {
            header = header.getNext();
        } else {
            LinkedNode temp = getNode(header, id);
            LinkedNode target = temp.getNext();
            
            if (target == tail) {
                temp.setNext(null);
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
}
