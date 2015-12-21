




echo $PATH
DB_PATH=/tmp/applifire/db/VTM8AJ3LPKLAHECJXAYYWW/3F2A18EA-3331-4898-9AEC-1ECE977B4791
MYSQL=/usr/bin
USER=onshopdb
PASSWORD=onshopdb
HOST=localhost


echo 'drop db starts....'
$MYSQL/mysql -h$HOST -u$USER -p$PASSWORD -e "SOURCE $DB_PATH/drop_db.sql";
echo 'drop db ends....'