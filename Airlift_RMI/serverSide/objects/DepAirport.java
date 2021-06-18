package serverSide.objects;

import java.rmi.*;

import interfaces.*;
import serverSide.main.*;
import commInfra.*;
import genclass.GenericIO;

/**
 *    Departure airport.
 *
 *    It is responsible to keep a continuously updated account of the passengers inside the departure airport
 *    and is implemented as an implicit monitor.
 *    All public methods are executed in mutual exclusion.
 *    There are six internal synchronization points: four blocking points for the hostess, in one of them she waits for the flight,
 *    in another she waits for the plane to be ready for boarding, 
 *    in another one she wait for the passengers to get to the queue,
 *    and in the other she waits for the passenger to show his documents so that she can check the documents;
 *    and two arrays of blocking points, one of them where the passenger waits in the queue for his turn to show the documents
 *    and the other one where he waits for the hostess to check his documents and to let him enter the plane. 
 */

public class DepAirport implements DepAirportInterface{
	
	/**
	* Control variable for the plane.
	*/

	boolean next_fly = false;
	
   /**
	* Control variable to board the plane.
	*/
	
	boolean plane_ready_boarding = false;

   /**
	* Number of the flight.
	*/

	private int flightNumber = 0;
	
   /**
	* Number of people in line.
	*/

	private int nLine = 0;

   /**
	* Number of people left to fly to destination.
	*/

	private int nLeft = SimulPar.nPassengers;

   /**
	* Reference to passengers on board.
	*/

	private int passengersOnBoard = 0;
   
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
	* Waiting seats occupation.
	*/

	private MemFIFO<Integer> waitingLine;

   /**
	* Reference to call the passenger with ID.
	*/
	
	private int calledPassengerId = -1;

   /**
	* Reference to the general repository.
	*/
	
	private final GeneralReposInterface repos;
	 
   /**
	* Reference to call the passenger.
	*/
	
	private int calledPassengerDocuments = -1;
	
	/**
	*  Departure airport instantiation.
	*
	*    @param repos reference to the general repository
	*/

	public DepAirport(GeneralReposInterface repos) {
		
		nLine = 0;
		passen = new Thread[SimulPar.nPassengers];
		pilot = new Thread[SimulPar.nPilots];
		hostess = new Thread[SimulPar.nHostess];
		
		for (int i = 0; i < SimulPar.nPassengers; i++)
			passen[i] = null;
		for (int i = 0; i < SimulPar.nPilots; i++)
			pilot[i] = null;
		for (int i = 0; i < SimulPar.nHostess; i++)
			hostess[i] = null;
		
		try {
			waitingLine = new MemFIFO<>(new Integer[SimulPar.nPassengers]);
		} 
		catch (MemException e) {
			GenericIO.writelnString("Instantiation of waiting FIFO failed: " + e.getMessage());
			waitingLine = null;
			System.exit(1);
		}
		
		this.repos = repos;
		
	}
	
	/**
	*  Operation wait in queue.
	*
	*  It is called by the passenger when he arrives to the airport.
	*
	*     @throws RemoteException if either the invocation of the remote method, or the communication with the registry
	*     service fails
	*/	
	
	@Override
	public synchronized void waitInQueue() {
		
	}
	
	/**
	*  Operation show documents.
	*
	*  It is called by the passenger when the hostess wants to check his documents.
	*  
	*     @throws RemoteException if either the invocation of the remote method, or the communication with the registry
	*     service fails
	*
	*/	
	
	@Override
	public synchronized void showDocuments() {
		
	}
	
	/**
	*  Operation wait for next passenger.
	*
	*  It is called by the hostess when the plane isn't ready to fly and she has to wait for passengers.
	*
	*  @return passengerId returns the Id from the passenger that is in front of the queue.
	*/	
	
	@Override
	public synchronized int waitForNextPassenger() {
		return 0;
	}
	
	/**
	*  Operation prepare for pass boarding.
	*
	*  It is called by the hostess when she is waiting for the plane to arrive to the transfer gate.
	*
	*  @throws RemoteException if either the invocation of the remote method, or the communication with the registry
	*     service fails
	*/
	
	@Override
	public synchronized void prepareForPassBoarding() {
		
	}
	
	/**
	*  Operation check documents.
	*
	*  It is called by the hostess to check the documents of the first passenger of the queue.
	*
	*  @param waitPassengerId receives the id of the passenger that is having his documents checked
	*  
	*  @throws RemoteException if either the invocation of the remote method, or the communication with the registry
	*     service fails
	*/

	@Override
	public synchronized void checkDocuments(int waitPassengerId) {
		
	}
	
	/**
	*  Operation inform plane ready for boarding.
	*
	*  It is called by the pilot after parking the plane at the transfer gate.
	*  
	*  @throws RemoteException if either the invocation of the remote method, or the communication with the registry
	*     service fails
	*
	*/
	
	@Override
	public synchronized void informPlaneReadyForBoarding() {
		
	}
	
	/**
	*  Operation park at transfer gate.
	*
	*  It is called by the pilot after the flight back to park the plane at the transfer gate.
	*  
	*  @throws RemoteException if either the invocation of the remote method, or the communication with the registry
	*     service fails
	*
	*/
	
	@Override
	public synchronized void parkAtTransferGate() {
		
	}
	
	/**
	*  Operation check end of the day.
	*
	*  Checks if all the passengers have traveled to the destination airport.
	*
	*  @return true if all the passengers have traveled to the destination airport, false otherwise.
	*  
	*  @throws RemoteException if either the invocation of the remote method, or the communication with the registry
	*     service fails
	*
	*/

	@Override
	public synchronized boolean CheckEndOfDay() {
		return false;
	}
	
	/**
	*  Operation wait for next flight.
	*
	*  It is called by the hostess when the plane left the departure airport and 
	*  she has to wait for the next flight to arrive.
	*  
	*  @throws RemoteException if either the invocation of the remote method, or the communication with the registry
	*     service fails
	*
	*/

	@Override
	public synchronized void waitForNextFlight() {
		
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
