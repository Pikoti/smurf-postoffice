package letter;

import city.Inhabitant;


/**
 * <span style="font-size: 12.8px;">A besoin du type Generique LEtter</span>
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */

public class RegisterLetter extends LetterWithAnswer
{
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	protected Letter letter;
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 */
	public RegisterLetter(Inhabitant sender, Inhabitant receiver){
		super(sender, receiver);
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	public void setCost() {
		// TODO implement me	
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	public void createAnswer() {
		// TODO implement me	
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	public boolean isRegistered() {
		// TODO implement me
		return false;	
	}
	
	public String getDescription () {
		return "registered letter";
	}

	@Override
	public void doAction() {
		// TODO Auto-generated method stub
		
	} 
	
}

