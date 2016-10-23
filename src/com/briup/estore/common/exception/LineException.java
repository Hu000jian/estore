package com.briup.estore.common.exception;

public class LineException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2299443369229122943L;
	public LineException() {
		super();
	}
	public LineException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public LineException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public LineException(String arg0) {
		super(arg0);
	}
	public LineException(Throwable arg0) {
		super(arg0);
	}
	
}
