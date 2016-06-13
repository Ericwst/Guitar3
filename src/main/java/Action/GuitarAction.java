package Action;

import java.util.List;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import Model.Guitar;
import Model.Inventory;

public class GuitarAction extends ServletActionContext<Guitar> {
	private static final long serialVersionUID = 1L;

	private Inventory init() {
		WebApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(application);
		Inventory inventory = (Inventory) ctx.getBean("inventory");
		return inventory;
	}

	public String select() {

		List<Guitar> sourceList = init().search(model);
		if (model != null) {
			request.setAttribute("select", model);
		}
		request.setAttribute("result", sourceList);
		return "select";
	}

	public String delete() {
		init().delGuitar(model);
		List<Guitar> sourceList = init().getAllData();
		request.setAttribute("result", sourceList);
		return "delete";
	}

	public String save() {
		init().addGuitar(model);
		List<Guitar> sourceList = init().getAllData();
		request.setAttribute("result", sourceList);
		return "save";
	}
}
