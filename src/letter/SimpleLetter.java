package letter;
import content.TextContent;
import city.Inhabitant;


/**
 * I am a simple letter with text.
 */

public class SimpleLetter extends Letter {
	
	protected TextContent content;
	
	public SimpleLetter(Inhabitant sender, Inhabitant receiver, String text) {
		super(sender, receiver);
		TextContent content= new TextContent(text); 
		this.content = content;
	}
	
	/**
	 * Get the content of <code>this</code>.
	 * @return content of the simple letter.
	 */
	public TextContent getContent() {
		return content;
	}
	
	/**
	 * Return string description of <code>this</code> letter.
	 */
	public String getDescription () {
		return "simple letter (" + content + ")";
	} 
}

