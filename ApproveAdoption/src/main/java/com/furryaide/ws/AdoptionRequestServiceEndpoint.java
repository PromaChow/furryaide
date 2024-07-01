package com.furryaide.ws;

import clients.*;
import adoptionrequestservice.*;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.List;

@Endpoint
public class AdoptionRequestServiceEndpoint {
	private static final String NAMESPACE_URI = "http://www.furryaide/ws/AdoptionRequestService";

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetPetListRequest")
	@ResponsePayload
	public GetPetListResponse getPetList(@RequestPayload GetPetListRequest request) throws Exception {

		if (!AccessControlClient.checkPermission(request.getToken(), "view-pets")) {
			throw new RuntimeException("Permission denied");
		}

		List<Pet> pets = PetServiceClient.getAllPets();

		ObjectFactory factory = new ObjectFactory();
		GetPetListResponse response = factory.createGetPetListResponse();
		response.getPets().addAll(pets);
		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "SubmitQuestionnaireRequest")
	@ResponsePayload
	public SubmitQuestionnaireResponse submitQuestionnaire(@RequestPayload SubmitQuestionnaireRequest request) throws Exception {




		if (!AccessControlClient.checkPermission(request.getToken(), "submit-questionnaire")) {
			throw new RuntimeException("Permission denied");
		}

		List<Question> questions = QuestionnaireServiceClient.getQuestionnaire(request.getQuestionnaire().getId());


		ObjectFactory factory = new ObjectFactory();
		SubmitQuestionnaireResponse response = factory.createSubmitQuestionnaireResponse();
		StatusCode status = new StatusCode();
		status.setCode(200);

		response.setStatus(status);
		return response;
	}

}
