/**
 * 
 */
package com.sabre.interf;

/**
 * @author Jaime Aldana
 *
 */

import java.rmi.Remote;
import java.rmi.RemoteException;

import com.sabre.data.FlightLeg;

/* By extending "Remote" we indicate that the methods of this interface can be
   called by other JVMs
*/
public interface ObjectStorage extends Remote{
	public void put(FlightLeg flightLeg)  throws RemoteException;
	public FlightLeg get()  throws RemoteException;
}
