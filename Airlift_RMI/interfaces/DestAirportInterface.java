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
	 *  Operation end of work.
	 *
	 *   New operation.
	 *
	 *      @param barbId barber id
	 *      @throws RemoteException if either the invocation of the remote method, or the communication with the registry
	 *                              service fails
	 */

	 public void endOperation (int barberId) throws RemoteException;

	/**
	 *   Operation server shutdown.
	 *
	 *   New operation.
	 *
	 *     @throws RemoteException if either the invocation of the remote method, or the communication with the registry
	 *                             service fails
	 */

	 public void shutdown () throws RemoteException;

}
