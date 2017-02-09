package ca.on.lsuc.csv.reader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.bindy.csv.BindyCsvDataFormat;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.spi.DataFormat;

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
    
    public void readCSV2() throws Exception{
    	CamelContext context = new DefaultCamelContext();
        final DataFormat bindy = new BindyCsvDataFormat();
        context.addRoutes(new RouteBuilder() {
            public void configure() {
                from("file:C:\\Users\\Opticca\\Documents\\GitHub\\LSUC").
                unmarshal(bindy)
                .process(new SimpleProcessor());
            }
        });
        context.start();
        Thread.sleep(10000);
        context.stop();
    }
    
    
    
}