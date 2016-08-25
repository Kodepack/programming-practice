package datamanagement;

/**
 * 
 * ListUnitController will populate a unit list to any iUnitListener
 *
 */
public class ListUnitsController {
	//This variable will hold a UnitManager instance;
	private UnitManager unitManager;

	
	public ListUnitsController() {
		unitManager = UnitManager.unitMap();
	}

	public void listUnits(IUnitLister lister) {
		lister.clearUnits();
		UnitMap units = unitManager.getUnits();
		for (String s : units.keySet())
			lister.addUnit(units.get(s));
	}
}
