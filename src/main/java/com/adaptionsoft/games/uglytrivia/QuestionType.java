package com.adaptionsoft.games.uglytrivia;

public enum QuestionType {
    POP("Pop"), SCIENCE("Science"), ROCK("Rock"), SPORTS("Sports");

    private String value;

    QuestionType(String value) {
        this.value = value;
    }

    public String toString() {
        return value;
    }
}
