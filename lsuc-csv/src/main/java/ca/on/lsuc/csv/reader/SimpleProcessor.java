package ca.on.lsuc.csv.reader;

import java.util.ArrayList;
import java.util.HashMap;
  
 
import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import ca.on.lsuc.dto.entity.PrintRequisitionFormat;

public class SimpleProcessor implements Processor {
	public void process(Exchange exchange) throws Exception {
        ArrayList<HashMap<String, Object>> list = (ArrayList) exchange.getIn().getBody();
        for (HashMap<String, Object> map : list) {
            for (String key : map.keySet()) {
 
                System.out.println("key : " + key);
                PrintRequisitionFormat user = (PrintRequisitionFormat) map.get(key);
                System.out.println("value : " + user);
            }
        }
 
    }
}
