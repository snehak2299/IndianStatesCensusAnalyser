package com.bridgelab.indianstatecensus;

public class StateCodeData {
	public Integer srNo;
	public String stateName;
	public String tin;
	public String stateCode;
	
	public StateCodeData() {}
	
	public StateCodeData(Integer srNo,String stateName,String tin,String stateCode) {
		this.srNo=srNo;
		this.stateName=stateName;
		this.tin=tin;
		this.stateCode=stateCode;
	}
}
