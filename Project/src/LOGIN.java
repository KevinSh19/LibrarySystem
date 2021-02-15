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
import javafx.scene.text.Font;

public class LOGIN {
	
	Button loginButton = new Button("Login");
	Button registerButton = new Button("Register");
	Button closeButton = new Button("Back");
	
	Label usernameLabel = new Label("Username:");
	TextField userTextField = new TextField();
	
	Label passwordLabel = new Label("Password:");
	PasswordField passwordField = new PasswordField();
	
	BackgroundFill background_fill = new BackgroundFill(Color.DARKCYAN,CornerRadii.EMPTY, Insets.EMPTY);
    Background background = new Background(background_fill); 
	
	public GridPane p1() {
		GridPane p1 = new GridPane();
		
		p1.setAlignment(Pos.CENTER);
		p1.setPadding(new Insets(5,5,2,5));
		p1.setHgap(10);
		p1.setVgap(5);
		
		p1.setBackground(background);
		
		p1.add(usernameLabel, 0, 0);
		p1.add(userTextField, 1, 0);
		
		p1.add(passwordLabel, 0, 1);
		p1.add(passwordField, 1, 1);
		
		p1.add(loginButton, 0, 2);
		p1.add(registerButton, 1, 2);
		p1.add(closeButton, 2, 2);
		
		return p1;
	}
}