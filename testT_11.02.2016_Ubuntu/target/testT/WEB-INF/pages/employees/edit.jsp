<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Переименовать работника</title>


    <style type="text/css">
        .block1 {

            float: left;
            position: relative;
            top: 100px;
            left: 50px;
        }

        .block2 {
            position: fixed; /* Фиксированное положение */
            right: 430px; /* Расстояние от правого края окна браузера */
            bottom: 1%; /* Расстояние снизу */
        }

        table {
            color: #f8f8f8;
        }

        .colortext {
            background-color: #ffe; /* Цвет фона */
            color: #930; /* Цвет текста */
        }
    </style>


    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <!--[if IE]>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <![endif]-->
    <title> Responsive Single Page Template : Design View</title>
    <!--REQUIRED STYLE SHEETS-->
    <%--BUTTON STYLE CSS--%>
    <link href="resources/assets/css/button.css" rel="stylesheet"/>
    <!-- BOOTSTRAP CORE STYLE CSS -->
    <link href="resources/assets/css/bootstrap.css" rel="stylesheet"/>
    <!-- FONTAWESOME STYLE CSS -->
    <link href="resources/assets/css/font-awesome.min.css" rel="stylesheet"/>
    <!-- VEGAS STYLE CSS -->
    <link href="resources/assets/plugins/vegas/jquery.vegas.min.css" rel="stylesheet"/>
    <!-- CUSTOM STYLE CSS -->
    <link href="resources/assets/css/style.css" rel="stylesheet"/>
    <!-- GOOGLE FONT -->
    <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css'>
    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->


</head>
<body>

<div class="navbar navbar-inverse navbar-fixed-top scrollclass">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">YOUR LOGO</a>
        </div>
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-right">
                <li><a href="/">HOME</a></li>
                <li><a href="#about">ABOUT</a></li>
                <li><a href="#clients-testimonial">TESTIMONIALS</a></li>
                <li><a href="#pricing">PRICING</a></li>
                <li><a href="#contact">CONTACT</a></li>
                <li><a href="#social-section">SOCIAL</a></li>

            </ul>
        </div>

    </div>
</div>
<div class="block1">
<form:form method="post" action="/empSaveEdit">
    <table>
        <tr>
            <td><b>Имя:</b></td>
            <td><input type="text" class="colortext" name="firstName" value="${employee.firstName}"/></td>
            <td><b>Фамилия:</b></td>
            <td><input type="text" class="colortext" name="secondName" value="${employee.secondName}"/></td>
            <td><input type="hidden" name="empId" value="${employee.id}"/></td>
            <td><input type="hidden" name="depId" value="${employee.department.id}"/></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" class="button" value="Переименовать"/>
            </td>
        </tr>
    </table>
</form:form>

</div>


<div class="block2">
    <!--END SOCIAL SECTION-->
    <!--FOOTER SECTION -->
    <div class="for-full-back" id="footer">
        2014 www.yourdomain.com | All Right Reserved | by: <a href="http://binarytheme.com" target="_blank"
                                                              style="color:#fff">www.binarytheme.com</a>

    </div>

    <!-- END FOOTER SECTION -->

    <!-- JAVASCRIPT FILES PLACED AT THE BOTTOM TO REDUCE THE LOADING TIME  -->
    <!-- CORE JQUERY  -->
    <script src="resources/assets/plugins/jquery-1.10.2.js"></script>
    <!-- BOOTSTRAP CORE SCRIPT   -->
    <script src="resources/assets/plugins/bootstrap.js"></script>
    <!-- VEGAS SLIDESHOW SCRIPTS -->
    <script src="resources/assets/plugins/vegas/jquery.vegas.min.js"></script>
    <!-- SCROLL SCRIPTS -->
    <script src="resources/assets/plugins/jquery.easing.min.js"></script>
    <!-- CUSTOM SCRIPTS -->
    <script src="resources/assets/js/custom.js"></script>
</div>

</body>
</html>
