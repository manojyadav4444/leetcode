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
            c[i] = -1;
            a[i] = new ArrayList<Integer>(); 
        } 

        for(int i=0;i<e;i++){
            int x = in.nextInt();
            int y = in.nextInt();
            a[x].add(y);
            a[y].add(x);
        }
        boolean theory = dfs(1,v, c, 0, a);
        System.out.println(theory);

    }

    public static boolean dfs(int i, int []v, int[] c, int color, ArrayList<Integer>[] a){{
        v[i] = 1;
        c[i] = color;
        for(int x : a[i]){
            if(v[x]==0){
                dfs(x,v,c,1^color,a);
            }
            else{
                if(color==c[x]){
                    return false;
                }
            }
        }
        return true;
    }
}




}