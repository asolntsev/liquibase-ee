package models;

import play.db.jpa.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "payment")
public class Payment extends Model {
  @Column(name = "payment_type") String type;
  @Column(name = "account_from") String accountFrom;
  @Column(name = "account_to") String accountTo;
  @Column(name = "amount") BigDecimal balance;
  @Column(name = "payment_date") Date date;
}
