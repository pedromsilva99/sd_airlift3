package interfaces;

import java.rmi.*;

/**
 *   Operational interface of a remote object of type GeneralRepos.
 *
 *     It provides the functionality to access the General Repository of Information.
 */

public interface GeneralReposInterface extends Remote{
	
	/**
	 *   Set pilot state.
	 *
	 *     @param state pilot state
	 */

	public void setPilotState (int state) throws RemoteException;
	
	/**
	 *   Set passenger state.
	 *
	 *     @param id passenger id
	 *     @param state passenger state
	 */

	public void setPassengerState (int id, int state) throws RemoteException;
	
	/**
	 *   Set hostess state.
	 *
	 *     @param state hostess state
	 *     
	 */

	public void setHostessState (int state) throws RemoteException;
	
	/**
	 *   Set hostess state.
	 *
	 *     @param state hostess state
	 *     @param passengerId id for the log
	 *     
	 */

	public void setHostessState (int state, int passengerId) throws RemoteException;
	
	/**
	 *   Set inQueue number.
	 *
	 *     @param number number to add to inQueue
	 */

	public void setQueue (int number) throws RemoteException;
	
	/**
	 *   Set inFlight number.
	 *
	 *     @param number number to add to inFlight
	 */

	public void setFlight (int number) throws RemoteException;
	
	/**
	 *   Set inDestination number.
	 *
	 *     @param number number to add to inDestination
	 */

	public void setDestisnation (int number) throws RemoteException;
	
	/**
	 *   Write a specific state line at the end of the logging file, for example an message informing that
	 *   the plane has arrived.
	 *
	 *     @param message message to write in the logging file
	 */

	public void reportSpecificStatus (String message) throws RemoteException;
	
	
	/**
	 *  Write the header to the logging file.
	 *
	 *  The pilot is flying back, the passengers are going to the airport and the hostess is waiting for the flight
	 *  Internal operation.
	 */
	
	public void reportInitialStatus () throws RemoteException;
	
	/**
	 *  Write a state line at the end of the logging file.
	 *
	 *  The current state of the pilot, hostess and passengers is organized in a line to be printed.
	 *  Internal operation.
	 */

	public void reportStatus () throws RemoteException;
	
	
	/**
	 *   Operation initialization of simulation.
	 *
	 *   New operation.
	 *
	 *     @param logFileName name of the logging file
	 *     @throws RemoteException if either the invocation of the remote method, or the communication with the registry
	 *                             service fails
	 */

	public void initSimul (String logFileName) throws RemoteException;

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
