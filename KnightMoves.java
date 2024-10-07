import java.util.*;
public class KnightMoves{
    public static int[] dx = {2,2,-2,-2,1,-1,1,-1};
    public static int[] dy = {1,-1,1,-1,2,2,-2,-2};
    public static boolean legalMove(int[][] board,int x,int y){
        int n = board.length;
        if(x >= 0 && x < n && y >= 0 && y < n && board[x][y] == -1){
            return true;
        }else{
            return false;
        }
    }
    public static boolean helper(int[][] board, int x,int y,int moves){
        if(moves == board.length*board.length - 1){
            return true;
        }
        for(int i = 0;i < 8;i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(legalMove(board,nx,ny) == true){
                board[nx][ny] = moves+1;
                if(helper(board,nx,ny,moves+1)){
                    return true;
                }
                board[nx][ny] = -1;
            }
        }
        return false;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the chessboard : ");
        int n = sc.nextInt();
        System.out.println("Enter the starting co-ordinates of the knight : ");
        int x = sc.nextInt(), y = sc.nextInt();
        int[][] board = new int[n][n];
        for(int i = 0;i < n;i++){
            for(int j = 0;j < n;j++){
                board[i][j] = -1;
            }
        }
        board[x][y] = 0;
        boolean ans = helper(board,x,y,0);
        if(!ans){
            System.out.println("All squares cannot be visited");
        }else{
            System.out.println("The number of moves for each square is : ");
            for(int i = 0;i < n;i++){
                for(int j = 0;j < n;j++){
                    System.out.printf("%d ",board[i][j]);
                }
                System.out.printf("%n");
            }
        }
        sc.close();
    }
}
