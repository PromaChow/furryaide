package com.furryaide.ws;


import managequestionnaireservice.*;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;



@Endpoint
public class ManageQuestionnaireServiceEndpoint {
	private static final String NAMESPACE_URI = "http://www.furryaide/ws/ManageQuestionnaire";

	private ManageQuestionnaireService manageQuestionnaireService = new ManageQuestionnaireService();

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "createQuestionnaireRequest")
	@ResponsePayload
	public CreateQuestionnaireResponse createQuestionnaire(@RequestPayload CreateQuestionnaireRequest request) throws Exception {
		CreateQuestionnaireResponse response = new CreateQuestionnaireResponse();
		response.setQuestionnaireId(manageQuestionnaireService.createQuestionnaire(
				request.getQuestions(),
				request.getUsername(),
				request.getPetId(),
				request.getToken()).getId());
		response.setStatus("Questionnaire created successfully");
		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "submitQuestionnaireRequest")
	@ResponsePayload
	public SubmitQuestionnaireResponse submitQuestionnaire(@RequestPayload SubmitQuestionnaireRequest request) throws Exception {
		manageQuestionnaireService.submitQuestionnaire(request.getQuestionnaireId(), request.getUsername(), request.getToken());
		SubmitQuestionnaireResponse response = new SubmitQuestionnaireResponse();
		response.setStatus("Questionnaire submitted successfully");
		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "updateQuestionnaireRequest")
	@ResponsePayload
	public UpdateQuestionnaireResponse updateQuestionnaire(@RequestPayload UpdateQuestionnaireRequest request) throws Exception {
		manageQuestionnaireService.updateQuestionnaire(
				request.getQuestionnaireId(),
				request.getQuestions(),
				request.getUsername(),
				request.getToken());
		UpdateQuestionnaireResponse response = new UpdateQuestionnaireResponse();
		response.setStatus("Questionnaire updated successfully");
		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "approveQuestionnaireRequest")
	@ResponsePayload
	public ApproveQuestionnaireResponse approveQuestionnaire(@RequestPayload ApproveQuestionnaireRequest request) throws Exception {
		manageQuestionnaireService.approveQuestionnaire(request.getQuestionnaireId(), request.getUsername(), request.getToken());
		ApproveQuestionnaireResponse response = new ApproveQuestionnaireResponse();
		response.setStatus("Questionnaire approved successfully");
		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getQuestionnaireByIdRequest")
	@ResponsePayload
	public GetQuestionnaireByIdResponse getQuestionnaireById(@RequestPayload GetQuestionnaireByIdRequest request) throws Exception {
		Questionnaire questionnaire = manageQuestionnaireService.getQuestionnaireById(request.getQuestionnaireId(), request.getToken());
		GetQuestionnaireByIdResponse response = new GetQuestionnaireByIdResponse();
		response.setQuestionnaire(questionnaire);
		return response;
	}
}
