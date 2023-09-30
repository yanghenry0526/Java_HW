import java.util.Scanner;

class bank extends Exception{
	private static int totalMoney = 0;
	Scanner scr2 = new Scanner(System.in);
	
	public static void deposit() {
		System.out.println("�п�J�n�s�J�����B :");
		Scanner scr = new Scanner(System.in);
		int tmp = 0;
		try {
			tmp = scr.nextInt();
			if(tmp <= 0) throw new Exception();		//��J�榡�����T
			
		}catch(Exception e){
			System.out.println("�п�J�����!!");
			deposit();
			return;
		}

		totalMoney = totalMoney + tmp;
		System.out.println("�`���B :" + totalMoney);
	}
	
	public static void withdraw() {
		if(totalMoney == 0) {
			System.out.println("�`���B :" + totalMoney);
			System.out.println("�S�����B�i�H���X�A���^�D���");
			return;
		}
		System.out.println("�п�J������B :");
		Scanner scr1 = new Scanner(System.in);
		int tmp = 0;
		try {
			tmp = scr1.nextInt();
			if(tmp <= 0 ) throw new Exception();		//��J�榡�����T
			
		}catch(Exception e) {
			System.out.println("�п�J�����!!");
			withdraw();
			return;
		}
		try {
			if((totalMoney - tmp) < 0) throw new Exception();
		}
		catch(Exception a) {
			System.out.println("�l�B�����A�Э��s��J");		//�l�B����
			withdraw();
			return;
		}
		totalMoney = totalMoney - tmp;
		System.out.println("�`���B :" + totalMoney);
	}
	
}

class Deposit extends Thread{
	public void run() {		//�I�sBank�̦s��
		bank.deposit();
	}	
}

class Withdraw extends Thread{
	public void run() {		//�I�sBank�̻��
		bank.withdraw();
	}
}

public class H1_110916042 {

	public static void main(String[] args){
		int choice = 0;
		Scanner input = new Scanner(System.in);
		while(true) {	//��ܤ���
			System.out.println(" ");
			System.out.println("�s���п�J 1");
			System.out.println("����п�J 2");
			System.out.println("���} 3");
			choice = input.nextInt();
			
			switch(choice) {
			case 1 :
				Deposit d1 = new Deposit();
				d1.start();		
				try {
					d1.join();
				}catch(InterruptedException e) {}
				break;
			case 2 :
				Withdraw w1 = new Withdraw();
				w1.start();
				try {
					w1.join();
				}catch(InterruptedException e) {}
				break;
			case 3 :
				System.out.println("Thanks for using!");
				System.exit(0);
			default :
				System.out.println("���~��J�A�ЦA����J");
				break;
			}
		}
	}
}
