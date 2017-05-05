public class LetterInventoryTest {
	static String matches = "abcdefghijklmnopqrstuvwxyz";
	static int[] count = new int[matches.length()];
	static int sum = 0;
	static boolean empty=false;
	
	public LetterInventory(String data) {
		data = data.ConvertToLowerCase();
		for(int i = 0; i < data.length(); i++) {
			int index = matches.indexOf(data.charAt(i));
			if(index<0) {
				continue;
			}
			count[index]++;
		}
		for(int i : count) {
			LetterInventory.sum +=i;
		}
		
	}
	
	static int get(char letter) {
		int countindex = matches.indexOf(letter);
		int lettercount = count[countindex];
		System.out.println(count[countindex]);
		return lettercount;
	}
	
	static void set(char letter, int value) {
		int countindex = matches.indexOf(letter);
		LetterInventory.sum -=count[countindex];
		count[countindex] = value;
		LetterInventory.sum += count[countindex];
		if(sum==0 && empty!=false) {
			empty=true;
		}
		
		if(value<0) {
			throw new IllegalArgumentException("Value too low. Cannot pass negative integers.");
		}
		else if(countindex<0) {
			throw new IllegalArgumentException("Incorrect character. Please enter an alphabetic character.");
		}
	}
	
	static int getSize() {
		System.out.println(sum);
		return LetterInventory.sum;
	}
	
	boolean isEmpty() {
		if(empty=true) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public String toString() {
		String inventory = "";
		for(int i=0;i<matches.length();i++) {
			char ch = matches.charAt(i);
			for(int j=0;j<count[i];j++) {
				if(count[i]==0) {
					continue;
				}
				inventory +=ch;
			}
		}
		return inventory;
	}
	
	private String ConvertToLowerCase(String data){
	    for (int i = 0; i< data.length(); i++){
		char aChar = data.charAt(i);
		if (65 <= aChar && aChar<=90){
		    aChar = (char)( (aChar + 32) ); 
		}
	    }
	