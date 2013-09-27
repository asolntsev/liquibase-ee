package controllers;

import models.Account;
import play.mvc.Controller;

import java.util.List;

public class Bank extends Controller {
  public static void overview() {
    List<Account> accounts = Account.all().fetch();
    render(accounts);
  }
}