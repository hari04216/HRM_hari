package com.GenericUtilities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class JavaUtility {

public int random()
{
	Random ran=new Random();
	int random =ran.nextInt(1000);
	return random;
}
public String getSystemDate()
{
	Date dt=new Date();
	String date=dt.toString();
	return date;
}
public String formatsystemdate()
{
	SimpleDateFormat dateformat=new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
	Date dt=new Date();
	String getDateAndTime=dateformat.format(dt);
	getDateAndTime.replace(":","-" );
	return getDateAndTime;
	
	
			
}
	
	
	
}
