package section10;

import java.text.ChoiceFormat;

public class ChoiceEx {
	public void type1() { //예제 10-16
		double[] limit = {0,60,70,80,90};
		String[] grade = {"F","D","C","B","A"}; //0<=x<60 F, 60<=x<70 D
		int[] scores = {100,99,80,70,78,55,60,65};
		
		ChoiceFormat cf = new ChoiceFormat(limit, grade);
		for(int i=0 ; i<scores.length; i++) {
			String fmt = String.format("%d : %s", scores[i], cf.format(scores[i]));
			System.out.println(fmt);
		}
	}
	
	public void type2() { //예제 10-17
		String pattern = "0#F|60#D|70#C|80#B|90#A";
		double[] scores = {100,99,80,70,78,55,60,65,79.9};
		
		ChoiceFormat cf = new ChoiceFormat(pattern);
		for(int i=0; i<scores.length; i++) {
			String fmt = String.format("%3.1f : %s", scores[i], cf.format(scores[i]));
			System.out.println(fmt);
		}
		
	}

	public static void main(String[] args) {
		ChoiceEx ex = new ChoiceEx();
		//ex.type1();
		ex.type2();
	}

}
