CREATE OR REPLACE PROCEDURE assert_equal (
  expected_value IN VARCHAR2,
  actual_value IN VARCHAR2
)
IS
BEGIN
  IF actual_value != expected_value THEN
    raise_application_error(-20003, 'Actual value ' || actual_value || ' does not match with expected value ' || expected_value);
  END IF;
END assert_equal;