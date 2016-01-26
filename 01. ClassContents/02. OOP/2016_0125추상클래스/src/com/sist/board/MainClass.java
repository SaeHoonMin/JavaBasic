package com.sist.board;

public class MainClass {

	public static void main(String[] args) 
	throws Exception
	{
		// TODO Auto-generated method stub
                 /* 게시판 board=new 답변형게시판();
        board.write();
        board=new 댓글형게시판();
        board.write();
        board=new 갤러리게시판();
        board.write();*/
		Class clsName=Class.forName("com.sist.board.답변형게시판");
		답변형게시판 rb=(답변형게시판)clsName.newInstance();
		rb.write();
		
	}

}
