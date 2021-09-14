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
	int i =0;
	public static List<StateCvsCensusData> stateCensusList = new ArrayList<>();
	public static List<StateCodeData> stateCodeList = new ArrayList<>();
	
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
	private void loadRecord(Iterator<String> rotate) {
		String state = rotate.next();
        String population = rotate.next();
        String areaInSqKm = rotate.next();
        String densityPerSqKm = rotate.next();
        if (!state.equals("State") && !population.equals("Population") && !areaInSqKm.equals("AreaInSqKm") && !densityPerSqKm.equals("DensityPerSqKm")) stateCensusList.add(new StateCvsCensusData(state, Long.parseLong(population), Long.parseLong(areaInSqKm), Integer.parseInt(densityPerSqKm)));
        else if ((state.equals("State") && population.equals("Population") && areaInSqKm.equals("AreaInSqKm") && densityPerSqKm.equals("DensityPerSqKm"))!=true) {
        	throw new InputMismatchException("Wrong Header ");
        }
	} 
	public int loadDataForState(String filePath) throws Exception{
		try{
			i = 0;
			stateCodeList = new ArrayList<>();
			CSVReader reader = new CSVReader(new FileReader(filePath));  
			List<String[]> data = reader.readAll();
			data.stream().forEach(n->{
	            if(i == 0) 
	            	i=1;
	            else
	            	stateCodeList.add(new StateCodeData());
			});
			reader.close();
		}catch(FileNotFoundException e) {
			throw new StateCensusException(e.getMessage(),StateCensusException.ExceptionType.File_Not_Found);
		}
		catch(IllegalStateException  e) {
			throw new StateCensusException(e.getMessage(),StateCensusException.ExceptionType.Parse_Error);
		}
		return stateCodeList.size();
	}
	
}
