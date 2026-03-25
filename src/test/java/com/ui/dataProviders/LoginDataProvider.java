package com.ui.dataProviders;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;

import com.google.gson.Gson;
import com.ui.pojo.User;
import com.ui.pojo.testData;

public class LoginDataProvider {
	
	@DataProvider(name="LoginTestDataProvider")
	public Iterator<Object[]> LoginDataProvider() throws FileNotFoundException
	{
		Gson gson=new Gson();
		File file=new File(System.getProperty("user.dir")+"//testData//loginData.json");
		FileReader filereader=new FileReader(file);
		testData data=gson.fromJson(filereader, testData.class);
		
		
		List<Object[]> dataToReturn=new ArrayList<Object[]>();
		for(User user:data.getData()) {
			dataToReturn.add(new Object[] {user});
		}
		return dataToReturn.iterator();
				
				
}
}
