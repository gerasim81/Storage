package com.spoloborota.teaching.storage.processor;

import com.spoloborota.teaching.storage.commands.Commands;
import com.spoloborota.teaching.storage.model.RAM;
import com.spoloborota.teaching.storage.processor.type.Add;
import com.spoloborota.teaching.storage.processor.type.Create;
import com.spoloborota.teaching.storage.processor.type.Display;
import com.spoloborota.teaching.storage.processor.type.Save;
import com.spoloborota.teaching.storage.processor.type.Use;
import com.spoloborota.teaching.storage.processor.type.Shutdown;

/**
 * process commands
 * @author Spoloborota
 *
 */
public class Processor {
	public RAM ram;

	public Processor(RAM ram) {
		this.ram = ram;
	}
	public String process(String commandString) {
		String[] commandWords = commandString.trim().split("\\s+");
		if (commandWords.length != 0) {
			for (String s : commandWords) {
				System.out.println(s);
			}

			String result = "";
			switch (commandWords[0]) {
			case Commands.DISPLAY:
				result = Display.process(ram);
				break;

			case Commands.USE:
				if (commandWords.length > 1) {
					result = Use.process(ram, commandWords);
				} else {
					result = "Storage name does not specified";
				}
				break;

			case Commands.CREATE:
				if (commandWords.length > 1) {
					result = Create.process(ram, commandWords);
				} else {
					result = "Storage name does not specified";
				}
				break;

			case Commands.ADD:
				if (commandWords.length > 2) {
					result = Add.process(ram, commandWords);					
				} else {
					result = "Data for storage does not specified correctly";
				}
				break;

			case Commands.SAVE:
				result = Save.process(ram);					
				break;

			case Commands.SHUTDOWN:
				boolean saveFlg = false;
				Shutdown shutdown = new Shutdown();
				saveFlg = shutdown.askSaveOrNot();
				if (saveFlg){
					result = Save.process(ram);
				}
				System.out.println(result);
				System.out.println("Good bye!");
				System.exit(0);
			}
			return result;
		} else {
			return "You do not entered any comand";
		}
	}

}
