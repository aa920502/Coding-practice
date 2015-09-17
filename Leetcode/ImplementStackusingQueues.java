// Implement the following operations of a stack using queues.

// push(x) -- Push element x onto stack.
// pop() -- Removes the element on top of the stack.
// top() -- Get the top element.
// empty() -- Return whether the stack is empty.
// Notes:
// You must use only standard operations of a queue -- which means only push to back, peek/pop from front, size, 
// and is empty operations are valid.
// Depending on your language, queue may not be supported natively. You may simulate a queue by using a list or deque 
// (double-ended queue), as long as you use only standard operations of a queue.
// You may assume that all operations are valid (for example, no pop or top operations will be called on an empty stack).

class ImplementStackusingQueues{
	class MyStack {
	    Queue<Integer> q1 = new LinkedList<>();
	    Queue<Integer> q2 = new LinkedList<>();
	    
	    // Push element x onto stack.
	    public void push(int x) {
	        if(!q1.isEmpty()) q1.add(x);
	        else q2.add(x);
	    }

	    // Removes the element on top of the stack.
	    public void pop() {
	        if(q1.isEmpty()&&q2.isEmpty()) return;
	        
	        if(!q1.isEmpty()){
	            while(!q1.isEmpty()){
	                int i = q1.poll();
	                if(!q1.isEmpty()){q2.add(i);}
	            }
	        }
	        else{
	            while(!q2.isEmpty()){
	                int i = q2.poll();
	                if(!q2.isEmpty()){q1.add(i);}
	            }
	        }
	    }

	    // Get the top element.
	    public int top() {
	        if(q1.isEmpty()&&q2.isEmpty()) return -1;
	        if(!q1.isEmpty()){
	            while(!q1.isEmpty()){
	                int i = q1.poll();
	                q2.add(i);
	                if(q1.isEmpty()) return i;
	            }
	        }
	        else{
	            while(!q2.isEmpty()){
	                int i = q2.poll();
	                q1.add(i);
	                if(q2.isEmpty()) return i;
	            }
	        }
	        return -1;
	    }

	    // Return whether the stack is empty.
	    public boolean empty() {
	        return q1.isEmpty()&&q2.isEmpty();
	    }
	}
}