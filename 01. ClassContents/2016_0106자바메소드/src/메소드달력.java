/*
 *    1) 년도,월 입력 
 *    2) 요청한 달에 1일자의 요일 
 *       => 1.1월 1일~입력한 달의 1일 => 총날수 
 *       => 윤년 
 *       => 각달의 마지막 날
 *    3) 1일 출력 
 */
import java.util.Scanner;
public class 메소드달력 {
    // 입력 
	static int dayInput()
	{
		Scanner scan=new Scanner(System.in);
		return scan.nextInt();
	}
	// 윤년
	static boolean isYear(int year)
	{
		boolean bCheck=false;
		if((year%4==0 && year%100!=0)||(year%400==0))
              bCheck=true;
		return bCheck;
	}
	// 각달의 마지막 날
	static int lastDay(int year,int month)
	{
		int[] day={31,28,31,30,31,30,
				   31,31,30,31,30,31};
		if(isYear(year))
			day[1]=29;
		else
			day[1]=28;
		return day[month-1];
	}
	// 요일을 구한다
	static int getWeek(int year,int month)
	{
		int week=0;
		// 전년도 총 날수를 구한다
		int total=(year-1)*365
				 +(year-1)/4
				 -(year-1)/100
				 +(year-1)/400;
		// 전달 
		for(int i=1;i<month;i++)
		{
			total+=lastDay(year, i);
		}
		total++;
		week=total%7;
		return week;
	}
	static void dayPrint(int year,int month)
	{
		System.out.println(year+"년도 "+month+"월");
		char[] strWeek={'일','월','화','수','목','금','토'};
		for(int i=0;i<7;i++)
		{
			System.out.print(strWeek[i]+"\t");
		}
		System.out.println();
		int week=getWeek(year, month);
		int last=lastDay(year, month);
		for(int i=1;i<=last;i++)
		{
			if(i==1)
			{
				for(int j=0;j<week;j++)
				{
					System.out.print("\t");
				}
			}
			System.out.printf("%2d\t",i);
			week++;
			if(week>6)
			{
				System.out.println();
				week=0;
			}
		}
	}
	// 조립
	static void process()
	{
		System.out.print("년도 입력:");
		int year=dayInput();
		System.out.print("월 입력:");
		int month=dayInput();
		dayPrint(year, month);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        process();
	}

}
