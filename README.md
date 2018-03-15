JDBC Singleton example

How to run?

You need to have access to an existing SQL database. Currently this package uses a MariaDB Connector-J driver.
(https://mariadb.com/kb/en/library/getting-started-with-the-java-connector/)

You can modify the singleton class file in order to change this to your preferred DB's driver.

When you run the demo class, you'll be asked for the connection string (address), username and password.
Then a temporary database is created for the application (along with a table).

Upon exit, the temporary table and the temporary database is cleaned up (sql DROP).
