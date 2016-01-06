
public class ¸Þ¼Òµå6 {
    static void a()
    {
    	System.out.println("a() start...");// 2
    	b();
    	System.out.println("a() end...");// 9
    }
    static void b()
    {
    	System.out.println("b() start...");// 3
    	c();
    	System.out.println("b() end...");// 8
    }
    static void c()
    {
    	System.out.println("c() start...");// 4
    	d();
    	System.out.println("c() end...");//7
    }
    static void d()
    {
    	System.out.println("d() start..."); // 5
    	System.out.println("d() end...");//6
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("main() start...");
        a();// 1
        System.out.println("main() end...");
	}

}
