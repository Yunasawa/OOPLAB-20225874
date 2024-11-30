package hust.soict.ict.aims.media;

public class Track 
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
}
