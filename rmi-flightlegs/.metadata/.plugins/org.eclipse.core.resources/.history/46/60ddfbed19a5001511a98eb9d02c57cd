/**
 * 
 */
package com.sabre.server;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * @author x0092516
 *
 */
public class FlightStorageServer {

	private static final int PORT = 1234;
	/**
	 * @param args
	 */
	public static void main(String[] args) throws RemoteException, AlreadyBoundException{
		/* The security manager allows the server to download classes that are
		 * not in our local classpath. This implementation does not use a Security manager because
		 * the server does not download any classes from remote locations
		 * */

        try {
            FlightLegStorage flightLegStorage = new FlightLegStorage();
            Registry registry = LocateRegistry.createRegistry(FlightStorageServer.PORT);
            // rebind is used instead of bind because if it is already bound we always want to rebind it in this case
            registry.rebind("FlightLegStorageServer", flightLegStorage);
            System.out.println("FlightLegStorage server running.");
        } catch (Exception e) {
            System.err.println("FlightLegStorage exception:");
            e.printStackTrace();
        }
	}
}
