create or replace function updated_time_modified()
    returns trigger as
$$
begin
    new.updated_time = now();
    return new;
end
$$
    language 'plpgsql';


-- CREATE TRIGGER default_now_timestamp
--     BEFORE UPDATE
--     ON table_name
--     FOR EACH ROW
-- EXECUTE PROCEDURE update_modified_column();
