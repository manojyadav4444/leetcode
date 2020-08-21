import java.util.*;

class Solution{
    public static void main(String dwa[]){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int e = in.nextInt();
        if(e!=n-1){
            System.out.println("NO");
            return;
        }
        int v[] = new int[n+1];
        int dist[] = new int[n+1];
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
        int cc = 0;
        for(int i=1;i<=n;i++){
            if(v[i]==0){
                dfs(i,v,a);
                cc++;
            }
        }
        if(cc==1) System.out.println("YES");
        else System.out.println("NO");

    }

    public static void dfs(int i, int []v, ArrayList<Integer>[] a){{
        v[i] = 1;
        for(int x : a[i]){
            if(v[x]==0)
            dfs(x,v,a);
        }
    }
}




}