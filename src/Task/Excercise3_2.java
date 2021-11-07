package task;

class Excercise3_2 {
	public static void main(String[] args) {
		int numOfApples = 123;
		int sizeOfBucket = 10;
		int numOfBucket = (int)Math.ceil((double)numOfApples/sizeOfBucket);
		
		System.out.println("필요한 바구니의 수:"+numOfBucket);
	}

}
