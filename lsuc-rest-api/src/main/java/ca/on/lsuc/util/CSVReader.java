package ca.on.lsuc.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CSVReader {

	String CSV_FILE_NAME = "/Users/Opticca/Documents/GitHub/LSUC/PRQ.csv";
    String line = "";
    String CSV_SPLIT_CHARACTER = ",";

    public void readCSV(){
    	
    	try {
    		BufferedReader br = new BufferedReader(getFileReader());

            while ((line = br.readLine()) != null) {

                String[] cells = line.split(CSV_SPLIT_CHARACTER);

                System.out.println("BusinessUnit [" + arrayValue(cells, 0) + "],  "
                		+ "ProductCode [" + arrayValue(cells, 1) + "],  QuantityToPrint [" + arrayValue(cells, 2) + "],  "
                				+ "GlCode [" + arrayValue(cells, 3) + "],  ProjectCode [" + arrayValue(cells, 4) + "],  "
                						+ "ActivityCode [" + arrayValue(cells, 5) + "],  CostCode [" + arrayValue(cells, 6) + "],  "
                								+ "DateRequisitionCreated [" + arrayValue(cells, 7) + "]");

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    	
    }
    
    public FileReader getFileReader() throws FileNotFoundException{
    	return new FileReader(CSV_FILE_NAME);
    }
    
    private String arrayValue(String[] array, int index){
    	String result = "";
    	
    	if (array.length > index){
    		result = array[index];
    	}
    	
    	return result;
    }
    
}