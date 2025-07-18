<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/edit.css?ts=${System.currentTimeMillis()}">
<html>
    <head> 
        <title>login</title>
    </head>
    <body>
        <div class="main">
            <div class='dish'>
                                <img class='dishimg' src='${pageContext.request.contextPath}${dish.imagePath()}' alt=''>
                                <div class='dish_name'>${dish.name()}</div>
                                <div class='dish_description'>${dish.description()}</div>
                                <div class="button_and_price">
                                    <div class='price'>${dish.price()}тг</div>
                                    <form action="${pageContext.request.contextPath}/admin" method="get">
                                        <input class="button" type="submit" value="Назад">
                                    </form>
                                </div>
                                
                            </div>
        </div>
    </body>
</html>