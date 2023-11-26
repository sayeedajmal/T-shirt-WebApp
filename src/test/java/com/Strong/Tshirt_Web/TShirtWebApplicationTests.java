package com.Strong.Tshirt_Web;

import org.slf4j.LoggerFactory;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.Strong.Tshirt_Web.Repository.AuthUsersRepo;
import com.Strong.Tshirt_Web.Security.TshirtAuthenProvider;

@SpringBootTest
class TShirtWebApplicationTests {
	@Autowired
	AuthUsersRepo authUsersRepo;

	@Autowired
	TshirtAuthenProvider tshirtAuthenProvider;

	Logger logger = LoggerFactory.getLogger(this.getClass());

}
