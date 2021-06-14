package section9;

import java.util.List;
import java.util.ArrayList;
public class WrapperEx {
	//Integer autoBox(), int autoUpbox()메서드 추가
	
	Integer autoBox() {
		int a=10;
		return a; //retrun new Integer(a);
	}
	
	int autoUpbox() {
		Integer i = new Integer(10);
		return i;	
	}
	
	public List getList() {
		List<Integer> abc = new ArrayList<Integer>(); 
		abc.add(10);
		
		return abc;
	}
	
}
