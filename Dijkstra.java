import java.util.*;
public class Dijkstra{
    public static void dijkstra(int[] dis, int[][] adjacent,int k){
        int n = dis.length;
        for(int i = 0;i < n;i++){
            dis[i] = Integer.MAX_VALUE;
        }
        dis[k] = 0;
        int[] vis = new int[n];
        for(int i = 0;i < n;i++){
            vis[i] = 0;
        }
        for(int i = 0;i < n-1;i++){
            int cur = -1,minm = Integer.MAX_VALUE;
            for(int j = 0;j < n;j++){
                if(vis[j] == 0 && dis[j] < minm){
                    cur = j;
                    minm = dis[j];
                }
            }
            if(cur == -1) break;
            vis[cur] = 1;
            for(int j = 0;j < n;j++){
                if(adjacent[cur][j] != Integer.MAX_VALUE && dis[j] > dis[cur] + adjacent[cur][j]){
                    dis[j] = dis[cur] + adjacent[cur][j];
                }
            }
        }
    }
    public static void main(String[] args){
        int n,m;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of vertices : ");
        n = sc.nextInt();
        System.out.println("Enter the number of edges : ");
        m = sc.nextInt();
        int[][] adjacent = new int[n][n];
        for(int i = 0;i < n;i++){
            for(int j = 0;j < n;j++){
                adjacent[i][j] = Integer.MAX_VALUE;
            }
        }
        for(int i = 0;i < m;i++){
            int x,y,w;
            x = sc.nextInt();
            y = sc.nextInt();
            w = sc.nextInt();
            x--;y--;
            adjacent[x][y] = Math.min(adjacent[x][y],w);
            adjacent[y][x] = Math.min(adjacent[y][x],w);
        }
        int[] shortestPath = new int[n];
        System.out.println("Enter the starting vertex : ");
        int k = sc.nextInt();
        k--;
        dijkstra(shortestPath, adjacent, k);
        for(int i = 0;i < n;i++){
            if(shortestPath[i] == Integer.MAX_VALUE){
                System.out.printf("%d -> %d = cannot be reached%n",k,i);
            }else{
                System.out.printf("%d -> %d = %d%n",k,i,shortestPath[i]);
            }
        }
        sc.close();
    }
}
