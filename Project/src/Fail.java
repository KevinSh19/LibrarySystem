import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class Fail extends Label {
	BackgroundFill background_fill = new BackgroundFill(Color.RED,CornerRadii.EMPTY, Insets.EMPTY); 
    Background background = new Background(background_fill);
    
    Label failLabel = new Label("Fail !");

    public GridPane p5() {
		GridPane p5 = new GridPane();
		
		p5.setAlignment(Pos.CENTER);
		p5.setPadding(new Insets(5,5,2,5));
		p5.setHgap(10);
		p5.setVgap(5);
		
		p5.add(failLabel, 0, 0);
		
		p5.setBackground(background);
		
		return p5;
	}
}