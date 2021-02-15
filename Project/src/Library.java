import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.BreakIterator;
import java.util.Scanner;


import java.util.ArrayList;
import java.util.Arrays;


public class Library {
	private String name,author, year;
	private int bookcounter;
	private String ISBN,bookcounter1;
	private  Library[] l = new Library[100];
	
	public Library() {
		
	}
	
	public Library(int a) {
		for(int i = 0 ; i< l.length;i++)
			this.l[i] = new Library();
	}
	
	public void updateLibrary() throws FileNotFoundException {
		
		File bookdatabase = new File("Book Database.txt");
		Scanner inputbook = new Scanner(bookdatabase);
		String tempString;
		inputbook.useDelimiter(";");
		int i = 0;
		while(inputbook.hasNext()) {
			
			l[i].name = inputbook.next();
			l[i].author = inputbook.next();
			l[i].ISBN = inputbook.next();
			l[i].year = inputbook.next();
			tempString = inputbook.next();
			l[i].bookcounter1 = tempString;
			l[i].bookcounter = Integer.parseInt(tempString);
			i++;
		
	}
		
	}
	
	public void addBooks(String name,String author,String ISBN,String year,int bookcounter) throws IOException {
		asa();
		updateLibrary();
		long temp = countLine("Book Database.txt");
		int index = (int) temp;
		int parameter=0;
		if(searchISBN(ISBN) == -1) {
		l[index].name = name;
		l[index].author = author;
		l[index].ISBN = ISBN;
		l[index].year = year;
		l[index].bookcounter = bookcounter;
		parameter = 1;
		}
		
		else {
			setCounterUp(searchISBN(ISBN),bookcounter);
			parameter=2;
		}
		
		changeDatabase(parameter);
		
		
		
	}
	
	public void changeDatabase(int temp) throws IOException {
		long linecnt = countLine("Book Database.txt");
		
		PrintWriter bookwriter = new PrintWriter("Book Database.txt");
		 bookwriter.print("");
		
		if(temp == 2) {
			for(int i = 0 ; i < linecnt ; i++) {
				
				bookwriter.print(l[i].name + ";" + l[i].author + ";" + l[i].ISBN + ";" + l[i].year + ";" + l[i].bookcounter + ";");
				}
		}
		else {
			for(int i = 0 ; i < linecnt + 1 ; i++) {
				if(i<linecnt) {
					bookwriter.print(l[i].name + ";" + l[i].author + ";" + l[i].ISBN + ";" + l[i].year + ";" + l[i].bookcounter + ";");
				}
				else {
					bookwriter.print("\n" + l[i].name + ";" + l[i].author + ";" + l[i].ISBN + ";" + l[i].year + ";" + l[i].bookcounter + ";");
				}
				}
			
		}
		
		bookwriter.close();
	}
	
	public void changeDatabase() throws IOException {
		long linecnt = countLine("Book Database.txt");
		
		PrintWriter bookwriter = new PrintWriter("Book Database.txt");
		 bookwriter.print("");
		
		
		for(int i = 0 ; i < linecnt ; i++) {
		
		bookwriter.print(l[i].name + ";" + l[i].author + ";" + l[i].ISBN + ";" + l[i].year + ";" + l[i].bookcounter + ";");
		
	    
		}
		bookwriter.close();
	}
	
	public boolean searchAuthor(String author1) throws IOException {
		updateLibrary();
		
		for (int i = 0; i < countLine("Book Database.txt"); i++) {
			
			if(author1.equals(l[i].author)) 
				return true;
			}
		
		return false;
		
	}
	
	public void asa() {
		for(int i = 0 ; i < l.length ; i++) {
			l[i] = new Library();
		}
	}
	
	/*public boolean searchISBN(int ISBN) throws IOException {
		updateLibrary();
		for (int i = 0; i < countLine("Book Database.txt"); i++) {
			
			if(ISBN==(l[i].ISBN)) 
				return true;
			}
		
		return false;
		
	}*/
	
	public int searchISBN(String ISBN) throws IOException {
		asa();
		updateLibrary();
		
		for (int i = 0; i < countLine("Book Database.txt"); i++) {
			
			if(ISBN.equals(l[i].ISBN)) {
				return i;}
			}
		
		return -1;
		
	}
	
	public long countLine(String fileName) throws IOException {

	     int lines = 0;
	     BufferedReader reader = new BufferedReader(new FileReader(fileName)); {
	          while (reader.readLine() != null) lines++;
	      } 
	      return lines;

	  }
	
	
	public String getBookname(int index) {
		return l[index].name;
	}
	
	public Library[] getL() throws FileNotFoundException {
		asa();
		updateLibrary();
		return l;
	}
	
	public int getBookcounter() {
		return bookcounter;
	}

	public void setBookcounter(int bookcounter) {
		this.bookcounter = bookcounter;
	}

	public String getBookcounter1() {
		return bookcounter1;
	}

	public void setBookcounter1(String bookcounter1) {
		this.bookcounter1 = bookcounter1;
	}

	public String getName() {
		return name;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public String getISBN() {
		return ISBN;
	}
	
	public String getYear() {
		return year;
	}
	
	public int getCounter(int i) {
		return l[i].bookcounter;
	}
	
	public int getCounter() {
		return bookcounter;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public void setISBN(String ISBN) {
		this.ISBN = ISBN;
	}
	
	public void setYear(String year) {
		this.year = year;
	}
	public void setCounterDown( int i) throws FileNotFoundException {
		updateLibrary();
		this.l[i].bookcounter = this.l[i].bookcounter - 1;
		
	}
	
	public void setCounterUp( int i) throws FileNotFoundException {
		updateLibrary();
		this.l[i].bookcounter = this.l[i].bookcounter + 1;
		
	}
	
	public void setCounterUp( int i,int counter) throws FileNotFoundException {
		updateLibrary();
		this.l[i].bookcounter = this.l[i].bookcounter + counter;
		
	}
}



