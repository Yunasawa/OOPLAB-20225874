package hust.soict.ict.aims.store;

import hust.soict.ict.aims.media.Media;
import java.util.ArrayList;

public class Store 
{
    public static final int MAX_AMOUNT = 100;
    private ArrayList<Media> _itemsInStore = new ArrayList<Media>();
    private int _mediaCount = 0;

    public ArrayList<Media> getItemsInStore() { return _itemsInStore; }
    
    public void addMedia(Media media) 
    {
        if (_mediaCount < MAX_AMOUNT) 
        {
            _itemsInStore.add(media);
            _mediaCount++;
            System.out.println("Added: " + media);
        } 
        else 
        {
            System.out.println("Store is full, cannot add media.");
        }
    }

    public void removeMedia(int mediaId) 
    {
        boolean mediaRemoved = false;
        for (int i = 0; i < _mediaCount; i++) 
        {
            if (_itemsInStore.get(i).getId() == mediaId) 
            {
                _itemsInStore.remove(i);
                _mediaCount--;
                mediaRemoved = true;
                System.out.println("Removed media with ID: " + mediaId);
                break;
            }
        }
        if (!mediaRemoved) 
        {
            System.out.println("Media with ID " + mediaId + " not found.");
        }
    }
    public void removeMedia(String title) 
    {
        boolean mediaRemoved = false;
        for (int i = 0; i < _mediaCount; i++) 
        {
            if (_itemsInStore.get(i).getTitle() == title) 
            {
                _itemsInStore.remove(i);
                _mediaCount--;
                mediaRemoved = true;
                System.out.println("Removed media with ID: " + title);
                break;
            }
        }
        if (!mediaRemoved) 
        {
            System.out.println("Media with ID " + title + " not found.");
        }
    }

    public Media searchById(int mediaId) 
    {
        for (Media media : _itemsInStore) 
        {
            if (media.getId() == mediaId) 
            {
                return media;
            }
        }
        System.out.println("Media with ID " + mediaId + " not found.");
        return null;
    }

    public Media searchByTitle(String title) 
    {
        for (Media media : _itemsInStore) 
        {
            if (media.getTitle().equalsIgnoreCase(title)) 
            {
                return media;
            }
        }
        System.out.println("Media with title '" + title + "' not found.");
        return null;
    }

    public void printItemsInStore() 
    {
        System.out.println("************* ITEMS IN STORE *************");
        for (int i = 0; i < _mediaCount; i++) 
        {
            System.out.println((i + 1) + ". " + _itemsInStore.get(i).toString());
        }
        System.out.println("********************************************");
    }
}
