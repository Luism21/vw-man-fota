# FOTA App
To build the app and have the tests run you must clone the repository and then run the following command in the pom.xml folder:

mvn clean install spring-boot:repackage -Dspring-boot.run.arguments=--CsvFilesPath=*.csv

To run the application you must go to the folder where the app has been compiled to and run the following command on terminal:

java -jar fota-0.0.1-SNAPSHOT.jar --CsvFilesPath={your-folder-path}*csv

Replace the placeholder with the path for your csv files

Your CSV files will be moved to a new folder named Done inside the same folder they were located after they are processed.

The Swagger can be found in the following URL once the app is running:
http://localhost:8080/fota/swagger-ui.html

The database will be available at http://localhost:8080/fota/h2/
