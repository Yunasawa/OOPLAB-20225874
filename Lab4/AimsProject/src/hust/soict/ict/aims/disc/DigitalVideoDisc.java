package hust.soict.ict.aims.disc;

import hust.soict.ict.aims.media.*;

public class DigitalVideoDisc extends Disc implements Playable
{
    public DigitalVideoDisc(int id, String title, String category, String director, int length, float cost) 
    {
        super(id, title, category, director, length, cost); // Call Media constructor with ID
    }
    
    @Override
    public void play() 
    {
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength());
    }
}
