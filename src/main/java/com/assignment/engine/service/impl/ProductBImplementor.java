/**
 * 
 */
package com.assignment.engine.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.assignment.engine.Product;
import com.assignment.engine.Promotion;
import com.assignment.engine.service.PromotionImplementor;

/**
 * @author Admin
 *
 */
public class ProductBImplementor implements PromotionImplementor {

	/**
	 * 
	 */
	public ProductBImplementor() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see com.assignment.engine.PromotionImplementor#applyPromotion(char, int, java.util.Map, java.util.List, java.util.List)
	 */
	public int applyPromotion(char id, int qty, Map<Character, Integer> purchases, List<Promotion> prom,
			List<Product> prods) {
		// TODO Auto-generated method stub
		 int appliedprice = 0 ;
			  if(null != prom && null != prods)	
			  {
				for(int i = 0 ; i < prods.size(); i++)
				{
					
					if(id == prods.get(i).getId())
					{
						for (int z = 0 ; z < prom.size() ; z++)
						{
							if(id == prom.get(z).getProdid())
							{
								  if(prom.get(z).getDependency() == Character.MIN_VALUE)
								  {
				    	    		int y = qty%prom.get(z).getQty();
				    	    		int m = qty/prom.get(z).getQty(); 
				    	    		appliedprice += ((m*prom.get(z).getDisctprice())+(y*prods.get(i).getValue()));
								  }	
						    }			
						
					     }
									
				     }		
		    	
		          }
			    }
				return appliedprice;
	}
	
	private Map<Character, Integer> checkDependency(Promotion promotion, Map<Character, Integer> purchases) {
		// TODO Auto-generated method stub
		Map<Character, Integer> mapped = new HashMap<Character, Integer>();
		for (Map.Entry<Character, Integer> entry : purchases.entrySet()) { 
		  if(promotion.getDependency() == entry.getKey())
		    mapped.put(entry.getKey(), entry.getValue());
		}
		return mapped;
	}

}
