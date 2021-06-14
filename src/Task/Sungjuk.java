package Task;

public class Sungjuk {
	public static void main(String[] args) {
		Student student=null;
		Teacher teacher=new Teacher();		
		student=new Student(100, 100, 100);		
		teacher.totalAvg(student);
		student.outputMethod();
		
		student=new Student(20, 20, 20);		
		teacher.totalAvg(student);
		student.outputMethod();
		
		student=new Student(30, 30, 30);		
		teacher.totalAvg(student);
		student.outputMethod();
		
		student=new Student(40, 40, 40);		
		teacher.totalAvg(student);
		student.outputMethod();
		
		student=new Student(50, 50, 50);		
		teacher.totalAvg(student);
		student.outputMethod();	 	
	}
}

class Student{
	int kor;
	int eng;
	int math;
	int total;
	double avg;
	
	Student(int kor, int eng, int math){
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	void outputMethod() {
		System.out.println(""+kor+" "+eng+" "+math+" "+total+" "+avg);
	}
}

class Teacher{
	void totalAvg(Student student) {
		Student tmp=student;
		tmp.total = tmp.kor+tmp.eng+tmp.math;
		tmp.avg = tmp.total/3.0;
	}
	void outputMethod(Student student) {
		Student tmp=student;
		System.out.println(""+tmp.kor+" "+tmp.eng+" "+
		tmp.math+" "+tmp.total+" "+tmp.avg);	
	}
}

