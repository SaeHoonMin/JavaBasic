/*
 *    ���� ���ǹ� 
 *    ����) 
 *        if(���ǹ�)   
 *          ����1
 *        else if(���ǹ�)
 *          ����2
 *        else if(���ǹ�)
 *          ����3
 *        else
 *          ����4
 *          
 *        if(���ǹ�)   
 *          ����1
 *        ========
 *        if(���ǹ�)
 *          ����2
 *        ========
 *        if(���ǹ�)
 *          ����3
 *        
 *        else
 *          ����4
 */

public class ���ǹ�6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int jumsu=85;
        char hak='A';
        if(jumsu>=90)// false
        	hak='A';
        else if(jumsu>=80) //true
        	hak='B';
        else if(jumsu>=70) //true
        	hak='C';
        else if(jumsu>=60) //true
        	hak='D';  // hak='D'
        else //false
        	hak='F';
        System.out.println(hak);
	}

}







