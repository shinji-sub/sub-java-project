package sub.domain;

public class Customer {


  private int no;
  private String Cartype;
  private String CarNumbel;
  private String photo;
  private String DiscountRatr;
  private String Payment;
  private String GyeoljeYuhyeong;
  private String parking;
  private String ExitStatus;
  private String acceptance;


  public static Customer valuOf(String csv) {
    String[] data = csv.split(",");

    Customer customer = new Customer();
    customer.setNo(Integer.parseInt(data[0]));
    customer.setCartype(data[1]);
    customer.setCarNumbel(data[2]);
    customer.setPhoto(data[3]);
    customer.setDiscountRatr(data[4]);
    customer.setPayment(data[5]);
    customer.setGyeoljeYuhyeong(data[6]);
    customer.setParking(data[7]);
    customer.setExitStatus(data[8]);
    customer.setAcceptance(data[9]);

    return customer;
  }

  public String toCsvString() {
    return String.format("%d,%s,%s,%s,%s,%s,%s,%s,%s,%s", this.getNo(), this.getCartype(),
        this.getCarNumbel(), this.getPhoto(), this.getDiscountRatr(), this.getPayment(),
        this.getGyeoljeYuhyeong(), this.getParking(), this.getExitStatus(), this.getAcceptance());
  }

  public int getNo() {
    return no;
  }

  public void setNo(int no) {
    this.no = no;
  }

  public String getCartype() {
    return Cartype;
  }

  public void setCartype(String cartype) {
    Cartype = cartype;
  }

  public String getCarNumbel() {
    return CarNumbel;
  }

  public void setCarNumbel(String carNumbel) {
    CarNumbel = carNumbel;
  }

  public String getPhoto() {
    return photo;
  }

  public void setPhoto(String photo) {
    this.photo = photo;
  }

  public String getDiscountRatr() {
    return DiscountRatr;
  }

  public void setDiscountRatr(String discountRatr) {
    DiscountRatr = discountRatr;
  }

  public String getPayment() {
    return Payment;
  }

  public void setPayment(String payment) {
    Payment = payment;
  }

  public String getGyeoljeYuhyeong() {
    return GyeoljeYuhyeong;
  }

  public void setGyeoljeYuhyeong(String gyeoljeYuhyeong) {
    GyeoljeYuhyeong = gyeoljeYuhyeong;
  }

  public String getParking() {
    return parking;
  }

  public void setParking(String parking) {
    this.parking = parking;
  }

  public String getExitStatus() {
    return ExitStatus;
  }

  public void setExitStatus(String exitStatus) {
    ExitStatus = exitStatus;
  }

  public String getAcceptance() {
    return acceptance;
  }

  public void setAcceptance(String acceptance) {
    this.acceptance = acceptance;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((CarNumbel == null) ? 0 : CarNumbel.hashCode());
    result = prime * result + ((Cartype == null) ? 0 : Cartype.hashCode());
    result = prime * result + ((DiscountRatr == null) ? 0 : DiscountRatr.hashCode());
    result = prime * result + ((ExitStatus == null) ? 0 : ExitStatus.hashCode());
    result = prime * result + ((GyeoljeYuhyeong == null) ? 0 : GyeoljeYuhyeong.hashCode());
    result = prime * result + ((Payment == null) ? 0 : Payment.hashCode());
    result = prime * result + ((acceptance == null) ? 0 : acceptance.hashCode());
    result = prime * result + no;
    result = prime * result + ((parking == null) ? 0 : parking.hashCode());
    result = prime * result + ((photo == null) ? 0 : photo.hashCode());
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
    Customer other = (Customer) obj;
    if (CarNumbel == null) {
      if (other.CarNumbel != null)
        return false;
    } else if (!CarNumbel.equals(other.CarNumbel))
      return false;
    if (Cartype == null) {
      if (other.Cartype != null)
        return false;
    } else if (!Cartype.equals(other.Cartype))
      return false;
    if (DiscountRatr == null) {
      if (other.DiscountRatr != null)
        return false;
    } else if (!DiscountRatr.equals(other.DiscountRatr))
      return false;
    if (ExitStatus == null) {
      if (other.ExitStatus != null)
        return false;
    } else if (!ExitStatus.equals(other.ExitStatus))
      return false;
    if (GyeoljeYuhyeong == null) {
      if (other.GyeoljeYuhyeong != null)
        return false;
    } else if (!GyeoljeYuhyeong.equals(other.GyeoljeYuhyeong))
      return false;
    if (Payment == null) {
      if (other.Payment != null)
        return false;
    } else if (!Payment.equals(other.Payment))
      return false;
    if (acceptance == null) {
      if (other.acceptance != null)
        return false;
    } else if (!acceptance.equals(other.acceptance))
      return false;
    if (no != other.no)
      return false;
    if (parking == null) {
      if (other.parking != null)
        return false;
    } else if (!parking.equals(other.parking))
      return false;
    if (photo == null) {
      if (other.photo != null)
        return false;
    } else if (!photo.equals(other.photo))
      return false;
    return true;
  }


}


