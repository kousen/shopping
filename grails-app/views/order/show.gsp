<%@ page import="s2gx.Order" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'order.label', default: 'Order')}"/>
    <title><g:message code="default.show.label" args="[entityName]"/></title>
</head>

<body>
<a href="#show-order" class="skip" tabindex="-1"><g:message code="default.link.skip.label"
                                                            default="Skip to content&hellip;"/></a>

<div class="nav" role="navigation">
    <ul>
        <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
        <li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]"/></g:link></li>
        <li><g:link class="create" action="create"><g:message code="default.new.label"
                                                              args="[entityName]"/></g:link></li>
    </ul>
</div>

<div id="show-order" class="content scaffold-show" role="main">
    <h1><g:message code="default.show.label" args="[entityName]"/></h1>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>
    <ol class="property-list order">

        <g:if test="${orderInstance?.number}">
            <li class="fieldcontain">
                <span id="number-label" class="property-label"><g:message code="order.number.label"
                                                                          default="Number"/></span>

                <span class="property-value" aria-labelledby="number-label"><g:fieldValue bean="${orderInstance}"
                                                                                          field="number"/></span>

            </li>
        </g:if>

        <g:if test="${orderInstance?.customer}">
            <li class="fieldcontain">
                <span id="customer-label" class="property-label"><g:message code="order.customer.label"
                                                                            default="Customer"/></span>

                <span class="property-value" aria-labelledby="customer-label"><g:link controller="customer"
                                                                                      action="show"
                                                                                      id="${orderInstance?.customer?.id}">${orderInstance?.customer?.encodeAsHTML()}</g:link></span>

            </li>
        </g:if>

        <g:if test="${orderInstance?.dateCreated}">
            <li class="fieldcontain">
                <span id="dateCreated-label" class="property-label"><g:message code="order.dateCreated.label"
                                                                               default="Date Created"/></span>

                <span class="property-value" aria-labelledby="dateCreated-label"><g:formatDate
                        date="${orderInstance?.dateCreated}"/></span>

            </li>
        </g:if>

        <g:if test="${orderInstance?.lastUpdated}">
            <li class="fieldcontain">
                <span id="lastUpdated-label" class="property-label"><g:message code="order.lastUpdated.label"
                                                                               default="Last Updated"/></span>

                <span class="property-value" aria-labelledby="lastUpdated-label"><g:formatDate
                        date="${orderInstance?.lastUpdated}"/></span>

            </li>
        </g:if>

        <g:if test="${orderInstance?.orderLines}">
            <li class="fieldcontain">
                <span id="orderLines-label" class="property-label"><g:message code="order.orderLines.label"
                                                                              default="Order Lines"/></span>

                <g:each in="${orderInstance.orderLines}" var="o">
                    <span class="property-value" aria-labelledby="orderLines-label"><g:link controller="orderLine"
                                                                                            action="show"
                                                                                            id="${o.id}">${o?.encodeAsHTML()}</g:link></span>
                </g:each>

            </li>
        </g:if>

    </ol>
    <g:form url="[resource: orderInstance, action: 'delete']" method="DELETE">
        <fieldset class="buttons">
            <g:link class="edit" action="edit" resource="${orderInstance}"><g:message code="default.button.edit.label"
                                                                                      default="Edit"/></g:link>
            <g:actionSubmit class="delete" action="delete"
                            value="${message(code: 'default.button.delete.label', default: 'Delete')}"
                            onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');"/>
        </fieldset>
    </g:form>
</div>
</body>
</html>
