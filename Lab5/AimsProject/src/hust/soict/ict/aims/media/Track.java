package hust.soict.ict.aims.media;

import java.util.Objects;

import hust.soict.ict.aims.exception.PlayerException;

public class Track implements Playable
{
    private String _title;
    private int length;

    public Track(String title, int length) 
    {
        this._title = title;
        this.length = length;
    }

    public String getTitle() { return _title; }
    public void setTitle(String title) { this._title = title; }

    public int getLength() { return length; }
    public void setLength(int length) { this.length = length; }

    @Override
    public void play() throws PlayerException
    {
    	if (this.getLength() > 0)
    	{
    		System.out.println("Playing Track: " + _title);
        	System.out.println("Track length: " + length + " seconds");
    	}
    	else 
		{
			throw new PlayerException("ERROR: DVD length is non-positive!");
		}
    }
    
    @Override
    public boolean equals(Object obj) 
    {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Track track = (Track) obj;
        return length == track.length && Objects.equals(getTitle(), track.getTitle()); // Compare title and length
    }

    @Override
    public int hashCode() 
    {
        return Objects.hash(getTitle(), length);
    }
}
