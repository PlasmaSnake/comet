# Comet

Cryptocurrency tracker web app

For the Cognizant-Platform by Per Scholas Java Developer class

For now, my goal is to create a prototype with dummy data but I aim to use the API when the data and website function together up to standard.

To run on a localhost: Install Spring 4 with the Spring 3 add-on into Eclipse EE. Place 'ojdbc7.jar' and 'json-simple-1.1.1.jar' into the '/WebContent/WEB-INF/lib' folder. Install TomCat, create a server and run.



Dummy Data: Bitcoin information collected from the API using the CryptoCollector/script.py file, and the python package made by lagerfeuer.

TODO / Production path:
1. Wireframe pages
2. Create database and schema
3. Implement DAO methods AND pages:
	* User coin registration/deletion
	* User Coin List display
	* Coin information display
	* Coin information register as user coin (if logged in)
	* Contact pages
	* User/Admin pages
	* Admin - account CRUD
	* Users - Modify data
4. Charts on Coin information display
5. (Ongoing) Source control on GitHub/Update user stories on Jira
6. Deployment

### Technologies used:
* Java
* Spring MVC
* Maven
* HTML/CSS
* JSP
* Oracle SQL
* Python
* Jira
* JUnit

## Free Services / Third Party software used

### API:
https://www.cryptocompare.com/api

### Bootstrap:
https://getbootstrap.com/

### Python CryptoCompare Package
https://github.com/lagerfeuer/cryptocompare

### Draw.io
https://www.draw.io/

### Google Charts
https://developers.google.com/chart/interactive/docs/

### Amazon Web Services
https://aws.amazon.com/ (Credit/Debit needed for a year of free service)

### Postman (API development Environment)
https://www.getpostman.com/

### Wireframe.cc (HTML Layout Development Tool)
https://wireframe.com


#### Things I would have done differently/Refactorable items:
* Database Access Objects: Refactor them into Models/BeanDAOs instead of CRUD-based DAOS
* Refine the implementation of MVC and have the Controllers simple, business logic done in the beans, and the views with less code.
* Table list/Graph in a more user friendly format