package index.graph;

public class GraphDfs {
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
    
    public static void dfs(int n){
        visited[n] = 1;
        System.out.print(n+1);
        for(int i=0; i<8; i++){
            if(iMat[n][i] == 1 && visited[i] != 1){
                dfs(i);
            }
        }
    }
    
    public static void main(String[] args) {
        dfs(0);
    }

}
