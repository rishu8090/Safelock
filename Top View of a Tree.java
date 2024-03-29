import java.util.*;
import java.util.HashMap;
public class App {

    static class Node{
        int data;
        Node left, right;
        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class Info{
        Node node;
        int hd;
        public Info(Node node, int hd){
            this.node = node; 
            this.hd = hd;     // hd = horizontal distance.
        }
    }

    public static void topView(Node root){
        // By ,level order traversal
         Queue<Info> q = new LinkedList<>();
         HashMap<Integer ,Node > map = new HashMap<>();
         int min = 0 , max = 0;
         q.add(new Info(root, 0));
         q.add(null);

         while(!q.isEmpty()){
            Info curr = q.remove();
            if(curr == null){
                if(q.isEmpty()){
                    break;   // if we have traverse all nodes.
                }else{
                    q.add(null);  // we added null again for next level.
                }
            }else{
                if(!map.containsKey(curr.hd)){   // this is first time my hd is occuring.
                    map.put(curr.hd , curr.node);
             }
             if(curr.node.left != null){
                 q.add(new Info(curr.node.left ,curr.hd-1));
                 min = Math.min(min , curr.hd-1);
             }
             if(curr.node.right != null){
                 q.add(new Info(curr.node.right , curr.hd +1));
                 max = Math.max(max , curr.hd+1);
             }
      }   
    }
    
         for(int i = min;  i <= max ; i++){
            System.out.print(map.get(i).data + " ");
         }
         System.out.println();    
    }
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
         /*
         *           1
         *         /  \
         *        2    3
         *       / \  / \
         *      4   5 6  7
         */

         Node root = new Node(1);
         root.left = new Node(2);
         root.right = new Node(3);
         root.left.left = new Node(4);
         root.left.right = new Node(5);
         root.right.left = new Node(6);
         root.right.right = new Node(7);

         topView(root);
    }
}
