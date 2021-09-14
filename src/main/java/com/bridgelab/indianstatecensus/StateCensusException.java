package com.bridgelab.indianstatecensus;

public class StateCensusException extends Exception {
	ExceptionType type;
	public enum ExceptionType{
		Parse_Error,File_Not_Found
	}
	public StateCensusException(String msg,ExceptionType type) {
	super(msg);
		this.type = type;
	}
}
