package hust.soict.ict.lab01;
import javax.swing.JOptionPane;

public class ChoosingOption 
{
	public static void main(String[] args)
	{
		String[] options = {"Yes", "No"};
        int option = JOptionPane.showOptionDialog(null, 
                "Do you want to change to first class ticket?", 
                "Choose an option", 
                JOptionPane.YES_NO_OPTION, 
                JOptionPane.QUESTION_MESSAGE, 
                null, 
                options, 
                options[0]);

        JOptionPane.showMessageDialog(null, "You've chosen: " 
                + (option == JOptionPane.YES_OPTION ? "Yes" : "No"));

        System.exit(0);
	}
}
