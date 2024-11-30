package hust.soict.ict.aims.media;

public class Track implements Playable
{
    private String _title;
    private int _length;

    public Track(String title, int length) 
    {
        this._title = title;
        this._length = length;
    }

    public String getTitle() { return _title; }
    public void setTitle(String title) { this._title = title; }

    public int getLength() { return _length; }
    public void setLength(int length) { this._length = length; }

    @Override
    public void play() 
    {
        System.out.println("Playing Track: " + _title);
        System.out.println("Track length: " + _length + " seconds");
    }
}
