package com.sist.board;

public class MainClass {

	public static void main(String[] args) 
	throws Exception
	{
		// TODO Auto-generated method stub
                 /* �Խ��� board=new �亯���Խ���();
        board.write();
        board=new ������Խ���();
        board.write();
        board=new �������Խ���();
        board.write();*/
		Class clsName=Class.forName("com.sist.board.�亯���Խ���");
		�亯���Խ��� rb=(�亯���Խ���)clsName.newInstance();
		rb.write();
		
	}

}
