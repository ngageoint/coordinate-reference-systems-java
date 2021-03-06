package mil.nga.crs.geo;

import mil.nga.crs.CRSType;
import mil.nga.crs.common.ReferenceFrame;

/**
 * Geodetic and Geographic Reference Frame (datum)
 * 
 * @author osbornb
 */
public class GeoReferenceFrame extends ReferenceFrame implements GeoDatum {

	/**
	 * Ellipsoid
	 */
	private Ellipsoid ellipsoid = null;

	/**
	 * Prime Meridian
	 */
	private PrimeMeridian primeMeridian = null;

	/**
	 * Constructor
	 */
	public GeoReferenceFrame() {
		this(CRSType.GEODETIC);
	}

	/**
	 * Constructor
	 * 
	 * @param type
	 *            geo crs type
	 */
	public GeoReferenceFrame(CRSType type) {
		super(type);
	}

	/**
	 * Constructor
	 * 
	 * @param name
	 *            name
	 * @param ellipsoid
	 *            ellipsoid
	 */
	public GeoReferenceFrame(String name, Ellipsoid ellipsoid) {
		this(name, CRSType.GEODETIC, ellipsoid);
	}

	/**
	 * Constructor
	 * 
	 * @param name
	 *            name
	 * @param type
	 *            geo crs type
	 * @param ellipsoid
	 *            ellipsoid
	 */
	public GeoReferenceFrame(String name, CRSType type, Ellipsoid ellipsoid) {
		super(name, type);
		setEllipsoid(ellipsoid);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Ellipsoid getEllipsoid() {
		return ellipsoid;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setEllipsoid(Ellipsoid ellipsoid) {
		this.ellipsoid = ellipsoid;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public PrimeMeridian getPrimeMeridian() {
		return primeMeridian;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean hasPrimeMeridian() {
		return getPrimeMeridian() != null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setPrimeMeridian(PrimeMeridian primeMeridian) {
		this.primeMeridian = primeMeridian;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((ellipsoid == null) ? 0 : ellipsoid.hashCode());
		result = prime * result
				+ ((primeMeridian == null) ? 0 : primeMeridian.hashCode());
		return result;
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
		GeoReferenceFrame other = (GeoReferenceFrame) obj;
		if (ellipsoid == null) {
			if (other.ellipsoid != null)
				return false;
		} else if (!ellipsoid.equals(other.ellipsoid))
			return false;
		if (primeMeridian == null) {
			if (other.primeMeridian != null)
				return false;
		} else if (!primeMeridian.equals(other.primeMeridian))
			return false;
		return true;
	}

}
