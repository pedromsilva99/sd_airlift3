package serverSide.objects;

import java.rmi.*;

import interfaces.*;
import serverSide.main.*;
import commInfra.*;
import genclass.GenericIO;

/**
 *    Plane.
 *
 *    It is responsible to keep a continuously updated account of the passengers inside the plane
 *    and is implemented as an implicit monitor.
 *    All public methods are executed in mutual exclusion.
 *    There are four internal synchronization points: two single blocking point for the pilot, one where he waits for the signal
 *    that all passengers have entered the plane and another where he waits for all passengers to leave the plane;
 *    one an array of blocking points, one per each passenger, where he waits for the plane to arrive at the destination airport;
 *    and one single blocking point for the hostess, where she waits for all the passengers to enter the plane to tell the pilot.
 *    where cutting chair while having his hair cut.
 */

public class Plane implements PlaneInterface{
	
	/**
	*  Number of passengers in the plane.
	*/
	
	private int nPassengers = 0;
	
   /**
	*  Vector for saving the number of passengers per flight.
	*/
	
	private int [] nPassForFlight;
	
   /**
	*  Number of passengers that left the flight.
	*/
	private int nPassengersLeft = 0;
	
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
	*   Plane seats occupation.
	*/
	
	private MemFIFO<Integer> planeSeats; 
	
   /**
	* Number of the flight.
	*/
	
	private int flightNumber = 0;
	 
   /**
	*   Reference to the general repository.
	*/
	
	private final GeneralReposInterface repos;
	
   /**
	*  Variable that signals the flight arrival
	*/
	private boolean allOnBoard = false;
	
   /**
	*  Variable that signals the flight arrival
	*/
	private boolean arrived = false;
	   
   /**
	*  Plane instantiation.
	*
	*    @param repos reference to the general repository
	*/
 	
	public Plane (GeneralReposInterface repos) {
		
		nPassForFlight = new int [5];
		passen = new Thread[SimulPar.nPassengers];
		pilot = new Thread[SimulPar.nPilots];
		hostess = new Thread[SimulPar.nHostess];
		
		for (int i = 0; i < SimulPar.nPassengers; i++)
			passen[i] = null;
		for (int i = 0; i < SimulPar.nPilots; i++)
			pilot[i] = null;
		for (int i = 0; i < SimulPar.nHostess; i++)
			hostess[i] = null;
		try
		{ planeSeats = new MemFIFO<> (new Integer [SimulPar.maxInPlane]);
		}
		catch (MemException e)
		{ GenericIO.writelnString ("Instantiation of waiting FIFO failed: " + e.getMessage ());
        	planeSeats = null;
        	System.exit (1);
		}
		this.repos = repos;
    }
	
	/**
	 *  Operation board the plane.
	 *
	 *  It is called by a passenger when he has permission to enter the plane.
	 *
	 */
	
	@Override
	public synchronized void boardThePlane () throws RemoteException{
		
	}
	
	/**
	*  Operation wait for all in board.
	*
	*  It is called by the pilot after he signals that the plane is ready for boarding.
	*  The pilot waits for all the passengers to enter the plane.
	*
	*/
	
	@Override
	public void waitForAllInBoard() throws RemoteException{
		
	}
	
	/**
	*  Operation inform plane ready to take off.
	*
	*  It is called by the hostess after every passenger entering the plane.
	*
	*  @param nboarded number of people that boarded the plane
	*/
	
	@Override
	public void informPlaneReadyToTakeOff(int nboarded) throws RemoteException{
		
	}
	
	/**
	*  Operation fly to destination point.
	*
	*  It is called by the pilot to fly to the destination airport.
	*
	*/	
	
	@Override
	public synchronized void flyToDestinationPoint () throws RemoteException{
		
	}

	/**
	*  Operation announce arrival.
	*
	*  It is called by the pilot when he arrives at the destination airport.
	*
	*/		
	
	@Override
	public synchronized void announceArrival () throws RemoteException{
		
	}
	
	/**
	*  Operation leave the plane.
	*
	*  It is called by the passenger to leave the plane.
	*
	*/	
	
	@Override
	public synchronized void leaveThePlane () throws RemoteException{
		
	}
	
	/**
	*  Operation last print.
	*
	*  It is called by the pilot in the end to print the last information lines of the logger file.
	*
	*/
	
	@Override
	public synchronized void lastPrint() throws RemoteException{
		
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
	public synchronized void endOperation (int barberId) throws RemoteException{
		 
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
