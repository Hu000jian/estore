package com.briup.estore.common.exception;

public class OrderException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4978231283270644326L;

	public OrderException() {
		super();
	}

	public OrderException(String arg0, Throwable arg1, boolean arg2,
			boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public OrderException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public OrderException(String arg0) {
		super(arg0);
	}

	public OrderException(Throwable arg0) {
		super(arg0);
	}
	
}
