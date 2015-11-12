class enumExample{
	public enum Company {
		EBAY, PAYPAL, GOOGLE, YAHOO, ATT
	}

	public enum Company2 {
		EBAY(30), PAYPAL(10), GOOGLE(15), YAHOO(20), ATT(25);
		private int value;
 
		private Company2(int value) {
			this.value = value;
		}
	}
 
	Company cName;
 
	public enumExample(Company cName) {
		this.cName = cName;
	}
 
	public void companyDetails() {
		switch (cName) {
		case EBAY:
			System.out.println("Biggest Market Place in the World.");
			break;
 
		case PAYPAL:
			System.out.println("Simplest way to manage Money.");
			break;
 
		case GOOGLE:
		case YAHOO:
			System.out.println("1st Web 2.0 Company.");
			break;
 
		default:
			System.out.println("Google - biggest search giant.. ATT - my carrier provider..");
			break;
		}
	}
 
	public static void main(String[] args) {
		enumExample ebay = new enumExample(Company.EBAY);
		ebay.companyDetails();
		enumExample paypal = new enumExample(Company.PAYPAL);
		paypal.companyDetails();
		enumExample google = new enumExample(Company.GOOGLE);
		google.companyDetails();
		enumExample yahoo = new enumExample(Company.YAHOO);
		yahoo.companyDetails();
		enumExample att = new enumExample(Company.ATT);
		att.companyDetails();

		for (Company2 cName : Company2.values()) {
			System.out.println("Company Value: " + cName.value + " - Comapny Name: " + cName);
		}
	}

}