package mil.nga.crs.engineering;

import mil.nga.crs.CRSType;
import mil.nga.crs.common.ReferenceFrame;

/**
 * Engineering Datum
 * 
 * @author osbornb
 */
public class EngineeringDatum extends ReferenceFrame {

	/**
	 * Constructor
	 */
	public EngineeringDatum() {
		super(CRSType.ENGINEERING);
	}

	/**
	 * Constructor
	 * 
	 * @param name
	 *            name
	 */
	public EngineeringDatum(String name) {
		super(name, CRSType.ENGINEERING);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		return super.hashCode();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		return true;
	}

}
