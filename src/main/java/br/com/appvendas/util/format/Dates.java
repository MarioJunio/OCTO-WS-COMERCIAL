package br.com.appvendas.util.format;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Dates {
	
	private static SimpleDateFormat dateFormatParam = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
	
	public static Date toDateParam(String data) throws ParseException {
		return dateFormatParam.parse(data);
	}
	
	public static String toStringParam(Date data) {
		return dateFormatParam.format(data);
	}
	
	public static Date milliToDate(Long milliseconds) {
		return new Date(milliseconds);
	}
	
}
