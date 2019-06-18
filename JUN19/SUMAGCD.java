import java.util.*;
import java.lang.*;
public class SUMAGCD{
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        int test = scan.nextInt();
        while(test-->0){
            int num = scan.nextInt();
            HashSet<Long> set = new HashSet<>();
            for(int i =0;i<num;i++)
            {
                set.add(scan.nextLong());
            }
            ArrayList<Long> list = new ArrayList<>();
            for(long numb : set){
                list.add(numb);
            }
            long result = solution(list);
            System.out.println(result);
        }
    }
    public static long solution(ArrayList<Long> list){
        int size = list.size();
        if(size == 1)
            return list.get(0);
        if(size == 2)
            return list.get(0)+list.get(1);
        Collections.sort(list);
        ArrayList<Long> temp1 = new ArrayList<>();
        ArrayList<Long> temp2 = new ArrayList<>();
        for(int i = 0;i<size -2;i++){
            temp1.add(list.get(i));
            temp2.add(list.get(i));
        }
        temp1.add(list.get(size-2));
        temp2.add(list.get(size-1));
        long gcd1 = getgcd(temp1);
        long gcd2 = getgcd(temp2);
        if( gcd1 + list.get(size-1)>gcd2 + list.get(size-2)){
            return gcd1 + list.get(size-1);
        }
        else
            return gcd2 + list.get(size-2);
    }
    public static long getgcd(ArrayList<Long> a){
        long size = a.size();
        long gcd = a.get(0);
        for(int i =1;i<size;i++){
            long temp;
            temp = gcd(a.get(0),a.get(i));
            gcd = gcd(gcd,temp);    
        }
        return gcd;
    }
    public static long gcd(long a, long b){
        if(b == 0)
            return a;
        return gcd(b,a%b);
    }
}