CREATE TABLE IF NOT EXISTS User(
    user_id int NOT NULL,
    user_name varchar(64) NOT NULL,
    CONSTRAINT PKUser PRIMARY KEY(user_id,user_name)
);

CREATE TABLE IF NOT EXISTS Private_account (
    user_id int NOT NULL,
    user_name varchar(64) NOT NULL,
    Credit_line float NOT NULL,       
    Debt float NOT NULL,              
	Credit_balance float NOT NULL,    
    CONSTRAINT PKPrivate_account PRIMARY KEY (user_id,user_name),
	CONSTRAINT FKPrivate_account FOREIGN KEY (user_id,user_name) REFERENCES User(user_id,user_name) ON DELETE CASCADE
	
)ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS Company_account(
    user_id int NOT NULL,
    user_name varchar(64) NOT NULL,
    Credit_line float NOT NULL,       
    Debt        float NOT NULL,      
    Credit_balance float NOT NULL,   

    CONSTRAINT PKCompany_account PRIMARY KEY (user_id,user_name),
	CONSTRAINT FKCompany_account FOREIGN KEY (user_id,user_name) REFERENCES User(user_id,user_name) ON DELETE CASCADE
)ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS Supplier_account(
    user_id int NOT NULL,
    user_name varchar(64) NOT NULL,
    Products      varchar(64) NOT NULL, 
    Profit       float NOT NULL,
    Percent_toCCC float NOT NULL, 
    Debt       float NOT NULL,
	
	CONSTRAINT PKSupplier_account PRIMARY KEY (user_id,user_name),
	CONSTRAINT FKSupplier_account FOREIGN KEY (user_id,user_name) REFERENCES User(user_id,user_name) ON DELETE CASCADE
	
)ENGINE = InnoDB;




/*Insert INTO 'Private_account' VALUES (
    
)*/


