/*
 *    1~10 ���� �߻� => �ߺ����� ���� �߻� 
 *    1) ���� �߻� 
 *    2) ������ �ߺ��� �ִ��� ���� Ȯ�� 
 *    3) �ߺ�(O) => ���� �߻� 
 *       �ߺ�(X) => ����
 *       
 *       => 1) 10������ => �迭
 *          2) �������� 
 *          3) �ߺ�üũ 
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
public class �ߺ����³��� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        // �ߺ����� �����͸� �����ϴ� ���� 
		int[] arr=new int[10];
		// ����
		int su=0;
		// �ߺ����� Ȯ�� 
		boolean bDash=true;
		/*
		 *    arr[0]=5;
		 *    arr[1]=4;
		 *    arr[2]=4
		 *    su=4
		 */
		for(int i=0;i<10;i++)
		{
			// �ߺ��� ���� ������ �߻��Ҷ����� ����
			bDash=true;
			while(bDash)
			{
				// �����߻�
				su=(int)(Math.random()*10)+1;
				// �ߺ�üũ
				bDash=false;
				for(int j=0;j<i;j++)
				{
					if(arr[j]==su)
					{
						bDash=true;
						break; // while(���ǹ�)
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
		// ���
		for(int i=0;i<10;i++)
		{
			System.out.print(arr[i]+" ");
		}
	}

}





