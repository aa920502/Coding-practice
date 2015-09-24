// Encode and decode a list of strings


class EncodeDecode{
	private static String enCode(String[] list){
		if(list == null || list.length == 0){ return null;}

		String result = "";
		result += list.length + "#"; for(String ss : list){
		result += ss.length() + "%"; }
		for(String ss : list){ result += ss;}
		return result; 
	}
		
	private static String[] deCode(String s){ 
		if(s == null || s.length() == 0){ return null; }

		String[] sizeAndcontent = s.split("#");
		int count = Integer.parseInt(sizeAndcontent[0]); // record the # of string 
		s = s.substring(sizeAndcontent[0].length() + 1); // count mybe 12 or 100 
		String[] eachSize = s.split("%");
		int[] size = new int[count];
		int total = 0;
		for(int i = 0; i < count;i++){
			size[i] = Integer.parseInt(eachSize[i]);
			total += size[i]; 
		}
		s = s.substring(s.length() - total); 
		String[] result = new String[count]; 
		for(int i = 0; i < count; i++){
			result[i] = s.substring(0, size[i]);
			s = s.substring(size[i]); 
		}
			
		return result; 
	}

}
