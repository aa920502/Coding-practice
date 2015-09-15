//http://www.slipperybrick.com/wp-content/uploads/2007/12/led_binary_watch.jpg

import java.util.*;

class BinaryWatch{
    static ArrayList<String> getAllTime(int n){
        ArrayList<String> res=new ArrayList();
        if (n>=9) return res;
        for (int i=0; i<=n&&i<=4; i++){
            if (n-i>6) continue; 
            //n-i: number of one for minute, 6-n+i: number of zero for minute
            ArrayList<Integer> mins=new ArrayList();
            getTime(n-i, 6-n+i, 0, 60, mins);
            //i: number of one for hour, 4-i: number of zero for hour. 
            ArrayList<Integer> hours=new ArrayList();
            getTime(i, 4-i, 0, 12, hours);
            for (int hour : hours){
                for (int min: mins){
                    String tmp=((hour<10?"0":"")+hour+ " : " + (min<10?"0":"")+min);
                    res.add(tmp);
                    System.out.println(tmp);
                }          
            }     
        }    
        return res;
    }
    static void getTime(int oneNB, int zeroNB, int currTime, int maxVal, ArrayList<Integer> times){
        if (zeroNB==0&&oneNB==0&&currTime<=maxVal)  times.add(currTime);            
        if (oneNB>0){
            currTime=currTime<<1; currTime++;
            getTime(oneNB-1, zeroNB, currTime, maxVal, times);
            currTime=currTime>>1;
        }
        if (zeroNB>0){
            currTime=currTime<<1;
            getTime(oneNB, zeroNB-1, currTime, maxVal, times);
            currTime=currTime>>1;
        }
    }

    public static void main(String[] args){
    	int times = 1;
    	ArrayList<String> res = getAllTime(times);
    	for(String s:res) System.out.println(s);
    }
}