package model;

import java.util.List;
import model.Mutter;

public class PostMutterLogic {

	public void excute(Mutter mutter, List<Mutter> mutterList) {
		mutterList.add(0,mutter);
	}
}
