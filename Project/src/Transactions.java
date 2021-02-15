import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;    


public class Transactions extends Clients {
	private int trID ;
	private String ISBN;
	private String username;
	private LocalDateTime take,handle;
	private boolean handleornot = false;
	private Transactions[] t = new Transactions[100];
	
	private String takenTime,handledTime,handledornotString,timeleft;
	private String takenTime2,handledTime2,handledornotString2,timeleft2;
	private Transactions[] personTransactions = new Transactions[100];
	private Transactions[] allTransactions = new Transactions[100];

	
public void arrayInitialize() throws IOException {
	for(int i = 0 ; i < 100 ; i++) {
		t[i] = new Transactions();
	}
}
	
public void updateTransactions() throws IOException {
		
	File trdatabase = new File("Transaction.txt");
	Scanner input = new Scanner(trdatabase);
	arrayInitialize();
	int i =0;
	while(input.hasNext()) {
		//t[i] = new Transactions();
		t[i].trID = input.nextInt();
		t[i].ISBN = input.next();
		t[i].username = input.next();
		String temp = input.next();
		t[i].take = LocalDateTime.parse(temp);
		t[i].handleornot = input.nextBoolean();
		
		if(t[i].handleornot) {
			temp = input.next();
			t[i].handle = LocalDateTime.parse(temp);
		}
		else {
			
		}
		i++;
	}
}
	
	public int takeBook(String ISBN,String username) throws IOException {
		File transactions = new File("Transaction.txt");
		Scanner inputbook = new Scanner(transactions);
		
		int haveornot = -1; // We see if the action is completed
		int i = super.searchISBN(ISBN);
		
		if(i != -1) {
			
			BufferedWriter writer = new BufferedWriter(new FileWriter("Transaction.txt", true));
		    writer.append((countLine("Transaction.txt")+1) + " " + ISBN + " " + username + " " + LocalDateTime.now() + " " + false +   "\n");
		    if(super.getCounter(i) > 0) {
	        super.setCounterDown(i);
		    super.changeDatabase();
		    haveornot = 1;// successful
		    }
		    
		    else {
		    	haveornot = 0; // We don't have more copies of this book
		    }
		    
		    writer.close();
		}
		return haveornot;	
	}
	
	public boolean searchUsername(String username) throws IOException {
		updateTransactions();
		for (int i = 0; i < countLine("Transaction.txt"); i++) {
			if(t[i].username.equals(username)) {
				return true;
			
			}
		}
		return false;
	}
	
	public int handlebook(String ISBN,String username) throws IOException {
		updateTransactions();
		int index = super.searchISBN(ISBN);
		int handleornot = 0;
		int temp=0;
		
		for(int i = 0 ; i < countLine("Transaction.txt") ; i++) {
			if(ISBN.equals(t[i].ISBN) && username.equals(t[i].username) && t[i].handleornot == false) {
				t[i].handleornot = true;
				t[i].handle = LocalDateTime.now();
				temp = t[i].trID;
				handleornot = 1;
				super.setCounterUp(index);
				super.changeDatabase();
				break;
			}
		}
		
		changeTransactionDatabase(temp);
		return handleornot;
	}
	public void changeTransactionDatabase(int trID) throws IOException {
		
		long cnt = countLine("Transaction.txt");
		
		PrintWriter trwriter = new PrintWriter("Transaction.txt");
		 trwriter.print("");
		
		 
		 
		for(int i = 0 ; i < cnt;  i++) {
		if(t[i].handleornot == true && t[i].trID == trID) {
			
		trwriter.print(t[i].trID + " " + t[i].ISBN + " " + t[i].username + " " + t[i].take + " " + t[i].handleornot + " " + t[i].handle +  "\n");
		}
		
		else if (t[i].handleornot == true) {
			trwriter.print(t[i].trID + " " + t[i].ISBN + " " + t[i].username + " " + t[i].take + " " + t[i].handleornot + " " + t[i].handle +  "\n");
		}
		
		else {
			trwriter.print(t[i].trID + " " + t[i].ISBN + " " + t[i].username + " " + t[i].take + " " + t[i].handleornot + "\n");	
		}
	    
		}
		trwriter.close();
	}
	
	public long timeleft(String username,String ISBN) throws IOException {
		long durationtemp = 0;
		updateTransactions();
		for (int i = 0; i < countLine("Transaction.txt"); i++) {
			
			if(t[i].handleornot == false && t[i].username.equals(username) && t[i].ISBN.equals(ISBN)) {
				int index = super.searchISBN(t[i].ISBN);
				
				LocalDateTime shouldhandleDateTime = t[i].take.plusDays(30);
				LocalDateTime nowDateTime = LocalDateTime.now();
				Duration duration = Duration.between(nowDateTime, shouldhandleDateTime);
				durationtemp = duration.toDays();
			}
			
		}
		return durationtemp;
	}
	
	public long timeleft2(int index) throws IOException {
		long durationtemp = 0;
		updateTransactions();
		
			
			if(t[index].handleornot == false) {
				//int index = super.searchISBN(t[i].ISBN);
				
				LocalDateTime shouldhandleDateTime = t[index].take.plusDays(30);
				LocalDateTime nowDateTime = LocalDateTime.now();
				Duration duration = Duration.between(nowDateTime, shouldhandleDateTime);
				durationtemp = duration.toDays();
			}
			
		
		return durationtemp;
	}
	
	
	
	public Transactions[] alltransaction() throws IOException {
		updateTransactions();
		int cnt = 0;
		for (int i = 0; i < countLine("Transaction.txt"); i++) {
			
				allTransactions[i] = new Transactions();
				allTransactions[i].trID = t[i].trID;
				allTransactions[i].ISBN = t[i].ISBN;
				allTransactions[i].username = t[i].username;
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
				String takenTime = t[i].take.format(formatter);
				allTransactions[i].takenTime = takenTime;
				
				if(t[i].handleornot == true) {
					allTransactions[i].handledornotString = "Handled";
					
					String handledTime = t[i].handle.format(formatter);
					allTransactions[i].handledTime = handledTime;
					allTransactions[i].timeleft = "";
				}
				else {
					allTransactions[i].handledornotString = "Not Handled";
					long temp = timeleft2(i) ;
					allTransactions[i].timeleft = Long.toString(temp);
					allTransactions[i].handledTime = "----------";
				}
					
				cnt++;	
			
			
		
		
		}
		
		return allTransactions;
	}
	
	public Transactions[] countpersontr(String username) throws IOException {
		updateTransactions();
		int cnt = 0;
		for (int i = 0; i < countLine("Transaction.txt"); i++) {
			if(t[i].username.equals(username)) {
				personTransactions[cnt] = new Transactions();
				personTransactions[cnt].trID = t[i].trID;
				personTransactions[cnt].ISBN = t[i].ISBN;
				personTransactions[cnt].username = t[i].username;
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
				String takenTime = t[i].take.format(formatter);
				personTransactions[cnt].takenTime = takenTime;
				
				if(t[i].handleornot == true) {
					personTransactions[cnt].handledornotString = "Handled";
					
					String handledTime = t[i].handle.format(formatter);
					personTransactions[cnt].handledTime = handledTime;
					personTransactions[cnt].timeleft = "";
				}
				else {
					personTransactions[cnt].handledornotString = "Not Handled";
					long temp = timeleft(username, t[i].ISBN) ;
					personTransactions[cnt].timeleft = Long.toString(temp);
					personTransactions[cnt].handledTime = "----------";
				}
					
				cnt++;	
			}
			
		}
		return personTransactions;
	}
	
	
	public String getTakenTime() {
		return takenTime;
	}

	public void setTakenTime(String takenTime) {
		this.takenTime = takenTime;
	}

	public String getHandledTime() {
		return handledTime;
	}

	public void setHandledTime(String handledTime) {
		this.handledTime = handledTime;
	}

	public String getHandledornotString() {
		return handledornotString;
	}

	public void setHandledornotString(String handledornotString) {
		this.handledornotString = handledornotString;
	}

	public String getTimeleft() {
		return timeleft;
	}

	public void setTimeleft(String timeleft) {
		this.timeleft = timeleft;
	}

	public Transactions[] getPersonTransactions() {
		return personTransactions;
	}

	public void setPersonTransactions(Transactions[] personTransactions) {
		this.personTransactions = personTransactions;
	}

	public Transactions[] getT() throws IOException {
		asa();
		updateTransactions();
		return t;
	}

	public int getTrID() {
		return trID;
	}

	public void setTrID(int trID) {
		this.trID = trID;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public LocalDateTime getTake() {
		return take;
	}

	public void setTake(LocalDateTime take) {
		this.take = take;
	}

	public LocalDateTime getHandle() {
		return handle;
	}

	public void setHandle(LocalDateTime handle) {
		this.handle = handle;
	}

	public boolean isHandleornot() {
		return handleornot;
	}

	public void setHandleornot(boolean handleornot) {
		this.handleornot = handleornot;
	}
}



