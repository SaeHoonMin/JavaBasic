// 1~100 짝수의 개수,홀수의 갯수
/*
 *   => 1~100 루프 (반복문) ************ 1) 첫번째 기술 문제
 *      1) for : 반복 횟수 지정
 *      2) while : 반복 횟수가 지정이 없는 경우
 *           => 선조건
 *      3) do~while : 반드시 한번 이상 수행 
 *           => 후조건 
 *     
 */
public class 문제3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int even=0;
        int odd=0;
        for(int i=1;i<=100;i++)
        {
        	if(i%2==0)
        		even++;
        	else
        		odd++;
        }
        System.out.println("짝수 갯수:"+even);
        System.out.println("홀수 갯수:"+odd);
        /*
         *   단항연산자 
         *     = 증감연산자 (++,--)
         *       한개 증가,감소
         *       => 전치 연산자
         *          ++a => 먼저 증가후에 다른 연산 수행
         *          int a=10;
         *          int b=++a;
         *            1) ++a
         *            2) b=a 
         *       => 후치 연산자
         *          a++ => 다른 연산 수행후 증가한다 
         *          int a=10;
         *          int b=a++;
         *          1) b=a
         *          2) a++
         *     = 부정연산자 (!) : boolean 
         *         true => false
         *         false => true
         */
	}

}




