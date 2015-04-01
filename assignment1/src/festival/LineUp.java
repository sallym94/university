package festival;

import java.util.*;

/**
 * <p>
 * A mutable class representing the line-up of a festival.
 * </p>
 * 
 * <p>
 * The line-up of a festival keeps track of the events that are scheduled to
 * take place. Time during the festival is broken up into a number of
 * consecutive sessions, and each event is scheduled to take place at a given
 * venue in a particular session. (Sessions are denoted simply by positive
 * integers.)
 * 
 * The session times are the same for all venues, so that events taking place in
 * the same session at different venues, are actually taking place at the same
 * time.
 * </p>
 * 
 * <p>
 * At most one event can be scheduled for a venue in a particular session,
 * although there is no requirement that there is an event scheduled at a venue
 * for every session.
 * </p>
 */
public class LineUp implements Iterable<Event> {

	// REMOVE THIS LINE AND INSERT YOUR INSTANCE VARIABLES AND IMPLEMENTATION
	// INVARIANT HERE

	/**
	 * Creates a new line-up with no events scheduled.
	 */
	public LineUp() {
		// REMOVE THIS LINE AND WRITE THIS METHOD
	}

	/**
	 * Adds a new event to the line-up.
	 * 
	 * @param event
	 *            the event to be added to the line-up
	 * @throws NullPointerException
	 *             if event is null
	 * @throws InvalidLineUpException
	 *             if there is already an event scheduled for the same venue and
	 *             session as the given event
	 */
	public void addEvent(Event event) {
		// REMOVE THIS LINE AND WRITE THIS METHOD
	}

	/**
	 * If the line-up contains an event that is equivalent to this one, then it
	 * is removed from the line-up. If there is no equivalent event, then the
	 * line-up is unchanged by the operation.
	 *
	 * @param event
	 *            the event to be removed from the line-up.
	 */
	public void removeEvent(Event event) {
		// REMOVE THIS LINE AND WRITE THIS METHOD
	}

	/**
	 * Returns a list of the events scheduled for the given venue. The list of
	 * events should be ordered by session number (in ascending order).
	 * 
	 * @param venue
	 *            the venue for which the events will be retrieved
	 * @return a list of the events scheduled for the given venue, ordered by
	 *         session number
	 * @throws NullPointerException
	 *             if the given venue is null
	 */
	public List<Event> getEvents(Venue venue) {
		return null; // REMOVE THIS LINE AND WRITE THIS METHOD
	}

	/**
	 * Returns a list of the events scheduled for the given session time (across
	 * all venues). The list should be ordered by venue name (in ascending
	 * order).
	 * 
	 * @param session
	 *            the session to retrieve the events for
	 * @return A list of the events scheduled for the given session time.
	 * @throws InvalidSessionException
	 *             if session <= 0
	 */
	public List<Event> getEvents(int session) {
		return null; // REMOVE THIS LINE AND WRITE THIS METHOD
	}

	/**
	 * Returns a set of all the venues where at least one event from the line-up
	 * takes place.
	 * 
	 * @return The venues where events from the line-up will take place.
	 */
	public Set<Venue> getVenues() {
		return null; // REMOVE THIS LINE AND WRITE THIS METHOD
	}

	/**
	 * If there is at least one event scheduled, then this method returns the
	 * number of the first session where there is an event scheduled. Otherwise
	 * it returns 0.
	 * 
	 * @return If there is at least one event scheduled, then the first session
	 *         number that an event is scheduled for, and 0 otherwise.
	 */
	public int getFirstUsedSession() {
		return -1; // REMOVE THIS LINE AND WRITE THIS METHOD
	}

	/**
	 * If there is at least one event scheduled, then this method returns the
	 * number of the last session where there is an event scheduled. Otherwise
	 * it returns 0.
	 * 
	 * @return If there is at least one event scheduled, then the last session
	 *         number that an event is scheduled for, and 0 otherwise.
	 */
	public int getLastUsedSession() {
		return -1; // REMOVE THIS LINE AND WRITE THIS METHOD
	}

	/**
	 * Returns an iterator over the events in the line-up.
	 */
	@Override
	public Iterator<Event> iterator() {
		return null; // REMOVE THIS LINE AND WRITE THIS METHOD
	}

	/**
	 * The string representation of a line-up contains a line-separated
	 * concatenation of the string representations of the events in the line up.
	 * The events in the line-up should be ordered using their natural ordering
	 * (i.e. using the compareTo method defined in the Event class).
	 * 
	 * The line separator string used to separate the events should be retrieved
	 * in a machine-independent way by calling the function
	 * System.getProperty("line.separator").
	 */
	@Override
	public String toString() {
		return null; // REMOVE THIS LINE AND WRITE THIS METHOD
	}

	/**
	 * Determines whether this LineUp is internally consistent (i.e. it
	 * satisfies its class invariant).
	 * 
	 * @return true if this LineUp is internally consistent, and false
	 *         otherwise.
	 */
	public boolean checkInvariant() {
		return true; // REMOVE THIS LINE AND WRITE THIS METHOD
	}

}
