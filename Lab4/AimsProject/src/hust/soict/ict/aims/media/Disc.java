package hust.soict.ict.aims.media;

public class Disc extends Media 
{
    private int _length;
    private String _director;

    public Disc(int id, String title, String category, String director, int length, float cost) 
    {
        super(id, title, category, cost);
        this._director = director;
        this._length = length;
    }

    public String getDirector() { return _director; }
    public void setDirector(String director) { this._director = director; }

    public int getLength() { return _length; }
    public void setLength(int length) { this._length = length; }

    @Override
    public String toString() {
        return String.format("%s - %s - %s - %d: %.2f$", getTitle(), getCategory(), _director, _length, getCost());
    }
}
