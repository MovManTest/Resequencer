package com.sabre.client;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import com.sabre.data.FlightLeg;
import com.sabre.interf.ObjectStorage;

public class FlightLegClient {

	private static final int PORT = 1231;
	private static final String HOST = "localhost";
	public static void main(String[] args) throws RemoteException, NotBoundException {
		Registry registry = null;
		
		try {
			registry = LocateRegistry.getRegistry(FlightLegClient.HOST, FlightLegClient.PORT);
		} catch (Exception e) {
			System.out.println("Could not get the registry or create connection for Host: " + 
		                        FlightLegClient.HOST + " and Port: " + FlightLegClient.PORT);
        	e.printStackTrace();
        }
		
		if (registry != null) {
			ObjectStorage flightLegStorage = null;
			try {
				flightLegStorage = (ObjectStorage) registry.lookup("FlightLegStorageServer");
			} catch (Exception e) {
				System.out.println("Could not find FlightLegStorageServer remote object.");
	        	e.printStackTrace();
	        }
			
			if (flightLegStorage != null) {
				FlightLeg flightLeg1 = new FlightLeg(1010, 1, "DFW", "LAX");
				FlightLeg flightLeg2 = new FlightLeg(2020, 2, "DFW", "MEX");
				FlightLeg flightLeg3 = new FlightLeg(3030, 3, "DFW", "MZT");
				FlightLeg tempFlightLeg = null; //this variable is used to hold flight legs as a result of calling GET on the server
				
				flightLegStorage.put(flightLeg3);
				flightLegStorage.put(flightLeg2);
				flightLegStorage.put(flightLeg1);
				
				tempFlightLeg = flightLegStorage.get();
				System.out.println(tempFlightLeg);
				tempFlightLeg = flightLegStorage.get();
				System.out.println(tempFlightLeg);
				tempFlightLeg = flightLegStorage.get();
				System.out.println(tempFlightLeg);
				
				flightLegStorage.put(flightLeg3);
				flightLegStorage.put(flightLeg3);
				flightLegStorage.put(flightLeg1);
				
				System.out.println("---------------------------------------------------------------------------------------------------");
				tempFlightLeg = flightLegStorage.get();
				System.out.println(tempFlightLeg);
				tempFlightLeg = flightLegStorage.get();
				System.out.println(tempFlightLeg);
				tempFlightLeg = flightLegStorage.get();
				System.out.println(tempFlightLeg);
			}
		}
	}

}
