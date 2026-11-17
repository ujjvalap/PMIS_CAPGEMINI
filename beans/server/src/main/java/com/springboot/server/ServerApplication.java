package com.springboot.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ServerApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ServerApplication.class, args);
	}

public final PaymentService paymentService;
	public ServerApplication(PaymentService paymentService)
	{
		this.paymentService=paymentService;
	}

//	Another one Aprroch using the @Authowired Anotation

//	@Autowired
//	public  RezarpayPayment paymentService;




//	We are create the Final Variable
//	private final  RezarpayPayment paymentService;

//	This is Best way to Impliment Because We can explicity add this class is dependent
//	public ServerApplication(RezarpayPayment paymentService)
//	{
//		this.paymentService=paymentService;
//	}

//	This Tight coupling of the Class Object creation issue Every time to create the object
//	private  RezarpayPayment paymentService = new RezarpayPayment();
	@Override
	public  void  run(String... args) throws Exception{
		System.out.println(paymentService.pay());
		System.out.println(paymentService.transaction());
		System.out.println(paymentService.refund());

	}

}
