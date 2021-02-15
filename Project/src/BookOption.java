import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class BookOption {
	BackgroundFill background_fill = new BackgroundFill(Color.DARKCYAN,CornerRadii.EMPTY, Insets.EMPTY);
    Background background = new Background(background_fill); 
    
	Button getbookButton = new Button("Get a book");
	Button handinButton = new Button("Hand in a book");
	Button closeButton = new Button("Back");
	
	public GridPane p3() {
		GridPane p3 = new GridPane();
		
		p3.setAlignment(Pos.CENTER);
		p3.setPadding(new Insets(5,5,2,5));
		p3.setHgap(10);
		p3.setVgap(5);
		
		p3.add(getbookButton, 0, 0);
		p3.add(handinButton, 1, 0);
		p3.add(closeButton, 2, 0);
		
		p3.setBackground(background);
		
		return p3;
	}
}