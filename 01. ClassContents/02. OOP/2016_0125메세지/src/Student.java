
public class Student {
    private int hakbun;
    private String name;
    private String sex;
    private String subject;
    private int kor;
    private int math;
    private int eng;
	public int getHakbun() {
		return hakbun;
	}
	public void setHakbun(int hakbun) {
		this.hakbun = hakbun;
		// 멤버변수     지역변수 
		// this는 생략이 가능하다 => 지역변수와 같은 이름이면 생략할 수 없다
		// this : 자신을 나타내주는 객체명 
		/*
		 *  this => 생성되는 시점 
		 *     Student s=new Student();
		 *     this=s; (JVM)
		 *     사용위치 
		 *       => 멤버메소드안에서,
		 *          생성자에서만 사용이 가능하다 
		 */
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	   
   // 읽기,쓰기 
   
   
}
