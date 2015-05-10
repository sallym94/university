import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//Creates a new timetable to return at the end of the method
		ShuttleTimetable timetable = new ShuttleTimetable();
		List<String> scheduleList = new ArrayList<String>(createScheduleArray(fileName));
		int numOfSession = new Integer(getNumOfSessions(scheduleList));
		
		System.out.println(numOfSession);
		
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
								//System.out
										//.println("Service about to be added: "
											//	+ service);

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
		//System.out.println(timetable);
		return timetable;

	}