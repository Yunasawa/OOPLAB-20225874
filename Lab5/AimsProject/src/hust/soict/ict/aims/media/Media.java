package hust.soict.ict.aims.media;

import java.util.Comparator;
import java.util.Objects;

import hust.soict.ict.aims.exception.PlayerException;

public abstract class Media
{
    private int id;
    private String title;
    private String category;
    private float cost;

    public Media(int id, String title, String category, float cost) 
    {
        this.id = id;
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
    public float getCost() { return cost; }
    public void setCost(float cost) { this.cost = cost; }

    public boolean isMatch(String title) { return this.getTitle().equalsIgnoreCase(title); }

    @Override
    public boolean equals(Object obj) 
    {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Media media = (Media) obj;
        return Objects.equals(title, media.title);
    }

    @Override
    public int hashCode() 
    {
        return Objects.hash(title);
    }

    // Abstract play method that must be implemented by subclasses
    public abstract void play() throws PlayerException;

    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaCompactorByTitleCost();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaCompactorByCostTitle();
}