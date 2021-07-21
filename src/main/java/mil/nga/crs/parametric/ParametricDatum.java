package mil.nga.crs.parametric;

import mil.nga.crs.CRSType;
import mil.nga.crs.common.ReferenceFrame;

/**
 * Parametric Datum
 * 
 * @author osbornb
 */
public class ParametricDatum extends ReferenceFrame {

	/**
	 * Constructor
	 */
	public ParametricDatum() {
		super(CRSType.PARAMETRIC);
	}

	/**
	 * Constructor
	 * 
	 * @param name
	 *            name
	 */
	public ParametricDatum(String name) {
		super(name, CRSType.PARAMETRIC);
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
