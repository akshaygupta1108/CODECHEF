import java.util.*;
import java.lang.*;

public class ks2{
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        int test = scan.nextInt();
        while(test-- >0){
            String num = scan.next();
            
            String ans = solution(num);

            System.out.println(ans);
        
        }
    }
    public static String solution(String num){
        int sum =0;
        int length = num.length();
        for(int i =0;i<length;i++){
            sum += num.charAt(i) -'0';
        }
        int rem = sum%10;
        int remaining;
        if(rem ==0)
            remaining = 0;
        else
            remaining = 10-rem;
        String res = num+remaining;
        return res;
    }
}