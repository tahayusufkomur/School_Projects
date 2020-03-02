//Taha Yusuf Kömür 150114064
//This is a class which allows us to handle the errors
public class IllegalNameException extends Exception{
	
	public IllegalNameException(String msg) {
		
		System.out.println(msg);
		
	}
	
	public IllegalNameException() {
		
		this(".");
	}

}
