<%@ page contentType="text/html;charset=UTF-8"  pageEncoding="UTF-8"%>
<nav lang=fa-ir >

    <div class="ui secondary  menu" style="height: 1rem;">
        <a href="/" class="item ${requestScope['javax.servlet.forward.request_uri'] eq '/' ? 'active' : ''}" >
            صفحه اصلی
        </a>
        <a href="/employees"
           class="item ${requestScope['javax.servlet.forward.request_uri'] eq '/employees' ? 'active' : ''}">
            کارمندان
        </a>
        <a href="/emails"
           class="item ${requestScope['javax.servlet.forward.request_uri'] eq '/emails' ? 'active' : ''}">
            ایمیل ها
        </a>
        <a href="/leaves"
           class="item ${requestScope['javax.servlet.forward.request_uri'] eq '/leaves' ? 'active' : ''}">
            مرخصی ها
        </a>

        <div class="right menu centered">
            <a href="#" class="item">ایجاد&nbsp;+</a>
            <div class="dt-navbar-dropdown dt-margin-remove" dt-dropdown="pos: bottom-right">
                <ul class="dt-nav dt-navbar-dropdown-nav">
                    <li><a href="/add/employee">کارمند</a></li>
                    <li><a href="/add/email">ایمیل</a></li>
                    <li><a href="/add/leave">مرخصی</a></li>

                </ul>
            </div>
            <a href="#" class="item" lang="fa">خروج</a>
        </div>
    </div>
</nav>