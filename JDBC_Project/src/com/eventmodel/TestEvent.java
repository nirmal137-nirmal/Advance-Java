package com.eventmodel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

public class TestEvent {

	public static void main(String[] args) throws Exception {

//		testNextPk();
//		testAdd();
//		testUpdate();
//		testDelete();
		testSearch();

	}

	public static void testNextPk() {

		EventModel model = new EventModel();

		model.nextPk();

	}

	public static void testAdd() throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		EventModel model = new EventModel();
		EventBean bean = new EventBean();

		bean.setEventId(1);
		bean.setEventName("Java Workshop");
		bean.setEventdate(sdf.parse("2026-09-18"));
		bean.setVenue("IIPS Auditorium");
		bean.setOrganizer("Code Academy");

		model.add(bean);

	}

	public static void testUpdate() throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		EventModel model = new EventModel();
		EventBean bean = new EventBean();

		bean.setEventName("Music Festival");
		bean.setEventdate(sdf.parse("2026-09-20"));
		bean.setVenue("Lal Parade Ground");
		bean.setOrganizer("Rudraveer sena");
		bean.setEventId(3);

		model.update(bean);
	}

	public static void testDelete() {

		EventModel model = new EventModel();

		model.delete(10);
	}

	public static void testSearch() throws Exception {

		EventModel model = new EventModel();
		EventBean bean = new EventBean();

		List list = model.search(bean, 1, 10);

		Iterator it = list.iterator();

		while (it.hasNext()) {

			bean = (EventBean) it.next();
			System.out.println("Event Id : " + bean.getEventId());
			System.out.println("Event Name : " + bean.getEventName());
			System.out.println("Event Date : " + bean.getEventdate());
			System.out.println("Event Venue : " + bean.getVenue());
			System.out.println("Event Organizer : " + bean.getOrganizer());

			System.out.println("-----------------------");
		}
	}

}
