echo "Building app..."
./mvnw clean package

echo "Deploy files to server..."
scp -r target/swpbe.jar root@167.99.69.197:/var/www/be

ssh root@167.99.69.197 <<EOF
pid=\$(sudo lsof -t -i :8080)

if [ -z "\$pid" ]; then
    echo "Start server..."
else
    echo "Restart server..."
    sudo kill -9 "\$pid"
fi
cd /var/www/be
java -jar swpbe.jar
EOF
exit
echo "Done!"