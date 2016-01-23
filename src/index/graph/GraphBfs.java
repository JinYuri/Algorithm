package index.graph;

public class GraphBfs {
    private static int[][] iMat = 
        { {0, 1, 1, 0, 0, 0, 0, 0},
          {1, 0, 0, 1, 1, 0, 0, 0},
          {1, 0, 0, 0, 0, 1, 1, 0},
          {0, 1, 0, 0, 0, 0, 0, 1},
          {0, 1, 0, 0, 0, 0, 0, 1},
          {0, 0, 1, 0, 0, 0, 0, 1},
          {0, 0, 1, 0, 0, 0, 0, 1},
          {0, 0, 0, 1, 1, 1, 1, 0}
        };
        
    private static int[] visited = new int[8];
    private static int[] queue = new int[8];
    
    private static int front = 0;
    private static int rear = 0;
    
    public static void bfs(int n){
        visited[n] = 1;
        System.out.print(n+1);
        queue[rear++] = n;
        while(front < rear){
            n = queue[front++];
            for(int i=0; i<8; i++){
                if(iMat[n][i] ==1 && visited[i] != 1){   
                    visited[i] = 1;
                    System.out.print(i+1);
                    queue[rear++] = i;
                }
            }
        }
    }
    public static void main(String[] args) {
        bfs(0);
    }
}
