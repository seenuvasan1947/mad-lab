
#!/bin/sh
echo "Updating apt"


echo "Installing snap"
sudo apt install snapd

echo "Installing Flutter"
sudo snap install android-studio --classic

echo "Installing Git"
sudo apt install git

echo "Installing JRE"
sudo apt install openjdk-8-jre

echo "Installing JDK"
sudo apt install openjdk-8-jdk-headless

sudo apt-get install android-tools-adb
sudo apt-get install adb
adb start-server

echo"./gradlew installDebug" 

echo "Setup are ready!"
