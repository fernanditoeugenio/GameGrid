//package edu.nu.sen632.appology;

//import edu.nu.sen632.appology.*;
import java.net.*;
import java.io.*;

public class GridModerator {
	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = null;
		boolean listening = true;

		try {
			serverSocket = new ServerSocket(4444);
		} catch (IOException e) {
			System.err.println("Could not listen on port: 4444.");
			System.exit(-1);
		}

		while (listening)
			new GridModeratorThread(serverSocket.accept()).start();

		serverSocket.close();
	}
}
