package ca.on.lsuc.jpa.test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import com.github.springtestdbunit.DbUnitTestExecutionListener;

import ca.on.lsuc.jpa.conf.PersistenceContext;
import ca.on.lsuc.jpa.dao.OrderRepository;
import ca.on.lsuc.jpa.entity.Order;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {PersistenceContext.class})
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class,
	DirtiesContextTestExecutionListener.class,
	TransactionalTestExecutionListener.class,
    DbUnitTestExecutionListener.class})
//@DatabaseSetup("orders.xml")
public class OrderServiceTest {
	
	    @Autowired
	    private OrderRepository dao;
	    
	    
	    @Test
	    public void testCreate() throws Exception {
	    	List<Order> orders = dao.findAll();
	    	assertThat(orders).hasSize(3);    
	    }

//	    @Test
//	    public void testSelect() throws Exception {
//	    	order = repo.findOne(order.getId());
//	    	System.err.println(order);
//	    	Assert.assertNotNull(order);
//	    }
	    
//	    @Test
//	    public void testUpdate() throws Exception {
//	    	order.setCustomerName("XXX");
//	    	repo.save(order);
//	    	order = repo.findOne(order.getId());
//	    	System.out.println(repo);
//	    	Assert.assertEquals("XXX", order.getCustomerName());
//	    }
//	    
//	    @Test
//	    public void testDelete() throws Exception {
//	    	repo.delete(order);
//	    	order = repo.findOne(order.getId());
//	    	System.out.println(repo);
//	    	Assert.assertNull(order);
//	    }
}
