package com.furryaide.ws;

import java.util.ArrayList;
import java.util.List;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import notificationservice.SendNotificationRequest;
import notificationservice.SendNotificationResponse;
import notificationservice.ObjectFactory;
import notificationservice.StatusCode;
import notificationservice.Notification;

@Endpoint
public class NotificationServiceEndpoint {
	private static final String NAMESPACE_URI = "http://www.furryaide/ws/NotificationService";

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "sendNotificationRequest")
	@ResponsePayload
	public SendNotificationResponse sendNotification(@RequestPayload SendNotificationRequest request) throws Exception {
		ObjectFactory factory = new ObjectFactory();
		StatusCode code = factory.createStatusCode();
		SendNotificationResponse response = factory.createSendNotificationResponse();

		// Dummy processing logic
		Notification notification = request.getNotification();
		System.out.println("Sending notification to " + notification.getChannel().getType());
		System.out.println("Message: " + notification.getMessage());

		code.setCode(200);
		response.setStatusCode(code);
		return response;
	}
}
