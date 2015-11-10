package model.letter;
import model.city.Inhabitant;


/**
 * A besoin du type Generique LEtter
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */

public class UrgentLetter extends Letter
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
	public UrgentLetter(){
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	public void createLetter(Inhabitant sender, Inhabitant receiver, Letter letter) {
		// TODO implement me	
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
	
	public boolean isUrgent() {
		// TODO implement me
		return false;	
	}
	
}

