package com.bridgelab.statecensustest;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import com.bridgelab.indianstatecensus.StateCensusAnalyzer;
import com.bridgelab.indianstatecensus.StateCensusException;

public class StateAnalyzerTest {
	@Test
    public void LoadCSVFile_AndReturnFileSize() throws IOException {
        StateCensusAnalyzer asc = new  StateCensusAnalyzer();
        try {
			asc.loadData("./src/main/resources/IndiaStateCensusData.csv");
		} catch (Exception e) {
			e.printStackTrace();e.getMessage();
		}
        Assert.assertEquals(29,asc.stateCensusList.size());
    }
	
	
	@Test
	public void ifCsvFileNotDetected_throwException_CSVFileIsNotDtected() throws Exception {
		try {
			StateCensusAnalyzer stateCensusAnalyser = new StateCensusAnalyzer();
			Assert.assertEquals(29, stateCensusAnalyser.loadData("./src/main/resources/IndiaStateCensusData.csv"));
		}catch(StateCensusException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void ifCsvFileNotCorrect_throwException_CSVFileIsNotCorrect() throws Exception {
		try {
			StateCensusAnalyzer stateCensusAnalyser = new StateCensusAnalyzer();
			Assert.assertEquals(29, stateCensusAnalyser.loadData("./src/main/resources/IndiaStateCensusData.csv"));
		}catch(StateCensusException e) {
			e.printStackTrace();
		}
	}
	@Test
	public void ifDelimiterIncorrect_WillReturnCustomException() throws Exception {
		try {
			StateCensusAnalyzer stateCensusAnalyser = new StateCensusAnalyzer();
			Assert.assertEquals(29, stateCensusAnalyser.loadData("./src/main/resources/IndiaStateCensusData.csv"));
		}catch(StateCensusException e) {
			e.printStackTrace();
		}
	}
}
