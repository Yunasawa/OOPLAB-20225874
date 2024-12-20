package hust.soict.ict.aims.media;

import java.util.ArrayList;
import hust.soict.ict.aims.exception.PlayerException;

public class CompactDisc extends Disc implements Playable 
{
    private String _artist;
    private ArrayList<Track> _tracks;

    public CompactDisc(int id, String title, String category, String artist, float cost) 
    {
        super(id, title, category, "", 0, cost);
        this._artist = artist;
        this._tracks = new ArrayList<>();
    }
    public CompactDisc(String title, float cost) 
    {
        super(0, title, "Music", "Unknown Artist", 60, cost);
    }
    public CompactDisc(String title) 
    {
        super(0, title, "Music", "Unknown Artist", 60, 9.99f);
    }

    public String getArtist() { return _artist; }

    public void addTrack(Track track) 
    {
        if (_tracks.contains(track)) 
        {
            System.out.println("Track " + track.getTitle() + " is already in the list.");
        } 
        else 
        {
            _tracks.add(track);
            System.out.println("Track " + track.getTitle() + " added successfully.");
        }
    }

    public void removeTrack(Track track) 
    {
        if (_tracks.contains(track)) 
        {
            _tracks.remove(track);
            System.out.println("Track " + track.getTitle() + " removed successfully.");
        } 
        else 
        {
            System.out.println("Track " + track.getTitle() + " does not exist in the list.");
        }
    }

    public int getTotalLength() 
    {
        int totalLength = 0;
        for (Track track : _tracks) 
        {
            totalLength += track.getLength();
        }
        return totalLength;
    }
    
    @Override
    public void play() throws PlayerException 
    {
        System.out.println("Playing CD: " + getTitle());
        System.out.println("Artist: " + _artist);
        System.out.println("CD length: " + getTotalLength() / 60 + " minutes");
        
        if(this.getLength() > 0) 
        {
            java.util.Iterator iter = _tracks.iterator();
            Track nexttrack;
            while(iter.hasNext()) 
            {
                nexttrack = (Track) iter.next();
                try 
                {
                    nexttrack.play();
                } 
                catch (PlayerException e) 
                {
                    throw e;
                }
            }
        } 
        else 
        {
            throw new PlayerException("ERROR: CD length  non-positivel");
        }
    }
}
