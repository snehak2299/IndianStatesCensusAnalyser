package com.bridgelab.indianstatecensus;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;

import com.opencsv.CSVReader;

public class StateCensusAnalyzer {
public static List<StateCvsCensusData> stateCensusList = new ArrayList<>();
	
	public int loadData(String filePath) throws Exception{

			stateCensusList = new ArrayList<>();
			try {
			CSVReader reader = new CSVReader(new FileReader(filePath));  
			List<String[]> data = reader.readAll();
			data.stream().forEach(n->{
				Iterator<String> iterate = Arrays.stream(n).iterator();
				String state = iterate.next();
				String population = iterate.next();
	            String areaInSqKm = iterate.next();
	            String densityPerSqKm = iterate.next();
	            if(!population.equals("Population"))
	            	stateCensusList.add(new StateCvsCensusData(state, Long.parseLong(population), Long.parseLong(areaInSqKm), Integer.parseInt(densityPerSqKm)));
			});
			reader.close();
		    return stateCensusList.size();
			}
	        catch(FileNotFoundException e) {
	        throw new StateCensusException(e.getMessage(),StateCensusException.ExceptionType.File_Not_Found);
	        }catch(IllegalStateException  e) {
				throw new StateCensusException(e.getMessage(),StateCensusException.ExceptionType.Parse_Error);
			}catch(InputMismatchException e) {
				throw new StateCensusException(e.getMessage(), StateCensusException.ExceptionType.Parse_Error);
			}
	}		
}
