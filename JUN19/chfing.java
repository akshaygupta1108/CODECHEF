import java.util.*;
import java.lang.*;

public class chfing{
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        int test = scan.nextInt();
        while(test-->0){
            long num = scan.nextLong();
            long k = scan.nextLong();
            long result = solution(num,k);
            System.out.println(result);
            //long result2 = solution2(num, k);
            //System.out.println(result2);
            //long result3 = solution3(num,k);
            //System.out.println(result3);
        }
    }
    public static long solution(long num,long k){
        if(num >= k)
            return k-1;
        long n = num + k;
        long arr[] = new long [(int)num];
        for(int i =0;i<num;i++){
            arr[i] = k +i;
        }
        long counter =0 ,count =0;
        for(long i = n;;i++){
            if(ispossible(arr,num,i)==0){
                counter++;
                count =0;
            }
            else{
                count++;
            }
            if(count == k)
                break;
        }
        return counter+(k-1);

    }
    public static int ispossible(long arr[],long n,long num){
        if(num < 0)
            return 0;
        if(num == 0)
            return 1;
        if(n <= 0 && num >=1)
            return 0;
        return ispossible(arr, n-1, num) + ispossible(arr, n, num-arr[(int)n-1]);
    }
    public static long solution2(long num,long k){
        long mod =(long) Math.pow(10, 9) +7;
        long sum = 0;
        for(long i = 1;i<k;i++){
            sum = (sum + i)%mod;
        }
        return sum;
    }
    public static long solution3(long num , long k){
        long mod = 1000000007;
        long a =0,b=0;
        if( k%2==0)
        { 
            a = k/2;
            b = k-1;
        }
        else
        {
            a = (k-1)/2;
            b = k;
        }
        long result = (a*b)%mod;
        return result;
    }
    public static long solution4(long num,long k){
        long mod = 1000000007;
        long a = k-1;
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
        long n = (-1)*( tn - a )/d +1;
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
        long result = (first*second)%mod;
        return result;
    }
}