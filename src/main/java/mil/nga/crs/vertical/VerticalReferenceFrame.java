package mil.nga.crs.vertical;

import mil.nga.crs.CRSType;
import mil.nga.crs.common.ReferenceFrame;

/**
 * Vertical Reference Frame (datum)
 * 
 * @author osbornb
 */
public class VerticalReferenceFrame extends ReferenceFrame {

	/**
	 * Constructor
	 */
	public VerticalReferenceFrame() {
		super(CRSType.VERTICAL);
	}

	/**
	 * Constructor
	 * 
	 * @param name
	 *            name
	 */
	public VerticalReferenceFrame(String name) {
		super(name, CRSType.VERTICAL);
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
