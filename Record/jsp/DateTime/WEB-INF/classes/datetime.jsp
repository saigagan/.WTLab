<%@page import="java.util.Date" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Date &amp; Time</title>

        <style>
            html, body {
                margin: 0px;
                display: flex;
                width: 100%;
                height: 100%;
                background-color: rgb(247, 247, 247); 
            }

            h1 {
                margin: auto;
                color: rgb(0, 122, 255);
                font-size: 72px;
            }
        </style>
    </head>
    <body>
        <%! Date d = null;
            String date = null; %>

        <% d = new Date();
            date = d.toString(); %>

        <h1><%= date  %></h1>
        
    </body>
</html>