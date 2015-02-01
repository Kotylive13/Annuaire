package springapp.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PagesTransformer {
	final static int BY_PAGE = 10;

	public static Map<String, Object> listToPage(int currentPage,
			List<Object> allElements) throws Exception {
		
		Map<String, Object> model = new HashMap<String, Object>();
		
		if(allElements.size() == 0) {
			model.put("firstPage", 1);
	    	model.put("lastPage", 1);
	    	model.put("currentPage", 1);
			return model;
		}
		
		--currentPage;
		
		if(BY_PAGE*currentPage >= allElements.size())
			throw new Exception();
		
		int firstElement = BY_PAGE * currentPage;
    	int lastElement = currentPage * BY_PAGE + BY_PAGE > allElements.size() ? 
    					allElements.size() : currentPage * BY_PAGE + BY_PAGE -1;
    	
    	int firstPage = currentPage-1 <= 0 ? 1 : currentPage-1;
    	int lastPage = firstPage+4 < (allElements.size()-1)/10+1 ? 
    			firstPage+4 : (allElements.size()-1)/10+1;
    	
    	if(lastPage > 4 && lastPage - 4 < firstPage) firstPage =  lastPage-4;
    	
    	model.put("elements", allElements.subList(firstElement, lastElement));
    	model.put("firstPage", firstPage);
    	model.put("lastPage", lastPage);
    	model.put("currentPage", ++currentPage);
    	
    	return model;
	}	
}
