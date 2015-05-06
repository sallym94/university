package festival.test;

import org.junit.*;
import java.util.*;
import festival.*;
import java.io.*;

/**
 * Basic tests for the {@link DayPlanner} implementation class.
 * 
 * CSSE7023: Write your own tests for the class here: I have only added two
 * basic ones to get you started. You don't have to use these tests in your own
 * test suite.
 * 
 * A much more extensive test suite will be performed for assessment of your
 * code, but this should get you started writing your own unit tests.
 */
public class DayPlannerTest {

	// Events for use in testing
	private Event[] events = { new Event(new Venue("v1"), 2, "act_a"),
			new Event(new Venue("v2"), 3, "act_d"),
			new Event(new Venue("v3"), 3, "act_e"),
			new Event(new Venue("v3"), 4, "act_i"),
			new Event(new Venue("v4"), 5, "act_f"), };

	/**
	 * Test that the method works correctly for a compatible day plan with three
	 * events.
	 */
	@Test
	public void testCompatiblePlan() throws IOException, FormatException {
		// the planner to test with
		ShuttleTimetable timetable = ScheduleReader.read("timetable_01.txt");
		DayPlanner planner = new DayPlanner(timetable);
		// the day plan to test
		List<Event> plan = new ArrayList<>();
		plan.add(events[0]);
		plan.add(events[1]);
		plan.add(events[4]);

		Assert.assertTrue(planner.compatible(plan));
	}

	/**
	 * Test that the method work correctly for a incompatible plan that contains
	 * two events at the same session.
	 */
	@Test
	public void testIncompatiblePlan() throws IOException, FormatException {
		// the planner to test with
		ShuttleTimetable timetable = ScheduleReader.read("timetable_01.txt");
		DayPlanner planner = new DayPlanner(timetable);
		// the day plan to test
		List<Event> plan = new ArrayList<>();
		plan.clear();
		plan.add(events[0]);
		plan.add(events[1]);
		plan.add(events[2]);
		plan.add(events[3]);
		Assert.assertFalse(planner.compatible(plan));
	}

}
