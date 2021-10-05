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

	/**
	 * Test EPSG 2057
	 * 
	 * @throws IOException
	 *             upon error
	 */
	@Test
	public void test2057() throws IOException {

		// +proj=omerc +lat_0=27.51882880555555 +lonc=52.60353916666667
		// +alpha=0.5716611944444444 +k=0.999895934 +x_0=658377.437
		// +y_0=3044969.194 +gamma=0.5716611944444444 +ellps=intl
		// +towgs84=-133.63,-157.5,-158.62,0,0,0,0 +units=m +no_defs

		String definition = "PROJCRS[\"Rassadiran / Nakhl e Taqi\",BASEGEOGCRS[\"Rassadiran\","
				+ "DATUM[\"Rassadiran\",ELLIPSOID[\"International 1924\",6378388,297,LENGTHUNIT[\"metre\",1,ID[\"EPSG\",9001]],"
				+ "ID[\"EPSG\",7022]],ID[\"EPSG\",6153]],ID[\"EPSG\",4153]],"
				+ "CONVERSION[\"Nakhl e Taqi Oblique Mercator\",METHOD[\"Hotine Oblique Mercator (variant B)\",ID[\"EPSG\",9815]],"
				+ "PARAMETER[\"Latitude of projection centre\",27.518828806,ANGLEUNIT[\"degree\",0.0174532925199433,ID[\"EPSG\",9102]]],"
				+ "PARAMETER[\"Longitude of projection centre\",52.603539167,ANGLEUNIT[\"degree\",0.0174532925199433,ID[\"EPSG\",9102]]],"
				+ "PARAMETER[\"Azimuth of initial line\",0.571661194,ANGLEUNIT[\"degree\",0.0174532925199433,ID[\"EPSG\",9102]]],"
				+ "PARAMETER[\"Angle from Rectified to Skew Grid\",0.571661194,ANGLEUNIT[\"degree\",0.0174532925199433,ID[\"EPSG\",9102]]],"
				+ "PARAMETER[\"Scale factor on initial line\",0.999895934,SCALEUNIT[\"unity\",1,ID[\"EPSG\",9201]]],"
				+ "PARAMETER[\"Easting at projection centre\",658377.437,LENGTHUNIT[\"metre\",1,ID[\"EPSG\",9001]]],"
				+ "PARAMETER[\"Northing at projection centre\",3044969.194,LENGTHUNIT[\"metre\",1,ID[\"EPSG\",9001]]],"
				+ "PARAMETER[\"X-axis translation\",-133.63,LENGTHUNIT[\"metre\",1.0]],"
				+ "PARAMETER[\"Y-axis translation\",-157.5,LENGTHUNIT[\"metre\",1.0]],"
				+ "PARAMETER[\"Z-axis translation\",-158.62,LENGTHUNIT[\"metre\",1.0]],"
				+ "ID[\"EPSG\",19951]],CS[Cartesian,2,ID[\"EPSG\",4400]],"
				+ "AXIS[\"Easting (E)\",east],AXIS[\"Northing (N)\",north],"
				+ "LENGTHUNIT[\"metre\",1,ID[\"EPSG\",9001]],ID[\"EPSG\",2057]]";

		String expected = "+proj=omerc +lat_0=27.518828806 +lonc=52.603539167 +alpha=0.571661194 +k_0=0.999895934 +x_0=658377.437 +y_0=3044969.194 +gamma=0.571661194 +ellps=intl +towgs84=-133.63,-157.5,-158.62,0,0,0,0 +units=m +no_defs";
		assertEquals(expected, ProjParser.paramsText(definition));

		definition = "PROJCS[\"Rassadiran / Nakhl e Taqi\",GEOGCS[\"Rassadiran\","
				+ "DATUM[\"Rassadiran\",SPHEROID[\"International 1924\",6378388,297,"
				+ "AUTHORITY[\"EPSG\",\"7022\"]],TOWGS84[-133.63,-157.5,-158.62,0,0,0,0],AUTHORITY[\"EPSG\",\"6153\"]],"
				+ "PRIMEM[\"Greenwich\",0,AUTHORITY[\"EPSG\",\"8901\"]],UNIT[\"degree\",0.01745329251994328,AUTHORITY[\"EPSG\",\"9122\"]],"
				+ "AUTHORITY[\"EPSG\",\"4153\"]],UNIT[\"metre\",1,AUTHORITY[\"EPSG\",\"9001\"]],"
				+ "PROJECTION[\"Oblique_Mercator\"],"
				+ "PARAMETER[\"latitude_of_center\",27.51882880555555],"
				+ "PARAMETER[\"longitude_of_center\",52.60353916666667],"
				+ "PARAMETER[\"azimuth\",0.5716611944444444],"
				+ "PARAMETER[\"rectified_grid_angle\",0.5716611944444444],"
				+ "PARAMETER[\"scale_factor\",0.999895934],"
				+ "PARAMETER[\"false_easting\",658377.437],"
				+ "PARAMETER[\"false_northing\",3044969.194],AUTHORITY[\"EPSG\",\"2057\"],"
				+ "AXIS[\"Easting\",EAST],AXIS[\"Northing\",NORTH]]";

		expected = "+proj=omerc +lat_0=27.51882880555555 +lonc=52.60353916666667 +alpha=0.5716611944444444 +k_0=0.999895934 +x_0=658377.437 +y_0=3044969.194 +gamma=0.5716611944444444 +ellps=intl +towgs84=-133.63,-157.5,-158.62,0,0,0,0 +units=m +no_defs";
		assertEquals(expected, ProjParser.paramsText(definition));

	}

	/**
	 * Test EPSG 2065
	 * 
	 * @throws IOException
	 *             upon error
	 */
	@Test
	public void test2065() throws IOException {

		// +proj=krovak +lat_0=49.5 +lon_0=42.5 +alpha=30.28813972222222
		// +k=0.9999 +x_0=0 +y_0=0 +ellps=bessel +towgs84=589,76,480,0,0,0,0
		// +pm=ferro +units=m +no_defs

		String definition = "PROJCRS[\"S-JTSK (Ferro) / Krovak\",BASEGEOGCRS[\"S-JTSK (Ferro)\","
				+ "DATUM[\"System of the Unified Trigonometrical Cadastral Network (Ferro)\","
				+ "ELLIPSOID[\"Bessel 1841\",6377397.155,299.1528128,LENGTHUNIT[\"metre\",1,ID[\"EPSG\",9001]],ID[\"EPSG\",7004]],ID[\"EPSG\",6818]],"
				+ "PRIMEM[\"Ferro\",-17.666666667,ANGLEUNIT[\"degree\",0.0174532925199433,ID[\"EPSG\",9102]],ID[\"EPSG\",8909]],ID[\"EPSG\",4818]],"
				+ "CONVERSION[\"Krovak\",METHOD[\"Krovak\",ID[\"EPSG\",9819]],"
				+ "PARAMETER[\"Latitude of projection centre\",49.5,ANGLEUNIT[\"degree\",0.0174532925199433,ID[\"EPSG\",9102]]],"
				+ "PARAMETER[\"Longitude of origin\",42.5,ANGLEUNIT[\"degree\",0.0174532925199433,ID[\"EPSG\",9102]]],"
				+ "PARAMETER[\"Co-latitude of cone axis\",30.288139753,ANGLEUNIT[\"degree\",0.0174532925199433,ID[\"EPSG\",9102]]],"
				+ "PARAMETER[\"Latitude of pseudo standard parallel\",78.5,ANGLEUNIT[\"degree\",0.0174532925199433,ID[\"EPSG\",9102]]],"
				+ "PARAMETER[\"Scale factor on pseudo standard parallel\",0.9999,SCALEUNIT[\"unity\",1,ID[\"EPSG\",9201]]],"
				+ "PARAMETER[\"False easting\",0,LENGTHUNIT[\"metre\",1,ID[\"EPSG\",9001]]],"
				+ "PARAMETER[\"False northing\",0,LENGTHUNIT[\"metre\",1,ID[\"EPSG\",9001]]],"
				+ "PARAMETER[\"X-axis translation\",589,LENGTHUNIT[\"metre\",1.0]],"
				+ "PARAMETER[\"Y-axis translation\",76,LENGTHUNIT[\"metre\",1.0]],"
				+ "PARAMETER[\"Z-axis translation\",480,LENGTHUNIT[\"metre\",1.0]],"
				+ "ID[\"EPSG\",19952]],"
				+ "CS[Cartesian,2,ID[\"EPSG\",6501]],AXIS[\"Southing (X)\",south],AXIS[\"Westing (Y)\",west],"
				+ "LENGTHUNIT[\"metre\",1,ID[\"EPSG\",9001]],ID[\"EPSG\",2065]]";

		String expected = "+proj=krovak +lat_0=49.5 +lon_0=42.5 +alpha=30.288139753 +k_0=0.9999 +x_0=0 +y_0=0 +ellps=bessel +towgs84=589,76,480,0,0,0,0 +pm=ferro +units=m +no_defs";
		assertEquals(expected, ProjParser.paramsText(definition));

		definition = "PROJCS[\"S-JTSK (Ferro) / Krovak\","
				+ "GEOGCS[\"S-JTSK (Ferro)\","
				+ "DATUM[\"System_Jednotne_Trigonometricke_Site_Katastralni_Ferro\","
				+ "SPHEROID[\"Bessel 1841\",6377397.155,299.1528128,"
				+ "AUTHORITY[\"EPSG\",\"7004\"]],"
				+ "TOWGS84[589,76,480,0,0,0,0],"
				+ "AUTHORITY[\"EPSG\",\"6818\"]],"
				+ "PRIMEM[\"Ferro\",-17.66666666666667,"
				+ "AUTHORITY[\"EPSG\",\"8909\"]],"
				+ "UNIT[\"degree\",0.0174532925199433,"
				+ "AUTHORITY[\"EPSG\",\"9122\"]],"
				+ "AUTHORITY[\"EPSG\",\"4818\"]]," + "PROJECTION[\"Krovak\"],"
				+ "PARAMETER[\"latitude_of_center\",49.5],"
				+ "PARAMETER[\"longitude_of_center\",42.5],"
				+ "PARAMETER[\"azimuth\",30.28813972222222],"
				+ "PARAMETER[\"pseudo_standard_parallel_1\",78.5],"
				+ "PARAMETER[\"scale_factor\",0.9999],"
				+ "PARAMETER[\"false_easting\",0],"
				+ "PARAMETER[\"false_northing\",0]," + "UNIT[\"metre\",1,"
				+ "AUTHORITY[\"EPSG\",\"9001\"]]," + "AXIS[\"X\",SOUTH],"
				+ "AXIS[\"Y\",WEST]," + "AUTHORITY[\"EPSG\",\"2065\"]]";

		expected = "+proj=krovak +lat_0=49.5 +lon_0=42.5 +alpha=30.28813972222222 +k_0=0.9999 +x_0=0 +y_0=0 +ellps=bessel +towgs84=589,76,480,0,0,0,0 +pm=ferro +units=m +no_defs";
		assertEquals(expected, ProjParser.paramsText(definition));

	}

	/**
	 * Test EPSG 2066
	 * 
	 * @throws IOException
	 *             upon error
	 */
	@Test
	public void test2066() throws IOException {

		// +proj=cass +lat_0=11.25217861111111 +lon_0=-60.68600888888889
		// +x_0=37718.66159325 +y_0=36209.91512952 +a=6378293.645208759
		// +b=6356617.987679838 +to_meter=0.201166195164 +no_defs

		String definition = "PROJCRS[\"Mount Dillon / Tobago Grid\",BASEGEOGCRS[\"Mount Dillon\","
				+ "DATUM[\"Mount Dillon\","
				+ "ELLIPSOID[\"Clarke 1858\",20926348,294.2606764,LENGTHUNIT[\"Clarke's foot\",0.3047972654,ID[\"EPSG\",9005]],ID[\"EPSG\",7007]],"
				+ "ID[\"EPSG\",6157]],ID[\"EPSG\",4157]],"
				+ "CONVERSION[\"Tobago Grid\",METHOD[\"Cassini-Soldner\",ID[\"EPSG\",9806]],"
				+ "PARAMETER[\"Latitude of natural origin\",11.252178611,ANGLEUNIT[\"degree\",0.0174532925199433,ID[\"EPSG\",9102]]],"
				+ "PARAMETER[\"Longitude of natural origin\",-60.686008889,ANGLEUNIT[\"degree\",0.0174532925199433,ID[\"EPSG\",9102]]],"
				+ "PARAMETER[\"False easting\",187500,LENGTHUNIT[\"Clarke's link\",0.201166195164,ID[\"EPSG\",9039]]],"
				+ "PARAMETER[\"False northing\",180000,LENGTHUNIT[\"Clarke's link\",0.201166195164,ID[\"EPSG\",9039]]],"
				+ "ID[\"EPSG\",19924]],"
				+ "CS[Cartesian,2,ID[\"EPSG\",4407]],AXIS[\"Easting (E)\",east],AXIS[\"Northing (N)\",north],"
				+ "LENGTHUNIT[\"Clarke's link\",0.201166195164,ID[\"EPSG\",9039]],ID[\"EPSG\",2066]]";

		String expected = "+proj=cass +lat_0=11.252178611 +lon_0=-60.686008889 +x_0=37718.66159325 +y_0=36209.91512952 +a=6378293.645208759 +b=6356617.987682102 +to_meter=0.201166195164 +no_defs";
		assertEquals(expected, ProjParser.paramsText(definition));

		definition = "PROJCS[\"Mount Dillon / Tobago Grid\","
				+ "GEOGCS[\"Mount Dillon\"," + "DATUM[\"Mount_Dillon\","
				+ "SPHEROID[\"Clarke 1858\",6378293.645208759,294.2606763692569,"
				+ "AUTHORITY[\"EPSG\",\"7007\"]],"
				+ "AUTHORITY[\"EPSG\",\"6157\"]]," + "PRIMEM[\"Greenwich\",0,"
				+ "AUTHORITY[\"EPSG\",\"8901\"]],"
				+ "UNIT[\"degree\",0.0174532925199433,"
				+ "AUTHORITY[\"EPSG\",\"9122\"]],"
				+ "AUTHORITY[\"EPSG\",\"4157\"]],"
				+ "PROJECTION[\"Cassini_Soldner\"],"
				+ "PARAMETER[\"latitude_of_origin\",11.25217861111111],"
				+ "PARAMETER[\"central_meridian\",-60.68600888888889],"
				+ "PARAMETER[\"false_easting\",187500],"
				+ "PARAMETER[\"false_northing\",180000],"
				+ "UNIT[\"Clarke's link\",0.201166195164,"
				+ "AUTHORITY[\"EPSG\",\"9039\"]]," + "AXIS[\"Easting\",EAST],"
				+ "AXIS[\"Northing\",NORTH]," + "AUTHORITY[\"EPSG\",\"2066\"]]";

		expected = "+proj=cass +lat_0=11.25217861111111 +lon_0=-60.68600888888889 +x_0=37718.66159325 +y_0=36209.91512952 +a=6378293.645208759 +b=6356617.987679838 +to_meter=0.201166195164 +no_defs";
		assertEquals(expected, ProjParser.paramsText(definition));

	}

	/**
	 * Test EPSG 2085
	 * 
	 * @throws IOException
	 *             upon error
	 */
	@Test
	public void test2085() throws IOException {

		// +proj=lcc +lat_1=22.35 +lat_0=22.35 +lon_0=-81 +k_0=0.99993602
		// +x_0=500000 +y_0=280296.016 +datum=NAD27 +units=m +no_defs

		String definition = "PROJCRS[\"NAD27 / Cuba Norte\",BASEGEOGCRS[\"NAD27\","
				+ "DATUM[\"North American Datum 1927\","
				+ "ELLIPSOID[\"Clarke 1866\",6378206.4,294.9786982,LENGTHUNIT[\"metre\",1,ID[\"EPSG\",9001]],ID[\"EPSG\",7008]],"
				+ "ID[\"EPSG\",6267]],ID[\"EPSG\",4267]],"
				+ "CONVERSION[\"Cuba Norte\",METHOD[\"Lambert Conic Conformal (1SP)\",ID[\"EPSG\",9801]],"
				+ "PARAMETER[\"Latitude of natural origin\",22.35,ANGLEUNIT[\"degree\",0.0174532925199433,ID[\"EPSG\",9102]]],"
				+ "PARAMETER[\"Longitude of natural origin\",-81,ANGLEUNIT[\"degree\",0.0174532925199433,ID[\"EPSG\",9102]]],"
				+ "PARAMETER[\"Scale factor at natural origin\",0.99993602,SCALEUNIT[\"unity\",1,ID[\"EPSG\",9201]]],"
				+ "PARAMETER[\"False easting\",500000,LENGTHUNIT[\"metre\",1,ID[\"EPSG\",9001]]],"
				+ "PARAMETER[\"False northing\",280296.016,LENGTHUNIT[\"metre\",1,ID[\"EPSG\",9001]]],"
				+ "ID[\"EPSG\",18061]],"
				+ "CS[Cartesian,2,ID[\"EPSG\",4532]],AXIS[\"Northing (Y)\",north],AXIS[\"Easting (X)\",east],"
				+ "LENGTHUNIT[\"metre\",1,ID[\"EPSG\",9001]],ID[\"EPSG\",2085]]";

		String expected = "+proj=lcc +lat_1=22.35 +lat_0=22.35 +lon_0=-81 +k_0=0.99993602 +x_0=500000 +y_0=280296.016 +datum=NAD27 +units=m +no_defs";
		assertEquals(expected, ProjParser.paramsText(definition));

		definition = "PROJCS[\"NAD27 / Cuba Norte (deprecated)\","
				+ "GEOGCS[\"NAD27\"," + "DATUM[\"North_American_Datum_1927\","
				+ "SPHEROID[\"Clarke 1866\",6378206.4,294.9786982139006,"
				+ "AUTHORITY[\"EPSG\",\"7008\"]],"
				+ "AUTHORITY[\"EPSG\",\"6267\"]]," + "PRIMEM[\"Greenwich\",0,"
				+ "AUTHORITY[\"EPSG\",\"8901\"]],"
				+ "UNIT[\"degree\",0.0174532925199433,"
				+ "AUTHORITY[\"EPSG\",\"9122\"]],"
				+ "AUTHORITY[\"EPSG\",\"4267\"]],"
				+ "PROJECTION[\"Lambert_Conformal_Conic_1SP\"],"
				+ "PARAMETER[\"latitude_of_origin\",22.35],"
				+ "PARAMETER[\"central_meridian\",-81],"
				+ "PARAMETER[\"scale_factor\",0.99993602],"
				+ "PARAMETER[\"false_easting\",500000],"
				+ "PARAMETER[\"false_northing\",280296.016],"
				+ "UNIT[\"metre\",1," + "AUTHORITY[\"EPSG\",\"9001\"]],"
				+ "AUTHORITY[\"EPSG\",\"2085\"]]";

		expected = "+proj=lcc +lat_1=22.35 +lat_0=22.35 +lon_0=-81 +k_0=0.99993602 +x_0=500000 +y_0=280296.016 +datum=NAD27 +units=m +no_defs";
		assertEquals(expected, ProjParser.paramsText(definition));

	}

	/**
	 * Test EPSG 2088
	 * 
	 * @throws IOException
	 *             upon error
	 */
	@Test
	public void test2088() throws IOException {

		// +proj=tmerc +lat_0=0 +lon_0=11 +k=0.9996 +x_0=500000 +y_0=0
		// +datum=carthage +units=m +no_defs

		String definition = "PROJCRS[\"Carthage / TM 11 NE\",BASEGEOGCRS[\"Carthage\","
				+ "DATUM[\"Carthage\","
				+ "ELLIPSOID[\"Clarke 1880 (IGN)\",6378249.2,293.4660213,LENGTHUNIT[\"metre\",1,ID[\"EPSG\",9001]],ID[\"EPSG\",7011]],"
				+ "ID[\"EPSG\",6223]],ID[\"EPSG\",4223]],"
				+ "CONVERSION[\"TM 11 NE\",METHOD[\"Transverse Mercator\",ID[\"EPSG\",9807]],"
				+ "PARAMETER[\"Latitude of natural origin\",0,ANGLEUNIT[\"degree\",0.0174532925199433,ID[\"EPSG\",9102]]],"
				+ "PARAMETER[\"Longitude of natural origin\",11,ANGLEUNIT[\"degree\",0.0174532925199433,ID[\"EPSG\",9102]]],"
				+ "PARAMETER[\"Scale factor at natural origin\",0.9996,SCALEUNIT[\"unity\",1,ID[\"EPSG\",9201]]],"
				+ "PARAMETER[\"False easting\",500000,LENGTHUNIT[\"metre\",1,ID[\"EPSG\",9001]]],"
				+ "PARAMETER[\"False northing\",0,LENGTHUNIT[\"metre\",1,ID[\"EPSG\",9001]]],"
				+ "ID[\"EPSG\",16411]],"
				+ "CS[Cartesian,2,ID[\"EPSG\",4400]],AXIS[\"Easting (E)\",east],AXIS[\"Northing (N)\",north],"
				+ "LENGTHUNIT[\"metre\",1,ID[\"EPSG\",9001]],ID[\"EPSG\",2088]]";

		String expected = "+proj=tmerc +lat_0=0 +lon_0=11 +k_0=0.9996 +x_0=500000 +y_0=0 +datum=carthage +units=m +no_defs";
		assertEquals(expected, ProjParser.paramsText(definition));

		definition = "PROJCS[\"Carthage / TM 11 NE\"," + "GEOGCS[\"Carthage\","
				+ "DATUM[\"Carthage\","
				+ "SPHEROID[\"Clarke 1880 (IGN)\",6378249.2,293.4660212936265,"
				+ "AUTHORITY[\"EPSG\",\"7011\"]],"
				+ "TOWGS84[-263,6,431,0,0,0,0],"
				+ "AUTHORITY[\"EPSG\",\"6223\"]]," + "PRIMEM[\"Greenwich\",0,"
				+ "AUTHORITY[\"EPSG\",\"8901\"]],"
				+ "UNIT[\"degree\",0.0174532925199433,"
				+ "AUTHORITY[\"EPSG\",\"9122\"]],"
				+ "AUTHORITY[\"EPSG\",\"4223\"]],"
				+ "PROJECTION[\"Transverse_Mercator\"],"
				+ "PARAMETER[\"latitude_of_origin\",0],"
				+ "PARAMETER[\"central_meridian\",11],"
				+ "PARAMETER[\"scale_factor\",0.9996],"
				+ "PARAMETER[\"false_easting\",500000],"
				+ "PARAMETER[\"false_northing\",0]," + "UNIT[\"metre\",1,"
				+ "AUTHORITY[\"EPSG\",\"9001\"]]," + "AXIS[\"Easting\",EAST],"
				+ "AXIS[\"Northing\",NORTH]," + "AUTHORITY[\"EPSG\",\"2088\"]]";

		expected = "+proj=tmerc +lat_0=0 +lon_0=11 +k_0=0.9996 +x_0=500000 +y_0=0 +datum=carthage +towgs84=-263,6,431,0,0,0,0 +units=m +no_defs";
		assertEquals(expected, ProjParser.paramsText(definition));

	}

	/**
	 * Test EPSG 2155
	 * 
	 * @throws IOException
	 *             upon error
	 */
	@Test
	public void test2155() throws IOException {

		// +proj=lcc +lat_1=-14.26666666666667 +lat_0=-14.26666666666667
		// +lon_0=170 +k_0=1 +x_0=152400.3048006096 +y_0=0 +ellps=clrk66
		// +towgs84=-115,118,426,0,0,0,0 +units=us-ft +no_defs

		String definition = "PROJCRS[\"American Samoa 1962 / American Samoa Lambert\",BASEGEOGCRS[\"American Samoa 1962\","
				+ "DATUM[\"American Samoa 1962\","
				+ "ELLIPSOID[\"Clarke 1866\",6378206.4,294.9786982,LENGTHUNIT[\"metre\",1,ID[\"EPSG\",9001]],ID[\"EPSG\",7008]],"
				+ "ID[\"EPSG\",6169]],ID[\"EPSG\",4169]],"
				+ "CONVERSION[\"American Samoa Lambert\",METHOD[\"Lambert Conic Conformal (1SP)\",ID[\"EPSG\",9801]],"
				+ "PARAMETER[\"Latitude of natural origin\",-14.266666667,ANGLEUNIT[\"degree\",0.0174532925199433,ID[\"EPSG\",9102]]],"
				+ "PARAMETER[\"Longitude of natural origin\",170,ANGLEUNIT[\"degree\",0.0174532925199433,ID[\"EPSG\",9102]]],"
				+ "PARAMETER[\"Scale factor at natural origin\",1,SCALEUNIT[\"unity\",1,ID[\"EPSG\",9201]]],"
				+ "PARAMETER[\"False easting\",500000,LENGTHUNIT[\"US survey foot\",0.304800609601219,ID[\"EPSG\",9003]]],"
				+ "PARAMETER[\"False northing\",0,LENGTHUNIT[\"US survey foot\",0.304800609601219,ID[\"EPSG\",9003]]],"
				+ "PARAMETER[\"X-axis translation\",-115,LENGTHUNIT[\"metre\",1.0]],"
				+ "PARAMETER[\"Y-axis translation\",118,LENGTHUNIT[\"metre\",1.0]],"
				+ "PARAMETER[\"Z-axis translation\",426,LENGTHUNIT[\"metre\",1.0]],"
				+ "ID[\"EPSG\",15300]],"
				+ "CS[Cartesian,2,ID[\"EPSG\",4497]],AXIS[\"Easting (X)\",east],AXIS[\"Northing (Y)\",north],"
				+ "LENGTHUNIT[\"US survey foot\",0.304800609601219,ID[\"EPSG\",9003]],ID[\"EPSG\",2155]]";

		String expected = "+proj=lcc +lat_1=-14.266666667 +lat_0=-14.266666667 +lon_0=170 +k_0=1 +x_0=152400.3048006095 +y_0=0 +ellps=clrk66 +towgs84=-115,118,426,0,0,0,0 +units=us-ft +no_defs";
		assertEquals(expected, ProjParser.paramsText(definition));

		definition = "PROJCS[\"American Samoa 1962 / American Samoa Lambert (deprecated)\","
				+ "GEOGCS[\"American Samoa 1962\","
				+ "DATUM[\"American_Samoa_1962\","
				+ "SPHEROID[\"Clarke 1866\",6378206.4,294.9786982139006,"
				+ "AUTHORITY[\"EPSG\",\"7008\"]],"
				+ "TOWGS84[-115,118,426,0,0,0,0],"
				+ "AUTHORITY[\"EPSG\",\"6169\"]]," + "PRIMEM[\"Greenwich\",0,"
				+ "AUTHORITY[\"EPSG\",\"8901\"]],"
				+ "UNIT[\"degree\",0.0174532925199433,"
				+ "AUTHORITY[\"EPSG\",\"9122\"]],"
				+ "AUTHORITY[\"EPSG\",\"4169\"]],"
				+ "PROJECTION[\"Lambert_Conformal_Conic_1SP\"],"
				+ "PARAMETER[\"latitude_of_origin\",-14.26666666666667],"
				+ "PARAMETER[\"central_meridian\",170],"
				+ "PARAMETER[\"scale_factor\",1],"
				+ "PARAMETER[\"false_easting\",500000],"
				+ "PARAMETER[\"false_northing\",0],"
				+ "UNIT[\"US survey foot\",0.3048006096012192,"
				+ "AUTHORITY[\"EPSG\",\"9003\"]]," + "AXIS[\"X\",EAST],"
				+ "AXIS[\"Y\",NORTH]," + "AUTHORITY[\"EPSG\",\"2155\"]]";

		expected = "+proj=lcc +lat_1=-14.26666666666667 +lat_0=-14.26666666666667 +lon_0=170 +k_0=1 +x_0=152400.3048006096 +y_0=0 +ellps=clrk66 +towgs84=-115,118,426,0,0,0,0 +units=us-ft +no_defs";
		assertEquals(expected, ProjParser.paramsText(definition));
	}

	/**
	 * Test EPSG 2163
	 * 
	 * @throws IOException
	 *             upon error
	 */
	@Test
	public void test2163() throws IOException {

		// +proj=laea +lat_0=45 +lon_0=-100 +x_0=0 +y_0=0 +a=6370997 +b=6370997
		// +units=m +no_defs

		String definition = "PROJCRS[\"US National Atlas Equal Area\",BASEGEOGCRS[\"Unspecified datum based upon the Clarke 1866 Authalic Sphere\","
				+ "DATUM[\"Not specified (based on Clarke 1866 Authalic Sphere)\","
				+ "ELLIPSOID[\"Clarke 1866 Authalic Sphere\",6370997,0,LENGTHUNIT[\"metre\",1,ID[\"EPSG\",9001]],ID[\"EPSG\",7052]],"
				+ "ID[\"EPSG\",6052]],ID[\"EPSG\",4052]],"
				+ "CONVERSION[\"US National Atlas Equal Area\",METHOD[\"Lambert Azimuthal Equal Area (Spherical)\",ID[\"EPSG\",1027]],"
				+ "PARAMETER[\"Latitude of natural origin\",45,ANGLEUNIT[\"degree\",0.0174532925199433,ID[\"EPSG\",9102]]],"
				+ "PARAMETER[\"Longitude of natural origin\",-100,ANGLEUNIT[\"degree\",0.0174532925199433,ID[\"EPSG\",9102]]],"
				+ "PARAMETER[\"False easting\",0,LENGTHUNIT[\"metre\",1,ID[\"EPSG\",9001]]],"
				+ "PARAMETER[\"False northing\",0,LENGTHUNIT[\"metre\",1,ID[\"EPSG\",9001]]],"
				+ "ID[\"EPSG\",3899]],"
				+ "CS[Cartesian,2,ID[\"EPSG\",4499]],AXIS[\"Easting (X)\",east],AXIS[\"Northing (Y)\",north],"
				+ "LENGTHUNIT[\"metre\",1,ID[\"EPSG\",9001]],ID[\"EPSG\",2163]]";

		String expected = "+proj=laea +lat_0=45 +lon_0=-100 +x_0=0 +y_0=0 +a=6370997 +b=6370997 +units=m +no_defs";
		assertEquals(expected, ProjParser.paramsText(definition));

		definition = "PROJCS[\"US National Atlas Equal Area\","
				+ "GEOGCS[\"Unspecified datum based upon the Clarke 1866 Authalic Sphere\","
				+ "DATUM[\"Not_specified_based_on_Clarke_1866_Authalic_Sphere\","
				+ "SPHEROID[\"Clarke 1866 Authalic Sphere\",6370997,0,"
				+ "AUTHORITY[\"EPSG\",\"7052\"]],"
				+ "AUTHORITY[\"EPSG\",\"6052\"]]," + "PRIMEM[\"Greenwich\",0,"
				+ "AUTHORITY[\"EPSG\",\"8901\"]],"
				+ "UNIT[\"degree\",0.0174532925199433,"
				+ "AUTHORITY[\"EPSG\",\"9122\"]],"
				+ "AUTHORITY[\"EPSG\",\"4052\"]],"
				+ "PROJECTION[\"Lambert_Azimuthal_Equal_Area\"],"
				+ "PARAMETER[\"latitude_of_center\",45],"
				+ "PARAMETER[\"longitude_of_center\",-100],"
				+ "PARAMETER[\"false_easting\",0],"
				+ "PARAMETER[\"false_northing\",0]," + "UNIT[\"metre\",1,"
				+ "AUTHORITY[\"EPSG\",\"9001\"]]," + "AXIS[\"X\",EAST],"
				+ "AXIS[\"Y\",NORTH]," + "AUTHORITY[\"EPSG\",\"2163\"]]";

		expected = "+proj=laea +lat_0=45 +lon_0=-100 +x_0=0 +y_0=0 +a=6370997 +b=6370997 +units=m +no_defs";
		assertEquals(expected, ProjParser.paramsText(definition));

	}

	/**
	 * Test EPSG 2171
	 * 
	 * @throws IOException
	 *             upon error
	 */
	@Test
	public void test2171() throws IOException {

		// +proj=sterea +lat_0=50.625 +lon_0=21.08333333333333 +k=0.9998
		// +x_0=4637000 +y_0=5647000 +ellps=krass
		// +towgs84=33.4,-146.6,-76.3,-0.359,-0.053,0.844,-0.84 +units=m
		// +no_defs

		String definition = "PROJCRS[\"Pulkovo 1942(58) / Poland zone I\",BASEGEOGCRS[\"Pulkovo 1942(58)\","
				+ "DATUM[\"Pulkovo 1942(58)\","
				+ "ELLIPSOID[\"Krassowsky 1940\",6378245,298.3,LENGTHUNIT[\"metre\",1,ID[\"EPSG\",9001]],ID[\"EPSG\",7024]],"
				+ "ID[\"EPSG\",6179]],ID[\"EPSG\",4179]],"
				+ "CONVERSION[\"Poland zone I\",METHOD[\"Oblique Stereographic\",ID[\"EPSG\",9809]],"
				+ "PARAMETER[\"Latitude of natural origin\",50.625,ANGLEUNIT[\"degree\",0.0174532925199433,ID[\"EPSG\",9102]]],"
				+ "PARAMETER[\"Longitude of natural origin\",21.083333333,ANGLEUNIT[\"degree\",0.0174532925199433,ID[\"EPSG\",9102]]],"
				+ "PARAMETER[\"Scale factor at natural origin\",0.9998,SCALEUNIT[\"unity\",1,ID[\"EPSG\",9201]]],"
				+ "PARAMETER[\"False easting\",4637000,LENGTHUNIT[\"metre\",1,ID[\"EPSG\",9001]]],"
				+ "PARAMETER[\"False northing\",5647000,LENGTHUNIT[\"metre\",1,ID[\"EPSG\",9001]]],"
				+ "PARAMETER[\"X-axis translation\",33.4,LENGTHUNIT[\"metre\",1.0]],"
				+ "PARAMETER[\"Y-axis translation\",-146.6,LENGTHUNIT[\"metre\",1.0]],"
				+ "PARAMETER[\"Z-axis translation\",-76.3,LENGTHUNIT[\"metre\",1.0]],"
				+ "PARAMETER[\"X-axis rotation\",-0.359,LENGTHUNIT[\"metre\",1.0]],"
				+ "PARAMETER[\"Y-axis rotation\",-0.053,LENGTHUNIT[\"metre\",1.0]],"
				+ "PARAMETER[\"Z-axis rotation\",0.844,LENGTHUNIT[\"metre\",1.0]],"
				+ "PARAMETER[\"Scale difference\",-0.84,SCALEUNIT[\"parts per million\",1E-06]],"
				+ "ID[\"EPSG\",18281]],"
				+ "CS[Cartesian,2,ID[\"EPSG\",4530]],AXIS[\"Northing (X)\",north],AXIS[\"Easting (Y)\",east],"
				+ "LENGTHUNIT[\"metre\",1,ID[\"EPSG\",9001]],ID[\"EPSG\",2171]]";

		String expected = "+proj=sterea +lat_0=50.625 +lon_0=21.083333333 +k_0=0.9998 +x_0=4637000 +y_0=5647000 +ellps=krass +towgs84=33.4,-146.6,-76.3,-0.359,-0.053,0.844,-0.84 +units=m +no_defs";
		assertEquals(expected, ProjParser.paramsText(definition));

		definition = "PROJCS[\"Pulkovo 1942(58) / Poland zone I (deprecated)\","
				+ "GEOGCS[\"Pulkovo 1942(58)\"," + "DATUM[\"Pulkovo_1942_58\","
				+ "SPHEROID[\"Krassowsky 1940\",6378245,298.3,"
				+ "AUTHORITY[\"EPSG\",\"7024\"]],"
				+ "TOWGS84[33.4,-146.6,-76.3,-0.359,-0.053,0.844,-0.84],"
				+ "AUTHORITY[\"EPSG\",\"6179\"]]," + "PRIMEM[\"Greenwich\",0,"
				+ "AUTHORITY[\"EPSG\",\"8901\"]],"
				+ "UNIT[\"degree\",0.0174532925199433,"
				+ "AUTHORITY[\"EPSG\",\"9122\"]],"
				+ "AUTHORITY[\"EPSG\",\"4179\"]],"
				+ "PROJECTION[\"Oblique_Stereographic\"],"
				+ "PARAMETER[\"latitude_of_origin\",50.625],"
				+ "PARAMETER[\"central_meridian\",21.08333333333333],"
				+ "PARAMETER[\"scale_factor\",0.9998],"
				+ "PARAMETER[\"false_easting\",4637000],"
				+ "PARAMETER[\"false_northing\",5647000]," + "UNIT[\"metre\",1,"
				+ "AUTHORITY[\"EPSG\",\"9001\"]],"
				+ "AUTHORITY[\"EPSG\",\"2171\"]]";

		expected = "+proj=sterea +lat_0=50.625 +lon_0=21.08333333333333 +k_0=0.9998 +x_0=4637000 +y_0=5647000 +ellps=krass +towgs84=33.4,-146.6,-76.3,-0.359,-0.053,0.844,-0.84 +units=m +no_defs";
		assertEquals(expected, ProjParser.paramsText(definition));

	}

	/**
	 * Test EPSG 2200
	 * 
	 * @throws IOException
	 *             upon error
	 */
	@Test
	public void test2200() throws IOException {

		// +proj=sterea +lat_0=46.5 +lon_0=-66.5 +k=0.999912 +x_0=300000
		// +y_0=800000 +a=6378135 +b=6356750.304921594 +units=m +no_defs

		String definition = "PROJCRS[\"ATS77 / New Brunswick Stereographic (ATS77)\",BASEGEOGCRS[\"ATS77\","
				+ "DATUM[\"Average Terrestrial System 1977\","
				+ "ELLIPSOID[\"Average Terrestrial System 1977\",6378135,298.257,LENGTHUNIT[\"metre\",1,ID[\"EPSG\",9001]],ID[\"EPSG\",7041]],"
				+ "ID[\"EPSG\",6122]],ID[\"EPSG\",4122]],"
				+ "CONVERSION[\"New Brunswick Stereographic (ATS77)\",METHOD[\"Oblique Stereographic\",ID[\"EPSG\",9809]],"
				+ "PARAMETER[\"Latitude of natural origin\",46.5,ANGLEUNIT[\"degree\",0.0174532925199433,ID[\"EPSG\",9102]]],"
				+ "PARAMETER[\"Longitude of natural origin\",-66.5,ANGLEUNIT[\"degree\",0.0174532925199433,ID[\"EPSG\",9102]]],"
				+ "PARAMETER[\"Scale factor at natural origin\",0.999912,SCALEUNIT[\"unity\",1,ID[\"EPSG\",9201]]],"
				+ "PARAMETER[\"False easting\",300000,LENGTHUNIT[\"metre\",1,ID[\"EPSG\",9001]]],"
				+ "PARAMETER[\"False northing\",800000,LENGTHUNIT[\"metre\",1,ID[\"EPSG\",9001]]],"
				+ "ID[\"EPSG\",19945]],"
				+ "CS[Cartesian,2,ID[\"EPSG\",4500]],AXIS[\"Northing (N)\",north],AXIS[\"Easting (E)\",east],"
				+ "LENGTHUNIT[\"metre\",1,ID[\"EPSG\",9001]],ID[\"EPSG\",2200]]";

		String expected = "+proj=sterea +lat_0=46.5 +lon_0=-66.5 +k_0=0.999912 +x_0=300000 +y_0=800000 +a=6378135 +b=6356750.304921594 +units=m +no_defs";
		assertEquals(expected, ProjParser.paramsText(definition));

		definition = "PROJCS[\"ATS77 / New Brunswick Stereographic (ATS77)\","
				+ "GEOGCS[\"ATS77\","
				+ "DATUM[\"Average_Terrestrial_System_1977\","
				+ "SPHEROID[\"Average Terrestrial System 1977\",6378135,298.257,"
				+ "AUTHORITY[\"EPSG\",\"7041\"]],"
				+ "AUTHORITY[\"EPSG\",\"6122\"]]," + "PRIMEM[\"Greenwich\",0,"
				+ "AUTHORITY[\"EPSG\",\"8901\"]],"
				+ "UNIT[\"degree\",0.0174532925199433,"
				+ "AUTHORITY[\"EPSG\",\"9122\"]],"
				+ "AUTHORITY[\"EPSG\",\"4122\"]],"
				+ "PROJECTION[\"Oblique_Stereographic\"],"
				+ "PARAMETER[\"latitude_of_origin\",46.5],"
				+ "PARAMETER[\"central_meridian\",-66.5],"
				+ "PARAMETER[\"scale_factor\",0.999912],"
				+ "PARAMETER[\"false_easting\",300000],"
				+ "PARAMETER[\"false_northing\",800000]," + "UNIT[\"metre\",1,"
				+ "AUTHORITY[\"EPSG\",\"9001\"]],"
				+ "AUTHORITY[\"EPSG\",\"2200\"]]";

		expected = "+proj=sterea +lat_0=46.5 +lon_0=-66.5 +k_0=0.999912 +x_0=300000 +y_0=800000 +a=6378135 +b=6356750.304921594 +units=m +no_defs";
		assertEquals(expected, ProjParser.paramsText(definition));

	}

	/**
	 * Test EPSG 2251
	 * 
	 * @throws IOException
	 *             upon error
	 */
	@Test
	public void test2251() throws IOException {

		// +proj=lcc +lat_1=47.08333333333334 +lat_2=45.48333333333333
		// +lat_0=44.78333333333333 +lon_0=-87 +x_0=7999999.999968001 +y_0=0
		// +datum=NAD83 +units=ft +no_defs

		String definition = "PROJCRS[\"NAD83 / Michigan North (ft)\",BASEGEOGCRS[\"NAD83\","
				+ "DATUM[\"North American Datum 1983\","
				+ "ELLIPSOID[\"GRS 1980\",6378137,298.2572221,LENGTHUNIT[\"metre\",1,ID[\"EPSG\",9001]],ID[\"EPSG\",7019]],"
				+ "ID[\"EPSG\",6269]],ID[\"EPSG\",4269]],"
				+ "CONVERSION[\"SPCS83 Michigan North zone (International feet)\",METHOD[\"Lambert Conic Conformal (2SP)\",ID[\"EPSG\",9802]],"
				+ "PARAMETER[\"Latitude of false origin\",44.783333333,ANGLEUNIT[\"degree\",0.0174532925199433,ID[\"EPSG\",9102]]],"
				+ "PARAMETER[\"Longitude of false origin\",-87,ANGLEUNIT[\"degree\",0.0174532925199433,ID[\"EPSG\",9102]]],"
				+ "PARAMETER[\"Latitude of 1st standard parallel\",47.083333333,ANGLEUNIT[\"degree\",0.0174532925199433,ID[\"EPSG\",9102]]],"
				+ "PARAMETER[\"Latitude of 2nd standard parallel\",45.483333333,ANGLEUNIT[\"degree\",0.0174532925199433,ID[\"EPSG\",9102]]],"
				+ "PARAMETER[\"Easting at false origin\",26246719.16,LENGTHUNIT[\"foot\",0.3048,ID[\"EPSG\",9002]]],"
				+ "PARAMETER[\"Northing at false origin\",0,LENGTHUNIT[\"foot\",0.3048,ID[\"EPSG\",9002]]],"
				+ "ID[\"EPSG\",15333]],"
				+ "CS[Cartesian,2,ID[\"EPSG\",4495]],AXIS[\"Easting (X)\",east],AXIS[\"Northing (Y)\",north],"
				+ "LENGTHUNIT[\"foot\",0.3048,ID[\"EPSG\",9002]],ID[\"EPSG\",2251]]";

		String expected = "+proj=lcc +lat_1=47.083333333 +lat_2=45.483333333 +lat_0=44.783333333 +lon_0=-87 +x_0=7999999.999968001 +y_0=0 +datum=NAD83 +units=ft +no_defs";
		assertEquals(expected, ProjParser.paramsText(definition));

		definition = "PROJCS[\"NAD83 / Michigan North (ft)\","
				+ "GEOGCS[\"NAD83\"," + "DATUM[\"North_American_Datum_1983\","
				+ "SPHEROID[\"GRS 1980\",6378137,298.257222101,"
				+ "AUTHORITY[\"EPSG\",\"7019\"]]," + "TOWGS84[0,0,0,0,0,0,0],"
				+ "AUTHORITY[\"EPSG\",\"6269\"]]," + "PRIMEM[\"Greenwich\",0,"
				+ "AUTHORITY[\"EPSG\",\"8901\"]],"
				+ "UNIT[\"degree\",0.0174532925199433,"
				+ "AUTHORITY[\"EPSG\",\"9122\"]],"
				+ "AUTHORITY[\"EPSG\",\"4269\"]],"
				+ "PROJECTION[\"Lambert_Conformal_Conic_2SP\"],"
				+ "PARAMETER[\"standard_parallel_1\",47.08333333333334],"
				+ "PARAMETER[\"standard_parallel_2\",45.48333333333333],"
				+ "PARAMETER[\"latitude_of_origin\",44.78333333333333],"
				+ "PARAMETER[\"central_meridian\",-87],"
				+ "PARAMETER[\"false_easting\",26246719.16],"
				+ "PARAMETER[\"false_northing\",0]," + "UNIT[\"foot\",0.3048,"
				+ "AUTHORITY[\"EPSG\",\"9002\"]]," + "AXIS[\"X\",EAST],"
				+ "AXIS[\"Y\",NORTH]," + "AUTHORITY[\"EPSG\",\"2251\"]]";

		expected = "+proj=lcc +lat_1=47.08333333333334 +lat_2=45.48333333333333 +lat_0=44.78333333333333 +lon_0=-87 +x_0=7999999.999968001 +y_0=0 +datum=NAD83 +towgs84=0,0,0,0,0,0,0 +units=ft +no_defs";
		assertEquals(expected, ProjParser.paramsText(definition));

	}

	/**
	 * Test EPSG 3035
	 * 
	 * @throws IOException
	 *             upon error
	 */
	@Test
	public void test3035() throws IOException {

		// +proj=laea +lat_0=52 +lon_0=10 +x_0=4321000 +y_0=3210000 +ellps=GRS80
		// +towgs84=0,0,0,0,0,0,0 +units=m +no_defs

		String definition = "PROJCRS[\"ETRS89-extended / LAEA Europe\",BASEGEOGCRS[\"ETRS89\","
				+ "ENSEMBLE[\"European Terrestrial Reference System 1989 ensemble\","
				+ "MEMBER[\"European Terrestrial Reference Frame 1989\",ID[\"EPSG\",1178]],"
				+ "MEMBER[\"European Terrestrial Reference Frame 1990\",ID[\"EPSG\",1179]],"
				+ "MEMBER[\"European Terrestrial Reference Frame 1991\",ID[\"EPSG\",1180]],"
				+ "MEMBER[\"European Terrestrial Reference Frame 1992\",ID[\"EPSG\",1181]],"
				+ "MEMBER[\"European Terrestrial Reference Frame 1993\",ID[\"EPSG\",1182]],"
				+ "MEMBER[\"European Terrestrial Reference Frame 1994\",ID[\"EPSG\",1183]],"
				+ "MEMBER[\"European Terrestrial Reference Frame 1996\",ID[\"EPSG\",1184]],"
				+ "MEMBER[\"European Terrestrial Reference Frame 1997\",ID[\"EPSG\",1185]],"
				+ "MEMBER[\"European Terrestrial Reference Frame 2000\",ID[\"EPSG\",1186]],"
				+ "MEMBER[\"European Terrestrial Reference Frame 2005\",ID[\"EPSG\",1204]],"
				+ "MEMBER[\"European Terrestrial Reference Frame 2014\",ID[\"EPSG\",1206]],"
				+ "ELLIPSOID[\"GRS 1980\",6378137,298.257222101,ID[\"EPSG\",7019]],"
				+ "ENSEMBLEACCURACY[0.1],ID[\"EPSG\",6258]],ID[\"EPSG\",4258]],"
				+ "CONVERSION[\"Europe Equal Area 2001\",METHOD[\"Lambert Azimuthal Equal Area\",ID[\"EPSG\",9820]],"
				+ "PARAMETER[\"Latitude of natural origin\",52,ANGLEUNIT[\"degree\",0.0174532925199433,ID[\"EPSG\",9102]]],"
				+ "PARAMETER[\"Longitude of natural origin\",10,ANGLEUNIT[\"degree\",0.0174532925199433,ID[\"EPSG\",9102]]],"
				+ "PARAMETER[\"False easting\",4321000,LENGTHUNIT[\"metre\",1,ID[\"EPSG\",9001]]],"
				+ "PARAMETER[\"False northing\",3210000,LENGTHUNIT[\"metre\",1,ID[\"EPSG\",9001]]],"
				+ "ID[\"EPSG\",19986]],CS[Cartesian,2,ID[\"EPSG\",4532]],"
				+ "AXIS[\"Northing (Y)\",north],AXIS[\"Easting (X)\",east],"
				+ "LENGTHUNIT[\"metre\",1,ID[\"EPSG\",9001]],ID[\"EPSG\",3035]]";

		String expected = "+proj=laea +lat_0=52 +lon_0=10 +x_0=4321000 +y_0=3210000 +ellps=GRS80 +units=m +no_defs";
		assertEquals(expected, ProjParser.paramsText(definition));

		definition = "PROJCS[\"ETRS89 / ETRS-LAEA\",GEOGCS[\"ETRS89\","
				+ "DATUM[\"European_Terrestrial_Reference_System_1989\","
				+ "SPHEROID[\"GRS 1980\",6378137,298.257222101,"
				+ "AUTHORITY[\"EPSG\",\"7019\"]],"
				+ "AUTHORITY[\"EPSG\",\"6258\"]],"
				+ "PRIMEM[\"Greenwich\",0,AUTHORITY[\"EPSG\",\"8901\"]],"
				+ "UNIT[\"degree\",0.01745329251994328,"
				+ "AUTHORITY[\"EPSG\",\"9122\"]],"
				+ "AUTHORITY[\"EPSG\",\"4258\"]],"
				+ "UNIT[\"metre\",1,AUTHORITY[\"EPSG\",\"9001\"]],"
				+ "PROJECTION[\"Lambert_Azimuthal_Equal_Area\"],"
				+ "PARAMETER[\"latitude_of_center\",52],"
				+ "PARAMETER[\"longitude_of_center\",10],"
				+ "PARAMETER[\"false_easting\",4321000],"
				+ "PARAMETER[\"false_northing\",3210000],"
				+ "AUTHORITY[\"EPSG\",\"3035\"],"
				+ "AXIS[\"X\",EAST],AXIS[\"Y\",NORTH]]";

		expected = "+proj=laea +lat_0=52 +lon_0=10 +x_0=4321000 +y_0=3210000 +ellps=GRS80 +units=m +no_defs";
		assertEquals(expected, ProjParser.paramsText(definition));

		definition = "PROJCS[\"ETRS89 / LAEA Europe\",GEOGCRS[\"ETRS89\","
				+ "DATUM[\"European_Terrestrial_Reference_System_1989\","
				+ "SPHEROID[\"GRS 1980\",6378137,298.257222101,"
				+ "ID[\"EPSG\",\"7019\"]],"
				+ "ABRIDGEDTRANSFORMATION[0,0,0,0,0,0,0],"
				+ "ID[\"EPSG\",\"6258\"]],"
				+ "PRIMEM[\"Greenwich\",0,ID[\"EPSG\",\"8901\"]],"
				+ "UNIT[\"degree\",0.0174532925199433,"
				+ "ID[\"EPSG\",\"9122\"]],ID[\"EPSG\",\"4258\"]],"
				+ "PROJECTION[\"Lambert_Azimuthal_Equal_Area\"],"
				+ "PARAMETER[\"latitude_of_center\",52],"
				+ "PARAMETER[\"longitude_of_center\",10],"
				+ "PARAMETER[\"false_easting\",4321000],"
				+ "PARAMETER[\"false_northing\",3210000],"
				+ "UNIT[\"metre\",1,ID[\"EPSG\",\"9001\"]],"
				+ "ID[\"EPSG\",\"3035\"]]";

		expected = "+proj=laea +lat_0=52 +lon_0=10 +x_0=4321000 +y_0=3210000 +ellps=GRS80 +towgs84=0,0,0,0,0,0,0 +units=m +no_defs";
		assertEquals(expected, ProjParser.paramsText(definition));

	}

	/**
	 * Test EPSG 3068
	 * 
	 * @throws IOException
	 *             upon error
	 */
	@Test
	public void test3068() throws IOException {

		// +proj=cass +lat_0=52.41864827777778 +lon_0=13.62720366666667
		// +x_0=40000 +y_0=10000 +datum=potsdam +units=m +no_defs

		String definition = "PROJCRS[\"DHDN / Soldner Berlin\",BASEGEOGCRS[\"DHDN\","
				+ "DATUM[\"Deutsches Hauptdreiecksnetz\","
				+ "ELLIPSOID[\"Bessel 1841\",6377397.155,299.1528128,LENGTHUNIT[\"metre\",1,ID[\"EPSG\",9001]],ID[\"EPSG\",7004]],"
				+ "ID[\"EPSG\",6314]],ID[\"EPSG\",4314]],"
				+ "CONVERSION[\"Soldner Berlin\",METHOD[\"Cassini-Soldner\",ID[\"EPSG\",9806]],"
				+ "PARAMETER[\"Latitude of natural origin\",52.418648278,ANGLEUNIT[\"degree\",0.0174532925199433,ID[\"EPSG\",9102]]],"
				+ "PARAMETER[\"Longitude of natural origin\",13.627203667,ANGLEUNIT[\"degree\",0.0174532925199433,ID[\"EPSG\",9102]]],"
				+ "PARAMETER[\"False easting\",40000,LENGTHUNIT[\"metre\",1,ID[\"EPSG\",9001]]],"
				+ "PARAMETER[\"False northing\",10000,LENGTHUNIT[\"metre\",1,ID[\"EPSG\",9001]]],"
				+ "ID[\"EPSG\",19996]],"
				+ "CS[Cartesian,2,ID[\"EPSG\",4531]],AXIS[\"Northing (x)\",north],AXIS[\"Easting (y)\",east],"
				+ "LENGTHUNIT[\"metre\",1,ID[\"EPSG\",9001]],ID[\"EPSG\",3068]]";

		String expected = "+proj=cass +lat_0=52.418648278 +lon_0=13.627203667 +x_0=40000 +y_0=10000 +datum=potsdam +units=m +no_defs";
		assertEquals(expected, ProjParser.paramsText(definition));

		definition = "PROJCS[\"DHDN / Soldner Berlin\"," + "GEOGCS[\"DHDN\","
				+ "DATUM[\"Deutsches_Hauptdreiecksnetz\","
				+ "SPHEROID[\"Bessel 1841\",6377397.155,299.1528128,"
				+ "AUTHORITY[\"EPSG\",\"7004\"]],"
				+ "TOWGS84[598.1,73.7,418.2,0.202,0.045,-2.455,6.7],"
				+ "AUTHORITY[\"EPSG\",\"6314\"]]," + "PRIMEM[\"Greenwich\",0,"
				+ "AUTHORITY[\"EPSG\",\"8901\"]],"
				+ "UNIT[\"degree\",0.0174532925199433,"
				+ "AUTHORITY[\"EPSG\",\"9122\"]],"
				+ "AUTHORITY[\"EPSG\",\"4314\"]],"
				+ "PROJECTION[\"Cassini_Soldner\"],"
				+ "PARAMETER[\"latitude_of_origin\",52.41864827777778],"
				+ "PARAMETER[\"central_meridian\",13.62720366666667],"
				+ "PARAMETER[\"false_easting\",40000],"
				+ "PARAMETER[\"false_northing\",10000]," + "UNIT[\"metre\",1,"
				+ "AUTHORITY[\"EPSG\",\"9001\"]],"
				+ "AUTHORITY[\"EPSG\",\"3068\"]]";

		expected = "+proj=cass +lat_0=52.41864827777778 +lon_0=13.62720366666667 +x_0=40000 +y_0=10000 +datum=potsdam +towgs84=598.1,73.7,418.2,0.202,0.045,-2.455,6.7 +units=m +no_defs";
		assertEquals(expected, ProjParser.paramsText(definition));

	}

	/**
	 * Test EPSG 3083
	 * 
	 * @throws IOException
	 *             upon error
	 */
	@Test
	public void test3083() throws IOException {

		// +proj=aea +lat_1=27.5 +lat_2=35 +lat_0=18 +lon_0=-100 +x_0=1500000
		// +y_0=6000000 +datum=NAD83 +units=m +no_defs

		String definition = "PROJCRS[\"NAD83 / Texas Centric Albers Equal Area\",BASEGEOGCRS[\"NAD83\","
				+ "DATUM[\"North American Datum 1983\","
				+ "ELLIPSOID[\"GRS 1980\",6378137,298.2572221,LENGTHUNIT[\"metre\",1,ID[\"EPSG\",9001]],ID[\"EPSG\",7019]],"
				+ "ID[\"EPSG\",6269]],ID[\"EPSG\",4269]],"
				+ "CONVERSION[\"Texas Centric Albers Equal Area\",METHOD[\"Albers Equal Area\",ID[\"EPSG\",9822]],"
				+ "PARAMETER[\"Latitude of false origin\",18,ANGLEUNIT[\"degree\",0.0174532925199433,ID[\"EPSG\",9102]]],"
				+ "PARAMETER[\"Longitude of false origin\",-100,ANGLEUNIT[\"degree\",0.0174532925199433,ID[\"EPSG\",9102]]],"
				+ "PARAMETER[\"Latitude of 1st standard parallel\",27.5,ANGLEUNIT[\"degree\",0.0174532925199433,ID[\"EPSG\",9102]]],"
				+ "PARAMETER[\"Latitude of 2nd standard parallel\",35,ANGLEUNIT[\"degree\",0.0174532925199433,ID[\"EPSG\",9102]]],"
				+ "PARAMETER[\"Easting at false origin\",1500000,LENGTHUNIT[\"metre\",1,ID[\"EPSG\",9001]]],"
				+ "PARAMETER[\"Northing at false origin\",6000000,LENGTHUNIT[\"metre\",1,ID[\"EPSG\",9001]]],"
				+ "ID[\"EPSG\",14254]],"
				+ "CS[Cartesian,2,ID[\"EPSG\",4499]],AXIS[\"Easting (X)\",east],AXIS[\"Northing (Y)\",north],"
				+ "LENGTHUNIT[\"metre\",1,ID[\"EPSG\",9001]],ID[\"EPSG\",3083]]";

		String expected = "+proj=aea +lat_1=27.5 +lat_2=35 +lat_0=18 +lon_0=-100 +x_0=1500000 +y_0=6000000 +datum=NAD83 +units=m +no_defs";
		assertEquals(expected, ProjParser.paramsText(definition));

		definition = "PROJCS[\"NAD83 / Texas Centric Albers Equal Area\","
				+ "GEOGCS[\"NAD83\"," + "DATUM[\"North_American_Datum_1983\","
				+ "SPHEROID[\"GRS 1980\",6378137,298.257222101,"
				+ "AUTHORITY[\"EPSG\",\"7019\"]]," + "TOWGS84[0,0,0,0,0,0,0],"
				+ "AUTHORITY[\"EPSG\",\"6269\"]]," + "PRIMEM[\"Greenwich\",0,"
				+ "AUTHORITY[\"EPSG\",\"8901\"]],"
				+ "UNIT[\"degree\",0.0174532925199433,"
				+ "AUTHORITY[\"EPSG\",\"9122\"]],"
				+ "AUTHORITY[\"EPSG\",\"4269\"]],"
				+ "PROJECTION[\"Albers_Conic_Equal_Area\"],"
				+ "PARAMETER[\"standard_parallel_1\",27.5],"
				+ "PARAMETER[\"standard_parallel_2\",35],"
				+ "PARAMETER[\"latitude_of_center\",18],"
				+ "PARAMETER[\"longitude_of_center\",-100],"
				+ "PARAMETER[\"false_easting\",1500000],"
				+ "PARAMETER[\"false_northing\",6000000]," + "UNIT[\"metre\",1,"
				+ "AUTHORITY[\"EPSG\",\"9001\"]]," + "AXIS[\"X\",EAST],"
				+ "AXIS[\"Y\",NORTH]," + "AUTHORITY[\"EPSG\",\"3083\"]]";

		expected = "+proj=aea +lat_1=27.5 +lat_2=35 +lat_0=18 +lon_0=-100 +x_0=1500000 +y_0=6000000 +datum=NAD83 +towgs84=0,0,0,0,0,0,0 +units=m +no_defs";
		assertEquals(expected, ProjParser.paramsText(definition));

	}

	/**
	 * Test EPSG 3375
	 * 
	 * @throws IOException
	 *             upon error
	 */
	@Test
	public void test3375() throws IOException {

		// +proj=omerc +lat_0=4 +lonc=102.25 +alpha=323.0257964666666 +k=0.99984
		// +x_0=804671 +y_0=0 +no_uoff +gamma=323.1301023611111 +ellps=GRS80
		// +units=m +no_defs

		String definition = "PROJCRS[\"GDM2000 / Peninsula RSO\",BASEGEOGCRS[\"GDM2000\","
				+ "DATUM[\"Geodetic Datum of Malaysia 2000\","
				+ "ELLIPSOID[\"GRS 1980\",6378137,298.2572221,LENGTHUNIT[\"metre\",1,ID[\"EPSG\",9001]],"
				+ "ID[\"EPSG\",7019]],ID[\"EPSG\",6742]],ID[\"EPSG\",4742]],"
				+ "CONVERSION[\"Peninsular RSO\",METHOD[\"Hotine Oblique Mercator (variant A)\",ID[\"EPSG\",9812]],"
				+ "PARAMETER[\"Latitude of projection centre\",4,ANGLEUNIT[\"degree\",0.0174532925199433,ID[\"EPSG\",9102]]],"
				+ "PARAMETER[\"Longitude of projection centre\",102.25,ANGLEUNIT[\"degree\",0.0174532925199433,ID[\"EPSG\",9102]]],"
				+ "PARAMETER[\"Azimuth of initial line\",323.0257964666666,ANGLEUNIT[\"degree\",0.0174532925199433,ID[\"EPSG\",9102]]],"
				+ "PARAMETER[\"Angle from Rectified to Skew Grid\",323.1301023611111,ANGLEUNIT[\"degree\",0.0174532925199433,ID[\"EPSG\",9102]]],"
				+ "PARAMETER[\"Scale factor on initial line\",0.99984,SCALEUNIT[\"unity\",1,ID[\"EPSG\",9201]]],"
				+ "PARAMETER[\"False easting\",804671,LENGTHUNIT[\"metre\",1,ID[\"EPSG\",9001]]],"
				+ "PARAMETER[\"False northing\",0,LENGTHUNIT[\"metre\",1,ID[\"EPSG\",9001]]],"
				+ "ID[\"EPSG\",19895]],"
				+ "CS[Cartesian,2,ID[\"EPSG\",4400]],AXIS[\"Easting (E)\",east],AXIS[\"Northing (N)\",north],"
				+ "LENGTHUNIT[\"metre\",1,ID[\"EPSG\",9001]],"
				+ "ID[\"EPSG\",3375]]";

		String expected = "+proj=omerc +lat_0=4 +lonc=102.25 +alpha=323.0257964666666 +k_0=0.99984 +x_0=804671 +y_0=0 +no_uoff +gamma=323.1301023611111 +ellps=GRS80 +units=m +no_defs";
		assertEquals(expected, ProjParser.paramsText(definition));

		definition = "PROJCS[\"GDM2000 / Peninsula RSO\",GEOGCS[\"GDM2000\","
				+ "DATUM[\"Geodetic_Datum_of_Malaysia_2000\","
				+ "SPHEROID[\"GRS 1980\",6378137,298.257222101,AUTHORITY[\"EPSG\",\"7019\"]],"
				+ "AUTHORITY[\"EPSG\",\"6742\"]],PRIMEM[\"Greenwich\",0,AUTHORITY[\"EPSG\",\"8901\"]],"
				+ "UNIT[\"degree\",0.01745329251994328,AUTHORITY[\"EPSG\",\"9122\"]],"
				+ "AUTHORITY[\"EPSG\",\"4742\"]],UNIT[\"metre\",1,AUTHORITY[\"EPSG\",\"9001\"]],"
				+ "PROJECTION[\"Hotine_Oblique_Mercator\"],"
				+ "PARAMETER[\"latitude_of_center\",4],"
				+ "PARAMETER[\"longitude_of_center\",102.25],"
				+ "PARAMETER[\"azimuth\",323.0257964666666],"
				+ "PARAMETER[\"rectified_grid_angle\",323.1301023611111],"
				+ "PARAMETER[\"scale_factor\",0.99984],"
				+ "PARAMETER[\"false_easting\",804671],"
				+ "PARAMETER[\"false_northing\",0],"
				+ "AUTHORITY[\"EPSG\",\"3375\"],AXIS[\"Easting\",EAST],AXIS[\"Northing\",NORTH]]";

		expected = "+proj=omerc +lat_0=4 +lonc=102.25 +alpha=323.0257964666666 +k_0=0.99984 +x_0=804671 +y_0=0 +no_uoff +gamma=323.1301023611111 +ellps=GRS80 +units=m +no_defs";
		assertEquals(expected, ProjParser.paramsText(definition));

	}

	/**
	 * Test EPSG 3376
	 * 
	 * @throws IOException
	 *             upon error
	 */
	@Test
	public void test3376() throws IOException {

		// +proj=omerc +lat_0=4 +lonc=115 +alpha=53.31580995 +k=0.99984 +x_0=0
		// +y_0=0 +no_uoff +gamma=53.13010236111111 +ellps=GRS80 +units=m
		// +no_defs

		String definition = "PROJCRS[\"GDM2000 / East Malaysia BRSO\",BASEGEOGCRS[\"GDM2000\","
				+ "DATUM[\"Geodetic Datum of Malaysia 2000\","
				+ "ELLIPSOID[\"GRS 1980\",6378137,298.2572221,LENGTHUNIT[\"metre\",1,"
				+ "ID[\"EPSG\",9001]],ID[\"EPSG\",7019]],ID[\"EPSG\",6742]],ID[\"EPSG\",4742]],"
				+ "CONVERSION[\"Borneo RSO\",METHOD[\"Hotine Oblique Mercator (variant A)\",ID[\"EPSG\",9812]],"
				+ "PARAMETER[\"Latitude of projection centre\",4,ANGLEUNIT[\"degree\",0.0174532925199433,ID[\"EPSG\",9102]]],"
				+ "PARAMETER[\"Longitude of projection centre\",115,ANGLEUNIT[\"degree\",0.0174532925199433,ID[\"EPSG\",9102]]],"
				+ "PARAMETER[\"Azimuth of initial line\",53.31580995,ANGLEUNIT[\"degree\",0.0174532925199433,ID[\"EPSG\",9102]]],"
				+ "PARAMETER[\"Angle from Rectified to Skew Grid\",53.130102361,ANGLEUNIT[\"degree\",0.0174532925199433,ID[\"EPSG\",9102]]],"
				+ "PARAMETER[\"Scale factor on initial line\",0.99984,SCALEUNIT[\"unity\",1,ID[\"EPSG\",9201]]],"
				+ "PARAMETER[\"False easting\",0,LENGTHUNIT[\"metre\",1,ID[\"EPSG\",9001]]],"
				+ "PARAMETER[\"False northing\",0,LENGTHUNIT[\"metre\",1,ID[\"EPSG\",9001]]],"
				+ "ID[\"EPSG\",19894]],"
				+ "CS[Cartesian,2,ID[\"EPSG\",4400]],AXIS[\"Easting (E)\",east],AXIS[\"Northing (N)\",north],"
				+ "LENGTHUNIT[\"metre\",1,ID[\"EPSG\",9001]],ID[\"EPSG\",3376]]";

		String expected = "+proj=omerc +lat_0=4 +lonc=115 +alpha=53.31580995 +k_0=0.99984 +x_0=0 +y_0=0 +no_uoff +gamma=53.130102361 +ellps=GRS80 +units=m +no_defs";
		assertEquals(expected, ProjParser.paramsText(definition));

		definition = "PROJCS[\"GDM2000 / East Malaysia BRSO\",GEOGCS[\"GDM2000\","
				+ "DATUM[\"Geodetic_Datum_of_Malaysia_2000\","
				+ "SPHEROID[\"GRS 1980\",6378137,298.257222101,AUTHORITY[\"EPSG\",\"7019\"]],AUTHORITY[\"EPSG\",\"6742\"]],"
				+ "PRIMEM[\"Greenwich\",0,AUTHORITY[\"EPSG\",\"8901\"]],"
				+ "UNIT[\"degree\",0.01745329251994328,AUTHORITY[\"EPSG\",\"9122\"]],"
				+ "AUTHORITY[\"EPSG\",\"4742\"]],UNIT[\"metre\",1,AUTHORITY[\"EPSG\",\"9001\"]],"
				+ "PROJECTION[\"Hotine_Oblique_Mercator\"],"
				+ "PARAMETER[\"latitude_of_center\",4],"
				+ "PARAMETER[\"longitude_of_center\",115],"
				+ "PARAMETER[\"azimuth\",53.31580995],"
				+ "PARAMETER[\"rectified_grid_angle\",53.13010236111111],"
				+ "PARAMETER[\"scale_factor\",0.99984],"
				+ "PARAMETER[\"false_easting\",0],"
				+ "PARAMETER[\"false_northing\",0],"
				+ "AUTHORITY[\"EPSG\",\"3376\"],AXIS[\"Easting\",EAST],AXIS[\"Northing\",NORTH]]";

		expected = "+proj=omerc +lat_0=4 +lonc=115 +alpha=53.31580995 +k_0=0.99984 +x_0=0 +y_0=0 +no_uoff +gamma=53.13010236111111 +ellps=GRS80 +units=m +no_defs";
		assertEquals(expected, ProjParser.paramsText(definition));

	}

	/**
	 * Test EPSG 3395
	 * 
	 * @throws IOException
	 *             upon error
	 */
	@Test
	public void test3395() throws IOException {

		// +proj=merc +lon_0=0 +k=1 +x_0=0 +y_0=0 +datum=WGS84 +units=m +no_defs

		String definition = "PROJCRS[\"WGS 84 / World Mercator\",BASEGEOGCRS[\"WGS 84\","
				+ "ENSEMBLE[\"World Geodetic System 1984 ensemble\","
				+ "MEMBER[\"World Geodetic System 1984 (Transit)\",ID[\"EPSG\",1166]],"
				+ "MEMBER[\"World Geodetic System 1984 (G730)\",ID[\"EPSG\",1152]],"
				+ "MEMBER[\"World Geodetic System 1984 (G873)\",ID[\"EPSG\",1153]],"
				+ "MEMBER[\"World Geodetic System 1984 (G1150)\",ID[\"EPSG\",1154]],"
				+ "MEMBER[\"World Geodetic System 1984 (G1674)\",ID[\"EPSG\",1155]],"
				+ "MEMBER[\"World Geodetic System 1984 (G1762)\",ID[\"EPSG\",1156]],"
				+ "ELLIPSOID[\"WGS 84\",6378137,298.257223563,ID[\"EPSG\",7030]],"
				+ "ENSEMBLEACCURACY[2],ID[\"EPSG\",6326]],ID[\"EPSG\",4326]],"
				+ "CONVERSION[\"World Mercator\",METHOD[\"Mercator (variant A)\",ID[\"EPSG\",9804]],"
				+ "PARAMETER[\"Latitude of natural origin\",0,ANGLEUNIT[\"degree\",0.0174532925199433,ID[\"EPSG\",9102]]],"
				+ "PARAMETER[\"Longitude of natural origin\",0,ANGLEUNIT[\"degree\",0.0174532925199433,ID[\"EPSG\",9102]]],"
				+ "PARAMETER[\"Scale factor at natural origin\",1,SCALEUNIT[\"unity\",1,ID[\"EPSG\",9201]]],"
				+ "PARAMETER[\"False easting\",0,LENGTHUNIT[\"metre\",1,ID[\"EPSG\",9001]]],"
				+ "PARAMETER[\"False northing\",0,LENGTHUNIT[\"metre\",1,ID[\"EPSG\",9001]]],"
				+ "ID[\"EPSG\",19883]],CS[Cartesian,2,ID[\"EPSG\",4400]],"
				+ "AXIS[\"Easting (E)\",east],AXIS[\"Northing (N)\",north],"
				+ "LENGTHUNIT[\"metre\",1,ID[\"EPSG\",9001]],ID[\"EPSG\",3395]]";

		String expected = "+proj=merc +lat_ts=0 +lon_0=0 +k_0=1 +x_0=0 +y_0=0 +datum=WGS84 +units=m +no_defs";
		assertEquals(expected, ProjParser.paramsText(definition));

		definition = "PROJCS[\"WGS 84 / World Mercator\",GEOGCS[\"WGS 84\","
				+ "DATUM[\"WGS_1984\","
				+ "SPHEROID[\"WGS 84\",6378137,298.257223563,"
				+ "AUTHORITY[\"EPSG\",\"7030\"]],"
				+ "AUTHORITY[\"EPSG\",\"6326\"]],"
				+ "PRIMEM[\"Greenwich\",0,AUTHORITY[\"EPSG\",\"8901\"]],"
				+ "UNIT[\"degree\",0.01745329251994328,"
				+ "AUTHORITY[\"EPSG\",\"9122\"]],"
				+ "AUTHORITY[\"EPSG\",\"4326\"]],"
				+ "UNIT[\"metre\",1,AUTHORITY[\"EPSG\",\"9001\"]],"
				+ "PROJECTION[\"Mercator_1SP\"],"
				+ "PARAMETER[\"central_meridian\",0],"
				+ "PARAMETER[\"scale_factor\",1],"
				+ "PARAMETER[\"false_easting\",0],"
				+ "PARAMETER[\"false_northing\",0],"
				+ "AUTHORITY[\"EPSG\",\"3395\"],"
				+ "AXIS[\"Easting\",EAST],AXIS[\"Northing\",NORTH]]";

		expected = "+proj=merc +lon_0=0 +k_0=1 +x_0=0 +y_0=0 +datum=WGS84 +units=m +no_defs";
		assertEquals(expected, ProjParser.paramsText(definition));

		definition = "PROJCS[\"WGS 84 / World Mercator\",GEOGCS[\"WGS 84\","
				+ "DATUM[\"WGS_1984\","
				+ "SPHEROID[\"WGS 84\",6378137,298.257223563,"
				+ "AUTHORITY[\"EPSG\",\"7030\"]],"
				+ "AUTHORITY[\"EPSG\",\"6326\"]],"
				+ "PRIMEM[\"Greenwich\",0,AUTHORITY[\"EPSG\",\"8901\"]],"
				+ "UNIT[\"degree\",0.01745329251994328,"
				+ "AUTHORITY[\"EPSG\",\"9122\"]],"
				+ "AUTHORITY[\"EPSG\",\"4326\"]],"
				+ "UNIT[\"metre\",1,AUTHORITY[\"EPSG\",\"9001\"]],"
				+ "PROJECTION[\"Mercator\"],"
				+ "PARAMETER[\"central_meridian\",0],"
				+ "PARAMETER[\"scale_factor\",1],"
				+ "PARAMETER[\"false_easting\",0],"
				+ "PARAMETER[\"false_northing\",0],"
				+ "AUTHORITY[\"EPSG\",\"3395\"],"
				+ "AXIS[\"Easting\",EAST],AXIS[\"Northing\",NORTH]]";

		expected = "+proj=merc +lon_0=0 +k_0=1 +x_0=0 +y_0=0 +datum=WGS84 +units=m +no_defs";
		assertEquals(expected, ProjParser.paramsText(definition));

		definition = "PROJCRS[\"WGS 84 / World Mercator\","
				+ "BASEGEODCRS[\"WGS 84\","
				+ "DATUM[\"World Geodetic System 1984\","
				+ "ELLIPSOID[\"WGS 84\",6378137,298.257223563]]],"
				+ "CONVERSION[\"Mercator\","
				+ "METHOD[\"Mercator (variant A)\",ID[\"EPSG\",\"9804\"]],"
				+ "PARAMETER[\"Latitude of natural origin\",0,"
				+ "ANGLEUNIT[\"degree\",0.0174532925199433]],"
				+ "PARAMETER[\"Longitude of natural origin\",0,"
				+ "ANGLEUNIT[\"degree\",0.0174532925199433]],"
				+ "PARAMETER[\"Scale factor at natural origin\",1,"
				+ "SCALEUNIT[\"unity\",1.0]],"
				+ "PARAMETER[\"False easting\",0,LENGTHUNIT[\"metre\",1.0]],"
				+ "PARAMETER[\"False northing\",0,LENGTHUNIT[\"metre\",1.0]],"
				+ "ID[\"EPSG\",\"19833\"]],CS[Cartesian,2],"
				+ "AXIS[\"Easting (E)\",east,ORDER[1]],"
				+ "AXIS[\"Northing (N)\",north,ORDER[2]],"
				+ "LENGTHUNIT[\"metre\",1.0],ID[\"EPSG\",\"3395\"]]";

		expected = "+proj=merc +lat_ts=0 +lon_0=0 +k_0=1 +x_0=0 +y_0=0 +datum=WGS84 +units=m +no_defs";
		assertEquals(expected, ProjParser.paramsText(definition));

	}

	/**
	 * Test EPSG 3410
	 * 
	 * @throws IOException
	 *             upon error
	 */
	@Test
	public void test3410() throws IOException {

		// +proj=cea +lon_0=0 +lat_ts=30 +x_0=0 +y_0=0 +a=6371228 +b=6371228
		// +units=m +no_defs

		String definition = "PROJCRS[\"NSIDC EASE-Grid Global\",BASEGEOGCRS[\"Unspecified datum based upon the International 1924 Authalic Sphere\","
				+ "DATUM[\"Not specified (based on International 1924 Authalic Sphere)\","
				+ "ELLIPSOID[\"International 1924 Authalic Sphere\",6371228,0,LENGTHUNIT[\"metre\",1,ID[\"EPSG\",9001]],ID[\"EPSG\",7057]],"
				+ "ID[\"EPSG\",6053]],ID[\"EPSG\",4053]],"
				+ "CONVERSION[\"US NSIDC Equal Area global projection\",METHOD[\"Lambert Cylindrical Equal Area (Spherical)\",ID[\"EPSG\",9834]],"
				+ "PARAMETER[\"Latitude of 1st standard parallel\",30,ANGLEUNIT[\"degree\",0.0174532925199433,ID[\"EPSG\",9102]]],"
				+ "PARAMETER[\"Longitude of natural origin\",0,ANGLEUNIT[\"degree\",0.0174532925199433,ID[\"EPSG\",9102]]],"
				+ "PARAMETER[\"False easting\",0,LENGTHUNIT[\"metre\",1,ID[\"EPSG\",9001]]],"
				+ "PARAMETER[\"False northing\",0,LENGTHUNIT[\"metre\",1,ID[\"EPSG\",9001]]],"
				+ "ID[\"EPSG\",19869]],"
				+ "CS[Cartesian,2,ID[\"EPSG\",4499]],AXIS[\"Easting (X)\",east],AXIS[\"Northing (Y)\",north],"
				+ "LENGTHUNIT[\"metre\",1,ID[\"EPSG\",9001]],ID[\"EPSG\",3410]]";

		String expected = "+proj=cea +lat_ts=30 +lon_0=0 +x_0=0 +y_0=0 +a=6371228 +b=6371228 +units=m +no_defs";
		assertEquals(expected, ProjParser.paramsText(definition));

		definition = "PROJCS[\"NSIDC EASE-Grid Global\","
				+ "GEOGCS[\"Unspecified datum based upon the International 1924 Authalic Sphere\","
				+ "DATUM[\"Not_specified_based_on_International_1924_Authalic_Sphere\","
				+ "SPHEROID[\"International 1924 Authalic Sphere\",6371228,0,"
				+ "AUTHORITY[\"EPSG\",\"7057\"]],"
				+ "AUTHORITY[\"EPSG\",\"6053\"]]," + "PRIMEM[\"Greenwich\",0,"
				+ "AUTHORITY[\"EPSG\",\"8901\"]],"
				+ "UNIT[\"degree\",0.0174532925199433,"
				+ "AUTHORITY[\"EPSG\",\"9122\"]],"
				+ "AUTHORITY[\"EPSG\",\"4053\"]],"
				+ "PROJECTION[\"Cylindrical_Equal_Area\"],"
				+ "PARAMETER[\"standard_parallel_1\",30],"
				+ "PARAMETER[\"central_meridian\",0],"
				+ "PARAMETER[\"false_easting\",0],"
				+ "PARAMETER[\"false_northing\",0]," + "UNIT[\"metre\",1,"
				+ "AUTHORITY[\"EPSG\",\"9001\"]]," + "AXIS[\"X\",EAST],"
				+ "AXIS[\"Y\",NORTH]," + "AUTHORITY[\"EPSG\",\"3410\"]]";

		expected = "+proj=cea +lat_ts=30 +lon_0=0 +x_0=0 +y_0=0 +a=6371228 +b=6371228 +units=m +no_defs";
		assertEquals(expected, ProjParser.paramsText(definition));

	}

	/**
	 * Test EPSG 3786
	 * 
	 * @throws IOException
	 *             upon error
	 */
	@Test
	public void test3786() throws IOException {

		// +proj=eqc +lat_ts=0 +lat_0=0 +lon_0=0 +x_0=0 +y_0=0 +a=6371007
		// +b=6371007 +units=m +no_defs

		String definition = "PROJCRS[\"World Equidistant Cylindrical (Sphere)\",BASEGEOGCRS[\"Unspecified datum based upon the GRS 1980 Authalic Sphere\","
				+ "DATUM[\"Not specified (based on GRS 1980 Authalic Sphere)\","
				+ "ELLIPSOID[\"GRS 1980 Authalic Sphere\",6371007,0,LENGTHUNIT[\"metre\",1,ID[\"EPSG\",9001]],ID[\"EPSG\",7048]],"
				+ "ID[\"EPSG\",6047]],ID[\"EPSG\",4047]],"
				+ "CONVERSION[\"World Equidistant Cylindrical (Sphere)\",METHOD[\"Equidistant Cylindrical (Spherical)\",ID[\"EPSG\",9823]],"
				+ "PARAMETER[\"Latitude of natural origin\",0,ANGLEUNIT[\"degree\",0.0174532925199433,ID[\"EPSG\",9102]]],"
				+ "PARAMETER[\"Longitude of natural origin\",0,ANGLEUNIT[\"degree\",0.0174532925199433,ID[\"EPSG\",9102]]],"
				+ "PARAMETER[\"False easting\",0,LENGTHUNIT[\"metre\",1,ID[\"EPSG\",9001]]],"
				+ "PARAMETER[\"False northing\",0,LENGTHUNIT[\"metre\",1,ID[\"EPSG\",9001]]],"
				+ "ID[\"EPSG\",19968]],"
				+ "CS[Cartesian,2,ID[\"EPSG\",4499]],AXIS[\"Easting (X)\",east],AXIS[\"Northing (Y)\",north],"
				+ "LENGTHUNIT[\"metre\",1,ID[\"EPSG\",9001]],ID[\"EPSG\",3786]]";

		String expected = "+proj=eqc +lat_0=0 +lat_ts=0 +lon_0=0 +x_0=0 +y_0=0 +a=6371007 +b=6371007 +units=m +no_defs";
		assertEquals(expected, ProjParser.paramsText(definition));

		definition = "PROJCS[\"World Equidistant Cylindrical (Sphere) (deprecated)\","
				+ "GEOGCS[\"Unspecified datum based upon the GRS 1980 Authalic Sphere\","
				+ "DATUM[\"Not_specified_based_on_GRS_1980_Authalic_Sphere\","
				+ "SPHEROID[\"GRS 1980 Authalic Sphere\",6371007,0,"
				+ "AUTHORITY[\"EPSG\",\"7048\"]],"
				+ "AUTHORITY[\"EPSG\",\"6047\"]]," + "PRIMEM[\"Greenwich\",0,"
				+ "AUTHORITY[\"EPSG\",\"8901\"]],"
				+ "UNIT[\"degree\",0.0174532925199433,"
				+ "AUTHORITY[\"EPSG\",\"9122\"]],"
				+ "AUTHORITY[\"EPSG\",\"4047\"]],"
				+ "PROJECTION[\"Equirectangular\"],"
				+ "PARAMETER[\"latitude_of_origin\",0],"
				+ "PARAMETER[\"central_meridian\",0],"
				+ "PARAMETER[\"false_easting\",0],"
				+ "PARAMETER[\"false_northing\",0]," + "UNIT[\"metre\",1,"
				+ "AUTHORITY[\"EPSG\",\"9001\"]]," + "AXIS[\"X\",EAST],"
				+ "AXIS[\"Y\",NORTH]," + "AUTHORITY[\"EPSG\",\"3786\"]]";

		expected = "+proj=eqc +lat_0=0 +lat_ts=0 +lon_0=0 +x_0=0 +y_0=0 +a=6371007 +b=6371007 +units=m +no_defs";
		assertEquals(expected, ProjParser.paramsText(definition));

	}

	/**
	 * Test EPSG 3787
	 * 
	 * @throws IOException
	 *             upon error
	 */
	@Test
	public void test3787() throws IOException {

		// +proj=tmerc +lat_0=0 +lon_0=15 +k=0.9999 +x_0=500000 +y_0=-5000000
		// +datum=hermannskogel +units=m +no_defs

		String definition = "PROJCRS[\"MGI / Slovene National Grid\",BASEGEOGCRS[\"MGI\","
				+ "DATUM[\"Militar-Geographische Institut\","
				+ "ELLIPSOID[\"Bessel 1841\",6377397.155,299.1528128,LENGTHUNIT[\"metre\",1,ID[\"EPSG\",9001]],ID[\"EPSG\",7004]],"
				+ "ID[\"EPSG\",6312]],ID[\"EPSG\",4312]],"
				+ "CONVERSION[\"Slovene National Grid\",METHOD[\"Transverse Mercator\",ID[\"EPSG\",9807]],"
				+ "PARAMETER[\"Latitude of natural origin\",0,ANGLEUNIT[\"degree\",0.0174532925199433,ID[\"EPSG\",9102]]],"
				+ "PARAMETER[\"Longitude of natural origin\",15,ANGLEUNIT[\"degree\",0.0174532925199433,ID[\"EPSG\",9102]]],"
				+ "PARAMETER[\"Scale factor at natural origin\",0.9999,SCALEUNIT[\"unity\",1,ID[\"EPSG\",9201]]],"
				+ "PARAMETER[\"False easting\",500000,LENGTHUNIT[\"metre\",1,ID[\"EPSG\",9001]]],"
				+ "PARAMETER[\"False northing\",-5000000,LENGTHUNIT[\"metre\",1,ID[\"EPSG\",9001]]],"
				+ "ID[\"EPSG\",19845]],"
				+ "CS[Cartesian,2,ID[\"EPSG\",4498]],AXIS[\"Easting (Y)\",east],AXIS[\"Northing (X)\",north],"
				+ "LENGTHUNIT[\"metre\",1,ID[\"EPSG\",9001]],ID[\"EPSG\",3787]]";

		String expected = "+proj=tmerc +lat_0=0 +lon_0=15 +k_0=0.9999 +x_0=500000 +y_0=-5000000 +datum=hermannskogel +units=m +no_defs";
		assertEquals(expected, ProjParser.paramsText(definition));

		definition = "PROJCS[\"MGI / Slovene National Grid (deprecated)\","
				+ "GEOGCS[\"MGI\","
				+ "DATUM[\"Militar_Geographische_Institute\","
				+ "SPHEROID[\"Bessel 1841\",6377397.155,299.1528128,"
				+ "AUTHORITY[\"EPSG\",\"7004\"]],"
				+ "TOWGS84[577.326,90.129,463.919,5.137,1.474,5.297,2.4232],"
				+ "AUTHORITY[\"EPSG\",\"6312\"]]," + "PRIMEM[\"Greenwich\",0,"
				+ "AUTHORITY[\"EPSG\",\"8901\"]],"
				+ "UNIT[\"degree\",0.0174532925199433,"
				+ "AUTHORITY[\"EPSG\",\"9122\"]],"
				+ "AUTHORITY[\"EPSG\",\"4312\"]],"
				+ "PROJECTION[\"Transverse_Mercator\"],"
				+ "PARAMETER[\"latitude_of_origin\",0],"
				+ "PARAMETER[\"central_meridian\",15],"
				+ "PARAMETER[\"scale_factor\",0.9999],"
				+ "PARAMETER[\"false_easting\",500000],"
				+ "PARAMETER[\"false_northing\",-5000000],"
				+ "UNIT[\"metre\",1," + "AUTHORITY[\"EPSG\",\"9001\"]],"
				+ "AXIS[\"Y\",EAST]," + "AXIS[\"X\",NORTH],"
				+ "AUTHORITY[\"EPSG\",\"3787\"]]";

		expected = "+proj=tmerc +lat_0=0 +lon_0=15 +k_0=0.9999 +x_0=500000 +y_0=-5000000 +datum=hermannskogel +towgs84=577.326,90.129,463.919,5.137,1.474,5.297,2.4232 +units=m +no_defs";
		assertEquals(expected, ProjParser.paramsText(definition));

	}

	/**
	 * Test EPSG 3857
	 * 
	 * @throws IOException
	 *             upon error
	 */
	@Test
	public void test3857() throws IOException {

		// +proj=merc +a=6378137 +b=6378137 +lat_ts=0.0 +lon_0=0.0 +x_0=0.0
		// +y_0=0 +k=1.0 +units=m +nadgrids=@null +wktext +no_defs

		String definition = "PROJCRS[\"WGS 84 / Pseudo-Mercator\",BASEGEOGCRS[\"WGS 84\","
				+ "ENSEMBLE[\"World Geodetic System 1984 ensemble\","
				+ "MEMBER[\"World Geodetic System 1984 (Transit)\",ID[\"EPSG\",1166]],"
				+ "MEMBER[\"World Geodetic System 1984 (G730)\",ID[\"EPSG\",1152]],"
				+ "MEMBER[\"World Geodetic System 1984 (G873)\",ID[\"EPSG\",1153]],"
				+ "MEMBER[\"World Geodetic System 1984 (G1150)\",ID[\"EPSG\",1154]],"
				+ "MEMBER[\"World Geodetic System 1984 (G1674)\",ID[\"EPSG\",1155]],"
				+ "MEMBER[\"World Geodetic System 1984 (G1762)\",ID[\"EPSG\",1156]],"
				+ "ELLIPSOID[\"WGS 84\",6378137,298.257223563,ID[\"EPSG\",7030]],"
				+ "ENSEMBLEACCURACY[2],ID[\"EPSG\",6326]],ID[\"EPSG\",4326]],"
				+ "CONVERSION[\"Popular Visualisation Pseudo-Mercator\","
				+ "METHOD[\"Popular Visualisation Pseudo Mercator\",ID[\"EPSG\",1024]],"
				+ "PARAMETER[\"Latitude of natural origin\",0,ANGLEUNIT[\"degree\",0.0174532925199433,ID[\"EPSG\",9102]]],"
				+ "PARAMETER[\"Longitude of natural origin\",0,ANGLEUNIT[\"degree\",0.0174532925199433,ID[\"EPSG\",9102]]],"
				+ "PARAMETER[\"False easting\",0,LENGTHUNIT[\"metre\",1,ID[\"EPSG\",9001]]],"
				+ "PARAMETER[\"False northing\",0,LENGTHUNIT[\"metre\",1,ID[\"EPSG\",9001]]],"
				+ "ID[\"EPSG\",3856]],CS[Cartesian,2,ID[\"EPSG\",4499]],"
				+ "AXIS[\"Easting (X)\",east],AXIS[\"Northing (Y)\",north],"
				+ "LENGTHUNIT[\"metre\",1,ID[\"EPSG\",9001]],ID[\"EPSG\",3857]]";

		String expected = "+proj=merc +lat_ts=0 +lon_0=0 +x_0=0 +y_0=0 +a=6378137 +b=6378137 +units=m +no_defs";
		assertEquals(expected, ProjParser.paramsText(definition));

		definition = "PROJCS[\"WGS 84 / Pseudo-Mercator\",GEOGCS[\"WGS 84\","
				+ "DATUM[\"WGS_1984\","
				+ "SPHEROID[\"WGS 84\",6378137,298.257223563,"
				+ "AUTHORITY[\"EPSG\",\"7030\"]],"
				+ "AUTHORITY[\"EPSG\",\"6326\"]],"
				+ "PRIMEM[\"Greenwich\",0,AUTHORITY[\"EPSG\",\"8901\"]],"
				+ "UNIT[\"degree\",0.0174532925199433,"
				+ "AUTHORITY[\"EPSG\",\"9122\"]],"
				+ "AUTHORITY[\"EPSG\",\"4326\"]],"
				+ "PROJECTION[\"Mercator_1SP\"],"
				+ "PARAMETER[\"central_meridian\",0],"
				+ "PARAMETER[\"scale_factor\",1],"
				+ "PARAMETER[\"false_easting\",0],"
				+ "PARAMETER[\"false_northing\",0],"
				+ "UNIT[\"metre\",1,AUTHORITY[\"EPSG\",\"9001\"]],"
				+ "AXIS[\"X\",EAST],AXIS[\"Y\",NORTH],"
				+ "EXTENSION[\"PROJ4\",\"+proj=merc +a=6378137 +b=6378137 +lat_ts=0.0 +lon_0=0.0 +x_0=0.0 +y_0=0 +k=1.0 +units=m +nadgrids=@null +wktext  +no_defs\"],"
				+ "AUTHORITY[\"EPSG\",\"3857\"]]";

		expected = "+proj=merc +lon_0=0 +k_0=1 +x_0=0 +y_0=0 +a=6378137 +b=6378137 +units=m +no_defs";
		assertEquals(expected, ProjParser.paramsText(definition));

		definition = "PROJCS[\"WGS 84 / Pseudo-Mercator\","
				+ "GEOGCRS[\"WGS 84\",DATUM[\"WGS_1984\","
				+ "SPHEROID[\"WGS 84\",6378137,298.257223563,"
				+ "ID[\"EPSG\",\"7030\"]],ID[\"EPSG\",\"6326\"]],"
				+ "PRIMEM[\"Greenwich\",0,ID[\"EPSG\",\"8901\"]],"
				+ "UNIT[\"degree\",0.0174532925199433,"
				+ "ID[\"EPSG\",\"9122\"]],ID[\"EPSG\",\"4326\"]],"
				+ "PROJECTION[\"Mercator_1SP\"],"
				+ "PARAMETER[\"central_meridian\",0],"
				+ "PARAMETER[\"scale_factor\",1],"
				+ "PARAMETER[\"false_easting\",0],"
				+ "PARAMETER[\"false_northing\",0]"
				+ ",UNIT[\"metre\",1,ID[\"EPSG\",\"9001\"]]"
				+ ",AXIS[\"X\",EAST],AXIS[\"Y\",NORTH]"
				+ ",ID[\"EPSG\",\"3857\"]]";

		expected = "+proj=merc +lon_0=0 +k_0=1 +x_0=0 +y_0=0 +a=6378137 +b=6378137 +units=m +no_defs";
		assertEquals(expected, ProjParser.paramsText(definition));

	}

	/**
	 * Test EPSG 3978
	 * 
	 * @throws IOException
	 *             upon error
	 */
	@Test
	public void test3978() throws IOException {

		// +proj=lcc +lat_1=49 +lat_2=77 +lat_0=49 +lon_0=-95 +x_0=0 +y_0=0
		// +datum=NAD83 +units=m +no_defs

		String definition = "PROJCRS[\"NAD83 / Canada Atlas Lambert\",BASEGEOGCRS[\"NAD83\","
				+ "DATUM[\"North American Datum 1983\","
				+ "ELLIPSOID[\"GRS 1980\",6378137,298.257222101,ID[\"EPSG\",7019]],"
				+ "ID[\"EPSG\",6269]],ID[\"EPSG\",4269]],"
				+ "CONVERSION[\"Canada Atlas Lambert\",METHOD[\"Lambert Conic Conformal (2SP)\",ID[\"EPSG\",9802]],"
				+ "PARAMETER[\"Latitude of false origin\",49,ANGLEUNIT[\"degree\",0.0174532925199433,ID[\"EPSG\",9102]]],"
				+ "PARAMETER[\"Longitude of false origin\",-95,ANGLEUNIT[\"degree\",0.0174532925199433,ID[\"EPSG\",9102]]],"
				+ "PARAMETER[\"Latitude of 1st standard parallel\",49,ANGLEUNIT[\"degree\",0.0174532925199433,ID[\"EPSG\",9102]]],"
				+ "PARAMETER[\"Latitude of 2nd standard parallel\",77,ANGLEUNIT[\"degree\",0.0174532925199433,ID[\"EPSG\",9102]]],"
				+ "PARAMETER[\"Easting at false origin\",0,LENGTHUNIT[\"metre\",1,ID[\"EPSG\",9001]]],"
				+ "PARAMETER[\"Northing at false origin\",0,LENGTHUNIT[\"metre\",1,ID[\"EPSG\",9001]]],"
				+ "ID[\"EPSG\",3977]],CS[Cartesian,2,ID[\"EPSG\",4400]],"
				+ "AXIS[\"Easting (E)\",east],AXIS[\"Northing (N)\",north],"
				+ "LENGTHUNIT[\"metre\",1,ID[\"EPSG\",9001]],ID[\"EPSG\",3978]]";

		String expected = "+proj=lcc +lat_1=49 +lat_2=77 +lat_0=49 +lon_0=-95 +x_0=0 +y_0=0 +datum=NAD83 +units=m +no_defs";
		assertEquals(expected, ProjParser.paramsText(definition));

		definition = "PROJCS[\"NAD83 / Canada Atlas Lambert\",GEOGCS[\"NAD83\","
				+ "DATUM[\"North_American_Datum_1983\","
				+ "SPHEROID[\"GRS 1980\",6378137,298.257222101,AUTHORITY[\"EPSG\",\"7019\"]],"
				+ "TOWGS84[0,0,0,0,0,0,0],AUTHORITY[\"EPSG\",\"6269\"]],"
				+ "PRIMEM[\"Greenwich\",0,AUTHORITY[\"EPSG\",\"8901\"]],"
				+ "UNIT[\"degree\",0.0174532925199433,"
				+ "AUTHORITY[\"EPSG\",\"9122\"]],"
				+ "AUTHORITY[\"EPSG\",\"4269\"]],"
				+ "PROJECTION[\"Lambert_Conformal_Conic_2SP\"],"
				+ "PARAMETER[\"standard_parallel_1\",49],"
				+ "PARAMETER[\"standard_parallel_2\",77],"
				+ "PARAMETER[\"latitude_of_origin\",49],"
				+ "PARAMETER[\"central_meridian\",-95],"
				+ "PARAMETER[\"false_easting\",0],"
				+ "PARAMETER[\"false_northing\",0],"
				+ "UNIT[\"metre\",1,AUTHORITY[\"EPSG\",\"9001\"]],"
				+ "AXIS[\"Easting\",EAST],AXIS[\"Northing\",NORTH],"
				+ "AUTHORITY[\"EPSG\",\"3978\"]]";

		expected = "+proj=lcc +lat_1=49 +lat_2=77 +lat_0=49 +lon_0=-95 +x_0=0 +y_0=0 +datum=NAD83 +towgs84=0,0,0,0,0,0,0 +units=m +no_defs";
		assertEquals(expected, ProjParser.paramsText(definition));

		definition = "PROJCS[\"NAD83 / Canada Atlas Lambert\",GEOGCRS[\"NAD83\","
				+ "DATUM[\"North_American_Datum_1983\","
				+ "SPHEROID[\"GRS 1980\",6378137,298.257222101,"
				+ "ID[\"EPSG\",\"7019\"]],"
				+ "ABRIDGEDTRANSFORMATION[0,0,0,0,0,0,0],"
				+ "ID[\"EPSG\",\"6269\"]],"
				+ "PRIMEM[\"Greenwich\",0,ID[\"EPSG\",\"8901\"]],"
				+ "UNIT[\"degree\",0.0174532925199433,ID[\"EPSG\",\"9122\"]],"
				+ "ID[\"EPSG\",\"4269\"]],"
				+ "PROJECTION[\"Lambert_Conformal_Conic_2SP\"],"
				+ "PARAMETER[\"standard_parallel_1\",49],"
				+ "PARAMETER[\"standard_parallel_2\",77],"
				+ "PARAMETER[\"latitude_of_origin\",49],"
				+ "PARAMETER[\"central_meridian\",-95],"
				+ "PARAMETER[\"false_easting\",0],"
				+ "PARAMETER[\"false_northing\",0],"
				+ "UNIT[\"metre\",1,ID[\"EPSG\",\"9001\"]],"
				+ "AXIS[\"Easting\",EAST],AXIS[\"Northing\",NORTH],"
				+ "ID[\"EPSG\",\"3978\"]]";

		expected = "+proj=lcc +lat_1=49 +lat_2=77 +lat_0=49 +lon_0=-95 +x_0=0 +y_0=0 +datum=NAD83 +towgs84=0,0,0,0,0,0,0 +units=m +no_defs";
		assertEquals(expected, ProjParser.paramsText(definition));

	}

	/**
	 * Test EPSG 3997
	 * 
	 * @throws IOException
	 *             upon error
	 */
	@Test
	public void test3997() throws IOException {

		// +proj=tmerc +lat_0=0 +lon_0=55.33333333333334 +k=1 +x_0=500000 +y_0=0
		// +datum=WGS84 +units=m +no_defs

		String definition = "PROJCRS[\"WGS 84 / Dubai Local TM\",BASEGEOGCRS[\"WGS 84\","
				+ "ENSEMBLE[\"World Geodetic System 1984 ensemble\","
				+ "MEMBER[\"World Geodetic System 1984 (Transit)\", ID[\"EPSG\",1166]],"
				+ "MEMBER[\"World Geodetic System 1984 (G730)\", ID[\"EPSG\",1152]],"
				+ "MEMBER[\"World Geodetic System 1984 (G873)\", ID[\"EPSG\",1153]],"
				+ "MEMBER[\"World Geodetic System 1984 (G1150)\", ID[\"EPSG\",1154]],"
				+ "MEMBER[\"World Geodetic System 1984 (G1674)\", ID[\"EPSG\",1155]],"
				+ "MEMBER[\"World Geodetic System 1984 (G1762)\", ID[\"EPSG\",1156]],"
				+ "ELLIPSOID[\"WGS 84\",6378137,298.2572236,LENGTHUNIT[\"metre\",1,ID[\"EPSG\",9001]],ID[\"EPSG\",7030]], ENSEMBLEACCURACY[2],"
				+ "ID[\"EPSG\",6326]],ID[\"EPSG\",4326]],"
				+ "CONVERSION[\"Dubai Local Transverse Mercator\",METHOD[\"Transverse Mercator\",ID[\"EPSG\",9807]],"
				+ "PARAMETER[\"Latitude of natural origin\",0,ANGLEUNIT[\"degree\",0.0174532925199433,ID[\"EPSG\",9102]]],"
				+ "PARAMETER[\"Longitude of natural origin\",55.333333333,ANGLEUNIT[\"degree\",0.0174532925199433,ID[\"EPSG\",9102]]],"
				+ "PARAMETER[\"Scale factor at natural origin\",1,SCALEUNIT[\"unity\",1,ID[\"EPSG\",9201]]],"
				+ "PARAMETER[\"False easting\",500000,LENGTHUNIT[\"metre\",1,ID[\"EPSG\",9001]]],"
				+ "PARAMETER[\"False northing\",0,LENGTHUNIT[\"metre\",1,ID[\"EPSG\",9001]]],"
				+ "ID[\"EPSG\",19839]],"
				+ "CS[Cartesian,2,ID[\"EPSG\",4400]],AXIS[\"Easting (E)\",east],AXIS[\"Northing (N)\",north],"
				+ "LENGTHUNIT[\"metre\",1,ID[\"EPSG\",9001]],ID[\"EPSG\",3997]]";

		String expected = "+proj=tmerc +lat_0=0 +lon_0=55.333333333 +k_0=1 +x_0=500000 +y_0=0 +datum=WGS84 +units=m +no_defs";
		assertEquals(expected, ProjParser.paramsText(definition));

		definition = "PROJCS[\"WGS 84 / Dubai Local TM\","
				+ "GEOGCS[\"WGS 84\"," + "DATUM[\"WGS_1984\","
				+ "SPHEROID[\"WGS 84\",6378137,298.257223563,"
				+ "AUTHORITY[\"EPSG\",\"7030\"]],"
				+ "AUTHORITY[\"EPSG\",\"6326\"]]," + "PRIMEM[\"Greenwich\",0,"
				+ "AUTHORITY[\"EPSG\",\"8901\"]],"
				+ "UNIT[\"degree\",0.0174532925199433,"
				+ "AUTHORITY[\"EPSG\",\"9122\"]],"
				+ "AUTHORITY[\"EPSG\",\"4326\"]],"
				+ "PROJECTION[\"Transverse_Mercator\"],"
				+ "PARAMETER[\"latitude_of_origin\",0],"
				+ "PARAMETER[\"central_meridian\",55.33333333333334],"
				+ "PARAMETER[\"scale_factor\",1],"
				+ "PARAMETER[\"false_easting\",500000],"
				+ "PARAMETER[\"false_northing\",0]," + "UNIT[\"metre\",1,"
				+ "AUTHORITY[\"EPSG\",\"9001\"]]," + "AXIS[\"Easting\",EAST],"
				+ "AXIS[\"Northing\",NORTH]," + "AUTHORITY[\"EPSG\",\"3997\"]]";

		expected = "+proj=tmerc +lat_0=0 +lon_0=55.33333333333334 +k_0=1 +x_0=500000 +y_0=0 +datum=WGS84 +units=m +no_defs";
		assertEquals(expected, ProjParser.paramsText(definition));

	}

	/**
	 * Test EPSG 4005
	 * 
	 * @throws IOException
	 *             upon error
	 */
	@Test
	public void test4005() throws IOException {

		// +proj=longlat +a=6377492.018 +b=6356173.508712696 +no_defs

		String definition = "GEOGCRS[\"Unknown datum based upon the Bessel Modified ellipsoid\","
				+ "DATUM[\"Not specified (based on Bessel Modified ellipsoid)\","
				+ "ELLIPSOID[\"Bessel Modified\",6377492.018,299.1528128,LENGTHUNIT[\"metre\",1,ID[\"EPSG\",9001]],"
				+ "ID[\"EPSG\",7005]],ID[\"EPSG\",6005]],"
				+ "CS[ellipsoidal,2,ID[\"EPSG\",6422]],"
				+ "AXIS[\"latitude (Lat)\",north],AXIS[\"longitude (Lon)\",east],"
				+ "ANGLEUNIT[\"degree\",0.0174532925199433,ID[\"EPSG\",9102]],ID[\"EPSG\",4005]]";

		String expected = "+proj=longlat +a=6377492.018 +b=6356173.508712696 +no_defs";
		assertEquals(expected, ProjParser.paramsText(definition));

		definition = "GEOGCS[\"Unknown datum based upon the Bessel Modified ellipsoid\","
				+ "DATUM[\"Not_specified_based_on_Bessel_Modified_ellipsoid\","
				+ "SPHEROID[\"Bessel Modified\",6377492.018,299.1528128,"
				+ "AUTHORITY[\"EPSG\",\"7005\"]],"
				+ "AUTHORITY[\"EPSG\",\"6005\"]]," + "PRIMEM[\"Greenwich\",0,"
				+ "AUTHORITY[\"EPSG\",\"8901\"]],"
				+ "UNIT[\"degree\",0.0174532925199433,"
				+ "AUTHORITY[\"EPSG\",\"9122\"]],"
				+ "AUTHORITY[\"EPSG\",\"4005\"]]";

		expected = "+proj=longlat +a=6377492.018 +b=6356173.508712696 +no_defs";
		assertEquals(expected, ProjParser.paramsText(definition));

	}

	/**
	 * Test EPSG 4023
	 * 
	 * @throws IOException
	 *             upon error
	 */
	@Test
	public void test4023() throws IOException {

		// +proj=longlat +ellps=GRS80 +towgs84=0,0,0,0,0,0,0 +no_defs

		String definition = "GEOGCRS[\"MOLDREF99\"," + "DATUM[\"MOLDREF99\","
				+ "ELLIPSOID[\"GRS 1980\",6378137,298.2572221,LENGTHUNIT[\"metre\",1,ID[\"EPSG\",9001]],"
				+ "ID[\"EPSG\",7019]]," + "TOWGS84[0,0,0,0,0,0,0],"
				+ "ID[\"EPSG\",1032]]," + "CS[ellipsoidal,2,ID[\"EPSG\",6422]],"
				+ "AXIS[\"latitude (Lat)\",north],AXIS[\"longitude (Lon)\",east],"
				+ "ANGLEUNIT[\"degree\",0.0174532925199433,ID[\"EPSG\",9102]],ID[\"EPSG\",4023]]";

		String expected = "+proj=longlat +ellps=GRS80 +towgs84=0,0,0,0,0,0,0 +no_defs";
		assertEquals(expected, ProjParser.paramsText(definition));

		definition = "GEOGCS[\"MOLDREF99\"," + "DATUM[\"MOLDREF99\","
				+ "SPHEROID[\"GRS 1980\",6378137,298.257222101,"
				+ "AUTHORITY[\"EPSG\",\"7019\"]]," + "TOWGS84[0,0,0,0,0,0,0],"
				+ "AUTHORITY[\"EPSG\",\"1032\"]]," + "PRIMEM[\"Greenwich\",0,"
				+ "AUTHORITY[\"EPSG\",\"8901\"]],"
				+ "UNIT[\"degree\",0.0174532925199433,"
				+ "AUTHORITY[\"EPSG\",\"9122\"]],"
				+ "AUTHORITY[\"EPSG\",\"4023\"]]";

		expected = "+proj=longlat +ellps=GRS80 +towgs84=0,0,0,0,0,0,0 +no_defs";
		assertEquals(expected, ProjParser.paramsText(definition));

	}

	/**
	 * Test EPSG 4035
	 * 
	 * @throws IOException
	 *             upon error
	 */
	@Test
	public void test4035() throws IOException {

		// +proj=longlat +a=6371000 +b=6371000 +no_defs

		String definition = "GEOGCRS[\"Unknown datum based upon the Authalic Sphere\","
				+ "DATUM[\"Not specified (based on Authalic Sphere)\","
				+ "ELLIPSOID[\"Sphere\",6371000,0,LENGTHUNIT[\"metre\",1,ID[\"EPSG\",9001]],"
				+ "ID[\"EPSG\",7035]],ID[\"EPSG\",6035]],"
				+ "CS[ellipsoidal,2,ID[\"EPSG\",6402]],"
				+ "AXIS[\"latitude (Lat)\",north],AXIS[\"longitude (Long)\",east],"
				+ "ANGLEUNIT[\"degree minute second hemisphere\",1,ID[\"EPSG\",9108]],ID[\"EPSG\",4035]]";

		String expected = "+proj=longlat +a=6371000 +b=6371000 +no_defs";
		assertEquals(expected, ProjParser.paramsText(definition));

		definition = "GEOGCS[\"Unknown datum based upon the Authalic Sphere\","
				+ "DATUM[\"Not_specified_based_on_Authalic_Sphere\","
				+ "SPHEROID[\"Sphere\",6371000,0,"
				+ "AUTHORITY[\"EPSG\",\"7035\"]],"
				+ "AUTHORITY[\"EPSG\",\"6035\"]]," + "PRIMEM[\"Greenwich\",0,"
				+ "AUTHORITY[\"EPSG\",\"8901\"]],"
				+ "UNIT[\"degree\",0.0174532925199433,"
				+ "AUTHORITY[\"EPSG\",\"9108\"]],"
				+ "AUTHORITY[\"EPSG\",\"4035\"]]";

		expected = "+proj=longlat +a=6371000 +b=6371000 +no_defs";
		assertEquals(expected, ProjParser.paramsText(definition));

	}

	/**
	 * Test EPSG 4047
	 * 
	 * @throws IOException
	 *             upon error
	 */
	@Test
	public void test4047() throws IOException {

		// +proj=longlat +a=6371007 +b=6371007 +no_defs

		String definition = "GEOGCRS[\"Unspecified datum based upon the GRS 1980 Authalic Sphere\","
				+ "DATUM[\"Not specified (based on GRS 1980 Authalic Sphere)\","
				+ "ELLIPSOID[\"GRS 1980 Authalic Sphere\",6371007,0,LENGTHUNIT[\"metre\",1,ID[\"EPSG\",9001]],"
				+ "ID[\"EPSG\",7048]],ID[\"EPSG\",6047]],"
				+ "CS[ellipsoidal,2,ID[\"EPSG\",6422]],"
				+ "AXIS[\"latitude (Lat)\",north],AXIS[\"longitude (Lon)\",east],"
				+ "ANGLEUNIT[\"degree\",0.0174532925199433,ID[\"EPSG\",9102]],ID[\"EPSG\",4047]]";

		String expected = "+proj=longlat +a=6371007 +b=6371007 +no_defs";
		assertEquals(expected, ProjParser.paramsText(definition));

		definition = "GEOGCS[\"Unspecified datum based upon the GRS 1980 Authalic Sphere\","
				+ "DATUM[\"Not_specified_based_on_GRS_1980_Authalic_Sphere\","
				+ "SPHEROID[\"GRS 1980 Authalic Sphere\",6371007,0,"
				+ "AUTHORITY[\"EPSG\",\"7048\"]],"
				+ "AUTHORITY[\"EPSG\",\"6047\"]]," + "PRIMEM[\"Greenwich\",0,"
				+ "AUTHORITY[\"EPSG\",\"8901\"]],"
				+ "UNIT[\"degree\",0.0174532925199433,"
				+ "AUTHORITY[\"EPSG\",\"9122\"]],"
				+ "AUTHORITY[\"EPSG\",\"4047\"]]";

		expected = "+proj=longlat +a=6371007 +b=6371007 +no_defs";
		assertEquals(expected, ProjParser.paramsText(definition));

	}

	/**
	 * Test EPSG 4055
	 * 
	 * @throws IOException
	 *             upon error
	 */
	@Test
	public void test4055() throws IOException {

		// +proj=longlat +a=6378137 +b=6378137 +towgs84=0,0,0,0,0,0,0 +no_defs

		String definition = "GEOGCRS[\"Popular Visualisation CRS\","
				+ "DATUM[\"Popular Visualisation Datum\","
				+ "ELLIPSOID[\"Popular Visualisation Sphere\",6378137,0,LENGTHUNIT[\"metre\",1,ID[\"EPSG\",9001]],"
				+ "ID[\"EPSG\",7059]]," + "TOWGS84[0,0,0,0,0,0,0],"
				+ "ID[\"EPSG\",6055]]," + "CS[ellipsoidal,2,ID[\"EPSG\",6422]],"
				+ "AXIS[\"latitude (Lat)\",north],AXIS[\"longitude (Lon)\",east],"
				+ "ANGLEUNIT[\"degree\",0.0174532925199433,ID[\"EPSG\",9102]],ID[\"EPSG\",4055]]";

		String expected = "+proj=longlat +a=6378137 +b=6378137 +towgs84=0,0,0,0,0,0,0 +no_defs";
		assertEquals(expected, ProjParser.paramsText(definition));

		definition = "PROJCRS[\"Popular Visualisation CRS\",BASEGEOGCRS[\"Popular Visualisation CRS\","
				+ "DATUM[\"Popular Visualisation Datum\","
				+ "ELLIPSOID[\"Popular Visualisation Sphere\",6378137,0,LENGTHUNIT[\"metre\",1,ID[\"EPSG\",9001]],ID[\"EPSG\",7059]],"
				+ "ID[\"EPSG\",6055]]],"
				+ "CONVERSION[\"Coordinate Frame rotation\",METHOD[\"Coordinate Frame rotation (geocentric domain)\",ID[\"EPSG\",1032]],"
				+ "PARAMETER[\"X-axis translation\",0,LENGTHUNIT[\"metre\",1.0]],"
				+ "PARAMETER[\"Y-axis translation\",0,LENGTHUNIT[\"metre\",1.0]],"
				+ "PARAMETER[\"Z-axis translation\",0,LENGTHUNIT[\"metre\",1.0]],"
				+ "PARAMETER[\"X-axis rotation\",0,LENGTHUNIT[\"metre\",1.0]],"
				+ "PARAMETER[\"Y-axis rotation\",0,LENGTHUNIT[\"metre\",1.0]],"
				+ "PARAMETER[\"Z-axis rotation\",0,LENGTHUNIT[\"metre\",1.0]],"
				+ "PARAMETER[\"Scale difference\",0,SCALEUNIT[\"parts per million\",1E-06]],"
				+ "],CS[Cartesian,2,ID[\"EPSG\",6422]],"
				+ "AXIS[\"latitude (Lat)\",north],AXIS[\"longitude (Lon)\",east],"
				+ "ANGLEUNIT[\"degree\",0.0174532925199433,ID[\"EPSG\",9102]],ID[\"EPSG\",4055]]";

		expected = "+proj=longlat +a=6378137 +b=6378137 +towgs84=0,0,0,0,0,0,0 +no_defs";
		assertEquals(expected, ProjParser.paramsText(definition));

		definition = "GEOGCS[\"Popular Visualisation CRS\","
				+ "DATUM[\"Popular_Visualisation_Datum\","
				+ "SPHEROID[\"Popular Visualisation Sphere\",6378137,0,"
				+ "AUTHORITY[\"EPSG\",\"7059\"]]," + "TOWGS84[0,0,0,0,0,0,0],"
				+ "AUTHORITY[\"EPSG\",\"6055\"]]," + "PRIMEM[\"Greenwich\",0,"
				+ "AUTHORITY[\"EPSG\",\"8901\"]],"
				+ "UNIT[\"degree\",0.0174532925199433,"
				+ "AUTHORITY[\"EPSG\",\"9122\"]],"
				+ "AUTHORITY[\"EPSG\",\"4055\"]]";

		expected = "+proj=longlat +a=6378137 +b=6378137 +towgs84=0,0,0,0,0,0,0 +no_defs";
		assertEquals(expected, ProjParser.paramsText(definition));

	}

	/**
	 * Test EPSG 4071
	 * 
	 * @throws IOException
	 *             upon error
	 */
	@Test
	public void test4071() throws IOException {

		// +proj=utm +zone=23 +south +ellps=intl +towgs84=-134,229,-29,0,0,0,0
		// +units=m +no_defs

		String definition = "PROJCRS[\"Chua / UTM zone 23S\",BASEGEOGCRS[\"Chua\","
				+ "DATUM[\"Chua\","
				+ "ELLIPSOID[\"International 1924\",6378388,297,LENGTHUNIT[\"metre\",1,ID[\"EPSG\",9001]],ID[\"EPSG\",7022]],"
				+ "ID[\"EPSG\",6224]],ID[\"EPSG\",4224]],"
				+ "CONVERSION[\"UTM zone 23S\",METHOD[\"Transverse Mercator\",ID[\"EPSG\",9807]],"
				+ "PARAMETER[\"Latitude of natural origin\",0,ANGLEUNIT[\"degree\",0.0174532925199433,ID[\"EPSG\",9102]]],"
				+ "PARAMETER[\"Longitude of natural origin\",-45,ANGLEUNIT[\"degree\",0.0174532925199433,ID[\"EPSG\",9102]]],"
				+ "PARAMETER[\"Scale factor at natural origin\",0.9996,SCALEUNIT[\"unity\",1,ID[\"EPSG\",9201]]],"
				+ "PARAMETER[\"False easting\",500000,LENGTHUNIT[\"metre\",1,ID[\"EPSG\",9001]]],"
				+ "PARAMETER[\"False northing\",10000000,LENGTHUNIT[\"metre\",1,ID[\"EPSG\",9001]]],"
				+ "PARAMETER[\"X-axis translation\",-134,LENGTHUNIT[\"metre\",1.0]],"
				+ "PARAMETER[\"Y-axis translation\",229,LENGTHUNIT[\"metre\",1.0]],"
				+ "PARAMETER[\"Z-axis translation\",-29,LENGTHUNIT[\"metre\",1.0]],"
				+ "ID[\"EPSG\",16123]],CS[Cartesian,2,ID[\"EPSG\",4400]],"
				+ "AXIS[\"Easting (E)\",east],AXIS[\"Northing (N)\",north],"
				+ "LENGTHUNIT[\"metre\",1,ID[\"EPSG\",9001]],ID[\"EPSG\",4071]]";

		String expected = "+proj=utm +zone=23 +south +ellps=intl +towgs84=-134,229,-29,0,0,0,0 +units=m +no_defs";
		assertEquals(expected, ProjParser.paramsText(definition));

		definition = "PROJCS[\"Chua / UTM zone 23S\"," + "GEOGCS[\"Chua\","
				+ "DATUM[\"Chua\","
				+ "SPHEROID[\"International 1924\",6378388,297,"
				+ "AUTHORITY[\"EPSG\",\"7022\"]],"
				+ "TOWGS84[-134,229,-29,0,0,0,0],"
				+ "AUTHORITY[\"EPSG\",\"6224\"]]," + "PRIMEM[\"Greenwich\",0,"
				+ "AUTHORITY[\"EPSG\",\"8901\"]],"
				+ "UNIT[\"degree\",0.0174532925199433,"
				+ "AUTHORITY[\"EPSG\",\"9122\"]],"
				+ "AUTHORITY[\"EPSG\",\"4224\"]],"
				+ "PROJECTION[\"Transverse_Mercator\"],"
				+ "PARAMETER[\"latitude_of_origin\",0],"
				+ "PARAMETER[\"central_meridian\",-45],"
				+ "PARAMETER[\"scale_factor\",0.9996],"
				+ "PARAMETER[\"false_easting\",500000],"
				+ "PARAMETER[\"false_northing\",10000000],"
				+ "UNIT[\"metre\",1," + "AUTHORITY[\"EPSG\",\"9001\"]],"
				+ "AXIS[\"Easting\",EAST]," + "AXIS[\"Northing\",NORTH],"
				+ "AUTHORITY[\"EPSG\",\"4071\"]]";

		expected = "+proj=utm +zone=23 +south +ellps=intl +towgs84=-134,229,-29,0,0,0,0 +units=m +no_defs";
		assertEquals(expected, ProjParser.paramsText(definition));

	}

	/**
	 * Test EPSG 4326
	 * 
	 * @throws IOException
	 *             upon error
	 */
	@Test
	public void test4326() throws IOException {

		// +proj=longlat +datum=WGS84 +no_defs

		String definition = "GEOGCRS[\"WGS 84\",ENSEMBLE[\"World Geodetic System 1984 ensemble\","
				+ "MEMBER[\"World Geodetic System 1984 (Transit)\",ID[\"EPSG\",1166]],"
				+ "MEMBER[\"World Geodetic System 1984 (G730)\",ID[\"EPSG\",1152]],"
				+ "MEMBER[\"World Geodetic System 1984 (G873)\",ID[\"EPSG\",1153]],"
				+ "MEMBER[\"World Geodetic System 1984 (G1150)\",ID[\"EPSG\",1154]],"
				+ "MEMBER[\"World Geodetic System 1984 (G1674)\",ID[\"EPSG\",1155]],"
				+ "MEMBER[\"World Geodetic System 1984 (G1762)\",ID[\"EPSG\",1156]],"
				+ "ELLIPSOID[\"WGS 84\",6378137,298.257223563,ID[\"EPSG\",7030]],"
				+ "ENSEMBLEACCURACY[2],ID[\"EPSG\",6326]],"
				+ "CS[ellipsoidal,2,ID[\"EPSG\",6422]],"
				+ "AXIS[\"Geodetic latitude (Lat)\",north],AXIS[\"Geodetic longitude (Lon)\",east],"
				+ "ANGLEUNIT[\"degree\",0.0174532925199433,ID[\"EPSG\",9102]],"
				+ "ID[\"EPSG\",4326]]";

		String expected = "+proj=longlat +datum=WGS84 +no_defs";
		assertEquals(expected, ProjParser.paramsText(definition));

		definition = "GEOGCS[\"WGS 84\",DATUM[\"WGS_1984\","
				+ "SPHEROID[\"WGS 84\",6378137,298.257223563,"
				+ "AUTHORITY[\"EPSG\",\"7030\"]],"
				+ "AUTHORITY[\"EPSG\",\"6326\"]],"
				+ "PRIMEM[\"Greenwich\",0,AUTHORITY[\"EPSG\",\"8901\"]],"
				+ "UNIT[\"degree\",0.01745329251994328,"
				+ "AUTHORITY[\"EPSG\",\"9122\"]],"
				+ "AUTHORITY[\"EPSG\",\"4326\"]]";

		expected = "+proj=longlat +datum=WGS84 +no_defs";
		assertEquals(expected, ProjParser.paramsText(definition));

		definition = "GEOGCS[\"WGS 84\",DATUM[\"WGS_1984\","
				+ "SPHEROID[\"WGS84\",6378137,298.257223563]],"
				+ "PRIMEM[\"Greenwich\",0],"
				+ "UNIT[\"degree\",0.0174532925199433]]";

		expected = "+proj=longlat +datum=WGS84 +no_defs";
		assertEquals(expected, ProjParser.paramsText(definition));

	}

	/**
	 * Test EPSG 4979
	 * 
	 * @throws IOException
	 *             upon error
	 */
	@Test
	public void test4979() throws IOException {

		// +proj=longlat +ellps=WGS84 +datum=WGS84 +no_defs

		String definition = "GEOGCRS[\"WGS 84\",ENSEMBLE[\"World Geodetic System 1984 ensemble\","
				+ "MEMBER[\"World Geodetic System 1984 (Transit)\",ID[\"EPSG\",1166]],"
				+ "MEMBER[\"World Geodetic System 1984 (G730)\",ID[\"EPSG\",1152]],"
				+ "MEMBER[\"World Geodetic System 1984 (G873)\",ID[\"EPSG\",1153]],"
				+ "MEMBER[\"World Geodetic System 1984 (G1150)\",ID[\"EPSG\",1154]],"
				+ "MEMBER[\"World Geodetic System 1984 (G1674)\",ID[\"EPSG\",1155]],"
				+ "MEMBER[\"World Geodetic System 1984 (G1762)\",ID[\"EPSG\",1156]],"
				+ "ELLIPSOID[\"WGS 84\",6378137,298.257223563,ID[\"EPSG\",7030]],"
				+ "ENSEMBLEACCURACY[2],ID[\"EPSG\",6326]],"
				+ "CS[ellipsoidal,3,ID[\"EPSG\",6423]],"
				+ "AXIS[\"Geodetic latitude (Lat)\",north,ANGLEUNIT[\"degree\",0.0174532925199433,ID[\"EPSG\",9102]]],"
				+ "AXIS[\"Geodetic longitude (Lon)\",east,ANGLEUNIT[\"degree\",0.0174532925199433,ID[\"EPSG\",9102]]],"
				+ "AXIS[\"Ellipsoidal height (h)\",up,LENGTHUNIT[\"metre\",1,ID[\"EPSG\",9001]]],ID[\"EPSG\",4979]]";

		String expected = "+proj=longlat +datum=WGS84 +no_defs";
		assertEquals(expected, ProjParser.paramsText(definition));

		definition = "GEOGCS[\"WGS 84\","
				+ "DATUM[\"World Geodetic System 1984\","
				+ "SPHEROID[\"WGS 84\",6378137.0,298.257223563,"
				+ "AUTHORITY[\"EPSG\",\"7030\"]],"
				+ "AUTHORITY[\"EPSG\",\"6326\"]],"
				+ "PRIMEM[\"Greenwich\",0.0,AUTHORITY[\"EPSG\",\"8901\"]],"
				+ "UNIT[\"degree\",0.017453292519943295],"
				+ "AXIS[\"Geodetic latitude\",NORTH],"
				+ "AXIS[\"Geodetic longitude\",EAST],"
				+ "AXIS[\"Ellipsoidal height\",UP],"
				+ "AUTHORITY[\"EPSG\",\"4979\"]]";

		expected = "+proj=longlat +datum=WGS84 +no_defs";
		assertEquals(expected, ProjParser.paramsText(definition));

		definition = "GEODCRS[\"WGS 84\",DATUM[\"World Geodetic System 1984\","
				+ "ELLIPSOID[\"WGS 84\",6378137,298.257223563,"
				+ "LENGTHUNIT[\"metre\",1.0]]],CS[ellipsoidal,3],"
				+ "AXIS[\"Geodetic latitude (Lat)\",north,"
				+ "ANGLEUNIT[\"degree\",0.0174532925199433]],"
				+ "AXIS[\"Geodetic longitude (Long)\",east,"
				+ "ANGLEUNIT[\"degree\",0.0174532925199433]],"
				+ "AXIS[\"Ellipsoidal height (h)\",up,"
				+ "LENGTHUNIT[\"metre\",1.0]],ID[\"EPSG\",4979]]";

		expected = "+proj=longlat +datum=WGS84 +no_defs";
		assertEquals(expected, ProjParser.paramsText(definition));

	}

	/**
	 * Test EPSG 5041
	 * 
	 * @throws IOException
	 *             upon error
	 */
	@Test
	public void test5041() throws IOException {

		// +proj=stere +lat_0=90 +lat_ts=90 +lon_0=0 +k=0.994 +x_0=2000000
		// +y_0=2000000 +datum=WGS84 +units=m +no_defs

		String definition = "PROJCRS[\"WGS 84 / UPS North (E,N)\",BASEGEOGCRS[\"WGS 84\","
				+ "ENSEMBLE[\"World Geodetic System 1984 ensemble\","
				+ "MEMBER[\"World Geodetic System 1984 (Transit)\",ID[\"EPSG\",1166]],"
				+ "MEMBER[\"World Geodetic System 1984 (G730)\",ID[\"EPSG\",1152]],"
				+ "MEMBER[\"World Geodetic System 1984 (G873)\",ID[\"EPSG\",1153]],"
				+ "MEMBER[\"World Geodetic System 1984 (G1150)\",ID[\"EPSG\",1154]],"
				+ "MEMBER[\"World Geodetic System 1984 (G1674)\",ID[\"EPSG\",1155]],"
				+ "MEMBER[\"World Geodetic System 1984 (G1762)\",ID[\"EPSG\",1156]],"
				+ "ELLIPSOID[\"WGS 84\",6378137,298.257223563,ID[\"EPSG\",7030]],"
				+ "ENSEMBLEACCURACY[2],ID[\"EPSG\",6326]],ID[\"EPSG\",4326]],"
				+ "CONVERSION[\"Universal Polar Stereographic North\","
				+ "METHOD[\"Polar Stereographic (variant A)\",ID[\"EPSG\",9810]],"
				+ "PARAMETER[\"Latitude of natural origin\",90,ANGLEUNIT[\"degree\",0.0174532925199433,ID[\"EPSG\",9102]]],"
				+ "PARAMETER[\"Longitude of natural origin\",0,ANGLEUNIT[\"degree\",0.0174532925199433,ID[\"EPSG\",9102]]],"
				+ "PARAMETER[\"Scale factor at natural origin\",0.994,SCALEUNIT[\"unity\",1,ID[\"EPSG\",9201]]],"
				+ "PARAMETER[\"False easting\",2000000,LENGTHUNIT[\"metre\",1,ID[\"EPSG\",9001]]],"
				+ "PARAMETER[\"False northing\",2000000,LENGTHUNIT[\"metre\",1,ID[\"EPSG\",9001]]],"
				+ "ID[\"EPSG\",16061]],CS[Cartesian,2,ID[\"EPSG\",1026]],"
				+ "AXIS[\"Easting (E)\",South,MERIDIAN[90.0,ANGLEUNIT[\"degree\",0.0174532925199433]]],"
				+ "AXIS[\"Northing (N)\",South,MERIDIAN[180.0,ANGLEUNIT[\"degree\",0.0174532925199433]]],"
				+ "LENGTHUNIT[\"metre\",1,ID[\"EPSG\",9001]],ID[\"EPSG\",5041]]";

		String expected = "+proj=stere +lat_0=90 +lat_ts=90 +lon_0=0 +k_0=0.994 +x_0=2000000 +y_0=2000000 +datum=WGS84 +units=m +no_defs";
		assertEquals(expected, ProjParser.paramsText(definition));

		definition = "PROJCS[\"WGS 84 / UPS North (E,N)\","
				+ "GEOGCS[\"WGS 84\",DATUM[\"WGS_1984\","
				+ "SPHEROID[\"WGS 84\",6378137,298.257223563,"
				+ "AUTHORITY[\"EPSG\",\"7030\"]],"
				+ "AUTHORITY[\"EPSG\",\"6326\"]],"
				+ "PRIMEM[\"Greenwich\",0,AUTHORITY[\"EPSG\",\"8901\"]],"
				+ "UNIT[\"degree\",0.0174532925199433,"
				+ "AUTHORITY[\"EPSG\",\"9122\"]],"
				+ "AUTHORITY[\"EPSG\",\"4326\"]],"
				+ "PROJECTION[\"Polar_Stereographic\"],"
				+ "PARAMETER[\"latitude_of_origin\",90],"
				+ "PARAMETER[\"central_meridian\",0],"
				+ "PARAMETER[\"scale_factor\",0.994],"
				+ "PARAMETER[\"false_easting\",2000000],"
				+ "PARAMETER[\"false_northing\",2000000],"
				+ "UNIT[\"metre\",1,AUTHORITY[\"EPSG\",\"9001\"]],"
				+ "AXIS[\"Easting\",EAST],AXIS[\"Northing\",NORTH],"
				+ "AUTHORITY[\"EPSG\",\"5041\"]]";

		expected = "+proj=stere +lat_0=90 +lat_ts=90 +lon_0=0 +k_0=0.994 +x_0=2000000 +y_0=2000000 +datum=WGS84 +units=m +no_defs";
		assertEquals(expected, ProjParser.paramsText(definition));

		definition = "PROJCRS[\"WGS 84 / UPS North (E,N)\","
				+ "BASEGEODCRS[\"WGS 84\","
				+ "DATUM[\"World Geodetic System 1984\","
				+ "ELLIPSOID[\"WGS 84\",6378137,298.257223563,"
				+ "LENGTHUNIT[\"metre\",1.0]]]],"
				+ "CONVERSION[\"Universal Polar Stereographic North\","
				+ "METHOD[\"Polar Stereographic (variant A)\",ID[\"EPSG\",\"9810\"]],"
				+ "PARAMETER[\"Latitude of natural origin\",90,"
				+ "ANGLEUNIT[\"degree\",0.0174532925199433]],"
				+ "PARAMETER[\"Longitude of natural origin\",0,"
				+ "ANGLEUNIT[\"degree\",0.0174532925199433]],"
				+ "PARAMETER[\"Scale factor at natural origin\",0.994,"
				+ "SCALEUNIT[\"unity\",1.0]],"
				+ "PARAMETER[\"False easting\",2000000,"
				+ "LENGTHUNIT[\"metre\",1.0]],"
				+ "PARAMETER[\"False northing\",2000000,"
				+ "LENGTHUNIT[\"metre\",1.0]],ID[\"EPSG\",\"16061\"]],"
				+ "CS[Cartesian,2],AXIS[\"Easting (E)\",south,"
				+ "MERIDIAN[90,ANGLEUNIT[\"degree\",0.0174532925199433]],"
				+ "ORDER[1]],AXIS[\"Northing (N)\",south,"
				+ "MERIDIAN[180,ANGLEUNIT[\"degree\",0.0174532925199433]],"
				+ "ORDER[2]],LENGTHUNIT[\"metre\",1.0],"
				+ "ID[\"EPSG\",\"5041\"]]";

		expected = "+proj=stere +lat_0=90 +lat_ts=90 +lon_0=0 +k_0=0.994 +x_0=2000000 +y_0=2000000 +datum=WGS84 +units=m +no_defs";
		assertEquals(expected, ProjParser.paramsText(definition));

	}

	/**
	 * Test EPSG 5042
	 * 
	 * @throws IOException
	 *             upon error
	 */
	@Test
	public void test5042() throws IOException {

		// +proj=stere +lat_0=-90 +lat_ts=-90 +lon_0=0 +k=0.994 +x_0=2000000
		// +y_0=2000000 +datum=WGS84 +units=m +no_defs

		String definition = "PROJCRS[\"WGS 84 / UPS South (E,N)\",BASEGEOGCRS[\"WGS 84\","
				+ "ENSEMBLE[\"World Geodetic System 1984 ensemble\","
				+ "MEMBER[\"World Geodetic System 1984 (Transit)\",ID[\"EPSG\",1166]],"
				+ "MEMBER[\"World Geodetic System 1984 (G730)\",ID[\"EPSG\",1152]],"
				+ "MEMBER[\"World Geodetic System 1984 (G873)\",ID[\"EPSG\",1153]],"
				+ "MEMBER[\"World Geodetic System 1984 (G1150)\",ID[\"EPSG\",1154]],"
				+ "MEMBER[\"World Geodetic System 1984 (G1674)\",ID[\"EPSG\",1155]],"
				+ "MEMBER[\"World Geodetic System 1984 (G1762)\",ID[\"EPSG\",1156]],"
				+ "ELLIPSOID[\"WGS 84\",6378137,298.257223563,ID[\"EPSG\",7030]],"
				+ "ENSEMBLEACCURACY[2],ID[\"EPSG\",6326]],ID[\"EPSG\",4326]],"
				+ "CONVERSION[\"Universal Polar Stereographic South\","
				+ "METHOD[\"Polar Stereographic (variant A)\",ID[\"EPSG\",9810]],"
				+ "PARAMETER[\"Latitude of natural origin\",-90,ANGLEUNIT[\"degree\",0.0174532925199433,ID[\"EPSG\",9102]]],"
				+ "PARAMETER[\"Longitude of natural origin\",0,ANGLEUNIT[\"degree\",0.0174532925199433,ID[\"EPSG\",9102]]],"
				+ "PARAMETER[\"Scale factor at natural origin\",0.994,SCALEUNIT[\"unity\",1,ID[\"EPSG\",9201]]],"
				+ "PARAMETER[\"False easting\",2000000,LENGTHUNIT[\"metre\",1,ID[\"EPSG\",9001]]],"
				+ "PARAMETER[\"False northing\",2000000,LENGTHUNIT[\"metre\",1,ID[\"EPSG\",9001]]],"
				+ "ID[\"EPSG\",16161]],CS[Cartesian,2,ID[\"EPSG\",1027]],"
				+ "AXIS[\"Easting (E)\",North,MERIDIAN[90.0,ANGLEUNIT[\"degree\",0.0174532925199433]]],"
				+ "AXIS[\"Northing (N)\",North,MERIDIAN[0.0,ANGLEUNIT[\"degree\",0.0174532925199433]]],"
				+ "LENGTHUNIT[\"metre\",1,ID[\"EPSG\",9001]],ID[\"EPSG\",5042]]";

		String expected = "+proj=stere +lat_0=-90 +lat_ts=-90 +lon_0=0 +k_0=0.994 +x_0=2000000 +y_0=2000000 +datum=WGS84 +units=m +no_defs";
		assertEquals(expected, ProjParser.paramsText(definition));

		definition = "PROJCS[\"WGS 84 / UPS South (E,N)\","
				+ "GEOGCS[\"WGS 84\",DATUM[\"WGS_1984\","
				+ "SPHEROID[\"WGS 84\",6378137,298.257223563,"
				+ "AUTHORITY[\"EPSG\",\"7030\"]],"
				+ "AUTHORITY[\"EPSG\",\"6326\"]],"
				+ "PRIMEM[\"Greenwich\",0,AUTHORITY[\"EPSG\",\"8901\"]],"
				+ "UNIT[\"degree\",0.0174532925199433,"
				+ "AUTHORITY[\"EPSG\",\"9122\"]],"
				+ "AUTHORITY[\"EPSG\",\"4326\"]],"
				+ "PROJECTION[\"Polar_Stereographic\"],"
				+ "PARAMETER[\"latitude_of_origin\",-90],"
				+ "PARAMETER[\"central_meridian\",0],"
				+ "PARAMETER[\"scale_factor\",0.994],"
				+ "PARAMETER[\"false_easting\",2000000],"
				+ "PARAMETER[\"false_northing\",2000000],"
				+ "UNIT[\"metre\",1,AUTHORITY[\"EPSG\",\"9001\"]],"
				+ "AXIS[\"Easting\",EAST],AXIS[\"Northing\",NORTH],"
				+ "AUTHORITY[\"EPSG\",\"5042\"]]";

		expected = "+proj=stere +lat_0=-90 +lat_ts=-90 +lon_0=0 +k_0=0.994 +x_0=2000000 +y_0=2000000 +datum=WGS84 +units=m +no_defs";
		assertEquals(expected, ProjParser.paramsText(definition));

		definition = "PROJCRS[\"WGS 84 / UPS South (E,N)\","
				+ "BASEGEODCRS[\"WGS 84\","
				+ "DATUM[\"World Geodetic System 1984\","
				+ "ELLIPSOID[\"WGS 84\",6378137,298.257223563,"
				+ "LENGTHUNIT[\"metre\",1.0]]]],"
				+ "CONVERSION[\"Universal Polar Stereographic North\","
				+ "METHOD[\"Polar Stereographic (variant A)\",ID[\"EPSG\",\"9810\"]],"
				+ "PARAMETER[\"Latitude of natural origin\",-90,"
				+ "ANGLEUNIT[\"degree\",0.0174532925199433]],"
				+ "PARAMETER[\"Longitude of natural origin\",0,"
				+ "ANGLEUNIT[\"degree\",0.0174532925199433]],"
				+ "PARAMETER[\"Scale factor at natural origin\",0.994,"
				+ "SCALEUNIT[\"unity\",1.0]],"
				+ "PARAMETER[\"False easting\",2000000,"
				+ "LENGTHUNIT[\"metre\",1.0]],"
				+ "PARAMETER[\"False northing\",2000000,"
				+ "LENGTHUNIT[\"metre\",1.0]],ID[\"EPSG\",\"16161\"]],"
				+ "CS[Cartesian,2],AXIS[\"Easting (E)\",north,"
				+ "MERIDIAN[90,ANGLEUNIT[\"degree\",0.0174532925199433]],"
				+ "ORDER[1]],AXIS[\"Northing (N)\",north,"
				+ "MERIDIAN[0,ANGLEUNIT[\"degree\",0.0174532925199433]],"
				+ "ORDER[2]],LENGTHUNIT[\"metre\",1.0],"
				+ "ID[\"EPSG\",\"5042\"]]";

		expected = "+proj=stere +lat_0=-90 +lat_ts=-90 +lon_0=0 +k_0=0.994 +x_0=2000000 +y_0=2000000 +datum=WGS84 +units=m +no_defs";
		assertEquals(expected, ProjParser.paramsText(definition));

	}

	/**
	 * Test EPSG 5472
	 * 
	 * @throws IOException
	 *             upon error
	 */
	@Test
	public void test5472() throws IOException {

		// +proj=poly +lat_0=8.25 +lon_0=-81 +x_0=914391.7962
		// +y_0=999404.7217154861 +ellps=clrk66 +to_meter=0.9143917962 +no_defs

		String definition = "PROJCRS[\"Panama-Colon 1911 / Panama Polyconic\",BASEGEOGCRS[\"Panama-Colon 1911\","
				+ "DATUM[\"Panama-Colon 1911\","
				+ "ELLIPSOID[\"Clarke 1866\",6378206.4,294.9786982,LENGTHUNIT[\"metre\",1,ID[\"EPSG\",9001]],ID[\"EPSG\",7008]],"
				+ "ID[\"EPSG\",1072]],ID[\"EPSG\",5467]],"
				+ "CONVERSION[\"Panama Polyconic\",METHOD[\"American Polyconic\",ID[\"EPSG\",9818]],"
				+ "PARAMETER[\"Latitude of natural origin\",8.25,ANGLEUNIT[\"degree\",0.0174532925199433,ID[\"EPSG\",9102]]],"
				+ "PARAMETER[\"Longitude of natural origin\",-81,ANGLEUNIT[\"degree\",0.0174532925199433,ID[\"EPSG\",9102]]],"
				+ "PARAMETER[\"False easting\",1000000,LENGTHUNIT[\"Clarke's yard\",0.9143917962,ID[\"EPSG\",9037]]],"
				+ "PARAMETER[\"False northing\",1092972.1,LENGTHUNIT[\"Clarke's yard\",0.9143917962,ID[\"EPSG\",9037]]],"
				+ "ID[\"EPSG\",5471]],"
				+ "CS[Cartesian,2,ID[\"EPSG\",1028]],AXIS[\"Easting (E)\",east],AXIS[\"Northing (N)\",north],"
				+ "LENGTHUNIT[\"Clarke's yard\",0.9143917962,ID[\"EPSG\",9037]],ID[\"EPSG\",5472]]";

		String expected = "+proj=poly +lat_0=8.25 +lon_0=-81 +x_0=914391.7962 +y_0=999404.7217154861 +ellps=clrk66 +to_meter=0.9143917962 +no_defs";
		assertEquals(expected, ProjParser.paramsText(definition));

		definition = "PROJCS[\"Panama-Colon 1911 / Panama Polyconic\","
				+ "GEOGCS[\"Panama-Colon 1911\","
				+ "DATUM[\"Panama_Colon_1911\","
				+ "SPHEROID[\"Clarke 1866\",6378206.4,294.9786982139006,"
				+ "AUTHORITY[\"EPSG\",\"7008\"]],"
				+ "AUTHORITY[\"EPSG\",\"1072\"]]," + "PRIMEM[\"Greenwich\",0,"
				+ "AUTHORITY[\"EPSG\",\"8901\"]],"
				+ "UNIT[\"degree\",0.0174532925199433,"
				+ "AUTHORITY[\"EPSG\",\"9122\"]],"
				+ "AUTHORITY[\"EPSG\",\"5467\"]],"
				+ "PROJECTION[\"Polyconic\"],"
				+ "PARAMETER[\"latitude_of_origin\",8.25],"
				+ "PARAMETER[\"central_meridian\",-81],"
				+ "PARAMETER[\"false_easting\",1000000],"
				+ "PARAMETER[\"false_northing\",1092972.1],"
				+ "UNIT[\"Clarke's yard\",0.9143917962,"
				+ "AUTHORITY[\"EPSG\",\"9037\"]]," + "AXIS[\"Easting\",EAST],"
				+ "AXIS[\"Northing\",NORTH]," + "AUTHORITY[\"EPSG\",\"5472\"]]";

		expected = "+proj=poly +lat_0=8.25 +lon_0=-81 +x_0=914391.7962 +y_0=999404.7217154861 +ellps=clrk66 +to_meter=0.9143917962 +no_defs";
		assertEquals(expected, ProjParser.paramsText(definition));

	}

	/**
	 * Test EPSG 7405
	 * 
	 * @throws IOException
	 *             upon error
	 */
	@Test
	public void test7405() throws IOException {

		// 27700:
		// +proj=tmerc +lat_0=49 +lon_0=-2 +k=0.9996012717 +x_0=400000
		// +y_0=-100000 +datum=OSGB36 +units=m +no_defs

		String definition = "COMPOUNDCRS[\"OSGB36 / British National Grid + ODN height\","
				+ "PROJCRS[\"OSGB36 / British National Grid\",BASEGEOGCRS[\"OSGB36\","
				+ "DATUM[\"Ordnance Survey of Great Britain 1936\","
				+ "ELLIPSOID[\"Airy 1830\",6377563.396,299.3249646,LENGTHUNIT[\"metre\",1,ID[\"EPSG\",9001]],"
				+ "ID[\"EPSG\",7001]],ID[\"EPSG\",6277]],ID[\"EPSG\",4277]],"
				+ "CONVERSION[\"British National Grid\",METHOD[\"Transverse Mercator\",ID[\"EPSG\",9807]],"
				+ "PARAMETER[\"Latitude of natural origin\",49,ANGLEUNIT[\"degree\",0.0174532925199433,ID[\"EPSG\",9102]]],"
				+ "PARAMETER[\"Longitude of natural origin\",-2,ANGLEUNIT[\"degree\",0.0174532925199433,ID[\"EPSG\",9102]]],"
				+ "PARAMETER[\"Scale factor at natural origin\",0.9996012717,SCALEUNIT[\"unity\",1,ID[\"EPSG\",9201]]],"
				+ "PARAMETER[\"False easting\",400000,LENGTHUNIT[\"metre\",1,ID[\"EPSG\",9001]]],"
				+ "PARAMETER[\"False northing\",-100000,LENGTHUNIT[\"metre\",1,ID[\"EPSG\",9001]]],"
				+ "ID[\"EPSG\",19916]],CS[Cartesian,2,ID[\"EPSG\",4400]],"
				+ "AXIS[\"Easting (E)\",east],AXIS[\"Northing (N)\",north],"
				+ "LENGTHUNIT[\"metre\",1,ID[\"EPSG\",9001]],ID[\"EPSG\",27700]],"
				+ "VERTCRS[\"ODN height\",VDATUM[\"Ordnance Datum Newlyn\",ID[\"EPSG\",5101]],"
				+ "CS[vertical,1,ID[\"EPSG\",6499]],"
				+ "AXIS[\"Gravity-related height (H)\",up],"
				+ "LENGTHUNIT[\"metre\",1,ID[\"EPSG\",9001]],ID[\"EPSG\",5701]],"
				+ "ID[\"EPSG\",7405]]";

		String expected = "+proj=tmerc +lat_0=49 +lon_0=-2 +k_0=0.9996012717 +x_0=400000 +y_0=-100000 +datum=OSGB36 +units=m +no_defs";
		assertEquals(expected, ProjParser.paramsText(definition));

		definition = "COMPD_CS[\"OSGB 1936 / British National Grid + ODN height\","
				+ "PROJCS[\"OSGB 1936 / British National Grid\",GEOGCS[\"OSGB 1936\","
				+ "DATUM[\"OSGB_1936\","
				+ "SPHEROID[\"Airy 1830\",6377563.396,299.3249646,"
				+ "AUTHORITY[\"EPSG\",\"7001\"]],"
				+ "TOWGS84[446.448,-125.157,542.06,0.15,0.247,0.842,-20.489],AUTHORITY[\"EPSG\",\"6277\"]],"
				+ "PRIMEM[\"Greenwich\",0,AUTHORITY[\"EPSG\",\"8901\"]],"
				+ "UNIT[\"degree\",0.0174532925199433,"
				+ "AUTHORITY[\"EPSG\",\"9122\"]],"
				+ "AUTHORITY[\"EPSG\",\"4277\"]],"
				+ "PROJECTION[\"Transverse_Mercator\"],"
				+ "PARAMETER[\"latitude_of_origin\",49],"
				+ "PARAMETER[\"central_meridian\",-2],"
				+ "PARAMETER[\"scale_factor\",0.9996012717],"
				+ "PARAMETER[\"false_easting\",400000],"
				+ "PARAMETER[\"false_northing\",-100000],"
				+ "UNIT[\"metre\",1,AUTHORITY[\"EPSG\",\"9001\"]],"
				+ "AXIS[\"Easting\",EAST],AXIS[\"Northing\",NORTH],"
				+ "AUTHORITY[\"EPSG\",\"27700\"]],"
				+ "VERT_CS[\"ODN height\",VERT_DATUM[\"Ordnance Datum Newlyn\",2005,"
				+ "AUTHORITY[\"EPSG\",\"5101\"]],"
				+ "UNIT[\"metre\",1,AUTHORITY[\"EPSG\",\"9001\"]],"
				+ "AXIS[\"Up\",UP],AUTHORITY[\"EPSG\",\"5701\"]],"
				+ "AUTHORITY[\"EPSG\",\"7405\"]]";

		expected = "+proj=tmerc +lat_0=49 +lon_0=-2 +k_0=0.9996012717 +x_0=400000 +y_0=-100000 +datum=OSGB36 +towgs84=446.448,-125.157,542.06,0.15,0.247,0.842,-20.489 +units=m +no_defs";
		assertEquals(expected, ProjParser.paramsText(definition));

	}

	/**
	 * Test NGA 8101
	 * 
	 * @throws IOException
	 *             upon error
	 */
	@Test
	public void test8101() throws IOException {

		// 4326:
		// +proj=longlat +datum=WGS84 +no_defs

		String definition = "COMPOUNDCRS[“WGS84 Height (EGM08)”,"
				+ "GEODCRS[\"WGS 84\","
				+ "DATUM[\"World Geodetic System 1984\","
				+ "ELLIPSOID[\"WGS 84\",6378137,298.257223563,LENGTHUNIT[\"metre\",1.0]]],"
				+ "CS[ellipsoidal,2],"
				+ "AXIS[\"Geodetic latitude (Lat)\",north],"
				+ "AXIS[\"Geodetic longitude (Long)\",east],"
				+ "ANGLEUNIT[\"degree\",0.0174532925199433],ID[\"EPSG\",4326]],"
				+ "VERTCRS[\"EGM2008 geoid height\","
				+ "VDATUM[\"EGM2008 geoid\",ANCHOR[\"WGS 84 ellipsoid\"]],"
				+ "CS[vertical,1],AXIS[\"Gravity-related height (H)\",up],"
				+ "LENGTHUNIT[\"metre\",1.0]ID[\"EPSG\",\"3855\"]],"
				+ "ID[“NSG”,”8101”]]";

		String expected = "+proj=longlat +datum=WGS84 +no_defs";
		assertEquals(expected, ProjParser.paramsText(definition));

	}

	/**
	 * Test EPSG 9801
	 * 
	 * @throws IOException
	 *             upon error
	 */
	@Test
	public void test9801() throws IOException {

		String definition = "PROJCS[\"Lambert_Conformal_Conic (1SP)\","
				+ "GEODCRS[\"GCS_North_American_1983\","
				+ "DATUM[\"North_American_Datum_1983\","
				+ "SPHEROID[\"GRS_1980\",6371000,0]],"
				+ "PRIMEM[\"Greenwich\",0],"
				+ "UNIT[\"Degree\",0.017453292519943295]],"
				+ "PROJECTION[\"Lambert_Conformal_Conic_1SP\"],"
				+ "PARAMETER[\"latitude_of_origin\",25],"
				+ "PARAMETER[\"central_meridian\",-95],"
				+ "PARAMETER[\"scale_factor\",1],"
				+ "PARAMETER[\"false_easting\",0],"
				+ "PARAMETER[\"false_northing\",0],"
				+ "PARAMETER[\"standard_parallel_1\",25],"
				+ "UNIT[\"Meter\",1],AUTHORITY[\"EPSG\",\"9801\"]]";

		String expected = "+proj=lcc +lat_1=25 +lat_0=25 +lon_0=-95 +k_0=1 +x_0=0 +y_0=0 +datum=NAD83 +units=m +no_defs";
		assertEquals(expected, ProjParser.paramsText(definition));

	}

	/**
	 * Test EPSG 9802
	 * 
	 * @throws IOException
	 *             upon error
	 */
	@Test
	public void test9802() throws IOException {

		String definition = "PROJCS[\"Lambert Conic Conformal (2SP)\","
				+ "GEODCRS[\"GCS_North_American_1983\","
				+ "DATUM[\"North_American_Datum_1983\","
				+ "SPHEROID[\"GRS_1980\",6378160,298.2539162964695]],"
				+ "PRIMEM[\"Greenwich\",0],"
				+ "UNIT[\"degree\",0.0174532925199433]],"
				+ "PROJECTION[\"Lambert_Conformal_Conic_2SP\"],"
				+ "PARAMETER[\"standard_parallel_1\",30],"
				+ "PARAMETER[\"standard_parallel_2\",60],"
				+ "PARAMETER[\"latitude_of_origin\",30],"
				+ "PARAMETER[\"central_meridian\",126],"
				+ "PARAMETER[\"false_easting\",0],"
				+ "PARAMETER[\"false_northing\",0],"
				+ "AUTHORITY[\"EPSG\",\"9802\"]]";

		String expected = "+proj=lcc +lat_1=30 +lat_2=60 +lat_0=30 +lon_0=126 +x_0=0 +y_0=0 +datum=NAD83 +no_defs";
		assertEquals(expected, ProjParser.paramsText(definition));

	}

	/**
	 * Test EPSG 21780
	 * 
	 * @throws IOException
	 *             upon error
	 */
	@Test
	public void test21780() throws IOException {

		// +proj=somerc +lat_0=46.95240555555556 +lon_0=0 +k_0=1 +x_0=0 +y_0=0
		// +ellps=bessel +towgs84=674.4,15.1,405.3,0,0,0,0 +pm=bern +units=m
		// +no_defs

		String definition = "PROJCRS[\"Bern 1898 (Bern) / LV03C\",BASEGEOGCRS[\"Bern 1898 (Bern)\","
				+ "DATUM[\"CH1903 (Bern)\","
				+ "ELLIPSOID[\"Bessel 1841\",6377397.155,299.1528128,LENGTHUNIT[\"metre\",1,ID[\"EPSG\",9001]],ID[\"EPSG\",7004]],ID[\"EPSG\",6801]],"
				+ "PRIMEM[\"Bern\",7.439583333,ANGLEUNIT[\"degree\",0.0174532925199433,ID[\"EPSG\",9102]],ID[\"EPSG\",8907]],ID[\"EPSG\",4801]],"
				+ "CONVERSION[\"Swiss Oblique Mercator 1903C\",METHOD[\"Hotine Oblique Mercator (variant B)\",ID[\"EPSG\",9815]],"
				+ "PARAMETER[\"Latitude of projection centre\",46.952405556,ANGLEUNIT[\"degree\",0.0174532925199433,ID[\"EPSG\",9102]]],"
				+ "PARAMETER[\"Longitude of projection centre\",0,ANGLEUNIT[\"degree\",0.0174532925199433,ID[\"EPSG\",9102]]],"
				+ "PARAMETER[\"Azimuth of initial line\",90,ANGLEUNIT[\"degree\",0.0174532925199433,ID[\"EPSG\",9102]]],"
				+ "PARAMETER[\"Angle from Rectified to Skew Grid\",90,ANGLEUNIT[\"degree\",0.0174532925199433,ID[\"EPSG\",9102]]],"
				+ "PARAMETER[\"Scale factor on initial line\",1,SCALEUNIT[\"unity\",1,ID[\"EPSG\",9201]]],"
				+ "PARAMETER[\"Easting at projection centre\",0,LENGTHUNIT[\"metre\",1,ID[\"EPSG\",9001]]],"
				+ "PARAMETER[\"Northing at projection centre\",0,LENGTHUNIT[\"metre\",1,ID[\"EPSG\",9001]]],"
				+ "PARAMETER[\"X-axis translation\",674.4,LENGTHUNIT[\"metre\",1.0]],"
				+ "PARAMETER[\"Y-axis translation\",15.1,LENGTHUNIT[\"metre\",1.0]],"
				+ "PARAMETER[\"Z-axis translation\",405.3,LENGTHUNIT[\"metre\",1.0]],"
				+ "ID[\"EPSG\",19923]],"
				+ "CS[Cartesian,2,ID[\"EPSG\",4498]],AXIS[\"Easting (Y)\",east],AXIS[\"Northing (X)\",north],"
				+ "LENGTHUNIT[\"metre\",1,ID[\"EPSG\",9001]],ID[\"EPSG\",21780]]";

		String expected = "+proj=somerc +lat_0=46.952405556 +lon_0=0 +k_0=1 +x_0=0 +y_0=0 +ellps=bessel +towgs84=674.4,15.1,405.3,0,0,0,0 +pm=bern +units=m +no_defs";
		assertEquals(expected, ProjParser.paramsText(definition));

		definition = "PROJCS[\"Bern 1898 (Bern) / LV03C\","
				+ "GEOGCS[\"Bern 1898 (Bern)\"," + "DATUM[\"CH1903_Bern\","
				+ "SPHEROID[\"Bessel 1841\",6377397.155,299.1528128,"
				+ "AUTHORITY[\"EPSG\",\"7004\"]],"
				+ "TOWGS84[674.4,15.1,405.3,0,0,0,0],"
				+ "AUTHORITY[\"EPSG\",\"6801\"]],"
				+ "PRIMEM[\"Bern\",7.439583333333333,"
				+ "AUTHORITY[\"EPSG\",\"8907\"]],"
				+ "UNIT[\"degree\",0.0174532925199433,"
				+ "AUTHORITY[\"EPSG\",\"9122\"]],"
				+ "AUTHORITY[\"EPSG\",\"4801\"]],"
				+ "PROJECTION[\"Hotine_Oblique_Mercator_Azimuth_Center\"],"
				+ "PARAMETER[\"latitude_of_center\",46.95240555555556],"
				+ "PARAMETER[\"longitude_of_center\",0],"
				+ "PARAMETER[\"azimuth\",90],"
				+ "PARAMETER[\"rectified_grid_angle\",90],"
				+ "PARAMETER[\"scale_factor\",1],"
				+ "PARAMETER[\"false_easting\",0],"
				+ "PARAMETER[\"false_northing\",0]," + "UNIT[\"metre\",1,"
				+ "AUTHORITY[\"EPSG\",\"9001\"]]," + "AXIS[\"Y\",EAST],"
				+ "AXIS[\"X\",NORTH]," + "AUTHORITY[\"EPSG\",\"21780\"]]";

		expected = "+proj=somerc +lat_0=46.95240555555556 +lon_0=0 +k_0=1 +x_0=0 +y_0=0 +ellps=bessel +towgs84=674.4,15.1,405.3,0,0,0,0 +pm=bern +units=m +no_defs";
		assertEquals(expected, ProjParser.paramsText(definition));

	}

	/**
	 * Test EPSG 22275
	 * 
	 * @throws IOException
	 *             upon error
	 */
	@Test
	public void test22275() throws IOException {

		// +proj=tmerc +lat_0=0 +lon_0=15 +k=1 +x_0=0 +y_0=0 +axis=wsu
		// +a=6378249.145 +b=6356514.966398753 +towgs84=-136,-108,-292,0,0,0,0
		// +units=m +no_defs

		String definition = "PROJCRS[\"Cape / Lo15\",BASEGEOGCRS[\"Cape\","
				+ "DATUM[\"Cape\","
				+ "ELLIPSOID[\"Clarke 1880 (Arc)\",6378249.145,293.4663077,LENGTHUNIT[\"metre\",1,ID[\"EPSG\",9001]],ID[\"EPSG\",7013]],"
				+ "ID[\"EPSG\",6222]],ID[\"EPSG\",4222]],"
				+ "CONVERSION[\"South African Survey Grid zone 15\",METHOD[\"Transverse Mercator (South Orientated)\",ID[\"EPSG\",9808]],"
				+ "PARAMETER[\"Latitude of natural origin\",0,ANGLEUNIT[\"degree\",0.0174532925199433,ID[\"EPSG\",9102]]],"
				+ "PARAMETER[\"Longitude of natural origin\",15,ANGLEUNIT[\"degree\",0.0174532925199433,ID[\"EPSG\",9102]]],"
				+ "PARAMETER[\"Scale factor at natural origin\",1,SCALEUNIT[\"unity\",1,ID[\"EPSG\",9201]]],"
				+ "PARAMETER[\"False easting\",0,LENGTHUNIT[\"metre\",1,ID[\"EPSG\",9001]]],"
				+ "PARAMETER[\"False northing\",0,LENGTHUNIT[\"metre\",1,ID[\"EPSG\",9001]]],"
				+ "PARAMETER[\"X-axis translation\",-136,LENGTHUNIT[\"metre\",1.0]],"
				+ "PARAMETER[\"Y-axis translation\",-108,LENGTHUNIT[\"metre\",1.0]],"
				+ "PARAMETER[\"Z-axis translation\",-292,LENGTHUNIT[\"metre\",1.0]],"
				+ "ID[\"EPSG\",17515]],"
				+ "CS[Cartesian,2,ID[\"EPSG\",6503]],AXIS[\"Westing (Y)\",west],AXIS[\"Southing (X)\",south],"
				+ "LENGTHUNIT[\"metre\",1,ID[\"EPSG\",9001]],ID[\"EPSG\",22275]]";

		String expected = "+proj=tmerc +lat_0=0 +lon_0=15 +k_0=1 +x_0=0 +y_0=0 +axis=wsu +a=6378249.145 +b=6356514.966398753 +towgs84=-136,-108,-292,0,0,0,0 +units=m +no_defs";
		assertEquals(expected, ProjParser.paramsText(definition));

		definition = "PROJCS[\"Cape / Lo15\"," + "GEOGCS[\"Cape\","
				+ "DATUM[\"Cape\","
				+ "SPHEROID[\"Clarke 1880 (Arc)\",6378249.145,293.4663077,"
				+ "AUTHORITY[\"EPSG\",\"7013\"]],"
				+ "TOWGS84[-136,-108,-292,0,0,0,0],"
				+ "AUTHORITY[\"EPSG\",\"6222\"]]," + "PRIMEM[\"Greenwich\",0,"
				+ "AUTHORITY[\"EPSG\",\"8901\"]],"
				+ "UNIT[\"degree\",0.0174532925199433,"
				+ "AUTHORITY[\"EPSG\",\"9122\"]],"
				+ "AUTHORITY[\"EPSG\",\"4222\"]],"
				+ "PROJECTION[\"Transverse_Mercator_South_Orientated\"],"
				+ "PARAMETER[\"latitude_of_origin\",0],"
				+ "PARAMETER[\"central_meridian\",15],"
				+ "PARAMETER[\"scale_factor\",1],"
				+ "PARAMETER[\"false_easting\",0],"
				+ "PARAMETER[\"false_northing\",0]," + "UNIT[\"metre\",1,"
				+ "AUTHORITY[\"EPSG\",\"9001\"]]," + "AXIS[\"Y\",WEST],"
				+ "AXIS[\"X\",SOUTH]," + "AUTHORITY[\"EPSG\",\"22275\"]]";

		expected = "+proj=tmerc +lat_0=0 +lon_0=15 +k_0=1 +x_0=0 +y_0=0 +axis=wsu +a=6378249.145 +b=6356514.966398753 +towgs84=-136,-108,-292,0,0,0,0 +units=m +no_defs";
		assertEquals(expected, ProjParser.paramsText(definition));

	}

	/**
	 * Test EPSG 27200
	 * 
	 * @throws IOException
	 *             upon error
	 */
	@Test
	public void test27200() throws IOException {

		// +proj=nzmg +lat_0=-41 +lon_0=173 +x_0=2510000 +y_0=6023150
		// +datum=nzgd49 +units=m +no_defs

		String definition = "PROJCRS[\"NZGD49 / New Zealand Map Grid\",BASEGEOGCRS[\"NZGD49\","
				+ "DATUM[\"New Zealand Geodetic Datum 1949\","
				+ "ELLIPSOID[\"International 1924\",6378388,297,LENGTHUNIT[\"metre\",1,ID[\"EPSG\",9001]],ID[\"EPSG\",7022]],"
				+ "ID[\"EPSG\",6272]],ID[\"EPSG\",4272]],"
				+ "CONVERSION[\"New Zealand Map Grid\",METHOD[\"New Zealand Map Grid\",ID[\"EPSG\",9811]],"
				+ "PARAMETER[\"Latitude of natural origin\",-41,ANGLEUNIT[\"degree\",0.0174532925199433,ID[\"EPSG\",9102]]],"
				+ "PARAMETER[\"Longitude of natural origin\",173,ANGLEUNIT[\"degree\",0.0174532925199433,ID[\"EPSG\",9102]]],"
				+ "PARAMETER[\"False easting\",2510000,LENGTHUNIT[\"metre\",1,ID[\"EPSG\",9001]]],"
				+ "PARAMETER[\"False northing\",6023150,LENGTHUNIT[\"metre\",1,ID[\"EPSG\",9001]]],"
				+ "ID[\"EPSG\",19917]],"
				+ "CS[Cartesian,2,ID[\"EPSG\",4400]],AXIS[\"Easting (E)\",east],AXIS[\"Northing (N)\",north],"
				+ "LENGTHUNIT[\"metre\",1,ID[\"EPSG\",9001]],ID[\"EPSG\",27200]]";

		String expected = "+proj=nzmg +lat_0=-41 +lon_0=173 +x_0=2510000 +y_0=6023150 +datum=nzgd49 +units=m +no_defs";
		assertEquals(expected, ProjParser.paramsText(definition));

		definition = "PROJCS[\"NZGD49 / New Zealand Map Grid\","
				+ "GEOGCS[\"NZGD49\","
				+ "DATUM[\"New_Zealand_Geodetic_Datum_1949\","
				+ "SPHEROID[\"International 1924\",6378388,297,"
				+ "AUTHORITY[\"EPSG\",\"7022\"]],"
				+ "TOWGS84[59.47,-5.04,187.44,0.47,-0.1,1.024,-4.5993],"
				+ "AUTHORITY[\"EPSG\",\"6272\"]]," + "PRIMEM[\"Greenwich\",0,"
				+ "AUTHORITY[\"EPSG\",\"8901\"]],"
				+ "UNIT[\"degree\",0.0174532925199433,"
				+ "AUTHORITY[\"EPSG\",\"9122\"]],"
				+ "AUTHORITY[\"EPSG\",\"4272\"]],"
				+ "PROJECTION[\"New_Zealand_Map_Grid\"],"
				+ "PARAMETER[\"latitude_of_origin\",-41],"
				+ "PARAMETER[\"central_meridian\",173],"
				+ "PARAMETER[\"false_easting\",2510000],"
				+ "PARAMETER[\"false_northing\",6023150]," + "UNIT[\"metre\",1,"
				+ "AUTHORITY[\"EPSG\",\"9001\"]]," + "AXIS[\"Easting\",EAST],"
				+ "AXIS[\"Northing\",NORTH],"
				+ "AUTHORITY[\"EPSG\",\"27200\"]]";

		expected = "+proj=nzmg +lat_0=-41 +lon_0=173 +x_0=2510000 +y_0=6023150 +datum=nzgd49 +towgs84=59.47,-5.04,187.44,0.47,-0.1,1.024,-4.5993 +units=m +no_defs";
		assertEquals(expected, ProjParser.paramsText(definition));

	}

	/**
	 * Test EPSG 27258
	 * 
	 * @throws IOException
	 *             upon error
	 */
	@Test
	public void test27258() throws IOException {

		// +proj=utm +zone=58 +south +datum=nzgd49 +units=m +no_defs

		String definition = "PROJCRS[\"NZGD49 / UTM zone 58S\",BASEGEOGCRS[\"NZGD49\","
				+ "DATUM[\"New Zealand Geodetic Datum 1949\","
				+ "ELLIPSOID[\"International 1924\",6378388,297,LENGTHUNIT[\"metre\",1,ID[\"EPSG\",9001]],"
				+ "ID[\"EPSG\",7022]],ID[\"EPSG\",6272]],ID[\"EPSG\",4272]],"
				+ "CONVERSION[\"UTM zone 58S\",METHOD[\"Transverse Mercator\",ID[\"EPSG\",9807]],"
				+ "PARAMETER[\"Latitude of natural origin\",0,ANGLEUNIT[\"degree\",0.0174532925199433,ID[\"EPSG\",9102]]],"
				+ "PARAMETER[\"Longitude of natural origin\",165,ANGLEUNIT[\"degree\",0.0174532925199433,ID[\"EPSG\",9102]]],"
				+ "PARAMETER[\"Scale factor at natural origin\",0.9996,SCALEUNIT[\"unity\",1,ID[\"EPSG\",9201]]],"
				+ "PARAMETER[\"False easting\",500000,LENGTHUNIT[\"metre\",1,ID[\"EPSG\",9001]]],"
				+ "PARAMETER[\"False northing\",10000000,LENGTHUNIT[\"metre\",1,ID[\"EPSG\",9001]]],"
				+ "ID[\"EPSG\",16158]],"
				+ "CS[Cartesian,2,ID[\"EPSG\",4400]],AXIS[\"Easting (E)\",east],AXIS[\"Northing (N)\",north],"
				+ "LENGTHUNIT[\"metre\",1,ID[\"EPSG\",9001]],ID[\"EPSG\",27258]]";

		String expected = "+proj=utm +zone=58 +south +datum=nzgd49 +units=m +no_defs";
		assertEquals(expected, ProjParser.paramsText(definition));

		definition = "PROJCS[\"NZGD49 / UTM zone 58S\"," + "GEOGCS[\"NZGD49\","
				+ "DATUM[\"New_Zealand_Geodetic_Datum_1949\","
				+ "SPHEROID[\"International 1924\",6378388,297,"
				+ "AUTHORITY[\"EPSG\",\"7022\"]],"
				+ "TOWGS84[59.47,-5.04,187.44,0.47,-0.1,1.024,-4.5993],"
				+ "AUTHORITY[\"EPSG\",\"6272\"]]," + "PRIMEM[\"Greenwich\",0,"
				+ "AUTHORITY[\"EPSG\",\"8901\"]],"
				+ "UNIT[\"degree\",0.0174532925199433,"
				+ "AUTHORITY[\"EPSG\",\"9122\"]],"
				+ "AUTHORITY[\"EPSG\",\"4272\"]],"
				+ "PROJECTION[\"Transverse_Mercator\"],"
				+ "PARAMETER[\"latitude_of_origin\",0],"
				+ "PARAMETER[\"central_meridian\",165],"
				+ "PARAMETER[\"scale_factor\",0.9996],"
				+ "PARAMETER[\"false_easting\",500000],"
				+ "PARAMETER[\"false_northing\",10000000],"
				+ "UNIT[\"metre\",1," + "AUTHORITY[\"EPSG\",\"9001\"]],"
				+ "AXIS[\"Easting\",EAST]," + "AXIS[\"Northing\",NORTH],"
				+ "AUTHORITY[\"EPSG\",\"27258\"]]";

		expected = "+proj=utm +zone=58 +south +datum=nzgd49 +towgs84=59.47,-5.04,187.44,0.47,-0.1,1.024,-4.5993 +units=m +no_defs";
		assertEquals(expected, ProjParser.paramsText(definition));

	}

	/**
	 * Test EPSG 27700
	 * 
	 * @throws IOException
	 *             upon error
	 */
	@Test
	public void test27700() throws IOException {

		// +proj=tmerc +lat_0=49 +lon_0=-2 +k=0.9996012717 +x_0=400000
		// +y_0=-100000 +datum=OSGB36 +units=m +no_defs

		String definition = "PROJCRS[\"OSGB36 / British National Grid\",BASEGEOGCRS[\"OSGB36\","
				+ "DATUM[\"Ordnance Survey of Great Britain 1936\","
				+ "ELLIPSOID[\"Airy 1830\",6377563.396,299.3249646,LENGTHUNIT[\"metre\",1,ID[\"EPSG\",9001]],ID[\"EPSG\",7001]],"
				+ "ID[\"EPSG\",6277]],ID[\"EPSG\",4277]],"
				+ "CONVERSION[\"British National Grid\",METHOD[\"Transverse Mercator\",ID[\"EPSG\",9807]],"
				+ "PARAMETER[\"Latitude of natural origin\",49,ANGLEUNIT[\"degree\",0.0174532925199433,ID[\"EPSG\",9102]]],"
				+ "PARAMETER[\"Longitude of natural origin\",-2,ANGLEUNIT[\"degree\",0.0174532925199433,ID[\"EPSG\",9102]]],"
				+ "PARAMETER[\"Scale factor at natural origin\",0.999601272,SCALEUNIT[\"unity\",1,ID[\"EPSG\",9201]]],"
				+ "PARAMETER[\"False easting\",400000,LENGTHUNIT[\"metre\",1,ID[\"EPSG\",9001]]],"
				+ "PARAMETER[\"False northing\",-100000,LENGTHUNIT[\"metre\",1,ID[\"EPSG\",9001]]],"
				+ "ID[\"EPSG\",19916]],"
				+ "CS[Cartesian,2,ID[\"EPSG\",4400]],AXIS[\"Easting (E)\",east],AXIS[\"Northing (N)\",north],"
				+ "LENGTHUNIT[\"metre\",1,ID[\"EPSG\",9001]],ID[\"EPSG\",27700]]";

		String expected = "+proj=tmerc +lat_0=49 +lon_0=-2 +k_0=0.999601272 +x_0=400000 +y_0=-100000 +datum=OSGB36 +units=m +no_defs";
		assertEquals(expected, ProjParser.paramsText(definition));

		definition = "PROJCS[\"OSGB 1936 / British National Grid\","
				+ "GEOGCS[\"OSGB 1936\"," + "DATUM[\"OSGB_1936\","
				+ "SPHEROID[\"Airy 1830\",6377563.396,299.3249646,"
				+ "AUTHORITY[\"EPSG\",\"7001\"]],"
				+ "TOWGS84[446.448,-125.157,542.06,0.15,0.247,0.842,-20.489],"
				+ "AUTHORITY[\"EPSG\",\"6277\"]]," + "PRIMEM[\"Greenwich\",0,"
				+ "AUTHORITY[\"EPSG\",\"8901\"]],"
				+ "UNIT[\"degree\",0.0174532925199433,"
				+ "AUTHORITY[\"EPSG\",\"9122\"]],"
				+ "AUTHORITY[\"EPSG\",\"4277\"]],"
				+ "PROJECTION[\"Transverse_Mercator\"],"
				+ "PARAMETER[\"latitude_of_origin\",49],"
				+ "PARAMETER[\"central_meridian\",-2],"
				+ "PARAMETER[\"scale_factor\",0.9996012717],"
				+ "PARAMETER[\"false_easting\",400000],"
				+ "PARAMETER[\"false_northing\",-100000]," + "UNIT[\"metre\",1,"
				+ "AUTHORITY[\"EPSG\",\"9001\"]]," + "AXIS[\"Easting\",EAST],"
				+ "AXIS[\"Northing\",NORTH],"
				+ "AUTHORITY[\"EPSG\",\"27700\"]]";

		expected = "+proj=tmerc +lat_0=49 +lon_0=-2 +k_0=0.9996012717 +x_0=400000 +y_0=-100000 +datum=OSGB36 +towgs84=446.448,-125.157,542.06,0.15,0.247,0.842,-20.489 +units=m +no_defs";
		assertEquals(expected, ProjParser.paramsText(definition));

	}

	/**
	 * Test EPSG 28991
	 * 
	 * @throws IOException
	 *             upon error
	 */
	@Test
	public void test28991() throws IOException {

		// +proj=sterea +lat_0=52.15616055555555 +lon_0=5.38763888888889
		// +k=0.9999079 +x_0=0 +y_0=0 +ellps=bessel
		// +towgs84=565.417,50.3319,465.552,-0.398957,0.343988,-1.8774,4.0725
		// +units=m +no_defs

		String definition = "PROJCRS[\"Amersfoort / RD Old\",BASEGEOGCRS[\"Amersfoort\","
				+ "DATUM[\"Amersfoort\","
				+ "ELLIPSOID[\"Bessel 1841\",6377397.155,299.1528128,LENGTHUNIT[\"metre\",1,ID[\"EPSG\",9001]],ID[\"EPSG\",7004]],"
				+ "ID[\"EPSG\",6289]],ID[\"EPSG\",4289]],"
				+ "CONVERSION[\"RD Old\",METHOD[\"Oblique Stereographic\",ID[\"EPSG\",9809]],"
				+ "PARAMETER[\"Latitude of natural origin\",52.156160556,ANGLEUNIT[\"degree\",0.0174532925199433,ID[\"EPSG\",9102]]],"
				+ "PARAMETER[\"Longitude of natural origin\",5.387638889,ANGLEUNIT[\"degree\",0.0174532925199433,ID[\"EPSG\",9102]]],"
				+ "PARAMETER[\"Scale factor at natural origin\",0.9999079,SCALEUNIT[\"unity\",1,ID[\"EPSG\",9201]]],"
				+ "PARAMETER[\"False easting\",0,LENGTHUNIT[\"metre\",1,ID[\"EPSG\",9001]]],"
				+ "PARAMETER[\"False northing\",0,LENGTHUNIT[\"metre\",1,ID[\"EPSG\",9001]]],"
				+ "PARAMETER[\"X-axis translation\",565.417,LENGTHUNIT[\"metre\",1.0]],"
				+ "PARAMETER[\"Y-axis translation\",50.3319,LENGTHUNIT[\"metre\",1.0]],"
				+ "PARAMETER[\"Z-axis translation\",465.552,LENGTHUNIT[\"metre\",1.0]],"
				+ "PARAMETER[\"X-axis rotation\",-0.398957,LENGTHUNIT[\"metre\",1.0]],"
				+ "PARAMETER[\"Y-axis rotation\",0.343988,LENGTHUNIT[\"metre\",1.0]],"
				+ "PARAMETER[\"Z-axis rotation\",-1.8774,LENGTHUNIT[\"metre\",1.0]],"
				+ "PARAMETER[\"Scale difference\",4.0725,SCALEUNIT[\"parts per million\",1E-06]],"
				+ "ID[\"EPSG\",19913]],"
				+ "CS[Cartesian,2,ID[\"EPSG\",4499]],AXIS[\"Easting (X)\",east],AXIS[\"Northing (Y)\",north],"
				+ "LENGTHUNIT[\"metre\",1,ID[\"EPSG\",9001]],ID[\"EPSG\",28991]]";

		String expected = "+proj=sterea +lat_0=52.156160556 +lon_0=5.387638889 +k_0=0.9999079 +x_0=0 +y_0=0 +ellps=bessel +towgs84=565.417,50.3319,465.552,-0.398957,0.343988,-1.8774,4.0725 +units=m +no_defs";
		assertEquals(expected, ProjParser.paramsText(definition));

		definition = "PROJCS[\"Amersfoort / RD Old\","
				+ "GEOGCS[\"Amersfoort\"," + "DATUM[\"Amersfoort\","
				+ "SPHEROID[\"Bessel 1841\",6377397.155,299.1528128,"
				+ "AUTHORITY[\"EPSG\",\"7004\"]],"
				+ "TOWGS84[565.417,50.3319,465.552,-0.398957,0.343988,-1.8774,4.0725],"
				+ "AUTHORITY[\"EPSG\",\"6289\"]]," + "RIMEM[\"Greenwich\",0,"
				+ "AUTHORITY[\"EPSG\",\"8901\"]],"
				+ "UNIT[\"degree\",0.0174532925199433,"
				+ "AUTHORITY[\"EPSG\",\"9122\"]],"
				+ "AUTHORITY[\"EPSG\",\"4289\"]],"
				+ "PROJECTION[\"Oblique_Stereographic\"],"
				+ "PARAMETER[\"latitude_of_origin\",52.15616055555555],"
				+ "PARAMETER[\"central_meridian\",5.38763888888889],"
				+ "PARAMETER[\"scale_factor\",0.9999079],"
				+ "PARAMETER[\"false_easting\",0],"
				+ "PARAMETER[\"false_northing\",0]," + "UNIT[\"metre\",1,"
				+ "AUTHORITY[\"EPSG\",\"9001\"]]," + "AXIS[\"X\",EAST],"
				+ "AXIS[\"Y\",NORTH]," + "AUTHORITY[\"EPSG\",\"28991\"]]";

		expected = "+proj=sterea +lat_0=52.15616055555555 +lon_0=5.38763888888889 +k_0=0.9999079 +x_0=0 +y_0=0 +ellps=bessel +towgs84=565.417,50.3319,465.552,-0.398957,0.343988,-1.8774,4.0725 +units=m +no_defs";
		assertEquals(expected, ProjParser.paramsText(definition));

	}

	/**
	 * Test EPSG 29371
	 * 
	 * @throws IOException
	 *             upon error
	 */
	@Test
	public void test29371() throws IOException {

		// +proj=tmerc +lat_0=-22 +lon_0=11 +k=1 +x_0=0 +y_0=0 +axis=wsu
		// +ellps=bess_nam +towgs84=616,97,-251,0,0,0,0 +to_meter=1.0000135965
		// +no_defs

		String definition = "PROJCRS[\"Schwarzeck / Lo22/11\",BASEGEOGCRS[\"Schwarzeck\","
				+ "DATUM[\"Schwarzeck\","
				+ "ELLIPSOID[\"Bessel Namibia (GLM)\",6377397.155,299.1528128,LENGTHUNIT[\"German legal metre\",1.0000135965,ID[\"EPSG\",9031]],ID[\"EPSG\",7046]],"
				+ "ID[\"EPSG\",6293]],ID[\"EPSG\",4293]],"
				+ "CONVERSION[\"South West African Survey Grid zone 11\",METHOD[\"Transverse Mercator (South Orientated)\",ID[\"EPSG\",9808]],"
				+ "PARAMETER[\"Latitude of natural origin\",-22,ANGLEUNIT[\"degree\",0.0174532925199433,ID[\"EPSG\",9102]]],"
				+ "PARAMETER[\"Longitude of natural origin\",11,ANGLEUNIT[\"degree\",0.0174532925199433,ID[\"EPSG\",9102]]],"
				+ "PARAMETER[\"Scale factor at natural origin\",1,SCALEUNIT[\"unity\",1,ID[\"EPSG\",9201]]],"
				+ "PARAMETER[\"False easting\",0,LENGTHUNIT[\"German legal metre\",1.0000135965,ID[\"EPSG\",9031]]],"
				+ "PARAMETER[\"False northing\",0,LENGTHUNIT[\"German legal metre\",1.0000135965,ID[\"EPSG\",9031]]],"
				+ "PARAMETER[\"X-axis translation\",616,LENGTHUNIT[\"metre\",1.0]],"
				+ "PARAMETER[\"Y-axis translation\",97,LENGTHUNIT[\"metre\",1.0]],"
				+ "PARAMETER[\"Z-axis translation\",-251,LENGTHUNIT[\"metre\",1.0]],"
				+ "ID[\"EPSG\",17611]],"
				+ "CS[Cartesian,2,ID[\"EPSG\",6502]],AXIS[\"Westing (Y)\",west],AXIS[\"Southing (X)\",south],"
				+ "LENGTHUNIT[\"German legal metre\",1.0000135965,ID[\"EPSG\",9031]],ID[\"EPSG\",29371]]";

		String expected = "+proj=tmerc +lat_0=-22 +lon_0=11 +k_0=1 +x_0=0 +y_0=0 +axis=wsu +ellps=bess_nam +towgs84=616,97,-251,0,0,0,0 +to_meter=1.0000135965 +no_defs";
		assertEquals(expected, ProjParser.paramsText(definition));

		definition = "PROJCS[\"Schwarzeck / Lo22/11\","
				+ "GEOGCS[\"Schwarzeck\"," + "DATUM[\"Schwarzeck\","
				+ "SPHEROID[\"Bessel Namibia (GLM)\",6377483.865280419,299.1528128,"
				+ "AUTHORITY[\"EPSG\",\"7046\"]],"
				+ "TOWGS84[616,97,-251,0,0,0,0],"
				+ "AUTHORITY[\"EPSG\",\"6293\"]]," + "PRIMEM[\"Greenwich\",0,"
				+ "AUTHORITY[\"EPSG\",\"8901\"]],"
				+ "UNIT[\"degree\",0.0174532925199433,"
				+ "AUTHORITY[\"EPSG\",\"9122\"]],"
				+ "AUTHORITY[\"EPSG\",\"4293\"]],"
				+ "PROJECTION[\"Transverse_Mercator_South_Orientated\"],"
				+ "PARAMETER[\"latitude_of_origin\",-22],"
				+ "PARAMETER[\"central_meridian\",11],"
				+ "PARAMETER[\"scale_factor\",1],"
				+ "PARAMETER[\"false_easting\",0],"
				+ "PARAMETER[\"false_northing\",0],"
				+ "UNIT[\"German legal metre\",1.0000135965,"
				+ "AUTHORITY[\"EPSG\",\"9031\"]]," + "AXIS[\"Y\",WEST],"
				+ "AXIS[\"X\",SOUTH]," + "AUTHORITY[\"EPSG\",\"29371\"]]";

		expected = "+proj=tmerc +lat_0=-22 +lon_0=11 +k_0=1 +x_0=0 +y_0=0 +axis=wsu +ellps=bess_nam +towgs84=616,97,-251,0,0,0,0 +to_meter=1.0000135965 +no_defs";
		assertEquals(expected, ProjParser.paramsText(definition));

	}

	/**
	 * Test EPSG 29900
	 * 
	 * @throws IOException
	 *             upon error
	 */
	@Test
	public void test29900() throws IOException {

		// +proj=tmerc +lat_0=53.5 +lon_0=-8 +k=1.000035 +x_0=200000 +y_0=250000
		// +datum=ire65 +units=m +no_defs

		String definition = "PROJCRS[\"TM65 / Irish National Grid\",BASEGEOGCRS[\"TM65\","
				+ "DATUM[\"TM65\","
				+ "ELLIPSOID[\"Airy Modified 1849\",6377340.189,299.3249646,LENGTHUNIT[\"metre\",1,ID[\"EPSG\",9001]],ID[\"EPSG\",7002]],"
				+ "ID[\"EPSG\",6299]],ID[\"EPSG\",4299]],"
				+ "CONVERSION[\"Irish National Grid\",METHOD[\"Transverse Mercator\",ID[\"EPSG\",9807]],"
				+ "PARAMETER[\"Latitude of natural origin\",53.5,ANGLEUNIT[\"degree\",0.0174532925199433,ID[\"EPSG\",9102]]],"
				+ "PARAMETER[\"Longitude of natural origin\",-8,ANGLEUNIT[\"degree\",0.0174532925199433,ID[\"EPSG\",9102]]],"
				+ "PARAMETER[\"Scale factor at natural origin\",1.000035,SCALEUNIT[\"unity\",1,ID[\"EPSG\",9201]]],"
				+ "PARAMETER[\"False easting\",200000,LENGTHUNIT[\"metre\",1,ID[\"EPSG\",9001]]],"
				+ "PARAMETER[\"False northing\",250000,LENGTHUNIT[\"metre\",1,ID[\"EPSG\",9001]]],"
				+ "ID[\"EPSG\",19908]],"
				+ "CS[Cartesian,2,ID[\"EPSG\",4400]],AXIS[\"Easting (E)\",east],AXIS[\"Northing (N)\",north],"
				+ "LENGTHUNIT[\"metre\",1,ID[\"EPSG\",9001]],ID[\"EPSG\",29900]]";

		String expected = "+proj=tmerc +lat_0=53.5 +lon_0=-8 +k_0=1.000035 +x_0=200000 +y_0=250000 +datum=ire65 +units=m +no_defs";
		assertEquals(expected, ProjParser.paramsText(definition));

		definition = "PROJCS[\"TM65 / Irish National Grid (deprecated)\","
				+ "GEOGCS[\"TM65\"," + "DATUM[\"TM65\","
				+ "SPHEROID[\"Airy Modified 1849\",6377340.189,299.3249646,"
				+ "AUTHORITY[\"EPSG\",\"7002\"]],"
				+ "TOWGS84[482.5,-130.6,564.6,-1.042,-0.214,-0.631,8.15],"
				+ "AUTHORITY[\"EPSG\",\"6299\"]]," + "PRIMEM[\"Greenwich\",0,"
				+ "AUTHORITY[\"EPSG\",\"8901\"]],"
				+ "UNIT[\"degree\",0.0174532925199433,"
				+ "AUTHORITY[\"EPSG\",\"9122\"]],"
				+ "AUTHORITY[\"EPSG\",\"4299\"]],"
				+ "PROJECTION[\"Transverse_Mercator\"],"
				+ "PARAMETER[\"latitude_of_origin\",53.5],"
				+ "PARAMETER[\"central_meridian\",-8],"
				+ "PARAMETER[\"scale_factor\",1.000035],"
				+ "PARAMETER[\"false_easting\",200000],"
				+ "PARAMETER[\"false_northing\",250000]," + "UNIT[\"metre\",1,"
				+ "AUTHORITY[\"EPSG\",\"9001\"]]," + "AXIS[\"Easting\",EAST],"
				+ "AXIS[\"Northing\",NORTH],"
				+ "AUTHORITY[\"EPSG\",\"29900\"]]";

		expected = "+proj=tmerc +lat_0=53.5 +lon_0=-8 +k_0=1.000035 +x_0=200000 +y_0=250000 +datum=ire65 +towgs84=482.5,-130.6,564.6,-1.042,-0.214,-0.631,8.15 +units=m +no_defs";
		assertEquals(expected, ProjParser.paramsText(definition));

	}

	/**
	 * Test EPSG 31600
	 * 
	 * @throws IOException
	 *             upon error
	 */
	@Test
	public void test31600() throws IOException {

		// +proj=sterea +lat_0=45.9 +lon_0=25.39246588888889 +k=0.9996667
		// +x_0=500000 +y_0=500000 +ellps=intl
		// +towgs84=103.25,-100.4,-307.19,0,0,0,0 +units=m +no_defs

		String definition = "PROJCRS[\"Dealul Piscului 1930 / Stereo 33\",BASEGEOGCRS[\"Dealul Piscului 1930\","
				+ "DATUM[\"Dealul Piscului 1930\","
				+ "ELLIPSOID[\"International 1924\",6378388,297,LENGTHUNIT[\"metre\",1,ID[\"EPSG\",9001]],ID[\"EPSG\",7022]],"
				+ "ID[\"EPSG\",6316]],ID[\"EPSG\",4316]],"
				+ "CONVERSION[\"Stereo 33\",METHOD[\"Oblique Stereographic\",ID[\"EPSG\",9809]],"
				+ "PARAMETER[\"Latitude of natural origin\",45.9,ANGLEUNIT[\"degree\",0.0174532925199433,ID[\"EPSG\",9102]]],"
				+ "PARAMETER[\"Longitude of natural origin\",25.392465889,ANGLEUNIT[\"degree\",0.0174532925199433,ID[\"EPSG\",9102]]],"
				+ "PARAMETER[\"Scale factor at natural origin\",0.9996667,SCALEUNIT[\"unity\",1,ID[\"EPSG\",9201]]],"
				+ "PARAMETER[\"False easting\",500000,LENGTHUNIT[\"metre\",1,ID[\"EPSG\",9001]]],"
				+ "PARAMETER[\"False northing\",500000,LENGTHUNIT[\"metre\",1,ID[\"EPSG\",9001]]],"
				+ "PARAMETER[\"X-axis translation\",103.25,LENGTHUNIT[\"metre\",1.0]],"
				+ "PARAMETER[\"Y-axis translation\",-100.4,LENGTHUNIT[\"metre\",1.0]],"
				+ "PARAMETER[\"Z-axis translation\",-307.19,LENGTHUNIT[\"metre\",1.0]],"
				+ "ID[\"EPSG\",19927]],"
				+ "CS[Cartesian,2,ID[\"EPSG\",4499]],AXIS[\"Easting (X)\",east],AXIS[\"Northing (Y)\",north]"
				+ ",LENGTHUNIT[\"metre\",1,ID[\"EPSG\",9001]],ID[\"EPSG\",31600]]";

		String expected = "+proj=sterea +lat_0=45.9 +lon_0=25.392465889 +k_0=0.9996667 +x_0=500000 +y_0=500000 +ellps=intl +towgs84=103.25,-100.4,-307.19,0,0,0,0 +units=m +no_defs";
		assertEquals(expected, ProjParser.paramsText(definition));

		definition = "PROJCS[\"Dealul Piscului 1930 / Stereo 33\","
				+ "GEOGCS[\"Dealul Piscului 1930\","
				+ "DATUM[\"Dealul_Piscului_1930\","
				+ "SPHEROID[\"International 1924\",6378388,297,"
				+ "AUTHORITY[\"EPSG\",\"7022\"]],"
				+ "TOWGS84[103.25,-100.4,-307.19,0,0,0,0],"
				+ "AUTHORITY[\"EPSG\",\"6316\"]]," + "PRIMEM[\"Greenwich\",0,"
				+ "AUTHORITY[\"EPSG\",\"8901\"]],"
				+ "UNIT[\"degree\",0.0174532925199433,"
				+ "AUTHORITY[\"EPSG\",\"9122\"]],"
				+ "AUTHORITY[\"EPSG\",\"4316\"]],"
				+ "PROJECTION[\"Oblique_Stereographic\"],"
				+ "PARAMETER[\"latitude_of_origin\",45.9],"
				+ "PARAMETER[\"central_meridian\",25.39246588888889],"
				+ "PARAMETER[\"scale_factor\",0.9996667],"
				+ "PARAMETER[\"false_easting\",500000],"
				+ "PARAMETER[\"false_northing\",500000]," + "UNIT[\"metre\",1,"
				+ "AUTHORITY[\"EPSG\",\"9001\"]]," + "AXIS[\"X\",EAST],"
				+ "AXIS[\"Y\",NORTH]," + "AUTHORITY[\"EPSG\",\"31600\"]]";

		expected = "+proj=sterea +lat_0=45.9 +lon_0=25.39246588888889 +k_0=0.9996667 +x_0=500000 +y_0=500000 +ellps=intl +towgs84=103.25,-100.4,-307.19,0,0,0,0 +units=m +no_defs";
		assertEquals(expected, ProjParser.paramsText(definition));

	}

	/**
	 * Test EPSG 32660
	 * 
	 * @throws IOException
	 *             upon error
	 */
	@Test
	public void test32660() throws IOException {

		// +proj=utm +zone=60 +datum=WGS84 +units=m +no_defs

		String definition = "PROJCRS[\"WGS 84 / UTM zone 60N\",BASEGEOGCRS[\"WGS 84\","
				+ "ENSEMBLE[\"World Geodetic System 1984 ensemble\","
				+ "MEMBER[\"World Geodetic System 1984 (Transit)\",ID[\"EPSG\",1166]],"
				+ "MEMBER[\"World Geodetic System 1984 (G730)\",ID[\"EPSG\",1152]],"
				+ "MEMBER[\"World Geodetic System 1984 (G873)\",ID[\"EPSG\",1153]],"
				+ "MEMBER[\"World Geodetic System 1984 (G1150)\",ID[\"EPSG\",1154]],"
				+ "MEMBER[\"World Geodetic System 1984 (G1674)\",ID[\"EPSG\",1155]],"
				+ "MEMBER[\"World Geodetic System 1984 (G1762)\",ID[\"EPSG\",1156]],"
				+ "ELLIPSOID[\"WGS 84\",6378137,298.257223563,ID[\"EPSG\",7030]],"
				+ "ENSEMBLEACCURACY[2],ID[\"EPSG\",6326]],ID[\"EPSG\",4326]],"
				+ "CONVERSION[\"UTM zone 60N\",METHOD[\"Transverse Mercator\",ID[\"EPSG\",9807]],"
				+ "PARAMETER[\"Latitude of natural origin\",0,ANGLEUNIT[\"degree\",0.0174532925199433,ID[\"EPSG\",9102]]],"
				+ "PARAMETER[\"Longitude of natural origin\",177,ANGLEUNIT[\"degree\",0.0174532925199433,ID[\"EPSG\",9102]]],"
				+ "PARAMETER[\"Scale factor at natural origin\",0.9996,SCALEUNIT[\"unity\",1,ID[\"EPSG\",9201]]],"
				+ "PARAMETER[\"False easting\",500000,LENGTHUNIT[\"metre\",1,ID[\"EPSG\",9001]]],"
				+ "PARAMETER[\"False northing\",0,LENGTHUNIT[\"metre\",1,ID[\"EPSG\",9001]]],"
				+ "ID[\"EPSG\",16060]],"
				+ "CS[Cartesian,2,ID[\"EPSG\",4400]],AXIS[\"Easting (E)\",east],AXIS[\"Northing (N)\",north],"
				+ "LENGTHUNIT[\"metre\",1,ID[\"EPSG\",9001]],ID[\"EPSG\",32660]]";

		String expected = "+proj=utm +zone=60 +datum=WGS84 +units=m +no_defs";
		assertEquals(expected, ProjParser.paramsText(definition));

		definition = "PROJCS[\"WGS 84 / UTM zone 60N\",GEOGCS[\"WGS 84\","
				+ "DATUM[\"WGS_1984\","
				+ "SPHEROID[\"WGS 84\",6378137,298.257223563,"
				+ "AUTHORITY[\"EPSG\",\"7030\"]],"
				+ "AUTHORITY[\"EPSG\",\"6326\"]],"
				+ "PRIMEM[\"Greenwich\",0,AUTHORITY[\"EPSG\",\"8901\"]],"
				+ "UNIT[\"degree\",0.01745329251994328,"
				+ "AUTHORITY[\"EPSG\",\"9122\"]],"
				+ "AUTHORITY[\"EPSG\",\"4326\"]],"
				+ "UNIT[\"metre\",1,AUTHORITY[\"EPSG\",\"9001\"]],"
				+ "PROJECTION[\"Transverse_Mercator\"],"
				+ "PARAMETER[\"latitude_of_origin\",0],"
				+ "PARAMETER[\"central_meridian\",177],"
				+ "PARAMETER[\"scale_factor\",0.9996],"
				+ "PARAMETER[\"false_easting\",500000],"
				+ "PARAMETER[\"false_northing\",0],"
				+ "AUTHORITY[\"EPSG\",\"32660\"],"
				+ "AXIS[\"Easting\",EAST],AXIS[\"Northing\",NORTH]]";

		expected = "+proj=utm +zone=60 +datum=WGS84 +units=m +no_defs";
		assertEquals(expected, ProjParser.paramsText(definition));

		definition = "PROJCS[\"WGS 84 / UTM zone 60N\",GEOGCRS[\"WGS 84\","
				+ "DATUM[\"WGS_1984\","
				+ "SPHEROID[\"WGS84\",6378137,298.257223563,"
				+ "ID[\"EPSG\",\"7030\"]],ID[\"EPSG\",\"6326\"]],"
				+ "PRIMEM[\"Greenwich\",0,ID[\"EPSG\",\"8901\"]],"
				+ "UNIT[\"degree\",0.0174532925199433,ID[\"EPSG\",\"9122\"]],"
				+ "ID[\"EPSG\",\"4326\"]],"
				+ "PROJECTION[\"Transverse_Mercator\"],"
				+ "PARAMETER[\"latitude_of_origin\",0],"
				+ "PARAMETER[\"central_meridian\",177],"
				+ "PARAMETER[\"scale_factor\",0.9996],"
				+ "PARAMETER[\"false_easting\",500000],"
				+ "PARAMETER[\"false_northing\",0],"
				+ "UNIT[\"metre\",1,ID[\"EPSG\",\"9001\"]],"
				+ "AXIS[\"Easting\",EAST],AXIS[\"Northing\",NORTH],"
				+ "ID[\"EPSG\",\"32660\"]]";

		expected = "+proj=utm +zone=60 +datum=WGS84 +units=m +no_defs";
		assertEquals(expected, ProjParser.paramsText(definition));

	}

}
