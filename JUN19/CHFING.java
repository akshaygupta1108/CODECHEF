import java.util.*;
import java.lang.*;

public class CHFING{
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        int test = scan.nextInt();
        while(test-->0){
            long num = scan.nextLong();
            long k = scan.nextLong();
            long result = solution(num,k);
            System.out.println(result);
        }
    }
    public static long solution(long num,long k){
        long mod = 1000000007;
        long a = k-num;
        long d = num-1;
        if(  num >= k)
            return k-1;
        long tn;
        if( a%d == 0){
            tn = d;
        }
        else {
            tn = a%d;
        }
        long n = ( a - tn )/d +1;
        long sum = a + tn;
        long first,second;
        if(sum%2==0)
        {
            first = sum/2;
            second = n;
        }
        else{
            first = n/2;
            second = sum;
        }

        long result = ((first*second)%mod+(k-1)%mod)%mod;
        return result;
    }
}