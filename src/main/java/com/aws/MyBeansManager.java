package com.aws;

import javax.ejb.Stateless;

/**
 * Session Bean implementation class MyBeansManager
 */
@Stateless
public class MyBeansManager {

    /**
     * Default constructor. 
     */
    public MyBeansManager() {
        // TODO Auto-generated constructor stub
    }
    
    public void sayHello() {
    	System.err.println("its work ! ")  ;
    }; 

}
