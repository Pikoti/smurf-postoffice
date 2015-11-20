package letter;

public abstract class LetterDecorator<L extends Letter<?>> extends Letter<L> {
	
	public LetterDecorator(L letter) {
		super(letter.sender, letter.receiver, letter);
	}

	public boolean isUrgent() {
		return this.content.isUrgent() || false;
	}
	
	public boolean isRegister() {
		return this.content.isRegisteredLetter() || false;
	}
}
