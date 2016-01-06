/*
 *   자바 => 반복문 
 *   
 *   for   : 반복 횟수가 지정이 된 경우에 주로 사용 (선조건)
 *   for(조건문) => 1
 *   {
 *     실행문장  => 2
 *   }
 *   while : 반복 횟수가 지정이 없는 경우에 주로 사용(선조건)
 *    => 데이터베이스 ,네트워크 (주로 사용)
 *   while(조건문) => 1
 *   {
 *      실행문장  => 2
 *   }
 *   ======================== 수행을 못할 수도 있다 
 *   do~while : 무조건 한번이상을 수행할 때 사용 (후조건)
 *   do{
 *       실행문장  ==1 
 *   }while(조건문)==2
 *   2 => true ==> 1
 *   
 *   ==> for 문 
 *             1   2    4  
 *   형식) for(초기값;조건식;증가식)
 *        {
 *            반복 실행 문장  3
 *        }
 *        
 *        1 => 2 => 3 => 4
 *             2 => 3 => 4
 *             2 => 3 => 4
 *             2 => 3 => 4
 *             2 => 3 => 4
 *             2번이 false가 되면 for을 중단 
 *        for(int i=1;i<=10;i++)
 *        {
 *             i=1 ==> i<=10 true ==> 문장 수행  (i++)
 *             i=2 ==> i<=10 true ==> 문장 수행  (i++)
 *             i=3 ==> i<=10 true ==> 문장 수행  (i++)
 *             i=4 ==> i<=10 true ==> 문장 수행  (i++)
 *             ..
 *             i=10 ==> i<=10 true ==> 문장 수행  (i++)
 *             i=11 ==> i<=10 false (for종료)
 *        }
 */
public class 반복문1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	   int sum=1;
       for(int i=1;i<=10;i++)
       {
    	   sum*=i;
    	   //System.out.print("i="+i+"\t");
       }
       System.out.println("sum="+sum);
	}

}
