<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

    <header class="bg-dark dk header navbar navbar-fixed-top-xs">
      <div class="navbar-header aside-md">
        <a class="btn btn-link visible-xs" data-toggle="class:nav-off-screen,open" data-target="#nav,html">
          <i class="fa fa-bars"></i>
        </a>
        <a href="#" class="navbar-brand" data-toggle="fullscreen">
        	LOGO (SIS)
        </a>
        <a class="btn btn-link visible-xs" data-toggle="dropdown" data-target=".nav-user">
          <i class="fa fa-cog"></i>
        </a>
      </div>      
      <ul class="nav navbar-nav navbar-right m-n hidden-xs nav-user">
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown">
            <span class="thumb-sm avatar pull-left">
              <img src="http://bilecik.edu.tr/Tema/images/bLogo.jpg">
            </span>
            Doç.Dr. Cihan KARAKUZU <b class="caret"></b>
          </a>
          <ul class="dropdown-menu animated fadeInRight">
            <span class="arrow top"></span>
            <li>
              <a href="instructor/settings"><spring:message code="topmenu.instructor.settings"/></a>
            </li>
            <li>
              <a href="pinstructor/profile"><spring:message code="topmenu.instructor.profile"/></a>
            </li>
            <li class="divider"></li>
            <li>
              <a href="javascript:formSubmit()"><spring:message code="topmenu.instructor.logout"/></a>
            </li>
          </ul>
        </li>
      </ul>     
    </header>