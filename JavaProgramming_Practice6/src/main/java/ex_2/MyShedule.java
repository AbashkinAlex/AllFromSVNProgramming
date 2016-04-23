package ex_2;

import java.util.Map;
import java.util.Map.Entry;

public class MyShedule implements Runnable {

	public MyShedule() {
		Thread th = new Thread(this);
		th.start();
	}

public void table(Map<Integer, String> map) {
		for (Entry<Integer, String> table : map.entrySet()) {
			try {
				Thread.sleep(table.getKey());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(table.getValue());
		}
	}

	@Override
	public void run() {

		
	}
}
