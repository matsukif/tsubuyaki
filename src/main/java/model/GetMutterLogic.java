package model;

import java.util.List;
import model.Mutter;
import dao.MutterDAO;


public class GetMutterLogic {
	
	public GetMutterLogic() {
	}
	
	public List<Mutter> excute(){
	
		MutterDAO dao = new MutterDAO();
		
		List<Mutter> mutterList = dao.findAll();
				
		return mutterList;
		
		
	}
	

}
