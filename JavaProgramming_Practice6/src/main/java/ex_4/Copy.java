package ex_4;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Copy implements Runnable{

	private String whence;
	private String where;

	
	public Copy(String whence, String where) {

		   File f = new File(where);		   
		  
		   if (!(f.exists())) { 
			   f.mkdirs();
		   }
		   
		   setWhence(whence);
	       setWhere(where);

	       Thread th = new Thread(this);
	       th.start();
	    
	    }
	
		
	public String getWhence() {
		return whence;
	}

	public void setWhence(String whence) {
		this.whence = whence;
	}

	public String getWhere() {
		return where;
	}

	public void setWhere(String where) {
		this.where = where;
	}

	
	//~~~~~~~~~~~~~~~~~ Метод Copy ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	public static void copy(File source, File dest) throws IOException {
        FileInputStream is = new FileInputStream(source);
        try {
            FileOutputStream os = new FileOutputStream(dest);
            try {
                byte[] buffer = new byte[4096];
                int length;
                while ((length = is.read(buffer)) > 0) {
                    os.write(buffer, 0, length);
                }
            } finally {
                os.close();
            }
        } finally {
            is.close();
        }
    }

	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	
	@Override
	public void run() {
				
		File dir = new File (whence);
		File dir1 = new File (where);
				
		String[] s = dir.list();
		
		for (String string : s) {
			
			String pathWhence = null;
			String pathWhere = null;
			
			pathWhence = (whence + "/" + string);
			pathWhere = (where + "/" + string);
			
			File f = new File (pathWhence);
			File f2 = new File (pathWhere);
			
			if(f.isFile()){
				try {
						copy(f, f2);
					} catch (IOException e) {
						e.printStackTrace();
					}
			}
	
			if(f.isDirectory()) {
								   
				new Copy(pathWhence, pathWhere);
			}
		}
	}
}
