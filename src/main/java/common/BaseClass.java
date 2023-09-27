package common;

import java.lang.reflect.InvocationTargetException;

public class BaseClass extends ApplicationKeywords {

////////////////////////////////////////////////////////////////////////////////
//Function Name  :
//Purpose        :
//Parameters     :
//Return Value   :
//Created by     :
//Created on     :      
//Remarks        :
/////////////////////////////////////////////////////////////////////////////////

	public static ThreadLocal<BaseClass> obj = new ThreadLocal<BaseClass>();

	public void setOR(String orName) {

		System.out.println("orName: " + orName);
		orClassName = "objectRepository." + orName; // Constant.OBJECT_REPOSITORY;

		try {
			System.out.println("orClassName: " + orClassName);
			or = Class.forName(orClassName);
			orConstructor = or.getConstructors()[0];
			orObject = orConstructor.newInstance(new Object[0]);

			System.out
					.println("Locator Name: " + (String) orObject.getClass().getDeclaredField("orName").get(orObject));

		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException | NoSuchFieldException | SecurityException e) {
			e.printStackTrace();

			System.out.println("Failed in Setting OR");
		}
	}
	
}
