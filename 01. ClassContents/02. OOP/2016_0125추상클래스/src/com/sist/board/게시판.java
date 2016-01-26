package com.sist.board;
/*
 *   추상 클래스 
 *     : 공통으로 적용되는 메소드 선언 
 *     : 다른 내용으로 구현해서 사용
 *     : 서로 다른 클래스를 묶어서 사용 
 *     : 단일 상속을 기본으로 한다  
 *     형식) 
 *         접근지정어 abstract class className
 *         
 *     기능 
 *      = 글쓰기 
 *      = 목록 출력 
 *      = 내용보기 
 *      = 찾기
 *      = 수정
 *      = 삭제 
 *      
 *      =============
 *      답변형 게시판 
 *      = 글쓰기 
 *      = 목록 출력 
 *      = 내용보기 
 *      = 찾기
 *      = 수정
 *      = 삭제 
 *      *** 답변주기 (추가)
 *      
 *      ==============
 *      댓글형 게시판 
 *      = 글쓰기 
 *      = 목록 출력 
 *      = 내용보기 
 *      = 찾기
 *      = 수정
 *      = 삭제 
 *      *** 댓글 추가 
 *      ==============
 *      갤러리 게시판 
 *      
 *      = 글쓰기 
 *      = 목록 출력 
 *      = 내용보기 
 *      = 찾기
 *      = 수정
 *      = 삭제 
 *      *** 그림 업로드 (추가)
 *         
 */
public abstract class 게시판 {
    public abstract void write();
    public abstract void list();
    public abstract void content();
    public abstract void find();
    public abstract void modify();
    public abstract void delete();
}









