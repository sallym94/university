package festival;

/**
 * <p>
 * An immutable class representing an event at a music festival.
 * </p>
 * 
 * <p>
 * An event takes place at a venue during one specified session. There is one
 * act associated with an event. (Sessions are denoted simply by positive
 * integers.)
 * </p>
 */
public class Event implements Comparable<Event> {

	
	public static void main(String [] args) {
			
			Event e1 = new Event(new Venue("v1"), 2, new String( "testact"));
			//Service s2 = new Service(new Venue("v2"), new Venue("v3"), 2);
			//System.out.println("test" + s1.equals(s2)); 
			System.out.println(e1);
			
	}
	// REMOVE THIS LINE AND INSERT YOUR INSTANCE VARIABLES AND IMPLEMENTATION
	/*
	 * invariant:
	 * 		&& venue != null
	 * 		&& act != null
	 * 		&& session > 0
	*/
	private Venue venue;
	private int session;
	private String act;
	/**
	 * Creates a new event for the given venue, session and act.
	 * 
	 * @param venue
	 *            the venue of the event
	 * @param session
	 *            the session number of the event
	 * @param act
	 *            the act that will be on at this event
	 * @throws NullPointerException
	 *             if either parameter venue or act is null
	 * @throws InvalidSessionException
	 *             if session is not a positive integer
	 */
	public Event(Venue venue, int session, String act) {
		this.venue = venue;
		this.session = session;
		this.act = act;
		
		if (venue == null || act == null){
			throw new NullPointerException("The venue or act is null");
		}
		
		if (session <=-1){
			throw new InvalidSessionException("The session is not a positive integer");
		}
		
		
	}

	/**
	 * Returns the venue of the event.
	 * 
	 * @return the venue of the event
	 */
	public Venue getVenue() {
		return venue; // REMOVE THIS LINE AND WRITE THIS METHOD
	}

	/**
	 * Returns the session when the event will take place.
	 * 
	 * @return the session number of the event
	 */
	public int getSession() {
		return session; // REMOVE THIS LINE AND WRITE THIS METHOD
	}

	/**
	 * Returns the act that will play at this event.
	 * 
	 * @return the act of the event.
	 */
	public String getAct() {
		return act; // REMOVE THIS LINE AND WRITE THIS METHOD
	}

	/**
	 * Returns a string of the form:
	 * 
	 * "ACT: session SESSION at VENUE"
	 * 
	 * where ACT is the act of the event; SESSION is the session number of the
	 * event; and VENUE is the name of the event's venue.
	 */
	@Override
	public String toString() {
		String sessionString;
		sessionString = getAct() + ": session " + getSession() + " at " + getVenue();
		System.out.println(sessionString);
		return sessionString;
	}

	/**
	 * <p>
	 * Returns true if and only if the given object is an Event with the same
	 * act, venue and session number as this one.
	 * </p>
	 * 
	 * <p>
	 * (Any two venues are considered to be the same when they are equal
	 * according to their equals method. The same applies for acts: two acts are
	 * the same only if the objects associated with those acts are equal
	 * according to their equals methods.)
	 * </p>
	 */
	@Override
	public boolean equals(Object object) {
		return super.equals(object); // REMOVE THIS LINE AND WRITE THIS METHOD
	}

	/**
	 * Returns the hash code of this event; any reasonable implementation of the
	 * hashCode() function is acceptable.
	 * 
	 * @return the hash code of this event
	 */
	@Override
	public int hashCode() {
		return super.hashCode(); // REMOVE THIS LINE AND WRITE THIS METHOD
	}

	/**
	 * Events are ordered primarily by the (lexicographical ordering of their)
	 * venue names, and then (for events at equal venues) by their session
	 * number (in ascending order), and then (for events at the same venue and
	 * session) by the (lexicographical ordering of their) act.
	 */
	@Override
	public int compareTo(Event event) {
		return 0; // REMOVE THIS LINE AND WRITE THIS METHOD
	}

	/**
	 * Determines whether this Event is internally consistent (i.e. it satisfies
	 * its class invariant).
	 * 
	 * @return true if this Event is internally consistent, and false otherwise.
	*/
	public boolean checkInvariant() {
		if (venue == null || act == null || session < 0) {
			return false;
		}
		return true;
	}
}
