package festival;

import java.util.*;

/**
 * A class with functionality for helping a festival-goer to plan their day at a
 * festival.
 */
public class DayPlanner {

	// the timetable of the festival
	private ShuttleTimetable timetable;

	/**
	 * @require timetable!=null
	 * @ensure Creates a new day planner for a festival with a copy of the given
	 *         shuttle timetable (so that changes to the parameter timetable
	 *         from outside of this class won't affect the timetable of the
	 *         day-planner.)
	 */
	public DayPlanner(ShuttleTimetable timetable) {
		this.timetable = new ShuttleTimetable();
		for (Service service : timetable) {
			this.timetable.addService(service);
		}
	}

	/**
	 * @require plan!=null && !plan.contains(null) && the events in the plan are
	 *          ordered (smallest to largest) by session number.
	 * @ensure Returns true if the events in the plan are compatible (as per
	 *         assignment hand-out). That is, (i) no event appears more than
	 *         once in the plan and no two different events in the plan are
	 *         scheduled for the same session, and (ii) for each event in the
	 *         plan, it is possible to go to that event and then (using the
	 *         available shuttle services in the day-planner's timetable if
	 *         necessary), get to the next event in the plan (on time), if there
	 *         is one.
	 * 
	 *         The timetable of the day-planner must not be modified in any way
	 *         by this method.
	 * 
	 *         See the assignment hand-out for details.
	 */
	public boolean compatible(List<Event> plan) {
		/*checks there are no duplicates within the plan
		 * if not returns false
		 */
		
		if (duplicateEvents(plan) == false){
			return false;
		}else if (duplicateSessions(plan) == false){
			return false;
		}
		
		/*compares the events to see if they are compatible
		 * and that the plan works
		 */
		for (int i=0; i < plan.size(); i++) {
			
			//gets an event
			Event sourceEvent = plan.get(i);
			//sets the source session for the event
			int sourceSession = sourceEvent.getSession();
			//sets the source venue for the event
			Venue source = sourceEvent.getVenue();
			
			for (int j=0; j < plan.size(); j++) {
				//gets the event to compare with
				Event event = plan.get(j);
				//sets the destination session for the event
				int destinationSession = event.getSession();
				//sets the destination venue for the event
				Venue destination = event.getVenue();
				//uses canReach method to see if the journey is possible
				if (canReach(source, sourceSession, 
						destination, destinationSession) == true){
					return true;
				}
			}
		}
		return false; 
	}
	
	/**
	* <p>
	 * returns true or false as to whether there are any duplicates
	 * events in the list
	 * </p>
	 * 
	 * @param plan
	 *            the list a plan of events
	 * 
	 */
	private boolean duplicateEvents(List<Event> plan){
		//creates a set from the list to condense the tokens
		Set<Event> eventSet = new HashSet<Event>(plan);
		//if the set is smaller than there are duplicate events
		if(eventSet.size() < plan.size()){
		    return false;
		}
		return true;
	}
	
	/**
	* <p>
	 * returns true or false as to whether there are any duplicates
	 * sessions in the list
	 * </p>
	 * 
	 * @param plan
	 *            the list a plan of events
	 * 
	 */
	private boolean duplicateSessions(List<Event> plan){
		/*creates loop to check every session against
		 * the other sessions
		 */
		for (int i=0; i < plan.size(); i++) {
			Event event = plan.get(i);
			int eventSes1 = event.getSession();
			//creates a loop insides to compare i and j
			for (int j=0; j < plan.size(); j++) {
				Event event2 = plan.get(i);
				int eventSes2 = event2.getSession();
				if (eventSes1 == eventSes2){
					return false;
				}
			}
		}
		return true;
	}
	
	/**
	* <p>
	 * returns true or false as to whether it is possible to reach
	 * the destination in time for the session
	 * </p>
	 * 
	 * @param source
	 *            the source venue
	 * @param sourceSession
	 *            the session of the source venue
	 * @param destination
	 *            the destination venue
	 * @param destinationSession
	 *            the session of the destination venue
	 */
	private boolean canReach(Venue source, int sourceSession, 
			Venue destination, int destinationSession){
		//tests first base case whether sourceSession > destinationSession
		if (sourceSession > destinationSession){
			return false;
		}
		//tests second base
		if (sourceSession == destinationSession && source != destination){
			return true;
		}
		//tests third base
		if (sourceSession == destinationSession && source == destination){
			return true;
		}
		//tests fourth base
		if (sourceSession < destinationSession && source == destination){
			return true;
		}
		//uses recursive method to solve final case **Note, I know this doesn't work
		if (sourceSession < destinationSession && source != destination){
			Venue finalDestination = destination;
			int finalSession = destinationSession;
			
			if (timetable.getDestinations(source, sourceSession).contains(finalDestination)){
				return true;
			}
			else {
				canReach(source, sourceSession, 
						destination, destinationSession);
			}
		}
		return false;
	}

}
