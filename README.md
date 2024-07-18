<!DOCTYPE html>
<html lang="en">
<head>
</head>
<body>

<h1>Bank Simulator</h1>

<h2>Overview</h2>
<p>Bank Simulator is a Java program that simulates financial transactions between multiple users, secured by password protection. This application provides a simple and effective way to understand the fundamental concepts of transactions and user authentication, featuring a graphical user interface (GUI) for ease of use.</p>

<h2>Features</h2>
<ul>
    <li><strong>User Registration:</strong> Create new users with a username and password.</li>
    <li><strong>User Authentication:</strong> Secure login mechanism with password protection.</li>
    <li><strong>Transaction Management:</strong> Perform transactions between users.</li>
    <li><strong>Balance Inquiry:</strong> Check the balance of any user.</li>
</ul>

<h2>Installation</h2>
<ol>
    <li><strong>Clone the repository</strong>
        <pre><code>git clone https://github.com/23Benji/Bank-Simulator.git
cd Bank-Simulator</code></pre>
    </li>
    <li><strong>Compile the Java files</strong>
        <pre><code>javac -d out/production/BankSimulator src/*.java</code></pre>
    </li>
    <li><strong>Run the program</strong>
        <pre><code>java -cp out/production/BankSimulator Main</code></pre>
    </li>
</ol>

<h2>Usage</h2>
<ol>
    <li><strong>Create new users and password</strong>
        <p>Change the existing usernames and passwords with whatever you like. Change it from  <strong>"Main.java" </strong></p>
        <div class="image-container">
            <img src=res/img/Main.png alt="Main Javafile" width="600">
        </div>
    </li>
    <li><strong>Login as an existing user</strong>
        <p>Enter your username and password in the login window.</p>
        <div class="image-container">
            <img src="res/img/Bank_LogIn.png" alt="Login Window" width="300">
        </div>
    </li>
    <li><strong>Check balance and perform a transaction</strong>
        <p>Your current balance is displayed upon logging in. You can choose the "Send Money" option to perform a transaction. Follow the prompts to enter the recipient's username and the amount.</p>
        <div class="image-container">
            <img src="res/img/User_Interface.png" alt="Transaction Window" width="300">
        </div>
    </li>
    <li><strong>Login to multiple users simultaneously</strong>
        <p>You can log in and check the balance live by simply using the login window.</p>
        <p><strong>Attention!</strong> By closing the login window, all other windows will close as well!</p>
        <div class="image-container">
            <img src=res/img/Multi_User.png alt="Balance Window" width="500">
        </div>
    </li>
</ol>
<h2>License</h2>
<p> This project is open source and licensed under the [<a href="LICENSE" title License>MIT LICENSE.</a>]. See the LICENSE file for details.</p><br>

</body>
