import java.util.*;

class Solution{
    public static void main(String dwa[]){
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while(t-->0){
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
            long ans = 1;
            int nc = 0;
            for(int i=1;i<=n;i++){
                if(v[i]==0){
                    nc++;
                    int cs = dfs(i,v,a);
                    ans = (ans*cs)%((long)Math.pow(10,9)+7);
                }
            }
            System.out.println(nc + " " + ans);
        }
    }

    public static int dfs(int i, int []v, ArrayList<Integer>[] a){
        v[i] = 1;
        int cs = 1;
        for(int x : a[i]){
            if(v[x]==0){
                cs += dfs(x,v,a);
            }
        }
        return cs;
    }
}