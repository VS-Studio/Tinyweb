/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tinyweb.core;

import java.util.HashMap;

/**
 *
 * @author Administrator
 */
public class Action {
    protected HashMap params = new HashMap();
    
    public Object get(String par)
    {
	return params.get(par);
    }
    
    public void put(String par, Object val)
    {
	params.put(par, val);
    }
    
    public void parseUrl(String url)
    {
	String[] pas = url.split("&");
	for(String pa:pas)
	{
	    String[] kv = pa.split("=");
	    if(kv.length > 1) put(kv[0],kv[1]);
	}
    }
}
