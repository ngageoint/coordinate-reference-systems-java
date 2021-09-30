package mil.nga.crs.util.proj;

/**
 * proj4 params
 * 
 * @author osbornb
 */
public class ProjParams {

	/**
	 * Axis West South Up
	 */
	private static final String axisWestSouthUp = ProjConstants.AXIS_WEST
			+ ProjConstants.AXIS_SOUTH + ProjConstants.AXIS_UP;

	/**
	 * proj param
	 */
	private String proj;

	/**
	 * zone param
	 */
	private String zone;

	/**
	 * south param
	 */
	private boolean south;

	/**
	 * lat_1 param
	 */
	private String lat_1;

	/**
	 * lat_2 param
	 */
	private String lat_2;

	/**
	 * lat_0 param
	 */
	private String lat_0;

	/**
	 * lat_ts param
	 */
	private String lat_ts;

	/**
	 * lon_0 param
	 */
	private String lon_0;

	/**
	 * lonc param
	 */
	private String lonc;

	/**
	 * alpha param
	 */
	private String alpha;

	/**
	 * k_0 param
	 */
	private String k_0;

	/**
	 * x_0 param
	 */
	private String x_0;

	/**
	 * y_0 param
	 */
	private String y_0;

	/**
	 * axis param
	 */
	private String axis;

	/**
	 * datum param
	 */
	private String datum;

	/**
	 * no_uoff param
	 */
	private boolean no_uoff;

	/**
	 * gamma param
	 */
	private String gamma;

	/**
	 * a param
	 */
	private String a;

	/**
	 * b param
	 */
	private String b;

	/**
	 * ellps param
	 */
	private String ellps;

	/**
	 * towgs84 param
	 */
	private String towgs84;

	/**
	 * xTranslation param
	 */
	private String xTranslation;

	/**
	 * yTranslation param
	 */
	private String yTranslation;

	/**
	 * zTranslation param
	 */
	private String zTranslation;

	/**
	 * xRotation param
	 */
	private String xRotation;

	/**
	 * yRotation param
	 */
	private String yRotation;

	/**
	 * zRotation param
	 */
	private String zRotation;

	/**
	 * scaleDifference param
	 */
	private String scaleDifference;

	/**
	 * pm param
	 */
	private String pm;

	/**
	 * units param
	 */
	private String units;

	/**
	 * to_meter param
	 */
	private String to_meter;

	/**
	 * nadgrids param
	 */
	private String nadgrids;

	/**
	 * wktext param
	 */
	private boolean wktext;

	/**
	 * no_defs param
	 */
	private boolean no_defs;

	/**
	 * Constructor
	 */
	public ProjParams() {

	}

	/**
	 * Get the proj parameter
	 * 
	 * @return proj parameter
	 */
	public String getProj() {
		return proj;
	}

	/**
	 * Set the proj parameter
	 * 
	 * @param proj
	 *            proj parameter
	 */
	public void setProj(String proj) {
		this.proj = proj;
	}

	/**
	 * Get the zone parameter
	 * 
	 * @return zone parameter
	 */
	public String getZone() {
		return zone;
	}

	/**
	 * Set the zone parameter
	 * 
	 * @param zone
	 *            zone parameter
	 */
	public void setZone(String zone) {
		this.zone = zone;
	}

	/**
	 * Is the south parameter enabled
	 * 
	 * @return south parameter
	 */
	public boolean isSouth() {
		return south;
	}

	/**
	 * Set the south parameter
	 * 
	 * @param south
	 *            south parameter
	 */
	public void setSouth(boolean south) {
		this.south = south;
	}

	/**
	 * Get the lat_1 parameter
	 * 
	 * @return lat_1 parameter
	 */
	public String getLat1() {
		return lat_1;
	}

	/**
	 * Set the lat_1 parameter
	 * 
	 * @param lat_1
	 *            lat_1 parameter
	 */
	public void setLat1(String lat_1) {
		this.lat_1 = lat_1;
	}

	/**
	 * Set the lat_1 parameter
	 * 
	 * @param lat_1
	 *            lat_1 parameter
	 */
	public void setLat1(double lat_1) {
		setLat1(String.valueOf(lat_1));
	}

	/**
	 * Get the lat_2 parameter
	 * 
	 * @return lat_2 parameter
	 */
	public String getLat2() {
		return lat_2;
	}

	/**
	 * Set the lat_2 parameter
	 * 
	 * @param lat_2
	 *            lat_2 parameter
	 */
	public void setLat2(String lat_2) {
		this.lat_2 = lat_2;
	}

	/**
	 * Set the lat_2 parameter
	 * 
	 * @param lat_2
	 *            lat_2 parameter
	 */
	public void setLat2(double lat_2) {
		setLat2(String.valueOf(lat_2));
	}

	/**
	 * Get the lat_0 parameter
	 * 
	 * @return lat_0 parameter
	 */
	public String getLat0() {
		return lat_0;
	}

	/**
	 * Set the lat_0 parameter
	 * 
	 * @param lat_0
	 *            lat_0 parameter
	 */
	public void setLat0(String lat_0) {
		this.lat_0 = lat_0;
	}

	/**
	 * Set the lat_0 parameter
	 * 
	 * @param lat_0
	 *            lat_0 parameter
	 */
	public void setLat0(double lat_0) {
		setLat0(String.valueOf(lat_0));
	}

	/**
	 * Get the lat_ts parameter
	 * 
	 * @return lat_ts parameter
	 */
	public String getLatTs() {
		return lat_ts;
	}

	/**
	 * Set the lat_ts parameter
	 * 
	 * @param lat_ts
	 *            lat_ts parameter
	 */
	public void setLatTs(String lat_ts) {
		this.lat_ts = lat_ts;
	}

	/**
	 * Set the lat_ts parameter
	 * 
	 * @param lat_ts
	 *            lat_ts parameter
	 */
	public void setLatTs(double lat_ts) {
		setLatTs(String.valueOf(lat_ts));
	}

	/**
	 * Get the lon_0 parameter
	 * 
	 * @return lon_0 parameter
	 */
	public String getLon0() {
		return lon_0;
	}

	/**
	 * Set the lon_0 parameter
	 * 
	 * @param lon_0
	 *            lon_0 parameter
	 */
	public void setLon0(String lon_0) {
		this.lon_0 = lon_0;
	}

	/**
	 * Set the lon_0 parameter
	 * 
	 * @param lon_0
	 *            lon_0 parameter
	 */
	public void setLon0(double lon_0) {
		setLon0(String.valueOf(lon_0));
	}

	/**
	 * Get the lonc parameter
	 * 
	 * @return lonc parameter
	 */
	public String getLonc() {
		return lonc;
	}

	/**
	 * Set the lonc parameter
	 * 
	 * @param lonc
	 *            lonc parameter
	 */
	public void setLonc(String lonc) {
		this.lonc = lonc;
	}

	/**
	 * Set the lonc parameter
	 * 
	 * @param lonc
	 *            lonc parameter
	 */
	public void setLonc(double lonc) {
		setLonc(String.valueOf(lonc));
	}

	/**
	 * Get the alpha parameter
	 * 
	 * @return alpha parameter
	 */
	public String getAlpha() {
		return alpha;
	}

	/**
	 * Set the alpha parameter
	 * 
	 * @param alpha
	 *            alpha parameter
	 */
	public void setAlpha(String alpha) {
		this.alpha = alpha;
	}

	/**
	 * Set the alpha parameter
	 * 
	 * @param alpha
	 *            alpha parameter
	 */
	public void setAlpha(double alpha) {
		setAlpha(String.valueOf(alpha));
	}

	/**
	 * Get the k_0 parameter
	 * 
	 * @return k_0 parameter
	 */
	public String getK0() {
		return k_0;
	}

	/**
	 * Set the k_0 parameter
	 * 
	 * @param k_0
	 *            k_0 parameter
	 */
	public void setK0(String k_0) {
		this.k_0 = k_0;
	}

	/**
	 * Set the k_0 parameter
	 * 
	 * @param k_0
	 *            k_0 parameter
	 */
	public void setK0(double k_0) {
		setK0(String.valueOf(k_0));
	}

	/**
	 * Get the x_0 parameter
	 * 
	 * @return x_0 parameter
	 */
	public String getX0() {
		return x_0;
	}

	/**
	 * Set the x_0 parameter
	 * 
	 * @param x_0
	 *            x_0 parameter
	 */
	public void setX0(String x_0) {
		this.x_0 = x_0;
	}

	/**
	 * Set the x_0 parameter
	 * 
	 * @param x_0
	 *            x_0 parameter
	 */
	public void setX0(double x_0) {
		setX0(String.valueOf(x_0));
	}

	/**
	 * Get the y_0 parameter
	 * 
	 * @return y_0 parameter
	 */
	public String getY0() {
		return y_0;
	}

	/**
	 * Set the y_0 parameter
	 * 
	 * @param y_0
	 *            y_0 parameter
	 */
	public void setY0(String y_0) {
		this.y_0 = y_0;
	}

	/**
	 * Set the y_0 parameter
	 * 
	 * @param y_0
	 *            y_0 parameter
	 */
	public void setY0(double y_0) {
		setY0(String.valueOf(y_0));
	}

	/**
	 * Get the axis parameter
	 * 
	 * @return axis parameter
	 */
	public String getAxis() {
		return axis;
	}

	/**
	 * Set the axis parameter
	 * 
	 * @param axis
	 *            axis parameter
	 */
	public void setAxis(String axis) {
		this.axis = axis;
	}

	/**
	 * Get the datum parameter
	 * 
	 * @return datum parameter
	 */
	public String getDatum() {
		return datum;
	}

	/**
	 * Set the datum parameter
	 * 
	 * @param datum
	 *            datum parameter
	 */
	public void setDatum(String datum) {
		this.datum = datum;
	}

	/**
	 * Is the no_uoff parameter enabled
	 * 
	 * @return no_uoff parameter
	 */
	public boolean isNoUoff() {
		return no_uoff;
	}

	/**
	 * Set the no_uoff parameter
	 * 
	 * @param no_uoff
	 *            no_uoff parameter
	 */
	public void setNoUoff(boolean no_uoff) {
		this.no_uoff = no_uoff;
	}

	/**
	 * Get the gamma parameter
	 * 
	 * @return gamma parameter
	 */
	public String getGamma() {
		return gamma;
	}

	/**
	 * Set the gamma parameter
	 * 
	 * @param gamma
	 *            gamma parameter
	 */
	public void setGamma(String gamma) {
		this.gamma = gamma;
	}

	/**
	 * Set the gamma parameter
	 * 
	 * @param gamma
	 *            gamma parameter
	 */
	public void setGamma(double gamma) {
		setGamma(String.valueOf(gamma));
	}

	/**
	 * Get the a parameter
	 * 
	 * @return a parameter
	 */
	public String getA() {
		return a;
	}

	/**
	 * Set the a parameter
	 * 
	 * @param a
	 *            a parameter
	 */
	public void setA(String a) {
		this.a = a;
	}

	/**
	 * Set the a parameter
	 * 
	 * @param a
	 *            a parameter
	 */
	public void setA(double a) {
		setA(String.valueOf(a));
	}

	/**
	 * Get the b parameter
	 * 
	 * @return b parameter
	 */
	public String getB() {
		return b;
	}

	/**
	 * Set the b parameter
	 * 
	 * @param b
	 *            b parameter
	 */
	public void setB(String b) {
		this.b = b;
	}

	/**
	 * Set the b parameter
	 * 
	 * @param b
	 *            b parameter
	 */
	public void setB(double b) {
		setB(String.valueOf(b));
	}

	/**
	 * Get the ellps parameter
	 * 
	 * @return ellps parameter
	 */
	public String getEllps() {
		return ellps;
	}

	/**
	 * Set the ellps parameter
	 * 
	 * @param ellps
	 *            ellps parameter
	 */
	public void setEllps(String ellps) {
		this.ellps = ellps;
	}

	/**
	 * Get the towgs84 parameter
	 * 
	 * @return towgs84 parameter
	 */
	public String getTowgs84() {
		return towgs84;
	}

	/**
	 * Set the towgs84 parameter
	 * 
	 * @param towgs84
	 *            towgs84 parameter
	 */
	public void setTowgs84(String towgs84) {
		this.towgs84 = towgs84;
	}

	/**
	 * Get the xTranslation parameter
	 * 
	 * @return xTranslation parameter
	 */
	public String getXTranslation() {
		return xTranslation;
	}

	/**
	 * Set the xTranslation parameter
	 * 
	 * @param xTranslation
	 *            xTranslation parameter
	 */
	public void setXTranslation(String xTranslation) {
		this.xTranslation = xTranslation;
	}

	/**
	 * Set the xTranslation parameter
	 * 
	 * @param xTranslation
	 *            xTranslation parameter
	 */
	public void setXTranslation(double xTranslation) {
		setXTranslation(String.valueOf(xTranslation));
	}

	/**
	 * Get the yTranslation parameter
	 * 
	 * @return yTranslation parameter
	 */
	public String getYTranslation() {
		return yTranslation;
	}

	/**
	 * Set the yTranslation parameter
	 * 
	 * @param yTranslation
	 *            yTranslation parameter
	 */
	public void setYTranslation(String yTranslation) {
		this.yTranslation = yTranslation;
	}

	/**
	 * Set the yTranslation parameter
	 * 
	 * @param yTranslation
	 *            yTranslation parameter
	 */
	public void setYTranslation(double yTranslation) {
		setYTranslation(String.valueOf(yTranslation));
	}

	/**
	 * Get the zTranslation parameter
	 * 
	 * @return zTranslation parameter
	 */
	public String getZTranslation() {
		return zTranslation;
	}

	/**
	 * Set the zTranslation parameter
	 * 
	 * @param zTranslation
	 *            zTranslation parameter
	 */
	public void setZTranslation(String zTranslation) {
		this.zTranslation = zTranslation;
	}

	/**
	 * Set the zTranslation parameter
	 * 
	 * @param zTranslation
	 *            zTranslation parameter
	 */
	public void setZTranslation(double zTranslation) {
		setZTranslation(String.valueOf(zTranslation));
	}

	/**
	 * Get the xRotation parameter
	 * 
	 * @return xRotation parameter
	 */
	public String getXRotation() {
		return xRotation;
	}

	/**
	 * Set the xRotation parameter
	 * 
	 * @param xRotation
	 *            xRotation parameter
	 */
	public void setXRotation(String xRotation) {
		this.xRotation = xRotation;
	}

	/**
	 * Set the xRotation parameter
	 * 
	 * @param xRotation
	 *            xRotation parameter
	 */
	public void setXRotation(double xRotation) {
		setXRotation(String.valueOf(xRotation));
	}

	/**
	 * Get the yRotation parameter
	 * 
	 * @return yRotation parameter
	 */
	public String getYRotation() {
		return yRotation;
	}

	/**
	 * Set the yRotation parameter
	 * 
	 * @param yRotation
	 *            yRotation parameter
	 */
	public void setYRotation(String yRotation) {
		this.yRotation = yRotation;
	}

	/**
	 * Set the yRotation parameter
	 * 
	 * @param yRotation
	 *            yRotation parameter
	 */
	public void setYRotation(double yRotation) {
		setYRotation(String.valueOf(yRotation));
	}

	/**
	 * Get the zRotation parameter
	 * 
	 * @return zRotation parameter
	 */
	public String getZRotation() {
		return zRotation;
	}

	/**
	 * Set the zRotation parameter
	 * 
	 * @param zRotation
	 *            zRotation parameter
	 */
	public void setZRotation(String zRotation) {
		this.zRotation = zRotation;
	}

	/**
	 * Set the zRotation parameter
	 * 
	 * @param zRotation
	 *            zRotation parameter
	 */
	public void setZRotation(double zRotation) {
		setZRotation(String.valueOf(zRotation));
	}

	/**
	 * Get the scaleDifference parameter
	 * 
	 * @return scaleDifference parameter
	 */
	public String getScaleDifference() {
		return scaleDifference;
	}

	/**
	 * Set the scaleDifference parameter
	 * 
	 * @param scaleDifference
	 *            scaleDifference parameter
	 */
	public void setScaleDifference(String scaleDifference) {
		this.scaleDifference = scaleDifference;
	}

	/**
	 * Set the scaleDifference parameter
	 * 
	 * @param scaleDifference
	 *            scaleDifference parameter
	 */
	public void setScaleDifference(double scaleDifference) {
		setScaleDifference(String.valueOf(scaleDifference));
	}

	/**
	 * Get the pm parameter
	 * 
	 * @return pm parameter
	 */
	public String getPm() {
		return pm;
	}

	/**
	 * Set the pm parameter
	 * 
	 * @param pm
	 *            pm parameter
	 */
	public void setPm(String pm) {
		this.pm = pm;
	}

	/**
	 * Set the pm parameter
	 * 
	 * @param pm
	 *            pm parameter
	 */
	public void setPm(double pm) {
		setPm(String.valueOf(pm));
	}

	/**
	 * Get the units parameter
	 * 
	 * @return units parameter
	 */
	public String getUnits() {
		return units;
	}

	/**
	 * Set the units parameter
	 * 
	 * @param units
	 *            units parameter
	 */
	public void setUnits(String units) {
		this.units = units;
	}

	/**
	 * Get the to_meter parameter
	 * 
	 * @return to_meter parameter
	 */
	public String getToMeter() {
		return to_meter;
	}

	/**
	 * Set the to_meter parameter
	 * 
	 * @param to_meter
	 *            to_meter parameter
	 */
	public void setToMeter(String to_meter) {
		this.to_meter = to_meter;
	}

	/**
	 * Set the to_meter parameter
	 * 
	 * @param to_meter
	 *            to_meter parameter
	 */
	public void setToMeter(double to_meter) {
		setToMeter(String.valueOf(to_meter));
	}

	/**
	 * Get the nadgrids parameter
	 * 
	 * @return nadgrids parameter
	 */
	public String getNadgrids() {
		return nadgrids;
	}

	/**
	 * Set the nadgrids parameter
	 * 
	 * @param nadgrids
	 *            nadgrids parameter
	 */
	public void setNadgrids(String nadgrids) {
		this.nadgrids = nadgrids;
	}

	/**
	 * Is the wktext parameter enabled
	 * 
	 * @return wktext parameter
	 */
	public boolean isWktext() {
		return wktext;
	}

	/**
	 * Set the wktext parameter
	 * 
	 * @param wktext
	 *            wktext parameter
	 */
	public void setWktext(boolean wktext) {
		this.wktext = wktext;
	}

	/**
	 * Is the no_defs parameter enabled
	 * 
	 * @return no_defs parameter
	 */
	public boolean isNoDefs() {
		return no_defs;
	}

	/**
	 * Set the no_defs parameter
	 * 
	 * @param no_defs
	 *            no_defs parameter
	 */
	public void setNoDefs(boolean no_defs) {
		this.no_defs = no_defs;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		StringBuilder value = new StringBuilder();

		if (proj != null) {
			value.append("+");
			value.append(ProjConstants.PARAM_PROJ);
			value.append("=");
			value.append(proj);
		}
		if (zone != null) {
			value.append(" +");
			value.append(ProjConstants.PARAM_ZONE);
			value.append("=");
			value.append(zone);
		}
		if (south) {
			value.append(" +");
			value.append(ProjConstants.PARAM_SOUTH);
		}
		if (lat_1 != null) {
			value.append(" +");
			value.append(ProjConstants.PARAM_LAT_1);
			value.append("=");
			value.append(lat_1);
		}
		if (lat_2 != null) {
			value.append(" +");
			value.append(ProjConstants.PARAM_LAT_2);
			value.append("=");
			value.append(lat_2);
		}
		if (lat_0 != null) {
			value.append(" +");
			value.append(ProjConstants.PARAM_LAT_0);
			value.append("=");
			value.append(lat_0);
		}
		if (lat_ts != null) {
			value.append(" +");
			value.append(ProjConstants.PARAM_LAT_TS);
			value.append("=");
			value.append(lat_ts);
		}
		if (lon_0 != null) {
			value.append(" +");
			value.append(ProjConstants.PARAM_LON_0);
			value.append("=");
			value.append(lon_0);
		}
		if (lonc != null) {
			value.append(" +");
			value.append(ProjConstants.PARAM_LONC);
			value.append("=");
			value.append(lonc);
		}
		if (alpha != null) {
			value.append(" +");
			value.append(ProjConstants.PARAM_ALPHA);
			value.append("=");
			value.append(alpha);
		}
		if (k_0 != null) {
			value.append(" +");
			value.append(ProjConstants.PARAM_K_0);
			value.append("=");
			value.append(k_0);
		}
		if (x_0 != null) {
			value.append(" +");
			value.append(ProjConstants.PARAM_X_0);
			value.append("=");
			value.append(x_0);
		}
		if (y_0 != null) {
			value.append(" +");
			value.append(ProjConstants.PARAM_Y_0);
			value.append("=");
			value.append(y_0);
		}
		if (axis != null && axis.equals(axisWestSouthUp)) {
			// Only known proj4 axis specification is wsu
			value.append(" +");
			value.append(ProjConstants.PARAM_AXIS);
			value.append("=");
			value.append(axis);
		}
		if (datum != null) {
			value.append(" +");
			value.append(ProjConstants.PARAM_DATUM);
			value.append("=");
			value.append(datum);
		}
		if (no_uoff) {
			value.append(" +");
			value.append(ProjConstants.PARAM_NO_UOFF);
		}
		if (gamma != null) {
			value.append(" +");
			value.append(ProjConstants.PARAM_GAMMA);
			value.append("=");
			value.append(gamma);
		}
		if (a != null) {
			value.append(" +");
			value.append(ProjConstants.PARAM_A);
			value.append("=");
			value.append(a);
		}
		if (b != null) {
			value.append(" +");
			value.append(ProjConstants.PARAM_B);
			value.append("=");
			value.append(b);
		}
		if (ellps != null) {
			value.append(" +");
			value.append(ProjConstants.PARAM_ELLPS);
			value.append("=");
			value.append(ellps);
		}
		if (towgs84 != null) {
			value.append(" +");
			value.append(ProjConstants.PARAM_TOWGS84);
			value.append("=");
			value.append(towgs84);
		} else if (xTranslation != null || yTranslation != null
				|| zTranslation != null || xRotation != null
				|| yRotation != null || zRotation != null
				|| scaleDifference != null) {
			value.append(" +");
			value.append(ProjConstants.PARAM_TOWGS84);
			value.append("=");
			value.append(xTranslation != null ? xTranslation : "0");
			value.append(",");
			value.append(yTranslation != null ? yTranslation : "0");
			value.append(",");
			value.append(zTranslation != null ? zTranslation : "0");
			value.append(",");
			value.append(xRotation != null ? xRotation : "0");
			value.append(",");
			value.append(yRotation != null ? yRotation : "0");
			value.append(",");
			value.append(zRotation != null ? zRotation : "0");
			value.append(",");
			value.append(scaleDifference != null ? scaleDifference : "0");
		}
		if (pm != null) {
			value.append(" +");
			value.append(ProjConstants.PARAM_PM);
			value.append("=");
			value.append(pm);
		}
		if (units != null) {
			value.append(" +");
			value.append(ProjConstants.PARAM_UNITS);
			value.append("=");
			value.append(units);
		}
		if (to_meter != null) {
			value.append(" +");
			value.append(ProjConstants.PARAM_TO_METER);
			value.append("=");
			value.append(to_meter);
		}
		if (nadgrids != null) {
			value.append(" +");
			value.append(ProjConstants.PARAM_NADGRIDS);
			value.append("=");
			value.append(nadgrids);
		}
		if (wktext) {
			value.append(" +");
			value.append(ProjConstants.PARAM_WKTEXT);
		}
		if (no_defs) {
			value.append(" +");
			value.append(ProjConstants.PARAM_NO_DEFS);
		}

		return value.toString();
	}

}
