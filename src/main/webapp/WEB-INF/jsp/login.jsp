<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css?ts=${System.currentTimeMillis()}">
<html>
    <head> 
        <title>login</title>
    </head>
    <body>
        <div class="main">
            <img src="${pageContext.request.contextPath}/img/gurmaniyaNeg.png" alt="">
            <form action="${pageContext.request.contextPath}/login" method="post">
                <label  for="login">Логин
                    <input class="inp" type="text" name="login" id="login" >
                </label>
                <label  for="login">Пароль
                    <input class="inp" type="password" name="password" id="password" >
                </label>
                <input class="button" type="submit" value="Войти">
            </form>
        </div>
    </body>
</html>