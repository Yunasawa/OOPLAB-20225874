package hust.soict.ict.test.cart;
import hust.soict.ict.aims.cart.Cart;
import hust.soict.ict.aims.disc.DigitalVideoDisc;

public class CartTest 
{
	public static void main(String[] args) 
	{
		Cart cart = new Cart();
		
		DigitalVideoDisc dvd1 = new DigitalVideoDisc(0, "The Lion King", "Animation", "Roger Allers", 87, 19.95f);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc(1, "Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc(2, "Aladin", "Animation", "", 0, 18.99f);
		
		//cart.addDigitalVideoDisc(dvd1, dvd2, dvd3);
		
		cart.print();
	}

}
