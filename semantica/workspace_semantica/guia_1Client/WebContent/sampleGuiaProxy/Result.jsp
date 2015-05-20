<%@page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<HTML>
<HEAD>
<TITLE>Result</TITLE>
</HEAD>
<BODY>
<H1>Result</H1>

<jsp:useBean id="sampleGuiaProxyid" scope="session" class="wssw.GuiaProxy" />
<%
if (request.getParameter("endpoint") != null && request.getParameter("endpoint").length() > 0)
sampleGuiaProxyid.setEndpoint(request.getParameter("endpoint"));
%>

<%
String method = request.getParameter("method");
int methodID = 0;
if (method == null) methodID = -1;

if(methodID != -1) methodID = Integer.parseInt(method);
boolean gotMethod = false;

try {
switch (methodID){ 
case 2:
        gotMethod = true;
        java.lang.String getEndpoint2mtemp = sampleGuiaProxyid.getEndpoint();
if(getEndpoint2mtemp == null){
%>
<%=getEndpoint2mtemp %>
<%
}else{
        String tempResultreturnp3 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getEndpoint2mtemp));
        %>
        <%= tempResultreturnp3 %>
        <%
}
break;
case 5:
        gotMethod = true;
        String endpoint_0id=  request.getParameter("endpoint8");
            java.lang.String endpoint_0idTemp = null;
        if(!endpoint_0id.equals("")){
         endpoint_0idTemp  = endpoint_0id;
        }
        sampleGuiaProxyid.setEndpoint(endpoint_0idTemp);
break;
case 10:
        gotMethod = true;
        wssw.Guia getGuia10mtemp = sampleGuiaProxyid.getGuia();
if(getGuia10mtemp == null){
%>
<%=getGuia10mtemp %>
<%
}else{
%>
<TABLE>
<TR>
<TD COLSPAN="3" ALIGN="LEFT">returnp:</TD>
</TABLE>
<%
}
break;
case 45:
        gotMethod = true;
        java.lang.String getCompetencias45mtemp = sampleGuiaProxyid.getCompetencias();
if(getCompetencias45mtemp == null){
%>
<%=getCompetencias45mtemp %>
<%
}else{
        String tempResultreturnp46 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getCompetencias45mtemp));
        %>
        <%= tempResultreturnp46 %>
        <%
}
break;
case 48:
        gotMethod = true;
        java.lang.String getEvaluacion48mtemp = sampleGuiaProxyid.getEvaluacion();
if(getEvaluacion48mtemp == null){
%>
<%=getEvaluacion48mtemp %>
<%
}else{
        String tempResultreturnp49 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getEvaluacion48mtemp));
        %>
        <%= tempResultreturnp49 %>
        <%
}
break;
case 51:
        gotMethod = true;
        java.lang.String getTitulacion51mtemp = sampleGuiaProxyid.getTitulacion();
if(getTitulacion51mtemp == null){
%>
<%=getTitulacion51mtemp %>
<%
}else{
        String tempResultreturnp52 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getTitulacion51mtemp));
        %>
        <%= tempResultreturnp52 %>
        <%
}
break;
case 54:
        gotMethod = true;
        java.lang.String getMaterias54mtemp = sampleGuiaProxyid.getMaterias();
if(getMaterias54mtemp == null){
%>
<%=getMaterias54mtemp %>
<%
}else{
        String tempResultreturnp55 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getMaterias54mtemp));
        %>
        <%= tempResultreturnp55 %>
        <%
}
break;
case 57:
        gotMethod = true;
        java.lang.String getCoordinacion57mtemp = sampleGuiaProxyid.getCoordinacion();
if(getCoordinacion57mtemp == null){
%>
<%=getCoordinacion57mtemp %>
<%
}else{
        String tempResultreturnp58 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getCoordinacion57mtemp));
        %>
        <%= tempResultreturnp58 %>
        <%
}
break;
case 60:
        gotMethod = true;
        java.lang.String getResumen60mtemp = sampleGuiaProxyid.getResumen();
if(getResumen60mtemp == null){
%>
<%=getResumen60mtemp %>
<%
}else{
        String tempResultreturnp61 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getResumen60mtemp));
        %>
        <%= tempResultreturnp61 %>
        <%
}
break;
case 63:
        gotMethod = true;
        java.lang.String getDatosAsignatura63mtemp = sampleGuiaProxyid.getDatosAsignatura();
if(getDatosAsignatura63mtemp == null){
%>
<%=getDatosAsignatura63mtemp %>
<%
}else{
        String tempResultreturnp64 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getDatosAsignatura63mtemp));
        %>
        <%= tempResultreturnp64 %>
        <%
}
break;
case 66:
        gotMethod = true;
        java.lang.String getOtrosRequisitos66mtemp = sampleGuiaProxyid.getOtrosRequisitos();
if(getOtrosRequisitos66mtemp == null){
%>
<%=getOtrosRequisitos66mtemp %>
<%
}else{
        String tempResultreturnp67 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getOtrosRequisitos66mtemp));
        %>
        <%= tempResultreturnp67 %>
        <%
}
break;
case 69:
        gotMethod = true;
        java.lang.String getRelacionConOtrasAsignaturas69mtemp = sampleGuiaProxyid.getRelacionConOtrasAsignaturas();
if(getRelacionConOtrasAsignaturas69mtemp == null){
%>
<%=getRelacionConOtrasAsignaturas69mtemp %>
<%
}else{
        String tempResultreturnp70 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getRelacionConOtrasAsignaturas69mtemp));
        %>
        <%= tempResultreturnp70 %>
        <%
}
break;
case 72:
        gotMethod = true;
        java.lang.String getResultadosAprendizaje72mtemp = sampleGuiaProxyid.getResultadosAprendizaje();
if(getResultadosAprendizaje72mtemp == null){
%>
<%=getResultadosAprendizaje72mtemp %>
<%
}else{
        String tempResultreturnp73 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getResultadosAprendizaje72mtemp));
        %>
        <%= tempResultreturnp73 %>
        <%
}
break;
case 75:
        gotMethod = true;
        java.lang.String getDescripcionDeContenidos75mtemp = sampleGuiaProxyid.getDescripcionDeContenidos();
if(getDescripcionDeContenidos75mtemp == null){
%>
<%=getDescripcionDeContenidos75mtemp %>
<%
}else{
        String tempResultreturnp76 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getDescripcionDeContenidos75mtemp));
        %>
        <%= tempResultreturnp76 %>
        <%
}
break;
case 78:
        gotMethod = true;
        java.lang.String getActividadesNoPresenciales78mtemp = sampleGuiaProxyid.getActividadesNoPresenciales();
if(getActividadesNoPresenciales78mtemp == null){
%>
<%=getActividadesNoPresenciales78mtemp %>
<%
}else{
        String tempResultreturnp79 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getActividadesNoPresenciales78mtemp));
        %>
        <%= tempResultreturnp79 %>
        <%
}
break;
case 81:
        gotMethod = true;
        java.lang.String getReferenciasBasicas81mtemp = sampleGuiaProxyid.getReferenciasBasicas();
if(getReferenciasBasicas81mtemp == null){
%>
<%=getReferenciasBasicas81mtemp %>
<%
}else{
        String tempResultreturnp82 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getReferenciasBasicas81mtemp));
        %>
        <%= tempResultreturnp82 %>
        <%
}
break;
case 84:
        gotMethod = true;
        java.lang.String getActividadesPresenciales84mtemp = sampleGuiaProxyid.getActividadesPresenciales();
if(getActividadesPresenciales84mtemp == null){
%>
<%=getActividadesPresenciales84mtemp %>
<%
}else{
        String tempResultreturnp85 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getActividadesPresenciales84mtemp));
        %>
        <%= tempResultreturnp85 %>
        <%
}
break;
case 87:
        gotMethod = true;
        java.lang.String getMetodologiaDocente87mtemp = sampleGuiaProxyid.getMetodologiaDocente();
if(getMetodologiaDocente87mtemp == null){
%>
<%=getMetodologiaDocente87mtemp %>
<%
}else{
        String tempResultreturnp88 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getMetodologiaDocente87mtemp));
        %>
        <%= tempResultreturnp88 %>
        <%
}
break;
case 90:
        gotMethod = true;
        java.lang.String getReferenciasComplementarias90mtemp = sampleGuiaProxyid.getReferenciasComplementarias();
if(getReferenciasComplementarias90mtemp == null){
%>
<%=getReferenciasComplementarias90mtemp %>
<%
}else{
        String tempResultreturnp91 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getReferenciasComplementarias90mtemp));
        %>
        <%= tempResultreturnp91 %>
        <%
}
break;
}
} catch (Exception e) { 
%>
Exception: <%= org.eclipse.jst.ws.util.JspUtils.markup(e.toString()) %>
Message: <%= org.eclipse.jst.ws.util.JspUtils.markup(e.getMessage()) %>
<%
return;
}
if(!gotMethod){
%>
result: N/A
<%
}
%>
</BODY>
</HTML>