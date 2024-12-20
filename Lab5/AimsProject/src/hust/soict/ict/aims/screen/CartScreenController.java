package hust.soict.ict.aims.screen;

import java.awt.event.ActionEvent;

import hust.soict.ict.aims.cart.Cart;
import hust.soict.ict.aims.media.Media;
import hust.soict.ict.aims.media.Playable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class CartScreenController 
{
    private Cart cart;

    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;
    
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
        
        btnPlay.setVisible(false);
        btnRemove.setVisible(false);

        tblMedia.getSelectionModel().selectedItemProperty().addListener(
            new ChangeListener<Media>() 
            {
                @Override
                public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue) 
                {
                    if (newValue != null) 
                    {
                        updateButtonBar(newValue);
                    }
                }
            });
    }
    
    void updateButtonBar(Media media)
    {
    	btnRemove.setVisible(true);
    	if (media instanceof Playable) btnPlay.setVisible(true);
    	else btnPlay.setVisible(false);
    }
    
    @FXML
    private void btnRemovePressed(ActionEvent event)
    {
    	Media media = tblMedia.getSelectionModel().getSelectedItem();
    	cart.removeMedia(media);
    }
}