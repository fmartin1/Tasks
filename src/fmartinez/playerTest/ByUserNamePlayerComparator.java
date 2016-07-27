package fmartinez.playerTest;

import java.util.Comparator;

public class ByUserNamePlayerComparator implements Comparator<Player> {
	
	enum SortOrder {
		ASCENDING,
		DESCENDING
	}
	
	private SortOrder sortOrder;
	
	public ByUserNamePlayerComparator() {
		sortOrder = SortOrder.ASCENDING;
	}
	
	public ByUserNamePlayerComparator(SortOrder order){
		sortOrder = order;
	}
	
	@Override
	public int compare(Player o1, Player o2) {
		if ( sortOrder == SortOrder.DESCENDING ){
			return o2.getUserName().compareTo(o1.getUserName());
		}
		else {
			return o1.getUserName().compareTo(o2.getUserName());
		}
	}

}
