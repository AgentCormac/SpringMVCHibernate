echo OFF
REM #######################################################################
REM #
REM # Author: 	Mark Higginbottom
REM # Date:		11/6/2016
REM #
REM # Change the mMaven command from the Apt version to plain vanilla 3.3 
REM # by swapping out the maven paths in the Path environment variable.
REM # We need to do this because we arent using an Apt project and repository.
REM #
REM #######################################################################
echo:
echo Setting up development environment.
echo:
echo Switching Maven build from Apt 1.4.2 to (Non-Corporate) Maven 3.3.9
REM #This replaces "Apt for Java-1.4.2" for "\Java\apache-maven-3.3.9" in the Path env variable! BY MAGIC!!!
set Path=%Path:Apt for Java-1.4.2=\Java\apache-maven-3.3.9%
echo:
mvn -v