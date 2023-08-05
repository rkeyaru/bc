mvn clean install
cp /home/ics-nitigya/eclipse-workspace/test/target/test.war -d /var/lib/tomcat9/webapps/
service tomcat9 restart
