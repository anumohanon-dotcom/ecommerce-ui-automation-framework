package com.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import com.constants.Env;

public class PropertiesUtil {
	public static String  properties(Env env,String value)
	{
		File filep=new File(System.getProperty("user.dir")+"//config//"+env+".properties");
		FileReader fr;
		Properties properties=new Properties();
		try {
			fr = new FileReader(filep);
			properties.load(fr);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		
		
	catch (IOException e) {
			
			e.printStackTrace();
		}
		
		String value1=properties.getProperty(value.toUpperCase());
		return value1;
		
	}

}
