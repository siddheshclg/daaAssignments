import java.util.*;
public class Apsp{

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of vertices : ");
        int n = sc.nextInt();
        int[][] dis = new int[n][n];
        for(int i = 0;i < n;i++){
            for(int j = 0;j < n;j++){
                dis[i][j] = sc.nextInt();
            }
        }
        for(int k = 0;k < n;k++){
            for(int i = 0;i < n;i++){
                for(int j = 0;j < n;j++){
                    dis[i][j] = Math.min(dis[i][j],dis[i][k]+dis[k][j]);
                }
            }
        }
        System.out.println("The Shortest Path from each vertex to every other vertex is : ");
        for(int i = 0;i < n;i++){
            for(int j = 0;j < n;j++){
                System.out.printf("%d ",dis[i][j]);
            }
            System.out.printf("%n");
        }
        sc.close();
    }
}
