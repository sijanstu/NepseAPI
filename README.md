Steps to use:
1. download and import to your project
2. download and import jsoup libray from:
 [https://jsoup.org/download](url) 
 
guides for setup::
1. import: `import DataAPI.NepseAPI;`
2. create object: `NepseAPI API=new NepseAPI();`
3. start API: `API.startPage();`

guides to use setup
1. check market status: `API.isMarketOpen()` returns boolean
2. get stock data by company: `API.getBySymbol("JBLB", true);` returns String[] with data
3. get stock data headers: `API.getHeader()` returns header names to match with data above
4. get all company list: `API.getAllcompany()` returns String[] with symbols

