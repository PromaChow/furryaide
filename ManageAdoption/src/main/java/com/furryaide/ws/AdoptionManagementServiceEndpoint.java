package com.furryaide.ws;

import clients.AccessControlClient;
import clients.NotificationClient;
import clients.PetClient;
import manageadoptionservice.*;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import repository.AdoptionRepository;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

import org.xml.sax.SAXException;

import static clients.PetClient.getPetById;

@Endpoint
public class AdoptionManagementServiceEndpoint {
	private static final String NAMESPACE_URI = "http://www.furryaide/ws/AdoptionManagement";

	private AdoptionManagementService adoptionManagementService = new AdoptionManagementService();
	private AdoptionRepository adoptionRepository = AdoptionRepository.getInstance();

	private boolean checkPermission(String token, String permission) throws IOException, ParserConfigurationException, SAXException {
		return AccessControlClient.checkPermission(token, permission);
	}
	private boolean sendNotification(String token, String type, String message, String pattern, String duration, String channelType, String address) throws IOException, ParserConfigurationException, SAXException {
		return NotificationClient.sendNotification(token, type, message, pattern, duration, channelType, address);
	}


	private boolean updatePetStatus(Pet pet) throws IOException, ParserConfigurationException, SAXException {
		return PetClient.updatePetStatus(pet);
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "requestAdoptionRequest")
	@ResponsePayload
	public RequestAdoptionResponse requestAdoption(@RequestPayload RequestAdoptionRequest request) throws Exception {
		if (checkPermission(request.getToken(), "request-adoption")) {
			long adoptionRequestId = adoptionManagementService.requestAdoption(
					request.getCustomerID(),
					request.getPetID());
			sendNotification(request.getToken(), "INFO", "Adoption request created successfully with ID: " + adoptionRequestId, "default", null, "EMAIL", "customer@example.com");

			RequestAdoptionResponse response = new RequestAdoptionResponse();
			response.setAdoptionRequestID(request.getId());
			response.setStatus("Adoption request created successfully");
			return response;
		} else {
			throw new SecurityException("Permission denied");
		}
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "approveAdoptionRequest")
	@ResponsePayload
	public ApproveAdoptionResponse approveAdoption(@RequestPayload ApproveAdoptionRequest request) throws Exception {
		if (checkPermission(request.getToken(), "approve-adoption")) {
			boolean isApproved = adoptionManagementService.approveAdoption(request.getAdoptionRequestID(), request.getRelinquisherID());
			if (isApproved) {
				Pet pet = getPetById(request.getAdoptionRequestID());
				pet.setAdopted(true);
				updatePetStatus(pet);
				sendNotification(request.getToken(), "SUCCESS", "Adoption approved successfully for ID: " + request.getAdoptionRequestID(), "default", null, "SMS", "customer@example.com");
			}
			ApproveAdoptionResponse response = new ApproveAdoptionResponse();
			response.setStatus(isApproved ? "Adoption approved successfully" : "Failed to approve adoption");
			return response;
		} else {
			throw new SecurityException("Permission denied");
		}
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "rejectAdoptionRequest")
	@ResponsePayload
	public RejectAdoptionResponse rejectAdoption(@RequestPayload RejectAdoptionRequest request) throws Exception {
		if (checkPermission(request.getToken(), "reject-adoption")) {
			boolean isRejected = adoptionManagementService.rejectAdoption(request.getAdoptionRequestID(), request.getRelinquisherID());
			if (isRejected) {
				sendNotification(request.getToken(), "ERROR", "Adoption rejected for ID: " + request.getAdoptionRequestID(), "default", null, "EMAIL", "customer@example.com");
			}

			RejectAdoptionResponse response = new RejectAdoptionResponse();
			response.setStatus(isRejected ? "Adoption rejected successfully" : "Failed to reject adoption");
			return response;
		} else {
			throw new SecurityException("Permission denied");
		}
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "cancelAdoptionRequest")
	@ResponsePayload
	public CancelAdoptionResponse cancelAdoption(@RequestPayload CancelAdoptionRequest request) throws Exception {
		if (checkPermission(request.getToken(), "cancel-adoption")) {
			boolean isCancelled = adoptionManagementService.cancelAdoption(request.getAdoptionRequestID(), request.getReason());
			if (isCancelled) {
				sendNotification(request.getToken(), "INFO", "Adoption cancelled for ID: " + request.getAdoptionRequestID(), "default", null, "EMAIL", "customer@example.com");
			}

			CancelAdoptionResponse response = new CancelAdoptionResponse();
			response.setStatus(isCancelled ? "Adoption cancelled successfully" : "Failed to cancel adoption");
			return response;
		} else {
			throw new SecurityException("Permission denied");
		}
	}

	public GetAdoptionStatusResponse getAdoptionStatus(@RequestPayload GetAdoptionStatusRequest request) throws Exception {
		if (checkPermission(request.getToken(), "get-adoption-status")) {
			Status status = adoptionManagementService.getAdoptionStatus(request.getAdoptionRequestID());
			GetAdoptionStatusResponse response = new GetAdoptionStatusResponse();
			response.setStatus(status);
			return response;
		} else {
			throw new SecurityException("Permission denied");
		}
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAdoptionDetailsRequest")
	@ResponsePayload
	public GetAdoptionDetailsResponse getAdoptionDetails(@RequestPayload GetAdoptionDetailsRequest request) throws Exception {
		if (checkPermission(request.getToken(), "get-adoption-details")) {
			Adoption adoption = adoptionManagementService.getAdoptionDetails(request.getAdoptionRequestID());
			GetAdoptionDetailsResponse response = new GetAdoptionDetailsResponse();
			response.setAdoptionDetails(adoption);
			return response;
		} else {
			throw new SecurityException("Permission denied");
		}
	}
}