select * from formulafcm;

create or replace function math_calc(p_statement_txt varchar) return number
is
  v_cursor_id_num int;
  v_statement_txt varchar(500);
  v_rowcount_num int;
  v_return_value_num number;
begin
  v_cursor_id_num := dbms_sql.open_cursor;
  v_statement_txt :=
    'begin ' ||
    '    :lv_value_num := ' || p_statement_txt || ';' ||
    'end;';
  dbms_sql.parse(v_cursor_id_num, v_statement_txt, dbms_sql.native);
  dbms_sql.bind_variable(v_cursor_id_num, ':lv_value_num', v_return_value_num);

  v_rowcount_num := dbms_sql.execute(v_cursor_id_num);

  dbms_sql.variable_value(v_cursor_id_num, ':lv_value_num', v_return_value_num);
  dbms_sql.close_cursor(v_cursor_id_num);
  return v_return_value_num;
exception
  when others then
    if dbms_sql.is_open(v_cursor_id_num) THEN
      dbms_sql.close_cursor(v_cursor_id_num);
    end if;
    raise_application_error(-20101, 'Error processing SQL ' || 'statement in MATH_CALC procedure', false);
end;
/

select getIdade(50) from dual;

create or replace function getIdade(p_id_atleta Atleta.id%type) return number
is
  v_idade number;
begin
  select (sysdate-data_nascimento)/365 into v_idade
    from Atleta
   where id = p_id_atleta;
  return v_idade;
end;
/

create or replace function parseFormulaFCM(
  p_id_formula FormulaFCM.id%type, p_id_atleta Atleta.id%type) return varchar
is
  v_idade number;
  v_ret varchar(2000);
begin
  select formula into v_ret
    from FormulaFCM
   where id = p_id_formula;
  v_ret := replace(v_ret, 'idade', replace(getIdade(p_id_atleta), ',', '.'));
  --v_ret := replace(v_ret, 'peso', replace(getPeso(p_id_atleta), ',', '.'));
  return v_ret;
end;
/

declare
  v_formula varchar(1000);
  v_value number;
begin
  v_formula := parseFormulaFCM(4, 1);
  dbms_output.put_line(v_formula);
  v_value := math_calc(v_formula);
  dbms_output.put_line(v_value);
  dbms_output.put_line(round(v_value, 2));
end;
/
