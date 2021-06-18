package serverSide.objects;

import java.rmi.*;

import interfaces.*;
import serverSide.main.*;
import clientSide.entities.*;
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

public class DepAirport {
	
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

	private final DepartureAirportProxy[] passen;

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
		passen = new DepartureAirportProxy[SimulPar.nPassengers];
		
		for (int i = 0; i < SimulPar.nPassengers; i++)
			passen[i] = null;
		
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
	

}
