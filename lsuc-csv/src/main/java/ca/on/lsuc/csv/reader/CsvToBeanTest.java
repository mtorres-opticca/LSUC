package ca.on.lsuc.csv.reader;

import static org.junit.Assert.*;

import java.util.List;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class CsvToBeanTest extends CamelTestSupport {

  @Test
  public void testCsv() throws Exception {
    MockEndpoint mock = getMockEndpoint("mock:queue.csv");
    mock.expectedMessageCount(2);

    assertMockEndpointsSatisfied();

    List line1 = mock.getReceivedExchanges().get(0).getIn().getBody(List.class);
    assertEquals("row 01", line1.get(0));
    assertEquals("row 02", line1.get(1));
    assertEquals("", line1.get(2));
    assertEquals("row 04", line1.get(3));

    List line2 = mock.getReceivedExchanges().get(1).getIn().getBody(List.class);
    assertEquals("row 11", line2.get(0));
    assertEquals("row 12", line2.get(1));
    assertEquals("row 13", line2.get(2));
    assertEquals("row 14", line2.get(3));
  }

  @Override
  protected RouteBuilder createRouteBuilder() throws Exception {
    return new RouteBuilder() {
      @Override
      public void configure() throws Exception {
        context.setTracing(true);

        from("file://src/test/resources?noop=true&fileName=test.csv")
          .unmarshal().csv()
          .split(body())
          .to("mock:queue.csv");
      }
    };
  }
}