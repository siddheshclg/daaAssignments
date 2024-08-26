import java.io.IOException;
import java.lang.*;
import java.util.*;
public class Main {
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
            if(a >= b){
                ans =(char)((a-b) + '0') + ans;
            }else{
                borrow = 1;
                a += 10;
                ans =(char)((a-b) + '0') + ans;
            }
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
        for(int i = 0;i < ar.length();i++){
            mmul += "0";
        }
	//System.out.printf("%s %s ", lmul, rmul);
	String ans = add(lmul,add(mmul,rmul));
	return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String ans = multiply(s,s);
        System.out.println(ans);
    }
}
