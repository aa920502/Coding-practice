// Given an arbitrary text document written in English, write a program that will generate a concordance, 
// i.e. an alphabetical list of all word occurrences, labeled with word frequencies. 
// Bonus: label each word with the sentence numbers in which each occurrence appeared.

// Here assume lower case and upper case word are treated same

//Usage: javac Concordance.java
//       java Concordance "test.txt"       


import java.util.*;
import java.io.*;


class Concordance{

    static private ArrayList<Word> record;
    

    //Word class   
    class Word{
        String content;
        int frequency;
        HashSet<Integer> sentenceNumber;
        
        public Word(String content) {
            this.content = content;
            this.frequency = 1;  // count the word it self
            sentenceNumber = new HashSet<>();
        }
       
        public boolean equals(Word word2) {
            return this.content.equals(word2.content);
        }
        
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("{");
            sb.append(frequency);
            sb.append(":");
            for(int i : sentenceNumber){
                sb.append(i+",");
            }
            sb.setLength(sb.length() - 1);
            sb.append("}");
            return content + "   "  + sb.toString();
        }

        public void IncreaseFrequency() {
            frequency++;
        }

        public boolean EndOfLine(){
            return content.charAt(content.length()-1)=='.';
        }

        public void InsertLineNum(int linenum){
            sentenceNumber.add(linenum);
        }
    }
       
    // Comparator for word frequency
    static class FrequencyComparator implements Comparator<Word> {
        @Override
        public int compare(Word a, Word b) {
            return b.frequency - a.frequency;
        }
    }
        
    public static void main(String [] args) throws FileNotFoundException{
        Concordance concordance = new Concordance();
        String filename = (args.length==0||args==null)?null:args[0];
        if(filename == null) {
            System.out.println("Invalid input, please input a file name");
            System.exit(0);
        }       
        record = new ArrayList<Word>();
        concordance.ReadAndAdd(filename);
        Collections.sort(record,new FrequencyComparator()); // sort the words by frequency
        for (int i = 0; i < record.size(); i++){
            System.out.println(record.get(i));
        }
    }
    
    //Read input file, and add each word
    public void ReadAndAdd(String filename) throws FileNotFoundException{
        Scanner input = new Scanner(new File(filename));
        int curSentence = 1;

        while (input.hasNext()){
            Word word = new Word(input.next().toLowerCase());
            if(word.EndOfLine()){
                curSentence ++;
            }

            int index = record.indexOf(word);
            word.sentenceNumber.add(curSentence);

            if (index == -1){
                record.add(word);
            }
            else{
                record.get(index).InsertLineNum(curSentence);
                record.get(index).IncreaseFrequency();
            }
        }    
    }
}