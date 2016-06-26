@echo off
echo "Deleting any existing vagrant.log"
rm -vf vagrant.log
echo "Executing vagrant up --no-parallel and sending debug output to vagrant.log"
echo
echo
echo "Please wait"
echo
vagrant up --no-parallel --debug  1> vagrant.log 2>&1