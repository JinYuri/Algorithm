package index.list;

public class DoublyLinkedList {
    private DoublyLinkedNode header;
    private DoublyLinkedNode tail;
    
    public void addNode(int id){
        DoublyLinkedNode node = new DoublyLinkedNode();
        node.setId(id);
        
        if(header == null){
            header = node;
            tail = node;
        }
        else{
            tail.setNext(node);
            node.setPrev(tail);
            tail = node;
        }
    }
    
    public void deleteNode(int id) {
        if (header.getId() == id) {
            header = header.getNext();
            header.setPrev(null);
        } else {
            DoublyLinkedNode temp = getNode(header, id);
            DoublyLinkedNode target = temp.getNext();
            
            if (target == tail) {
                temp.setNext(null);
                tail = temp;
            } 
            else{
                temp.setNext(target.getNext());
                target.getNext().setPrev(temp);
            }
        }
    }

    private DoublyLinkedNode getNode(DoublyLinkedNode temp, int id) {
        if (temp.getNext().getId() == id) {
            return temp;
        } else {
            return getNode(temp.getNext(), id);
        }
    }

    public void printNode(DoublyLinkedNode temp) {
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
    
    public void printReverseNode(DoublyLinkedNode temp) {
        if (temp == null) {
            temp = tail;
        }
        System.out.print(temp.getId() + " ");
        if (temp != header) {
            printReverseNode(temp.getPrev());
        } else {
            System.out.println();
        }
    }
}
