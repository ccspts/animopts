<%@ tag %>
<%@ taglib prefix="nav" tagdir="/WEB-INF/tags/core/nav" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="GlobalConstant" class="org.animopts.bean.GlobalConstant" scope="session"/>

<!-- Navigation -->
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <div class="container">
            <div class="navbar-header page-scroll">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand page-scroll" href=""><img src="<c:url value="${GlobalConstant.LOGO}" />"  class="logo" alt="Animo PTS" /></a>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse navbar-ex1-collapse">
                <ul class="nav navbar-nav">
                    <!-- Hidden li included to remove active class from about link when scrolled up past about section -->
                    <li class="hidden">
                        <a class="page-scroll" href="#intro"></a>
                    </li>
                    <li>
                        <a class="page-scroll" href="#intro">About us</a>
                    </li>
                    <li>
                        <a class="page-scroll" href="#contact">Contact us</a>
                    </li>
                </ul>
                <nav:nav-user />
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>