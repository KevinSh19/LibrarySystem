import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class CheckAdmin {
	BackgroundFill background_fill = new BackgroundFill(Color.BLACK,CornerRadii.EMPTY, Insets.EMPTY);
    Background background = new Background(background_fill); 
    
    Label usernamLabel = new Label("Username:");
    TextField usernameField = new TextField();
    
    Label passwordLabel = new Label("Password:");
    PasswordField passwordField = new PasswordField();
    
    Button submitButton = new Button("Submit");
    Button backButton = new Button("Back");
    
    public GridPane p7() {
    	GridPane p7 = new GridPane();
    	
    	p7.setAlignment(Pos.CENTER);
		p7.setPadding(new Insets(5,5,2,5));
		p7.setHgap(10);
		p7.setVgap(5);
		
		p7.add(usernamLabel, 0, 0);
		p7.add(usernameField, 1, 0);
		p7.add(passwordLabel, 0, 1);
		p7.add(passwordField, 1, 1);
		
		p7.add(submitButton, 1, 2);
		p7.add(backButton, 2, 2);
		
		p7.setBackground(background);
    	
    	return p7;
    }
}
