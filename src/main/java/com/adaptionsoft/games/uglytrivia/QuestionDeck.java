package com.adaptionsoft.games.uglytrivia;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class QuestionDeck {
    private Map<String, LinkedList<String>> questionsPerType;

    public QuestionDeck(int nomberOfQuestionPerType) {
        questionsPerType = new HashMap<String, LinkedList<String>>();
        questionsPerType.put("Pop", new LinkedList<String>());
        questionsPerType.put("Science", new LinkedList<String>());
        questionsPerType.put("Sports", new LinkedList<String>());
        questionsPerType.put("Rock", new LinkedList<String>());

        for (int i = 0; i < nomberOfQuestionPerType; i++) {
            addQuestion("Pop", i);
            addQuestion("Science", i);
            addQuestion("Sports", i);
            addQuestion("Rock", i);
        }
    }

    private void addQuestion(String type, int index) {
        questionsPerType.get(type).addLast(type + " Question " + index);
    }

    public String useOneQuestion(String type) {
        return questionsPerType.get(type).removeFirst();
    }
}
