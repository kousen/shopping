<%@ page import="s2gx.Order" %>



<div class="fieldcontain ${hasErrors(bean: orderInstance, field: 'number', 'error')} required">
    <label for="number">
        <g:message code="order.number.label" default="Number"/>
        <span class="required-indicator">*</span>
    </label>
    <g:textField name="number" required="" value="${orderInstance?.number}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: orderInstance, field: 'customer', 'error')} required">
    <label for="customer">
        <g:message code="order.customer.label" default="Customer"/>
        <span class="required-indicator">*</span>
    </label>
    <g:select id="customer" name="customer.id" from="${s2gx.Customer.list()}" optionKey="id" required=""
              value="${orderInstance?.customer?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: orderInstance, field: 'orderLines', 'error')} ">
    <label for="orderLines">
        <g:message code="order.orderLines.label" default="Order Lines"/>

    </label>
    <g:select name="orderLines" from="${s2gx.OrderLine.list()}" multiple="multiple" optionKey="id" size="5"
              value="${orderInstance?.orderLines*.id}" class="many-to-many"/>

</div>

