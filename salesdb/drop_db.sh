




echo $PATH
DB_PATH=/tmp/applifire/db/B76CI6M85A58LBP7NYA2A/908694E0-F9B2-48CC-82A6-82D41EE2BEB7
MYSQL=/usr/bin
USER=sales
PASSWORD=sales
HOST=localhost


echo 'drop db starts....'
$MYSQL/mysql -h$HOST -u$USER -p$PASSWORD -e "SOURCE $DB_PATH/drop_db.sql";
echo 'drop db ends....'