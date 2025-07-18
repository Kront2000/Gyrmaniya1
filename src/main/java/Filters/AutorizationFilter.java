package Filters;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Set;

import static java.util.Arrays.stream;

@WebFilter("/*")
public class AutorizationFilter extends HttpFilter {
    private static final Set<String> PRIVATE_PATH = Set.of("/gyrmaniya/admin", "/gyrmaniya/edit", "/gyrmaniya/complete");

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        req.setAttribute("login", ((HttpServletRequest) req).getSession().getAttribute("login"));
        var uri = ((HttpServletRequest) req).getRequestURI();
        if(isPrivatePath(uri) || isUserLoggedIn(req)){
            chain.doFilter(req, res);
        }else{
            ((HttpServletResponse) res).sendRedirect("/gyrmaniya/login");
        }
    }

    private boolean isPrivatePath(String uri){
        return !PRIVATE_PATH.stream().anyMatch(e -> uri.startsWith(e));
    }

    private boolean isUserLoggedIn(ServletRequest req){
        if(((HttpServletRequest) req).getSession().getAttribute("login") == null || ((HttpServletRequest) req).getSession().getAttribute("login").equals("false")){
            return false;
        }else {
            return true;
        }


    }
}
