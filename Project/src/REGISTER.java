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

public class REGISTER {
	BackgroundFill background_fill = new BackgroundFill(Color.DARKCYAN,CornerRadii.EMPTY, Insets.EMPTY);
    Background background = new Background(background_fill); 
	
	Label IDLabel = new Label("ID:");
	TextField idField = new TextField();
	
	Label nameLabel = new Label("Name:");
	TextField nameField = new TextField();
	
	Label surnameLabel = new Label("Surname:");
	TextField surnameField = new TextField();
	
	Label usernameLabel = new Label("Username:");
	TextField usernameField = new TextField();
	
	Label passwordLabel = new Label("Password:");
	PasswordField passwordField = new PasswordField();
	
	Button submitButton = new Button("Submit");
	Button backButton = new Button("Back");
	
	public GridPane p2() {
		GridPane p2 = new GridPane();
		
		p2.setAlignment(Pos.CENTER);
		p2.setPadding(new Insets(5,5,2,5));
		p2.setHgap(10);
		p2.setVgap(5);

		p2.add(IDLabel, 0, 0);
		p2.add(idField, 1, 0);
		p2.add(nameLabel, 0, 1);
		p2.add(nameField, 1, 1);
		p2.add(surnameLabel, 0, 2);
		p2.add(surnameField, 1, 2);
		p2.add(usernameLabel, 0, 3);
		p2.add(usernameField, 1, 3);
		p2.add(passwordLabel, 0, 4);
		p2.add(passwordField, 1, 4);
		p2.add(submitButton, 1, 5);
		p2.add(backButton, 2, 5);
		
		p2.setBackground(background);
		
		return p2;
	}
}