import java.util.*;
import java.lang.*;

class CHFINGS{
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
    public static long solution(long n,long k){
        long mod = 1000000007;
        long s=(k-2)/(n-1);
        s=(s+1)%mod;
        long r=(k-2)%(n-1);
        long f=(k+r)%mod;
        long ans=(f*s)%mod;
        ans=(ans*power(2,mod-2,mod))%mod;
        return ans;
    }
    public static long power(long x,long y,long m) { 
        if (y == 0) 
            return 1; 
        long p = power(x, y/2, m) % m; 
        p = (p * p) % m; 
        return (y%2 == 0)? p : (x * p) % m; 
    }
}
