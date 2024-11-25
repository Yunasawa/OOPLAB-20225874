package hust.soict.dsai.aims.cart;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class Cart 
{
	public static final int MAX_NUMBERS_ORDERED = 20;
	private DigitalVideoDisc itemOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED]; 
	private int qtyOrdered = 0;
	
	public void addDigitalVideoDisc(DigitalVideoDisc disc)
	{
		if (qtyOrdered == MAX_NUMBERS_ORDERED) 
		{
			System.out.printf("The cart is almost full\n");
			return;
		}
		itemOrdered[qtyOrdered] = disc;
		qtyOrdered++;
		
		System.out.printf("The disc has been added: " + disc.getTitle() + "\n");
	}
	//public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList)
	//{
	//	for (int i = 0; i < dvdList.length; i++) addDigitalVideoDisc(dvdList[i]);
	//}
	public void addDigitalVideoDisc(DigitalVideoDisc... dvds)
	{
	    for (DigitalVideoDisc dvd : dvds) addDigitalVideoDisc(dvd);
	}
	public void addDigitalVideoDisc(DigitalVideoDisc dvd1,DigitalVideoDisc dvd2)
	{
		addDigitalVideoDisc(dvd1);
		addDigitalVideoDisc(dvd2);
	}
	
	public void removeDigitalVideoDisc(DigitalVideoDisc disc)
	{
		for (byte i = 0; i < MAX_NUMBERS_ORDERED; i++)
		{
			if (itemOrdered[i] == disc) 
			{
				System.out.printf("The disc has been removed: " + disc.getTitle() + "\n");
				itemOrdered[i] = null;
			}
		}
	}
	
	public DigitalVideoDisc searchById(int id)
	{
		for (DigitalVideoDisc dvd : itemOrdered) 
		{
            if (dvd.getId() == id) return dvd;
        }
		
        System.out.println("No DVD found with ID: " + id);
        return null;
	}
	public void searchByTitle(String title) 
	{
        boolean found = false;
        for (DigitalVideoDisc dvd : itemOrdered) 
        {
            if (dvd.isMatch(title)) 
            {
                System.out.println(dvd.toString());
                found = true;
            }
        }
        if (!found)  System.out.println("No DVD found with title: " + title);
    }
	
	public float totalCost()
	{
		float totalCost = 0;
		for (byte i = 0; i < MAX_NUMBERS_ORDERED; i++)
		{
			if (itemOrdered[i] != null) totalCost += itemOrdered[i].getCost();
		}
		return totalCost;
	}
	public void print()
	{
		System.out.println("***********************CART***********************");
		System.out.println("Ordered Items:");
		double totalCost = 0;
		
		for (int i = 0; i < MAX_NUMBERS_ORDERED; i++)
		{
			if (itemOrdered[i] == null) continue;
            System.out.println((i + 1) + ". " + itemOrdered[i].toString());
            totalCost += itemOrdered[i].getCost();
		}
		
		System.out.println(String.format("Total cost: %.2f", totalCost));
		System.out.println("***************************************************");
	}
}
