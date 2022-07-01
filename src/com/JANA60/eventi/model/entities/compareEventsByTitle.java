package com.JANA60.eventi.model.entities;

import java.util.Comparator;

public class compareEventsByTitle implements Comparator<Event>{

	
	@Override
	public int compare(Event o1, Event o2) {
		int res=o1.getFormattedDate().compareTo(o2.getFormattedDate());
		
		if (res==0)
		{
			res=o1.getTitle().compareTo(o2.getTitle());
		}
		return res;
	}

}
