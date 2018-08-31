package mall.dog.web.controller.order;

import mall.dog.common.request.TokenRequest;
import mall.dog.entity.response.Entity;
import mall.dog.service.order.OrderService;
import mall.dog.service.order.entity.CreateOrderRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * 2018/8/26 mall.dog.web.controller.order
 *
 * @author dylan
 * Home: http://blog.devdylan.cn
 */
@Valid
@RestController
@RequestMapping("order")
public class OrderController {

	private final OrderService orderService;

	@Autowired
	public OrderController(OrderService orderService) {
		this.orderService = orderService;
	}

	@PostMapping("create")
	public Entity create(@RequestBody CreateOrderRequest createOrderRequest) {
		return orderService.create(createOrderRequest);
	}

	@PostMapping("query")
	public Entity query(@RequestBody TokenRequest tokenRequest) {
		return orderService.query(tokenRequest);
	}

}
