// You are not allowed to use loop constructs like while, for..etc, 
// and you can only use the following ADT functions on Stack S:
// isEmpty(S)
// push(S)
// pop(S)

// Solution:
// The idea of the solution is to hold all values in Function Call Stack 
// until the stack becomes empty. When the stack becomes empty, 
// insert all held items one by one at the bottom of the stack.

// For example, let the input stack be

//     1  <-- top
//     2
//     3
//     4   
// First 4 is inserted at the bottom.
//     4 <-- top

// Then 3 is inserted at the bottom
//     4 <-- top    
//     3

// Then 2 is inserted at the bottom
//     4 <-- top    
//     3 
//     2
     
// Then 1 is inserted at the bottom
//     4 <-- top    
//     3 
//     2
//     1

import java.util.*;

class ReverseStackRecursion{
    public static void InsertAtBottom(Stack<Integer> st, int i){
        if(st.isEmpty()){
            st.push(i);
            return;
        }
        else{
            int temp = st.pop();
            InsertAtBottom(st,i);
            st.push(temp);
        }
    }

    public static void Reverse(Stack<Integer> st){
        if(!st.isEmpty()){
            int temp = st.pop();
            Reverse(st);
            InsertAtBottom(st,temp);
        }
    }

    public static void main(String[] args){
        Stack<Integer> st = new Stack<>();
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        
        Reverse(st);
        while(!st.isEmpty()){
            System.out.println(st.pop());
        }
    }
}



