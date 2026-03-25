package com.example.demo.contollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Dto.OrdersReuestDto;
import com.example.demo.Service.OrderService;
import com.example.demo.entity.Orders;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/orders")
public class OrderController {
	@Autowired
	private OrderService os;
	
	@PostMapping("/place")
	public String orderPlaceing(@RequestParam Long customerId,@RequestBody List<OrdersReuestDto> items) {
	 return os.orderPlaceing(customerId, items);
	 
	}
	@GetMapping
	public List<Orders> getAllOrders(){
		return os.getAllOrders();
	}

}
