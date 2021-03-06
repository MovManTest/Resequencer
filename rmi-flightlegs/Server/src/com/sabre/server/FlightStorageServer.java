/**
 * 
 */
package com.sabre.server;

import java.rmi.AccessException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * @author x0092516
 *
 */
public class FlightStorageServer {

	private static final int PORT = 1231;
	private FlightLegStorage flightLegStorage;
	private Registry registry;
	
	public FlightStorageServer() {
		super();
	}

	protected FlightLegStorage createFlightLegStorage() throws RemoteException
	{
		return new FlightLegStorage();
	}
	
	protected Registry createRegistry() throws RemoteException {
		return LocateRegistry.createRegistry(FlightStorageServer.PORT);
	}
	
	protected Registry getRegistry() throws RemoteException {
		return LocateRegistry.getRegistry(FlightStorageServer.PORT);
	}
	
	protected void rebindRegistry(String str, Remote remote) throws AccessException, RemoteException {
		registry.rebind(str, remote);
	}
	
	public void startServer() throws RemoteException
	{
		flightLegStorage = createFlightLegStorage();
		
		try {
			registry = createRegistry();
		} catch (RemoteException re) {
			// If we couldn't create a registry try to get the current one
			System.out.println("Could not create Registry, we will try to get it if it exists.");
			registry = getRegistry();
		}
		
		if (registry != null) {
			rebindRegistry("FlightLegStorageServer", flightLegStorage);
	        System.out.println("FlightLegStorage server running.");
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) throws RemoteException{
		/* The security manager allows the server to download classes that are
		 * not in our local classpath. This implementation does not use a Security manager because
		 * the server does not download any classes from remote locations
		 * */

        FlightStorageServer flightLegStorageServer = new FlightStorageServer();
        
        try {
        	flightLegStorageServer.startServer();
        } catch (Exception e) {
        	e.printStackTrace();
        }
	}
}
