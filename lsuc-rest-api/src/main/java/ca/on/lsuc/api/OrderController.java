package ca.on.lsuc.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import ca.on.lsuc.jpa.entity.Order;
import ca.on.lsuc.service.OrderService;

@RestController
@RequestMapping(path = "/orders", produces = MediaType.APPLICATION_JSON_VALUE)
public class OrderController {

	@Autowired
	private OrderService orderService;

	@RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
	public List<Order> getOrders() {
		return orderService.findAll();
	}
	
	@RequestMapping(value = {"/{id}"}, method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
    public Order getOrder(@PathVariable("id") Long id) {
        return orderService.findOrder(id);
    }
	
	@RequestMapping(value = {"", "/"}, method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
    public Order createOrder(@RequestBody Order order) {
        return orderService.saveOrder(order);
    }
	
	@RequestMapping(value = {"/{id}"}, method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
    public Order updateOrder(@PathVariable("id") Long id, @RequestBody Order order) {
        return orderService.saveOrder(order);
    }
	
	@RequestMapping(value = {"/{id}"}, method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteOrder(@PathVariable("id") Long id) {
        orderService.deleteOrder(id);
    }
}
