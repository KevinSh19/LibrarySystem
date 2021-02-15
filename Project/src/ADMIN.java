import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class ADMIN {
	BackgroundFill background_fill = new BackgroundFill(Color.BLACK,CornerRadii.EMPTY, Insets.EMPTY);
    Background background = new Background(background_fill); 
    
    Button checkTransactions = new Button("Transactions");
    Button checkUserButton = new Button("Users");
    Button addBookButton = new Button("Add new book");
    Button backButton = new Button("Back");
    
    public GridPane p6() {
    	GridPane p6 = new GridPane();
    	
    	p6.setAlignment(Pos.CENTER);
		p6.setPadding(new Insets(5,5,2,5));
		p6.setHgap(10);
		p6.setVgap(5);
		
		p6.add(checkTransactions, 0, 0);
		p6.add(checkUserButton, 1, 0);
		p6.add(addBookButton, 2, 0);
		p6.add(backButton, 3, 0);
		
		p6.setBackground(background);
    	
    	return p6;
    }
}