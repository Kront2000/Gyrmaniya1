<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>


<!DOCTYPE html>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/admin.css?ts=${System.currentTimeMillis()}">
<html>
    <head>
        <meta charset="utf-8">

    </head>
    <body>
        <div class="top">
            <div class="header">
            <div class="conteiner">
                <div class="logoKrb">
                    <div class="logo">
                    <img class="logoimg" src="${pageContext.request.contextPath}/img/gurmaniya.png" alt="">
                    </div>
                <div>
                
                    <div class="KRB">
                        <div class="gps">
                        <img class="gpsimg" src="${pageContext.request.contextPath}/img/gps.png" alt="">
                        </div>
                        Карабалык
                    </div>
                    <div class="Dos">Доствка работает с 9:00 до 21:00</div>
                </div>
            </div>

                <div class="number">
                    <div class="phone">
                        <img class="phoneimg" src="${pageContext.request.contextPath}/img/phone.png" alt="">
                    </div>
                    <div class="numbertext">+7(705) 419-70-50</div>
                </div>
            </div>
        </div>
        <div class="navig">
            <div class="menu">
                <a class="menubutton" href="">Сеты</a>
                <a class="menubutton" href="">Роллы</a>
                <a class="menubutton" href="">Запечёные</a>
                <a class="menubutton" href="">Шаурма</a>
                <a class="menubutton" href="">Горячее</a>
                <a class="menubutton" href="">Напитки</a>
            </div>
        </div>


        </div>
            <div class="main">
                <div class="categories_text">Сеты</div>
                <div class="categories">    
                    <c:forEach var="dish" items = "${requestScope.dishes}">
                        <c:if test = "${dish.category()  == 'Сеты'}">
                            <div class='dish'>
                                <div class="full_description">
                                    <img class='dishimg' src='${pageContext.request.contextPath}${dish.imagePath()}' alt=''>
                                    <div class='dish_name'>${dish.name()}</div>
                                <div class='dish_description'>${dish.description()}</div>
                                </div>
                                
                                <div class="button_and_price">
                                    <div class='price'>${dish.price()}тг</div>
                                    <form action="${pageContext.request.contextPath}/edit?id=${dish.id()}" method="post">
                                        <input class="button" type="submit" value="Ред.">
                                    </form>
                                    <form action="${pageContext.request.contextPath}/del?id=${dish.id()}" method="post">
                                        <input class="button" type="submit" value="Удалить">
                                    </form>
                                </div>
                                
                            </div>
                        </c:if>
                    </c:forEach>
                    <div class="dish_plus">
                        <form action="${pageContext.request.contextPath}/add?category=Сеты" method="post">
                            <input class="plus" type="submit" value="+">
                        </form>
                    </div>
                </div>
                <div class="categories_text">Жаренные роллы</div>
                <div class="categories">    
                    <c:forEach var="dish" items = "${requestScope.dishes}">
                        <c:if test = "${dish.category()  == 'Жаренные роллы'}">
                            <div class='dish'>
                                <div class="full_description">
                                    <img class='dishimg' src='${pageContext.request.contextPath}${dish.imagePath()}' alt=''>
                                    <div class='dish_name'>${dish.name()}</div>
                                <div class='dish_description'>${dish.description()}</div>
                                </div>
                                
                                <div class="button_and_price">
                                    <div class='price'>${dish.price()}тг</div>
                                    <form action="${pageContext.request.contextPath}/edit?id=${dish.id()}" method="post">
                                        <input class="button" type="submit" value="Ред.">
                                    </form>
                                    <form action="${pageContext.request.contextPath}/del?id=${dish.id()}" method="post">
                                        <input class="button" type="submit" value="Удалить">
                                    </form>
                                </div>
                                
                            </div>
                        </c:if>
                    </c:forEach>
                    <div class="dish_plus">
                        <form action="${pageContext.request.contextPath}/add?category=Жаренные роллы" method="post">
                            <input class="plus" type="submit" value="+">
                        </form>
                    </div>
                </div>
                <div class="categories_text">Холодные роллы</div>
                <div class="categories">    
                    <c:forEach var="dish" items = "${requestScope.dishes}">
                        <c:if test = "${dish.category()  == 'Холодные роллы'}">
                            <div class='dish'>
                                <div class="full_description">
                                    <img class='dishimg' src='${pageContext.request.contextPath}${dish.imagePath()}' alt=''>
                                    <div class='dish_name'>${dish.name()}</div>
                                <div class='dish_description'>${dish.description()}</div>
                                </div>
                                
                                <div class="button_and_price">
                                    <div class='price'>${dish.price()}тг</div>
                                    <form action="${pageContext.request.contextPath}/edit?id=${dish.id()}" method="post">
                                        <input class="button" type="submit" value="Ред.">
                                    </form>
                                    <form action="${pageContext.request.contextPath}/del?id=${dish.id()}" method="post">
                                        <input class="button" type="submit" value="Удалить">
                                    </form>
                                </div>
                                
                            </div>
                        </c:if>
                    </c:forEach>
                    <div class="dish_plus">
                        <form action="${pageContext.request.contextPath}/add?category=Холодные роллы" method="post">
                            <input class="plus" type="submit" value="+">
                        </form>
                    </div>
                </div>
                <div class="categories_text">Шаурма</div>
                <div class="categories">    
                    <c:forEach var="dish" items = "${requestScope.dishes}">
                        <c:if test = "${dish.category()  == 'Шаурма'}">
                            <div class='dish'>
                                <div class="full_description">
                                    <img class='dishimg' src='${pageContext.request.contextPath}${dish.imagePath()}' alt=''>
                                    <div class='dish_name'>${dish.name()}</div>
                                <div class='dish_description'>${dish.description()}</div>
                                </div>
                                
                                <div class="button_and_price">
                                    <div class='price'>${dish.price()}тг</div>
                                    <form action="${pageContext.request.contextPath}/edit?id=${dish.id()}" method="post">
                                        <input class="button" type="submit" value="Ред.">
                                    </form>
                                    <form action="${pageContext.request.contextPath}/del?id=${dish.id()}" method="post">
                                        <input class="button" type="submit" value="Удалить">
                                    </form>
                                </div>
                                
                            </div>
                        </c:if>
                    </c:forEach>
                    <div class="dish_plus">
                        <form action="${pageContext.request.contextPath}/add?category=Шаурма" method="post">
                            <input class="plus" type="submit" value="+">
                        </form>
                    </div>
                </div>
                <div class="categories_text">Пицца</div>
                <div class="categories">    
                    <c:forEach var="dish" items = "${requestScope.dishes}">
                        <c:if test = "${dish.category()  == 'Пицца'}">
                            <div class='dish'>
                                <div class="full_description">
                                    <img class='dishimg' src='${pageContext.request.contextPath}${dish.imagePath()}' alt=''>
                                    <div class='dish_name'>${dish.name()}</div>
                                <div class='dish_description'>${dish.description()}</div>
                                </div>
                                
                                <div class="button_and_price">
                                    <div class='price'>${dish.price()}тг</div>
                                    <form action="${pageContext.request.contextPath}/edit?id=${dish.id()}" method="post">
                                        <input class="button" type="submit" value="Ред.">
                                    </form>
                                    <form action="${pageContext.request.contextPath}/del?id=${dish.id()}" method="post">
                                        <input class="button" type="submit" value="Удалить">
                                    </form>
                                </div>
                                
                            </div>
                        </c:if>
                    </c:forEach>
                    <div class="dish_plus">
                        <form action="${pageContext.request.contextPath}/add?category=Пицца" method="post">
                            <input class="plus" type="submit" value="+">
                        </form>
                    </div>
                </div>
                <div class="categories_text">Фри, нагетсы</div>
                <div class="categories">    
                    <c:forEach var="dish" items = "${requestScope.dishes}">
                        <c:if test = "${dish.category()  == 'Фри, нагетсы'}">
                            <div class='dish'>
                                <div class="full_description">
                                    <img class='dishimg' src='${pageContext.request.contextPath}${dish.imagePath()}' alt=''>
                                    <div class='dish_name'>${dish.name()}</div>
                                <div class='dish_description'>${dish.description()}</div>
                                </div>
                                
                                <div class="button_and_price">
                                    <div class='price'>${dish.price()}тг</div>
                                    <form action="${pageContext.request.contextPath}/edit?id=${dish.id()}" method="post">
                                        <input class="button" type="submit" value="Ред.">
                                    </form>
                                    <form action="${pageContext.request.contextPath}/del?id=${dish.id()}" method="post">
                                        <input class="button" type="submit" value="Удалить">
                                    </form>
                                </div>
                                
                            </div>
                        </c:if>
                    </c:forEach>
                    <div class="dish_plus">
                        <form action="${pageContext.request.contextPath}/add?category=Фри, нагетсы" method="post">
                            <input class="plus" type="submit" value="+">
                        </form>
                    </div>
                </div>
                <div class="categories_text">Другое</div>
                <div class="categories">    
                    <c:forEach var="dish" items = "${requestScope.dishes}">
                        <c:if test = "${dish.category()  == 'Другое'}">
                            <div class='dish'>
                                <div class="full_description">
                                    <img class='dishimg' src='${pageContext.request.contextPath}${dish.imagePath()}' alt=''>
                                    <div class='dish_name'>${dish.name()}</div>
                                <div class='dish_description'>${dish.description()}</div>
                                </div>
                                
                                <div class="button_and_price">
                                    <div class='price'>${dish.price()}тг</div>
                                    <form action="${pageContext.request.contextPath}/edit?id=${dish.id()}" method="post">
                                        <input class="button" type="submit" value="Ред.">
                                    </form>
                                    <form action="${pageContext.request.contextPath}/del?id=${dish.id()}" method="post">
                                        <input class="button" type="submit" value="Удалить">
                                    </form>
                                </div>
                                
                            </div>
                        </c:if>
                    </c:forEach>
                    <div class="dish_plus">
                        <form action="${pageContext.request.contextPath}/add?category=Другое" method="post">
                            <input class="plus" type="submit" value="+">
                        </form>
                    </div>
                </div>
        </div>
    </body>
</html>