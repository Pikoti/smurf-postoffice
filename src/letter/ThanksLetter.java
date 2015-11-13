package letter;
import city.*;


/**
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */

public class ThanksLetter extends SimpleLetter
{
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 */
	public ThanksLetter(Inhabitant sender, Inhabitant receiver){
		super(sender, receiver, "Thanks!");
	}
	
	public String getDescription () {
		return "thanks letter";
	}
}

