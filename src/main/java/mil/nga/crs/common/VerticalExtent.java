package mil.nga.crs.common;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import mil.nga.crs.wkt.CRSWriter;

/**
 * Vertical Extent
 * 
 * @author osbornb
 */
public class VerticalExtent {

	/**
	 * Logger
	 */
	private static final Logger logger = Logger
			.getLogger(VerticalExtent.class.getName());

	/**
	 * Minimum Height
	 */
	private double minimumHeight;

	/**
	 * Minimum Height Text
	 */
	private String minimumHeightText;

	/**
	 * Maximum Height
	 */
	private double maximumHeight;

	/**
	 * Maximum Height Text
	 */
	private String maximumHeightText;

	/**
	 * Unit (Length)
	 */
	private Unit unit = null;

	/**
	 * Constructor
	 */
	public VerticalExtent() {

	}

	/**
	 * Constructor
	 * 
	 * @param minimumHeight
	 *            minimum height
	 * @param maximumHeight
	 *            maximum height
	 */
	public VerticalExtent(double minimumHeight, double maximumHeight) {
		this(minimumHeight, maximumHeight, null);
	}

	/**
	 * Constructor
	 * 
	 * @param minimumHeight
	 *            minimum height
	 * @param maximumHeight
	 *            maximum height
	 * @since 1.1.0
	 */
	public VerticalExtent(String minimumHeight, String maximumHeight) {
		this(minimumHeight, maximumHeight, null);
	}

	/**
	 * Constructor
	 * 
	 * @param minimumHeight
	 *            minimum height
	 * @param maximumHeight
	 *            maximum height
	 * @param unit
	 *            unit (length)
	 */
	public VerticalExtent(double minimumHeight, double maximumHeight,
			Unit unit) {
		setMinimumHeight(minimumHeight);
		setMaximumHeight(maximumHeight);
		setUnit(unit);
	}

	/**
	 * Constructor
	 * 
	 * @param minimumHeight
	 *            minimum height
	 * @param maximumHeight
	 *            maximum height
	 * @param unit
	 *            unit (length)
	 * @since 1.1.0
	 */
	public VerticalExtent(String minimumHeight, String maximumHeight,
			Unit unit) {
		setMinimumHeight(minimumHeight);
		setMaximumHeight(maximumHeight);
		setUnit(unit);
	}

	/**
	 * Get the minimum height
	 * 
	 * @return minimum height
	 */
	public double getMinimumHeight() {
		return minimumHeight;
	}

	/**
	 * Get the minimum height text
	 * 
	 * @return minimum height text
	 * @since 1.1.0
	 */
	public String getMinimumHeightText() {
		return minimumHeightText;
	}

	/**
	 * Set the minimum height
	 * 
	 * @param minimumHeight
	 *            minimum height
	 */
	public void setMinimumHeight(double minimumHeight) {
		this.minimumHeight = minimumHeight;
		this.minimumHeightText = String.valueOf(minimumHeight);
	}

	/**
	 * Set the minimum height
	 * 
	 * @param minimumHeight
	 *            minimum height
	 * @since 1.1.0
	 */
	public void setMinimumHeight(String minimumHeight) {
		this.minimumHeightText = minimumHeight;
		this.minimumHeight = Double.parseDouble(minimumHeight);
	}

	/**
	 * Get the maximum height
	 * 
	 * @return maximum height
	 */
	public double getMaximumHeight() {
		return maximumHeight;
	}

	/**
	 * Get the maximum height text
	 * 
	 * @return maximum height text
	 * @since 1.1.0
	 */
	public String getMaximumHeightText() {
		return maximumHeightText;
	}

	/**
	 * Set the maximum height
	 * 
	 * @param maximumHeight
	 *            maximum height
	 */
	public void setMaximumHeight(double maximumHeight) {
		this.maximumHeight = maximumHeight;
		this.maximumHeightText = String.valueOf(maximumHeight);
	}

	/**
	 * Set the maximum height
	 * 
	 * @param maximumHeight
	 *            maximum height
	 * @since 1.1.0
	 */
	public void setMaximumHeight(String maximumHeight) {
		this.maximumHeightText = maximumHeight;
		this.maximumHeight = Double.parseDouble(maximumHeight);
	}

	/**
	 * Get the unit (length)
	 * 
	 * @return unit (length)
	 */
	public Unit getUnit() {
		return unit;
	}

	/**
	 * Has a unit (length)
	 * 
	 * @return true if has unit (length)
	 */
	public boolean hasUnit() {
		return getUnit() != null;
	}

	/**
	 * Set the unit (length)
	 * 
	 * @param unit
	 *            unit (length)
	 */
	public void setUnit(Unit unit) {
		this.unit = unit;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((unit == null) ? 0 : unit.hashCode());
		long temp;
		temp = Double.doubleToLongBits(maximumHeight);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(minimumHeight);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VerticalExtent other = (VerticalExtent) obj;
		if (unit == null) {
			if (other.unit != null)
				return false;
		} else if (!unit.equals(other.unit))
			return false;
		if (Double.doubleToLongBits(maximumHeight) != Double
				.doubleToLongBits(other.maximumHeight))
			return false;
		if (Double.doubleToLongBits(minimumHeight) != Double
				.doubleToLongBits(other.minimumHeight))
			return false;
		return true;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		String value = null;
		CRSWriter writer = new CRSWriter();
		try {
			writer.write(this);
			value = writer.toString();
		} catch (IOException e) {
			logger.log(Level.WARNING,
					"Failed to write vertical extent as a string", e);
			value = super.toString();
		} finally {
			writer.close();
		}
		return value;
	}

}
