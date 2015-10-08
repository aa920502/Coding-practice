// Input:
// string: 'bacdadc...f'
// re-defined order: 'dbca...'
// Output:
// sort the input string based on the re-defined order
// string: 'ddbccaa...'

// hash1 (String): a,2 b,1 c,2 d,2 f,1    length: m
// hash2 (order): d,0 b,1, c,2, a,3       length: n

class SortStringBasedOnOrderString{

    public String Solution(String input, String order){

        Map<Character,Integer> occurance = new HashMap<>();
        for(int i=0; i<input.length();i++){
            if(!occurance.containsKey(input.charAt(i))){
                occurance.put(input.charAt(i),1);
            }
            else{
                occurance.put(input.charAt(i),occurance.get(input.charAt(i)+1));
            }
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<order.length();i++){
            if(occurance.containsKey(order.charAt(i))){
                for(int j=0;j<occurance.get(order.charAt(i));j++){
                    sb.append(order.charAt(i));
                }
                occurance.remove(order.charAt(i));
            }
        }
        
        for(Character key : occurance.keySet()){
            for(int j = 0; j<occurance.get(key);j++){
                sb.append(key);
            }
        }
        
        return sb.toString();
    }
}