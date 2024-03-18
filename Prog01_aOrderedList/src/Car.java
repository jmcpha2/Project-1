/**
* <Car class>
*
* CSC 1351 Programming Project No 1
* Section 2
*
* @author <Julianna Mcphail>
* @since <March 17 2024>
*
*/
public class Car implements Comparable<Car>{

	private String make;
	private int year;
	private int price;
	
	public Car(String Make, int Year, int Price) {
		make = Make;
		year = Year;
		price = Price;
	}
	public String getMake() {
		return this.make;
	}
	public int getYear() {
		return this.year;
	}
	public int getPrice() {
		return this.price;
	}
	public int compareTo(Car other) {
		if(make.compareTo(other.make) != 0) {
			return make.compareTo(other.make);
		}
		else {
			return Integer.compare(year, other.year);
		}
	 }
	
	public String toString() {
		return "Make: " + make + ", Year: " + year + ", Price: " + price +";";
	}
	
}
