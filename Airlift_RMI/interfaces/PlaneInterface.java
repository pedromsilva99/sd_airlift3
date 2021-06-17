package interfaces;

import java.rmi.*;

/**
 *   Operational interface of a remote object of type Plane.
 *
 *     It provides the functionality to access the Plane.
 */

public interface PlaneInterface extends Remote{
	
	/**
	 *  Operation board the plane.
	 *
	 *  It is called by a passenger when he has permission to enter the plane.
	 *
	 */
	
	public void boardThePlane () throws RemoteException;
	
	/**
	*  Operation wait for all in board.
	*
	*  It is called by the pilot after he signals that the plane is ready for boarding.
	*  The pilot waits for all the passengers to enter the plane.
	*
	*/
	
	public void waitForAllInBoard() throws RemoteException;
	
	/**
	*  Operation inform plane ready to take off.
	*
	*  It is called by the hostess after every passenger entering the plane.
	*
	*  @param nboarded number of people that boarded the plane
	*/
	
	public void informPlaneReadyToTakeOff(int nboarded) throws RemoteException;
	
	/**
	*  Operation fly to destination point.
	*
	*  It is called by the pilot to fly to the destination airport.
	*
	*/	
	
	public void flyToDestinationPoint () throws RemoteException;
	
	/**
	*  Operation announce arrival.
	*
	*  It is called by the pilot when he arrives at the destination airport.
	*
	*/		
		
	public void announceArrival () throws RemoteException;
	
	/**
	*  Operation leave the plane.
	*
	*  It is called by the passenger to leave the plane.
	*
	*/	
	
	public void leaveThePlane () throws RemoteException;
	
	/**
	*  Operation last print.
	*
	*  It is called by the pilot in the end to print the last information lines of the logger file.
	*
	*/
	
	public void lastPrint() throws RemoteException;
	
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
