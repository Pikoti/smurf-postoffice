package content;

/**
 * I am a text content for a letter.
 */

public class TextContent implements Content {
	
	protected String value;

	public TextContent (String value) {
		this.value = value;
	}
	
	/**
	 * Get the text content of the letter
	 * @return value 
	 */	
	public String getValue() {
		return value;	
	}
	
	/**
	 * @see getContent 
	 */	
	public String toString() {
		return getValue();	
	}
	
	/**
	 * Set text content of the letter
	 * @param value the content text of the letter
	 */	
	public void setValue(String value) {
		this.value = value;	
	}
	
}

