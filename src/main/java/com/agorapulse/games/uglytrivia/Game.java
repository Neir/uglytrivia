package com.agorapulse.games.uglytrivia;

public class Game {

	private Board board;

	private QuestionDeck questionDeck;

    public  Game(){
		board = new Board();
		questionDeck = new QuestionDeck(50);
    }

	public boolean add(String playerName) {
    	return board.addPlayer(playerName);
	}

	public void roll(int roll) {
		System.out.println(board.getCurrentPlayer().getName() + " is the current player");
		System.out.println("They have rolled a " + roll);
		
		if (board.getCurrentPlayer().isInPenaltyBox()) {
			if (roll % 2 != 0) {
				board.getCurrentPlayer().setInPenaltyBox(false);
				System.out.println(board.getCurrentPlayer().getName() + " is getting out of the penalty box");

				playerMove(roll);
				askQuestion();
			} else {
				System.out.println(board.getCurrentPlayer().getName() + " is not getting out of the penalty box");
			}
		} else {
			playerMove(roll);
			askQuestion();
		}
	}

	public boolean wasCorrectlyAnswered() {
		if (board.getCurrentPlayer().isInPenaltyBox()){
			board.nextPlayer();
			return true;
		} else {
			return rewardSuccessAnswer();
		}
	}
	
	public boolean wrongAnswer(){
		System.out.println("Question was incorrectly answered");
		board.getCurrentPlayer().setInPenaltyBox(true);
		System.out.println(board.getCurrentPlayer() + " was sent to the penalty box");
		board.nextPlayer();
		return true;
	}

	private void playerMove(int roll) {
		board.getCurrentPlayer().move(roll, board.getBoardSize());

		System.out.println(board.getCurrentPlayer().getName()
				+ "'s new location is "
				+ board.getCurrentPlayer().getPlace());
	}

	private void askQuestion() {
		System.out.println("The category is " + board.currentCategory());
		System.out.println(questionDeck.useOneQuestion(board.currentCategory()));
	}

	private boolean rewardSuccessAnswer() {
		System.out.println("Answer was correct!!!!");
		board.getCurrentPlayer().winGoldCoin();
		if (board.getCurrentPlayer().isWinner()) {
			return false;
		} else {
			board.nextPlayer();
			return true;
		}
	}
}
