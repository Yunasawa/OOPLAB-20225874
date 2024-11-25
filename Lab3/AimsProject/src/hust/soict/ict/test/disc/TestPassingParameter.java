package hust.soict.ict.test.disc;
import hust.soict.ict.aims.Wrapper;
import hust.soict.ict.aims.disc.DigitalVideoDisc;

public class TestPassingParameter 
{
    public static void main(String[] args) 
    {
        DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
        DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");
        
        Wrapper<DigitalVideoDisc> wrapper = new Wrapper<>(jungleDVD, cinderellaDVD);
        
        swap(wrapper);
        jungleDVD = wrapper.Wrapper1;
        cinderellaDVD = wrapper.Wrapper2;
        
        System.out.println("jungle dvd title: " + jungleDVD.getTitle());
        System.out.println("cinderella dvd title: " + cinderellaDVD.getTitle() + "\n");

        changeTitle(jungleDVD, cinderellaDVD.getTitle());
        System.out.println("jungle dvd title: " + jungleDVD.getTitle());
    }

    public static void swap(Wrapper<DigitalVideoDisc> wrapper) {wrapper.Swap(); }
    
    public static void changeTitle(DigitalVideoDisc dvd, String title) 
    {
        String oldTitle = dvd.getTitle();
        dvd.setTitle(title);
        dvd = new DigitalVideoDisc(oldTitle);
    }
}