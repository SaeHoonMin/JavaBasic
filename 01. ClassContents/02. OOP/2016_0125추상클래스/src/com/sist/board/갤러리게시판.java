package com.sist.board;

public class 갤러리게시판  extends 게시판{

	@Override
	public void write() {
		// TODO Auto-generated method stub
		upload();
		System.out.println("글쓰기를 한다");
	}

	@Override
	public void list() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void content() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void find() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modify() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}
	
	public void upload()
	{
		System.out.println("그림을 업로드 한다");
	}

}
