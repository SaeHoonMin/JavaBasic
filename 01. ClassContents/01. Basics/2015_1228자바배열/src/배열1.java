/*
 *   배열 
 *    = 같은 데이터형의 변수를 모아서 관리 
 *      변수(한옥집) , 배열 (아파트)
 *    = 일반 변수 : 변수(5)
 *      변수명 5개  int a=1,int b=2,int c=3,int d=4,int e=5
 *      배열은 1개의 배열명으로 여러개 데이터 처리
 *      연속적으로 메모리 배치 (관리가 쉽다)
 *      
 *      1) 형식
 *         int[] 배열명={1,2,3,4,5};
 *        데이터형
 *        int[] a={1,2,3,4,5}
 *        =========================
 *          1    2    3    4    5
 *        =========================
 *         a[0] a[1] a[2] a[3] a[4] ==> 일반 변수와 동일 
 *      
 */

public class 배열1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int a1=(int)(Math.random()*45)+1;
        int a2=(int)(Math.random()*45)+1;
        int a3=(int)(Math.random()*45)+1;
        int a4=(int)(Math.random()*45)+1;
        int a5=(int)(Math.random()*45)+1;
        int a6=(int)(Math.random()*45)+1;
        System.out.println("첫번째 번호:"+a1);
        System.out.println("두번째 번호:"+a2);
        System.out.println("세번째 번호:"+a3);
        System.out.println("네번째 번호:"+a4);
        System.out.println("다섯번째 번호:"+a5);
        System.out.println("여섯번째 번호:"+a6);
        
        int[] arr=new int[6];// 0으로 초기화
        for(int i=0;i<6;i++)
        {
        	arr[i]=(int)(Math.random()*45)+1;
        	System.out.println(arr[i]);
        }
	}

}






