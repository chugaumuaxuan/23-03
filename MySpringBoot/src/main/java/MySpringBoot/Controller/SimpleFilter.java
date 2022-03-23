package MySpringBoot.Controller;

import java.io.IOException;
import java.time.LocalTime;
import java.time.temporal.ChronoField;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@WebFilter(urlPatterns = "/*")
public class SimpleFilter implements Filter {	
	
	private final static Logger LOG = LoggerFactory.getLogger(SimpleFilter.class);

	private int count =0;
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {	
		
			long begin = LocalTime.now().getLong(ChronoField.MILLI_OF_DAY);
			
			++count;		
//			System.out.println(count);
		
			chain.doFilter(request, response);
			
			long end = LocalTime.now().getLong(ChronoField.MILLI_OF_DAY);
		
			long start = end - begin;
			
			if(count > 7 && start < 1000) {
				LOG.info("warning");
			}	
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		count = 0;
		Filter.super.init(filterConfig);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		Filter.super.destroy();
	}
	
}
