package task;

class Exam020402MKY {
	public static void main(String[] args) {
		float x = 2;
		float y = 0.0f;
		
		System.out.println(x/y);
		System.out.println(x%y);
		
		x = 2;
		y = x/0.0f;
		
		System.out.println(x/y);
		System.out.println(x%y);
		
		x = 0.0f;
		y = 0.0f;
		
		System.out.println(x/y);
		System.out.println(x%y);
		
		x = 2/0.0f;
		y = 2.0f;
		
		System.out.println(x/y);
		System.out.println(x%y);
		
		x = 2/0.0f;
		y = 2/0.0f;
		
		System.out.println(x/y);
		System.out.println(x%y);
		
	}

}
