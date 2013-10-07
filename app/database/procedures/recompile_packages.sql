DECLARE
  errorMessage VARCHAR2(2048) := '';
  error VARCHAR2(1024) := '';
BEGIN
  DBMS_UTILITY.compile_schema(schema => USER);

  FOR invalid_object IN (
    SELECT object_name, object_type
      FROM user_objects
     WHERE object_type IN ('PACKAGE', 'PACKAGE BODY', 'TRIGGER', 'VIEW', 'PROCEDURE', 'FUNCTION')
       AND status != 'VALID'
    ORDER BY object_name, object_type)
  LOOP
    SELECT text INTO error FROM user_errors
     WHERE name=invalid_object.object_name AND type=invalid_object.object_type and rownum = 1;

    errorMessage := errorMessage || invalid_object.object_type || ' : ' ||
          invalid_object.object_name || ' ' || ' ' || error || CHR(10);
  END LOOP;

  IF LENGTH(errorMessage) > 0 THEN
    raise_application_error(-20001, 'Invalid objects: ' || CHR(10) || errorMessage);
  END IF;
END;