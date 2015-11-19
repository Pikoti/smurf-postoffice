package letter.answer;
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
	public AcknowlegmentOfReceipt(Inhabitant sender, Inhabitant receiver){
		super(sender, receiver, "I received your letter !" );
	}
	
	public String getDescription () {
		return "acknowlegment of receipt";
	}
	
}

