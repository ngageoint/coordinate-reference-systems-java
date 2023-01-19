package mil.nga.crs.wkt;

import java.io.IOException;
import java.util.Scanner;

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
	 * Command prompt
	 */
	public static final String COMMAND_PROMPT = "wkt> ";

	/**
	 * Main method to generate tiles in a GeoPackage
	 * 
	 * @param args
	 *            arguments
	 * @throws IOException
	 *             upon error
	 */
	public static void main(String[] args) throws IOException {

		boolean help = false;
		StringBuilder builder = new StringBuilder();

		if (args.length > 0) {

			if (args[0].equalsIgnoreCase(HELP_ARG)) {
				help = true;
			} else {

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

		}

		if (help) {
			printUsage();
		} else if (builder.length() == 0) {
			commandPrompt();
		} else {
			parseAndPrint(builder.toString());
		}

	}

	/**
	 * Command prompt accepting well-known text
	 */
	private static void commandPrompt() {

		Scanner scanner = new Scanner(System.in);
		try {
			System.out.println();
			System.out.println(
					"Enter OGC Coordinate Reference System Well-Known Text");
			System.out.println(
					"* Parsing occurs when closing brackets ']' match or exceed opening brackets '['");

			StringBuilder wktBuilder = new StringBuilder();
			resetCommandPrompt(wktBuilder);
			int openBrackets = 0;
			int closeBrackets = 0;

			while (scanner.hasNextLine()) {
				try {
					String line = scanner.nextLine().trim();
					if (line.isEmpty()) {
						if (wktBuilder.length() == 0) {
							break;
						}
					} else {
						wktBuilder.append(line);

						openBrackets += line.length()
								- line.replaceAll("\\[", "").length();
						closeBrackets += line.length()
								- line.replaceAll("]", "").length();

						if (closeBrackets >= openBrackets
								&& closeBrackets > 0) {

							String wkt = wktBuilder.toString().trim();
							char firstChar = wkt.charAt(0);
							char lastChar = wkt.charAt(wkt.length() - 1);
							if (isQuoteCharacter(firstChar)
									&& firstChar == lastChar) {
								wkt = wkt.substring(1, wkt.length() - 1).trim();
							}

							parseAndPrint(wkt);
							resetCommandPrompt(wktBuilder);

							openBrackets = 0;
							closeBrackets = 0;

						}
					}

				} catch (Exception e) {
					System.out.println(e);
					resetCommandPrompt(wktBuilder);
				}
			}
		} finally {
			scanner.close();
		}

	}

	/**
	 * Reset the command prompt
	 * 
	 * @param builder
	 *            string builder
	 */
	private static void resetCommandPrompt(StringBuilder builder) {
		builder.setLength(0);
		System.out.println();
		System.out.print(COMMAND_PROMPT);
	}

	/**
	 * Check if the character is a quote character
	 * 
	 * @param c
	 *            character
	 * @return true if quote character
	 * @since 1.1.3
	 */
	public static boolean isQuoteCharacter(char c) {
		return c == '\'' || TextReader.isQuoteCharacter(c);
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

			String crsSingleLine = CRSWriter.write(crs);
			if (!wkt.equals(crsSingleLine)) {
				System.out.println();
				System.out.println("---------------------------------");
				System.out.println("CRS Well-Known Text (Single Line)");
				System.out.println("---------------------------------");
				System.out.println();
				System.out.println(crsSingleLine);
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
			e.printStackTrace(System.out);
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
