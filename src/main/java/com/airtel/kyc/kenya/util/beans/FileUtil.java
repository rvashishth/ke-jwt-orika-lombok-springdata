package com.airtel.kyc.kenya.util.beans;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Base64;

public class FileUtil {

	public static Boolean saveBase64ToFile(String base64String, String destfilepath, String filename) {
		try {
			File f1 = new File(destfilepath);
			if (!f1.isDirectory())
				f1.mkdirs();
			OutputStream out = new FileOutputStream(new File(destfilepath + filename.toString()), true);
			final byte[] dec = Base64.getDecoder().decode(base64String);
			out.write(dec);
			out.flush();
			out.close();
			return true;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			e.printStackTrace();
			return false;

		}
	}

	public static void main(String args[]) throws IOException {
		File file = new File("/Users/b0202777/work/KYC/kenya/img/sample.jpg");
		InputStream fin = new FileInputStream(file);
		byte fileContent[] = new byte[(int) file.length()];
		fin.read(fileContent);
		//String s = new String(fileContent);

		 String encodeToString = Base64.getEncoder().encodeToString(fileContent);
		 
		 System.out.println(encodeToString);

		 saveBase64ToFile(encodeToString,"/Users/b0202777/work/KYC/kenya/img/","converted.jpg");
	}
}
