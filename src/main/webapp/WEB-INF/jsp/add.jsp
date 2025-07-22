<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/edit.css?ts=${System.currentTimeMillis()}">
<html>
    <head> 
        <title>add</title>
    </head>
    <body>
        <div class="main">
            <div class='dish'>
                <form action="${pageContext.request.contextPath}/AddComplete?category=${category}" method="post" enctype="multipart/form-data">
                    
                    <input class="text" type="file" accept="img/*" name="image" > 
                    <input class="text" type="text" name="name" id="name" value="Название">
                    <textarea class="text" name="description" id="description" >Описание</textarea>
                    <div class="button_and_price">
                    <input class="text" type="number" name="price" id="price" value="Цена">
                        <input class="button" type="submit" value="Добавить">
                    </div>
                </form>                    
            </div>
        </div>
    </body>
</html>