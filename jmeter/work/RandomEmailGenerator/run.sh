
javac -cp /opt/jmeter/apache-jmeter-2.13/lib/ext/ApacheJMeter_core.jar:${CLASSPATH} RandomEmailGenerator.java
mkdir -p com/itcvanadzor/jmeter/functions
mv *class com/itcvanadzor/jmeter/functions
jar cf ITCVanadzor.jar com
rm -rf com/itcvanadzor/jmeter/functions

jmeter -D search_paths=./ITCVanadzor.jar 
