package com.server;
import com.common.Function;
/*
 *   패키지가 다르면 public외는 접근이 불가능하다 
 */
public class Server {
   public void start()
   {
	   System.out.println("서버 실행...");
   }
   public void accept()
   {
	   System.out.println("클라이언트 접속...");
   }
   public void readwrite(int type)
   {
	   switch(type)
	   {
	   case Function.LOGIN:
		   System.out.println("로그인 처리 완료");
		   break;
	   case Function.MAKEROOM:
		   System.out.println("방만들기 처리 완료");
		   break;
	   case Function.GAME:
		   System.out.println("게임 신청 처리 완료");
		   break;
	   case Function.CHATMESSAGE:
		   System.out.println("채팅 처리 완료");
		   break;
	   case Function.CHATEND:
		   System.out.println("종료");
		   break;
	   }
   }
   public void end()
   {
	   System.out.println("서버 종료");
   }
}
