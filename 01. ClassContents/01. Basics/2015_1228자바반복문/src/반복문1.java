/*
 *    반복문 
 *     = for : 지정된 횟수
 *       형식)
 *                1    2    4
 *           for(초기값;조건식;증가식)
 *                실행문장  3
 *                1-2-3-4
 *                  2-3-4
 *                  2-3-4
 *                  2=> false면 종료 
 *           for(int i=1;i<=10;i++)
 *           {
 *              System.out.println("i="+i);
 *           }
 *           for(;;) => 무한 루프 (break)
 *     = while : 지정이 없는 횟수
 *         형식) 
 *              초기값  ===> 1
 *              while(조건식) ==> 2
 *              {
 *                  실행문장; ==> 3 
 *                  증가식; ==> 4
 *              }
 *              1-2-3-4
 *                4==> 2-3-4
 *                4==> 2-3-4
 *                2번이 false면 종료 
 *           int i=1;
 *           while(i<=10)
 *           {
 *              System.out.println("i="+i);
 *              i++;
 *           }
 *           ==> 무한 루프 
 *           while(true)
 *           {
 *           }  ==> break
 *     = do~while : 한번이상 수행
 *        형식)
 *            초기값   ===> 1
 *            do
 *            {
 *               반복 수행문장; ==> 2
 *               증가식 ==> 3
 *            }while(조건식); ==> 
 *            
 *            int i=1;
 *            do
 *            {
 *               System.out.println("i="+i);
 *               i++;
 *            }while(i<=10);
 */
public class 반복문1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        System.out.println("For문 수행");
        for(int i=1;i<=10;i++)
        {
        	System.out.print(i+"\t");
        }
        System.out.println();
        System.out.println("While문 수행");
        int i=1;
        while(i<=10)
        {
        	System.out.print(i+"\t");
        	// tab (일정 간격) => \t
        	// ln => \n (new Line) 다음줄에 출력 
        	i++;
        }
        System.out.println();
        System.out.println("Do~While문 수행");
        i=1;
        do
        {
        	System.out.print(i+"\t");
        	i++;
        }while(i<=10);
	}

}





