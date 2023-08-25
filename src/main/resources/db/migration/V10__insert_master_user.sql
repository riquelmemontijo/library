-- {
--     "name":"Riquelme",
--     "username":"riquelme.montijo",
--     "password":"riquelme",
--     "email":"email",
--     "phoneNumber":"38999999999",
--     "roles":[
--         {
--             "id":"17bff957-cb70-4376-a1fc-3787f4cc5eb6"
--         }
--     ]
-- }

INSERT INTO TB_USER (ID, NAME, USERNAME, PASSWORD, EMAIL, STATUS, CREATED_AT)
VALUES ('0b35f61d-35c1-4ebe-8781-fba2e475e520', 'master', 'master.master', '$2a$12$BmomCxKH36cyneUuzga7quiAMt6XzXfJ47ZaYxKP.eplEbTjBmDMG', '', 'ACTIVE', CURRENT_DATE);

INSERT INTO USER_ROLES (ID_USER, ID_ROLE)
VALUES ('0b35f61d-35c1-4ebe-8781-fba2e475e520', '17bff957-cb70-4376-a1fc-3787f4cc5eb6');