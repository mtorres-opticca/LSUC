package ca.on.lsuc.csv.reader;

import org.apache.camel.CamelContext;
import org.apache.camel.dataformat.bindy.csv.BindyCsvDataFormat;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.spi.DataFormat;
import org.apache.camel.builder.RouteBuilder;

public class CSVReaderTestJMS {

	public static void main(String[] args) {

		CamelContext context = new DefaultCamelContext();
        final DataFormat bindy = new BindyCsvDataFormat(); //"com.sample.model"
      
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(
                "admin", "admin", ActiveMQConnection.DEFAULT_BROKER_URL);
        context.addComponent("test-jms",
                JmsComponent.jmsComponentAutoAcknowledge(connectionFactory));
        
        context.addRoutes(new RouteBuilder() {
            public void configure() {
                from("file:C:\\camel\\in?noop=true").
                unmarshal(bindy)
                .to("test-jms:queue:testMQDestination");
            }
        });
        context.start();
        Thread.sleep(10000);
        context.stop();

	}

}
