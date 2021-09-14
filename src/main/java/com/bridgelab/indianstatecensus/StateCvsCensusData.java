package com.bridgelab.indianstatecensus;

public class StateCvsCensusData {
	 public String state;
	    public long population;
	    public long areaInSqKm;
	    public Integer densityPerSqKm;
	    
		public StateCvsCensusData(String state, long population, long areaInSqKm, Integer densityPerSqKm) {
			super();
			this.state = state;
			this.population = population;
			this.areaInSqKm = areaInSqKm;
			this.densityPerSqKm = densityPerSqKm;
		}
		
		public StateCvsCensusData() {
			
		}
	    
}
