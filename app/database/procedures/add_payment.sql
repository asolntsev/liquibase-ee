CREATE OR REPLACE PROCEDURE add_payment (
  account_from  IN VARCHAR2,
  account_to    IN VARCHAR2,
  amount        IN NUMBER,
  payment_date  IN DATE,
  description   IN VARCHAR2
)
IS
  v_payment_type VARCHAR2(6) := 'DEBIT';
BEGIN
  IF amount = 0 THEN
    raise_application_error(-20101, 'Payment must be either positive (debit) or negative (credit)');
  ELSIF amount > 0 THEN
    v_payment_type := 'CREDIT';
  END IF;

  INSERT INTO payment
  VALUES (payment_id_seq.nextval, v_payment_type, account_from, account_to, amount, payment_date, description);
END add_payment;