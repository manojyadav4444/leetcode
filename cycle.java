import java.util.*;

class Solution{
    public static void main(String dwa[]){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int e = in.nextInt();
        int v[] = new int[n+1];
        int c[] = new int[n+1];
        ArrayList<Integer>[] a = new ArrayList[n+1]; 
        for (int i = 0; i < n+1; i++) { 
            a[i] = new ArrayList<Integer>(); 
        } 

        for(int i=0;i<e;i++){
            int x = in.nextInt();
            int y = in.nextInt();
            a[x].add(y);
            a[y].add(x);
        }
        
        boolean cycle = dfs(1, -1, v,a);
        System.out.println(cycle);
    }

    public static boolean dfs(int i, int parent, int []v, ArrayList<Integer>[] a){
        v[i] = 1;
        for(int x : a[i]){
            if(v[x]==0){
                dfs(x, i, v,a);
            }
            else{
                if(x!=parent) return true;
            }
        }
        return false;   
    }
}