/**
 * Classe permettant de paginer les listes
 * @author Jonathan, Philippe, Marcel
 * @version 1.0
 */

package springapp.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PagesTransformer {
	/**
	 * Nombre maximum par page
	 */
	final static int BY_PAGE = 10;

	/**
	 * Fonction permettant de paginer les listes
	 * @param currentPage
	 * @param allElements
	 * @return Map<String, Object>
	 * @throws Exception
	 */
	public static Map<String, Object> listToPage(int currentPage,
			List<Object> allElements) throws Exception {
		
		Map<String, Object> model = new HashMap<String, Object>();
		
		if(allElements.size() == 0) {
			model.put("firstPage", 1);
	    	model.put("currentPage", 1);
	    	model.put("lastPage", 1);
	    	model.put("veryLastPage", 1);
			return model;
		}
		
		--currentPage;
		
		if(BY_PAGE*currentPage >= allElements.size())
			throw new Exception();
		
		int firstElement = BY_PAGE * currentPage;
    	int lastElement = currentPage * BY_PAGE + BY_PAGE > allElements.size() ? 
    					allElements.size() : currentPage * BY_PAGE + BY_PAGE -1;
    	
    	int firstPage = currentPage-1 <= 0 ? 1 : currentPage-1;
    	
    	int veryLastPage = (allElements.size()-1)/10+1;
    	
    	int lastPage = firstPage+4 < veryLastPage ? firstPage+4 : veryLastPage;
    	
    	if(lastPage > 4 && lastPage - 4 < firstPage) firstPage =  lastPage-4;
    	
    	model.put("elements", allElements.subList(firstElement, lastElement));
    	model.put("firstPage", firstPage);
    	model.put("currentPage", ++currentPage);
    	model.put("lastPage", lastPage);
    	model.put("veryLastPage", veryLastPage);
    	
    	return model;
	}	
}
