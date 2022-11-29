<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="cpath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <title>Watch Dogs</title>
    <link
      href="https://fonts.googleapis.com/css2?family=Cairo:wght@200;300;400;600;700;900&display=swap"
      rel="stylesheet"
    />
    <link rel="stylesheet" href="build/css/tailwind.css" />
    <script src="https://cdn.jsdelivr.net/gh/alpine-collective/alpine-magic-helpers@0.5.x/dist/component.min.js"></script>
    <script src="https://cdn.jsdelivr.net/gh/alpinejs/alpine@v2.7.3/dist/alpine.min.js" defer></script>
    <script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
   <script>
      $(document).ready(function(){
          $("#db").click(function(){
              location.href="index";
           });

       });

       $(document).ready(function(){
          $("#blc").click(function(){
              location.href="BlockChain";
           });

       });
       $(document).ready(function(){
          $("#fds").click(function(){
              location.href="G_FDS";
           });

       });
       
       $(document).ready(function(){
          $("#int").click(function(){
              location.href="introduce";
           });

       });

    </script>
  </head> 
  <body>
    <div>introduce.jsp</div>
    
    
  </body>
</html>
