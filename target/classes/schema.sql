DROP TABLE IF EXISTS TBL_HOTELS;
 
CREATE TABLE TBL_HOTELS (
  id INT   PRIMARY KEY,
  hotel_name VARCHAR(250) NOT NULL,
  location VARCHAR(250) NOT NULL,
  mob_num VARCHAR(250) NOT NULL,
  room_avail VARCHAR(250) NOT NULL,
  cost INT

);