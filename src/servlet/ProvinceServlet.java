package servlet;

import domain.Province;
import org.codehaus.jackson.map.ObjectMapper;
import service.ProvinceService;
import service.impl.ProvinceServiceimpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/provinceServlet")
public class ProvinceServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
/*        ProvinceServiceimpl service=new ProvinceServiceimpl();
        List<Province> list = service.findAll();

        ObjectMapper mapper =new ObjectMapper();
        String json = mapper.writeValueAsString(list);*/
        ProvinceServiceimpl service=new ProvinceServiceimpl();
        String json = service.findAllJson();
        System.out.println(json);
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(json);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
