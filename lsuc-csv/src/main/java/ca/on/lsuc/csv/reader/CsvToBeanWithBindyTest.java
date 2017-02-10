package ca.on.lsuc.csv.reader;

import java.util.List;
import java.util.Map;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class CsvToBeanWithBindyTest extends CamelTestSupport {

  @Test
  public void testCsv() throws Exception {
    MockEndpoint mock = getMockEndpoint("mock:queue.csv");
    mock.expectedMessageCount(1);

    assertMockEndpointsSatisfied();

    List csv = (List) mock.getReceivedExchanges().get(0).getIn().getBody();
    Map map1 = (Map) csv.get(0);
    CsvBean csv1 = (CsvBean) map1.get("de.kopis.camel.model.CsvBean");
    assertEquals("row 01", csv1.getFirst());

    Map map2 = (Map) csv.get(1);
    CsvBean csv2 = (CsvBean) map2.get("de.kopis.camel.model.CsvBean");
    assertEquals("row 11", csv2.getFirst());
  }

  @Override
  protected RouteBuilder createRouteBuilder() throws Exception {
    return new RouteBuilder() {
      @Override
      public void configure() throws Exception {
        context.setTracing(true);

        from("file://src/test/resources?noop=true&fileName=test.csv")
          .unmarshal(new BindyCsvDataFormat("de.kopis.camel.model"))
          .to("mock:queue.csv");
      }
    };
  }

}