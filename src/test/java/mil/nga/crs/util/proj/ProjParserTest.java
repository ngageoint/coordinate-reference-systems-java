package mil.nga.crs.util.proj;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

/**
 * CRS to PROJ parser tests
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
	@Test
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

	/**
	 * Test EPSG 2046
	 * 
	 * @throws IOException
	 *             upon error
	 */
	@Test
	public void test2046() throws IOException {

		// +proj=tmerc +lat_0=0 +lon_0=15 +k=1 +x_0=0 +y_0=0 +axis=wsu
		// +ellps=WGS84 +towgs84=0,0,0,0,0,0,0 +units=m +no_defs

		String definition = "PROJCRS[\"Hartebeesthoek94 / Lo15\",BASEGEOGCRS[\"Hartebeesthoek94\","
				+ "DATUM[\"Hartebeesthoek94\","
				+ "ELLIPSOID[\"WGS 84\",6378137,298.2572236,LENGTHUNIT[\"metre\",1,ID[\"EPSG\",9001]],ID[\"EPSG\",7030]],"
				+ "ID[\"EPSG\",6148]],ID[\"EPSG\",4148]],"
				+ "CONVERSION[\"South African Survey Grid zone 15\",METHOD[\"Transverse Mercator (South Orientated)\",ID[\"EPSG\",9808]],"
				+ "PARAMETER[\"Latitude of natural origin\",0,ANGLEUNIT[\"degree\",0.0174532925199433,ID[\"EPSG\",9102]]],"
				+ "PARAMETER[\"Longitude of natural origin\",15,ANGLEUNIT[\"degree\",0.0174532925199433,ID[\"EPSG\",9102]]],"
				+ "PARAMETER[\"Scale factor at natural origin\",1,SCALEUNIT[\"unity\",1,ID[\"EPSG\",9201]]],"
				+ "PARAMETER[\"False easting\",0,LENGTHUNIT[\"metre\",1,ID[\"EPSG\",9001]]],"
				+ "PARAMETER[\"False northing\",0,LENGTHUNIT[\"metre\",1,ID[\"EPSG\",9001]]],"
				+ "ID[\"EPSG\",17515]],"
				+ "CS[Cartesian,2,ID[\"EPSG\",6503]],AXIS[\"Westing (Y)\",west],AXIS[\"Southing (X)\",south],"
				+ "LENGTHUNIT[\"metre\",1,ID[\"EPSG\",9001]],ID[\"EPSG\",2046]]";

		String expected = "+proj=tmerc +lat_0=0 +lon_0=15 +k_0=1 +x_0=0 +y_0=0 +axis=wsu +ellps=WGS84 +units=m +no_defs";
		assertEquals(expected, ProjParser.paramsText(definition));

		definition = "PROJCS[\"Hartebeesthoek94 / Lo15\","
				+ "GEOGCS[\"Hartebeesthoek94\"," + "DATUM[\"Hartebeesthoek94\","
				+ "SPHEROID[\"WGS 84\",6378137,298.257223563,"
				+ "AUTHORITY[\"EPSG\",\"7030\"]]," + "TOWGS84[0,0,0,0,0,0,0],"
				+ "AUTHORITY[\"EPSG\",\"6148\"]]," + "PRIMEM[\"Greenwich\",0,"
				+ "AUTHORITY[\"EPSG\",\"8901\"]],"
				+ "UNIT[\"degree\",0.0174532925199433,"
				+ "AUTHORITY[\"EPSG\",\"9122\"]],"
				+ "AUTHORITY[\"EPSG\",\"4148\"]],"
				+ "PROJECTION[\"Transverse_Mercator_South_Orientated\"],"
				+ "PARAMETER[\"latitude_of_origin\",0],"
				+ "PARAMETER[\"central_meridian\",15],"
				+ "PARAMETER[\"scale_factor\",1],"
				+ "PARAMETER[\"false_easting\",0],"
				+ "PARAMETER[\"false_northing\",0]," + "UNIT[\"metre\",1,"
				+ "AUTHORITY[\"EPSG\",\"9001\"]]," + "AXIS[\"Y\",WEST],"
				+ "AXIS[\"X\",SOUTH]," + "AUTHORITY[\"EPSG\",\"2046\"]]";

		expected = "+proj=tmerc +lat_0=0 +lon_0=15 +k_0=1 +x_0=0 +y_0=0 +axis=wsu +ellps=WGS84 +towgs84=0,0,0,0,0,0,0 +units=m +no_defs";
		assertEquals(expected, ProjParser.paramsText(definition));

	}

	/**
	 * Test EPSG 2056
	 * 
	 * @throws IOException
	 *             upon error
	 */
	@Test
	public void test2056() throws IOException {

		// +proj=somerc +lat_0=46.95240555555556 +lon_0=7.439583333333333 +k_0=1
		// +x_0=2600000 +y_0=1200000 +ellps=bessel
		// +towgs84=674.374,15.056,405.346,0,0,0,0 +units=m +no_defs

		String definition = "PROJCRS[\"CH1903+ / LV95\",BASEGEOGCRS[\"CH1903+\",DATUM[\"CH1903+\","
				+ "ELLIPSOID[\"Bessel 1841\",6377397.155,299.1528128,LENGTHUNIT[\"metre\",1,ID[\"EPSG\",9001]],ID[\"EPSG\",7004]],"
				+ "ID[\"EPSG\",6150]],ID[\"EPSG\",4150]],"
				+ "CONVERSION[\"Swiss Oblique Mercator 1995\",METHOD[\"Hotine Oblique Mercator (variant B)\",ID[\"EPSG\",9815]],"
				+ "PARAMETER[\"Latitude of projection centre\",46.952405556,ANGLEUNIT[\"degree\",0.0174532925199433,ID[\"EPSG\",9102]]],"
				+ "PARAMETER[\"Longitude of projection centre\",7.439583333,ANGLEUNIT[\"degree\",0.0174532925199433,ID[\"EPSG\",9102]]],"
				+ "PARAMETER[\"Azimuth of initial line\",90,ANGLEUNIT[\"degree\",0.0174532925199433,ID[\"EPSG\",9102]]],"
				+ "PARAMETER[\"Angle from Rectified to Skew Grid\",90,ANGLEUNIT[\"degree\",0.0174532925199433,ID[\"EPSG\",9102]]],"
				+ "PARAMETER[\"Scale factor on initial line\",1,SCALEUNIT[\"unity\",1,ID[\"EPSG\",9201]]],"
				+ "PARAMETER[\"Easting at projection centre\",2600000,LENGTHUNIT[\"metre\",1,ID[\"EPSG\",9001]]],"
				+ "PARAMETER[\"Northing at projection centre\",1200000,LENGTHUNIT[\"metre\",1,ID[\"EPSG\",9001]]],"
				+ "PARAMETER[\"X-axis translation\",674.374,LENGTHUNIT[\"metre\",1.0]],"
				+ "PARAMETER[\"Y-axis translation\",15.056,LENGTHUNIT[\"metre\",1.0]],"
				+ "PARAMETER[\"Z-axis translation\",405.346,LENGTHUNIT[\"metre\",1.0]],"
				+ "ID[\"EPSG\",19950]],"
				+ "CS[Cartesian,2,ID[\"EPSG\",4400]],AXIS[\"Easting (E)\",east],AXIS[\"Northing (N)\",north],"
				+ "LENGTHUNIT[\"metre\",1,ID[\"EPSG\",9001]],ID[\"EPSG\",2056]]";

		String expected = "+proj=somerc +lat_0=46.952405556 +lon_0=7.439583333 +k_0=1 +x_0=2600000 +y_0=1200000 +ellps=bessel +towgs84=674.374,15.056,405.346,0,0,0,0 +units=m +no_defs";
		assertEquals(expected, ProjParser.paramsText(definition));

		definition = "PROJCS[\"CH1903+ / LV95\"," + "GEOGCS[\"CH1903+\","
				+ "DATUM[\"CH1903+\","
				+ "SPHEROID[\"Bessel 1841\",6377397.155,299.1528128,"
				+ "AUTHORITY[\"EPSG\",\"7004\"]],"
				+ "TOWGS84[674.374,15.056,405.346,0,0,0,0],"
				+ "AUTHORITY[\"EPSG\",\"6150\"]]," + "PRIMEM[\"Greenwich\",0,"
				+ "AUTHORITY[\"EPSG\",\"8901\"]],"
				+ "UNIT[\"degree\",0.0174532925199433,"
				+ "AUTHORITY[\"EPSG\",\"9122\"]],"
				+ "AUTHORITY[\"EPSG\",\"4150\"]],"
				+ "PROJECTION[\"Hotine_Oblique_Mercator_Azimuth_Center\"],"
				+ "PARAMETER[\"latitude_of_center\",46.95240555555556],"
				+ "PARAMETER[\"longitude_of_center\",7.439583333333333],"
				+ "PARAMETER[\"azimuth\",90],"
				+ "PARAMETER[\"rectified_grid_angle\",90],"
				+ "PARAMETER[\"scale_factor\",1],"
				+ "PARAMETER[\"false_easting\",2600000],"
				+ "PARAMETER[\"false_northing\",1200000]," + "UNIT[\"metre\",1,"
				+ "AUTHORITY[\"EPSG\",\"9001\"]]," + "AXIS[\"Y\",EAST],"
				+ "AXIS[\"X\",NORTH]," + "AUTHORITY[\"EPSG\",\"2056\"]]";

		expected = "+proj=somerc +lat_0=46.95240555555556 +lon_0=7.439583333333333 +k_0=1 +x_0=2600000 +y_0=1200000 +ellps=bessel +towgs84=674.374,15.056,405.346,0,0,0,0 +units=m +no_defs";
		assertEquals(expected, ProjParser.paramsText(definition));

	}

}
