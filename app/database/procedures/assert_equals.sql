CREATE OR REPLACE PROCEDURE assert_equals (
  table_name IN VARCHAR2,
  field_name IN VARCHAR2,
  filter IN VARCHAR2,
  expected_value IN VARCHAR2
)
IS
  sql_clause VARCHAR2(1024);
  actual_value VARCHAR2(1024);
BEGIN
  sql_clause := 'SELECT ' || field_name || ' FROM ' || table_name;
  IF filter IS NOT NULL THEN
    sql_clause := sql_clause || ' WHERE ' || filter;
  END IF;

  EXECUTE IMMEDIATE sql_clause INTO actual_value;

  assert_equal(expected_value, actual_value);
END assert_equals;