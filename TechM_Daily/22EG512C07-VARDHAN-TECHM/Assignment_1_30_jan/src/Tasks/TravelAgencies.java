package techm;
import java.util.*;
public class TravelAgencies {
       int regno;
        String agencyname;
        String packagetype;
         int price;
        boolean filght;
        public TravelAgencies(int regno,String agencyname,String packagetype,int price ,boolean flight) {
        	this.regno=regno;
        	this.agencyname=agencyname;
        	this.packagetype=packagetype;
        	this.price=price;
        	this.filght=flight;
        	
        }
		public int getRegno() {
			return regno;
		}
		public void setRegno(int regno) {
			this.regno = regno;
		}
		public String getAgencyname() {
			return agencyname;
		}
		public void setAgencyname(String agencyname) {
			this.agencyname = agencyname;
		}
		public String getPackagetype() {
			return packagetype;
		}
		public void setPackagetype(String packagetype) {
			this.packagetype = packagetype;
		}
		public int getPrice() {
			return price;
		}
		public void setPrice(int price) {
			this.price = price;
		}
		public boolean isFilght() {
			return filght;
		}
		public void setFilght(boolean filght) {
			this.filght = filght;
		}
        
}