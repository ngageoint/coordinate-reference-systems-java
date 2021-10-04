package mil.nga.crs.common;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import mil.nga.crs.wkt.CRSWriter;

/**
 * Geographic Bounding Box
 * 
 * @author osbornb
 */
public class GeographicBoundingBox {

	/**
	 * Logger
	 */
	private static final Logger logger = Logger
			.getLogger(GeographicBoundingBox.class.getName());

	/**
	 * Lower Left Latitude
	 */
	private double lowerLeftLatitude;

	/**
	 * Lower Left Latitude Text
	 */
	private String lowerLeftLatitudeText;

	/**
	 * Lower Left Longitude
	 */
	private double lowerLeftLongitude;

	/**
	 * Lower Left Longitude Text
	 */
	private String lowerLeftLongitudeText;

	/**
	 * Upper Right Latitude
	 */
	private double upperRightLatitude;

	/**
	 * Upper Right Latitude Text
	 */
	private String upperRightLatitudeText;

	/**
	 * Upper Right Longitude
	 */
	private double upperRightLongitude;

	/**
	 * Upper Right Longitude Text
	 */
	private String upperRightLongitudeText;

	/**
	 * Constructor
	 */
	public GeographicBoundingBox() {

	}

	/**
	 * Constructor
	 * 
	 * @param lowerLeftLatitude
	 *            lower left latitude
	 * @param lowerLeftLongitude
	 *            lower left longitude
	 * @param upperRightLatitude
	 *            upper right latitude
	 * @param upperRightLongitude
	 *            upper right longitude
	 */
	public GeographicBoundingBox(double lowerLeftLatitude,
			double lowerLeftLongitude, double upperRightLatitude,
			double upperRightLongitude) {
		setLowerLeftLatitude(lowerLeftLatitude);
		setLowerLeftLongitude(lowerLeftLongitude);
		setUpperRightLatitude(upperRightLatitude);
		setUpperRightLongitude(upperRightLongitude);
	}

	/**
	 * Constructor
	 * 
	 * @param lowerLeftLatitude
	 *            lower left latitude
	 * @param lowerLeftLongitude
	 *            lower left longitude
	 * @param upperRightLatitude
	 *            upper right latitude
	 * @param upperRightLongitude
	 *            upper right longitude
	 * @since 1.1.0
	 */
	public GeographicBoundingBox(String lowerLeftLatitude,
			String lowerLeftLongitude, String upperRightLatitude,
			String upperRightLongitude) {
		setLowerLeftLatitude(lowerLeftLatitude);
		setLowerLeftLongitude(lowerLeftLongitude);
		setUpperRightLatitude(upperRightLatitude);
		setUpperRightLongitude(upperRightLongitude);
	}

	/**
	 * Get the lower left latitude
	 * 
	 * @return lower left latitude
	 */
	public double getLowerLeftLatitude() {
		return lowerLeftLatitude;
	}

	/**
	 * Get the lower left latitude text
	 * 
	 * @return lower left latitude text
	 * @since 1.1.0
	 */
	public String getLowerLeftLatitudeText() {
		return lowerLeftLatitudeText;
	}

	/**
	 * Set the lower left latitude
	 * 
	 * @param lowerLeftLatitude
	 *            lower left latitude
	 */
	public void setLowerLeftLatitude(double lowerLeftLatitude) {
		this.lowerLeftLatitude = lowerLeftLatitude;
		this.lowerLeftLatitudeText = String.valueOf(lowerLeftLatitude);
	}

	/**
	 * Set the lower left latitude
	 * 
	 * @param lowerLeftLatitude
	 *            lower left latitude
	 * @since 1.1.0
	 */
	public void setLowerLeftLatitude(String lowerLeftLatitude) {
		this.lowerLeftLatitudeText = lowerLeftLatitude;
		this.lowerLeftLatitude = Double.parseDouble(lowerLeftLatitude);
	}

	/**
	 * Get the lower left longitude
	 * 
	 * @return lower left longitude
	 */
	public double getLowerLeftLongitude() {
		return lowerLeftLongitude;
	}

	/**
	 * Get the lower left longitude text
	 * 
	 * @return lower left longitude text
	 * @since 1.1.0
	 */
	public String getLowerLeftLongitudeText() {
		return lowerLeftLongitudeText;
	}

	/**
	 * Set the lower left longitude
	 * 
	 * @param lowerLeftLongitude
	 *            lower left longitude
	 */
	public void setLowerLeftLongitude(double lowerLeftLongitude) {
		this.lowerLeftLongitude = lowerLeftLongitude;
		this.lowerLeftLongitudeText = String.valueOf(lowerLeftLongitude);
	}

	/**
	 * Set the lower left longitude
	 * 
	 * @param lowerLeftLongitude
	 *            lower left longitude
	 * @since 1.1.0
	 */
	public void setLowerLeftLongitude(String lowerLeftLongitude) {
		this.lowerLeftLongitudeText = lowerLeftLongitude;
		this.lowerLeftLongitude = Double.parseDouble(lowerLeftLongitude);
	}

	/**
	 * Set the upper right latitude
	 * 
	 * @return upper right latitude
	 */
	public double getUpperRightLatitude() {
		return upperRightLatitude;
	}

	/**
	 * Set the upper right latitude text
	 * 
	 * @return upper right latitude text
	 * @since 1.1.0
	 */
	public String getUpperRightLatitudeText() {
		return upperRightLatitudeText;
	}

	/**
	 * Set the upper right latitude
	 * 
	 * @param upperRightLatitude
	 *            upper right latitude
	 */
	public void setUpperRightLatitude(double upperRightLatitude) {
		this.upperRightLatitude = upperRightLatitude;
		this.upperRightLatitudeText = String.valueOf(upperRightLatitude);
	}

	/**
	 * Set the upper right latitude
	 * 
	 * @param upperRightLatitude
	 *            upper right latitude
	 * @since 1.1.0
	 */
	public void setUpperRightLatitude(String upperRightLatitude) {
		this.upperRightLatitudeText = upperRightLatitude;
		this.upperRightLatitude = Double.parseDouble(upperRightLatitude);
	}

	/**
	 * Set the upper right longitude
	 * 
	 * @return upper right longitude
	 */
	public double getUpperRightLongitude() {
		return upperRightLongitude;
	}

	/**
	 * Set the upper right longitude text
	 * 
	 * @return upper right longitude text
	 * @since 1.1.0
	 */
	public String getUpperRightLongitudeText() {
		return upperRightLongitudeText;
	}

	/**
	 * Set the upper right longitude
	 * 
	 * @param upperRightLongitude
	 *            upper right longitude
	 */
	public void setUpperRightLongitude(double upperRightLongitude) {
		this.upperRightLongitude = upperRightLongitude;
		this.upperRightLongitudeText = String.valueOf(upperRightLongitude);
	}

	/**
	 * Set the upper right longitude
	 * 
	 * @param upperRightLongitude
	 *            upper right longitude
	 * @since 1.1.0
	 */
	public void setUpperRightLongitude(String upperRightLongitude) {
		this.upperRightLongitudeText = upperRightLongitude;
		this.upperRightLongitude = Double.parseDouble(upperRightLongitude);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(lowerLeftLatitude);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(lowerLeftLongitude);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(upperRightLatitude);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(upperRightLongitude);
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
		GeographicBoundingBox other = (GeographicBoundingBox) obj;
		if (Double.doubleToLongBits(lowerLeftLatitude) != Double
				.doubleToLongBits(other.lowerLeftLatitude))
			return false;
		if (Double.doubleToLongBits(lowerLeftLongitude) != Double
				.doubleToLongBits(other.lowerLeftLongitude))
			return false;
		if (Double.doubleToLongBits(upperRightLatitude) != Double
				.doubleToLongBits(other.upperRightLatitude))
			return false;
		if (Double.doubleToLongBits(upperRightLongitude) != Double
				.doubleToLongBits(other.upperRightLongitude))
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
					"Failed to write geographic bounding box as a string", e);
			value = super.toString();
		} finally {
			writer.close();
		}
		return value;
	}

}
