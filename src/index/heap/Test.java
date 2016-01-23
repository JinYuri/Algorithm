package index.heap;

public class Test {
    public static void main(String[] args) {
        MinHeap heap = new MinHeap(10);
        
        heap.insert(6);
        heap.insert(8);
        heap.insert(9);
        heap.insert(3);
        heap.insert(5);
        heap.insert(7);
        heap.insert(0);
        heap.insert(4);
        heap.insert(1);
        heap.insert(2);
        
        heap.printHeap();
        
        heap.extractMin();
        heap.printHeap();
        
        heap.extractMin();
        heap.printHeap();
        
        heap.insert(10);
        heap.printHeap();
    }
}
