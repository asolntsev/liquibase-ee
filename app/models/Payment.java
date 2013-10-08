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
  @Column(name = "payment_type") public String type;
  @Column(name = "account_from") public String accountFrom;
  @Column(name = "account_to") public String accountTo;
  @Column(name = "amount") public BigDecimal amount;
  @Column(name = "payment_date") public Date date;
  @Column public String description;
}
