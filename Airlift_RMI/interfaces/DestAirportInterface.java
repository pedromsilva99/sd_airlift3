package interfaces;

import java.rmi.*;

/**
 *   Operational interface of a remote object of type Destination Airport.
 *
 *     It provides the functionality to access the Destination Airport.
 */


public interface DestAirportInterface extends Remote{
	
	/**
	 *  Sleep a certain amount of time to simulate the plane flying to the departure airport.
	 *	After the Sleep, the Pilot changes his state to FLYINGBACK	
	 *     
	 */
	   
	public  void flyToDeparturePoint () throws RemoteException;
	   
	/**
	 *  Operation shut server.
	 *
	 *  It shuts down the server.
	 *
	 */
		
	public void shutServer() throws RemoteException;

}
