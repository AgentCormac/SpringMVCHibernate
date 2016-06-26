#SpringMVCHibernate

This is a simple Spring 4 MVC Hibernate demo on MySQL with a Maven build.
The real interest is that it is hosted on Vagrant/Docker.

The project is an Eclipse project workspace.

##Pre-requisites

-Eclipse Luna
-Java SDK 8
-Maven 3.3.9
-Vagrant 1.8.4
-VirtualBox 5.0.22
-Cygwin (for Vagrant?)
-MySQL Workbench 6.3


##Instructions
1. Import project into Eclipse
  * mvn eclipse:eclipse
  * mvn eclipse install
2. From project root
  * cd vagrant-centos-mysql-tomcat
  * vagrant up --no-parallel
3. Setup database
  * Using MySQL Workbench
  * Connect to MySQL database localhost:3306 root/root
  * execute  shared-data\mysql\setup.sql
3. Tomcat 8.5 should be up on http://localhost:8080
  * use manager application to deploy target\SpringMVCHibernate.war

##Things to do
- [ ]Switch EventLog to PostgreSQL
- [ ]Add deploy target for maven pom
- [ ]Add Jenkins container
- [ ]Add Jenkins job to this repo
- [ ]Investigate adding Vagrant environment build and deploy too Jenkins CI job 
