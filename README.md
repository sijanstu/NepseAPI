Steps to use:

download and import to your project
download and import jsoup libray from:
https://jsoup.org/download
guides for setup::
import: import DataAPI.NepseAPI;
create object: NepseAPI API=new NepseAPI();
start API: API.startPage();
guides to use setup
check market status: API.isMarketOpen() returns boolean
get stock data by company: API.getBySymbol("JBLB", true); returns String[] with data
get stock data headers: API.getHeader() returns header names to match with data above
get all company list: API.getAllcompany() returns String[] with symbols
