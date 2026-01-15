<link rel="stylesheet" href="css/style.css">
<script src="js/script.js"></script>
</head>

<body>
    <div class="container">
        <h2>Currency Converter</h2>

        <form id="currencyForm">
            <label>From:</label>
            <select id="fromCurrency">
                <option value="USD">USD</option>
                <option value="INR">INR</option>
                <option value="EUR">EUR</option>
                <option value="GBP">GBP</option>
                <option value="JPY">JPY</option>
            </select>

            <label>To:</label>
            <select id="toCurrency">
                <option value="USD">USD</option>
                <option value="INR">INR</option>
                <option value="EUR">EUR</option>
                <option value="GBP">GBP</option>
                <option value="JPY">JPY</option>
            </select>

            <label>Amount:</label>
            <input type="number" id="amount" placeholder="Enter amount" required>

            <button type="submit">Convert</button>
        </form>
    </div>
</body>
