import java.util.*;
import java.lang.*;
public class rsigns{
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        int test = scan.nextInt();
        while(test-->0){
            long k = scan.nextLong();
            long result = solution(k);
            System.out.println(result);
        }
    }
    public static long solution(long k){

        long mod = 1000000007;
        long result = 1;
        long num = k-1;
        long a = 2;
        while(num > 0){
            if( (num & 1) == 1 )
                result = (result * a)%mod;
            num = num >> 1;
            a = (a*a)%mod;
        }
        result = (10*result)%mod;
        return result;
    }
}
