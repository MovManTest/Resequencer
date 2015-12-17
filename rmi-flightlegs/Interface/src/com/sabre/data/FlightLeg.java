/**
 * 
 */
package com.sabre.data;

import java.io.Serializable;

/**
 * @author x0092516
 *
 */
public class FlightLeg implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int flightNumber;
	private int index;
	private String departureAirport;
	private String arrivalAirport;
	
	public FlightLeg(int flightNumber, int index, String departureAirport, String arrivalAirport) {
		super();
		this.flightNumber = flightNumber;
		this.index = index;
		this.departureAirport = departureAirport;
		this.arrivalAirport = arrivalAirport;
	}
	
	@Override
	public String toString() {
		return "FlightLeg [flightNumber=" + flightNumber + ", index=" + index + ", departureAirport=" + departureAirport
				+ ", arrivalAirport=" + arrivalAirport + "]";
	}

	/**
	 * @return the index
	 */
	public int getIndex() {
		return index;
	}
	
}
