package index.list;

public class Test {
    public static void main(String[] args) {
//        testLinkedLcist();
//        testDoublyLinkedList();
        testCircularLinkedList();
    }
    
    private static void testLinkedList(){
        LinkedList list = new LinkedList();
        list.addNode(1);
        list.addNode(2);
        list.addNode(3);
        list.addNode(4);
        list.addNode(5);
        
        list.printNode(null);
        list.printNode(null);
        
        list.deleteNode(3);
        list.printNode(null);
        
        list.deleteNode(1);
        list.printNode(null);
        
        list.addNode(6);
        
        list.printNode(null);
    }
    
    private static void testDoublyLinkedList(){
        DoublyLinkedList list = new DoublyLinkedList();
        list.addNode(1);
        list.addNode(2);
        list.addNode(3);
        list.addNode(4);
        list.addNode(5);
        
        list.printNode(null);
        list.printReverseNode(null);
        
        list.deleteNode(3);
        list.printNode(null);
        list.printReverseNode(null);
        
        list.deleteNode(1);
        list.printNode(null);
        list.printReverseNode(null);
        
        list.addNode(6);
        
        list.printNode(null);
        list.printReverseNode(null);
    }
    
    private static void testCircularLinkedList(){
        CircularLinkedList list = new CircularLinkedList();
        list.addNode(1);
        list.addNode(2);
        list.addNode(3);
        list.addNode(4);
        list.addNode(5);
        
        list.printNode(null);
        list.printNode(2);
        
        list.deleteNode(3);
        list.printNode(null);
        list.printNode(4);
        
        list.deleteNode(1);
        list.printNode(null);
        list.printNode(4);
        
        list.addNode(6);
        
        list.printNode(null);
        list.printNode(4);
    }
}
