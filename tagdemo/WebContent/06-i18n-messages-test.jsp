<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<c:set var="theLocale"
	value="${not empty param.theLocale ? param.theLocale : pageContext.request.locale} }"
	scope="session" />

<fmt:setLocale value="${theLocale}" />
<fmt:setBundle
	basename="com.wayneyong.jsp.tagdemo.i18n.resources.mylables" />


<html>

<body>

	<a href="06-i18n-messages-test.jsp?theLocale">English (US)</a> |
	<a href="06-i18n-messages-test.jsp?theLocale=es_ES">Spanish (ES)</a> |
	<a href="06-i18n-messages-test.jsp?theLocale=de_DE">German (DE)</a> 
	<hr>
	<br />
	<br />
	<fmt:message key="label.greeting" />
	<br />
	<br />

	<fmt:message key="label.firstName" />
	<i>John</i>
	<br />

	<fmt:message key="label.lastName" />
	<i>Doe</i>
	<br />

	<fmt:message key="label.welcome" />
	<br />

</body>

</html>