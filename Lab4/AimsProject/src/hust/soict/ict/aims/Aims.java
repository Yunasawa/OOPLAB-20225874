package hust.soict.ict.aims;

import hust.soict.ict.aims.disc.DigitalVideoDisc;
import hust.soict.ict.aims.store.Store;
import hust.soict.ict.aims.media.*;

public class Aims 
{
	public static void main(String[] args) 
    {
		DigitalVideoDisc dvd1 = new DigitalVideoDisc(0, "The Matrix", "Sci-Fi", "", 0, 19.99f);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc(0, "The Matrix", "Sci-Fi", "", 0, 19.99f);

        System.out.println("Are the DVDs equal? " + dvd1.equals(dvd2));

        Track track1 = new Track("Song A", 3);
        Track track2 = new Track("Song A", 3);

        System.out.println("Are the tracks equal? " + track1.equals(track2));

        Track track3 = new Track("Song A", 4);

        System.out.println("Are track1 and track3 equal? " + track1.equals(track3));
    }
}
