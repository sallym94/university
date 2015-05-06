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
		return false; // REMOVE THIS LINE AND WRITE THIS METHOD
	}

}
