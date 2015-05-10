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
		
		if (duplicateEvents(plan) == false){
			return false;
		}else if (duplicateSessions(plan) == false){
			return false;
		}
		
		for (int i=0; i < plan.size(); i++) {
			
			Event event = plan.get(i);
			int sourceSession = event.getSession();
			Venue source = event.getVenue();
			
			for (int j=0; j < plan.size(); j++) {
				
				int destinationSession = event.getSession();
				Venue destination = event.getVenue();
				
				if (canReach(source, sourceSession, 
						destination, destinationSession) == true){
					return true;
				}
			}
		}
		return false; 
	}
	
	
	private boolean duplicateEvents(List<Event> plan){
		Set<Event> eventSet = new HashSet<Event>(plan);
		if(eventSet.size() < plan.size()){
		    return false;
		}
		return true;
	}
	
	private boolean duplicateSessions(List<Event> plan){
		for (int i=0; i < plan.size(); i++) {
			Event event = plan.get(i);
			int eventSes1 = event.getSession();
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
	
	private boolean canReach(Venue source, int sourceSession, 
			Venue destination, int destinationSession){
		if (sourceSession > destinationSession){
			return false;
		}
		if (sourceSession == destinationSession && source != destination){
			return true;
		}
		if (sourceSession == destinationSession && source == destination){
			return true;
		}
		if (sourceSession < destinationSession && source == destination){
			return true;
		}
		
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
