<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/edit.css?ts=${System.currentTimeMillis()}">
<html>
    <head> 
        <title>edit</title>
    </head>
    <body>
        <div class="main">
            <div class='dish'>
                <form action="${pageContext.request.contextPath}/complete?id=${dish.id()}&category=${dish.category()}&image=${dish.imagePath()}" method="post" enctype="multipart/form-data">
                    <img class='dishimg' src='${pageContext.request.contextPath}${dish.imagePath()}' alt=''>
                    <input class="text" type="file" accept="img/*" name="image" > 
                    <input class="text" type="text" name="name" id="name" value="${dish.name()}">
                    <textarea class="text" name="description" id="description" >${dish.description()}</textarea>
                    <div class="button_and_price">
                    <input class="text" type="number" name="price" id="price" value="${dish.price()}">
                        <input class="button" type="submit" value="Готово">
                    </div>
                </form>                    
            </div>
        </div>
    </body>
</html>