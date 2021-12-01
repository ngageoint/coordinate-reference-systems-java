package mil.nga.crs.geo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Common Geo Datums
 * 
 * @author osbornb
 * @since 1.1.0
 */
public enum GeoDatums {

	/**
	 * WGS 84
	 */
	WGS84("WGS84", 0, 0, 0, Ellipsoids.WGS84, "WGS84",
			"World Geodetic System 1984 ensemble", "WGS 1984", "WGS 84",
			"World Geodetic System 1984"),

	/**
	 * Greek Geodetic Reference System 1987
	 */
	GGRS87("GGRS87", -199.87, 74.79, 246.62, Ellipsoids.GRS80,
			"Greek Geodetic Reference System 1987"),

	/**
	 * North American Datum 1983
	 */
	NAD83("NAD83", 0, 0, 0, Ellipsoids.GRS80, "North American Datum 1983"),

	/**
	 * European Terrestrial Reference System 1989 ensemble
	 */
	ETRS89("ETRS89", 0, 0, 0, Ellipsoids.GRS80,
			"European Terrestrial Reference System 1989",
			"European Terrestrial Reference System 1989 ensemble"),

	/**
	 * North American Datum 1927
	 */
	NAD27("NAD27", Ellipsoids.CLARKE_1866, "North American Datum 1927"),

	/**
	 * Potsdam
	 */
	POTSDAM("potsdam", 598.1, 73.7, 418.2, 0.202, 0.045, -2.455, 6.7,
			Ellipsoids.BESSEL, "Potsdam Rauenberg 1950 DHDN",
			"Deutsches Hauptdreiecksnetz"),

	/**
	 * Carthage
	 */
	CARTHAGE("carthage", -263.0, 6.0, 431.0, Ellipsoids.CLARKE_1880,
			"Carthage 1934 Tunisia", "Carthage"),

	/**
	 * Hermannskogel
	 */
	HERMANNSKOGEL("hermannskogel", 577.326, 90.129, 463.919, 5.137, 1.474,
			5.297, 2.4232, Ellipsoids.BESSEL, "Hermannskogel",
			"Militar-Geographische Institut",
			"Militar Geographische Institute"),

	/**
	 * Ireland 1965
	 */
	IRE65("ire65", 482.530, -130.596, 564.557, -1.042, -0.214, -0.631, 8.15,
			Ellipsoids.MOD_AIRY, "Ireland 1965", "TM65"),

	/**
	 * New Zealand Geodetic Datum 1949
	 */
	NZGD49("nzgd49", 59.47, -5.04, 187.44, 0.47, -0.1, 1.024, -4.5993,
			Ellipsoids.INTERNATIONAL, "New Zealand Geodetic Datum 1949"),

	/**
	 * Ordnance Survey of Great Britain 1936
	 */
	OSGB36("OSGB36", 446.448, -125.157, 542.06, 0.15, 0.247, 0.842, -20.489,
			Ellipsoids.AIRY, "Airy 1830", "OSGB 1936",
			"Ordnance Survey of Great Britain 1936");

	/**
	 * Code
	 */
	private final String code;

	/**
	 * Names
	 */
	private final List<String> names;

	/**
	 * Transform
	 */
	private final double[] transform;

	/**
	 * Ellipsoid
	 */
	private final Ellipsoids ellipsoid;

	/**
	 * Name to geo datums type mapping
	 */
	private static final Map<String, GeoDatums> nameTypes = new HashMap<>();
	static {
		for (GeoDatums type : values()) {
			nameTypes.put(type.getCode().toLowerCase(), type);
			for (String name : type.getNames()) {
				String lowercaseName = name.toLowerCase();
				nameTypes.put(lowercaseName, type);
			}
		}
	}

	/**
	 * Constructor
	 * 
	 * @param code
	 *            code
	 * @param ellipsoid
	 *            ellipsoid
	 * @param names
	 *            names
	 */
	private GeoDatums(String code, Ellipsoids ellipsoid, String... names) {
		this(code, null, ellipsoid, names);
	}

	/**
	 * Constructor
	 * 
	 * @param code
	 *            code
	 * @param xTranslation
	 *            x translation
	 * @param yTranslation
	 *            y translation
	 * @param zTranslation
	 *            z translation
	 * @param ellipsoid
	 *            ellipsoid
	 * @param names
	 *            names
	 */
	private GeoDatums(String code, double xTranslation, double yTranslation,
			double zTranslation, Ellipsoids ellipsoid, String... names) {
		this(code, new double[] { xTranslation, yTranslation, zTranslation },
				ellipsoid, names);
	}

	/**
	 * Constructor
	 * 
	 * @param code
	 *            code
	 * @param xTranslation
	 *            x translation
	 * @param yTranslation
	 *            y translation
	 * @param zTranslation
	 *            z translation
	 * @param xRotation
	 *            x rotation
	 * @param yRotation
	 *            y rotation
	 * @param zRotation
	 *            z rotation
	 * @param scaleDifference
	 *            scale difference
	 * @param ellipsoid
	 *            ellipsoid
	 * @param names
	 *            names
	 */
	private GeoDatums(String code, double xTranslation, double yTranslation,
			double zTranslation, double xRotation, double yRotation,
			double zRotation, double scaleDifference, Ellipsoids ellipsoid,
			String... names) {
		this(code,
				new double[] { xTranslation, yTranslation, zTranslation,
						xRotation, yRotation, zRotation, scaleDifference },
				ellipsoid, names);
	}

	/**
	 * Constructor
	 * 
	 * @param code
	 *            code
	 * @param transform
	 *            transform
	 * @param ellipsoid
	 *            ellipsoid
	 * @param names
	 *            names
	 */
	private GeoDatums(String code, double[] transform, Ellipsoids ellipsoid,
			String... names) {
		this.code = code;
		this.transform = transform;
		this.ellipsoid = ellipsoid;
		List<String> tempNames = new ArrayList<>();
		for (String name : names) {
			if (!tempNames.contains(name)) {
				tempNames.add(name);
			}
			String underscore = name.replaceAll(" ", "_");
			if (!tempNames.contains(underscore)) {
				tempNames.add(underscore);
			}
		}
		this.names = tempNames;
	}

	/**
	 * Get the code
	 * 
	 * @return code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * Get the name
	 * 
	 * @return name
	 */
	public String getName() {
		return names.get(0);
	}

	/**
	 * Get the names
	 * 
	 * @return names
	 */
	public List<String> getNames() {
		return names;
	}

	/**
	 * Get the transform
	 * 
	 * @return transform
	 */
	public double[] getTransform() {
		return transform;
	}

	/**
	 * Get the ellipsoid
	 * 
	 * @return ellipsoid
	 */
	public Ellipsoids getEllipsoid() {
		return ellipsoid;
	}

	/**
	 * Get the geo datums type from the name
	 * 
	 * @param name
	 *            geo datums name
	 * @return geo datums type
	 */
	public static GeoDatums fromName(String name) {
		return nameTypes.get(name.toLowerCase());
	}

}
