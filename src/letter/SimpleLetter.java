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
		if (sender.getAccount().balance() < getCost()) throw new NotEnoughMoneyException();
	}

	public SimpleLetter(Inhabitant sender, Inhabitant receiver, String text) {
		super(sender, receiver, new TextContent(text));
		this.cost = 1;
	}
	
	/**
	 * Return string description of <code>this</code> letter.
	 */
	public String getDescription () {
		return "simple letter (" + content + ")";
	}
}

