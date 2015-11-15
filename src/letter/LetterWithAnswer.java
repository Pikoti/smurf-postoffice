package letter;

import city.Inhabitant;


/**
 * I deal with the sending of answers
 */

public abstract class LetterWithAnswer extends Letter
{
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 */
	public LetterWithAnswer(Inhabitant sender, Inhabitant receiver){
		super(sender, receiver);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	public void sendAnswer() {
		// TODO implement me	
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	public abstract void createAnswer() ;
	
}

