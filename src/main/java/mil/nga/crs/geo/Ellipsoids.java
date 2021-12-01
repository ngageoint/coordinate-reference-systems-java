package mil.nga.crs.geo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import mil.nga.crs.CRSException;

/**
 * Common Ellipsoids
 * 
 * @author osbornb
 * @since 1.1.0
 */
public enum Ellipsoids {

	/**
	 * International
	 */
	INTERNATIONAL("intl", 6378388.0, 0.0, 297.0, "International 1909 (Hayford)",
			"International 1924 (Hayford)"),

	/**
	 * Bessel
	 */
	BESSEL("bessel", 6377397.155, 0.0, 299.1528128, "Bessel 1841"),

	/**
	 * Clarke 1866
	 */
	CLARKE_1866("clrk66", 6378206.4, 6356583.8, 0.0, "Clarke 1866"),

	/**
	 * Clarke 1880
	 */
	CLARKE_1880("clrk80", 6378249.145, 0.0, 293.4663, "Clarke 1880 mod.",
			"Clarke 1880 (RGS)"),

	/**
	 * Airy
	 */
	AIRY("airy", 6377563.396, 6356256.910, 0.0, "Airy 1830"),

	/**
	 * WGS 60
	 */
	WGS60("WGS60", 6378165.0, 0.0, 298.3, "WGS 60"),

	/**
	 * WGS 66
	 */
	WGS66("WGS66", 6378145.0, 0.0, 298.25, "WGS 66", "NWL 9D"),

	/**
	 * WGS 72
	 */
	WGS72("WGS72", 6378135.0, 0.0, 298.26, "WGS 72"),

	/**
	 * WGS 84
	 */
	WGS84("WGS84", 6378137.0, 0.0, 298.257223563, "WGS 84"),

	/**
	 * Krassovsky
	 */
	KRASSOVSKY("krass", 6378245.0, 0.0, 298.3, "Krassovsky, 1942",
			"Krassovsky 1942", "Krassowsky 1940"),

	/**
	 * Everest 1830
	 */
	EVEREST("evrst30", 6377276.345, 0.0, 300.8017, "Everest 1830"),

	/**
	 * International 1967
	 */
	INTERNATIONAL_1967("new_intl", 6378157.5, 6356772.2, 0.0,
			"New International 1967"),

	/**
	 * GRS 1980
	 */
	GRS80("GRS80", 6378137.0, 0.0, 298.257222101, "GRS 1980 (IUGG, 1980)"),

	/**
	 * Australian
	 */
	AUSTRALIAN("australian", 6378160.0, 6356774.7, 298.25, "Australian"),

	/**
	 * Merit
	 */
	MERIT("MERIT", 6378137.0, 0.0, 298.257, "MERIT 1983"),

	/**
	 * Soviet Geodetic System 85
	 */
	SGS85("SGS85", 6378136.0, 0.0, 298.257, "Soviet Geodetic System 85"),

	/**
	 * IAU 1976
	 */
	IAU76("IAU76", 6378140.0, 0.0, 298.257, "IAU 1976"),

	/**
	 * Appl. Physics.
	 */
	APL4_9("APL4.9", 6378137.0, 0.0, 298.25, "Appl. Physics. 1965"),

	/**
	 * Naval Weapons Lab.
	 */
	NWL9D("NWL9D", 6378145.0, 0.0, 298.25, "Naval Weapons Lab., 1965"),

	/**
	 * Modified Airy
	 */
	MOD_AIRY("mod_airy", 6377340.189, 6356034.446, 0.0, "Modified Airy",
			"Airy Modified 1849"),

	/**
	 * Andrae
	 */
	ANDRAE("andrae", 6377104.43, 0.0, 300.0, "Andrae 1876 (Den., Iclnd.)"),

	/**
	 * Australian Natl and S. Amer.
	 */
	AUST_SA("aust_SA", 6378160.0, 0.0, 298.25,
			"Australian Natl & S. Amer. 1969", "GRS 1967 Modified"),

	/**
	 * GRS 1967
	 */
	GRS67("GRS67", 6378160.0, 0.0, 298.2471674270, "GRS 67 (IUGG 1967)",
			"GRS 1967"),

	/**
	 * Bessel Namibia
	 */
	BESS_NAM("bess_nam", 6377483.865, 0.0, 299.1528128, "Bessel 1841 (Namibia)",
			"Bessel Namibia (GLM)"),

	/**
	 * Comm. des Poids et Mesures
	 */
	CPM("CPM", 6375738.7, 0.0, 334.29, "Comm. des Poids et Mesures 1799"),

	/**
	 * Delambre
	 */
	DELMBR("delmbr", 6376428.0, 0.0, 311.5, "Delambre 1810 (Belgium)"),

	/**
	 * Engelis
	 */
	ENGELIS("engelis", 6378136.05, 0.0, 298.2566, "Engelis 1985"),

	/**
	 * Everest 1948
	 */
	EVRST48("evrst48", 6377304.063, 0.0, 300.8017, "Everest 1948"),

	/**
	 * Everest 1956
	 */
	EVRST56("evrst56", 6377301.243, 0.0, 300.8017, "Everest 1956"),

	/**
	 * Everest 1969
	 */
	EVRTS69("evrst69", 6377295.664, 0.0, 300.8017, "Everest 1969"),

	/**
	 * Everest (Sabah and Sarawak)
	 */
	EVRTSTSS("evrstSS", 6377298.556, 0.0, 300.8017, "Everest (Sabah & Sarawak)",
			"Everest 1830 (1967 Definition)"),

	/**
	 * Fischer (Mercury Datum) 1960
	 */
	FRSCH60("fschr60", 6378166.0, 0.0, 298.3, "Fischer (Mercury Datum) 1960"),

	/**
	 * Modified Fischer 1960
	 */
	FSRCH60M("fschr60m", 6378155.0, 0.0, 298.3, "Modified Fischer 1960"),

	/**
	 * Fischer 1968
	 */
	FSCHR68("fschr68", 6378150.0, 0.0, 298.3, "Fischer 1968"),

	/**
	 * Helmert
	 */
	HELMERT("helmert", 6378200.0, 0.0, 298.3, "Helmert 1906"),

	/**
	 * Hough
	 */
	HOUGH("hough", 6378270.0, 0.0, 297.0, "Hough"),

	/**
	 * Kaula
	 */
	KAULA("kaula", 6378163.0, 0.0, 298.24, "Kaula 1961"),

	/**
	 * Lerch
	 */
	LERCH("lerch", 6378139.0, 0.0, 298.257, "Lerch 1979"),

	/**
	 * Maupertius
	 */
	MPRTS("mprts", 6397300.0, 0.0, 191.0, "Maupertius 1738"),

	/**
	 * Plessis
	 */
	PLESSIS("plessis", 6376523.0, 6355863.0, 0.0, "Plessis 1817 (France)"),

	/**
	 * Southeast Asia
	 */
	SEASIA("SEasia", 6378155.0, 6356773.3205, 0.0, "Southeast Asia"),

	/**
	 * Walbeck
	 */
	WALBECK("walbeck", 6376896.0, 6355834.8467, 0.0, "Walbeck"),

	/**
	 * NAD27
	 */
	NAD27("NAD27", 6378249.145, 0.0, 293.4663, "NAD27: Clarke 1880 mod."),

	/**
	 * NAD83
	 */
	NAD83("NAD83", 6378137.0, 0.0, 298.257222101,
			"NAD83: GRS 1980 (IUGG, 1980)"),

	/**
	 * Sphere
	 */
	SPHERE("sphere", 6371008.7714, 6371008.7714, 0.0, "Sphere");

	/**
	 * Name to ellipsoids type mapping
	 */
	private static final Map<String, Ellipsoids> nameTypes = new HashMap<>();
	static {
		for (Ellipsoids type : values()) {
			nameTypes.put(type.getShortName().toLowerCase(), type);
			for (String name : type.getNames()) {
				String lowercaseName = name.toLowerCase();
				if (!nameTypes.containsKey(lowercaseName)) {
					nameTypes.put(lowercaseName, type);
				}
			}
		}
	}

	/**
	 * Names
	 */
	private final List<String> names = new ArrayList<>();

	/**
	 * Short name
	 */
	private final String shortName;

	/**
	 * Equator radius
	 */
	private final double equatorRadius;

	/**
	 * Pole radius
	 */
	private final double poleRadius;

	/**
	 * Reciprocal flattening
	 */
	private final double reciprocalFlattening;

	/**
	 * Eccentricity
	 */
	private final double eccentricity;

	/**
	 * Eccentricity squared
	 */
	private final double eccentricity2;

	/**
	 * Constructor
	 * 
	 * @param shortName
	 *            short name
	 * @param equatorRadius
	 *            equator radius
	 * @param poleRadius
	 *            pole radius
	 * @param reciprocalFlattening
	 *            reciprocal flattening
	 * @param names
	 *            names
	 */
	private Ellipsoids(String shortName, double equatorRadius,
			double poleRadius, double reciprocalFlattening, String... names) {
		this.shortName = shortName;
		this.equatorRadius = equatorRadius;
		this.reciprocalFlattening = reciprocalFlattening;

		for (String name : names) {
			int index = name.indexOf("(");
			if (index > -1) {
				this.names.add(name.substring(0, index).trim());
			}
			this.names.add(name);
		}

		if (poleRadius == 0.0 && reciprocalFlattening == 0.0) {
			throw new CRSException(
					"One of poleRadius or reciprocalFlattening must be specified");
		}

		if (reciprocalFlattening != 0) {
			double flattening = 1.0 / reciprocalFlattening;
			double f = flattening;
			this.eccentricity2 = 2 * f - f * f;
			poleRadius = equatorRadius * Math.sqrt(1.0 - this.eccentricity2);
		} else {
			this.eccentricity2 = 1.0 - (poleRadius * poleRadius)
					/ (equatorRadius * equatorRadius);
		}
		this.poleRadius = poleRadius;
		this.eccentricity = Math.sqrt(this.eccentricity2);
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
	 * Get the short name
	 * 
	 * @return short name
	 */
	public String getShortName() {
		return shortName;
	}

	/**
	 * Get the equator radius
	 * 
	 * @return equator radius
	 */
	public double getEquatorRadius() {
		return equatorRadius;
	}

	/**
	 * Get the reciprocal flattening
	 * 
	 * @return reciprocal flattening
	 * @since 1.1.1
	 */
	public double getReciprocalFlattening() {
		return reciprocalFlattening;
	}

	/**
	 * Get the a
	 * 
	 * @return a
	 */
	public double getA() {
		return equatorRadius;
	}

	/**
	 * Get the pole radius
	 * 
	 * @return pole radius
	 */
	public double getPoleRadius() {
		return poleRadius;
	}

	/**
	 * Get the b
	 * 
	 * @return b
	 */
	public double getB() {
		return poleRadius;
	}

	/**
	 * Get the eccentricity
	 * 
	 * @return eccentricity
	 */
	public double getEccentricity() {
		return eccentricity;
	}

	/**
	 * Get the eccentricity squared
	 * 
	 * @return eccentricity squared
	 */
	public double getEccentricitySquared() {
		return eccentricity2;
	}

	/**
	 * Get the ellipsoids type from the name
	 * 
	 * @param name
	 *            ellipsoid name
	 * @return ellipsoids type
	 */
	public static Ellipsoids fromName(String name) {
		return nameTypes.get(name.toLowerCase());
	}

}
