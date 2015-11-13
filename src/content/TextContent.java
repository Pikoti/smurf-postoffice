package content;

/**
 * I am a text content for a letter
 */

public class TextContent implements Content {
	
	protected String text;

	public TextContent (String text) {
		this.text = text;
	}
	
	/**
	 * Get the text content of the letter
	 * @return content 
	 */	
	public String getContent() {
		return text;	
	}
	
	/**
	 * @see getContent 
	 */	
	public String toString() {
		return getContent();	
	}
	
	/**
	 * Set text content of the letter
	 * @param text the content text of the letter
	 */	
	public void setContent(String text) {
		this.text = text;	
	}
	
}

