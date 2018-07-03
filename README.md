# LoginLogs

This is a simple Application where there are two users.
One is normal User and other one is Manager Login

Manager credentials are -
Username-SS
password-SS

Now SQlite database stores normal user's username ,password and date Time of User login

Manager can see all Logs which includes username and Date and Time of user login

Note:
To include password in logs :
GOTO: DatabaseHelper.java 
in that go in method 'getAllLogs'
where we generate string of logs
just add cursor.getString(cursor.getColumnIndex(Login.PassWord))
And password will also be included in Log File.


Thank You
