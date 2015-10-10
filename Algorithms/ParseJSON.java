// Given a string that which is in JSON format, print it in a human readable way. 
//For example" {'a':'1', 'b':['c':'2','d':'3']}" should output:
//    a:1
//    b:[
//       c:2
//       d:3
//       ]


class ParseJSON{
	public static String prettyJSON(String input){
		StringBuilder res = new StringBuilder();
		int i = 0;
		int space = 0;

		while(i<input.length()){
			int j = 0;
			while(j<space){
				res.append(' ');
				j++;
			}

			char c = input.charAt(i);
			if(c=='{'||c=='['){
				res.append(c);
				res.append('\n');
				space += 2;
				i++;
			}
			else if(c=='}'||c==']'){
				res.append('\n');
				space -= 2;
				int k = 0;
				while(k<space){
					res.append(' ');
				}
				res.append(c);
				i++;
			}
			else if(c==','){
				res.append('\n');
				i++;
			}
			else if(c=='\''){
				i++;
			}
			else{
				res.append(c);
				i++;
			}
		}
		return res.toString();
	}

	public static void main(String[] args){
		String input = "{'meau':{'id':'file','value':'File','popup':{'menuitem':[{'value':'new','onclick':'CreateNewDoc()'},{'value':'Open','onclick':'OpenDoc()'}]}}}";
		System.out.println(prettyJSON(input));
	}
}





