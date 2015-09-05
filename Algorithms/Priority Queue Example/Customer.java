public class Customer{
	private int id;
	private String name;

	public Customer(int id, String name){
		this.id=id;
		this.name=name;
	}

	public int getID(){
		return this.id;
	}

	public String getName(){
		return this.name;
	}
}