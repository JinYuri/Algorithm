package jungol.btree;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import jungol.btree.model.Node;

public class BinaryTreeWidth2 {
    static Map<Integer, Node> nodeMap = new HashMap<>();
    static Node root = null;
    static int maxLevel = 0;
    static int[][] widthByLevel = null;
    static int order = 0;
    static int maxWidth = 0;
    static int maxRow = 1;
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        
        while(N > 0){
            Node pnode = setParent(sc.nextInt());
            setChild(pnode, sc.nextInt(), true);
            setChild(pnode, sc.nextInt(), false);
            
            N--;
        }
        
        //start, end
        widthByLevel = new int[maxLevel][2];
        
        // dfs
        dfs(root);
        
        System.out.println("[Result] Row : " + maxRow + " , Width : " + (maxWidth+1) );
    }

    private static void dfs(Node parent){
        if(parent == null){
            return;
        }
        dfs(parent.getLeft());

        order++;
        System.out.println("["+order+"]"+parent.getId() +"("+ parent.getLevel()+")");
        
        int level = parent.getLevel();
        // start
        if(widthByLevel[level-1][0] == 0){
            widthByLevel[level-1][0] = order;
            widthByLevel[level-1][1] = order; 
        } 
        // end
        else if(widthByLevel[level-1][1] < order){
            widthByLevel[level-1][1] = order; 
            if(maxWidth <= (widthByLevel[level-1][1] - widthByLevel[level-1][0])){
                if(maxWidth < (widthByLevel[level-1][1] - widthByLevel[level-1][0]) || maxRow > level){
                    maxRow = level;
                }
                maxWidth = widthByLevel[level-1][1] - widthByLevel[level-1][0];
            }
        }
        dfs(parent.getRight());
    }
    
    private static Node setParent(int id){
        Node parent = nodeMap.get(id);
        if(parent == null){
            root = new Node();
            root.setId(id);
            root.setLevel(1);
            nodeMap.put(id, root);
            
            if(maxLevel < root.getLevel()){
                maxLevel = root.getLevel();
            }
            
            return root;
        }
        return parent;
    }
    
    private static void setChild(Node parent, int id, boolean isLeft){
        if(id != -1){
            Node child = new Node();
            child.setId(id);
            child.setLevel(parent.getLevel()+1);
            if(isLeft){
                parent.setLeft(child);
            }
            else{
                parent.setRight(child);
            }
            nodeMap.put(id, child);
            
            if(maxLevel < child.getLevel()){
                maxLevel = child.getLevel();
            }
        }
    }
}
