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
    <li><strong>Transaction History:</strong> View the transaction history of any user.</li>
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
    <li><strong>Login as an existing user</strong>
        <p>Enter your username and password in the login window.</p>
        <div class="image-container">
            <img src="screenshots/login.png" alt="Login Window">
        </div>
    </li>
    <li><strong>Perform a transaction</strong>
        <p>After logging in, you can choose the "Send Money" option to perform a transaction.</p>
        <p>Follow the prompts to enter the recipient's username and the amount.</p>
        <div class="image-container">
            <img src="screenshots/transaction.png" alt="Transaction Window">
        </div>
    </li>
    <li><strong>Check balance</strong>
        <p>Your current balance is displayed upon logging in.</p>
        <div class="image-container">
            <img src="screenshots/balance.png" alt="Balance Window">
        </div>
    </li>
</ol>
</body>
