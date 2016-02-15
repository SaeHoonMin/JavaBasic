package com.sist;
import java.util.*;
interface I
{
	void display();
}
class A implements I
{
	public void display()
	{
		System.out.println("A:display() Call..");
	}
}
class B implements I
{
	public void display()
	{
		System.out.println("B:display() Call..");
	}
}
class C implements I
{
	public void display()
	{
		System.out.println("C:display() Call..");
	}
}
class Container
{
	Map<String,I> map=new HashMap<String,I>();
	public Container()
	{
		map.put("a", new A());
		map.put("b", new B());
		map.put("c", new C());
	}
	public I getBean(String key)
	{
		return map.get(key);
	}
}
public class MainClass3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Container c=new Container();
        I i=c.getBean("a");
        i.display();
        i=c.getBean("b");
        i.display();
        i=c.getBean("c");
        i.display();
	}

}
