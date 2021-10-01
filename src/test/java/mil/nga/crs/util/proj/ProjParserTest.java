package mil.nga.crs.util.proj;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

/**
 * CRS to proj4 parser tests
 * 
 * @author osbornb
 */
public class ProjParserTest {

	/**
	 * Test EPSG 2036
	 * 
	 * @throws IOException
	 *             upon error
	 */
	// @Test TODO
	public void test2036() throws IOException {

		// +proj=sterea +lat_0=46.5 +lon_0=-66.5 +k=0.999912 +x_0=2500000
		// +y_0=7500000 +ellps=GRS80 +towgs84=0,0,0,0,0,0,0 +units=m +no_defs

		String definition = "PROJCRS[\"NAD83(CSRS98) / New Brunswick Stereo\",BASEGEOGCRS[\"NAD83(CSRS98)\","
				+ "DATUM[\"NAD83 Canadian Spatial Reference System\","
				+ "ELLIPSOID[\"GRS 1980\",6378137,298.2572221,LENGTHUNIT[\"metre\",1,ID[\"EPSG\",9001]],ID[\"EPSG\",7019]],"
				+ "ID[\"EPSG\",6140]],ID[\"EPSG\",4140]],"
				+ "CONVERSION[\"New Brunswick Stereographic (NAD83)\",METHOD[\"Oblique Stereographic\",ID[\"EPSG\",9809]],"
				+ "PARAMETER[\"Latitude of natural origin\",46.5,ANGLEUNIT[\"degree\",0.0174532925199433,ID[\"EPSG\",9102]]],"
				+ "PARAMETER[\"Longitude of natural origin\",-66.5,ANGLEUNIT[\"degree\",0.0174532925199433,ID[\"EPSG\",9102]]],"
				+ "PARAMETER[\"Scale factor at natural origin\",0.999912,SCALEUNIT[\"unity\",1,ID[\"EPSG\",9201]]],"
				+ "PARAMETER[\"False easting\",2500000,LENGTHUNIT[\"metre\",1,ID[\"EPSG\",9001]]],"
				+ "PARAMETER[\"False northing\",7500000,LENGTHUNIT[\"metre\",1,ID[\"EPSG\",9001]]],"
				+ "ID[\"EPSG\",19946]],"
				+ "CS[Cartesian,2,ID[\"EPSG\",4500]],AXIS[\"Northing (N)\",north],AXIS[\"Easting (E)\",east],"
				+ "LENGTHUNIT[\"metre\",1,ID[\"EPSG\",9001]],ID[\"EPSG\",2036]]";

		String expected = "+proj=sterea +lat_0=46.5 +lon_0=-66.5 +k_0=0.999912 +x_0=2500000 +y_0=7500000 +ellps=GRS80 +units=m +no_defs";
		assertEquals(expected, ProjParser.paramsText(definition));

		definition = "PROJCS[\"NAD83(CSRS98) / New Brunswick Stereo (deprecated)\","
				+ "GEOGCS[\"NAD83(CSRS98)\","
				+ "DATUM[\"NAD83_Canadian_Spatial_Reference_System\","
				+ "SPHEROID[\"GRS 1980\",6378137,298.257222101,"
				+ "AUTHORITY[\"EPSG\",\"7019\"]]," + "TOWGS84[0,0,0,0,0,0,0],"
				+ "AUTHORITY[\"EPSG\",\"6140\"]]," + "PRIMEM[\"Greenwich\",0,"
				+ "AUTHORITY[\"EPSG\",\"8901\"]],"
				+ "UNIT[\"degree\",0.0174532925199433,"
				+ "AUTHORITY[\"EPSG\",\"9108\"]],"
				+ "AUTHORITY[\"EPSG\",\"4140\"]],"
				+ "PROJECTION[\"Oblique_Stereographic\"],"
				+ "PARAMETER[\"latitude_of_origin\",46.5],"
				+ "PARAMETER[\"central_meridian\",-66.5],"
				+ "PARAMETER[\"scale_factor\",0.999912],"
				+ "PARAMETER[\"false_easting\",2500000],"
				+ "PARAMETER[\"false_northing\",7500000]," + "UNIT[\"metre\",1,"
				+ "AUTHORITY[\"EPSG\",\"9001\"]],"
				+ "AUTHORITY[\"EPSG\",\"2036\"]]";

		expected = "+proj=sterea +lat_0=46.5 +lon_0=-66.5 +k_0=0.999912 +x_0=2500000 +y_0=7500000 +ellps=GRS80 +towgs84=0,0,0,0,0,0,0 +units=m +no_defs";
		assertEquals(expected, ProjParser.paramsText(definition));

	}

}
