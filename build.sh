echo "compiling..."
javac --release 17 src/Server.java src/ClientHandler.java
javac --release 17 src/Client.java

echo "archiving..."
jar -cfm jar/ServerApp.jar src/MANIFEST_Server.mf src/Server.class src/ClientHandler.class
jar -cfm jar/ClientApp.jar src/MANIFEST_Client.mf src/Client.class

echo "cleaning..."
rm -rf src/*.class

echo "done!"
