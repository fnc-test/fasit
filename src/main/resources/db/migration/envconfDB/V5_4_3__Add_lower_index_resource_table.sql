-- Added after running SQL Tuning advisor in test
CREATE INDEX LOWER_RES_ALIAS_RES_TYPE_IX ON RESOURCE_TABLE(LOWER("RESOURCE_ALIAS"),"RESOURCE_TYPE");