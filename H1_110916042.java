import java.util.Scanner;

class bank extends Exception{
	private static int totalMoney = 0;
	Scanner scr2 = new Scanner(System.in);
	
	public static void deposit() {
		System.out.println("請輸入要存入的金額 :");
		Scanner scr = new Scanner(System.in);
		int tmp = 0;
		try {
			tmp = scr.nextInt();
			if(tmp <= 0) throw new Exception();		//輸入格式不正確
			
		}catch(Exception e){
			System.out.println("請輸入正整數!!");
			deposit();
			return;
		}

		totalMoney = totalMoney + tmp;
		System.out.println("總金額 :" + totalMoney);
	}
	
	public static void withdraw() {
		if(totalMoney == 0) {
			System.out.println("總金額 :" + totalMoney);
			System.out.println("沒有金額可以提出，跳回主選單");
			return;
		}
		System.out.println("請輸入領取金額 :");
		Scanner scr1 = new Scanner(System.in);
		int tmp = 0;
		try {
			tmp = scr1.nextInt();
			if(tmp <= 0 ) throw new Exception();		//輸入格式不正確
			
		}catch(Exception e) {
			System.out.println("請輸入正整數!!");
			withdraw();
			return;
		}
		try {
			if((totalMoney - tmp) < 0) throw new Exception();
		}
		catch(Exception a) {
			System.out.println("餘額不足，請重新輸入");		//餘額不足
			withdraw();
			return;
		}
		totalMoney = totalMoney - tmp;
		System.out.println("總金額 :" + totalMoney);
	}
	
}

class Deposit extends Thread{
	public void run() {		//呼叫Bank裡存錢
		bank.deposit();
	}	
}

class Withdraw extends Thread{
	public void run() {		//呼叫Bank裡領錢
		bank.withdraw();
	}
}

public class H1_110916042 {

	public static void main(String[] args){
		int choice = 0;
		Scanner input = new Scanner(System.in);
		while(true) {	//選擇介面
			System.out.println(" ");
			System.out.println("存錢請輸入 1");
			System.out.println("領錢請輸入 2");
			System.out.println("離開 3");
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
				System.out.println("錯誤輸入，請再次輸入");
				break;
			}
		}
	}
}
