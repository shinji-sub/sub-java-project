package sub.domain;

import java.sql.Date;

public class Carinfor {
  private int no;
  private String CarType;
  private String CarNumber;
  private String parking;
  private Date Datas;
  private Date Departure;

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
    return Datas;
  }
  public void setDatas(Date datas) {
    Datas = datas;
  }
  public Date getDeparture() {
    return Departure;
  }
  public void setDeparture(Date departure) {
    Departure = departure;
  }
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((CarNumber == null) ? 0 : CarNumber.hashCode());
    result = prime * result + ((CarType == null) ? 0 : CarType.hashCode());
    result = prime * result + ((Datas == null) ? 0 : Datas.hashCode());
    result = prime * result + ((Departure == null) ? 0 : Departure.hashCode());
    result = prime * result + no;
    result = prime * result + ((parking == null) ? 0 : parking.hashCode());
    return result;
  }
  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Carinfor other = (Carinfor) obj;
    if (CarNumber == null) {
      if (other.CarNumber != null)
        return false;
    } else if (!CarNumber.equals(other.CarNumber))
      return false;
    if (CarType == null) {
      if (other.CarType != null)
        return false;
    } else if (!CarType.equals(other.CarType))
      return false;
    if (Datas == null) {
      if (other.Datas != null)
        return false;
    } else if (!Datas.equals(other.Datas))
      return false;
    if (Departure == null) {
      if (other.Departure != null)
        return false;
    } else if (!Departure.equals(other.Departure))
      return false;
    if (no != other.no)
      return false;
    if (parking == null) {
      if (other.parking != null)
        return false;
    } else if (!parking.equals(other.parking))
      return false;
    return true;
  }


}


