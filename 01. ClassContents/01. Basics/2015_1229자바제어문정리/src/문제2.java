/*
 *    2. ������ ���� �Է¹޾Ƽ� Ȧ��,¦�� Ȯ�� 
 *    => ���ǹ� 
 *       ���� IF
 *         = ����) 
 *               if(���ǹ�)
 *                 ����       => 
 *               1) ���� Ȯ��  true�� ������ ����
 *                  false�� ������ �������� �ʴ´� 
 *               ***** ��� ����� �ٷ� �ؿ� �ִ� ���常 ��� �Ѵ� 
 *               ==> �������� ������ ���� ó���ÿ��� 
 *                   �ݵ�� {}�� ����Ѵ� 
 *       ���� IF
 *               ����) 
 *                   if(���ǹ�)
 *                   {
 *                     ����
 *                     ���� 
 *                   }
 *                   else
 *                     ���� 
 *                     
 *                  => ���ǹ��� true if�� ���� ����
 *                     false�� else�� ������ ���� 
 *       ���� IF
 *           if(���ǹ�)
 *           {
 *              true=>������ ������ ����
 *              false=> ������ if�� ������ ����
 *           }
 *           else if(���ǹ�)
 *           {
 *              true=>������ ������ ����
 *              false=> ������ if�� ������ ����
 *           }
 *           else if(���ǹ�)
 *           {
 *              true=>������ ������ ����
 *              false=> ������ if�� ������ ����
 *           }
 *           else
 *           {
 *               �´� ������ ������ else������ �����Ѵ� 
 *               
 *           }
 *           
 */
import java.util.Scanner;
public class ����2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner scan=new Scanner(System.in);
        System.out.print("���� �Է�:");
        int num=scan.nextInt();
        // ó�� => ����� ��� 
        if(num%2==0)
        	System.out.println(num+"��(��) ¦��");
        else
        	System.out.println(num+"��(��) Ȧ��");
	}

}








