package mil.nga.crs;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

import mil.nga.crs.bound.BoundCoordinateReferenceSystem;
import mil.nga.crs.derived.DerivedCoordinateReferenceSystem;
import mil.nga.crs.engineering.EngineeringCoordinateReferenceSystem;
import mil.nga.crs.geo.GeoCoordinateReferenceSystem;
import mil.nga.crs.metadata.CoordinateMetadata;
import mil.nga.crs.operation.ConcatenatedOperation;
import mil.nga.crs.operation.CoordinateOperation;
import mil.nga.crs.operation.Operation;
import mil.nga.crs.operation.PointMotionOperation;
import mil.nga.crs.parametric.ParametricCoordinateReferenceSystem;
import mil.nga.crs.projected.ProjectedCoordinateReferenceSystem;
import mil.nga.crs.temporal.TemporalCoordinateReferenceSystem;
import mil.nga.crs.util.proj.ProjParams;
import mil.nga.crs.util.proj.ProjParser;
import mil.nga.crs.vertical.VerticalCoordinateReferenceSystem;
import mil.nga.crs.wkt.CRSReader;
import mil.nga.crs.wkt.CRSWriter;

/**
 * README example tests
 * 
 * @author osbornb
 */
public class ReadmeTest {

	/**
	 * Test crs
	 * 
	 * @throws IOException
	 *             upon failure
	 */
	@Test
	public void testCRS() throws IOException {

		String wkt = "GEOGCRS[\"WGS 84\",ENSEMBLE[\"World Geodetic System 1984 ensemble\","
				+ "MEMBER[\"World Geodetic System 1984 (Transit)\",ID[\"EPSG\",1166]],"
				+ "MEMBER[\"World Geodetic System 1984 (G730)\",ID[\"EPSG\",1152]],"
				+ "MEMBER[\"World Geodetic System 1984 (G873)\",ID[\"EPSG\",1153]],"
				+ "MEMBER[\"World Geodetic System 1984 (G1150)\",ID[\"EPSG\",1154]],"
				+ "MEMBER[\"World Geodetic System 1984 (G1674)\",ID[\"EPSG\",1155]],"
				+ "MEMBER[\"World Geodetic System 1984 (G1762)\",ID[\"EPSG\",1156]],"
				+ "ELLIPSOID[\"WGS 84\",6378137.0,298.257223563,ID[\"EPSG\",7030]],"
				+ "ENSEMBLEACCURACY[2.0],ID[\"EPSG\",6326]],"
				+ "CS[ellipsoidal,2,ID[\"EPSG\",6422]],"
				+ "AXIS[\"Geodetic latitude (Lat)\",north],AXIS[\"Geodetic longitude (Lon)\",east],"
				+ "ANGLEUNIT[\"degree\",0.0174532925199433,ID[\"EPSG\",9102]],"
				+ "ID[\"EPSG\",4326]]";

		assertEquals(wkt, testCRS(wkt));

		assertEquals("+proj=longlat +datum=WGS84 +no_defs", testProj(wkt));

	}

	/**
	 * Test crs
	 * 
	 * @param wkt
	 *            crs well-known text
	 * @return well-known text
	 * @throws IOException
	 *             upon failure
	 */
	private String testCRS(String wkt) throws IOException {

		// String wkt = ...

		CRS crs = CRSReader.read(wkt);

		CRSType type = crs.getType();
		CategoryType category = crs.getCategoryType();

		String text = CRSWriter.write(crs);
		String prettyText = CRSWriter.writePretty(crs);

		switch (category) {

		case CRS:

			CoordinateReferenceSystem coordRefSys = (CoordinateReferenceSystem) crs;

			switch (type) {
			case BOUND:
				BoundCoordinateReferenceSystem bound = (BoundCoordinateReferenceSystem) coordRefSys;
				// ...
				break;
			case COMPOUND:
				CompoundCoordinateReferenceSystem compound = (CompoundCoordinateReferenceSystem) coordRefSys;
				// ...
				break;
			case DERIVED:
				DerivedCoordinateReferenceSystem derived = (DerivedCoordinateReferenceSystem) coordRefSys;
				// ...
				break;
			case ENGINEERING:
				EngineeringCoordinateReferenceSystem engineering = (EngineeringCoordinateReferenceSystem) coordRefSys;
				// ...
				break;
			case GEODETIC:
			case GEOGRAPHIC:
				GeoCoordinateReferenceSystem geo = (GeoCoordinateReferenceSystem) coordRefSys;
				// ...
				break;
			case PARAMETRIC:
				ParametricCoordinateReferenceSystem parametric = (ParametricCoordinateReferenceSystem) coordRefSys;
				// ...
				break;
			case PROJECTED:
				ProjectedCoordinateReferenceSystem projected = (ProjectedCoordinateReferenceSystem) coordRefSys;
				// ...
				break;
			case TEMPORAL:
				TemporalCoordinateReferenceSystem temporal = (TemporalCoordinateReferenceSystem) coordRefSys;
				// ...
				break;
			case VERTICAL:
				VerticalCoordinateReferenceSystem vertical = (VerticalCoordinateReferenceSystem) coordRefSys;
				// ...
				break;
			default:
			}

			// ...
			break;

		case METADATA:

			CoordinateMetadata metadata = (CoordinateMetadata) crs;

			// ...
			break;

		case OPERATION:

			Operation operation = (Operation) crs;

			switch (type) {
			case CONCATENATED_OPERATION:
				ConcatenatedOperation concatenatedOperation = (ConcatenatedOperation) operation;
				// ...
				break;
			case COORDINATE_OPERATION:
				CoordinateOperation coordinateOperation = (CoordinateOperation) operation;
				// ...
				break;
			case POINT_MOTION_OPERATION:
				PointMotionOperation pointMotionOperation = (PointMotionOperation) operation;
				// ...
				break;
			default:
			}

			// ...
			break;

		}

		return text;
	}

	/**
	 * Test proj
	 *
	 * @param wkt
	 *            crs well-known text
	 * @return PROJ text
	 * @throws IOException
	 *             upon failure
	 */
	private String testProj(String wkt) throws IOException {

		// String wkt = ...

		CRS crs = CRSReader.read(wkt);

		ProjParams projParamsFromCRS = ProjParser.params(crs);
		String projTextFromCRS = ProjParser.paramsText(crs);
		ProjParams projParamsFromWKT = ProjParser.params(wkt);
		String projTextFromWKT = ProjParser.paramsText(wkt);

		return projTextFromWKT;
	}

}
