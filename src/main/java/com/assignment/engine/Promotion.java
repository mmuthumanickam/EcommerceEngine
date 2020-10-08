/**
 * 
 */
package com.assignment.engine;

/**
 * @author Admin
 *
 */
public class Promotion {

	/**
	 * 
	 */
	private  char prodid;
	private  int qty ;
	private  char dependency;
	private boolean promoapply;
	


	/**
	 * @return the prodid
	 */
	public char getProdid() {
		return prodid;
	}


	/**
	 * @param prodid the prodid to set
	 */
	public void setProdid(char prodid) {
		this.prodid = prodid;
	}


	/**
	 * @return the qty
	 */
	public int getQty() {
		return qty;
	}


	/**
	 * @param qty the qty to set
	 */
	public void setQty(int qty) {
		this.qty = qty;
	}


	/**
	 * @return the dependency
	 */
	public char getDependency() {
		return dependency;
	}


	/**
	 * @param dependency the dependency to set
	 */
	public void setDependency(char dependency) {
		this.dependency = dependency;
	}


	/**
	 * @return the disctprice
	 */
	public int getDisctprice() {
		return disctprice;
	}


	/**
	 * @param disctprice the disctprice to set
	 */
	public void setDisctprice(int disctprice) {
		this.disctprice = disctprice;
	}


	private  int disctprice;
	
	
	public Promotion(char id , int qty, char dep ,int price) {
		// TODO Auto-generated constructor stub
		this.prodid = id;
		this.qty = qty;
		this.dependency = dep;
		this.disctprice= price;
	}


	public boolean isPromoapply() {
		return promoapply;
	}


	public void setPromoapply(boolean promoapply) {
		this.promoapply = promoapply;
	}

}
