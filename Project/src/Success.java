import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class Success {
	BackgroundFill background_fill = new BackgroundFill(Color.LIGHTGREEN,CornerRadii.EMPTY, Insets.EMPTY); 
    Background background = new Background(background_fill);
    
    Label successLabel = new Label("Success !");
    
    public GridPane p4() {
		GridPane p4 = new GridPane();
		
		p4.setAlignment(Pos.CENTER);
		p4.setPadding(new Insets(5,5,2,5));
		p4.setHgap(10);
		p4.setVgap(5);
		
		p4.add(successLabel, 0, 0);
		
		p4.setBackground(background);
		
		return p4;
	}
}