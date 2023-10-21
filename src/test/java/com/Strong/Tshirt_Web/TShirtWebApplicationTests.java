package com.Strong.Tshirt_Web;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.Strong.Tshirt_Web.Repository.ImagesRepo;
import com.Strong.Tshirt_Web.Repository.ProductRepo;

@SpringBootTest
class TShirtWebApplicationTests {
	@Autowired
	ImagesRepo imagesRepo;
	@Autowired
	ProductRepo productRepo;

	Logger logger = LoggerFactory.getLogger(this.getClass());

	/*
	 * 
	 * @Test
	 * public void Sort() {
	 * Sort sort = Sort.by(Sort.Direction.ASC, "name");
	 * logger.info("Sorting BY Names: -> {}", categoryRepo.findAll(sort));
	 * }
	 * 
	 * @Test
	 * public void Paging() {
	 * PageRequest request = PageRequest.of(0, 1);
	 * Page<Categories> firstPage = categoryRepo.findAll(request);
	 * logger.info("First Page: -> {}", firstPage.getContent());
	 * }
	 * 
	 * @Test
	 * public void SearchByName() {
	 * logger.info("Search By Name: -> {}",
	 * categoryRepo.findByName("Graphic T-Shirts"));
	 * }
	 */

	/*
	 * @Test
	 * public void ProductImage() {
	 * Optional<Products> prouductId = productRepo.findById(152);
	 * if (prouductId.isPresent()) {
	 * Products product = prouductId.get();
	 * Images image = new Images(product, "/images/Vintage-T-Shirts4.jpg");
	 * logger.info("Inserted Image: {}", imagesRepo.save(image).toString());
	 * } else {
	 * logger.error("Product with ID 152 not found.");
	 * }
	 * }
	 */

}
