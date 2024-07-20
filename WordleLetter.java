public class WordleLetter {
	private char letter;
	private String color;

	public WordleLetter(char letterIn){
		this.letter = letterIn;
	}

	/*  -----------------------------------------------------------------------
		TODO - include the below code back in once rest of class is implemented. 
		Do not modify this method implementation. 
		-----------------------------------------------------------------------*/ 
	
	public void setColor(String colorIn){
		this.color = colorIn;
	}

	public void setLetter(char letterIn){
		this.letter = letterIn;
	}

	public String getColor(){
		return this.color;
	}

	public char getLetter(){
		return this.letter;
	}

	public String toString() {
		/*	Determine the special characters to add at the beginning of the String
			to change the text color to the right color. */
		String colorCode;
		if(color.equals("green")) {
			colorCode = "\u001B[32m";
		} else if(color.equals("yellow")) {
			colorCode = "\u001B[33m";
		} else {
			colorCode = "\u001B[31m";
		}
	
		/*	These are the special character to add 
			to the end of the String 
			to signify the end of the color change. */
		String resetCode = "\u001B[0m";

		/*  Surround the letter with space characters and with 
			the above color changing special characters. */ 
		return String.format(
			"%s %s %s",
			colorCode, letter, resetCode);
	}

	//Create a method to indicate whether the color attribute has been set yet.
	public boolean isColorSet(){
		return color != null;
	}

	//Create a method to indicate whether the color attribute has been set to "green".
	public boolean isGreen(){
		return "green".equals(this.color);
	}

}
