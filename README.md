# WhoKnowsMe
 A program to find all your accounts that are still active and you have forgotten about. This is a Jugend Hackt Project.
Made by asqiir, claashi, wutchilli, numten.

## content

1. How to run the project
2. How to use the website

# 1 How to run

## Shortly (in general)

1. Install a server (apache2 recommended; there is an apache2 minimal edition within tomcat)
2. Install a Java Servlet container (apache tomcat recommended)
3. Deploy the most actual .war file in stable directory (look for highest version number)

## Detailed explanation for Ubuntu Linux

### 1. Install Java

Run the command `sudo apt install default-jdk`.

### 2. Install tomcat

Figure out which tomcat is the most actual version. Look for it on the official [which-version site](https://tomcat.apache.org/whichversion.html).
The project is written in Java 8, so this Java version has to be supported.

Run the command `sudo service install tomcat8 tomcat8-admin`.

(Replace 8 by the version number you prefer.)

Is tomcat started? Run `service tomcat8 status`. If it shows you a status other than "Running" or "active" run `sudo service tomcat8 start`.

If you want to stop tomcat after using this project, run `sudo service tomcat8 stop`.

### 3. Deploy .war file

1. Visit [the projects github repository](https://github.com/jugendhackt/whoknowsme). Move to the directory `/stable`. Download the file with the highest version number.

2. Make yourself a tomcat manager.

Open the file `/var/lib/tomcat8/conf/tomcat-users.xml`. (Directory can be different, but it will always be within the tomcat main folder.)

Add the following lines above the closing `</tomcat-users>` tag:

`<role rolename="manager-gui"/>`
`<user username="your-name" password="your-password" roles="manager-gui"/>`

3. Visit [the tomcat manager page](localhost:8080/manager).
Move to the tab `List Applications`. Scroll down until `Deploy > WAR file to deploy`. Select a war file. (The one you downloaded before.) Deploy it. (Using the "deploy"-button.)

# 2 How to use

## In general

1. Open a browser
2. Visit the sites url
3. (Activate JavaScript and allow jQuery.)
4. Type your username to the input field.
5. Click on "Who knows me?"
6. Enjoy the answer!

## How to find the right URL?

If you followed the "Deploy the .war file" tutorial…

Visit [the manager page](localhost:8080/manager). Go to the "List Applications" tab. In the "Applications" table you will find a row whose Display Name is "WhoKnowsMe". Click on the URL in the first column.

