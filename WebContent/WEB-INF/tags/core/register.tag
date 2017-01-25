<%@ tag %>
<%@ attribute name="header" fragment="true" %>
<%@ attribute name="body" fragment="true" %>
<html>
  <head>
    <title>My Website</title>
    <jsp:invoke fragment="header"/>
  </head>
  <body>
    <jsp:invoke fragment="body"/>
  </body>
</html>