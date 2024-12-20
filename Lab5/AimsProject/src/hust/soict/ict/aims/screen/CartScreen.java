package hust.soict.ict.aims.screen;

import java.io.IOException;
import javax.swing.JFrame;
import hust.soict.ict.aims.cart.Cart;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class CartScreen extends JFrame 
{
    private Cart cart;
    private JFXPanel fxPanel;

    public CartScreen(Cart cart) 
    {
        super();
        this.cart = cart;

        fxPanel = new JFXPanel();
        this.add(fxPanel);

        this.setTitle("Cart");
        this.setVisible(true);
        Platform.runLater(new Runnable() 
        {
            @Override
            public void run() 
            {
                try 
                {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/hust/soict/ict/aims/screen/cart.fxml"));
                    CartScreenController controller = new CartScreenController(cart);
                    loader.setController(controller);
                    Parent root = loader.load();
                    fxPanel.setScene(new Scene(root));
                }
                catch (IOException e) 
                {
                    e.printStackTrace();
                }
            }
        });
    }
    
    public JFXPanel getScene() { return fxPanel; }
}

