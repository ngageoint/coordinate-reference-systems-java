package mil.nga.crs.util.proj;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import mil.nga.crs.CRS;
import mil.nga.crs.CRSException;
import mil.nga.crs.CompoundCoordinateReferenceSystem;
import mil.nga.crs.SimpleCoordinateReferenceSystem;
import mil.nga.crs.common.Axis;
import mil.nga.crs.common.CoordinateSystem;
import mil.nga.crs.common.Unit;
import mil.nga.crs.common.UnitType;
import mil.nga.crs.common.Units;
import mil.nga.crs.geo.Ellipsoid;
import mil.nga.crs.geo.Ellipsoids;
import mil.nga.crs.geo.GeoCoordinateReferenceSystem;
import mil.nga.crs.geo.GeoDatum;
import mil.nga.crs.geo.GeoDatums;
import mil.nga.crs.geo.PrimeMeridian;
import mil.nga.crs.geo.PrimeMeridians;
import mil.nga.crs.geo.TriaxialEllipsoid;
import mil.nga.crs.operation.OperationMethod;
import mil.nga.crs.operation.OperationMethods;
import mil.nga.crs.operation.OperationParameter;
import mil.nga.crs.projected.MapProjection;
import mil.nga.crs.projected.ProjectedCoordinateReferenceSystem;
import mil.nga.crs.wkt.CRSKeyword;
import mil.nga.crs.wkt.CRSReader;

/**
 * CRS to PROJ parser
 * 
 * @author osbornb
 * @since 1.1.0
 */
public class ProjParser {

	/**
	 * Parse crs well-known text into PROJ params
	 *
	 * @param wkt
	 *            crs well-known text
	 * @return params
	 * @throws IOException
	 *             upon failure to read
	 */
	public static ProjParams params(String wkt) throws IOException {

		CRS crs = CRSReader.read(wkt);

		ProjParams params = null;
		if (crs != null) {
			params = params(crs);
		}

		return params;
	}

	/**
	 * Parse crs well-known text into PROJ params text
	 *
	 * @param wkt
	 *            crs well-known text
	 * @return params text
	 * @throws IOException
	 *             upon failure to read
	 */
	public static String paramsText(String wkt) throws IOException {
		return paramsText(params(wkt));
	}

	/**
	 * Convert a CRS object into PROJ params
	 *
	 * @param crs
	 *            CRS object
	 * @return params
	 */
	public static ProjParams params(CRS crs) {

		ProjParams params = null;

		switch (crs.getType()) {

		case GEODETIC:
		case GEOGRAPHIC:
			params = params((GeoCoordinateReferenceSystem) crs);
			break;

		case PROJECTED:
			params = params((ProjectedCoordinateReferenceSystem) crs);
			break;

		case COMPOUND:
			params = params((CompoundCoordinateReferenceSystem) crs);
			break;

		default:
			break;

		}

		return params;
	}

	/**
	 * Convert a CRS object into PROJ params text
	 *
	 * @param crs
	 *            CRS object
	 * @return params text
	 */
	public static String paramsText(CRS crs) {
		return paramsText(params(crs));
	}

	/**
	 * Convert a geodetic or geographic crs into PROJ params
	 *
	 * @param geo
	 *            geodetic or geographic crs
	 * @return params
	 */
	public static ProjParams params(GeoCoordinateReferenceSystem geo) {

		ProjParams params = new ProjParams();

		GeoDatum geoDatum = geo.getGeoDatum();

		updateDatum(params, geoDatum);

		updateDatumTransform(params, geo);

		updateProj(params, geo.getCoordinateSystem());
		updatePrimeMeridian(params, geoDatum);

		params.setNoDefs(true);

		return params;
	}

	/**
	 * Convert a geodetic or geographic crs into PROJ params text
	 *
	 * @param geo
	 *            geodetic or geographic crs
	 * @return params text
	 */
	public static String paramsText(GeoCoordinateReferenceSystem geo) {
		return paramsText(params(geo));
	}

	/**
	 * Convert a projected crs into PROJ params
	 *
	 * @param projected
	 *            projected crs
	 * @return params
	 */
	public static ProjParams params(
			ProjectedCoordinateReferenceSystem projected) {

		ProjParams params = new ProjParams();

		CoordinateSystem coordinateSystem = projected.getCoordinateSystem();
		MapProjection mapProjection = projected.getMapProjection();

		GeoDatum geoDatum = projected.getGeoDatum();

		updateDatum(params, geoDatum, mapProjection);

		updateDatumTransform(params, projected.getBase());
		updateDatumTransform(params, mapProjection.getMethod());

		updateProj(params, coordinateSystem, mapProjection);
		updateUnits(params, coordinateSystem);
		updatePrimeMeridian(params, geoDatum);
		updateParams(params, mapProjection, coordinateSystem.getUnit());

		params.setNoDefs(true);

		return params;
	}

	/**
	 * Convert a projected crs into PROJ params text
	 *
	 * @param projected
	 *            projected crs
	 * @return params text
	 */
	public static String paramsText(
			ProjectedCoordinateReferenceSystem projected) {
		return paramsText(params(projected));
	}

	/**
	 * Convert a compound crs into PROJ params
	 *
	 * @param compound
	 *            compound crs
	 * @return params
	 */
	public static ProjParams params(
			CompoundCoordinateReferenceSystem compound) {

		ProjParams params = new ProjParams();

		for (SimpleCoordinateReferenceSystem simpleCrs : compound
				.getCoordinateReferenceSystems()) {

			params = params(simpleCrs);

			if (params != null) {
				break;
			}

		}

		return params;
	}

	/**
	 * Convert a compound crs into PROJ params text
	 *
	 * @param compound
	 *            compound crs
	 * @return params text
	 */
	public static String paramsText(
			CompoundCoordinateReferenceSystem compound) {
		return paramsText(params(compound));
	}

	/**
	 * Update the datum
	 * 
	 * @param params
	 *            projection params
	 * @param geoDatum
	 *            geo datum
	 */
	private static void updateDatum(ProjParams params, GeoDatum geoDatum) {

		GeoDatums commonGeoDatum = GeoDatums.fromName(geoDatum.getName());

		if (commonGeoDatum != null) {
			params.setDatum(commonGeoDatum.getCode());
		} else {
			updateEllipsoid(params, geoDatum.getEllipsoid());
		}

	}

	/**
	 * Update the datum
	 * 
	 * @param params
	 *            projection params
	 * @param geoDatum
	 *            geo datum
	 * @param mapProjection
	 *            map projection
	 */
	private static void updateDatum(ProjParams params, GeoDatum geoDatum,
			MapProjection mapProjection) {

		GeoDatums commonGeoDatum = GeoDatums.fromName(geoDatum.getName());

		if (commonGeoDatum != null) {
			updateDatum(params, geoDatum, commonGeoDatum, mapProjection);
		} else {
			updateEllipsoid(params, geoDatum.getEllipsoid());
		}
	}

	/**
	 * Update the datum
	 * 
	 * @param params
	 *            projection params
	 * @param geoDatum
	 *            geo datum
	 * @param commonGeoDatum
	 *            common geo datum
	 * @param mapProjection
	 *            map projection
	 */
	private static void updateDatum(ProjParams params, GeoDatum geoDatum,
			GeoDatums commonGeoDatum, MapProjection mapProjection) {
		OperationMethod method = mapProjection.getMethod();
		// Check for special cases like EPSG 3857 which specifies the ellipsoid
		// parameters instead of a datum
		if (commonGeoDatum == GeoDatums.WGS84 && method.hasMethod() && method
				.getMethod() == OperationMethods.POPULAR_VISUALISATION_PSEUDO_MERCATOR
				&& mapProjection.getName().toLowerCase()
						.contains(ProjConstants.PSEUDO_MERCATOR)) {
			updateSphericalEllipsoid(params,
					geoDatum.getEllipsoid().getSemiMajorAxisText());
		} else {
			params.setDatum(commonGeoDatum.getCode());
		}
	}

	/**
	 * Update the ellipsoid
	 * 
	 * @param params
	 *            projection params
	 * @param ellipsoid
	 *            ellipsoid
	 */
	private static void updateEllipsoid(ProjParams params,
			Ellipsoid ellipsoid) {

		Ellipsoids commonEllipsoid = null;

		if (ellipsoid.getInverseFlattening() != 0) {
			commonEllipsoid = Ellipsoids.fromName(ellipsoid.getName());
		}

		if (commonEllipsoid != null) {
			params.setEllps(commonEllipsoid.getShortName());
		} else {

			params.setA(convert(ellipsoid.getSemiMajorAxis(),
					ellipsoid.getSemiMajorAxisText(), ellipsoid.getUnit(),
					Units.METRE));

			switch (ellipsoid.getType()) {
			case OBLATE:
				params.setB(convert(ellipsoid.getPoleRadius(),
						ellipsoid.getPoleRadiusText(), ellipsoid.getUnit(),
						Units.METRE));
				break;
			case TRIAXIAL:
				TriaxialEllipsoid triaxial = (TriaxialEllipsoid) ellipsoid;
				params.setB(convert(triaxial.getSemiMinorAxis(),
						triaxial.getSemiMinorAxisText(), ellipsoid.getUnit(),
						Units.METRE));
				break;
			default:
				throw new CRSException(
						"Unsupported Ellipsoid Type: " + ellipsoid.getType());
			}

		}

	}

	/**
	 * Update the spherical ellipsoid
	 * 
	 * @param params
	 *            projection params
	 * @param radius
	 *            radius
	 */
	private static void updateSphericalEllipsoid(ProjParams params,
			String radius) {
		params.setA(radius);
		params.setB(radius);
	}

	/**
	 * Update the datum transform
	 * 
	 * @param params
	 *            projection params
	 * @param radius
	 *            radius
	 */
	private static void updateDatumTransform(ProjParams params, CRS crs) {
		Object toWGS84 = crs.getExtra(CRSKeyword.TOWGS84.name());
		if (toWGS84 != null) {
			updateDatumTransform(params, (String[]) toWGS84);
		}
	}

	/**
	 * Update the datum transform
	 * 
	 * @param params
	 *            projection params
	 * @param toWGS84
	 *            to WGS84 array
	 */
	private static void updateDatumTransform(ProjParams params,
			String[] toWGS84) {
		if (toWGS84.length >= 3) {
			params.setXTranslation(toWGS84[0]);
			params.setYTranslation(toWGS84[1]);
			params.setZTranslation(toWGS84[2]);
			if (toWGS84.length >= 7) {
				params.setXRotation(toWGS84[3]);
				params.setYRotation(toWGS84[4]);
				params.setZRotation(toWGS84[5]);
				params.setScaleDifference(toWGS84[6]);
			}
		}
	}

	/**
	 * Update the datum transform
	 * 
	 * @param params
	 *            projection params
	 * @param method
	 *            operation method
	 */
	private static void updateDatumTransform(ProjParams params,
			OperationMethod method) {

		for (OperationParameter parameter : method.getParameters()) {

			if (parameter.hasParameter()) {

				switch (parameter.getParameter()) {

				case X_AXIS_TRANSLATION:
					params.setXTranslation(value(parameter, Units.METRE));
					break;

				case Y_AXIS_TRANSLATION:
					params.setYTranslation(value(parameter, Units.METRE));
					break;

				case Z_AXIS_TRANSLATION:
					params.setZTranslation(value(parameter, Units.METRE));
					break;

				case X_AXIS_ROTATION:
					params.setXRotation(value(parameter, Units.ARC_SECOND));
					break;

				case Y_AXIS_ROTATION:
					params.setYRotation(value(parameter, Units.ARC_SECOND));
					break;

				case Z_AXIS_ROTATION:
					params.setZRotation(value(parameter, Units.ARC_SECOND));
					break;

				case SCALE_DIFFERENCE:
					params.setScaleDifference(
							value(parameter, Units.PARTS_PER_MILLION));
					break;

				default:
					break;

				}
			}
		}

	}

	/**
	 * Update the prime meridian
	 * 
	 * @param params
	 *            projection params
	 * @param geoDatum
	 *            geo datum
	 */
	private static void updatePrimeMeridian(ProjParams params,
			GeoDatum geoDatum) {

		if (geoDatum.hasPrimeMeridian()) {
			PrimeMeridian primeMeridian = geoDatum.getPrimeMeridian();
			PrimeMeridians commonPrimeMeridian = PrimeMeridians
					.fromName(primeMeridian.getName());
			if (commonPrimeMeridian != null) {
				if (commonPrimeMeridian != PrimeMeridians.GREENWICH) {
					params.setPm(commonPrimeMeridian.getName());
				}
			} else {
				params.setPm(convert(primeMeridian.getLongitude(),
						primeMeridian.getLongitudeText(),
						primeMeridian.getLongitudeUnit(), Units.DEGREE));
			}
		}

	}

	/**
	 * Update the proj
	 * 
	 * @param params
	 *            projection params
	 * @param coordinateSystem
	 *            coordinate system
	 */
	private static void updateProj(ProjParams params,
			CoordinateSystem coordinateSystem) {

		Unit unit = coordinateSystem.getAxisUnit();

		if (unit != null && (unit.getType() == UnitType.ANGLEUNIT
				|| (unit.getType() == UnitType.UNIT
						&& unit.getName().toLowerCase()
								.startsWith(ProjConstants.UNITS_DEGREE)))) {
			params.setProj(ProjConstants.NAME_LONGLAT);
		} else {
			params.setProj(ProjConstants.NAME_MERC);
		}
	}

	/**
	 * Update the proj
	 * 
	 * @param params
	 *            projection params
	 * @param coordinateSystem
	 *            coordinate system
	 * @param mapProjection
	 *            map projection
	 */
	private static void updateProj(ProjParams params,
			CoordinateSystem coordinateSystem, MapProjection mapProjection) {

		OperationMethod method = mapProjection.getMethod();

		if (method.hasMethod()) {

			switch (method.getMethod()) {

			case ALBERS_EQUAL_AREA:
				params.setProj(ProjConstants.NAME_AEA);
				break;

			case AMERICAN_POLYCONIC:
				params.setProj(ProjConstants.NAME_POLY);
				break;

			case CASSINI_SOLDNER:
				params.setProj(ProjConstants.NAME_CASS);
				break;

			case EQUIDISTANT_CYLINDRICAL:
				params.setProj(ProjConstants.NAME_EQC);
				break;

			case HOTINE_OBLIQUE_MERCATOR_A:
				params.setNoUoff(true);
				params.setProj(ProjConstants.NAME_OMERC);
				break;

			case HOTINE_OBLIQUE_MERCATOR_B:
				if (mapProjection.getName().toLowerCase()
						.contains(ProjConstants.SWISS_OBLIQUE_MERCATOR)
						|| method.getName().toLowerCase().contains(
								ProjConstants.SWISS_OBLIQUE_MERCATOR_COMPAT)) {
					params.setProj(ProjConstants.NAME_SOMERC);
				} else {
					params.setProj(ProjConstants.NAME_OMERC);
				}
				break;

			case KROVAK:
				params.setProj(ProjConstants.NAME_KROVAK);
				break;

			case LAMBERT_AZIMUTHAL_EQUAL_AREA:
				params.setProj(ProjConstants.NAME_LAEA);
				break;

			case LAMBERT_CONIC_CONFORMAL_1SP:
			case LAMBERT_CONIC_CONFORMAL_2SP:
				params.setProj(ProjConstants.NAME_LCC);
				break;

			case LAMBERT_CYLINDRICAL_EQUAL_AREA:
				params.setProj(ProjConstants.NAME_CEA);
				break;

			case MERCATOR_A:
			case MERCATOR_B:
				params.setProj(ProjConstants.NAME_MERC);
				break;

			case NEW_ZEALAND_MAP_GRID:
				params.setProj(ProjConstants.NAME_NZMG);
				break;

			case OBLIQUE_STEREOGRAPHIC:
				params.setProj(ProjConstants.NAME_STEREA);
				break;

			case POLAR_STEREOGRAPHIC_A:
			case POLAR_STEREOGRAPHIC_B:
			case POLAR_STEREOGRAPHIC_C:
				params.setProj(ProjConstants.NAME_STERE);
				break;

			case POPULAR_VISUALISATION_PSEUDO_MERCATOR:
				params.setProj(ProjConstants.NAME_MERC);
				break;

			case TRANSVERSE_MERCATOR:
			case TRANSVERSE_MERCATOR_SOUTH_ORIENTATED:
				if (mapProjection.getName().toLowerCase()
						.contains(ProjConstants.UTM_ZONE)) {
					params.setProj(ProjConstants.NAME_UTM);
				} else {
					params.setProj(ProjConstants.NAME_TMERC);
				}
				break;

			default:
				break;

			}

			if (params.getProj() != null) {
				updateAxis(params, coordinateSystem);
			}

		}

		if (params.getProj() == null) {
			updateProj(params, coordinateSystem);
		}

	}

	/**
	 * Update the units
	 * 
	 * @param params
	 *            projection params
	 * @param coordinateSystem
	 *            coordinate system
	 */
	private static void updateUnits(ProjParams params,
			CoordinateSystem coordinateSystem) {

		if (coordinateSystem.hasUnit()) {

			Unit unit = coordinateSystem.getUnit();

			if (unit.getType() == UnitType.LENGTHUNIT
					|| unit.getType() == UnitType.UNIT) {

				Units type = Units.fromUnit(unit);
				if (type != null) {

					switch (type) {
					case MICROMETRE:
					case MILLIMETRE:
					case METRE:
					case KILOMETRE:
						params.setUnits(ProjConstants.UNITS_METRE);
						break;
					case US_SURVEY_FOOT:
						params.setUnits(ProjConstants.UNITS_US_SURVEY_FOOT);
						break;
					case FOOT:
						params.setUnits(ProjConstants.UNITS_FOOT);
						break;
					default:
						break;
					}

				}

				if (params.getUnits() == null && unit.hasConversionFactor()
						&& unit.getConversionFactor() != 1.0) {
					params.setToMeter(unit.getConversionFactorText());
				}

			}

		}

	}

	/**
	 * Update the axis
	 * 
	 * @param params
	 *            projection params
	 * @param coordinateSystem
	 *            coordinate system
	 */
	private static void updateAxis(ProjParams params,
			CoordinateSystem coordinateSystem) {
		String axisOrder = convertAxes(coordinateSystem.getAxes());
		params.setAxis(axisOrder);
	}

	/**
	 * Update the params
	 * 
	 * @param params
	 *            projection params
	 * @param mapProjection
	 *            map projection
	 * @param unit
	 *            unit
	 */
	private static void updateParams(ProjParams params,
			MapProjection mapProjection, Unit unit) {

		String name = mapProjection.getName();
		int index = name.toLowerCase().indexOf(ProjConstants.UTM_ZONE);
		if (index > -1) {
			String utm = name.substring(index + ProjConstants.UTM_ZONE.length())
					.trim();
			String[] parts = utm.split("\\s+");
			boolean south = false;
			if (parts.length > 0) {
				utm = parts[0].toLowerCase();
				south = utm.endsWith(ProjConstants.AXIS_SOUTH);
				if (south || utm.endsWith(ProjConstants.AXIS_NORTH)) {
					utm = utm.substring(0, utm.length() - 1);
				}
			}
			Scanner scanner = new Scanner(utm);
			boolean isZone = scanner.hasNextInt();
			scanner.close();
			if (isZone) {
				params.setZone(utm);
				if (south) {
					params.setSouth(true);
				}
			} else {
				updateParams(params, mapProjection.getMethod(), unit);
			}
		} else {
			updateParams(params, mapProjection.getMethod(), unit);
		}

	}

	/**
	 * Update the params
	 * 
	 * @param params
	 *            projection params
	 * @param method
	 *            operation method
	 * @param unit
	 *            unit
	 */
	private static void updateParams(ProjParams params, OperationMethod method,
			Unit unit) {
		if (method.hasParameters()) {
			for (OperationParameter parameter : method.getParameters()) {
				updateParams(params, method, unit, parameter);
			}
		}
	}

	/**
	 * Update the params
	 * 
	 * @param params
	 *            projection params
	 * @param method
	 *            operation method
	 * @param unit
	 *            unit
	 * @param parameter
	 *            operation parameter
	 */
	private static void updateParams(ProjParams params, OperationMethod method,
			Unit unit, OperationParameter parameter) {

		if (parameter.hasParameter()) {

			switch (parameter.getParameter()) {

			case FALSE_EASTING:
			case EASTING_AT_PROJECTION_CENTRE:
			case EASTING_AT_FALSE_ORIGIN:
				params.setX0(value(parameter, unit, Units.METRE));
				break;

			case FALSE_NORTHING:
			case NORTHING_AT_PROJECTION_CENTRE:
			case NORTHING_AT_FALSE_ORIGIN:
				params.setY0(value(parameter, unit, Units.METRE));
				break;

			case SCALE_FACTOR_AT_NATURAL_ORIGIN:
			case SCALE_FACTOR_ON_INITIAL_LINE:
			case SCALE_FACTOR_ON_PSEUDO_STANDARD_PARALLEL:
				params.setK0(value(parameter, Units.UNITY));
				break;

			case LATITUDE_OF_1ST_STANDARD_PARALLEL:
				if (method.hasMethod()) {
					switch (method.getMethod()) {
					case LAMBERT_CYLINDRICAL_EQUAL_AREA:
						params.setLatTs(value(parameter, Units.DEGREE));
						break;
					default:
						params.setLat1(value(parameter, Units.DEGREE));
						break;
					}
				} else {
					params.setLat1(value(parameter, Units.DEGREE));
				}
				break;

			case LATITUDE_OF_2ND_STANDARD_PARALLEL:
				params.setLat2(value(parameter, Units.DEGREE));
				break;

			case LATITUDE_OF_PROJECTION_CENTRE:
			case LATITUDE_OF_NATURAL_ORIGIN:
			case LATITUDE_OF_FALSE_ORIGIN:
				if (method.hasMethod()) {
					switch (method.getMethod()) {
					case POLAR_STEREOGRAPHIC_A:
					case POLAR_STEREOGRAPHIC_B:
					case POLAR_STEREOGRAPHIC_C:
						params.setLatTs(value(parameter, Units.DEGREE));
						if (Double.valueOf(params.getLatTs()) >= 0) {
							params.setLat0("90");
						} else {
							params.setLat0("-90");
						}
						break;
					case EQUIDISTANT_CYLINDRICAL:
						params.setLatTs(value(parameter, Units.DEGREE));
						params.setLat0("0");
						break;
					case LAMBERT_CYLINDRICAL_EQUAL_AREA:
					case MERCATOR_A:
					case MERCATOR_B:
					case POPULAR_VISUALISATION_PSEUDO_MERCATOR:
						params.setLatTs(value(parameter, Units.DEGREE));
						break;
					case LAMBERT_CONIC_CONFORMAL_1SP:
					case LAMBERT_CONIC_CONFORMAL_2SP:
						params.setLat0(value(parameter, Units.DEGREE));
						if (params.getLat1() == null) {
							params.setLat1(params.getLat0());
						}
						break;
					default:
						params.setLat0(value(parameter, Units.DEGREE));
						break;
					}
				} else {
					params.setLat0(value(parameter, Units.DEGREE));
				}
				break;

			case LONGITUDE_OF_PROJECTION_CENTRE:
			case LONGITUDE_OF_NATURAL_ORIGIN:
			case LONGITUDE_OF_FALSE_ORIGIN:
			case LONGITUDE_OF_ORIGIN:
				if (method.hasMethod()) {
					switch (method.getMethod()) {
					case HOTINE_OBLIQUE_MERCATOR_A:
						params.setLonc(value(parameter, Units.DEGREE));
						break;
					case HOTINE_OBLIQUE_MERCATOR_B:
						if (params.getProj() != null && params.getProj()
								.equals(ProjConstants.NAME_SOMERC)) {
							params.setLon0(value(parameter, Units.DEGREE));
						} else {
							params.setLonc(value(parameter, Units.DEGREE));
						}
						break;
					default:
						params.setLon0(value(parameter, Units.DEGREE));
						break;
					}
				} else {
					params.setLon0(value(parameter, Units.DEGREE));
				}
				break;

			case AZIMUTH_OF_INITIAL_LINE:
			case CO_LATITUDE_OF_CONE_AXIS:
				if (method.hasMethod()) {
					switch (method.getMethod()) {
					case HOTINE_OBLIQUE_MERCATOR_B:
						if (params.getProj() == null || !params.getProj()
								.equals(ProjConstants.NAME_SOMERC)) {
							params.setAlpha(value(parameter, Units.DEGREE));
						}
						break;
					default:
						params.setAlpha(value(parameter, Units.DEGREE));
						break;
					}
				} else {
					params.setAlpha(value(parameter, Units.DEGREE));
				}
				break;

			case ANGLE_FROM_RECTIFIED_TO_SKEW_GRID:
				if (method.hasMethod()) {
					switch (method.getMethod()) {
					case HOTINE_OBLIQUE_MERCATOR_B:
						if (params.getProj() == null || !params.getProj()
								.equals(ProjConstants.NAME_SOMERC)) {
							params.setGamma(value(parameter, Units.DEGREE));
						}
						break;
					default:
						params.setGamma(value(parameter, Units.DEGREE));
						break;
					}
				} else {
					params.setGamma(value(parameter, Units.DEGREE));
				}
				break;

			default:
				break;

			}

		}

	}

	/**
	 * Convert axes
	 * 
	 * @param axes
	 *            list of axes
	 * @return axes text
	 */
	private static String convertAxes(List<Axis> axes) {

		String axisValue = null;

		int axesCount = axes.size();
		if (axesCount == 2 || axesCount == 3) {

			StringBuilder axisString = new StringBuilder();

			for (Axis axis : axes) {

				switch (axis.getDirection()) {

				case EAST:
					axisString.append(ProjConstants.AXIS_EAST);
					break;

				case WEST:
					axisString.append(ProjConstants.AXIS_WEST);
					break;

				case NORTH:
					axisString.append(ProjConstants.AXIS_NORTH);
					break;

				case SOUTH:
					axisString.append(ProjConstants.AXIS_SOUTH);
					break;

				case UP:
					axisString.append(ProjConstants.AXIS_UP);
					break;

				case DOWN:
					axisString.append(ProjConstants.AXIS_DOWN);
					break;

				default:
					axisString = null;
					break;

				}

				if (axisString == null) {
					break;
				}
			}

			if (axisString != null) {

				if (axesCount == 2) {
					axisString.append(ProjConstants.AXIS_UP);
				}

				axisValue = axisString.toString();
			}

		}

		return axisValue;
	}

	/**
	 * Get the value of the parameter in the unit
	 * 
	 * @param parameter
	 *            operation parameter
	 * @param unit
	 *            unit
	 * @param inUnit
	 *            in unit
	 * @return converted value
	 */
	private static String value(OperationParameter parameter, Unit unit,
			Units inUnit) {
		return value(parameter, unit, inUnit.createUnit());
	}

	/**
	 * Get the value of the parameter in the unit
	 * 
	 * @param parameter
	 *            operation parameter
	 * @param unit
	 *            unit
	 * @param inUnit
	 *            in unit
	 * @return converted value
	 */
	private static String value(OperationParameter parameter, Unit unit,
			Unit inUnit) {
		Unit parameterUnit = parameter.getUnit();
		if (parameterUnit == null) {
			parameterUnit = unit;
		}
		return convert(parameter.getValue(), parameter.getValueText(),
				parameterUnit, inUnit);
	}

	/**
	 * Get the value of parameter in the unit
	 * 
	 * @param parameter
	 *            operation parameter
	 * @param unit
	 *            unit
	 * @return converted value
	 */
	private static String value(OperationParameter parameter, Units unit) {
		return value(parameter, unit.createUnit());
	}

	/**
	 * Get the value of parameter in the unit
	 * 
	 * @param parameter
	 *            operation parameter
	 * @param unit
	 *            unit
	 * @return converted value
	 */
	private static String value(OperationParameter parameter, Unit unit) {
		return convert(parameter.getValue(), parameter.getValueText(),
				parameter.getUnit(), unit);
	}

	/**
	 * Convert the value
	 * 
	 * @param value
	 *            value
	 * @param textValue
	 *            text value
	 * @param fromUnit
	 *            from unit
	 * @param toUnit
	 *            to unit
	 * @return converted value
	 */
	private static String convert(double value, String textValue, Unit fromUnit,
			Units toUnit) {
		return convert(value, textValue, fromUnit, toUnit.createUnit());
	}

	/**
	 * Convert the value
	 * 
	 * @param value
	 *            value
	 * @param textValue
	 *            text value
	 * @param fromUnit
	 *            from unit
	 * @param toUnit
	 *            to unit
	 * @return converted value
	 */
	private static String convert(double value, String textValue, Unit fromUnit,
			Unit toUnit) {

		if (fromUnit == null) {
			fromUnit = Units.createDefaultUnit(toUnit.getType());
		}

		if (value != 0.0 && Units.canConvert(fromUnit, toUnit)
				&& !fromUnit.equalsName(toUnit)) {
			value = Units.convert(value, fromUnit, toUnit);
			textValue = String.valueOf(value);
		}

		return textValue;
	}

	/**
	 * Get the params text from the params
	 * 
	 * @param params
	 *            projection params
	 * @return params text
	 */
	private static String paramsText(ProjParams params) {
		String text = null;
		if (params != null) {
			text = params.toString();
		}
		return text;
	}

}
