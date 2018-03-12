package pl.scartout;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import com.google.common.base.Preconditions;

public class Calculator {

	public String count(int num) {
		
		Preconditions.checkArgument(num>=0, "Argument must be greater than 0");
		Preconditions.checkArgument(num<=999999999, "Argument must be in the range of Integer");
		
	    String hex = Integer.toHexString(num);   
	    
	    StringBuilder result = new StringBuilder(hex);
	    
	    for (int i=0; i<4-hex.length(); i++){
	    	result = result.insert(0, "0");
	    }
	    
	    result = result.insert(0, "P");
	    
	    StringSelection stringSelection = new StringSelection(result.toString());
	    Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
	    clpbrd.setContents(stringSelection, null);
	    
	    return result.toString();
	}
	
	public static void main(String[] args) {

		new SimpleJButton();
		
	}

}
