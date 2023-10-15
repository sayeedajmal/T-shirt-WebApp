package com.Strong.Tshirt_Web;

import org.slf4j.LoggerFactory;


import org.slf4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.Strong.Tshirt_Web.Repository.CategoryRepo;
import com.Strong.Tshirt_Web.Repository.ImagesRepo;
import com.Strong.Tshirt_Web.Repository.ProductRepo;
import com.Strong.Tshirt_Web.Repository.UsersRepo;

@SpringBootApplication
public class TShirtWebApplication implements CommandLineRunner {

	@Autowired
	UsersRepo usersRepo;
	@Autowired
	CategoryRepo categoryRepo;
	@Autowired
	ProductRepo productRepo;
	@Autowired
	ImagesRepo imagesRepo;

	Logger logger = LoggerFactory.getLogger(this.getClass());

	public static void main(String[] args) {
		SpringApplication.run(TShirtWebApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/* Optional<Products> prouductId = productRepo.findById(152);
		if (prouductId.isPresent()) {
			Products product = prouductId.get();
			Images image = new Images(product, "/images/Vintage-T-Shirts1.jpg");
			logger.info("Inserted Image: {}", imagesRepo.save(image));
		} else {
			logger.error("Product with ID 152 not found.");
		} */
		/*
		 * logger.info("Inserted: ->{}", usersRepo.InsertUser(new Users("xyz",
		 * "xtz@gmail.com", "2443243",
		 * "X", "Z", "yy", "00000000")).toString());
		 */
		/*
		 * logger.info("Added Category: -> {}",
		 * categoryRepo.AddTShirtCategory(new Categories("Vintage T-Shirts",
		 * "Vintage Inspired T-Shirts for a Retro Vibe")).toString());
		 */

		// First Fetch the id of the category, in which categroy you wanna to add
		/*
		 * Categories category = categoryRepo.findById(152);
		 * if (category != null) {
		 * logger.info("Added Category: -> {}",
		 * productRepo.AddProduct(new Products("Casual Blue T-shirt",
		 * "Men's Casual Blue Striped T-shirt", 179f, 42, category))
		 * .toString());
		 * } else
		 * System.out.println("Added Category:-> Category Id Not Found");
		 */

		/* logger.info("Find By ID :-> {}", usersRepo.findById(2)); */
		// usersRepo.DeleteUserById(52);
	}

}
