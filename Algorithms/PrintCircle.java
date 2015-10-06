//Print a circle

class PrinCircle{
	public void Print(int radius){
		for(int i = -radius; i<=radius; i++){
			for(int j = -radius; j<=radius; j++){
				//Pythagorean theorem
				if(i*i+j*j<=radius*radius) 
					System.out.print("* ");
				else 
					System.out.print(". ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args){
		PrinCircle p = new PrinCircle();
		p.Print(6);
	}

}