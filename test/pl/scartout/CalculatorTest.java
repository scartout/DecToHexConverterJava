package pl.scartout;

import org.junit.Test;
import static org.assertj.core.api.Assertions.*;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

public class CalculatorTest {

	  public String getClipboardContents() {
		    String result = "";
		    Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		    Transferable contents = clipboard.getContents(null);
		    boolean hasTransferableText =
		      (contents != null) &&
		      contents.isDataFlavorSupported(DataFlavor.stringFlavor);
		    if (hasTransferableText) {
		      try {
		        result = (String)contents.getTransferData(DataFlavor.stringFlavor);
		      }
		      catch (IOException ex){
		        System.out.println(ex);
		        ex.printStackTrace();
		      } catch (UnsupportedFlavorException e) {
				e.printStackTrace();
			}
		    }
		    return result;
		  }
	
	@Test
	public void test1() {
		Calculator calculator = new Calculator();
		assertThat(calculator.count(268)).isEqualTo("P010c");
	}
	
	@Test
	public void test2() {
		Calculator calculator = new Calculator();
		assertThat(calculator.count(0)).isEqualTo("P0000");
	}
	
	@Test
	public void test3() {
		Calculator calculator = new Calculator();
		assertThat(calculator.count(2599)).isEqualTo("P0a27");
	}
	
	@Test
	public void test4() {
		Calculator calculator = new Calculator();
		assertThat(calculator.count(2599000)).isEqualTo("P27a858");
	}
	
	@Test
	public void test5() {
		Calculator calculator = new Calculator();
		assertThat(calculator.count(999999999)).isEqualTo("P3b9ac9ff");
	}
	
	@Test
	public void test6() {
		Calculator calculator = new Calculator();
		calculator.count(2599);
		assertThat(getClipboardContents()).isEqualTo("P0a27");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test7() {
		Calculator calculator = new Calculator();
		calculator.count(-1);
	}

}
