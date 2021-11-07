package Task;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternEx {
	public boolean hangulCheck(String hangul) {
		boolean b = false;
		String reg = "^[°¡-ÆR\\s]*$";
		Pattern p = Pattern.compile(reg);
		Matcher m = p.matcher(hangul);
		b = m.matches();
		return b;
	}
}
