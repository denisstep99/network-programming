<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="http://localhost:8080/MainProject_war_exploded/src/styles/index.css">
    <title>SS sign in</title>
</head>
<body class="b-page b-page_background_dark b-page_font-color_light flex-container flex-container_x_center flex-container_y_center">
<form class="form" action="http://localhost:8080/MainProject_war_exploded/main" method="post">
    <fieldset class="form__fieldset form__fieldset_width_m">
        <legend class="form__legend">Sign in</legend>
        <div class="form-field">
            <label class="form-field__label" for="username">Username</label>
            <input class="form-field__input form-field__input_size_m" type="text" name="username" id="username">
        </div>
        <div class="form-field">
            <label class="form-field__label" for="password">Password</label>
            <input class="form-field__input form-field__input_size_m" type="password" name="password" id="password">
        </div>
        <input type="submit" value="Войти" class="button button_style_normal button_size_m">
    </fieldset>
</form>
</body>
</html>