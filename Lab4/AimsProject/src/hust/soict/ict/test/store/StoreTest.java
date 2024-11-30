package hust.soict.ict.test.store;
import hust.soict.ict.aims.disc.DigitalVideoDisc;
import hust.soict.ict.aims.store.Store;

public class StoreTest 
{
	public static void main(String[] args) 
	{
		Store store = new Store();
		
		DigitalVideoDisc dvd1 = new DigitalVideoDisc(0, "The Lion King", "Animation", "Roger Allers", 87, 19.95f);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc(1, "Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc(2, "Aladin", "Animation", "", 0, 18.99f);
	
		store.addDVD(dvd1);
		store.addDVD(dvd2);
		store.addDVD(dvd3);
	}

}