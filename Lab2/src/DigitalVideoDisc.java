
public class DigitalVideoDisc 
{
	private String _title;
	private String _category;
	private String _director;
	private int _length;
	private float _cost;
	
	public DigitalVideoDisc(String _title, String _category, String _director, int _length, float _cost) 
	{
        this(_title, _category, _director, _cost);
        this._length = _length;
    }
    public DigitalVideoDisc(String _title, String _category, String _director, float _cost) 
    {
        this(_title, _category, _cost);
        this._director = _director;
    }
    public DigitalVideoDisc(String _title, String _category, float _cost) 
    {
        this(_title);
        this._category = _category;
        this._cost = _cost;
    }
    public DigitalVideoDisc(String _title) 
    {
        this._title = _title;
    }
	
	public String getTitle() { return _title; }
	public void setTitle(String _title) { this._title = _title; }

	public String getCategory() { return _category; }
	public void setCategory(String _category) { this._category = _category; }

	public String getDirector() { return _director; }
	public void setDirector(String _director) { this._director = _director; }

	public float getCost() { return _cost; }
	public void setCost(float _cost) { this._cost = _cost; }

	public int getLength() { return _length; }
	public void setLength(int _length) { this._length = _length; }

	
}
