<%@ tag body-content="empty" trimDirectiveWhitespaces="true" %><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %><%@ taglib prefix="material" tagdir="/WEB-INF/tags/material" %><%@ attribute name="materialTypeData" required="true" type="ua.ksstroy.logic.material.MaterialTypeData" %><ul class="group">    <material:materialType materialType="${materialTypeData}"/>    <ul class="subgroups">        <ul class="materials">            <material:material materialList="${materialTypeData.materialDataList}"/>        </ul>        <c:forEach var="innerMaterialType" items="${materialTypeData.materialTypeDataList}">            <material:node materialTypeData="${innerMaterialType}"/>        </c:forEach>            </ul></ul>