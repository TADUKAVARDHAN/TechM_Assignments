package Task3;

public class Inventory_class {
		
	public int goodsQuality;
	public int goodsQuantity;
	public String goodsType;
 
	
	public Inventory_class(int goodsQuality,int goodsQuantity, String goodsType){
		this.goodsQuality=goodsQuality;
		this.goodsQuantity=goodsQuantity;
		this.goodsType=goodsType;
	}
	
	public void display() {
		System.out.println("The Type of the good is "+goodsType+ "  quality is "+ goodsQuality+" tons the quantity "+goodsType );
	}
	
	 

}
