package mil.nga.crs.common;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import mil.nga.crs.wkt.CRSWriter;

/**
 * Unit
 * 
 * @author osbornb
 */
public class Unit implements Identifiable {

	/**
	 * Logger
	 */
	private static final Logger logger = Logger.getLogger(Unit.class.getName());

	/**
	 * Unit Type
	 */
	private UnitType type = null;

	/**
	 * Name
	 */
	private String name = null;

	/**
	 * Conversion Factor
	 */
	private Double conversionFactor;

	/**
	 * Conversion Factor Text
	 */
	private String conversionFactorText;

	/**
	 * Identifiers
	 */
	private List<Identifier> identifiers = null;

	/**
	 * Constructor
	 */
	public Unit() {

	}

	/**
	 * Constructor
	 * 
	 * @param type
	 *            unit type
	 * @param name
	 *            name
	 */
	public Unit(UnitType type, String name) {
		setType(type);
		setName(name);
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
	public Unit(UnitType type, String name, double conversionFactor) {
		setType(type);
		setName(name);
		setConversionFactor(conversionFactor);
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
	 * @since 1.1.0
	 */
	public Unit(UnitType type, String name, String conversionFactor) {
		setType(type);
		setName(name);
		setConversionFactor(conversionFactor);
	}

	/**
	 * Get the unit type
	 * 
	 * @return unit type
	 */
	public UnitType getType() {
		return type;
	}

	/**
	 * Set the unit type
	 * 
	 * @param type
	 *            unit type
	 */
	public void setType(UnitType type) {
		this.type = type;
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
	 * Set the name
	 * 
	 * @param name
	 *            name
	 */
	public void setName(String name) {
		this.name = name;
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
	 * Get the conversion factor text
	 * 
	 * @return conversion factor text
	 * @since 1.1.0
	 */
	public String getConversionFactorText() {
		return conversionFactorText;
	}

	/**
	 * Has a conversion factor
	 * 
	 * @return true if has conversion factor
	 */
	public boolean hasConversionFactor() {
		return getConversionFactor() != null;
	}

	/**
	 * Set the conversion factor
	 * 
	 * @param conversionFactor
	 *            conversion factor
	 */
	public void setConversionFactor(Double conversionFactor) {
		this.conversionFactor = conversionFactor;
		this.conversionFactorText = conversionFactor != null
				? String.valueOf(conversionFactor)
				: null;
	}

	/**
	 * Set the conversion factor
	 * 
	 * @param conversionFactor
	 *            conversion factor
	 * @since 1.1.0
	 */
	public void setConversionFactor(String conversionFactor) {
		this.conversionFactorText = conversionFactor;
		this.conversionFactor = conversionFactor != null
				? Double.parseDouble(conversionFactor)
				: null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Identifier> getIdentifiers() {
		return identifiers;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean hasIdentifiers() {
		return identifiers != null && !identifiers.isEmpty();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int numIdentifiers() {
		return identifiers != null ? identifiers.size() : 0;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Identifier getIdentifier(int index) {
		return identifiers.get(index);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setIdentifiers(List<Identifier> identifiers) {
		this.identifiers = identifiers;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void addIdentifier(Identifier identifier) {
		if (this.identifiers == null) {
			this.identifiers = new ArrayList<>();
		}
		this.identifiers.add(identifier);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void addIdentifiers(List<Identifier> identifiers) {
		if (this.identifiers == null) {
			this.identifiers = new ArrayList<>();
		}
		this.identifiers.addAll(identifiers);
	}

	/**
	 * Determine if the unit names are equal, ignoring case
	 * 
	 * @param unit
	 *            unit
	 * @return true if equal names
	 * @since 1.1.0
	 */
	public boolean equalsName(Unit unit) {
		return name.equalsIgnoreCase(unit.getName());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((conversionFactor == null) ? 0
				: conversionFactor.hashCode());
		result = prime * result
				+ ((identifiers == null) ? 0 : identifiers.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		Unit other = (Unit) obj;
		if (conversionFactor == null) {
			if (other.conversionFactor != null)
				return false;
		} else if (!conversionFactor.equals(other.conversionFactor))
			return false;
		if (identifiers == null) {
			if (other.identifiers != null)
				return false;
		} else if (!identifiers.equals(other.identifiers))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (type != other.type)
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
			logger.log(Level.WARNING, "Failed to write unit as a string", e);
			value = super.toString();
		} finally {
			writer.close();
		}
		return value;
	}

}
