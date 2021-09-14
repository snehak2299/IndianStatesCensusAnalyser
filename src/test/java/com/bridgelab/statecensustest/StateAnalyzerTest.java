package com.bridgelab.statecensustest;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import com.bridgelab.indianstatecensus.StateCensusAnalyzer;

public class StateAnalyzerTest {
	@Test
    public void LoadCSVFile_AndReturnFileSize() throws IOException {
        StateCensusAnalyzer asc = new  StateCensusAnalyzer();
        try {
			asc.loadData("./src/main/resources/IndiaStateCensusData.csv");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();e.getMessage();
		}
        Assert.assertEquals(29,asc.stateCensusList.size());
    }
}
