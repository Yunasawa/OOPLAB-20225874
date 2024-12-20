package hust.soict.ict.aims.screen;

import hust.soict.ict.aims.cart.Cart;
import javafx.application.Application;
import javafx.stage.Stage;

public class ViewCartScreen extends Application 
{
    @Override
    public void start(Stage primaryStage) throws Exception 
    {
        Cart cart = new Cart();
        CartScreen cartScreen = new CartScreen(cart);
    }

    public static void main(String[] args) 
    {
        launch(args);
    }
}