package section9;

import java.util.List;
import java.util.ArrayList;

public class WrapperEx {
	// Integer autoBox(), int autoUpBox()메서드 추가
	public Integer autoBox() {
		int a=10;
		return a;
	}
	public int autoUpBox() {
		Integer i = new Integer(10);
		return i;
	}
	
	public List getList() {
		List<Integer> abc = new ArrayList<Integer>(); 
		abc.add(10);
		
		return abc;
	}
}










