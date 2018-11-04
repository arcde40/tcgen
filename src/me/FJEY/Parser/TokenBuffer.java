package me.FJEY.Parser;

import java.util.List;

public class TokenBuffer {
	private List<Token> list;
	private int currentPosition = 0;
	
	public TokenBuffer(List<Token> list) {
		this.list = list;
	}
	
	/**
	 * Get the Token of current position.
	 * @return Current Token
	 */
	public Token currentToken() {
		return list.get(currentPosition);
	}
	
	
	/**
	 * Go to the first of index and return first Token.
	 * @return First Token
	 */
	public Token first() {
		currentPosition = 0;
		return list.get(currentPosition);
	}
	
	/**
	 * Get Current Token's Type to String
	 * @return Token's Type to String
	 */
	public String currentTokenByName() {
		return list.get(currentPosition).getTypeString();
	}
	
	/**
	 * Returns Current Token Value.
	 * @return Current Token Value
	 */
	public String currentTokenValue() {
		return list.get(currentPosition).getValue();
	}
	
	/**
	 * Return Current Token and Go next.
	 * @return Curren Token
	 */
	public Token returnCurrNGoNext() {
		return list.get(currentPosition++);
	}
	
	/**
	 * Returns whether the Buffer has next Token
	 * @return Existence of next Token
	 */
	public boolean hasNext() {
		return currentPosition < list.size() - 1;
	}
	/**
	 * Returns whether the Buffer has current Token
	 * @return Existence of current Token
	 */
	public boolean hasCurrent() {
		return currentPosition < list.size();
	}
	
	/**
	 * Move index to next.
	 */
	public void moveNext() {
		currentPosition++;
	}
	
	/**
	 * Returns Current Position.
	 * @return Current Position
	 */
	public int currentPosition() {
		return currentPosition;
	}
}
