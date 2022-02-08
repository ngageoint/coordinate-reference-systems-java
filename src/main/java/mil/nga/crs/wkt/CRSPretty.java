package mil.nga.crs.wkt;

import java.io.IOException;

import mil.nga.crs.CRS;
import mil.nga.crs.CRSException;
import mil.nga.crs.util.proj.ProjParser;

/**
 * Parse OGC Coordinate Reference System Well-Known Text (1|2) and pretty print
 * Coordinate Reference System Well-Known Text 2 and PROJ params
 * 
 * To run from command line:
 * 
 * java -jar name.jar +usage_arguments
 * 
 * java -classpath name.jar mil.nga.crs.wkt.CRSPretty +usage_arguments
 * 
 * @author osbornb
 * @since 1.1.2
 */
public class CRSPretty {

	/**
	 * Help Argument
	 */
	private static final String HELP_ARG = "-help";

	/**
	 * Main method to generate tiles in a GeoPackage
	 * 
	 * @param args
	 *            arguments
	 * @throws IOException
	 *             upon error
	 */
	public static void main(String[] args) throws IOException {

		StringBuilder builder = new StringBuilder();

		if (args.length > 0 && !args[0].equalsIgnoreCase(HELP_ARG)) {

			for (int i = 0; i < args.length; i++) {

				String[] lines = args[i].trim().split("\n");

				for (int j = 0; j < lines.length; j++) {

					String line = lines[j].trim();
					if (line.endsWith("\\") || line.endsWith("/")) {
						line = line.substring(0, line.length() - 1);
					}

					builder.append(line);

				}

			}

		}

		if (builder.length() == 0) {
			printUsage();
		} else {
			parseAndPrint(builder.toString());
		}

	}

	/**
	 * Project coordinates
	 * 
	 * @param wkt
	 *            well-known text
	 * @throws IOException
	 *             upon error
	 */
	public static void parseAndPrint(String wkt) throws IOException {

		System.out.println();
		System.out.println("---------------");
		System.out.println("Well-Known Text");
		System.out.println("---------------");
		System.out.println();
		String wktPretty = CRSWriter.writePretty(wkt);
		System.out.println(wktPretty);

		try {

			CRS crs = CRSReader.read(wkt);

			String crsPretty = CRSWriter.writePretty(crs);
			if (!wktPretty.equals(crsPretty)) {
				System.out.println();
				System.out.println("-------------------");
				System.out.println("CRS Well-Known Text");
				System.out.println("-------------------");
				System.out.println();
				System.out.println(crsPretty);
			}

			System.out.println();
			System.out.println("-----------");
			System.out.println("PROJ Params");
			System.out.println("-----------");
			System.out.println();
			System.out.println(ProjParser.paramsText(crs));
			System.out.println();

		} catch (CRSException e) {

			System.out.println();
			System.out.println("-------------------------------------------");
			System.out.println("Failed to parse Coordinate Reference System");
			System.out.println("-------------------------------------------");
			System.out.println();
			e.printStackTrace();
			System.out.println();

		}

	}

	/**
	 * Print usage for the main method
	 */
	private static void printUsage() {
		System.out.println();
		System.out.println("USAGE");
		System.out.println();
		System.out.println("\twell-known_text");
		System.out.println();
		System.out.println("DESCRIPTION");
		System.out.println();
		System.out.println(
				"\tParse OGC Coordinate Reference System Well-Known Text (1|2) and pretty print Coordinate Reference System Well-Known Text 2 and PROJ params");
		System.out.println();
		System.out.println("\twell-known_text");
		System.out.println("\t\tCoordinate Reference System Well-Known Text");
		System.out.println(
				"\t\t\tExample: 'GEOGCS[\"WGS 84\",DATUM[\"WGS_1984\",SPHEROID[\"WGS 84\",6378137,298.257223563]],PRIMEM[\"Greenwich\",0]]'");
		System.out.println();
	}

}
