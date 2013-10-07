CREATE OR REPLACE PROCEDURE assert_count (
  table_name IN VARCHAR2,
  filter IN VARCHAR2 := NULL,
  expected_count IN NUMBER
)
IS
  sql_clause VARCHAR2(1024);
  actual_count NUMBER;
BEGIN
  sql_clause := 'SELECT COUNT(*) FROM ' || table_name;
  IF filter IS NOT NULL THEN
    sql_clause := sql_clause || ' WHERE ' || filter;
  END IF;

  EXECUTE IMMEDIATE sql_clause INTO actual_count;

  assert_equal(expected_count, actual_count);
END assert_count;