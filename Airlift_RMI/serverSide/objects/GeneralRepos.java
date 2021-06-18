package serverSide.objects;

import java.rmi.*;
import interfaces.*;
import serverSide.main.*;
import clientSide.entities.*;

/**
 *  General Repository of information.
 *
 *    It is responsible to keep the visible internal state of the problem and to provide means for it
 *    to be printed in the logging file.
 *    It is implemented as an implicit monitor.
 *    All public methods are executed in mutual exclusion.
 *    There are no internal synchronization points.
 *    Implementation of a client-server model of type 2 (server replication).
 *    Communication is based on Java RMI.
 */

public class GeneralRepos implements GeneralReposInterface{
	
	/**
	 *  Name of the logging file.
	 */
	private final String logFileName;

	/**
	 *  State of the pilot.
	 */
	private int pilotState;

	/**
	 *  State of the passengers.
	 */
	private final int [] passengerState;

	/**
	 *  State of the hostess.
	 */
	private int hostessState;

	/**
	 *  Number of passengers presently forming a queue to board the plane
	 */
	private int inQueue = 0;

	/**
	 *  Number of flight
	 */
	private int flightNumber = 1;

	/**
	 *  Number of passengers in the plane
	 */
	private int inFlight = 0;

	/**
	 *  Number of passengers that have already arrived at their destination
	 */
	private int inDestination = 0;

	/**
	 *   Instantiation of a general repository object.
	 *
	 *     @param logFileName name of the logging file
	 */
	public GeneralRepos () {
		this.logFileName = "logger";
		pilotState = PilotStates.ATTRANSFERGATE;
		passengerState = new int [SimulPar.nPassengers];
		for (int i = 0; i < SimulPar.nPassengers; i++)
			passengerState[i] = PassengerStates.GOINGTOAIRPORT;
		hostessState = HostessStates.WAITFORFLIGHT;
		//reportInitialStatus ();
	}
	
	/**
	 *   Set pilot state.
	 *
	 *     @param state pilot state
	 */

	@Override
	public synchronized void setPilotState (int state) throws RemoteException{
		
	}
	
	/**
	 *   Set passenger state.
	 *
	 *     @param id passenger id
	 *     @param state passenger state
	 */

	@Override
	public synchronized void setPassengerState (int id, int state) throws RemoteException{
		
	}
	
	/**
	 *   Set hostess state.
	 *
	 *     @param state hostess state
	 *     
	 */

	@Override
	public synchronized void setHostessState (int state) throws RemoteException{
		
	}

	/**
	 *   Set inQueue number.
	 *
	 *     @param number number to add to inQueue
	 */

	@Override
	public synchronized void setQueue (int number) throws RemoteException{
		
	}
	
	/**
	 *   Set inFlight number.
	 *
	 *     @param number number to add to inFlight
	 */

	@Override
	public synchronized void setFlight (int number) throws RemoteException{
		
	}
	
	/**
	 *   Set inDestination number.
	 *
	 *     @param number number to add to inDestination
	 */

	@Override
	public synchronized void setDestisnation (int number) throws RemoteException{
		
	}
	
	/**
	 *   Write a specific state line at the end of the logging file, for example an message informing that
	 *   the plane has arrived.
	 *
	 *     @param message message to write in the logging file
	 */

	@Override
	public synchronized void reportSpecificStatus (String message) throws RemoteException{
		
	}
	
	/**
	 *   Operation initialization of simulation.
	 *
	 *   New operation.
	 *
	 *     @param logFileName name of the logging file
	 *     @throws RemoteException if either the invocation of the remote method, or the communication with the registry
	 *                             service fails
	 */

	@Override
	public synchronized void initSimul (String logFileName) throws RemoteException{
		
	}
	
	/**
	 *   Operation server shutdown.
	 *
	 *   New operation.
	 *
	 *     @throws RemoteException if either the invocation of the remote method, or the communication with the registry
	 *                             service fails
	 */

	@Override
	public synchronized void shutdown () throws RemoteException{
		
	}
}
