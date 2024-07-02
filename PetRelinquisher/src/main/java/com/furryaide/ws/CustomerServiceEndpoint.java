
package com.furryaide.ws;

import java.util.ArrayList;
import java.util.List;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import customerservice.DeleteCustomerRequest;
import customerservice.DeleteCustomerResponse;
import customerservice.GetCustomersRequest;
import customerservice.GetCustomersResponse;
import customerservice.ObjectFactory;
import customerservice.StatusCode;
import customerservice.Customer;
import customerservice.UpdateCustomerRequest;
import customerservice.UpdateCustomerResponse;

@Endpoint
public class CustomerServiceEndpoint {
	private static final String NAMESPACE_URI = "http://www.wstutorial.com/ws/CustomerService";

	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "updateCustomerRequest" )
	@ResponsePayload
	public UpdateCustomerResponse updateCustomer(@RequestPayload UpdateCustomerRequest request)throws Exception  {
		ObjectFactory factory = new ObjectFactory();
		StatusCode code = factory.createStatusCode();
		UpdateCustomerResponse response = factory.createUpdateCustomerResponse();
		code.setCode(200);
		response.setStatusCode(code);
		return response;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "deleteCustomerRequest" )
	@ResponsePayload
	public DeleteCustomerResponse deleteCustomer(@RequestPayload DeleteCustomerRequest request)throws Exception  {
		System.out.println("-->deleteCustomer<--");
		ObjectFactory factory = new ObjectFactory();
		DeleteCustomerResponse response = factory.createDeleteCustomerResponse();
		StatusCode code = factory.createStatusCode();
		code.setCode(204);
		response.setStatusCode(code);
		return response;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCustomersRequest" )
	@ResponsePayload
	public GetCustomersResponse getCustomers(@RequestPayload GetCustomersRequest request)throws Exception  {
		ObjectFactory factory = new ObjectFactory();
		GetCustomersResponse response = factory.createGetCustomersResponse();
		
		List<Customer> tutorials = getCustomers();
		
		response.getCustomers().addAll(tutorials);
		return response;
	}

	private List<Customer> getCustomers() {
		List<Customer> tutorials= new ArrayList<Customer>();
		Customer tut1 = new Customer();
		tut1.setName("John Doe");
		tut1.setId(15l);
		
		
		
//		CustomerType tut2 = new CustomerType();
//		tut2.setAuthor("John Doe");
//		tut2.setId(152);
//		tut2.setName("Web Service with spring boot");
		
		tutorials.add(tut1);
//		tutorials.add(tut2);
		return tutorials;
	}
	
}