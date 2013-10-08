package controllers;

import models.Payment;
import play.mvc.Controller;

import java.util.List;

public class Payments extends Controller {
  public static void list() {
    List<Payment> payments = Payment.find("order by date desc").fetch();
    render(payments);
  }
}