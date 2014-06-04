/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tinyweb.core;

import java.lang.reflect.Method;
import tinyweb.core.utils.StrUtils;

/**
 *
 * @author Administrator
 */
public class Controler {
    String control = "Index";
    String action = "index";
    String params = "";
    Object out;

    public Controler(String req) {
	route(req);
	loadClass();
    }
    
    public void loadClass()
    {
	try{
	    Class control = Class.forName("tinyweb.core.action." + this.control);
	    Object o = control.newInstance();
	    initAction(control, o);
	    //Method method = control.getMethod(this.action, String[].class);
	    //Object out = method.invoke(control.newInstance(), (Object) this.args);
	    out = control.getMethod(this.action, null).invoke(o, null);
	}catch(Exception e)
	{
	    StrUtils.pl(e.getMessage());
	}
    }
    
    public Object output()
    {
	return out;
    }
    
    public void initAction(Class tar, Object o)
    {
	try{
	    Method method = tar.getMethod("parseUrl", String.class);
	    Object out = method.invoke(o, this.params);
	}catch(Exception e)
	{
	    e.printStackTrace();
	}
    }
    
    public void route(String url)
    {
	String[] ma = url.split("\\?");
	String[] m = ma[0].split("/");
	if(ma.length > 1)
	{
	    this.params = ma[1];
	}
	if(m.length>1 && m[1] != null) this.control = StrUtils.ucfirst(m[1]);
	if(m.length>2 && m[2] != null) this.action = m[2];
    }
    
    
}
