import java.util.*;
import java.lang.*;

public class sumagcd{
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        int test = scan.nextInt();
        while (test-->0) {
            int n = scan.nextInt();
            ArrayList<Integer> al = new ArrayList<Integer>();
            for(int i =0;i<n;i++){
                al.add(scan.nextInt());
            }
            long result = getsolution(al);
            System.out.println(result);   
        }
    }
    public static long solution(ArrayList<Integer> a){
        if(a.size()==2)
            return a.get(0)+a.get(1);
        Collections.sort(a);
        int size = a.size();
        int gcd = 1;
        for(int i =0;i<size-1;i++){
            int temp;
            if(i==0)
            {   temp = gcd(a.get(i),a.get(i+1));
                if(temp ==1)
                    return 1+a.get(size-1);
                else
                    gcd = temp;
                //System.out.println(gcd);
                continue;
            }
            temp = gcd(a.get(i),a.get(i+1));
            gcd = gcd(gcd,temp);
            //System.out.println(gcd);
            if(gcd == 1)
                break;    
        }
        return gcd + a.get(size-1);

    }
    public static int gcd(int a,int b){
        if(b==0)
            return a;
        else return gcd(b,a%b);
    }
    public static long getsolution(ArrayList<Integer> a){
        int size = a.size();
        Collections.sort(a);
        int num = a.get(0);
        ArrayList<Integer> factor = new ArrayList<Integer>();
        ArrayList<Integer> other = new ArrayList<Integer>();
        factor.add(num);
        for(int i =1;i<size;i++){
            if(gcd(a.get(i),num)!=1){
                factor.add(a.get(i));
            }
            else{
                other.add(a.get(i));
            }
        }
        long temp = solution(a);
        long gcd1,gcd2;
        if(factor.size()==a.size())
        {
            gcd2 = factor.get(size-1);
            factor.remove(size-1);
            gcd1 = gcdlist(factor);
            
        }
        else
        {
            gcd1 = gcdlist(factor);
            gcd2 = other.get(other.size()-1);
        }
        if(temp > gcd1 + gcd2)
            return temp;
        else
            return gcd1 + gcd2;

    }
    public static long gcdlist(ArrayList<Integer> a){
        Collections.sort(a);
        int size = a.size();
        int gcd = a.get(0);
        for(int i =1;i<size;i++){
            int temp;
            temp = gcd(a.get(0),a.get(i));
            gcd = gcd(gcd,temp);    
        }
        System.out.println("sol  "+gcd);
        return gcd;
    }
}