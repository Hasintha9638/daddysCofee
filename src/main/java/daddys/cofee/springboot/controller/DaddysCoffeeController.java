package daddys.cofee.springboot.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import daddys.cofee.springboot.exception.ResourceNotFoundException;
import daddys.cofee.springboot.model.Order;
import daddys.cofee.springboot.model.Product;
import daddys.cofee.springboot.repository.OrderRepository;
import daddys.cofee.springboot.repository.ProductRepository;

@RestController
@RequestMapping("/api/v1/")
public class DaddysCoffeeController {

	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private OrderRepository orderRepository;
	
	//get products
	@GetMapping("/products")
	public List<Product> getAllProducts(){
		return productRepository.findAll();
	}
	
	//create products
	@PostMapping("/products")
		public Product createProduct(@RequestBody Product product)
		{
			return productRepository.save(product);
		}

	
	//update product
	@PutMapping("/products/{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product productDetails){
		Product product = productRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Product is not exist with id:"+id));
		product.setProductName(productDetails.getProductName());
		product.setProductPrice(productDetails.getProductPrice());
		
		Product updatedProduct = productRepository.save(product);
		return ResponseEntity.ok(updatedProduct);
	}
	
	//delete product
	@DeleteMapping("/products/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteProduct(@PathVariable Long id){
		Product product = productRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Product is not exist with id:"+id));
		
		productRepository.delete(product);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

	//get odrers
	@GetMapping("/orders")
	public List<Order> getAllOrders(){
		return orderRepository.findAll();
	}

	//create order
	@PostMapping("/orders")
	public Order createOrder(@RequestBody Order order) {
		return orderRepository.save(order);
	}
	
	//update order
		@PutMapping("/orders/{id}")
		public ResponseEntity<Order> updateOrder(@PathVariable Long id, @RequestBody Order orderDetails){
			Order order = orderRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Order is not exist with id:"+id));
			order.setCustomerName(orderDetails.getCustomerName());
			order.setCustomerTelno(orderDetails.getCustomerTelno());
			order.setProductId(orderDetails.getProductId());
			order.setAmount(orderDetails.getAmount());
			order.setOrderDate(orderDetails.getOrderDate());
			
			Order updatedOrder = orderRepository.save(order);
			return ResponseEntity.ok(updatedOrder);
		}
		
		@PutMapping("/cancleorders/{id}")
		public ResponseEntity<Order> canleOrder(@PathVariable Long id, @RequestBody Order orderDetails){
			Order order = orderRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Order is not exist with id:"+id));
			order.setCustomerName(orderDetails.getCustomerName());
			order.setCustomerTelno(orderDetails.getCustomerTelno());
			order.setProductId(orderDetails.getProductId());
			order.setAmount(orderDetails.getAmount());
			order.setOrderDate(orderDetails.getOrderDate());
			order.setOrderState("cancle Order");
			
			Order updatedOrder = orderRepository.save(order);
			return ResponseEntity.ok(updatedOrder);
		}
}
