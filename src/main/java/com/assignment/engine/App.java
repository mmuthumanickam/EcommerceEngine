package com.assignment.engine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.assignment.engine.service.PromotionImplementor;
import com.assignment.engine.service.impl.ProductAImplementor;
import com.assignment.engine.service.impl.ProductBImplementor;
import com.assignment.engine.service.impl.ProductCImplementor;
import com.assignment.engine.service.impl.ProductDImplementor;

/**
 * Hello world!
 *
 */
public class App 
{
	
	static List<Product> lprod = null;
	static  List<Promotion> lpromo = null ;
	
	
	{
		Product p1 = new Product('A',50);
        Product p2 = new Product('B',30);
        Product p3 = new Product('C',20);
        Product p4 = new Product('D',15);
        
         lprod = new ArrayList<Product>() ;	
        lprod.add(p1);
        lprod.add(p2);
        lprod.add(p3);
        lprod.add(p4);
        Promotion promo1 = new Promotion('A',3,Character.MIN_VALUE,130);
       // promo1.setPromoapply(true);
        Promotion promo2 = new Promotion('B',2,Character.MIN_VALUE,45);
      //  promo2.setPromoapply(true);
        Promotion promo3 = new Promotion('C',1,'D',30);
        promo3.setPromoapply(true);
        Promotion promo4 = new Promotion('D',1,'C',30);
        lpromo = new ArrayList<Promotion>() ;
        lpromo.add(promo1);
        lpromo.add(promo2);
        lpromo.add(promo3);
        lpromo.add(promo4);
       
        
	}
    public static void main( String[] args )
    {
    	try{
    		
    	
        System.out.println( "Hello World!" );       
        
        App p = new App();
        Map<Character, Integer> purchases = new HashMap<Character, Integer>();
        purchases.put('B', 5);
        purchases.put('D', 1);
        purchases.put('C', 1);
        int price =  p.calculatePrice(purchases,lprod,lpromo);
    //    System.out.println("total price of purchase is "+price);
    	}catch(Exception e)
    	{
    		e.printStackTrace();
    	}
        }
    
    
    protected int calculatePrice(Map<Character, Integer> purchases, List<Product> lp, List<Promotion> lpromo) throws Exception {
		// TODO Auto-generated method stub
    	  int totalPrice = 0;
    	  try
    	  {
    		
    	 PromotionImplementor pi = null;
    	if(null != purchases && null != lp && null != lpromo )
    	{
    		char promocodeproduct = Character.MIN_VALUE;
    		List<Character> prodlist = new ArrayList<Character>();
    		int count  = 0;
    		for(int d = 0 ; d < lp.size() ; d++ )
    		{
    			if(lpromo.get(d).isPromoapply() == true)
    			{
    				count ++;
    				prodlist.add(lp.get(d).getId());
    			}
    		}
    		if(count > 1){
    			throw new Exception("more than one product with promotion applied");
    		}else if (count == 1){
    			promocodeproduct = prodlist.get(0).charValue();    				
    		}
    	//	System.out.println("the value of promocode product is "+promocodeproduct);
    		int price = 0;
    		for (Map.Entry<Character, Integer> entry : purchases.entrySet()) { 
           //     System.out.println("Key = " + entry.getKey() + 
           //                      ", Value = " + entry.getValue()); 
    		switch(entry.getKey()){  
    	    //Case statements  
    	    case 'A': 
    	    	
    	    	if(promocodeproduct == 'A'){
    	    	//	System.out.println("entered A");
    	    		pi = new ProductAImplementor();
    	    	price = pi.applyPromotion('A' , entry.getValue(),purchases, lpromo , lp);
    	    	}
    	        break; 
    	    case 'B': 
    	    
    	    	if(promocodeproduct == 'B'){
    	    	//	System.out.println("entered B"); 
    	    		pi = new ProductBImplementor();
        	    	price = pi.applyPromotion('B' , entry.getValue(),purchases, lpromo , lp);
    	    	}
    	    	  break;   
    	    case 'C': 
    	    //	System.out.println("entered C"); 
    	    	if(promocodeproduct == 'C'){
    	    	//	System.out.println("entered C"); 
    	        pi = new ProductCImplementor();
    	    	price = pi.applyPromotion('C' , entry.getValue(),purchases, lpromo , lp);
    	    	}
    	        break;  
    	    case 'D': 
    	    //	System.out.println("entered D"); 
    	    	if(promocodeproduct == 'D'){
    	    	//	System.out.println("entered D"); 
    	    		pi = new ProductDImplementor();
        	    	price = pi.applyPromotion('D' , entry.getValue(),purchases, lpromo , lp);
    	    	}
    	       	    break;  
    	    //Default case statement  
    	    default:System.out.println("Product not correct");  
    	    }
    		  if(entry.getKey() != promocodeproduct)
    		  {
    			  if(entry.getKey() == 'A')
    			  {
    				  totalPrice += (entry.getValue()*lprod.get(0).getValue());
    			  }

    			  if(entry.getKey() == 'B')
    			  {
    				  totalPrice += (entry.getValue()*lprod.get(1).getValue());
    			  }
    			  

    			  if(entry.getKey() == 'C' && promocodeproduct != 'D')
    			  {
    				  totalPrice += (entry.getValue()*lprod.get(2).getValue());
    			  }

    			  if(entry.getKey() == 'D' && promocodeproduct != 'C')
    			  {
    				  totalPrice += (entry.getValue()*lprod.get(3).getValue());
    			  }
    			  
    			  
    			  
    		  }
    		 
    	 }
    		totalPrice += price;
    		
    	}else
    	{
    		throw new Exception("no purchases or products");
    	}
    	
    	
    	  }catch(Exception e)
    	  {
    		  e.printStackTrace();
    	  }finally{
    	//	  System.out.println("price calculation completed");
    	  }
    	  return totalPrice;
	}




/*	private int applyPromotion(char id , int qty,Map<Character, Integer> purchases, List<Promotion> prom, List<Product> prods){
		
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
						  }	else{
							  Map<Character, Integer> check = checkDependency(prom.get(z),purchases);
							 if(null != check)
							 {
								 for (Map.Entry<Character, Integer> entry : check.entrySet()) { 
									 int b = prods.get(i).getCount() / entry.getValue();
									 int c = prods.get(i).getCount() % entry.getValue();
									 appliedprice += ((b*prom.get(z).getDisctprice())+(c*prods.get(i).getCount()));
								 }
								 
							 }else
							  appliedprice += prods.get(i).getValue();	 
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
	}  */
}
