package peopleMoverDB.model;

import java.util.List;

public class StopsWithWP extends Stops {
List<WayPoints> listwp;

public List<WayPoints> getListwp() {
	return listwp;
}

public void setListwp(List<WayPoints> listwp) {
	this.listwp = listwp;
}
}
