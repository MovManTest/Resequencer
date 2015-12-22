package com.sabre.server;

import static org.junit.Assert.*;

import java.rmi.AccessException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class FlightStorageServerTest {

	@InjectMocks
	private FlightStorageServer flightLegStorageServer;
	
	@Mock
	private Registry registry;
	
	@Before
	public void setup() throws RemoteException {
		MockitoAnnotations.initMocks(this);
		
		flightLegStorageServer = Mockito.spy(new FlightStorageServer());
		// TODO: How can I create a registry without the need of calling getRegistry?
		try {
			registry = LocateRegistry.getRegistry();
		} catch (RemoteException re) {
			fail("Could not get the Registry");
		}
		
		Mockito.doReturn(registry)
		.when(flightLegStorageServer)
		.getRegistry();
	}
	
	// testSuccess will test the happy path scenario, when everything goes as expected
	@Test
	public void testSuccess() throws RemoteException {
		Mockito.doNothing()
	      .when(flightLegStorageServer)
	      .rebindRegistry(Mockito.any(String.class), Mockito.any(Remote.class));
		
		flightLegStorageServer.startServer();
		Mockito.verify(flightLegStorageServer).rebindRegistry(Mockito.any(String.class), Mockito.any(Remote.class));
	}

	// testAccessExceptionOnRebind will test the scenario when calling rebindRegistry throws an Access Exception
	@Test (expected = AccessException.class)
	public void testAccessExceptionOnRebind() throws RemoteException {

		Mockito.doThrow(AccessException.class)
	      .when(flightLegStorageServer)
	      .rebindRegistry(Mockito.any(String.class), Mockito.any(Remote.class));
		
		flightLegStorageServer.startServer();
		Mockito.verify(flightLegStorageServer).rebindRegistry(Mockito.any(String.class), Mockito.any(Remote.class));
	}
	
	// testRemoteExceptionOnRebind will test the scenario when calling rebindRegistry throws an RemoteException
	@Test (expected = RemoteException.class)
	public void testRemoteExceptionOnRebind() throws RemoteException {
		Mockito.doThrow(RemoteException.class)
	      .when(flightLegStorageServer)
	      .rebindRegistry(Mockito.any(String.class), Mockito.any(Remote.class));
		
		flightLegStorageServer.startServer();
		Mockito.verify(flightLegStorageServer).rebindRegistry(Mockito.any(String.class), Mockito.any(Remote.class));
	}
	
	// testRemoteExceptionOnCreateFlightLegStorage will test the scenario when calling
	// createFlightLegStorage throws an RemoteException
	@Test (expected = RemoteException.class)
	public void testRemoteExceptionOnCreateFlightLegStorage() throws RemoteException {
		Mockito.doThrow(RemoteException.class)
	      .when(flightLegStorageServer)
	      .createFlightLegStorage();
		
		flightLegStorageServer.startServer();
		Mockito.verify(flightLegStorageServer).createFlightLegStorage();
	}
}
