import java.util.*;
    
/**
 * Given a list of non negative integers, arrange them such that they form the
 * largest number.
 * 
 * For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.
 * 
 * Note: The result may be very large, so you need to return a string instead
 * of an integer.
 * 
 * Tags: Sort
 */

class LargestNum{
	//Comparator
	public static String largestNumber(int[] nums) {
        if(nums==null||nums.length==0) return null;
        String[] nums2 = new String[nums.length];
        for(int i=0;i<nums.length;i++){
            nums2[i] = String.valueOf(nums[i]);
        }
        //Decending order comparator
        Comparator<String> comp = new Comparator<String>(){
            @Override
            public int compare(String s1, String s2){
                return (s2+s1).compareTo(s1+s2);
            }
        };
        Arrays.sort(nums2,comp);
        StringBuilder res = new StringBuilder();
        if (nums2[0].equals("0")) return "0"; // deal with 0
        for (String s : nums2){
        	System.out.println(s);
        	res.append(s);
        }
        return res.toString();
    }


    //comparable 
    public static String largestNumber2(int[] nums) {
        if(nums==null||nums.length==0) return null;
        compar[] nums2 = new compar[nums.length];
        for(int i=0;i<nums.length;i++){
        	nums2[i] = new compar(nums[i]);
        }
        Arrays.sort(nums2);
        StringBuilder b = new StringBuilder();
        for(int i=0; i<nums2.length; i++){
        	System.out.println(nums2[i].num);
            b.append(nums2[i].num);
        }
        return b.toString();
    }
    public static class compar implements Comparable<compar>{
    	String num;
    	public compar(int n){
    		this.num = String.valueOf(n);
    	}
    	@Override
	    public int compareTo(compar n){
	    	String s1 = n.num + this.num;
	    	String s2 = this.num+n.num;
	    	for(int i=0;i<s1.length();i++){
	    		if(s1.charAt(i)>s2.charAt(i)) return 1;
	    		else if(s1.charAt(i)<s2.charAt(i)) return -1;
	    	}
	    	return 0;
	    }
	}

    public static void main(String[] args){
    	int[] nums = new int[]{2,31,22,45,78,53,95,36,99};
    	String ret = largestNumber(nums);
    }

}