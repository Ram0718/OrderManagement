package com.example.demo.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Dto.OrdersReuestDto;
import com.example.demo.Repo.CustomerRepo;
import com.example.demo.Repo.OdersIteamRepo;
import com.example.demo.Repo.OrdersRepo;
import com.example.demo.Repo.ProductRepo;
import com.example.demo.entity.Customer;
import com.example.demo.entity.Orders;
import com.example.demo.entity.OrdersIteam;
import com.example.demo.entity.Product;

@Service
public class OrderService {
	
   @Autowired
   private CustomerRepo customerRepo;
   @Autowired
   private ProductRepo productRepo;
   @Autowired
   private OrdersRepo ordersRepo;
   @Autowired 
   OdersIteamRepo ordersItemRepo;
   @Transactional
   public String orderPlaceing(Long customerId,List<OrdersReuestDto> reuest) {
	   Customer customer=customerRepo.findById(customerId).orElseThrow(); // finding the customer if not throw error
	   Orders order=new Orders();  // creating obj for new orders
	   order.setCusromer(customer);    // set cust in orders table 
	   order.setOrderDate(LocalDateTime.now()); // same 
	   
	   double total=0;
	   List<OrdersIteam> iteam=new ArrayList<>();     // storeing the all orders item in OrdersItem entity
	     for(OrdersReuestDto req:reuest) {           //looping the over the requesting iteams 
	    	 Product product=productRepo.findById(req.getProductId()).orElseThrow();  // finding the id of product to place order if not throe error
	    	 
	    	 if(product.getQuantity()<req.getQuantity()) {  // checking the quantity
	    		 throw new IllegalArgumentException("Stock not available for productId: " + req.getProductId());
	    	 }
	   
	    	 product.setQuantity(product.getQuantity()-req.getQuantity()); // minus the stock
	    	 productRepo.save(product);
	    	 double price=product.getPrice()*req.getQuantity(); // cal total bill
	    	 total+=price;
	    	 
	    	 OrdersIteam itemas=new OrdersIteam();  // creating the new obj for cust place ordes it will create new row in db
	    	 itemas.setOrder(order);
	    	 itemas.setPrice(price);
	    	 itemas.setProduct(product);
	    	 itemas.setQuantity(req.getQuantity());
	    	 iteam.add(itemas);
	     }
    	 order.setTotalAmount(total);
    	 ordersRepo.save(order);
    	 
    	 ordersItemRepo.saveAll(iteam);
    	 return "order placed successfully and your grand total is = "+total;
	   
	   
   }
   public List<Orders>getAllOrders(){
	   return ordersRepo.findAll();
   }
}
