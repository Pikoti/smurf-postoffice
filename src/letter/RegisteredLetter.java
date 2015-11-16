package letter;

import city.Postbox;


/**
 * <span style="font-size: 12.8px;">A besoin du type Generique LEtter</span>
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */

public class RegisteredLetter extends LetterDecorator {

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 */
	public RegisteredLetter(Letter letter){
		super(letter);
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
		return true;	
	}
	
	public String getDescription () {
		return "registered letter";
	}

	@Override
	public void doAction(Postbox postbox) {
		// TODO Auto-generated method stub
		
	} 
	
}

