#!/bin/bash

# MySQL Configuration
MYSQL_ROOT_PASSWORD="root"
NEW_USER_PASSWORD="Strong_Password"

# Install MySQL
sudo apt update
sudo apt install -y mysql-server

# Start the MySQL service
sudo service mysql start

# Set the root password for MySQL
sudo mysql -u root -e "ALTER USER 'root'@'localhost' IDENTIFIED BY '$MYSQL_ROOT_PASSWORD'"

# Create a new MySQL user "Sayeed" and set the password
sudo mysql -u root -p"$MYSQL_ROOT_PASSWORD" -e "CREATE USER 'Sayeed'@'localhost' IDENTIFIED BY '$NEW_USER_PASSWORD';"

# Grant necessary privileges to the "Sayeed" user (e.g., you can adjust these as needed)
sudo mysql -u root -p"$MYSQL_ROOT_PASSWORD" -e "GRANT ALL PRIVILEGES ON *.* TO 'Sayeed'@'localhost';"
sudo mysql -u root -p"$MYSQL_ROOT_PASSWORD" -e "FLUSH PRIVILEGES;"

echo "MySQL installation and user configuration completed."

# Create the "Tshirt-Store" folder
HOME_DIR="$HOME"
FOLDER_NAME="Tshirt-Store"
mkdir -p "$HOME_DIR/$FOLDER_NAME"

# Navigate to the folder
cd "$HOME_DIR/$FOLDER_NAME"

# Create the text file and add lines
echo "This is a sample text." > "mytextfile.txt"

# Optionally, you can add more lines to the text file using the 'echo' command
# echo "Another line of text" >> "mytextfile.txt"

echo "Folder and text file created."

# Define variables for your Spring Boot application
SPRING_APP_DIR="$HOME"  # Replace with your Spring project directory

# Stop the currently running Spring Boot application (if any)
pkill -f setup.jar

# Start the Spring Boot application with embedded Tomcat
nohup java -jar "$SPRING_APP_DIR/setup.jar" > /dev/null 2>&1 &

echo "Deployment completed."

# End of the script
