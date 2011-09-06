//package edu.nu.sen632.appology;

import java.io.*;
import java.util.Arrays;
import java.util.Arrays.*;

public class RegistrationProtocol {
	private static final int WAITING = 0;
	private static final int SENTIDENTIFY = 1;
	private static final int SENTNAME = 2;
	private static final int SENTORIGIN = 3;
	private static final int SENTDESC = 4;
	private static final int OLDWARRIOR = 5;
	private static final int SENTFILES = 6;

	private int state = WAITING;
	private String file_name = "newprogram.wdat";

	public String processInput(String theInput) {
		String theOutput = null;

		if (state == WAITING) {
			theOutput = "Welcome to the Game Grid! " +
					"(N)ew Program or (R)eturning Program?";
			state = SENTIDENTIFY;
		} else if (state == SENTIDENTIFY) {
			if (theInput.equalsIgnoreCase("n")) {
				theOutput = "Creating a new identity disc. What is your name program?";
				state = SENTNAME;
			} else if (theInput.equalsIgnoreCase("r")) {
				String curDir = System.getProperty("user.dir");
				File dir = new File(curDir);
				String[] children = dir.list();
				if (children == null) {
					// Either dir does not exist or is not a directory
				} else {
					for (int i=0; i<children.length; i++) {
						// Get filename of file or directory
						String filename = children[i];
					}
				}
				FilenameFilter filter = new FilenameFilter() {
					public boolean accept(File dir, String name) {
						return name.endsWith(".wdat");
					}
				};
				children = dir.list(filter);
				theOutput = "Welcome back program. Enter the name of your identity disc. " + (Arrays.toString(children));
				state = SENTFILES;
			} else {
				theOutput = "Please make a selection. " +
						"(N)ew Program or (R)eturning Program?";
				state = SENTIDENTIFY;
			}
		} else if (state == SENTFILES) {
			// Read theInput file with inputStream and create warrior object here.
			theOutput = "Proceed to the game grid."; // temporary
			state = WAITING; //temporary
		} else if (state == SENTNAME) {
			if (theInput.length() > 0) {
				file_name = theInput + ".wdat";
				file_name = file_name.replaceAll(" ", "_");
				try {
					File file = new File(file_name);
					boolean success = file.createNewFile();
					if (success) {
						// File did not exist and was created
						FileWriter fstream = new FileWriter(file_name);
						BufferedWriter out = new BufferedWriter(fstream);
						out.write(theInput);
						out.newLine();
						out.close();
						theOutput = "Identity disc created successfully. Place of origin?";
						state = SENTORIGIN;
					} else {
						// File already exists
						theOutput = "Identity disc already exists. (N)ew Program or (R)eturning Program?";
						state = SENTIDENTIFY;
					}
				} catch (IOException e) {
				}
			} else {
				theOutput = "Enter your name program!";
				state = SENTNAME;
			}
		} else if (state == SENTORIGIN) {
			if (theInput.length() > 0) {
				try {
					BufferedWriter out = new BufferedWriter(new FileWriter(file_name, true));
					out.write(theInput);
					out.newLine();
					out.close();
				} catch (IOException e) {
				}
				theOutput = "Program Description?";
				state = SENTDESC;
			} else {
				theOutput = "Enter your place of origin program!";
				state = SENTORIGIN;
			}
		} else if (state == SENTDESC) {
			if (theInput.length() > 0) {
				try {
					BufferedWriter out = new BufferedWriter(new FileWriter(file_name, true));
					out.write(theInput);
					out.newLine();
					out.write("100");
					out.newLine();
					out.close();
				} catch (IOException e) {
				}
				// Read file with inputStream and create warrior object here.
				theOutput = "Proceed to the game grid."; // Add name here
				// Read file with inputStream and create warrior object here.
				state = WAITING; //temporary
			} else {
				theOutput = "Describe yourself program!";
				state = SENTDESC;
			}
		}
		return theOutput;
	}
}
