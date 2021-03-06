package mil.nga.crs.wkt;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import mil.nga.crs.CRSException;

/**
 * Read through text string
 * 
 * @author osbornb
 */
public class TextReader {

	/**
	 * Logger
	 */
	private static final Logger logger = Logger
			.getLogger(TextReader.class.getName());

	/**
	 * Reader
	 */
	private final Reader reader;

	/**
	 * Next tokens cache for peeks
	 */
	private final List<String> nextTokens = new ArrayList<>();

	/**
	 * Next character number cache for between token caching
	 */
	private Integer nextCharacterNum;

	/**
	 * Include quotes on quoted strings
	 */
	private boolean includeQuotes = false;

	/**
	 * Constructor
	 * 
	 * @param text
	 *            text
	 */
	public TextReader(String text) {
		this(new StringReader(text));
	}

	/**
	 * Constructor
	 * 
	 * @param reader
	 *            reader
	 */
	public TextReader(Reader reader) {
		this(reader, false);
	}

	/**
	 * Constructor
	 * 
	 * @param text
	 *            text
	 * @param includeQuotes
	 *            include quotes
	 */
	public TextReader(String text, boolean includeQuotes) {
		this(new StringReader(text), includeQuotes);
	}

	/**
	 * Constructor
	 * 
	 * @param reader
	 *            reader
	 * @param includeQuotes
	 *            include quotes
	 */
	public TextReader(Reader reader, boolean includeQuotes) {
		this.reader = reader;
		this.includeQuotes = includeQuotes;
	}

	/**
	 * Get the reader
	 * 
	 * @return reader
	 */
	public Reader getReader() {
		return reader;
	}

	/**
	 * Is include quotes enabled
	 * 
	 * @return include quotes setting
	 */
	public boolean isIncludeQuotes() {
		return includeQuotes;
	}

	/**
	 * Set the include quotes setting
	 * 
	 * @param includeQuotes
	 *            true to include quotes
	 */
	public void setIncludeQuotes(boolean includeQuotes) {
		this.includeQuotes = includeQuotes;
	}

	/**
	 * Reset the reader
	 * 
	 * @throws IOException
	 *             upon reset error
	 */
	public void reset() throws IOException {
		reader.reset();
		nextTokens.clear();
		nextCharacterNum = null;
	}

	/**
	 * Close the text reader
	 */
	public void close() {
		try {
			reader.close();
		} catch (IOException e) {
			logger.log(Level.WARNING, "Failed to close text reader", e);
		}
	}

	/**
	 * Read the next token. Ignores whitespace until a non whitespace character
	 * is encountered. Returns a contiguous block of token characters ( [a-z] |
	 * [A-Z] | [0-9] | - | . | + | : | _ ) or a non whitespace single character.
	 * 
	 * @return token
	 * @throws IOException
	 *             upon read error
	 */
	public String readToken() throws IOException {
		return readToken(true);
	}

	/**
	 * Read the next token. Ignores whitespace until a non whitespace character
	 * is encountered. Returns a contiguous block of token characters ( [a-z] |
	 * [A-Z] | [0-9] | - | . | + | : | _ ) or a non whitespace single character.
	 * 
	 * @param cache
	 *            true to read from cached peeks, false to force read
	 * 
	 * @return token
	 * @throws IOException
	 *             upon read error
	 */
	private String readToken(boolean cache) throws IOException {

		String token = null;

		// Get the next token, cached or read
		if (cache && !nextTokens.isEmpty()) {
			token = nextTokens.remove(0);
		} else {

			StringBuilder builder = null;
			boolean isQuote = false;
			boolean previousCharQuote = false;

			// Get the next character, cached or read
			int characterNum;
			if (nextCharacterNum != null) {
				characterNum = nextCharacterNum;
				nextCharacterNum = null;
			} else {
				characterNum = reader.read();
			}

			// Continue while characters are left
			while (characterNum != -1) {

				char character = (char) characterNum;

				// Check if not the first character in the token
				if (builder != null) {

					// If in a quoted string
					if (isQuote) {
						boolean charQuote = isQuoteCharacter(character);
						if (previousCharQuote) {
							if (charQuote) {
								builder.append(character);
								previousCharQuote = false;
							} else {
								// End of quoted string found at previous
								// character
								nextCharacterNum = characterNum;
								break;
							}
						} else if (charQuote) {
							previousCharQuote = true;
						} else {
							builder.append(character);
						}
					} else if (isTokenCharacter(character)) {
						// Append token characters
						builder.append(character);
					} else {
						// Complete the token before this character and cache
						// the character
						if (!isWhitespace(character)) {
							nextCharacterNum = characterNum;
						}
						break;
					}

				} else if (!isWhitespace(character)) {

					// First non whitespace character in the token
					builder = new StringBuilder();
					if (isQuoteCharacter(character)) {
						isQuote = true;
					} else {

						builder.append(character);

						if (!isTokenCharacter(character)) {
							// Complete token if a single character token
							break;
						}
					}

				}

				// Read the next character
				characterNum = reader.read();
			}

			if (builder != null) {
				token = builder.toString();
				if (isQuote && includeQuotes) {
					token = "\"" + token + "\"";
				}
			}

		}
		return token;
	}

	/**
	 * Peek at the next token without reading past it
	 * 
	 * @return next token
	 * @throws IOException
	 *             upon read error
	 */
	public String peekToken() throws IOException {
		return peekToken(1);
	}

	/**
	 * Peek at a token without reading past it
	 * 
	 * @param num
	 *            number of tokens out to peek at
	 * @return token
	 * @throws IOException
	 *             upon read error
	 */
	public String peekToken(int num) throws IOException {
		for (int i = 1; i <= num; i++) {
			if (nextTokens.size() < i) {
				String token = readToken(false);
				if (token != null) {
					nextTokens.add(token);
				} else {
					break;
				}
			}
		}
		String token = null;
		if (num <= nextTokens.size()) {
			token = nextTokens.get(num - 1);
		}
		return token;
	}

	/**
	 * Push a token back onto the read cache
	 * 
	 * @param token
	 *            token
	 */
	public void pushToken(String token) {
		nextTokens.add(0, token);
	}

	/**
	 * Read an expected token
	 * 
	 * @return token
	 * @throws IOException
	 *             upon read error
	 */
	public String readExpectedToken() throws IOException {
		String token = readToken();
		if (token == null) {
			throw new CRSException("Unexpected end of text, null token");
		}
		return token;
	}

	/**
	 * Peek at the next expected token without reading past it
	 * 
	 * @return next token
	 * @throws IOException
	 *             upon read error
	 */
	public String peekExpectedToken() throws IOException {
		return peekExpectedToken(1);
	}

	/**
	 * Peek at the next expected token without reading past it
	 * 
	 * @param num
	 *            number of tokens out to peek at
	 * @return token
	 * @throws IOException
	 *             upon read error
	 */
	public String peekExpectedToken(int num) throws IOException {
		String token = peekToken(num);
		if (token == null) {
			throw new CRSException("Unexpected end of text, null token");
		}
		return token;
	}

	/**
	 * Read a signed number as a double
	 * 
	 * @return signed double
	 * @throws IOException
	 *             upon failure to read
	 */
	public double readNumber() throws IOException {
		String token = readExpectedToken();
		double number;
		try {
			number = Double.parseDouble(token);
		} catch (NumberFormatException e) {
			throw new CRSException(
					"Invalid number token. found: '" + token + "'", e);
		}
		return number;
	}

	/**
	 * Read an unsigned number as a double
	 * 
	 * @return unsigned double
	 * @throws IOException
	 *             upon failure to read
	 */
	public double readUnsignedNumber() throws IOException {
		double number = readNumber();
		if (number < 0) {
			throw new CRSException("Invalid unsigned number. found: " + number);
		}
		return number;
	}

	/**
	 * Read a signed integer
	 * 
	 * @return signed integer
	 * @throws IOException
	 *             upon failure to read
	 */
	public int readInteger() throws IOException {
		String token = readExpectedToken();
		int number;
		try {
			number = Integer.parseInt(token);
		} catch (NumberFormatException e) {
			throw new CRSException(
					"Invalid integer token. found: '" + token + "'", e);
		}
		return number;
	}

	/**
	 * Read an unsigned integer
	 * 
	 * @return unsigned integer
	 * @throws IOException
	 *             upon failure to read
	 */
	public int readUnsignedInteger() throws IOException {
		String token = readExpectedToken();
		int number;
		try {
			number = Integer.parseUnsignedInt(token);
		} catch (NumberFormatException e) {
			throw new CRSException(
					"Invalid unsigned integer token. found: '" + token + "'",
					e);
		}
		return number;
	}

	/**
	 * Check if the character is a contiguous block token character: ( [a-z] |
	 * [A-Z] | [0-9] | - | . | + | : | _ )
	 * 
	 * @param c
	 *            character
	 * @return true if token character
	 * @since 1.1.3
	 */
	public static boolean isTokenCharacter(char c) {
		return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')
				|| (c >= '0' && c <= '9') || c == '-' || c == '.' || c == '+'
				|| c == ':' || c == '_';
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
		boolean quote = c == '"';
		if (!quote) {
			int type = Character.getType(c);
			quote = type == Character.INITIAL_QUOTE_PUNCTUATION
					|| type == Character.FINAL_QUOTE_PUNCTUATION;
		}
		return quote;
	}

	/**
	 * Check if the character is whitespace or a space character
	 * 
	 * @param c
	 *            character
	 * @return true if whitespace
	 * @since 1.1.3
	 */
	public static boolean isWhitespace(char c) {
		return Character.isWhitespace(c) || Character.isSpaceChar(c);
	}

}
