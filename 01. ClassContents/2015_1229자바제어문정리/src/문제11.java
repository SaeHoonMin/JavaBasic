// 10명 점수 저장 ==> 총합 , 평균,최대 ,최소
public class 문제11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int[] student=new int[10];
        int hap=0;
        double avg=0.0;
        int max=0;
        int min=100;
        // 점수 입력 
        for(int i=0;i<10;i++)
        {
        	student[i]=(int)(Math.random()*101);
        	// 0~100난수 발생 
        	hap+=student[i];
        }
        avg=hap/10.0;
        for(int i=0;i<10;i++)
        {
        	if(max<student[i])
        		max=student[i];
        	if(min>student[i])
        		min=student[i];
        }
        // 출력
        System.out.println("총합:"+hap);
        System.out.println("평균:"+avg);
        System.out.println("최고점:"+max);
        System.out.println("최하점:"+min);
	}

}



