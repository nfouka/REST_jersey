package org.webservice.application;    

import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.core.Application;

import com.mkyong.rest.JSONService;


public class RSApplication extends Application
{
    public Set<Class<?>> getClasses()
    {
        Set<Class<?>> s = new HashSet<Class<?>>();
        s.add(JSONService.class);
        return s;
    }
}