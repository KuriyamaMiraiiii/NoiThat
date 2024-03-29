echo "Building app..."
./mvnw clean package

echo "Deploy files to server..."
scp -r target/swpbe.jar root@128.199.214.103:/var/www/be

ssh root@128.199.214.103 <<EOF
pid=\$(sudo lsof -t -i :8081)

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