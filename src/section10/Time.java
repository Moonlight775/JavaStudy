package section10;
import java.text.SimpleDateFormat;
import java.util.Date;
public class Time {
	String frm = "yyyy-MM-dd(E) hh:mm:ss:SS";
	SimpleDateFormat sdf;
	// ��-��-��(����) ��:��:��
	public String getTime() {
		String r = null;
		sdf = new SimpleDateFormat(frm);
		r = sdf.format(new Date());
		return r;
	}
	
	public static void main(String[] abc) {
		Time t = new Time();
		String str = t.getTime();
		System.out.println(str);
	}
	
}
