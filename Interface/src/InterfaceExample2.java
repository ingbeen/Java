
public class InterfaceExample2 {
    public static void main(String args[]) { 
    	// �������̽��� laendable�� Ŭ������ �����غ���
    	// Ŭ������ �迭�� ���� �޼ҵ带 �����Ų��
    	// ��, Lendable�� checkout, chcekin�� ���� �����ϴ�
        Lendable[] arr = new Lendable[3]; 
        arr[0] = new SeparateVolume("883��", "Ǫ���� ����", "����"); 
        arr[1] = new SeparateVolume("609.2", "����̼���", "���긮ġ"); 
        arr[2] = new AppCDInfo("02-17", "XML�� ���� �ڹ� ���α׷���"); 
        checkOutAll(arr, "������", "20060315");      
    } 
    
    static void checkOutAll(Lendable[] arr, String borrower, String date) { 
        for (int cnt = 0; cnt < arr.length; cnt++) 
            arr[cnt].checkOut(borrower, date);      
    } 
}
