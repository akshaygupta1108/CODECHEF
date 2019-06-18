import java.util.*;
import java.lang.*;
public class lentmo{
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        int test = scan.nextInt();
        while(test-->0){
            int n = scan.nextInt();
            int tmp[] = new int[n];
            for(int i =0;i<n;i++){
                tmp[i] =  scan.nextInt();
            }
            int k = scan.nextInt();
            int x = scan.nextInt();
            money mn[] = new money[n];
            for(int i = 0; i<n;i++){
                int oldvalue = tmp[i];
                int newvalue = oldvalue^x;
                int diff = newvalue - oldvalue;
                money m = new money(oldvalue,newvalue,diff);
                mn[i] = m;
            }
            Arrays.sort(mn,new Comparator<money>() {

                @Override
                public int compare(money a, money b) {
                    return (b.diff - a.diff);
                }
            });
            long sum = 0;
            for(int i =0;i<n;i++){
                if(i<k)
                    sum +=mn[i].newvalue;
                else
                    sum+=mn[i].oldvalue;
                System.out.println(sum);
            }
            System.out.println(sum);

        }        
    }
}
class money{
    int oldvalue;
    int  newvalue;
    int diff;

    money(int value1,int value2,int value3){
        oldvalue = value1;
        newvalue = value2;
        diff = value3;
    }
}
