package Action;

import java.lang.reflect.ParameterizedType;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.util.ServletContextAware;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;


public class ServletActionContext<T> extends ActionSupport
		implements ServletRequestAware, ServletResponseAware, ServletContextAware,ModelDriven<T> {

	private static final long serialVersionUID = 1L;
	protected ServletContext application;
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	protected HttpSession session;
	protected T model = null;
	
	public void setServletContext(ServletContext application) {
		this.application = application;
	}

	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
		this.session = this.request.getSession();
	}
	public T getModel() {
		return model;
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ServletActionContext() {
		ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
		Class clazz = (Class) type.getActualTypeArguments()[0];
		try {
			model = (T) clazz.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
