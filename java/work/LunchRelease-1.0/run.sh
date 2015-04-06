#!/usr/bin/bash

sudo rm -r /var/lib/tomcat7/webapps/lunch*

ant all
sudo cp -r dist/* /var/lib/tomcat7/webapps/
sudo service tomcat7 restart
