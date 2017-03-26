package vs.test;

import java.util.Date;

public class TestCommon {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Date a = new Date();
		Thread.sleep(3000);
		Date b = new Date();
		System.out.println(b.getTime() - a.getTime());
	}

}
