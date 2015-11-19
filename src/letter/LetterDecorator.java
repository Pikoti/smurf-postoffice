package letter;

public abstract class LetterDecorator extends Letter {

	protected Letter letter;
	
	public LetterDecorator(Letter letter) {
		super(letter.sender, letter.receiver);
		this.letter = letter;
	}

	public boolean isUrgent() {
		return this.letter.isUrgent() || false;
	}
	
	public boolean isRegister() {
		return this.letter.isRegisteredLetter() || false;
	}
}
