package hust.soict.ict.aims.disc;

import hust.soict.ict.aims.media.Media;

public class DigitalVideoDisc extends Media
{
    private String _director;
    private int _length;
	
	private static int _nbDigitalVideoDiscs = 0;
	
    public DigitalVideoDisc(int id, String title, String category, String director, int length, float cost) 
    {
        super(id, title, category, cost); // Call Media constructor with ID
        this._director = director;
        this._length = length;
    }
	
    public String getDirector() { return _director; }
    public void setDirector(String director) { this._director = director; }

    public int getLength() { return _length; }
    public void setLength(int length) { this._length = length; }
	
    public boolean isMatch(String title) { return this.getTitle().equalsIgnoreCase(title); }
	
	@Override
	public String toString()
	{
		return String.format("DVD - %s - %s - %s - %d: %.2f$", getTitle(), getCategory(), _director, _length, getCost());
	}
}
