package hust.soict.ict.aims.media;

import java.util.ArrayList;

public class Book 
{
    private int id;
    private String title;
    private String category;
    private float cost;
    private ArrayList<String> authors;
	
    public Book(int id, String title, String category, float cost) 
    {
        this.id = id;
        this.title = title;
        this.category = category;
        this.cost = cost;
        this.authors = new ArrayList<>();
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
    public float getCost() { return cost; }
    public void setCost(float cost) { this.cost = cost; }
    public ArrayList<String> getAuthors() { return authors; }

    public void addAuthor(String authorName) 
    {
        if (!authors.contains(authorName)) authors.add(authorName);
        else System.out.println("Author already exists in the list.");
    }
    
    public void removeAuthor(String authorName) 
    {
        if (authors.contains(authorName)) authors.remove(authorName);
        else System.out.println("Author not found in the list.");
    }
}
