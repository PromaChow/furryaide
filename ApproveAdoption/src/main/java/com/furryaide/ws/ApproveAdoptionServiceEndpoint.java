package com.furryaide.ws;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import adoptionselectionservice.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Endpoint
public class ApproveAdoptionServiceEndpoint {
	private static final String NAMESPACE_URI = "http://www.furryaide/ws/AdoptionSelectionService";
	private static Map<Long, List<Question>> questionnaires = new HashMap<Long,List<Question>>();


	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "createQuestionnaireRequest")
	@ResponsePayload
	public CreateQuestionnaireResponse createQuestionnaire(@RequestPayload CreateQuestionnaireRequest request) {
		CreateQuestionnaireResponse response = new CreateQuestionnaireResponse();
		questionnaires.put(request.getPetId(), (List<Question>) request.getQuestionnaire());
		response.setStatusCode(new StatusCode());
		response.getStatusCode().setCode(200);
		return response;
	}



	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "selectQuestionnaireRequest")
	@ResponsePayload
	public SelectQuestionnaireResponse selectQuestionnaire(@RequestPayload SelectQuestionnaireRequest request) {
		SelectQuestionnaireResponse response = new SelectQuestionnaireResponse();
		List<Question> questions = questionnaires.get(request.getPetId());
		boolean found = false;
		if (questions != null) {
			for (Question question : questions) {
				if (question.getId()==request.getQuestionnaireId()) {
					found = true;
					break;
				}
			}
		}
		if (found) {
			response.setStatusCode(new StatusCode());
			response.getStatusCode().setCode(200);
		} else {
			response.setStatusCode(new StatusCode());
			response.getStatusCode().setCode(404);
		}
		return response;
	}

}

