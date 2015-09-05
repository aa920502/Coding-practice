import java.util.*;

public class test{
	public static void main (String[] args){
		Queue<Customer> customerPriorityQueue = new PriorityQueue<>(5,idComparater);
		addCustomer(customerPriorityQueue);
		pollCustomer(customerPriorityQueue);
	}

	// implement customized comparator for priority queue
	// if not implemented here, default comparator cannot handle Customer
	public static Comparator<Customer> idComparater=new Comparator<Customer>(){
		@Override
		public int compare(Customer c1, Customer c2){
			return (int)(c1.getID()-c2.getID());
		}
	};

	public static void addCustomer(Queue<Customer> customerPriorityQueue){
		for (int i=0;i<5;i++){
			customerPriorityQueue.add(new Customer(getRandomNumberWith(1,10),"Java"+i));
		}
	}

	public static void pollCustomer(Queue<Customer> customerPriorityQueue){
		System.out.println("Order Customer with ID");
		for (int i=0;i<5;i++){
			Customer c = customerPriorityQueue.poll();
			System.out.println("Customer ID: " + c.getID() + " Customer Name: "+ c.getName()  );
		}
	}

	/*Generate random number*/
	public static int getRandomNumberWith(int low, int high){
		Random rand=new Random();
		int randomwNumber=rand.nextInt(high-low)+low;
		if(randomwNumber==low){
			return randomwNumber+1;
		}
		return randomwNumber;
	}
}