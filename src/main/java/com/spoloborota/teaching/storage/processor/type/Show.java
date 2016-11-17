package com.spoloborota.teaching.storage.processor.type;

import com.spoloborota.teaching.storage.model.RAM;

public class Show {
	
	public static String process(RAM ram, String[] commandWords) {
		boolean isShowed = ram.list(new String[]{commandWords[0]});
		if (isShowed) {
			return "Data showed";
		} else {
			return "There is no selected storage";
		}
	}
}
