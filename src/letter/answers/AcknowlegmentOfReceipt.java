package letter.answers;
import city.*;
import letter.SimpleLetter;


/**
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */

public class AcknowlegmentOfReceipt extends SimpleLetter
{
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 */
	public AcknowlegmentOfReceipt(Inhabitant sender, Inhabitant receiver, String text){
		super(sender, receiver, text);
	}
	
	public String getDescription () {
		return "acknowlegment of receipt";
	}
	
}

