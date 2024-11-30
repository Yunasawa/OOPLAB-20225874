package hust.soict.ict.aims;

import java.util.ArrayList;
import java.util.Collections;
import hust.soict.ict.aims.disc.DigitalVideoDisc;
import hust.soict.ict.aims.media.*;

public class Aims 
{
	public static void main(String[] args) 
    {
        Media dvd = new DigitalVideoDisc(0, "The Matrix", "Sci-Fi", "", 0, 19.99f);
        Media cd = new CompactDisc(1, "Best of 2024", "Pop", "", 15.99f);
        Media book = new Book(2, "Effective Java", "Programming", 35.50f);
        
        ArrayList<Media> mediaList = new ArrayList<>();
        mediaList.add(dvd);
        mediaList.add(cd);
        mediaList.add(book);

        System.out.println("Sort by title then cost:");
        Collections.sort(mediaList, Media.COMPARE_BY_TITLE_COST);
        for (Media media : mediaList) 
        {
            System.out.println(media.toString());
        }

        System.out.println("\nSort by cost then title:");
        Collections.sort(mediaList, Media.COMPARE_BY_COST_TITLE);
        for (Media media : mediaList) 
        {
            System.out.println(media.toString());
        }
    }
}
