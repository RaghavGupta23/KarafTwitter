<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>

<html>
<head>
<title>KarafTwitterAPI</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
    href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
    src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
    src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
hr {
    border: none;
    height: 2px;
    color: #890;
    background-color: #ffffff;
}
body {

}
</style>
</head>
<body style="margin: 0px 0px 0px 20px;">
    <h3><i>Homework 2 by Spartan Developers</i></h3>
    <h4><i><u>Instructions:</u></i></h4>
    <ul>
    <li><i>create Friendship: input the friend's id that not exists in you Twitter account.</i></li>
    <li><i>destroy Friendship: input the friend's id to be destroyed.</i></li>
    <li><i>list Friends IDs: list all IDs to be used in other APIs.</i></li>
    <li><i>list Friends: list friends user names.</i></li>
    <li><i>list Followers IDs: list followers IDs.</i></li>
    <li><i>list Followers: list followers user names.</i></li>
    <li><i>list Block IDs: list the IDs for users of whom you blocked on Twitter.</i></li>    
    <li><i>list Block Users: list the user names for users blocked on Twitter.</i></li>
    </ul>
    <h2><i>Select the Twitter API</i></h2>
    <br>
    <div class="panel panel-primary">
     <div class="btn-group">


 </div>
    <form action="executeApi" method="POST">
       
        <select name="twitteroptions">
            <option value="Create Friendship">Create Friendship</option>
            <option value="Destroy Friendship">Destroy Friendship</option>
            <option value="List Friends ids">List Friends IDs</option>
            <option value="list Followers ids">List Followers IDs</option>
            <option value="Followers List">Followers List</option>
            <option value="Friends List">Friends List</option>
            <option value="Blocks IDs">Block IDs</option>
            <option value="Blocks List">Block users</option>
          
          	<input type="text" name="value" value=""><br>
            </select> <input type="submit" value="Submit" />
         
    </form>
    <br>
    <br>
    <div class="panel panel-primary">
        <%
            try {
                if (session.getAttribute("option") != null) {
        %>
        <div class="panel-heading"><%=session.getAttribute("option")%></div>
        <%
            }

                if (session.getAttribute("twitterResponse") != null) {
                    List<String> responses = (List<String>)session.getAttribute("twitterResponse");

                    for (String resp : responses) {
        %>
        <div class="panel-body"><%=resp%></div>
        <hr>
        <%
            }
                }
            } catch (Exception e) {
            }
        %>
    </div>
</body>
</html>