package ca.on.lsuc.csv.reader;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.bindy.csv.BindyCsvDataFormat;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.spi.DataFormat;

public class CSVReaderTest {

	public static void main(String[] args) {
		CamelContext context = new DefaultCamelContext();
        final DataFormat bindy = new BindyCsvDataFormat();
        try {
			context.addRoutes(new RouteBuilder() {
			    public void configure() {
			        from("file:C:\\camel\\in?noop=true").
			        unmarshal(bindy)
			        .process(new SimpleProcessor());
			    }
			});
			context.start();
			Thread.sleep(10000);
	        context.stop();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
