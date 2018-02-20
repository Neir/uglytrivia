package com.adaptionsoft.games.uglytrivia;

import java.util.LinkedList;

public class QuestionDeck {
    private LinkedList<String> popQuestions;
    private LinkedList<String> scienceQuestions;
    private LinkedList<String> sportsQuestions;
    private LinkedList<String> rockQuestions;

    public QuestionDeck(int nomberOfQuestionPerType) {
        popQuestions = new LinkedList<String>();
        scienceQuestions = new LinkedList<String>();
        sportsQuestions = new LinkedList<String>();
        rockQuestions = new LinkedList<String>();

        for (int i = 0; i < nomberOfQuestionPerType; i++) {
            popQuestions.addLast(createQuestion("Pop", i));
            scienceQuestions.addLast(createQuestion("Science", i));
            sportsQuestions.addLast(createQuestion("Sports", i));
            rockQuestions.addLast(createQuestion("Rock", i));
        }
    }

    private String createQuestion(String type, int index){
        return type + " Question " + index;
    }

    public String useOneQuestion(QuestionType type) {
        switch (type) {
            case POP:
                return popQuestions.removeFirst();
            case SCIENCE:
                return scienceQuestions.removeFirst();
            case SPORTS:
                return sportsQuestions.removeFirst();
            case ROCK:
                return rockQuestions.removeFirst();
            default:
                return "Question type unknown";
        }
    }
}
