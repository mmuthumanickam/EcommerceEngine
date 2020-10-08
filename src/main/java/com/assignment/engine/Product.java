/**
 * 
 */
package com.assignment.engine;

/**
 * @author Admin
 *
 */
public class Product {

	/**
	 * 
	 */
	
	public char id;
	/**
	 * @return the promo
	 */
	public boolean isPromo() {
		return promo;
	}

	/**
	 * @param promo the promo to set
	 */
	public void setPromo(boolean promo) {
		this.promo = promo;
	}

	public int count;
	public int value;
	public boolean promo;
	
	/**
	 * @return the id
	 */
	public char getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(char id) {
		this.id = id;
	}

	/**
	 * @return the count
	 */
	public int getCount() {
		return count;
	}

	/**
	 * @param count the count to set
	 */
	public void setCount(int count) {
		this.count = count;
	}

	/**
	 * @return the value
	 */
	public int getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(int value) {
		this.value = value;
	}

	public Product(char x,  int z) {
		// TODO Auto-generated constructor stub
		this.id = x;
		
		this.value = z;
	}
	
	

}
