CREATE TABLE IF NOT EXISTS beneficiaries_table(
   name             VARCHAR(13) NOT NULL PRIMARY KEY
  ,category         VARCHAR(1) NOT NULL
  ,last_receipt     DATE 
  ,headcount        INTEGER  NOT NULL
  ,request_counter  INTEGER  NOT NULL
  ,receipt_counter  INTEGER  NOT NULL
);
INSERT INTO beneficiaries_table(name,category,last_receipt,headcount,request_counter,receipt_counter) VALUES ('beneficiary1','A','2017-09-29',100,10,8);
INSERT INTO beneficiaries_table(name,category,last_receipt,headcount,request_counter,receipt_counter) VALUES ('beneficiary2','B','2017-09-29',300,20,15);
INSERT INTO beneficiaries_table(name,category,last_receipt,headcount,request_counter,receipt_counter) VALUES ('beneficiary3','A','2017-09-05',300,30,22);
INSERT INTO beneficiaries_table(name,category,last_receipt,headcount,request_counter,receipt_counter) VALUES ('beneficiary4','B','2017-09-05',300,40,29);
INSERT INTO beneficiaries_table(name,category,last_receipt,headcount,request_counter,receipt_counter) VALUES ('beneficiary5','A','2017-09-05',300,50,36);
INSERT INTO beneficiaries_table(name,category,last_receipt,headcount,request_counter,receipt_counter) VALUES ('beneficiary6','B','2017-09-05',300,60,43);
INSERT INTO beneficiaries_table(name,category,last_receipt,headcount,request_counter,receipt_counter) VALUES ('beneficiary7','A','2017-09-05',300,70,50);
INSERT INTO beneficiaries_table(name,category,last_receipt,headcount,request_counter,receipt_counter) VALUES ('beneficiary8','B','2017-09-05',300,80,57);
INSERT INTO beneficiaries_table(name,category,last_receipt,headcount,request_counter,receipt_counter) VALUES ('beneficiary9','A','2017-09-05',300,90,64);
INSERT INTO beneficiaries_table(name,category,last_receipt,headcount,request_counter,receipt_counter) VALUES ('beneficiary10','B','2017-09-05',300,100,71);
INSERT INTO beneficiaries_table(name,category,last_receipt,headcount,request_counter,receipt_counter) VALUES ('beneficiary11','A','2017-09-05',300,110,78);
INSERT INTO beneficiaries_table(name,category,last_receipt,headcount,request_counter,receipt_counter) VALUES ('beneficiary12','B','2017-09-05',300,120,85);
INSERT INTO beneficiaries_table(name,category,last_receipt,headcount,request_counter,receipt_counter) VALUES ('beneficiary13','A','2017-09-05',300,130,92);
INSERT INTO beneficiaries_table(name,category,last_receipt,headcount,request_counter,receipt_counter) VALUES ('beneficiary14','B','2017-08-25',300,140,99);
INSERT INTO beneficiaries_table(name,category,last_receipt,headcount,request_counter,receipt_counter) VALUES ('beneficiary15','A','2017-08-25',300,5,3);
INSERT INTO beneficiaries_table(name,category,last_receipt,headcount,request_counter,receipt_counter) VALUES ('beneficiary16','B','2017-08-25',300,8,6);
INSERT INTO beneficiaries_table(name,category,last_receipt,headcount,request_counter,receipt_counter) VALUES ('beneficiary17','A','2017-08-25',300,11,9);
INSERT INTO beneficiaries_table(name,category,last_receipt,headcount,request_counter,receipt_counter) VALUES ('beneficiary18','B','2017-08-25',300,14,12);
INSERT INTO beneficiaries_table(name,category,last_receipt,headcount,request_counter,receipt_counter) VALUES ('beneficiary19','A','2017-08-25',50,17,15);
INSERT INTO beneficiaries_table(name,category,last_receipt,headcount,request_counter,receipt_counter) VALUES ('beneficiary20','B','2017-08-25',50,20,18);
INSERT INTO beneficiaries_table(name,category,last_receipt,headcount,request_counter,receipt_counter) VALUES ('beneficiary21','A','2017-08-25',50,23,21);
INSERT INTO beneficiaries_table(name,category,last_receipt,headcount,request_counter,receipt_counter) VALUES ('beneficiary22','B','2017-08-25',50,26,24);
INSERT INTO beneficiaries_table(name,category,last_receipt,headcount,request_counter,receipt_counter) VALUES ('beneficiary23','A','2017-08-25',50,29,27);
INSERT INTO beneficiaries_table(name,category,last_receipt,headcount,request_counter,receipt_counter) VALUES ('beneficiary24','B','2017-08-25',50,32,30);
INSERT INTO beneficiaries_table(name,category,last_receipt,headcount,request_counter,receipt_counter) VALUES ('beneficiary25','A','2017-08-25',50,35,33);
INSERT INTO beneficiaries_table(name,category,last_receipt,headcount,request_counter,receipt_counter) VALUES ('beneficiary26','B',NULL,50,1,0);
INSERT INTO beneficiaries_table(name,category,last_receipt,headcount,request_counter,receipt_counter) VALUES ('beneficiary27','A',NULL,50,1,0);
INSERT INTO beneficiaries_table(name,category,last_receipt,headcount,request_counter,receipt_counter) VALUES ('beneficiary28','B',NULL,50,1,0);
INSERT INTO beneficiaries_table(name,category,last_receipt,headcount,request_counter,receipt_counter) VALUES ('beneficiary29','A',NULL,50,1,0);
INSERT INTO beneficiaries_table(name,category,last_receipt,headcount,request_counter,receipt_counter) VALUES ('beneficiary30','B',NULL,50,1,0);
