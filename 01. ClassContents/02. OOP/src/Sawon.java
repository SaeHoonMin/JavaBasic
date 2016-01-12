/*
 *     클래스의 구조 
 *     class class_name
 *     {
 *         변수 설정  => 전역변수 (멤버변수) 클래스 멤버 변수
 *         메소드 설정 
 *         main()
 *         {
 *         }
 *     }
 *     클래스의 구성요소 
 *        1) 변수 
 *        2) 메소드 => 연산자+제어문
 *       
 */
public class Sawon {
    static int sabun;// 저장=> 공통사용 (공통변수)
    String name; // 객체변수 => 객체가 생성시마다 각각 생성 변수
    String dept;
    String loc;
    long pay;
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Sawon s=new Sawon();
        // s=> name,dept,loc,pay
        System.out.println("s="+s);
        s.sabun=10;
        s.name="홍길동";
        Sawon s2=s;
        System.out.println("s2="+s2);
        Sawon s1=new Sawon();
        //  int malloc(sizeof(Sawon)) ==> new
        System.out.println("s1="+s1);
        // s1=> name,dept,loc,pay
        s1.sabun=20;
        s1.name="심청이";
        s2.name="춘향이";
        System.out.println("s.sabun:"+s.sabun);
        System.out.println("s.name:"+s.name);
	}

}
