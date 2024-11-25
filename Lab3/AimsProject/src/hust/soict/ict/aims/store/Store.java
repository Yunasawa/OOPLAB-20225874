package hust.soict.ict.aims.store;
import hust.soict.ict.aims.disc.DigitalVideoDisc;

public class Store 
{
	public static final int MAX_AMOUNT = 100;
	private DigitalVideoDisc[] _itemsInStore = new DigitalVideoDisc[MAX_AMOUNT];
	private int _dvdCount = 0;

    public void addDVD(DigitalVideoDisc dvd) 
    {
        if (_dvdCount < _itemsInStore.length) 
        {
        	_itemsInStore[_dvdCount] = dvd;
            _dvdCount++;
            System.out.println("Added: " + dvd);
        } 
        else System.out.println("Store is full, cannot add DVD.");
    }
    
    public void removeDVD(int dvdId) 
    {
        boolean dvdRemoved = false;

        for (int i = 0; i < _dvdCount; i++) 
        {
            if (_itemsInStore[i].getId() == dvdId) 
            {
                for (int j = i; j < _dvdCount - 1; j++) 
                {
                	_itemsInStore[j] = _itemsInStore[j + 1];
                }
                _itemsInStore[_dvdCount - 1] = null; 
                _dvdCount--;
                dvdRemoved = true;
                System.out.println("Removed DVD with ID: " + dvdId);
                break;
            }
        }

        if (!dvdRemoved) System.out.println("DVD with ID " + dvdId + " not found.");
    }
}
