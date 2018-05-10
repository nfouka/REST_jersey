package com.aws;

import javax.ejb.Local;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class EJB
 */
@Stateless
public class MyEJB implements EJBRemote, EJBLocal {

    /**
     * Default constructor. 
     */
    public MyEJB() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public String sayHello() {
		System.out.println("hello");
		return "salut tout le monde ";
	}

}
