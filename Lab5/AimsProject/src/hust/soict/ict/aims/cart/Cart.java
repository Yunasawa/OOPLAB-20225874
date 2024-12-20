package hust.soict.ict.aims.cart;

import hust.soict.ict.aims.media.Media;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.util.Collections;
import java.util.Comparator;

import javax.naming.LimitExceededException;

public class Cart 
{
	public final int MAX_NUMBERS_ORDERED = 20;
	
    private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();

    public Cart() {}
    
    public ObservableList<Media> getItemsOrdered() { return itemsOrdered; }

    public void addMedia(Media media) throws LimitExceededException
    {
    	if (itemsOrdered.size() < MAX_NUMBERS_ORDERED)
    	{
    		itemsOrdered.add(media);
        	System.out.printf("The media has been added: " + media.getTitle() + "\n");
    	}
    	else 
    	{
    		throw new LimitExceededException("ERROR: The number of media has reached its limit.");
    	}
	}

    public void addMedia(Media... mediaItems) throws LimitExceededException
    {
        for (Media media : mediaItems) 
            addMedia(media);
    }

    public void removeMedia(Media media) 
    {
        if (itemsOrdered.contains(media)) 
        {
            itemsOrdered.remove(media);
            System.out.printf("The media has been removed: " + media.getTitle() + "\n");
        } 
        else 
        {
            System.out.println("The media " + media.getTitle() + " is not in the cart.");
        }
    }

    public void removeMedia(String title) 
    {
        boolean mediaRemoved = false;
        for (int i = 0; i < itemsOrdered.size(); i++) 
        {
            Media media = itemsOrdered.get(i);
            if (media.getTitle().equalsIgnoreCase(title)) 
            {
                itemsOrdered.remove(i);
                mediaRemoved = true;
                System.out.println("Removed media with title: " + title);
                break;
            }
        }
        if (!mediaRemoved) 
        {
            System.out.println("No media found with title: " + title);
        }
    }

    public void sortByTitle() 
    {
        Collections.sort(itemsOrdered, new Comparator<Media>() 
        {
            @Override
            public int compare(Media media1, Media media2) 
            {
                return media1.getTitle().compareToIgnoreCase(media2.getTitle());
            }
        });
        System.out.println("Cart sorted by title.");
    }

    public void sortByCost() 
    {
        Collections.sort(itemsOrdered, new Comparator<Media>() 
        {
            @Override
            public int compare(Media media1, Media media2) 
            {
                return Float.compare(media2.getCost(), media1.getCost());
            }
        });
        System.out.println("Cart sorted by cost (descending).");
    }

    public void clearCart() 
    {
        itemsOrdered.clear();
        System.out.println("Cart has been cleared.");
    }

    public int getQtyOrdered(Media media) 
    {
        int quantity = 0;
        for (Media m : itemsOrdered) 
        {
            if (m.equals(media)) 
            {
                quantity++;
            }
        }
        return quantity;
    }

    public Media searchById(int id) 
    {
        for (Media media : itemsOrdered) 
        {
            if (media.getId() == id) return media;
        }
        System.out.println("No media found with ID: " + id);
        return null;
    }

    public void searchByTitle(String title) 
    {
        boolean found = false;
        for (Media media : itemsOrdered) 
        {
            if (media.isMatch(title)) 
            {
                System.out.println(media.toString());
                found = true;
            }
        }
        if (!found) 
        {
            System.out.println("No media found with title: " + title);
        }
    }

    public float totalCost() 
    {
        float totalCost = 0;
        for (Media media : itemsOrdered) 
        {
            totalCost += media.getCost();
        }
        return totalCost;
    }

    public void print() 
    {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        float totalCost = 0;

        for (int i = 0; i < itemsOrdered.size(); i++) 
        {
            System.out.println((i + 1) + ". " + itemsOrdered.get(i).toString());
            totalCost += itemsOrdered.get(i).getCost();
        }

        System.out.println(String.format("Total cost: %.2f", totalCost));
        System.out.println("***************************************************");
    }
}
