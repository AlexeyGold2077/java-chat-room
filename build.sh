echo "compiling..."
javac --release 17 src/Server/Server.java src/Server/ClientHandler.java
javac --release 17 src/Client/Client.java

echo "archiving..."
jar -cfm src/Server/ServerApp.jar src/Server/MANIFEST.mf src/Server/Server.class src/Server/ClientHandler.class
jar -cfm src/Client/ClientApp.jar src/Client/MANIFEST.mf src/Client/Client.class

echo "moving..."
rm -rf jars
rm -rf jars
mkdir -p jars
cp src/Server/ServerApp.jar ./jars
cp src/Client/ClientApp.jar ./jars

echo "done!"

