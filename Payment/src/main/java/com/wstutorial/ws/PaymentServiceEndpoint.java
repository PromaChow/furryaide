package com.wstutorial.ws;

import paymentservice.*;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.Map;
import java.util.HashMap;
import java.util.UUID;

@Endpoint
public class PaymentServiceEndpoint {
	private static final String NAMESPACE_URI = "http://www.furryaide.com/payment";


	public PaymentServiceEndpoint() {
		// Initialize some dummy users

	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "makePaymentRequest")
	@ResponsePayload
	public MakePaymentResponse makePayment(@RequestPayload MakePaymentRequest request) {
		System.out.println("khshjbshjfsbfh"+"\n\n\n\n");
		System.out.println(request.getRequest().getPayeeId());
		System.out.println(request.getRequest().getPayeeId());
		String transactionId = UUID.randomUUID().toString();
		Payment payment = new Payment();
		Header header = new Header();
		header.setAmount(request.getRequest().getAmount());
		header.setPayeeId(request.getRequest().getPayeeId());
		header.setPayerId(request.getRequest().getPayerId());

		payment.setHeader(header);
		payment.setTransactionId(transactionId);

//		paymentDatabase.put(transactionId, payment);

		ObjectFactory factory = new ObjectFactory();
		MakePaymentResponse response = factory.createMakePaymentResponse();
		response.setStatus("SUCCESS");
		response.setTransactionId(transactionId);
		return response;
	}
//
//	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "validatePaymentRequest")
//	@ResponsePayload
//	public ValidatePaymentResponse validatePayment(@RequestPayload ValidatePaymentRequest request) {
//		ObjectFactory factory = new ObjectFactory();
//		ValidatePaymentResponse response = factory.createValidatePaymentResponse();
//
//		Payment payment = paymentDatabase.get(request.getTransactionId());
//		if (payment != null) {
//			response.setIsValid(true);
//			response.setDetails("Payment is valid for transaction ID: " + request.getTransactionId());
//		} else {
//			response.setIsValid(false);
//			response.setDetails("Invalid transaction ID: " + request.getTransactionId());
//		}
//
//		return response;
//	}
}
