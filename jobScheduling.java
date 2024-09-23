import java.util.*;

public class jobScheduling {
    static class Job{
        char id;
        int deadline;
        int profit;
        public Job(char id,int deadline, int profit){
            this.id=id;
            this.deadline = deadline;
            this.profit = profit;
        }
        public static void printSequence(Job[] jobs,int n,int t){
            Arrays.sort(jobs,(a, b) -> b.profit-a.profit);
            boolean[] slot = new boolean[t];
            char[] order = new char[t];
            for(int i = 0;i < n;i++){
                for(int j = Math.min(t-1,jobs[i].deadline-1);j >= 0;j--){
                    if(slot[j] == false){
                        slot[j] = true;
                        order[j] = jobs[i].id;
                        break;
                    }
                }
            }
            for(char ch : order){
                if(ch != 0){
                    System.out.printf("%c ",ch);
                }
            }
            System.out.printf("%n");
        }
    }
    
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of jobs");
        int n = sc.nextInt();
        Job[] jobs = new Job[n];
        for(int i = 0;i < n;i++){
            char id;
            int deadline,profit;
            System.out.println("Enter job id : ");
            id = sc.next().charAt(0);
            System.out.println("Enter deadline : ");
            deadline = sc.nextInt();
            System.out.println("Enter profit : ");
            profit = sc.nextInt();
            jobs[i] = new Job(id, deadline, profit);
        }
        System.out.println("Enter the number of days");
        int t = sc.nextInt();
        System.out.println("The sequence of jobs for maximum profit is ");
        Job.printSequence(jobs, n, t);
        sc.close();
    }
}