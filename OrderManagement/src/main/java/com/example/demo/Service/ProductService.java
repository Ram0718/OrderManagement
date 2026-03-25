package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repo.ProductRepo;
import com.example.demo.entity.Product;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepo pr;
	
	public List<Product> getAllProducts(){
		return pr.findAll();
	}
     public Product addingProduct(Product p) {
    	 return pr.save(p);
     }
     public String deleatById(long id) {
    	 pr.deleteById(id);
    	 return "product is deleted successfully with this id "+id;
     }
     public Product updateById(long id,Product p) {
    	 Product ep=pr.findById(id).orElseThrow(()-> new RuntimeException("product with this id is not found "+id));
    	 ep.setName(p.getName());
    	 ep.setPrice(p.getPrice());
    	 ep.setQuantity(p.getQuantity());
    	 return pr.save(ep);
     }
   public Product getById(long id) {
    	 return pr.findById(id).orElseThrow(()->new RuntimeException("product is not found with this id "+id));
     }
}
