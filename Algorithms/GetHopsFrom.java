// Problem 3:

// Write a function get_hops_from(page1, page2) that will determine the number of hyperlinks that you would 
// need to click on to get from some page1 on the web to some other page2 on the web.

// For example, if each page below links to the pages that are indented below it, 
// e.g. page 1 links to pages 2 and 5, and page 2 links to pages 3 and 4, and page 5 links to pages 3 and 7, 
// then the get_hops_from(page1, page7) should return 2 (2 hops), since you have to hop once from page 1 to 5 
// and once more from page 5 to page 7.


// page1 :       distance == 0
//     page2 :   distance == 1
//       page3 : distance == 2
//       page4 : distance == 2
//     page5 :   distance == 2
//       page3 : distance == 2
//       page7 : distance == 2

// Assume that an API is available to:
// * get_links(a_page) will return an array/list of all pages that a_page links to


//Breadth first search

class GetHopsFrom{
	class Page{
		//Implementation
	}

	public static get_hops_from(Page p1, Page p2){
		Queue<Page> q = new LinkedList<>();
		q.add(p1);
		int count = 0;

		while(!q.isEmpty()){
			int size = q.size();
			count++;
			for(int i=0;i<q.size();i++){
				Page p = q.poll();
				ArrayList<Page> arr = get_linkes(p);
				if(arr.contains(p2)) return count;
				q.addAll(arr);
			}
		}
		return 0;
	}	
}