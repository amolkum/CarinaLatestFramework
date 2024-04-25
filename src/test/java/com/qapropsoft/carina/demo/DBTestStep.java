package com.qapropsoft.carina.demo;

import org.apache.ibatis.session.SqlSession;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.webdriver.IDriverPool;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.ConnectionFactory;

import utils.User;
import utils.UserMapper;

public class DBTestStep implements IAbstractTest {
	User customers=new User();
	UserMapper userMapper;
	SqlSession session;

	@Given("Database is connected")
	public void database_is_connected() {
		System.out.println("Start1--------------");
		System.out.println("The DB is Connected");
		session = ConnectionFactory.getSqlSessionFactory().openSession(true);
	}

	@When("I run the query")
	public void i_run_the_query() {
		System.out.println("Start2--------------");
		System.out.println("The Query is Executed");
		userMapper = session.getMapper(UserMapper.class);
	}

	@Then("I should see the user created")
	public void i_should_see_the_user_created() {
		System.out.println("Start3--------------");
		System.out.println("The Result is returned");
		userMapper.create(customers);
//		userMapper.findByUserName("AMOL");
//		userMapper.findById(35211708);
		
	}
	
	@Then("I should see the customer account deleted")
	public void i_should_see_the_customer_account_deleted() {
		System.out.println("Start4--------------");
	   userMapper.delete(customers);
	}
	
	@Then("I should see the customer details updated")
	public void i_should_see_the_customer_details_updated() {
		System.out.println("Start5--------------");
	    //userMapper.update(customers);
	}
}
