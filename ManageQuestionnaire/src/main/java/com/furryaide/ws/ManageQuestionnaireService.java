package com.furryaide.ws;

import managequestionnaireservice.*;
import repository.*;
import clients.AccessControlClient;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ManageQuestionnaireService {
    private QuestionnaireRepository repository;

    public ManageQuestionnaireService() {
        repository = QuestionnaireRepository.getInstance();


    }

    public Questionnaire createQuestionnaire(List<Question> questions, String username, long petId, String token) throws IOException, ParserConfigurationException, SAXException {
        if (!checkPermission(token, "approve-questionnaire")) {
            throw new SecurityException("User does not have permission to create a questionnaire");
        }

        List<Long> questionIds = new ArrayList<Long>();
        for (Question question : questions) {
            long questionId = repository.createQuestion(question);
            questionIds.add(questionId);
        }

        return repository.createQuestionnaire(questionIds, username, petId);
    }

    public void submitQuestionnaire(long questionnaireId, String username, String token) throws IOException, ParserConfigurationException, SAXException {
        if (!checkPermission(token, "submit-questionnaire")) {
            throw new SecurityException("User does not have permission to submit a questionnaire");
        }
        repository.submitQuestionnaire(questionnaireId, username);
    }

    public void updateQuestionnaire(long questionnaireId, List<Question> questions, String username, String token) throws IOException, ParserConfigurationException, SAXException {
        if (!checkPermission(token, "approve-questionnaire")) {
            throw new SecurityException("User does not have permission to update a questionnaire");
        }

        List<Long> questionIds = new ArrayList<Long>();
        for (Question question : questions) {
            long questionId = questionService.updateQuestion(question);
            questionIds.add(questionId);
        }

        repository.updateQuestionnaire(questionnaireId, questionIds);
    }

    public void approveQuestionnaire(long questionnaireId, String username, String token) throws IOException, ParserConfigurationException, SAXException {
        if (!checkPermission(token, "approve-questionnaire")) {
            throw new SecurityException("User does not have permission to approve a questionnaire");
        }
        repository.approveQuestionnaire(questionnaireId, username);
    }

    public Questionnaire getQuestionnaireById(long questionnaireId, String token) throws IOException, ParserConfigurationException, SAXException {
        if (!checkPermission(token, "view-questionnaire")) {
            throw new SecurityException("User does not have permission to view a questionnaire");
        }
        return repository.getQuestionnaire(questionnaireId);
    }

    private boolean checkPermission(String token, String permission) throws IOException, ParserConfigurationException, SAXException {
        return AccessControlClient.checkPermission(token, permission);
    }
}
