/**
 * 
 */
package com.assignment.engine.service;

import java.util.List;
import java.util.Map;

import com.assignment.engine.Product;
import com.assignment.engine.Promotion;

/**
 * @author Admin
 *
 */
public interface PromotionImplementor {
	
	abstract int applyPromotion(char id , int qty,Map<Character, Integer> purchases, List<Promotion> prom, List<Product> prods);


}
