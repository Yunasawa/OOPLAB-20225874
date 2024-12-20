package hust.soict.ict.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PainterController 
{
	private boolean _isUsingPen;
	
	@FXML
	private Pane drawingAreaPane;
	
	@FXML
	void clearButtonPressed(ActionEvent event)
	{
		drawingAreaPane.getChildren().clear();
	}
	
	@FXML
	void drawingAreaMouseDragged(MouseEvent event)
	{
		Color color = _isUsingPen ? Color.BLACK : Color.WHITE;
		Circle newCircle = new Circle(event.getX(), event.getY(), 4, color);
		drawingAreaPane.getChildren().add(newCircle);
	}
	
	@FXML
	void onPenPressed(ActionEvent event)
	{
		_isUsingPen = true;
	}
	
	@FXML
	void onEraserPressed(ActionEvent event)
	{
		_isUsingPen = false;	
	}
}
