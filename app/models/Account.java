package models;

import play.db.jpa.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "account")
public class Account extends Model {
  @Column(name = "account_id") String accountId;
  @Column(name = "balance") BigDecimal balance;

	public Account(String accountId, BigDecimal balance) {
		this.accountId = accountId;
		this.balance = balance;
	}
}
