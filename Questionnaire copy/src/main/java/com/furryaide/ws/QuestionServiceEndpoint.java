package com.furryaide.ws;

import java.util.ArrayList;
import java.util.List;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import questionnaireservice.CreateQuestionRequest;
import questionnaireservice.CreateQuestionResponse;
import questionnaireservice.DeleteQuestionRequest;
import questionnaireservice.DeleteQuestionResponse;
import questionnaireservice.GetQuestionRequest;
import questionnaireservice.GetQuestionResponse;
import questionnaireservice.ListQuestionsRequest;
import questionnaireservice.ListQuestionsResponse;
import questionnaireservice.UpdateQuestionRequest;
import questionnaireservice.UpdateQuestionResponse;
import questionnaireservice.Question;
import questionnaireservice.ObjectFactory;
import questionnaireservice.StatusCode;

@Endpoint
public class QuestionServiceEndpoint {
	private static final String NAMESPACE_URI = "http://www.furryaide/ws/QuestionnaireService";

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "createQuestionRequest")
	@ResponsePayload
	public CreateQuestionResponse createQuestion(@RequestPayload CreateQuestionRequest request) throws Exception {
		ObjectFactory factory = new ObjectFactory();
		StatusCode code = factory.createStatusCode();
		CreateQuestionResponse response = factory.createCreateQuestionResponse();
		code.setCode(200);
		response.setStatusCode(code);
		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "updateQuestionRequest")
	@ResponsePayload
	public UpdateQuestionResponse updateQuestion(@RequestPayload UpdateQuestionRequest request) throws Exception {
		ObjectFactory factory = new ObjectFactory();
		StatusCode code = factory.createStatusCode();
		UpdateQuestionResponse response = factory.createUpdateQuestionResponse();
		code.setCode(200);
		response.setStatusCode(code);
		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "deleteQuestionRequest")
	@ResponsePayload
	public DeleteQuestionResponse deleteQuestion(@RequestPayload DeleteQuestionRequest request) throws Exception {
		ObjectFactory factory = new ObjectFactory();
		DeleteQuestionResponse response = factory.createDeleteQuestionResponse();
		StatusCode code = factory.createStatusCode();
		code.setCode(204);
		response.setStatusCode(code);
		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getQuestionRequest")
	@ResponsePayload
	public GetQuestionResponse getQuestion(@RequestPayload GetQuestionRequest request) throws Exception {
		ObjectFactory factory = new ObjectFactory();
		GetQuestionResponse response = factory.createGetQuestionResponse();
		Question question = getQuestionById(request.getId());
		response.setQuestion(question);
		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "listQuestionsRequest")
	@ResponsePayload
	public ListQuestionsResponse listQuestions(@RequestPayload ListQuestionsRequest request) throws Exception {
		ObjectFactory factory = new ObjectFactory();
		ListQuestionsResponse response = factory.createListQuestionsResponse();
		List<Question> questions = listAllQuestions();
		response.getQuestions().addAll(questions);
		return response;
	}

	private Question getQuestionById(Long id) {
		Question question = new Question();
		question.setId(id);
		question.setText("Sample question text");
		question.setType("text");
		question.getOptions().add("Option 1");
		question.getOptions().add("Option 2");
		return question;
	}

	private List<Question> listAllQuestions() {
		List<Question> questions = new ArrayList<Question>();
		// Add logic to list all questions
		return questions;
	}
}
