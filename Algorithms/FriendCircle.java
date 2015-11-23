

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;
 
/**
 * Created by vinod on 16/7/15.
 */
public class FriendCircle {
 
    static LinkedList<Integer> queue = new LinkedList<Integer>();
 
    public static int friendCircles(String[] friends) {
        String[] tempFriendArray = friends.clone();
        int friendCircleCount=0;
        for (int j=0;j<tempFriendArray.length;j++){
            if (tempFriendArray[j].contains("Y") ){
                friendCircleCount++;
                tempFriendArray[j] = processRow(tempFriendArray[j]);
                while (!queue.isEmpty()){
                    int head = queue.poll();
                    tempFriendArray[head] = processRow(tempFriendArray[head]);
                }
            }
        }
        return  friendCircleCount;
    }
 
    public static String processRow(String row){
        Integer indexOfY;
        while((indexOfY=row.indexOf('Y')) != -1){
            queue.addLast(indexOfY);
            row = row.replaceFirst("Y","N");
        }
        return row;
    }
 
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numFriends = Integer.parseInt(scanner.nextLine());
        String[] friends = new String[numFriends];
        for (int i = 0; i < numFriends; i++) {
            friends[i]=scanner.nextLine();
        }
        //String[] friends = new String[]{"YYNN","YYYN","NYYN","NNNY"};

        System.out.println(friendCircles(friends));
    }
}