/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tinyweb.core.action;

import tinyweb.core.Action;
import tinyweb.core.utils.StrUtils;

/**
 *
 * @author Administrator
 */
public class Index extends Action{
    
    public String put()
    {
	System.out.println("hello put");
	return "hello";
    }
    
    public void get()
    {
	System.out.println("hello get");
    }
    
    public String pa()
    {
	
	System.out.println(this.params);
	return (String)get("a");
    }
}
