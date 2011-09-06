//package edu.nu.sen632.appology;

//import edu.nu.sen632.appology.*;
import java.net.*;
import java.io.*;

public class GridModeratorThread extends Thread {
	private Socket socket = null;

	public GridModeratorThread(Socket socket) {
		super("GridModeratorThread");
		this.socket = socket;
	}

	public void run() {

		try {
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
			BufferedReader in = new BufferedReader(
					new InputStreamReader(
							socket.getInputStream()));

			String inputLine, outputLine;
			RegistrationProtocol rp = new RegistrationProtocol();
			outputLine = rp.processInput(null);
			out.println(outputLine);

			while ((inputLine = in.readLine()) != null) {
				outputLine = rp.processInput(inputLine);
				out.println(outputLine);
				if (outputLine.startsWith("Proceed"))
					break;
			}
			out.close();
			in.close();
			socket.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
