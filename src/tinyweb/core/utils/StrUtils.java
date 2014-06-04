/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tinyweb.core.utils;

import java.io.OutputStream;
import java.net.Socket;

/**
 *
 * @author Administrator
 */
public class StrUtils {
    public static String ucfirst(String str)
    {
	return str.replaceFirst(str.substring(0, 1), str.substring(0, 1).toUpperCase());
    }
    
    public static void pl(String str)
    {
	System.out.println(str);
    }
    
    public static void prints(String[] args)
    {
	for(String str:args)
	{
	    pl(str);
	}
    }
    
    public static void httpOut(Socket s, Object o) throws Exception
    {
	OutputStream os = s.getOutputStream();
	String output = (o == null) ? " " : (String)o;
	
	String header = "HTTP/1.0 200 OK\r\n" + "Server: OneFile 1.0 \r\n" 
		    + "Content-length: " + output.length()
		    + "\r\n\r\n" ;//+ "Content-type: \r\n";
	System.out.println(header);
	os.write(header.getBytes());
    }
    
    public static String httpResponse(String o)
    {
	String output = (o == null) ? " " : o;
	String header = "HTTP/1.0 200 OK\r\n" + "Server: OneFile 1.0 \r\n" 
		    + "Content-length: " + output.length()
		    + "\r\n\r\n"
		    + output ;
	return header;
    }
}
