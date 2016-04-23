package ex_3;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.logging.Logger;

public class FindTxt implements Runnable {

    private String name;
    private Thread thread;
    private static int count = 0;
    private static File log = null;
    
    public FindTxt(String name) {
       setName(name);
        this.thread = new Thread(this);
        this.thread.start();
    
    }

    public void writeLog(String text){
		count++;
		
		if (count<2){
			log = new File("Log.log");
		}
		
		synchronized (log) {
			
		try (BufferedWriter bw = new BufferedWriter( new FileWriter(log,true))){		
			bw.write(text);	
			bw.newLine();
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void run() {

		File dir = new File (name);
		String[] s = dir.list();
		
		for (String string : s) {
			
			String put1 = null;
			put1 = (name + "\\" + string);
			File f = new File (put1);
			if(f.isFile()){
				if (put1.endsWith(".txt")) {
					 writeLog(put1);
				}
			}
			
			if(f.isDirectory()) {
				new FindTxt(put1);
			}
		}

	}

}


