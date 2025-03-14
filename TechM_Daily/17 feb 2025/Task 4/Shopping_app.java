package Task4;

public class Shopping_app {
		
	double price;
	String item;
	int id;
	int discount;
	
	public double getPrice() {
		return price;
	}
	public String getItem() {
		return item;
	}
	public int getId() {
		return id;
	}
	public int getDiscount() {
		return discount;
	}
	public void setPrice(double price) {
		 this.price=price;
	}
	public void setItem(String item) {
		this.item=item;
	}
	public void setid(int id) {
		this.id=id;
	}
	public void setdiscount(int discount) {
		this.discount=discount;
	}
	 
	public void printl() {
		System.out.print(price+" "+ item +" "+ id+" "+discount);
		
	}
	
	

	
}
