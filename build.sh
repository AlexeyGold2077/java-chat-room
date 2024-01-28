echo "compiling..."
javac --release 17 src/Server/Server.java src/Server/ClientHandler.java
echo "archiving..."
jar -cfm src/Server/ServerApp.jar src/Server/MANIFEST.mf src/Server/Server.class src/Server/ClientHandler.class
echo "done!"

