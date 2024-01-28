echo "compiling..."
javac --release 17 src/Server.java src/ClientHandler.java
javac --release 17 src/Client.java

echo "archiving..."
jar -cfm src/ServerApp.jar src/MANIFEST_Server.mf src/Server.class src/ClientHandler.class
jar -cfm src/ClientApp.jar src/MANIFEST_Client.mf src/Client.class

echo "moving..."
rm -rf jars
mkdir -p jars
mv src/ServerApp.jar ./jars
mv src/ClientApp.jar ./jars

echo "cleaning..."
rm -rf src/*.class rm src/*.jar

echo "done!"
