package letter;
import content.TextContent;
import city.Inhabitant;
import exception.NotEnoughMoneyException;


/**
 * I am a simple letter with text.
 */

public class SimpleLetter extends Letter<TextContent> {

	
	public SimpleLetter(Inhabitant sender, Inhabitant receiver) throws NotEnoughMoneyException {
		super(sender, receiver);
	}

	public SimpleLetter(Inhabitant sender, Inhabitant receiver, String text) throws NotEnoughMoneyException {
		super(sender, receiver, new TextContent(text));
		this.cost = 1;
	}
	
	/**
	 * Return string description of <code>this</code> letter.
	 * @return string of description
	 */
	public String getDescription () {
		return " simple letter (" + content.getValue() + ")";
	}
}

