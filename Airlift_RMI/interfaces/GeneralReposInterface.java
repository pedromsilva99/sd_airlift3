package interfaces;

import java.rmi.*;

/**
 *   Operational interface of a remote object of type GeneralRepos.
 *
 *     It provides the functionality to access the General Repository of Information.
 */

public interface GeneralReposInterface extends Remote{
	
	/**
	   *   Operation initialization of simulation.
	   *
	   *   New operation.
	   *
	   *     @param logFileName name of the logging file
	   *     @param nIter number of iterations of the customer life cycle
	   *     @throws RemoteException if either the invocation of the remote method, or the communication with the registry
	   *                             service fails
	   */

	   public void initSimul (String logFileName, int nIter) throws RemoteException;

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
