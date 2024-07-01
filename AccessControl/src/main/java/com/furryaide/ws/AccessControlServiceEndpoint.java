package com.furryaide.ws;

import accesscontrolservice.*;
import com.furryaide.ws.AccessControlService;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class AccessControlServiceEndpoint {

	private static final String NAMESPACE_URI = "http://www.furryaide.com/accesscontrol";
	private AccessControlService accessControlService = new AccessControlService();

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "checkPermissionRequest")
	@ResponsePayload
	public CheckPermissionResponse checkPermission(@RequestPayload CheckPermissionRequest request) {
		boolean hasPermission = accessControlService.checkPermission(request.getToken(), request.getPermission());
		CheckPermissionResponse response = new CheckPermissionResponse();
		response.setHasPermission(hasPermission);
		return response;
	}
}
