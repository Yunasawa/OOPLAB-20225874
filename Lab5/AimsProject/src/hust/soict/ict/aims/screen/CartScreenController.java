package hust.soict.ict.aims.screen;

import hust.soict.ict.aims.cart.Cart;
import hust.soict.ict.aims.media.Media;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class CartScreenController 
{
    private Cart cart;

    @FXML
    public TableView<Media> tblMedia;

    @FXML
    public TableColumn<Media, String> colMediaTitle;

    @FXML
    public TableColumn<Media, String> colMediacategory;

    @FXML
    public TableColumn<Media, Float> colMediaCost;

    public CartScreenController(Cart cart) 
    {
        super();
        this.cart = cart;
    }

    @FXML
    private void initialize() 
    {
        colMediaTitle.setCellValueFactory(new PropertyValueFactory<Media, String>("title"));
        colMediacategory.setCellValueFactory(new PropertyValueFactory<Media, String>("category"));
        colMediaCost.setCellValueFactory(new PropertyValueFactory<Media, Float>("cost"));
        tblMedia.setItems(this.cart.getItemsOrdered());
    }
}