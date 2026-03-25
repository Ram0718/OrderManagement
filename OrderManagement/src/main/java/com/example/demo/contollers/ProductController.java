package com.example.demo.contollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.Service.ProductService;
import com.example.demo.entity.Product;

@RestController
@RequestMapping("/products")
public class ProductController {
	@Autowired
	private ProductService ps;
	
	@GetMapping
	public List<Product>getAllProducts(){
		return ps.getAllProducts();
	}
	@PostMapping
	public Product addProduct(@RequestBody Product p) {
		return ps.addingProduct(p);
	}
	@GetMapping("/{id}")
	public Product findById(@PathVariable long id) {
		return ps.getById(id);
	}
    @PutMapping("/{id}")
    public Product updating(@PathVariable long id,@RequestBody Product p) {
    	return ps.updateById(id, p);
    }
    @DeleteMapping("/{id}")
    public String delet(@PathVariable long id) {
    	ps.deleatById(id);
    	return "Product was deleted sucessfully "+id;
    }
}
