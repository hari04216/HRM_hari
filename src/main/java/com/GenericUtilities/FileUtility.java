package com.GenericUtilities;

import java.io.FileInputStream;
import java.util.Properties;

public class FileUtility {

	public   String readproperityfile(String key) throws Throwable
	{
FileInputStream fis=new FileInputStream(Ipathconstants.filepath);
Properties pobj=new Properties();
pobj.load(fis);
String value=pobj.getProperty(key);
return value;

		
	}

}
