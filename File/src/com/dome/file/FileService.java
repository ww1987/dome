package com.dome.file;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import android.content.Context;
import android.os.Environment;

public class FileService {
	
	private Context context;
	
	
	

	public FileService(Context context) {
		this.context = context;
	}

	public void writeFileToSDCard(String name, String context) throws IOException {
		
		File file = new File(Environment.getExternalStorageDirectory()+"/"+name);
		FileOutputStream fos = new FileOutputStream(file);
		fos.write(context.getBytes());
		fos.close();
	}

	public void writeFileToRom(String name, String context) {
		
		
	}

}
