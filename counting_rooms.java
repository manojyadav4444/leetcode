import java.util.*;

class Solution{
    public static void main (String []rd){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        char [][]a = new char[n][m];
        for(int i=0;i<n;i++){
            String temp = in.next();
            for(int j=0;j<m;j++){
                a[i][j] = temp.charAt(j);
            }
        }
        int cc = 0;
        int [][]v = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(v[i][j]==0 && a[i][j]=='.'){
                    cc++;
                    dfs(i,j,v,a);
                }
            }
        }
        System.out.println(cc);
    }

    public static void dfs(int i,int j,int [][]v,char [][]a){
        int n = a.length;
        int m = a[0].length;
        v[i][j] = 1;
        if(isValid(i-1,j,n,m,a,v)){
            dfs(i-1,j,v,a);
        }
        if(isValid(i,j-1,n,m,a,v)){
            dfs(i,j-1,v,a);
        }
        if(isValid(i+1,j,n,m,a,v)){
            dfs(i+1,j,v,a);
        }
        if(isValid(i,j+1,n,m,a,v)){
            dfs(i,j+1,v,a);
        }
    }
    public static boolean isValid(int i,int j,int n,int m, char [][]a, int [][]v){
        if(i<0 || i>=n || j<0 || j>=m || v[i][j]==1) return false;
        else if(a[i][j]=='#'){
            return false;
        } 
        return true;   
    }

}