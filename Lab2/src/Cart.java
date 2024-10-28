
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
	
	public float totalCost()
	{
		float totalCost = 0;
		for (byte i = 0; i < MAX_NUMBERS_ORDERED; i++)
		{
			if (itemOrdered[i] != null) totalCost += itemOrdered[i].getCost();
		}
		return totalCost;
	}
}
