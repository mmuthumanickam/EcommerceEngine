/**
 * 
 */
package com.assignment.engine;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Admin
 *
 */
public class AppTest {

	/**
	 * @throws java.lang.Exception
	 * 
	 *
	 */
	static List<Product> lprod = null;
	static  List<Promotion> lpromo = null ;
	App p = null;
	Promotion promo1=null,promo2=null ,promo3=null ,promo4 = null;
	Product p1 = null,p2 = null,p3 = null,p4 = null;
	
	 
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		 p1 = new Product('A',50);
         p2 = new Product('B',30);
         p3 = new Product('C',20);
         p4 = new Product('D',15);
        
         lprod = new ArrayList<Product>() ;	
        lprod.add(p1);
        lprod.add(p2);
        lprod.add(p3);
        lprod.add(p4);
         promo1 = new Promotion('A',3,Character.MIN_VALUE,130);
       // promo1.setPromoapply(true);
         promo2 = new Promotion('B',2,Character.MIN_VALUE,45);
      //  promo2.setPromoapply(true);
         promo3 = new Promotion('C',1,'D',30);
      //  promo3.setPromoapply(true);
          promo4 = new Promotion('D',1,'C',30);
        lpromo = new ArrayList<Promotion>() ;
        lpromo.add(promo1);
        lpromo.add(promo2);
        lpromo.add(promo3);
        lpromo.add(promo4);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAPromotion() {
		try
		{
			System.out.println("started testing Apromotion");
			System.out.println();
			System.out.println("( A = 5 , B = 1 , C =1   & promotion applied for A");
		    p = new App();
	        Map<Character, Integer> purchases = new HashMap<Character, Integer>();
	        purchases.put('A', 5);
	        purchases.put('B', 1);
	        purchases.put('C', 1);
	        promo1.setPromoapply(true);
	        int price =  p.calculatePrice(purchases,lprod,lpromo);
	        System.out.println("total price of purchase is "+price);
	    	}catch(Exception e)
	    	{
	    		e.printStackTrace();
	    	}finally {
	    		System.out.println();
	    		System.out.println("completed testing Apromotion");
	    		System.out.println();
	    	}

	}
	
	@Test
	public void testBPromotion() {
		
		try
		{
			System.out.println("started testing B promotion");
			System.out.println();
			System.out.println("( B = 5 , A = 1 , C =1   & promotion applied for B");
		    p = new App();
	        Map<Character, Integer> purchases = new HashMap<Character, Integer>();
	        purchases.put('B', 5);
	        purchases.put('A', 1);
	        purchases.put('C', 1);
	        promo2.setPromoapply(true);
	        int price =  p.calculatePrice(purchases,lprod,lpromo);
	        System.out.println("total price of purchase is "+price);
	    	}catch(Exception e)
	    	{
	    		e.printStackTrace();
	    	}finally {
	    		System.out.println();
	    		System.out.println("completed testing B promotion");
	    		System.out.println();
	    	}

	}
	
	@Test
	public void testCDPromotion() {
		
		try
		{
			System.out.println("started testing C & D promotion");
			System.out.println();
			System.out.println("( B = 5 , D = 1 , C =1 promotion applied for C & D combo");
	       
		    p = new App();
	        Map<Character, Integer> purchases = new HashMap<Character, Integer>();
	        purchases.put('B', 5);
	        purchases.put('D', 1);
	        purchases.put('C', 1);
	        promo3.setPromoapply(true);
	        int price =  p.calculatePrice(purchases,lprod,lpromo);
	        System.out.println("total price of purchase is "+price);
	    	}catch(Exception e)
	    	{
	    		e.printStackTrace();
	    	}finally {
	    		System.out.println();
	    		System.out.println("completed testing C & D  promotion");
	    		System.out.println();
	    	}

	}
	

}
