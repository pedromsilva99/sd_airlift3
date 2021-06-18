package serverSide.objects;

import java.rmi.*;

import interfaces.*;
import serverSide.main.*;

/**
 * Destination Airport shared Region
 */

public class DestAirport implements DestAirportInterface{
	
	/**
	* Reference to passenger threads.
	*/

	private final Thread[] passen;
	
	/**
	 *  Reference to pilot thread.
	 */

	private final Thread[] pilot;
	
	/**
	 *  Reference to hostess thread.
	 */

	private final Thread[] hostess;

	/**
	 * Reference to the general repository.
	 */
	private final GeneralReposInterface repos;

	/**
	 *   Instantiation of DestinationAirport object.
	 *
	 *     @param repos repository object for logging
	 */
	public DestAirport (GeneralReposInterface repos){
		passen = new Thread[SimulPar.nPassengers];
		pilot = new Thread[SimulPar.nPilots];
		hostess = new Thread[SimulPar.nHostess];
		
		for (int i = 0; i < SimulPar.nPassengers; i++)
			passen[i] = null;
		for (int i = 0; i < SimulPar.nPilots; i++)
			pilot[i] = null;
		for (int i = 0; i < SimulPar.nHostess; i++)
			hostess[i] = null;
		this.repos = repos;
	}
	
	/**
	 *  Sleep a certain amount of time to simulate the plane flying to the departure airport.
	 *	After the Sleep, the Pilot changes his state to FLYINGBACK	
	 *     
	 */
	
	@Override
	public synchronized void flyToDeparturePoint () {
		
	}
	
	/**
	 *  Operation end of work.
	 *
	 *   New operation.
	 *
	 *      @param barbId barber id
	 *      @throws RemoteException if either the invocation of the remote method, or the communication with the registry
	 *                              service fails
	 */

	@Override
	public synchronized void endOperation (int barberId) {
		
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
	public synchronized void shutdown () {
		
	}

}
