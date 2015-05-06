package festival;

import java.io.*;
import java.util.Scanner;

/**
 * Provides a method to read a shuttle timetable from a file.
 */
public class ScheduleReader {

	public static void main(String[] args) throws IOException, FormatException {
		ScheduleReader.read("read_08_incorrectlyFormatted.txt");
	}

	/**
	 * <p>
	 * Reads a text file called fileName that describes the shuttle services
	 * available for a festival, and returns the shuttle timetable containing
	 * each of the services in the file.
	 * </p>
	 * 
	 * <p>
	 * The first line of the file contains a single positive integer, denoting
	 * the number of sessions in the festival. The rest of the file contains
	 * zero or more descriptions of venues and their services for the available
	 * sessions.
	 * </p>
	 * 
	 * <p>
	 * There may be leading or trailing whitespace on the first line of the file
	 * that contains the single positive integer denoting the number of sessions
	 * in the festival.
	 * </p>
	 * 
	 * <p>
	 * A description of a venue and its services consists of (1) a venue name on
	 * a line of its own, followed by (2) one line for each session in the
	 * festival that describes the services that depart the venue at the end of
	 * that session, followed by (3) an empty line. <br>
	 * <br>
	 * (For the purpose of this method) a venue name is simply an unformatted
	 * non-empty string that doesn't contain any whitespace characters. There
	 * may be leading and trailing whitespace on the line containing the venue
	 * name but no other information. <br>
	 * <br>
	 * For (2) the lines for each session in the festival should be ordered by
	 * session number: starting at 1 and ending at the number of sessions in the
	 * festival. Each such line should consist of the session number, followed
	 * by zero or more venue names separated by white spaces. There may be
	 * leading or trailing whitespace on each such line.
	 * 
	 * A venue may not have a shuttle service to itself, and there can be no
	 * duplicate services.
	 * </p>
	 * 
	 * <p>
	 * A venue shouldn't have more than one description of itself and its
	 * services, but a venue doesn't have to have a description of itself and
	 * its services if it doesn't have any.
	 * </p>
	 * 
	 * @param fileName
	 *            the file to read from.
	 * @return the shuttle timetable that was read from the file.
	 * @throws IOException
	 *             if there is an error reading from the input file.
	 * @throws FormatException
	 *             if there is an error with the input format (e.g. a venue has
	 *             more than one description of itself and its services, or the
	 *             file format is not as specified above in any other way.) The
	 *             FormatExceptions thrown should have a meaningful message that
	 *             accurately describes the problem with the input file format.
	 */
	public static ShuttleTimetable read(String fileName) throws IOException,
			FormatException {
		//Creates a new timetable to return at the end of the method
		ShuttleTimetable timetable = new ShuttleTimetable();
		
		//trys method to see if IOException if thrown
		try {
			//creates a new fileReader to read the supplied fileName
			FileReader fr = new FileReader(fileName);
			//creates a BufferedReader to read the lines of the file
			BufferedReader br = new BufferedReader(fr);

			//creates a variable to store each line under as it is read
			String sCurrentLine = br.readLine();
			//stores the first line of the document under a variable containing
			//the number of sessions in the timetable
			int numOfSessions = new Integer(sCurrentLine);
			
			//throws error if there are an invalid number of sessions
			if (numOfSessions <= 0) {
				br.close();
				throw new FormatException(
						"There are an invalid number of sessions");
			}
			String source = "nothing";
			String dest = "nothing";
			int session = 0;
			int count = 0;

			while ((sCurrentLine = br.readLine()) != null) {
				// System.out.println(sCurrentLine);
				Scanner scnr = new Scanner(sCurrentLine);
				count++;
				if (count == numOfSessions + 3) {
					count = 1;
					session = 0;
				}
				// System.out.println("count: " + count);
				if (count == 1) {
					source = sCurrentLine;
					// System.out.println("source: " + source);
				}

				int tokenCount = 0;
				while (scnr.hasNext()) {
					tokenCount++;
					String token = new String(scnr.next());

					if (count > 1) {
						if (tokenCount == 1) {
							if ((session == ((new Integer(token)) - 1))
									|| (session == 0)) {
								session = new Integer(token);
							} else {
								scnr.close();
								throw new FormatException("There is a "
										+ "missing session row after session"
										+ session);
							}

						}
						if (tokenCount > 1) {
							dest = token;

							try {
								Service service = new Service(
										new Venue(source), new Venue(dest),
										session);
								if (timetable.hasService(service)) {
									scnr.close();
									throw new FormatException(
											"The timetable has "
													+ "	duplicate service of: "
													+ service);
								}
								System.out
										.println("Service about to be added: "
												+ service);

								timetable.addService(service);
							} catch (InvalidServiceException ne) {
								scnr.close();
								throw new FormatException(
										"The source and destination are equal for session: "
												+ session + "source: " + source);
							}

						}
					}
				}
				scnr.close();
			}
			br.close();
		} catch (IOException e) {
			System.err.println("IOException: " + e);
		}
		System.out.println(timetable);
		return timetable;

	}

}
