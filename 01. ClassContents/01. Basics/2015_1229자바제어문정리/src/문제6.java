/*
 *    3명 의 국어,영어,수학 점수를 입력받아서 
 *    총점 , 평균, 학점 , 등수를 구해서 출력 
 *    ==========================
 *    국어  영어 수학 총점 평균 학점 등수 
 *    90 = =
 *    80 = =
 *    70 = =
 *    ==========================
 *    
 *    배열 (array)
 *      => 연속적인 메모리 배치
 *      => 같은 데이터형을 모아서 관리 
 *      형식)
 *          데이터형[] 배열명; ==> 권장사항 
 *          데이터형 배열명[]; (c언어)
 *          
 *          예)
 *              int[] a;
 *              a=new int[5];
 *              
 *              ========================
 *                 10   20   30   40   50
 *              ========================
 *               a[0] a[1] a[2] a[3] a[4] ==> 일반 정수와 동일 
 *               *&(a+0)&(a+1)  a+2  a+3 a+4
 *               
 *              ==> 100 
 *             예)
 *                 int[] a={1,2,3,4,5};
 *                 a[0]=10
 *                 1=>10
 */
import java.util.Scanner;
public class 문제6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int[] kor=new int[3];// new => 0
        int[] eng=new int[3];
        int[] math=new int[3];
        int[] total=new int[3];
        double[] avg=new double[3];
        char[] hak=new char[3];
        int[] rank=new int[3];
        // int[][] jumsu=new int[3][7];
        Scanner scan=new Scanner(System.in);
        for(int i=0;i<3;i++)
        {
        	System.out.printf("%d번째 국어점수 입력:",(i+1));
        	kor[i]=scan.nextInt();
        	System.out.printf("%d번째 영어점수 입력:",(i+1));
        	eng[i]=scan.nextInt();
        	System.out.printf("%d번째 수학점수 입력:",(i+1));
        	math[i]=scan.nextInt();
        	
        	total[i]=kor[i]+eng[i]+math[i];
        	avg[i]=total[i]/3.0;
        }
        // 등수
        for(int i=0;i<3;i++)
        {
        	rank[i]=1;
        	for(int j=0;j<3;j++)
        	{
        		if(total[i]<total[j])
        		{
        			rank[i]++;
        		}
        	}
        }
        // 학점
        char score='A';
        for(int i=0;i<3;i++)
        {
        	switch((int)(avg[i]/10))
        	{
        	case 10:
        	case 9:
        		score='A';
        		break;
        	case 8:
        		score='B';
        		break;
        		
        	case 7:
        		score='C';
        		break;
        	case 6:
        		score='D';
        		break;
            default:
            	score='F';
        	}
        	hak[i]=score;
        }
        System.out.printf("%10s%10s%10s%14s%20s%10s%10s\n","국어","영어","수학","총점","평균","학점","등수");
        for(int i=0;i<3;i++)
        {
    	   System.out.printf("%5d%5d%5d%7d%10.2f%5c%5d\n",
    			   kor[i],eng[i],math[i],
    			   total[i],avg[i],hak[i],rank[i]);
        }
	}

}




