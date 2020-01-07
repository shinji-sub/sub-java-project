package sub.domain;

import java.sql.Date;

public class Carinfor {
  private int no;
  private String CarType;
  private String CarNumber;
  private String parking;
  private Date datas;
  private String Departure;

  
  public int getNo() {
	return no;
}
public void setNo(int no) {
	this.no = no;
}
public String getCarType() {
	return CarType;
}
public void setCarType(String carType) {
	CarType = carType;
}
public String getCarNumber() {
	return CarNumber;
}
public void setCarNumber(String carNumber) {
	CarNumber = carNumber;
}
public String getParking() {
	return parking;
}
public void setParking(String parking) {
	this.parking = parking;
}
public Date getDatas() {
	return datas;
}
public void setDatas(Date datas) {
	this.datas = datas;
}
public String getDeparture() {
	return Departure;
}
public void setDeparture(String departure) {
	Departure = departure;
}
  
}


