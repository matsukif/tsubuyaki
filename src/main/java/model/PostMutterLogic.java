package model;

import java.util.List;
import model.Mutter;
import dao.MutterDAO;

public class PostMutterLogic {

	public void excute(Mutter mutter) {
		
		MutterDAO dao = new MutterDAO();
		dao.create(mutter);
		
	}
}
