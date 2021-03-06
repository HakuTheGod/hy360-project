CREATE TABLE IF NOT EXISTS User(
    user_id int NOT NULL,
    user_name varchar(64) NOT NULL,
    PRIMARY KEY(user_id, user_name)
)ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS Private_account (
    user_id int NOT NULL,
    user_name varchar(64) NOT NULL,
    Credit_line float NOT NULL,       
    Debt float NOT NULL,              
	Credit_balance float NOT NULL,    
    PRIMARY KEY (user_id,user_name),
	FOREIGN KEY (user_id,user_name) REFERENCES User(user_id,user_name) ON DELETE CASCADE
	
)ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS Company_account(
    user_id int NOT NULL,
    user_name varchar(64) NOT NULL,
    Credit_line float NOT NULL,       
    Debt        float NOT NULL,      
    Credit_balance float NOT NULL,   

    PRIMARY KEY (user_id,user_name),
	FOREIGN KEY (user_id,user_name) REFERENCES User(user_id,user_name) ON DELETE CASCADE
)ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS Supplier_account(
    user_id int NOT NULL,
    user_name varchar(64) NOT NULL,
    Products      varchar(64) NOT NULL, 
    Profit       float NOT NULL,
    Percent_toCCC float NOT NULL, 
    Debt       float NOT NULL,
	Product_price double NOT NULL,
	
	PRIMARY KEY (user_id,user_name),
	FOREIGN KEY (user_id,user_name) REFERENCES User(user_id,user_name) ON DELETE CASCADE
	
)ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS Employees(
	employee_id int NOT NULL,
	employee_name varchar(64) NOT NULL,
    company_id int NOT NULL,
    company_name varchar(64) NOT NULL,
	
	PRIMARY KEY (employee_id),
	FOREIGN KEY (company_id,company_name) REFERENCES Company_account(user_id,user_name)
	
)ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS Transactions(
	t_date DATETIME NOT NULL,
	seller_name varchar(64) NOT NULL,
	customer_name varchar(64) NOT NULL,
	t_id int NOT NULL,
	amount double NOT NULL,
	t_type varchar(64) NOT NULL,
	
	PRIMARY KEY (seller_name,customer_name,t_date)
	
)ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS private_purchases(
	p_account_name varchar(64) NOT NULL,
	seller_name varchar(64) NOT NULL,
	product varchar(64) NOT NULL,
	quantity int NOT NULL,
	total_price double NOT NULL,
	
	PRIMARY KEY (p_account_name, seller_name, product)
	
)ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS company_purchases(
	c_account_name varchar(64) NOT NULL,
	seller_name varchar(64) NOT NULL,
	product varchar(64) NOT NULL,
	employee_id int NOT NULL,
	quantity int NOT NULL,
	total_price double NOT NULL,
	c_date DATETIME NOT NULL,
	
	PRIMARY KEY (c_account_name, seller_name, product, employee_id)
	
)ENGINE = InnoDBi;

INSERT INTO User VALUES(
	"0",
	"Giwwwwrgoooooooo"

);


INSERT INTO Private_account VALUES(
	"0",
	"Giwwwwrgoooooooo",
	"1000",
	"69",
	"931"
);

INSERT INTO User VALUES(
	"1",
	"Paulinos"

);

INSERT INTO Private_account VALUES(
	"1",
	"Paulinos",
	"1000",
	"300",
	"700"
);

INSERT INTO User VALUES(
	"6",
	"Dandis"

);

INSERT INTO Private_account VALUES(
	"6",
	"Dandis",
	"5000",
	"0",
	"5000"
);

INSERT INTO User VALUES(
	"3",
	"Nikola"

);

INSERT INTO Private_account VALUES(
	"3",
	"Nikola",
	"6900",
	"130",
	"6770"
);

INSERT INTO User VALUES(
	"4",
	"blizzard"

);

INSERT INTO Company_account VALUES(
	"4",
	"blizzard",
	"68000000",
	"68000000",
	"0"
);

INSERT INTO User VALUES(
	"2",
	"Riot Games"

);

INSERT INTO Company_account VALUES(
	"2",
	"Riot Games",
	"20000",
	"10000",
	"10000"
);

INSERT INTO User VALUES(
	"7",
	"Nintendo"

);

INSERT INTO Company_account VALUES(
	"7",
	"Nintendo",
	"60000",
	"30000",
	"30000"
);

INSERT INTO User VALUES(
	"5",
	"Mhtsakos"

);

INSERT INTO Supplier_account VALUES(
	"5",
	"Mhtsakos",
	"Wood",
	"45000",
	"0.09",
	"10000",
	"5"
);

INSERT INTO User VALUES(
	"8",
	"belle_delphine"

);

INSERT INTO Supplier_account VALUES(
	"8",
	"belle_delphine",
	"bathwater",
	"100000",
	"0.05",
	"6900",
	"30"
);

INSERT INTO User VALUES(
	"9",
	"emporos(paylos in disguise)"

);

INSERT INTO Supplier_account VALUES(
	"9",
	"emporos(paylos in disguise)",
	"erotic_mangas",
	"1000000",
	"0.02",
	"0",
	"6.9"
);

INSERT INTO User VALUES(
	"10",
	"Filthy Frank"

);

INSERT INTO Supplier_account VALUES(
	"10",
	"Filthy_Frank",
	"celebrities_butt_hair",
	"333333",
	"0.1",
	"0",
	"3"
);

