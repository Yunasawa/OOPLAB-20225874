package hust.soict.ict.aims.disc;

import hust.soict.ict.aims.media.*;

public class DigitalVideoDisc extends Disc
{
    public DigitalVideoDisc(int id, String title, String category, String director, int length, float cost) 
    {
        super(id, title, category, director, length, cost); // Call Media constructor with ID
    }
    
    public boolean isMatch(String title) { return this.getTitle().equalsIgnoreCase(title); }
}
