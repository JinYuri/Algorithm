package etc.inner;

class InnerClassTest {
	class MinHeap {
	    private int[] heapArr;
	    private int pointer;

	    public MinHeap(int n) {
	        heapArr = new int[n];
	        pointer = -1;
	    }

	    public void insert(int id) {
	        if (pointer == heapArr.length) {
	            System.out.println("Heap is full!!");
	            return;
	        }
	        heapArr[++pointer] = id;
	        reorder(pointer);
	    }

	    public void extractMin() {
	        if (pointer < 0) {
	            System.out.println("Heap is empty!!");
	            return;
	        } else if (pointer == 0) {
	            pointer--;
	            heapArr = new int[heapArr.length];
	        } else {
	            heapArr[0] = heapArr[pointer];
	            heapArr[pointer--] = 0;
	            reorderFromRoot(0);
	        }

	    }

	    private void reorderFromRoot(int index) {
	        if(index == pointer){
	            return;
	        }
	        else if((2*index)+1 > pointer || (2*index)+2 > pointer){
	            return;
	        }
	       if(heapArr[(2*index)+1] < heapArr[index]){
	           int temp = heapArr[(2*index)+1];
	           heapArr[(2*index)+1] = heapArr[index];
	           heapArr[index] = temp;
	           reorderFromRoot((2*index)+1);
	       }
	       else if(heapArr[(2*index)+2] < heapArr[index]){
	           int temp = heapArr[(2*index)+2];
	           heapArr[(2*index)+2] = heapArr[index];
	           heapArr[index] = temp;
	           reorderFromRoot((2*index)+2);
	       }
	    }

	    private void reorder(int index) {
	        if (index == 0) {
	            return;
	        }
	        if (index == 1) {
	            if (heapArr[0] > heapArr[index]) {
	                int temp = heapArr[0];
	                heapArr[0] = heapArr[index];
	                heapArr[index] = temp;
	                reorder((index-1)/2);
	            } 
	        } 
	        else {
	            if (heapArr[(index-1)/2] > heapArr[index]) {
	                int temp = heapArr[(index-1)/2];
	                heapArr[(index-1)/2] = heapArr[index];
	                heapArr[index] = temp;
	                reorder((index-1)/2);
	            } 
	        }
	        
	    }
	    
	    public void printHeap(){
	        for(int i : heapArr){
	            System.out.print( i + " ");
	        }
	        System.out.println();
	    }
	}
   public static void main(String args[]){
	   InnerClassTest i = new InnerClassTest();
	   InnerClassTest.MinHeap heap = i.new MinHeap(10);
       
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
