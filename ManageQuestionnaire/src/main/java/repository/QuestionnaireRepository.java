package repository;

import java.util.*;

import managequestionnaireservice.*;

    public class QuestionnaireRepository {
        private static QuestionnaireRepository instance;
        private List<Questionnaire> questionnaires;
        private long nextId;

        private QuestionnaireRepository() {
            questionnaires = new ArrayList<Questionnaire>();
            nextId = 1;
        }

        public static synchronized QuestionnaireRepository getInstance() {
            if (instance == null) {
                instance = new QuestionnaireRepository();
            }
            return instance;
        }

        public Questionnaire createQuestionnaire(List<Long> questionIds, String username, long petId) {
            Questionnaire questionnaire = new Questionnaire();
            questionnaire.setId(nextId++);
            questionnaire.getQuestionIds().addAll(questionIds); // use the live list
            questionnaire.setUsername(username);
            questionnaire.setStatus("created");
            questionnaire.setPetId(petId);
            questionnaires.add(questionnaire);
            return questionnaire;
        }

        public Questionnaire getQuestionnaire(long id) {
            for (Questionnaire q : questionnaires) {
                if (q.getId() == id) {
                    return q;
                }
            }
            return null;
        }

        public void updateQuestionnaire(long id, List<Long> questionIds) {
            Questionnaire questionnaire = getQuestionnaire(id);
            if (questionnaire != null) {
                questionnaire.getQuestionIds().clear();
                questionnaire.getQuestionIds().addAll(questionIds); // use the live list
            }
        }

        public void submitQuestionnaire(long id, String username) {
            Questionnaire questionnaire = getQuestionnaire(id);
            if (questionnaire != null && questionnaire.getUsername().equals(username)) {
                questionnaire.setStatus("submitted");
            }
        }

        public void approveQuestionnaire(long id, String username) {
            Questionnaire questionnaire = getQuestionnaire(id);
            if (questionnaire != null) {
                questionnaire.setStatus("approved");
            }
        }

        public List<Questionnaire> getAllQuestionnaires() {
            return questionnaires;
        }
    }