package config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

public class ContactAppDispatcherServletInıtıalizer extends AbstractAnnotationConfigDispatcherServletInitializer {

    protected Class<?>[] getRootConfigClasses() {

        return new Class[] {SpringRootConfiguration.class};
    }

    protected Class<?>[] getServletConfigClasses() {

        return new Class[] {SpringWebConfiguration.class};
    }

    protected String[] getServletMappings() {
        return new String[] {"/"};
    }

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        super.onStartup(servletContext);
    }
}
