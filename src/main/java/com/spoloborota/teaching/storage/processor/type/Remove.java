package com.spoloborota.teaching.storage.processor.type;

import com.spoloborota.teaching.storage.model.RAM;

public class Remove {
	
	public static String process(RAM ram, String[] commandWords) {
		boolean isRemoved = ram.remove(new String[]{commandWords[1]});
		if (isRemoved) {
			return "Data removed";
		} else {
			return "There is no selected key";
		}
	}
}
