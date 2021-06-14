package section9;

import java.util.List;
import java.util.StringTokenizer;
import java.util.Vector;

public class TokenEx {
	String source;
	String delim;
	boolean returnDelims;
	public TokenEx(String source, String delim, boolean returnDelims) {
		this.source = source; //this.은 TokenEx가 가진 멤버를 의미
		this.delim = delim;
		this.returnDelims = returnDelims;
	}
	public List<String> getToken(){
		List<String> list = new Vector();
		StringTokenizer st = new StringTokenizer(source, delim, returnDelims);
		while(st.hasMoreTokens()) {
			String t = st.nextToken();
			list.add(t);
			System.out.println(t);
		}
		return list;
	}
	
	public void split(String source, String delim, int limit) {
		String[] r = source.split(delim, limit);
		for(String s : r) {
			System.out.println(s);
		}
	}
	
	
}




