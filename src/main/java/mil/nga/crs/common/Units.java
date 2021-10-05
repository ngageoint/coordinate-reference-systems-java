package mil.nga.crs.common;

import java.util.HashMap;
import java.util.Map;

import mil.nga.crs.CRSException;

/**
 * Common Units
 * 
 * @author osbornb
 * @since 1.1.0
 */
public enum Units {

	/**
	 * Micrometre unit
	 */
	MICROMETRE(UnitType.LENGTHUNIT, "micrometre", 0.000001),

	/**
	 * Millimetre unit
	 */
	MILLIMETRE(UnitType.LENGTHUNIT, "millimetre", 0.001),

	/**
	 * Metre unit
	 */
	METRE(UnitType.LENGTHUNIT, "metre", 1.0),

	/**
	 * Kilometre unit
	 */
	KILOMETRE(UnitType.LENGTHUNIT, "kilometre", 1000.0),

	/**
	 * German legal metre unit
	 */
	GERMAN_LEGAL_METRE(UnitType.LENGTHUNIT, "German legal metre", 1.0000135965),

	/**
	 * US survey foot unit
	 */
	US_SURVEY_FOOT(UnitType.LENGTHUNIT, "US survey foot", 0.304800609601219),

	/**
	 * Foot unit
	 */
	FOOT(UnitType.LENGTHUNIT, "foot", 0.3048),

	/**
	 * Microradian unit
	 */
	MICRORADIAN(UnitType.ANGLEUNIT, "microradian", 0.000001),

	/**
	 * Milliradian unit
	 */
	MILLIRADIAN(UnitType.ANGLEUNIT, "milliradian", 0.001),

	/**
	 * Radian unit
	 */
	RADIAN(UnitType.ANGLEUNIT, "radian", 1.0),

	/**
	 * Arc-second unit
	 */
	ARC_SECOND(UnitType.ANGLEUNIT, "arc-second",
			0.00000484813681109535993589914102357),

	/**
	 * Arc-minute unit
	 */
	ARC_MINUTE(UnitType.ANGLEUNIT, "arc-minute", 0.0002908882086657216),

	/**
	 * Degree unit
	 */
	DEGREE(UnitType.ANGLEUNIT, "degree", 0.017453292519943295),

	/**
	 * Grad unit
	 */
	GRAD(UnitType.ANGLEUNIT, "grad", 0.015707963267949),

	/**
	 * Unity unit
	 */
	UNITY(UnitType.SCALEUNIT, "unity", 1.0),

	/**
	 * Bin unit
	 */
	BIN(UnitType.SCALEUNIT, "bin", 1.0),

	/**
	 * Parts per million unit
	 */
	PARTS_PER_MILLION(UnitType.SCALEUNIT, "parts per million", 0.000001),

	/**
	 * Pascal unit
	 */
	PASCAL(UnitType.PARAMETRICUNIT, "pascal", 1.0),

	/**
	 * Hectopascal unit
	 */
	HECTOPASCAL(UnitType.PARAMETRICUNIT, "hectopascal", 100.0),

	/**
	 * Microsecond unit
	 */
	MICROSECOND(UnitType.TIMEUNIT, "microsecond", 0.000001),

	/**
	 * Millisecond unit
	 */
	MILLISECOND(UnitType.TIMEUNIT, "millisecond", 0.001),

	/**
	 * Second unit
	 */
	SECOND(UnitType.TIMEUNIT, "second", 1.0),

	/**
	 * Minute unit
	 */
	MINUTE(UnitType.TIMEUNIT, "minute", 60.0),

	/**
	 * Hour unit
	 */
	HOUR(UnitType.TIMEUNIT, "hour", 3600.0),

	/**
	 * Day unit
	 */
	DAY(UnitType.TIMEUNIT, "day", 86400.0),

	/**
	 * Year unit
	 */
	YEAR(UnitType.TIMEUNIT, "year", 31557600.0),

	/**
	 * Calendar second unit
	 */
	CALENDAR_SECOND(UnitType.TIMEUNIT, "calendar second"),

	/**
	 * Calendar month unit
	 */
	CALENDAR_MONTH(UnitType.TIMEUNIT, "calendar month");

	/**
	 * Name to units type mapping
	 */
	private static final Map<String, Units> nameTypes = new HashMap<>();
	static {
		for (Units type : values()) {
			String lowercase = type.getName().toLowerCase();
			nameTypes.put(lowercase, type);
			if (lowercase.contains("metre")) {
				nameTypes.put(lowercase.replaceAll("metre", "meter"), type);
			}
		}
	}

	/**
	 * Unit Type
	 */
	private final UnitType type;

	/**
	 * Name
	 */
	private final String name;

	/**
	 * Conversion Factor
	 */
	private final Double conversionFactor;

	/**
	 * Constructor
	 * 
	 * @param type
	 *            unit type
	 * @param name
	 *            name
	 */
	private Units(UnitType type, String name) {
		this.type = type;
		this.name = name;
		this.conversionFactor = null;
	}

	/**
	 * Constructor
	 * 
	 * @param type
	 *            unit type
	 * @param name
	 *            name
	 * @param conversionFactor
	 *            conversion factor
	 */
	private Units(UnitType type, String name, double conversionFactor) {
		this.type = type;
		this.name = name;
		this.conversionFactor = conversionFactor;
	}

	/**
	 * Get the type
	 * 
	 * @return type
	 */
	public UnitType getType() {
		return type;
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
	 * Has conversion factor
	 * 
	 * @return true if has conversion factor
	 */
	public boolean hasConversionFactor() {
		return conversionFactor != null;
	}

	/**
	 * Get the conversion factor
	 * 
	 * @return conversion factor
	 */
	public Double getConversionFactor() {
		return conversionFactor;
	}

	/**
	 * Create a unit
	 * 
	 * @return new unit
	 */
	public Unit createUnit() {
		Unit unit = null;
		if (hasConversionFactor()) {
			unit = new Unit(type, name, conversionFactor);
		} else {
			unit = new Unit(type, name);
		}
		return unit;
	}

	/**
	 * Get the units type from the name
	 * 
	 * @param name
	 *            unit name
	 * @return units type
	 */
	public static Units fromName(String name) {
		return nameTypes.get(name.toLowerCase());
	}

	/**
	 * Get the units type from the unit
	 * 
	 * @param unit
	 *            unit
	 * @return units type
	 */
	public static Units fromUnit(Unit unit) {
		return fromName(unit.getName());
	}

	/**
	 * Get the default unit for the unit type
	 * 
	 * @param type
	 *            unit type
	 * @return default unit or null if no default
	 */
	public static Units getDefaultUnit(UnitType type) {

		Units defaultUnit = null;

		switch (type) {
		case LENGTHUNIT:
			defaultUnit = METRE;
			break;
		case ANGLEUNIT:
			defaultUnit = DEGREE;
			break;
		case SCALEUNIT:
			defaultUnit = UNITY;
			break;
		default:
		}

		return defaultUnit;
	}

	/**
	 * Create the default unit for the unit type
	 * 
	 * @param type
	 *            unit type
	 * @return default unit or null if no default
	 */
	public static Unit createDefaultUnit(UnitType type) {

		Unit defaultUnit = null;

		Units defaultUnits = getDefaultUnit(type);
		if (defaultUnits != null) {
			defaultUnit = defaultUnits.createUnit();
		}

		return defaultUnit;
	}

	/**
	 * Determine if values can be converted between the two units
	 * 
	 * @param unit1
	 *            first unit
	 * @param unit2
	 *            second unit
	 * @return true if can convert
	 */
	public static boolean canConvert(Unit unit1, Unit unit2) {
		return unit1 != null && unit2 != null
				&& (unit1.getType() == unit2.getType()
						|| unit1.getType() == UnitType.UNIT
						|| unit2.getType() == UnitType.UNIT)
				&& unit1.hasConversionFactor() && unit2.hasConversionFactor();
	}

	/**
	 * Convert the value from a unit to a same typed unit, both with conversion
	 * factors
	 * 
	 * @param value
	 *            value to convert
	 * @param from
	 *            unit to convert from
	 * @param to
	 *            unit to convert to
	 * @return converted value
	 */
	public static double convert(double value, Unit from, Unit to) {

		if (from.getType() != to.getType() && from.getType() != UnitType.UNIT
				&& to.getType() != UnitType.UNIT) {
			throw new CRSException("Can't convert value '" + value
					+ "' from unit type " + from.getType().name()
					+ " to unit type " + to.getType().name());
		}

		if (!from.hasConversionFactor()) {
			throw new CRSException("Can't convert value '" + value
					+ "' from unit type " + from.getType().name()
					+ " without a conversion factor.");
		}

		if (!to.hasConversionFactor()) {
			throw new CRSException("Can't convert value '" + value
					+ "' to unit type " + to.getType().name()
					+ " without a conversion factor.");
		}

		return value * (from.getConversionFactor() / to.getConversionFactor());
	}

}
