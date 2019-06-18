import java.util.*;
import java.lang.*;

public class proxyc{
    public static void main(String arg[]){
        Scanner scan = new Scanner(System.in);
        int test  = scan.nextInt();
        while(test-- >0){
            int total = scan.nextInt();
            String attend = scan.next();
            int result = solution(attend);
            System.out.println(result);    
        }
    }
    public static int solution(String str){

        int size = str.length();
        int absent = 0;
        for(int i = 0;i<size;i++){
            if(str.charAt(i)=='A')
                absent++;
        }
        if(size < 4 && absent >0 )
            return -1;
        if(size == 4 && absent >1 )
            return -1;

        int totalneed = ( size%4==0)? (3*size)/4 : (3*size)/4 +1;
        //System.out.println("size "+size+"\n totalneed "+totalneed+"\n absent "+absent);
        if( size - absent > totalneed)
            return 0;

        int maxabsent = size - totalneed;

        int proxy = Math.abs(maxabsent - absent);
        //System.out.println("maxabssent "+maxabsent+"\n proxy"+proxy);
        int count =0;

        for(int i =2;i<size-2;i++){
            if(str.charAt(i)=='A'){
                if((str.charAt(i-1)=='P'||str.charAt(i-2)=='P')&&(str.charAt(i+1)=='P'||str.charAt(i+2)=='P'))
                    count++;
            }
            if(count == proxy)
                break;
        }
        if(count == proxy)
            return count;
        return -1;
    }
}