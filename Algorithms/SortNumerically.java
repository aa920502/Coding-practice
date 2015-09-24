// Problem 4:

// Implement a function sort_numerically() that will receive a list of numbers represented in 
// English words and return the listed sorted by their numeric value, starting with the largest.
// Input:
// [
//     "seventy five",                                                                                                     
//     "two hundred forty one",                                                                                           
//     "three thousand",                                                                                          
//     "one million thirty five thousand twelve",
//     "twenty", 
//     "five hundred thousand",
//     "two hundred", 
// ]

// Output:
 
// [
//   "one million thirty five thousand twelve",
//   "five hundred thousand"
//   "three thousand",
//   "two hundred forty one",
//   "two hundred",
//   "seventy five",
//   "twenty",
// ]

import java.util.*;

class SortNumerically{

  public static HashMap<String,Long> map = new HashMap<>();
  public static Long trillionPrefixNum = 0L;
  public static Long billionPrefixNum = 0L;
  public static Long millionPrefixNum = 0L;
  public static Long thousandPrefixNum = 0L;

  public static void initialize(HashMap<String,Long> map){
      map.put("trillion",1000000000000L);
      map.put("billion",1000000000L);
      map.put("million",1000000L);
      map.put("thousand",1000L);
      map.put("hundred",100l);
      map.put("ninety",90L);
      map.put("eighty",80L);
      map.put("seventy",70L);
      map.put("sixty",60L);
      map.put("fifty",50L);
      map.put("forty",40L);
      map.put("thirty",30L);
      map.put("twenty",20L);
      map.put("ten",10L);
      map.put("nineteen",19L);
      map.put("eighteen",18L);
      map.put("seventeen",17L);
      map.put("sixteen",16L);
      map.put("fifteen",15L);
      map.put("fourteen",14L);
      map.put("thirteen",13L);
      map.put("twelve",12L);
      map.put("eleven",11L);
      map.put("nine",9L);
      map.put("eight",8L);
      map.put("seven",7L);
      map.put("six",6L);
      map.put("five",5L);
      map.put("four",4L);
      map.put("three",3L);
      map.put("two",2L);
      map.put("one",1L);
  }


  //prefix for trillion, billion, million, thousand is 1-999; prefix for hundred is 1-99
  public static String[] sort_numerically(String[] input){
    if(input==null||input.length==0) return null;
    String[] ret = new String[input.length];
    int index = 0;

    ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
    ArrayList<String> trillions = new ArrayList<>();
    ArrayList<String> billions = new ArrayList<>();
    ArrayList<String> millions = new ArrayList<>();
    ArrayList<String> thousands = new ArrayList<>();
    ArrayList<String> hundreds = new ArrayList<>();
    ArrayList<String> lessthanhundreds = new ArrayList<>();
    list.add(trillions);
    list.add(billions);
    list.add(millions);
    list.add(thousands);
    list.add(hundreds);
    list.add(lessthanhundreds);

    // Group numbers
    for(int i = 0; i<input.length; i++){
      if(input[i].contains("trillion")) list.get(0).add(input[i]);
      else if(input[i].contains("billion")) list.get(1).add(input[i]);
      else if(input[i].contains("million")) list.get(2).add(input[i]);
      else if(input[i].contains("thousand")) list.get(3).add(input[i]);
      else if(input[i].contains("hundred")) list.get(4).add(input[i]);
      else list.get(5).add(input[i]);
    }
    // HashMap for number table
    HashMap<Long,String> numberTable = new HashMap<>();
    ArrayList<Long> tempArr = new ArrayList<>();

    for(int j=0; j<list.size();j++){
      for(int i = 0; i<list.get(j).size(); i++){
        Long num_val = GetStringValue(list.get(j).get(i));
        numberTable.put(num_val,list.get(j).get(i));
        tempArr.add(num_val);
      }
      Collections.sort(tempArr);
      Collections.reverse(tempArr);
      for(int i=0;i<tempArr.size();i++){
        ret[index++] = numberTable.get(tempArr.get(i));
      }
      tempArr.clear();
    }
    return ret;
  }

  //Given a string, return numeric value
  public static Long GetStringValue(String s){
      Long lessthanhundred = 0L;
      String temp = s;
      //contains "trillion"
      temp = helper(temp,"trillion");
      // contain "billion"
      temp = helper(temp,"billion");
      // contain "million"
      temp = helper(temp,"million");
      //contain "thousand"
      temp = helper(temp,"thousand");

      lessthanhundred = CalculatePrefix(temp);
      Long result = trillionPrefixNum*map.get("trillion")+billionPrefixNum*map.get("billion")
                      +millionPrefixNum*map.get("million")+thousandPrefixNum*map.get("thousand")+lessthanhundred;
      //Reset prefix
      trillionPrefixNum = 0L;
      billionPrefixNum = 0L;
      millionPrefixNum = 0L;
      thousandPrefixNum = 0L;
      return result;
  }

  // Process string with keyword str
  public static String helper(String temp, String str){
    if(temp.contains(str)){
        String prefix = temp.split(str)[0];
        prefix = prefix.substring(0,prefix.length()-1);
        switch (str) {
          case "trillion": trillionPrefixNum = CalculatePrefix(prefix);
                           break;
          case "billion":  billionPrefixNum = CalculatePrefix(prefix);
                           break;
          case "million":  millionPrefixNum = CalculatePrefix(prefix);
                           break;
          case "thousand": thousandPrefixNum = CalculatePrefix(prefix);
                           break;
        }
        temp = temp.split(str).length>1?temp.split(str)[1].substring(1):"";
      }
    return temp;
  }

  //translate number in range 1-999
  public static Long CalculatePrefix(String s){
    if(s =="" || s.length()==0) return 0L;
    int ret = 0;
    String temp = s;
    Long hundredPrefixNum = 0L;
    if(temp.contains("hundred")){
      String hundredPrefix = temp.split("hundred")[0];
      hundredPrefix = hundredPrefix.substring(0,hundredPrefix.length()-1);
      hundredPrefixNum = map.get(hundredPrefix);
      temp = temp.split("hundred").length==1? "":temp.split("hundred")[1].substring(1); 
    }
    String[] arr = (temp=="")?new String[0]:temp.split(" ");
    Long j =0L;
    for(int i = 0; i<arr.length; i++){
      j += map.get(arr[i]);
    }
    return hundredPrefixNum*100+j;
  }


  public static void main(String[] args){
    initialize(map);
    String[] test = new String[]{"seventy five","two trillion",                                                                                                    
    "two hundred forty one",                                                                                           
    "three thousand", "three hundred thousand five hundred thirty one",                                                                                         
    "one million thirty five thousand twelve",
    "twenty", 
    "five hundred thousand"};
    test = sort_numerically(test);
   for(int i=0;i<test.length;i++){
     System.out.println(test[i]);
    }
  }
}