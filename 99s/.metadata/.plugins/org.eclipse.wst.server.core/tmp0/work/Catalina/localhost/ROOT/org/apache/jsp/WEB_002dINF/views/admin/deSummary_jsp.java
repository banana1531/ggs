/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.53
 * Generated at: 2020-07-13 08:36:57 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class deSummary_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("<script type=\"text/javascript\" src=\"https://www.gstatic.com/charts/loader.js\"></script>    \r\n");
      out.write("<script>\r\n");
      out.write("\tgoogle.charts.load('current', {\r\n");
      out.write("\t\tpackages : ['corechart']});\r\n");
      out.write("\tgoogle.charts.setOnLoadCallback(drawLineColors);\r\n");
      out.write("\r\n");
      out.write("\tfunction drawLineColors() {\r\n");
      out.write("\t\tvar data = new google.visualization.DataTable();\r\n");
      out.write("\t\tdata.addColumn('string', 'X');\r\n");
      out.write("\t\tdata.addColumn('number', '접속자수');\r\n");
      out.write("\t\t//data.addColumn('number', '방문자수');\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tdata.addRows(");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${weekly}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write(");\r\n");
      out.write("\r\n");
      out.write("\t\tvar options = {\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\thAxis : {\r\n");
      out.write("\t\t\t\ttitle : 'week'\r\n");
      out.write("\t\t\t},\r\n");
      out.write("\t\t\tvAxis : {\r\n");
      out.write("\t\t\t\ttitle : 'Count',\r\n");
      out.write("\t\t\t\tminValue : 0\r\n");
      out.write("\t\t\t},\r\n");
      out.write("\t\t\tcolors : [ '#a52714', '#097138' ]\r\n");
      out.write("\t\t};\r\n");
      out.write("\r\n");
      out.write("\t\tvar chart = new google.visualization.LineChart(document\r\n");
      out.write("\t\t\t\t.getElementById('chart_div'));\r\n");
      out.write("\t\tchart.draw(data, options);\r\n");
      out.write("\t};\r\n");
      out.write("</script>\r\n");
      out.write("<script>\r\n");
      out.write("\tgoogle.charts.load('current', {\r\n");
      out.write("\t\tpackages : ['corechart']});\r\n");
      out.write("\tgoogle.charts.setOnLoadCallback(drawLineColors);\r\n");
      out.write("\r\n");
      out.write("\tfunction drawLineColors() {\r\n");
      out.write("\t\tvar data = new google.visualization.DataTable();\r\n");
      out.write("\t\tdata.addColumn('string', 'X');\r\n");
      out.write("\t\tdata.addColumn('number', '평균처리시간');\r\n");
      out.write("\t\t//data.addColumn('number', '방문자수');\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tdata.addRows(");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${avgTime}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write(");\r\n");
      out.write("\r\n");
      out.write("\t\tvar options = {\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\thAxis : {\r\n");
      out.write("\t\t\t\ttitle : 'week'\r\n");
      out.write("\t\t\t},\r\n");
      out.write("\t\t\tvAxis : {\r\n");
      out.write("\t\t\t\ttitle : 'Count',\r\n");
      out.write("\t\t\t\tminValue : 0\r\n");
      out.write("\t\t\t},\r\n");
      out.write("\t\t\tcolors : [ '#a52714', '#097138' ]\r\n");
      out.write("\t\t};\r\n");
      out.write("\r\n");
      out.write("\t\tvar chart = new google.visualization.LineChart(document\r\n");
      out.write("\t\t\t\t.getElementById('chart_div2'));\r\n");
      out.write("\t\tchart.draw(data, options);\r\n");
      out.write("\t};\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("   <h1>deSummary 들어왔다.</h1>\r\n");
      out.write("   <div class=\"container\">\r\n");
      out.write("\t   <button><a href=\"/admin/deSummary.gg\">접수 현황</a></button>\r\n");
      out.write("\t   <button><a href=\"/admin/declList.gg\">미처리 목록</a></button>\r\n");
      out.write("\t   <button><a href=\"/admin/dondeclList.gg\">처리완료 목록</a></button>\r\n");
      out.write("   </div>\r\n");
      out.write("   \r\n");
      out.write("   <div class=\"container\">\r\n");
      out.write("\t\t<table class=\"table\">\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td>금일 접수건 : ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${todayCnt }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("<br /> 미처리건 : ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${toDoCnt }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("<br /> 금주 누적\r\n");
      out.write("\t\t\t\t\t접수건 : ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${weekCnt }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("<br />\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<td><div id=\"chart_div\"></div>주간별 누적 점수건 그래프</td>\r\n");
      out.write("\t\t\t\t<td rowspan=\"2\">접수사유별 점유율 그래프</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td><div id=\"chart_div2\"></div>주간단위 평균 신고 처리 시간 그래프\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
