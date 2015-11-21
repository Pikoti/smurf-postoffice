package city;

import letter.Letter;

public class Printer {

	public static void print (Object line) {
		System.out.println(line);
	}
	
	public static void printMailing(Letter<?> letter) {
		print(
		" -> " + letter.getSender() + " mails " +  letter.getDescription() + 
		", " + letter.getContent().getDescription()+ 
		" , to " + letter.getReceiver() + 
		" for a cost of " + letter.getCost() + " euros "
		);
	}
	
	public static void printReception(Letter<?> letter) {
		print(
		" <- " + letter.getReceiver() + " receives a " + letter.getDescription() +
		", " + letter.getContent().getDescription()+
		" , from " + letter.getSender()
		);
	}
}
