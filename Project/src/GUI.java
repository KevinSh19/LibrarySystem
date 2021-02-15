import java.io.FileInputStream;
import java.io.IOException;
import javafx.scene.control.TableColumn;
import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

public class GUI extends Application {
	Stage stage = new Stage();

	Stage failStage = new Stage();
	Stage successStage = new Stage();
	
	Transactions transactions = new Transactions();
	Transactions[] tra = new Transactions[100];
	Clients clients = new Clients();
	
	TableView<Library> tableBook;
	TableView<Transactions> transactionTable;
	TableView<Library> tableBookAdmin;
	TableView<Transactions> transactionAdminTable;
	TableView<Clients> userTable;
	
	Library l = new Library();
	Library[] li = new Library[100];
	static String loginusername;
	static int controller = 0;
	
	@Override
	public void start(Stage st) throws Exception {
		LOGIN user = new LOGIN();
		REGISTER register = new REGISTER();
		BookOption bookOption = new BookOption();
		Success success = new Success();
		Fail fail = new Fail();
		CheckAdmin checkAdmin = new CheckAdmin();
		ADMIN admin = new ADMIN();
		AdminAddBook adb = new AdminAddBook();
		
		BorderPane p1 = new BorderPane();
		p1.setCenter(user.p1());
		Scene scene1 = new Scene(p1, 1500, 800);
		
		BorderPane p2 = new BorderPane();
		p2.setCenter(bookOption.p3());
		Scene scene2 = new Scene(p2, 1500, 800);
		
		BorderPane p3 = new BorderPane();
		p3.setCenter(register.p2());
		Scene scene3 = new Scene(p3, 1500, 800);
		
		BorderPane p4 = new BorderPane();
		p4.setCenter(success.p4());
		Scene successScene = new Scene(p4, 200, 200);
		
		BorderPane p5 = new BorderPane();
		p5.setCenter(fail.p5());
		Scene failScene = new Scene(p5, 200, 200);
		
		BorderPane p6 = new BorderPane();
		p6.setCenter(admin.p6());
		Scene adminScene = new Scene(p6, 1500, 800);
		
		BorderPane p7 = new BorderPane();
		p7.setCenter(checkAdmin.p7());
		Scene checkAdminScene = new Scene(p7, 1500, 800);
		
		// set sizes
		user.usernameLabel.setStyle("-fx-font-size:30");
		user.usernameLabel.setTextFill(Color.web("#ffffff"));
		
		user.userTextField.setStyle("-fx-font-size:15");
		
		user.passwordLabel.setStyle("-fx-font-size:30");
		user.passwordLabel.setTextFill(Color.web("#ffffff"));
		
		user.passwordField.setStyle("-fx-font-size:15");
		
		user.loginButton.setStyle("-fx-font-size:15");
		user.loginButton.setMinWidth(200);
		
		user.registerButton.setStyle("-fx-font-size:15");
		user.registerButton.setMinWidth(200);;
		
		user.closeButton.setStyle("-fx-font-size:15");
		user.closeButton.setMinWidth(200);
		user.closeButton.setStyle("-fx-background-color: #ff0000");
		
		register.IDLabel.setStyle("-fx-font-size:30");
		register.IDLabel.setTextFill(Color.web("#ffffff"));
		
		register.idField.setStyle("-fx-font-size:15");
		
		register.nameLabel.setStyle("-fx-font-size:30");
		register.nameLabel.setTextFill(Color.web("#ffffff"));
		
		register.nameField.setStyle("-fx-font-size:15");
		
		register.surnameLabel.setStyle("-fx-font-size:30");
		register.surnameLabel.setTextFill(Color.web("#ffffff"));
		
		register.surnameField.setStyle("-fx-font-size:15");
		
		register.usernameLabel.setStyle("-fx-font-size:30");
		register.usernameLabel.setTextFill(Color.web("#ffffff"));
		
		register.usernameField.setStyle("-fx-font-size:15");
		
		register.passwordLabel.setStyle("-fx-font-size:30");
		register.passwordLabel.setTextFill(Color.web("#ffffff"));
		
		register.passwordField.setStyle("-fx-font-size:15");
		
		register.submitButton.setStyle("-fx-font-size:15");
		register.submitButton.setMinWidth(200);
		
		register.backButton.setStyle("-fx-font-size:15");
		register.backButton.setMinWidth(200);
		register.backButton.setStyle("-fx-background-color: #ff0000");
		
		bookOption.getbookButton.setStyle("-fx-font-size:15");
		bookOption.getbookButton.setMinWidth(200);
		
		bookOption.handinButton.setStyle("-fx-font-size:15");
		bookOption.handinButton.setMinWidth(200);
		
		bookOption.closeButton.setStyle("-fx-font-size:15");
		bookOption.closeButton.setMinWidth(200);
		bookOption.closeButton.setStyle("-fx-background-color: #ff0000");
		
		admin.checkTransactions.setStyle("-fx-font-size:15");
		admin.checkTransactions.setMinWidth(200);
		
		admin.checkUserButton.setStyle("-fx-font-size:15");
		admin.checkUserButton.setMinWidth(200);
		
		admin.addBookButton.setStyle("-fx-font-size:15");
		admin.addBookButton.setMinWidth(200);
		
		admin.backButton.setStyle("-fx-font-size:15");
		admin.backButton.setMinWidth(200);
		admin.backButton.setStyle("-fx-background-color: #ff0000");
		
		checkAdmin.usernamLabel.setStyle("-fx-font-size:30");
		checkAdmin.usernamLabel.setTextFill(Color.web("#ffffff"));
		
		checkAdmin.usernameField.setStyle("-fx-font-size:15");
		
		checkAdmin.passwordLabel.setStyle("-fx-font-size:30");
		checkAdmin.passwordLabel.setTextFill(Color.web("#ffffff"));
		
		checkAdmin.passwordField.setStyle("-fx-font-size:15");
		
		checkAdmin.submitButton.setStyle("-fx-font-size:15");
		checkAdmin.submitButton.setMinWidth(200);
		
		checkAdmin.backButton.setStyle("-fx-font-size:15");
		checkAdmin.backButton.setMinWidth(200);
		checkAdmin.backButton.setStyle("-fx-background-color: #ff0000");
		
		// Welcome scene
		Label welcomeLabel = new Label("Welcome to Epoka Library");
		welcomeLabel.setFont(new Font(50.0));
		welcomeLabel.setTextFill(Color.web("#ffffff"));
		welcomeLabel.setStyle("-fx-background-color: #0000ff");
		welcomeLabel.setAlignment(Pos.CENTER);
		
		Button logAdminButton = new Button("ADMIN");
		logAdminButton.setFont(new Font(25));
		logAdminButton.setTextFill(Color.web("#ffffff"));
		logAdminButton.setStyle("-fx-background-color: #0000ff");
		logAdminButton.setMinWidth(300);
		
		Button logUserButton = new Button("USER");
		logUserButton.setFont(new Font(25));
		logUserButton.setTextFill(Color.web("#ffffff"));
		logUserButton.setStyle("-fx-background-color: #0000ff");
		logUserButton.setMinWidth(300);
		
		Button exitButton = new Button("EXIT");
		exitButton.setFont(new Font(25));
		exitButton.setMinWidth(300);
		exitButton.setStyle("-fx-background-color: #ff0000");
		
		VBox imageBox = new VBox(welcomeLabel, logUserButton, logAdminButton, exitButton);
		
		// set spacing 
        imageBox.setSpacing(50); 

        // set alignment for the HBox 
        imageBox.setAlignment(Pos.CENTER); 
		
		// create a input stream 
        FileInputStream input = new FileInputStream("253332.png"); 

        // create a image 
        Image image = new Image(input); 

        // create a background image 
        BackgroundImage backgroundimage = new BackgroundImage(image,  
                                         BackgroundRepeat.NO_REPEAT,  
                                         BackgroundRepeat.NO_REPEAT,  
                                         BackgroundPosition.DEFAULT,  
                                            BackgroundSize.DEFAULT); 
        
        // create Background 
        Background background = new Background(backgroundimage); 

        // set background 
        imageBox.setBackground(background); 
        
        Scene imageScene = new Scene(imageBox, 1500, 800); 
		
		// book table
		TableColumn<Library, String> bookNameColumn = new TableColumn<>("Title");
		bookNameColumn.setMinWidth(200);
		bookNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
		bookNameColumn.setStyle("-fx-alignment: CENTER-LEFT;");
		
		TableColumn<Library, String> authorNameColumn = new TableColumn<>("Author");
		authorNameColumn.setMinWidth(200);
		authorNameColumn.setCellValueFactory(new PropertyValueFactory<>("author"));
		authorNameColumn.setStyle("-fx-alignment: CENTER;");
		
		TableColumn<Library, String> isbnColumn = new TableColumn<>("ISBN");
		isbnColumn.setMinWidth(200);
		isbnColumn.setCellValueFactory(new PropertyValueFactory<>("ISBN"));
		isbnColumn.setStyle("-fx-alignment: CENTER;");
		
		TableColumn<Library, String> yearColumn = new TableColumn<>("Year");
		yearColumn.setMinWidth(200);
		yearColumn.setCellValueFactory(new PropertyValueFactory<>("year"));
		yearColumn.setStyle("-fx-alignment: CENTER;");
		
		tableBook = new TableView<>();
		tableBook.setItems(getBooks());
		tableBook.getColumns().addAll(bookNameColumn, authorNameColumn, isbnColumn, yearColumn);
		
		tableBook.setMinHeight(700);
		
		Label iSBNLabel = new Label("ISBN:");
		TextField iSBNField = new TextField();
		iSBNField.setPromptText("ISBN");
		iSBNField.setMinWidth(100);
		
		Button submitButtonTake = new Button("Submit");
		Button quitButton = new Button("Back");
		
		HBox hBox1 = new HBox();
		hBox1.setPadding(new Insets(10, 10, 10, 10));
		hBox1.setSpacing(10);
		hBox1.getChildren().addAll(iSBNLabel, iSBNField, submitButtonTake, quitButton);
		
		VBox vBox1 = new VBox();
		vBox1.getChildren().addAll(tableBook, hBox1);
		
		Scene bookScene = new Scene(vBox1);
		
		// transaction table 
		TableColumn<Transactions, Integer> transactionIDColumn = new TableColumn<>("ID");
		transactionIDColumn.setMinWidth(50);
		transactionIDColumn.setCellValueFactory(new PropertyValueFactory<>("trID"));
		transactionIDColumn.setStyle("-fx-alignment: CENTER;");
		
		TableColumn<Transactions, String> isbn2Column = new TableColumn<>("ISBN");
		isbn2Column.setMinWidth(100);
		isbn2Column.setCellValueFactory(new PropertyValueFactory<>("ISBN"));
		isbn2Column.setStyle("-fx-alignment: CENTER;");
		
		TableColumn<Transactions, String> takeDateColumn = new TableColumn<>("Take Date");
		takeDateColumn.setMinWidth(200);
		takeDateColumn.setCellValueFactory(new PropertyValueFactory<>("takenTime"));
		takeDateColumn.setStyle("-fx-alignment: CENTER;");
		
		TableColumn<Transactions, String> handleDateColumn = new TableColumn<>("Handle Date");
		handleDateColumn.setMinWidth(200);
		handleDateColumn.setCellValueFactory(new PropertyValueFactory<>("handledTime"));
		handleDateColumn.setStyle("-fx-alignment: CENTER;");
		
		TableColumn<Transactions, String> daysLefTableColumn = new TableColumn<>("Days Left");
		daysLefTableColumn.setMinWidth(100);
		daysLefTableColumn.setCellValueFactory(new PropertyValueFactory<>("timeleft"));
		daysLefTableColumn.setStyle("-fx-alignment: CENTER;");
		
		TableColumn<Transactions, String> handleornoTableColumn = new TableColumn<>("Handled?");
		handleornoTableColumn.setMinWidth(200);
		handleornoTableColumn.setCellValueFactory(new PropertyValueFactory<>("handledornotString"));
		handleornoTableColumn.setStyle("-fx-alignment: CENTER;");
		
		transactionTable = new TableView<>();
		
		transactionTable.getColumns().addAll(transactionIDColumn, isbn2Column, takeDateColumn,handleornoTableColumn,daysLefTableColumn, handleDateColumn);
		
		transactionTable.setMinHeight(700);
		
		Label iSBNLabel2 = new Label("ISBN:");
		TextField iSBNField2 = new TextField();
		iSBNField2.setPromptText("ISBN");
		iSBNField2.setMinWidth(100);
		
		Button submitButtonHandIn = new Button("Submit");
		Button quitButton2 = new Button("Back");
		
		HBox hBox2 = new HBox();
		hBox2.setPadding(new Insets(10, 10, 10, 10));
		hBox2.setSpacing(10);
		hBox2.getChildren().addAll(iSBNLabel2, iSBNField2, submitButtonHandIn, quitButton2);
		
		VBox vBox2 = new VBox();
		vBox2.getChildren().addAll(transactionTable, hBox2);
		
		Scene bookScene2 = new Scene(vBox2);
		
		// admin book table
		TableColumn<Library, String> bookNameColumn2 = new TableColumn<>("Title");
		bookNameColumn2.setMinWidth(200);
		bookNameColumn2.setCellValueFactory(new PropertyValueFactory<>("name"));
		bookNameColumn2.setStyle("-fx-alignment: CENTER-LEFT;");
		
		TableColumn<Library, String> authorNameColumn2 = new TableColumn<>("Author");
		authorNameColumn2.setMinWidth(200);
		authorNameColumn2.setCellValueFactory(new PropertyValueFactory<>("author"));
		authorNameColumn2.setStyle("-fx-alignment: CENTER;");
		
		TableColumn<Library, String> isbnColumn2 = new TableColumn<>("ISBN");
		isbnColumn2.setMinWidth(200);
		isbnColumn2.setCellValueFactory(new PropertyValueFactory<>("ISBN"));
		isbnColumn2.setStyle("-fx-alignment: CENTER;");
		
		TableColumn<Library, String> yearColumn2 = new TableColumn<>("Year");
		yearColumn2.setMinWidth(200);
		yearColumn2.setCellValueFactory(new PropertyValueFactory<>("year"));
		yearColumn2.setStyle("-fx-alignment: CENTER;");
		
		TableColumn<Library, Integer> counterColumn = new TableColumn<>("Left");
		counterColumn.setMinWidth(200);
		counterColumn.setCellValueFactory(new PropertyValueFactory<>("bookcounter1"));
		counterColumn.setStyle("-fx-alignment: CENTER;");
		
		tableBookAdmin = new TableView<>();
		tableBookAdmin.setItems(getBooks());
		tableBookAdmin.setMinHeight(700);
		
		tableBookAdmin.getColumns().addAll(bookNameColumn2, authorNameColumn2, isbnColumn2, yearColumn2, counterColumn);
		
		adb.name.setPromptText("Book title");
		adb.author.setPromptText("Author name");
		adb.isbn.setPromptText("ISBN");
		adb.year.setPromptText("Year");
		adb.counter.setPromptText("Counter");
		
		adb.backButton.setFont(new Font(15));
		adb.backButton.setMinWidth(100);
		adb.backButton.setStyle("-fx-background-color: #ff0000");
		
		adb.submitButton.setFont(new Font(15));
		adb.submitButton.setMinWidth(100);
		
		HBox hBoxAdmin = new HBox();
		hBoxAdmin.setPadding(new Insets(10, 10, 10, 10));
		hBoxAdmin.setSpacing(10);
		hBoxAdmin.getChildren().addAll(adb.name, adb.author, adb.isbn, adb.year, adb.counter, adb.submitButton, adb.backButton);
		
		VBox vBoxAdmin = new VBox();
		vBoxAdmin.getChildren().addAll(tableBookAdmin, hBoxAdmin);
		
		Scene bookAdminScene = new Scene(vBoxAdmin);
		
		// transactins admin table
		TableColumn<Transactions, Integer> transactionIDColumn2 = new TableColumn<>("ID");
		transactionIDColumn2.setMinWidth(50);
		transactionIDColumn2.setCellValueFactory(new PropertyValueFactory<>("trID"));
		transactionIDColumn2.setStyle("-fx-alignment: CENTER;");
		
		TableColumn<Transactions, String> usernameColumn = new TableColumn<>("Username");
		usernameColumn.setMinWidth(50);
		usernameColumn.setCellValueFactory(new PropertyValueFactory<>("username"));
		usernameColumn.setStyle("-fx-alignment: CENTER;");
		usernameColumn.setMinWidth(200);
		
		TableColumn<Transactions, String> isbn2Column2 = new TableColumn<>("ISBN");
		isbn2Column2.setMinWidth(100);
		isbn2Column2.setCellValueFactory(new PropertyValueFactory<>("ISBN"));
		isbn2Column2.setStyle("-fx-alignment: CENTER;");
		
		TableColumn<Transactions, String> takeDateColumn2 = new TableColumn<>("Take Date");
		takeDateColumn2.setMinWidth(200);
		takeDateColumn2.setCellValueFactory(new PropertyValueFactory<>("takenTime"));
		takeDateColumn2.setStyle("-fx-alignment: CENTER;");
		
		TableColumn<Transactions, String> handleDateColumn2 = new TableColumn<>("Handle Date");
		handleDateColumn2.setMinWidth(200);
		handleDateColumn2.setCellValueFactory(new PropertyValueFactory<>("handledTime"));
		handleDateColumn2.setStyle("-fx-alignment: CENTER;");
		
		TableColumn<Transactions, String> daysLefTableColumn2 = new TableColumn<>("Days Left");
		daysLefTableColumn2.setMinWidth(100);
		daysLefTableColumn2.setCellValueFactory(new PropertyValueFactory<>("timeleft"));
		daysLefTableColumn2.setStyle("-fx-alignment: CENTER;");
		
		TableColumn<Transactions, String> handleornoTableColumn2 = new TableColumn<>("Handled?");
		handleornoTableColumn2.setMinWidth(200);
		handleornoTableColumn2.setCellValueFactory(new PropertyValueFactory<>("handledornotString"));
		handleornoTableColumn2.setStyle("-fx-alignment: CENTER;");
		
		transactionAdminTable = new TableView<>();
		
		transactionAdminTable.getColumns().addAll(transactionIDColumn2, usernameColumn, isbn2Column2, takeDateColumn2, handleornoTableColumn2, daysLefTableColumn2, handleDateColumn2);
		
		transactionAdminTable.setMinHeight(700);
		
		TextField usernameField = new TextField();
		usernameField.setPromptText("Type username");
		usernameField.setFont(new Font(20));
		
		Button searchButton = new Button("Search");
		searchButton.setFont(new Font(20));
		searchButton.setMinWidth(200);
		searchButton.setOnAction(e -> {
			String username = usernameField.getText().toString();
			
			try {
				if (transactions.searchUsername(username)) {
					
					transactionTable.setItems(getTransactions(username));

					SwitchScenes(bookScene2);
					
					successStage.setScene(successScene);
					successStage.setTitle("SUCCESS");
					successStage.show();
					
					PauseTransition delay = new PauseTransition(Duration.seconds(1.5));
					delay.setOnFinished( event -> successStage.close() );
					delay.play();
				} else {
					failStage.setScene(failScene);
					failStage.setTitle("FAIL");
					failStage.show();
					
					PauseTransition delay = new PauseTransition(Duration.seconds(1.5));
					delay.setOnFinished( event -> failStage.close() );
					delay.play();
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			usernameField.clear();
		});
		
		Button quitButton22 = new Button("Back");
		quitButton22.setOnAction(e -> SwitchScenes(adminScene));
		quitButton22.setFont(new Font(20));
		quitButton22.setMinWidth(200);
		quitButton22.setStyle("-fx-background-color: #ff0000");
		
		HBox hBox3 = new HBox();
		hBox3.setPadding(new Insets(10, 10, 10, 10));
		hBox3.setSpacing(10);
		hBox3.getChildren().addAll(usernameField, searchButton, quitButton22);
		
		VBox vBox3 = new VBox();
		vBox3.getChildren().addAll(transactionAdminTable, hBox3);
		
		Scene transactionAdminScene = new Scene(vBox3);
		
		// user table
		TableColumn<Clients, String> idColumn = new TableColumn<>("Personal ID");
		idColumn.setMinWidth(100);
		idColumn.setCellValueFactory(new PropertyValueFactory<>("ID"));
		idColumn.setStyle("-fx-alignment: CENTER;");
		
		TableColumn<Clients, String> nameColumn = new TableColumn<>("Name");
		nameColumn.setMinWidth(200);
		nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
		nameColumn.setStyle("-fx-alignment: CENTER;");
		
		TableColumn<Clients, String> usernameColumn2 = new TableColumn<>("Username");
		usernameColumn2.setMinWidth(200);
		usernameColumn2.setCellValueFactory(new PropertyValueFactory<>("username"));
		usernameColumn2.setStyle("-fx-alignment: CENTER;");
		
		TableColumn<Clients, String> passwordColumn2 = new TableColumn<>("Password");
		passwordColumn2.setMinWidth(200);
		passwordColumn2.setCellValueFactory(new PropertyValueFactory<>("password"));
		passwordColumn2.setStyle("-fx-alignment: CENTER;");
		
		userTable = new TableView<>();
		userTable.setItems(getAllClients());
		userTable.setMinHeight(700);
		
		userTable.getColumns().addAll(idColumn, nameColumn, usernameColumn2, passwordColumn2);
		
		Button backButton2 = new Button("Back");
		backButton2.setOnAction(e -> SwitchScenes(adminScene));
		backButton2.setFont(new Font(20));
		backButton2.setMinWidth(200);
		backButton2.setStyle("-fx-background-color: #ff0000");
		
		HBox hBox4 = new HBox();
		hBox4.setPadding(new Insets(10, 10, 10, 10));
		hBox4.setSpacing(10);
		hBox4.getChildren().addAll(backButton2);
		
		VBox vBox4 = new VBox();
		vBox4.getChildren().addAll(userTable, hBox4);
		
		Scene usersAdminScene = new Scene(vBox4);
		
		admin.checkUserButton.setOnAction(e -> {
			try {
				userTable.setItems(getAllClients());
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			SwitchScenes(usersAdminScene);
		});
		
		// welcome buttons
		logUserButton.setOnAction(e -> SwitchScenes(scene1));
		logAdminButton.setOnAction(e -> SwitchScenes(checkAdminScene));
		exitButton.setOnAction(e -> stage.close());
		
		checkAdmin.submitButton.setOnAction(e -> SwitchScenes(adminScene));
		
		// check admin buttons
		checkAdmin.submitButton.setOnAction(e -> {
			String username = checkAdmin.usernameField.getText().toString();
			String password = checkAdmin.passwordField.getText().toString();
			
			if (username.equals("admin") && password.equals("admin")) {
				SwitchScenes(adminScene);
				
				successStage.setScene(successScene);
				successStage.setTitle("SUCCESS");
				successStage.show();
				
				PauseTransition delay = new PauseTransition(Duration.seconds(1.5));
				delay.setOnFinished( event -> successStage.close() );
				delay.play();
				
				checkAdmin.usernameField.clear();
				checkAdmin.passwordField.clear();
			} else {
				failStage.setScene(failScene);
				failStage.setTitle("FAIL");
				failStage.show();
				
				PauseTransition delay = new PauseTransition(Duration.seconds(1.5));
				delay.setOnFinished( event -> failStage.close() );
				delay.play();
			}
		});
		
		checkAdmin.backButton.setOnAction(e -> SwitchScenes(imageScene));
		
		// admin buttons
		admin.backButton.setOnAction(e -> SwitchScenes(imageScene));
		
		admin.addBookButton.setOnAction(e -> {
			try {
				tableBookAdmin.setItems(getBooks());
			} catch (IOException e2) {
				e2.printStackTrace();
			}
			SwitchScenes(bookAdminScene);
		});
		
		admin.checkTransactions.setOnAction(e -> {
			controller = 2;
			
			try {
				transactionAdminTable.setItems(getAllTransactions());
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
			SwitchScenes(transactionAdminScene);
		});
		
		// admin - get book
		adb.submitButton.setOnAction(e -> {			
			String name = adb.name.getText().toString();
			String author = adb.author.getText().toString();
			String isbn = adb.isbn.getText().toString();
			String year = adb.year.getText().toString();
			int counter = Integer.parseInt(adb.counter.getText().toString());
			
			if (name.equals("") || author.equals("") || isbn.equals("") || year.equals("")) {
				failStage.setScene(failScene);
				failStage.setTitle("FAIL");
				failStage.show();
				
				PauseTransition delay = new PauseTransition(Duration.seconds(1.5));
				delay.setOnFinished( event -> failStage.close() );
				delay.play();
			} else {
				try {
					transactions.addBooks(name, author, isbn, year, counter);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
				SwitchScenes(adminScene);
				
				successStage.setScene(successScene);
				successStage.setTitle("SUCCESS");
				successStage.show();
				
				PauseTransition delay = new PauseTransition(Duration.seconds(1.5));
				delay.setOnFinished( event -> successStage.close() );
				delay.play();
				
				adb.name.clear();
				adb.author.clear();
				adb.isbn.clear();
				adb.year.clear();
				adb.counter.clear();
			}
		});
		
		adb.backButton.setOnAction(e -> SwitchScenes(adminScene));
		
		// user buttons
		user.loginButton.setOnAction(e -> {
			String username = user.userTextField.getText().toString();	
			String password = user.passwordField.getText().toString();
			
			loginusername = username;

			try {
				if(clients.searchClients(username, password)){
					transactionTable.setItems(getTransactions(loginusername));
					
					SwitchScenes(scene2);
					
					successStage.setScene(successScene);
					successStage.setTitle("SUCCESS");
					successStage.show();
					
					PauseTransition delay = new PauseTransition(Duration.seconds(1.5));
					delay.setOnFinished( event -> successStage.close() );
					delay.play();
				} else {
					failStage.setScene(failScene);
					failStage.setTitle("FAIL");
					failStage.show();
					
					PauseTransition delay = new PauseTransition(Duration.seconds(1.5));
					delay.setOnFinished( event -> failStage.close() );
					delay.play();
				}
			} catch (NullPointerException | IOException e1) {
				e1.printStackTrace();
			}	
			
			user.userTextField.clear();
			user.passwordField.clear();
		});
		
		user.registerButton.setOnAction(e -> SwitchScenes(scene3));
		user.closeButton.setOnAction(e -> SwitchScenes(imageScene));
		
		// register buttons
		register.submitButton.setOnAction(e -> {
			String username = register.usernameField.getText().toString();	
			String password = register.passwordField.getText().toString();
			String name = register.nameField.getText().toString();
			String surname = register.surnameField.getText().toString();
			String ID = register.idField.getText().toString();
			
			try {			
				if (username.equals("") || password.equals("") || name.equals("") || surname.equals("") || ID.equals("")) {
					failStage.setScene(failScene);
					failStage.setTitle("FAIL");
					failStage.show();
					
					PauseTransition delay = new PauseTransition(Duration.seconds(1.5));
					delay.setOnFinished( event -> failStage.close() );
					delay.play();
				} else {
					transactions.registerClients(name.replace(" ", ""), surname.replace(" ", ""), username.replace(" ", ""), password, ID.replace(" ", ""));
					
					loginusername = username;
					
					SwitchScenes(scene2);
					
					successStage.setScene(successScene);
					successStage.setTitle("SUCCESS");
					successStage.show();
					
					PauseTransition delay = new PauseTransition(Duration.seconds(1.5));
					delay.setOnFinished( event -> successStage.close() );
					delay.play();
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			register.nameField.clear();
			register.idField.clear();
			register.surnameField.clear();
			register.usernameField.clear();
			register.passwordField.clear();
		});
		
		register.backButton.setOnAction(e -> SwitchScenes(scene1));
		
		// book option button
		bookOption.getbookButton.setOnAction(e -> SwitchScenes(bookScene));
		bookOption.handinButton.setOnAction(e -> {
			controller = 1;
			SwitchScenes(bookScene2);
		});
		bookOption.closeButton.setOnAction(e -> SwitchScenes(scene1));
		
		// get book buttons
		submitButtonTake.setOnAction(e -> {
			String ISBN = iSBNField.getText().toString();
			
			try {
				if (transactions.takeBook(ISBN, loginusername) == 1) {
					transactionTable.setItems(getTransactions(loginusername));
					tableBook.setItems(getBooks());
					
					SwitchScenes(scene2);
					
					successStage.setScene(successScene);
					successStage.setTitle("SUCCESS");
					successStage.show();
					
					PauseTransition delay = new PauseTransition(Duration.seconds(1.5));
					delay.setOnFinished( event -> successStage.close() );
					delay.play();
				} else {
					failStage.setScene(failScene);
					failStage.setTitle("FAIL");
					failStage.show();
					
					PauseTransition delay = new PauseTransition(Duration.seconds(1.5));
					delay.setOnFinished( event -> failStage.close() );
					delay.play();
				}
				
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			iSBNField.clear();
		});
		
		submitButtonHandIn.setOnAction(e -> {
			String ISBN = iSBNField2.getText().toString();
			
			try {
				if (transactions.handlebook(ISBN, loginusername) == 1) {
					transactionTable.setItems(getTransactions(loginusername));
					
					SwitchScenes(scene2);
					
					successStage.setScene(successScene);
					successStage.setTitle("SUCCESS");
					successStage.show();
					
					PauseTransition delay = new PauseTransition(Duration.seconds(1.5));
					delay.setOnFinished( event -> successStage.close() );
					delay.play();
				} else {
					failStage.setScene(failScene);
					failStage.setTitle("FAIL");
					failStage.show();
					
					PauseTransition delay = new PauseTransition(Duration.seconds(1.5));
					delay.setOnFinished( event -> failStage.close() );
					delay.play();
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			iSBNField2.clear();
		});
		
		quitButton.setOnAction(e -> SwitchScenes(scene2));
		quitButton2.setOnAction(e -> {
			if (controller == 1) {
				SwitchScenes(scene2);
			} 
			
			else if (controller == 2) {
				SwitchScenes(adminScene);
			}
		});
		
		stage.setTitle("Epoka Library");
		stage.setScene(imageScene);
		stage.setFullScreen(true);
		stage.setFullScreenExitHint("");
		stage.show();
	}
	
	public void SwitchScenes(Scene scene){
        stage.setScene(scene);
        stage.setFullScreen(true);
        stage.setFullScreenExitHint("");
        stage.show();
    }
	
	public ObservableList<Library> getBooks() throws IOException {
		ObservableList<Library> books = FXCollections.observableArrayList();
		books.addAll(l.getL());
		return books;
	}
	
	public ObservableList<Clients> getAllClients() throws IOException {
		ObservableList<Clients> user = FXCollections.observableArrayList();
		user.addAll(transactions.getC());
		return user;
	}
	
	public ObservableList<Transactions> getTransactions(String username) throws IOException {
		ObservableList<Transactions> tr = FXCollections.observableArrayList();
		
		tra = transactions.countpersontr(username);
		
		for (int i = 0; i < transactions.countLine("Transaction.txt"); i++) {
			tr.addAll(tra[i]);
		}
		return tr;
	}
	
	public ObservableList<Transactions> getAllTransactions() throws IOException {
		ObservableList<Transactions> tr = FXCollections.observableArrayList();
		
		tra = transactions.alltransaction();
		
		for (int i = 0; i < transactions.countLine("Transaction.txt"); i++) {
			tr.addAll(tra[i]);
		}
		return tr;
	}
}