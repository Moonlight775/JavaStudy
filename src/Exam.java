import book.*;

//public class Exam {
public class Exam extends PublicA{
	public static void main(String[] args) {
		PublicA a = new PublicA();
		a.publicMethodA();
		Exam exam = new Exam();
		exam.protectedMethodA();
		
		C c = new C();
		c.publicMethodA();
	}
}

class C extends PublicA{}//상속; 자손, 부모보다 제한자의 확장 불가
