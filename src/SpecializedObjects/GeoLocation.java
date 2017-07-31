package SpecializedObjects;


public class GeoLocation {
	private double latitude; 
	private double longitude; 

	public GeoLocation(){}
	public GeoLocation(double latitude, double longitude){
		this.latitude = latitude; 
		this.longitude = longitude; 
	}
	
	/**Returns the latitude of the given Geolocation Object
	 * @return (double) returns latitude 
	 */
	public double getLatitude() {
		return latitude;
	}
	/**Set the latitude of a given object. 
	 * @param latitude
	 */
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	/**Returns the longitude of the given Geolocation Object
	 * @return (double) returns longitude 
	 */
	public double getLongitude() {
		return longitude;
	}
	/**Set the longitude of a given object. 
	 * @param longitude
	 */
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	
	
	
	/**Returns the distance between the invoked point and the coordinates given by latitude and longitude
	 * Assumption: none of the latitudes/longitudes are null.
	 * @param latitude the latitude of the location (x coordinate)
	 * @param longitude the longitude of the location (y coordinate)
	 * @return distance in miles (as the crow flies).
	 */
	public double getDistance(double lat, double lon){
		Double lat1, lat2,lon1,lon2;
		lat1 = Math.toRadians(this.latitude);
		lon1 = Math.toRadians(this.longitude);
		lat2 = Math.toRadians(lat);
		lon2 = Math.toRadians(lon);
		
		//angular distance
		double angle = Math.acos(Math.sin(lat1) * Math.sin(lat2) + Math.cos(lat1) * Math.cos(lat2) * Math.cos(lon1 - lon2));
		double distance = 1.15078*(60*Math.toDegrees(angle));
		
		return distance; 
	}
	/**Returns the distance between the invoked point and the passed location
	 * Assumption: none of the latitudes/longitudes are null.
	 * @param location a Geolocation object, containing latitude and longitude.
	 * @return distance in miles (as the crow files).
	 */
	public double getDistance(GeoLocation location){
		Double lat1, lat2,lon1,lon2;
		
		//set up variables
		lat1 = Math.toRadians(this.latitude);
		lon1 = Math.toRadians(this.longitude);
		lat2 = Math.toRadians(location.getLatitude());
		lon2 = Math.toRadians(location.getLongitude());

		//angular distance
		double angle = Math.acos(Math.sin(lat1) * Math.sin(lat2) + Math.cos(lat1) * Math.cos(lat2) * Math.cos(lon1 - lon2));
		double distance = 1.15078*(60*Math.toDegrees(angle));
		
		return distance; 
	}
	/**Returns the distance between the invoked point and the passed location
	 * Assumption: none of the latitudes/longitudes are null.
	 * @param location Geolocation object, containing latitude and longitude.
	 * @return distance in kilometers (as the crow files).
	 */
	public double getDistanceKilometers(double lat, double lon){
		Double lat1, lat2,lon1,lon2;
		lat1 = Math.toRadians(this.latitude);
		lon1 = Math.toRadians(this.longitude);
		lat2 = Math.toRadians(lat);
		lon2 = Math.toRadians(lon);

		//angular distance
		double angle = Math.acos(Math.sin(lat1) * Math.sin(lat2) + Math.cos(lat1) * Math.cos(lat2) * Math.cos(lon1 - lon2));
		double distance = 1.852*(60*Math.toDegrees(angle));
		
		return distance; 
	}
	/**Returns the distance between the invoked point and the passed location
	 * Assumption: none of the latitudes/longitudes are null.
	 * @param location a Geolocation object, containing latitude and longitude.
	 * @return distance in kilometers (as the crow files).
	 */
	public double getDistanceKilometers(GeoLocation location){
		Double lat1, lat2,lon1,lon2;
		lat1 = Math.toRadians(this.latitude);
		lon1 = Math.toRadians(this.longitude);
		lat2 = Math.toRadians(location.getLatitude());
		lon2 = Math.toRadians(location.getLongitude());
		
		//angular distance
		double angle = Math.acos(Math.sin(lat1) * Math.sin(lat2) + Math.cos(lat1) * Math.cos(lat2) * Math.cos(lon1 - lon2));
		double distance = 1.852*(60*Math.toDegrees(angle));
		
		return distance; 
	}
	/**Returns the distance between the invoked point and the passed location using the Haversine Formula
	 * Assumption: none of the latitudes/longitudes are null.
	 * @param location Geolocation object, containing latitude and longitude.
	 * @return distance in kilometers (as the crow files).
	 */
	public double getHaversineDistanceKilometers(double lat, double lon){
		Double lat1, lat2,lon1,lon2, dlat, dlon;
		/*lat1 = Math.toRadians(this.latitude);
		lon1 = Math.toRadians(this.longitude); */
		dlat = Math.toRadians((lat - this.latitude));
		dlon = Math.toRadians((lon - this.longitude));
		lat1 = Math.toRadians(this.latitude);
		lat2 = Math.toRadians(lat);

		//angular distance  Math.pow(Math.sin(val / 2), 2)
		double a =  Math.pow(Math.sin(dlat / 2), 2) + Math.cos(lat1) * Math.cos(lat2) * Math.pow(Math.sin(dlon / 2), 2);
		double c = 2 * Math.asin(Math.sqrt(a));
		double distance = 6372.8*c;
		
		return distance; 
	}
	/**Returns the distance between the invoked point and the passed location using the Haversine Formula
	 * Assumption: none of the latitudes/longitudes are null.
	 * @param location a Geolocation object, containing latitude and longitude.
	 * @return distance in kilometers (as the crow files).
	 */
	public double getHaversineDistanceKilometers(GeoLocation location){
		Double lat1, lat2,lon1,lon2, dlat, dlon;
		/*lat1 = Math.toRadians(this.latitude);
		lon1 = Math.toRadians(this.longitude); */
		dlat = Math.toRadians((location.getLatitude() - this.latitude));
		dlon = Math.toRadians((location.getLongitude() - this.longitude));
		lat1 = Math.toRadians(this.latitude);
		lat2 = Math.toRadians(location.getLatitude());
		
		//angular distance
		double a =  Math.pow(Math.sin(dlat / 2), 2) + Math.cos(lat1) * Math.cos(lat2) * Math.pow(Math.sin(dlon / 2), 2);
		double c = 2 * Math.asin(Math.sqrt(a));
		double distance = 6372.8*c;
				
		return distance; 
	}
	/**Returns the distance between the invoked point and the passed location using the Haversine Formula
	 * Assumption: none of the latitudes/longitudes are null.
	 * @param location Geolocation object, containing latitude and longitude.
	 * @return distance in miles (as the crow files).
	 */
	public double getHaversineDistance(double lat, double lon){
		Double lat1, lat2,lon1,lon2, dlat, dlon;
		/*lat1 = Math.toRadians(this.latitude);
		lon1 = Math.toRadians(this.longitude); */
		dlat = Math.toRadians((lat - this.latitude));
		dlon = Math.toRadians((lon - this.longitude));
		lat1 = Math.toRadians(this.latitude);
		lat2 = Math.toRadians(lat);

		//angular distance  Math.pow(Math.sin(val / 2), 2)
		double a =  Math.pow(Math.sin(dlat / 2), 2) + Math.cos(lat1) * Math.cos(lat2) * Math.pow(Math.sin(dlon / 2), 2);
		double c = 2 * Math.asin(Math.sqrt(a));
		double distance =  (0.621371* 6372.8)*c;
		
		return distance; 
	}
	/**Returns the distance between the invoked point and the passed location using the Haversine Formula
	 * Assumption: none of the latitudes/longitudes are null.
	 * @param location a Geolocation object, containing latitude and longitude.
	 * @return distance in miles (as the crow files).
	 */
	public double getHaversineDistance(GeoLocation location){
		Double lat1, lat2,lon1,lon2, dlat, dlon;
		/*lat1 = Math.toRadians(this.latitude);
		lon1 = Math.toRadians(this.longitude); */
		dlat = Math.toRadians((location.getLatitude() - this.latitude));
		dlon = Math.toRadians((location.getLongitude() - this.longitude));
		lat1 = Math.toRadians(this.latitude);
		lat2 = Math.toRadians(location.getLatitude());
		
		//angular distance
		double a =  Math.pow(Math.sin(dlat / 2), 2) + Math.cos(lat1) * Math.cos(lat2) * Math.pow(Math.sin(dlon / 2), 2);
		double c = 2 * Math.asin(Math.sqrt(a));
		double distance = (0.621371* 6372.8)*c;
				
		return distance; 
	}
	/**A formatted string containing the Latitude and longitude.
	 * return a formatted string of latitude and longitude
	 */
	@Override
	public String toString(){
		String returnval = this.latitude + "," + this.longitude; 
		return returnval; 
	}

	
}
