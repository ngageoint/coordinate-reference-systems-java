package mil.nga.crs.geo;

import java.util.HashMap;
import java.util.Map;

/**
 * Common Prime Meridians
 * 
 * @author osbornb
 * @since 1.1.0
 */
public enum PrimeMeridians {

	/**
	 * Greenwich
	 */
	GREENWICH("greenwich", 0),

	/**
	 * Lisbon
	 */
	LISBON("lisbon", true, 9, 7, 54.862),

	/**
	 * Paris
	 */
	PARIS("paris", false, 2, 20, 14.025),

	/**
	 * Bogota
	 */
	BOGOTA("bogota", true, 74, 04, 51.3),

	/**
	 * Madrid
	 */
	MADRID("madrid", true, 3, 41, 16.58),

	/**
	 * Rome
	 */
	ROME("rome", false, 12, 27, 8.4),

	/**
	 * Bern
	 */
	BERN("bern", false, 7, 26, 22.5),

	/**
	 * Jakarta
	 */
	JAKARTA("jakarta", false, 106, 48, 27.79),

	/**
	 * Ferro
	 */
	FERRO("ferro", true, 17, 40, 0),

	/**
	 * Brussels
	 */
	BRUSSELS("brussels", false, 4, 22, 4.71),

	/**
	 * Stockholm
	 */
	STOCKHOLM("stockholm", false, 18, 3, 29.8),

	/**
	 * Athens
	 */
	ATHENS("athens", false, 23, 42, 58.815),

	/**
	 * Oslo
	 */
	OSLO("oslo", false, 10, 43, 22.5);

	/**
	 * Name to prime meridians type mapping
	 */
	private static final Map<String, PrimeMeridians> nameTypes = new HashMap<>();
	static {
		for (PrimeMeridians type : values()) {
			nameTypes.put(type.getName().toLowerCase(), type);
		}
	}

	/**
	 * Name
	 */
	private final String name;

	/**
	 * Offset from greenwich
	 */
	private final double offsetFromGreenwich;

	/**
	 * Constructor
	 * 
	 * @param name
	 * @param west
	 * @param degree
	 * @param minute
	 * @param second
	 */
	private PrimeMeridians(String name, boolean west, double degree,
			double minute, double second) {
		this(name, getLongitude(west, degree, minute, second));
	}

	/**
	 * Constructor
	 * 
	 * @param name
	 *            name
	 * @param offsetFromGreenwich
	 *            offset from greenwich
	 */
	private PrimeMeridians(String name, double offsetFromGreenwich) {
		this.name = name;
		this.offsetFromGreenwich = offsetFromGreenwich;
	}

	/**
	 * Get the name
	 * 
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Get the offset from greenwich
	 * 
	 * @return offset longitude
	 */
	public double getOffsetFromGreenwich() {
		return offsetFromGreenwich;
	}

	/**
	 * Get the prime meridians type from the name
	 * 
	 * @param name
	 *            prime meridian name
	 * @return prime meridians type
	 */
	public static PrimeMeridians fromName(String name) {
		return nameTypes.get(name.toLowerCase());
	}

	/**
	 * Get the longitude
	 * 
	 * @param west
	 *            true if west, false if east
	 * @param degree
	 *            degrees
	 * @param minute
	 *            minutes
	 * @param second
	 *            seconds
	 * @return longitude
	 */
	private static double getLongitude(boolean west, double degree,
			double minute, double second) {
		double longitude;
		if (west) {
			longitude = getWestLongitude(degree, minute, second);
		} else {
			longitude = getEastLongitude(degree, minute, second);
		}
		return longitude;
	}

	/**
	 * Get the east longitude
	 * 
	 * @param degree
	 *            degrees
	 * @param minute
	 *            minutes
	 * @param second
	 *            seconds
	 * @return east longitude
	 */
	private static double getEastLongitude(double degree, double minute,
			double second) {
		return ((second / 60.0 + minute) / 60.0 + degree) * (Math.PI / 180.0);
	}

	/**
	 * Get the west longitude
	 * 
	 * @param degree
	 *            degrees
	 * @param minute
	 *            minutes
	 * @param second
	 *            seconds
	 * @return west longitude
	 */
	private static double getWestLongitude(double degree, double minute,
			double second) {
		return getEastLongitude(-degree, -minute, -second);
	}

}
