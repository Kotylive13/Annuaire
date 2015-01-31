package springapp.util;

import java.util.ArrayList;
import java.util.List;

public class Pages {
	final static int BY_PAGE = 10;
	
	private List<Object> subList;
	
	private int firstPage;
	private int lastPage;

	public Pages(int currentPage, List<Object> collection) 
			throws Exception {		
		
		--currentPage;
		
		List<Object> allElement = new ArrayList<Object>(collection);
		
		if(BY_PAGE*currentPage >= allElement.size())
			throw new Exception();
		
		int firstElement = BY_PAGE * currentPage;
    	int lastElement = currentPage * BY_PAGE + BY_PAGE > allElement.size() ? 
    					allElement.size() : currentPage * BY_PAGE + BY_PAGE -1;
    	
    	firstPage = currentPage-1 <= 0 ? 1 : currentPage-1;
    	lastPage = firstPage+4 < (allElement.size()-1)/10+1 ? 
    			firstPage+4 : (allElement.size()-1)/10+1;
    	
    	if(lastPage > 4 && lastPage - 4 < firstPage) firstPage =  lastPage-4;
    	
    	subList = allElement.subList(firstElement, lastElement);
	}

	public List<Object> getSubList() {
		return subList;
	}

	public int getFirstPage() {
		return firstPage;
	}

	public int getLastPage() {
		return lastPage;
	}	
}
