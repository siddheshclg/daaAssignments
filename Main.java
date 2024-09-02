import java.lang.*;
import java.util.*;
public class Main {
    public static String removeLeadingZeroes(String s){
        boolean takeAll = false;
        String t = "";
        for(int i = 0;i < s.length();i++){
            if(takeAll){
                t += s.charAt(i);
            }else{
                if(s.charAt(i) != '0'){
                    takeAll = true;
                    t += s.charAt(i);
                }
            }
        }
        return t;
    }
    public static String diff(String s,String t){
        String ans = "";
        if((t.length() > s.length())|| (s.length() == t.length() && s.compareTo(t) < 0)){
            String temp = s;
            s = t;
            t = temp;
        }
        while(t.length() < s.length()){
            t = "0" + t;
        }
        int borrow = 0;
        for(int i = s.length()-1;i >= 0;i--){
            int a = s.charAt(i) - '0';
            int b = t.charAt(i) - '0';
            if(borrow > 0){
                borrow = 0;
                a--;
            }
            if(a < b){
                borrow = 1;
                a += 10;
            }
            ans =(char)((a-b) + '0') + ans;
        }
        return ans;
    }
    public static String add(String s, String t){
        String ans = "";
        if(t.length() > s.length()){
            String temp = s;
            s = t;
            t = temp;
        }
        while(t.length() < s.length()){
            t = "0" + t;
        }
        int carry = 0;
        for(int i = s.length()-1;i >= 0;i--){
            int a = s.charAt(i) - '0';
            int b = t.charAt(i) - '0';
            int sum = a+b+carry;
            carry = sum/10;
            ans = (char)((sum % 10) + '0') + ans;
        }
        if(carry > 0){
            ans = (char)((carry) + '0') + ans;
        }
        return ans;
    }
    public static String multiply(String s,String t){
        if(s.length() == 1 && t.length() == 1){
            int a = Integer.parseInt(s),b = Integer.parseInt(t);
            int prod = a*b;
            return Integer.toString(prod);
        }
        if(t.length() > s.length()){
            String temp = s;
            s = t;
            t = temp;
        }
        while(t.length() < s.length()){
            t = "0" + t;
        }
        String al = "",ar = "",bl = "",br = "";
        for(int i = 0;i < s.length();i++){
            if(i < (s.length())/2){
                al += s.charAt(i);
                bl += t.charAt(i);
            }else{
                ar += s.charAt(i);
                br += t.charAt(i);
            }
        }

        String lmul = multiply(al,bl);
        String rmul = multiply(ar,br);

        String mmul = diff(multiply(add(al,ar),add(bl,br)),add(lmul,rmul));
        for(int i = 0;i < 2*ar.length();i++){
            lmul += "0";
        }
        for(int i = 0;i < ar.length();i++) {
            mmul += "0";
        }
        String ans = removeLeadingZeroes(add(lmul,add(mmul,rmul)));
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.printf("Choose the option:%n1.Multiply two number%n2.Square a number%n");
        while(true) {
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.printf("Enter two numbers : %n");
                    String s, t;
                    s = sc.nextLine();
                    t = sc.nextLine();
                    System.out.printf("Multiplication : %s", multiply(s, t));
                    break;
                case 2:
                    System.out.printf("Enter a number : %n");
                    String num = sc.nextLine();
                    System.out.printf("Square : %s", multiply(num, num));
                    break;
                default:
                    return;
            }
        }
    }
}
