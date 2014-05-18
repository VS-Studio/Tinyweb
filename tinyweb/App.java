/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tinyweb;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import tinyweb.core.Controler;
import tinyweb.core.utils.StrUtils;

/**
 *
 * @author Administrator
 */
public class App implements Runnable{
    Socket socket = null;
    public App(Socket _socket) {
	this.socket = _socket;
    }
    
    @Override
    public void run() {
	Controler controler = new Controler(parseRequest());
	try{
	    OutputStream out = socket.getOutputStream();
	    String outStr = StrUtils.httpResponse((String)controler.output());
	    //StrUtils.pl(outStr);
	    out.write(outStr.getBytes());
	}catch(Exception e){
	    e.printStackTrace();
	}
    }
    
    public String parseRequest()
    {
	String ret = "";
	try{
	    BufferedReader  br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	    String req = br.readLine();
	    ret = req.split(" ")[1];
	}catch(Exception e){}
	return ret;
    }
    
    public static void main(String[] args)
    {
	App.startWeb();
    }
    
    public static void startWeb()
    {
	try{
	    ServerSocket ss = new ServerSocket(8800);
	    Socket s;
	    while((s = ss.accept()) != null)
	    {
		new Thread(new App(s)).start();
	    }
	}catch(Exception e){}
    }
}
