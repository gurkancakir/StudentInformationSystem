<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<spring:message var="en" code="language.en" />
<spring:message var="tr" code="language.tr" />

<!-- .aside -->
<aside class="bg-dark lter aside-md hidden-print" id="nav">          
  <section class="vbox">
    <section class="w-f scrollable">
      <div class="slim-scroll" data-height="auto" data-disable-fade-out="true" data-distance="0" data-size="5px" data-color="#333333">
        
        <!-- nav -->
        <nav class="nav-primary hidden-xs">
          <ul class="nav">
            <li  class="active">
              <a href="admin" class="active">
                <i class="fa fa-dashboard icon">
                  <b class="bg-danger"></b>
                </i>
                <span><spring:message code="leftmenu.admin.home"/></span>
              </a>
            </li>
            <li >
              <a href="#faculty">
                <i class="fa fa-columns icon">
                  <b class="bg-warning"></b>
                </i>
                <span class="pull-right">
                  <i class="fa fa-angle-down text"></i>
                  <i class="fa fa-angle-up text-active"></i>
                </span>
                <span><spring:message code="leftmenu.admin.faculty"/></span>
              </a>
              <ul class="nav lt">
                <li >
                  <a href="admin/faculty/" >                                                        
                    <i class="fa fa-angle-right"></i>
                    <span><spring:message code="leftmenu.admin.faculty.list"/></span>
                  </a>
                </li>
                <li >
                  <a href="admin/faculty/add" >                                                        
                    <i class="fa fa-angle-right"></i>
                    <span><spring:message code="leftmenu.admin.faculty.add"/></span>
                  </a>
                </li>
              </ul>
            </li>
            <li >
              <a href="#department">
                <i class="fa fa-columns icon">
                  <b class="bg-warning"></b>
                </i>
                <span class="pull-right">
                  <i class="fa fa-angle-down text"></i>
                  <i class="fa fa-angle-up text-active"></i>
                </span>
                <span><spring:message code="leftmenu.admin.department"/></span>
              </a>
              <ul class="nav lt">
                <li >
                  <a href="admin/department/" >                                                        
                    <i class="fa fa-angle-right"></i>
                    <span><spring:message code="leftmenu.admin.department.list"/></span>
                  </a>
                </li>
                <li >
                  <a href="admin/department/add" >                                                        
                    <i class="fa fa-angle-right"></i>
                    <span><spring:message code="leftmenu.admin.department.add"/></span>
                  </a>
                </li>
              </ul>
            </li>
          </ul>
        </nav>
        <!-- / nav -->
      </div>
    </section>
    
    <footer class="footer lt hidden-xs b-t b-dark">
      <div id="chat" class="dropup">
        <section class="dropdown-menu on aside-md m-l-n">
          <section class="panel bg-white">
            <header class="panel-heading b-b b-light">Active chats</header>
            <div class="panel-body animated fadeInRight">
              <p class="text-sm">No active chats.</p>
              <p><a href="#" class="btn btn-sm btn-default">Start a chat</a></p>
            </div>
          </section>
        </section>
      </div>
      <div id="invite" class="dropup">                
        <section class="dropdown-menu on aside-md m-l-n">
          <section class="panel bg-white">
            <header class="panel-heading b-b b-light">
              John <i class="fa fa-circle text-success"></i>
            </header>
            <div class="panel-body animated fadeInRight">
              <p class="text-sm">No contacts in your lists.</p>
              <p><a href="#" class="btn btn-sm btn-facebook"><i class="fa fa-fw fa-facebook"></i> Invite from Facebook</a></p>
            </div>
          </section>
        </section>
      </div>
      <a href="#nav" data-toggle="class:nav-xs" class="pull-right btn btn-sm btn-dark btn-icon">
        <i class="fa fa-angle-left text"></i>
        <i class="fa fa-angle-right text-active"></i>
      </a>
      <div class="btn-group hidden-nav-xs">
        <a title="${ en }" class="btn btn-icon btn-sm btn-dark" href="?lang=en"><img alt="en" src="resources/img/en_language.gif" /></a>
        <a title="${ tr }" class="btn btn-icon btn-sm btn-dark" href="?lang=tr"><img alt="tr" src="resources/img/tr_language.gif" /></a>
      </div>
    </footer>
  </section>
</aside>
<!-- /.aside -->