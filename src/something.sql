CREATE TABLE IF NOT EXISTS User(
    user_id int NOT NULL,
    user_name varchar(64) NOT NULL,
    PRIMARY KEY(user_id,user_name)
);

CREATE TABLE IF NOT EXISTS Private_account (
    user_id int NOT NULL,
    user_name varchar(64) NOT NULL,
    Credit_line float NOT NULL,       
    Debt float NOT NULL,              
	Credit_balance float NOT NULL,    
    PRIMARY KEY (user_id,user_name),
	FOREIGN KEY (user_id,user_name) REFERENCES User(user_id,user_name)
	
)ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS Company_account(
    user_id int NOT NULL,
    user_name varchar(64) NOT NULL,
    Credit_line float NOT NULL,       
    Debt        float NOT NULL,      
    Credit_balance float NOT NULL,   

    PRIMARY KEY (user_id,user_name),
	FOREIGN KEY (user_id,user_name) REFERENCES User(user_id,user_name)
)ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS Supplier_account(
    user_id int NOT NULL,
    user_name varchar(64) NOT NULL,
    Products      varchar(64) NOT NULL, 
    Profit       float NOT NULL,
    Percent_toCCC float NOT NULL, 
    Debt       float NOT NULL,
	
	PRIMARY KEY (user_id,user_name),
	FOREIGN KEY (user_id,user_name) REFERENCES User(user_id,user_name)
	
)ENGINE = InnoDB;

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
	"10000"
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
	"6900"
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
	"0"
);

INSERT INTO User VALUES(
	"10",
	"Filthy Frank"

);

INSERT INTO Supplier_account VALUES(
	"10",
	"Filthy Frank",
	"celebrities_butt_hair",
	"333333",
	"0.1",
	"0"
);

