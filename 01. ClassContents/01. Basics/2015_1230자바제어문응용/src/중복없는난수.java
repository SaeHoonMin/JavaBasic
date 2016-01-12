/*
 *    1~10 난수 발생 => 중복없는 난수 발생 
 *    1) 난수 발생 
 *    2) 난수가 중복이 있는지 여부 확인 
 *    3) 중복(O) => 난수 발생 
 *       중복(X) => 저장
 *       
 *       => 1) 10개변수 => 배열
 *          2) 난수저장 
 *          3) 중복체크 
 *          char c='A'
 *          for(int i=0;i<3;i++)
 *          {
 *             c='A';
 *             for(int j=0;j<3;j++)
 *             {
 *                c++;
 *             }
 *          }
 *          
 *          i=0 ==> j=0
 *          i=1 ==> j=0
 *          i=2 ==> j=0
 */
public class 중복없는난수 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        // 중복없는 데이터를 저장하는 변수 
		int[] arr=new int[10];
		// 난수
		int su=0;
		// 중복여부 확인 
		boolean bDash=true;
		/*
		 *    arr[0]=5;
		 *    arr[1]=4;
		 *    arr[2]=4
		 *    su=4
		 */
		for(int i=0;i<10;i++)
		{
			// 중복이 없는 난수가 발생할때까지 루프
			bDash=true;
			while(bDash)
			{
				// 난수발생
				su=(int)(Math.random()*10)+1;
				// 중복체크
				bDash=false;
				for(int j=0;j<i;j++)
				{
					if(arr[j]==su)
					{
						bDash=true;
						break; // while(조건문)
					}
					/*else
					{
						bDash=false;
						break;
					}*/
				}
			}
			arr[i]=su;
		}
		// 출력
		for(int i=0;i<10;i++)
		{
			System.out.print(arr[i]+" ");
		}
	}

}





