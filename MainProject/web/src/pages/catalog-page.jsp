<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="http://localhost:8080/MainProject_war_exploded/src/styles/index.css">
    <title>Document</title>
</head>
<body class="b-page b-page_background_dark b-page_font-color_light flex-container flex-container_x_center flex-container_y_center">
<form class="form" action="http://localhost:8080/MainProject_war_exploded/Session" method="post">
    <ul class="list products-list">
        <li class="product product_shadow products-list__element flex-container flex-container_x_between">
            <div class="product__body">
                <h2 class="product__name">PeterEngland</h2>
                <p class="product__description">Крутая фуболка для спортсменов!!</p>
            </div>
            <input id="c1" class="button-holder" name="c1" type="checkbox" value="PeterEngland">
            <label for="c1" class="button product__button"></label>
        </li>
        <li class="product product_shadow products-list__element flex-container flex-container_x_between">
            <div class="product__body">
                <h2 class="product__name">Excaliber</h2>
                <p class="product__description">Футболка из микрофибры, позволяет почувствовать сябя крутым!!</p>
            </div>
            <input id="c2" name="c2" class="button-holder" type="checkbox" value="Excaliber">
            <label for="c2" class="button product__button"></label>

        </li>
        <li class="product product_shadow products-list__element flex-container flex-container_x_between">
            <div class="product__body">
                <h2 class="product__name">Vaun Newman</h2>
                <p class="product__description">Черный цвет всегда в моде, как и эта футболка.</p>
            </div>
            <input id="c3" name="c3" class="button-holder" type="checkbox" value="VaunNewman">
            <label for="c3" class="button product__button"></label>

        </li>
        <li class="product product_shadow products-list__element flex-container flex-container_x_between">
            <div class="product__body">
                <h2 class="product__name">Wills Classic</h2>
                <p class="product__description">Обычная, но необычная.</p>
            </div>
            <input id="c4" name="c4" class="button-holder" type="checkbox" value="WillsClassic">
            <label for="c4" class="button product__button"></label>
        </li>
    </ul>
    <input class="button button_style_normal button_size_m" value="Купить" type="submit">
</form>
</body>
</html>