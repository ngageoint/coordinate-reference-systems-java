package mil.nga.crs.vertical;

import java.util.List;

import mil.nga.crs.common.DatumEnsemble;
import mil.nga.crs.common.DatumEnsembleMember;

/**
 * Vertical Datum Ensemble
 * 
 * @author osbornb
 */
public class VerticalDatumEnsemble extends DatumEnsemble {

	/**
	 * Constructor
	 */
	public VerticalDatumEnsemble() {

	}

	/**
	 * Constructor
	 * 
	 * @param name
	 *            name
	 * @param member
	 *            member
	 * @param accuracy
	 *            accuracy
	 */
	public VerticalDatumEnsemble(String name, DatumEnsembleMember member,
			double accuracy) {
		super(name, member, accuracy);
	}

	/**
	 * Constructor
	 * 
	 * @param name
	 *            name
	 * @param members
	 *            members
	 * @param accuracy
	 *            accuracy
	 */
	public VerticalDatumEnsemble(String name, List<DatumEnsembleMember> members,
			double accuracy) {
		super(name, members, accuracy);
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
