import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Clients extends Library {
	private String username,name,surname,password,ID;
	private Clients[] c = new Clients[100];
	static int index;
	
	public void updateclients() throws FileNotFoundException {
		
		File clientdatabase = new File("Clients.txt");
		Scanner inputbook = new Scanner(clientdatabase);
		
		inputbook.useDelimiter(";");
		index = 0;
		String dasdaString;
		int i =0;
		while(inputbook.hasNext()) {
			
			c[i] = new Clients();
			c[i].username = inputbook.next();
			
			
			c[i].name = inputbook.next();
			
			c[i].surname = inputbook.next();
			
			c[i].password = inputbook.next();
			
			c[i].ID = inputbook.next();
		
			
			index++;
			i++;
		}
		
	}
	
	
public boolean searchClients(String username,String password) throws IOException{
	
	updateclients();
		for (int i = 0; i < index; i++) {
			
			if(username.equals(c[i].username) && password.equals(c[i].password) ) 
			
				return true;
			}
		
		return false;
		
	}
	

	public boolean searchUsername(String username)throws NullPointerException , IOException{
		updateclients();
	for (int i = 0; i < countLine("Clients.txt"); i++) {
		
		if(username.equals(c[i].username) ) 
			
			return true;
		}
	
	return false;
	
}
	
	public void registerClients(String name,String surname, String username, String password, String ID) throws IOException {
	    BufferedWriter writer = new BufferedWriter(new FileWriter("Clients.txt", true));
	    
	    writer.append(username + ';' + name + ';' + surname + ';' + password + ';' + ID+ ";" );

	    writer.close();
	    this.updateclients();
	}
	
	
	public Clients[] getC() throws FileNotFoundException {
		updateclients();
		return c;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setID(String ID) {
		this.ID = ID;
	}
	
	public String getUsername() {
		return username;
	}
	public String getName() {
		return name;
	}
	public String getSurname() {
		return surname;
	}
	public String getPassword() {
		return password;
	}
	public String getID() {
		return ID;
	}	
}