package com.sist2;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Container c=new Container();
        I i=c.getBean("a");
        i.display();
        i=c.getBean("c");
	}

}
