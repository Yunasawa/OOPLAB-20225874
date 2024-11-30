package hust.soict.ict.aims.cart;

import hust.soict.ict.aims.media.Media;
import java.util.ArrayList;

public class Cart 
{
    private ArrayList<Media> itemsOrdered = new ArrayList<Media>();
    
    public Cart() {}

    public void addMedia(Media media) 
    {
        itemsOrdered.add(media);
        System.out.printf("The media has been added: " + media.getTitle() + "\n");
    }

    public void addMedia(Media... mediaItems) 
    {
        for (Media media : mediaItems) addMedia(media);
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
