package festival;

/**
 * <p>
 * An immutable class representing a shuttle service for a festival.
 * </p>
 * 
 * <p>
 * A shuttle service departs a venue at the end of a session, and arrives at a
 * destination venue before the start of the next session. (The source and
 * destination venues in a service are distinct.)
 * </p>
 */



public class Service {

	
	public static void main(String [] args) {
		
		Venue source = new Venue("v1");
		Venue destination = new Venue("v2");
		int session = 2;

		Service service = new Service(source, destination, session);
		//System.out.println(timetable);
		//if (timetable.isEmpty()) {
		 //   System.out.println("Empty");
		//}
		
		System.out.println(service);
		
	}
	
	// REMOVE THIS LINE AND INSERT YOUR INSTANCE VARIABLES AND IMPLEMENTATION
	/*
	 * invariant:
	 * 		&& source != null
	 * 		&& destination != null
	 * 		&& session > 0
	 * 		&& source <> destination
	*/
	
	//private ArrayList<String> venue;
	private Venue source;
	private Venue destination;
	private int session;
	/**
	 * Creates a new service that departs the source venue at the end of the
	 * given session, and arrives at the destination venue before the start of
	 * the next session.
	 * 
	 * @param source
	 *            the venue that the service departs from
	 * @param destination
	 *            the venue that the service arrives at
	 * @param session
	 *            the session when the service departs
	 * @throws NullPointerException
	 *             if either the source or destination is null
	 * @throws InvalidServiceException
	 *             if the source venue equals the destination venue
	 * @throws InvalidSessionException
	 *             if session <= 0
	 */
	public Service(Venue source, Venue destination, int session) {
		this.source = source;
		this.destination = destination;
		this.session = session;
		
		
		if (session <= 0){
			throw new InvalidSessionException("The session less than or equal to 0, therefore invalid");
		}
		
		if (source.equals(destination)){
			throw new InvalidServiceException("The service has the same source and destination");
		}
		
		if (source == null || destination == null){
			throw new NullPointerException("The service has the same source and destination");
		}
	}

	/**
	 * Returns the venue that the service departs from.
	 * 
	 * @return the source venue of this service.
	 */
	public Venue getSource() {
		//System.out.println(source);
		return source;
		
	}

	/**
	 * Returns the venue that the service arrives at.
	 * 
	 * @return the destination venue of this service.
	 */
	public Venue getDestination() {
		//System.out.println(destination);
		return destination; 
	}

	/**
	 * Returns the number of the session when the service departs.
	 * 
	 * (To be precise, the service departs at the end of this session, arriving
	 * before the start of the next session.)
	 * 
	 * @return the session when this service departs
	 */
	public int getSession() {
		//System.out.println(session);
		return session;
	}

	/**
	 * Two services are considered to be equal if they have the same source,
	 * destination and session.
	 * 
	 * (Two venues are considered to be the same if they are equal according to
	 * their equals method.)
	 */
	@Override
	public boolean equals(Object object) {
		
		if (! (object instanceof Service)) return false;
		Service s = (Service)object;
		return source.equals(s.source) && destination.equals(s.destination) && (session == s.session);
		
		//return super.equals(object); // REMOVE THIS LINE AND WRITE THIS METHOD
	}

	@Override
	public int hashCode() {
		
		return source.hashCode() + destination.hashCode() + session;
		
		//return super.hashCode(); // REMOVE THIS LINE AND WRITE THIS METHOD
	}

	/**
	 * Returns a string of the form:
	 * 
	 * "Departs SOURCE after session SESSION for DESTINATION"
	 * 
	 * where SOURCE is the name of the source venue, SESSION is the session
	 * number when this service departs and and DESTINATION is the name of the
	 * destination venue.
	 */
	@Override
	public String toString() {
		String sessionString;
		sessionString = "Departs " + getSource() + 
				" after session " + getSession() + " for " + getDestination();
		return sessionString; // REMOVE THIS LINE AND WRITE THIS METHOD
	}

	/**
	 * Determines whether this Service is internally consistent (i.e. it
	 * satisfies its class invariant).
	 * 
	 * @return true if this Service is internally consistent, and false
	 *         otherwise.
	 */
		
	public boolean checkInvariant() {
		if (source == null || destination == null 
				|| session < 0 || source == destination) {
			return false;
		}
				
		return true; 
	}
}
