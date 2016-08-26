package datamanagement;

import java.util.List;
import org.jdom.Element; // changed explicitly 

public class UnitManager {

private static UnitManager uniManager_ = null; // variable forming class itself
	

	private UnitMap unitMap_;// class unitMap separate class File

	public static UnitManager unitMap() {
		if (uniManager_ == null)
			uniManager_ = new UnitManager();
		return uniManager_;
	}

	private UnitManager() {
		unitMap_ = new UnitMap();
	}

	public IUnit getUnit(String uc) {
		IUnit iu = unitMap_.get(uc);
		return iu != null ? iu : createUnit(uc);

	}

	private IUnit createUnit(String unitCode) {

		IUnit iUnit;

		for (Element el : (List<Element>) XMLManager.getXML().getDocument().getRootElement().getChild("unitTable")
				.getChildren("unit"))
			if (unitCode.equals(el.getAttributeValue("uid"))) {
				StudentUnitRecordList slist;

				slist = null;

				iUnit = new Unit(el.getAttributeValue("uid"),
						el.getAttributeValue("name"), Float.valueOf(
								el.getAttributeValue("ps")).floatValue(), Float
								.valueOf(el.getAttributeValue("cr"))
								.floatValue(), Float.valueOf(
								el.getAttributeValue("di")).floatValue(), Float
								.valueOf(el.getAttributeValue("hd"))
								.floatValue(), Float.valueOf(
								el.getAttributeValue("ae")).floatValue(),
						Integer.valueOf(el.getAttributeValue("asg1wgt"))
								.intValue(), Integer.valueOf(
								el.getAttributeValue("asg2wgt")).intValue(),
						Integer.valueOf(el.getAttributeValue("examwgt"))
								.intValue(), StudentUnitRecordManager
								.instance().getRecordsByUnit(unitCode));
				unitMap_.put(iUnit.getUnitCode(), iUnit);
				return iUnit;
			}

		throw new RuntimeException("DBMD: createUnit : unit not in file");
	}

	public UnitMap getUnits() {

		UnitMap unitMap;
		IUnit iUnit;

		unitMap = new UnitMap();
		for (Element el : (List<Element>) XMLManager.getXML().getDocument()
				.getRootElement().getChild("unitTable").getChildren("unit")) {
			iUnit = new UnitProxy(el.getAttributeValue("uid"),
					el.getAttributeValue("name"));
			unitMap.put(iUnit.getUnitCode(), iUnit);
		} // unit maps are filled with PROXY units
		return unitMap;
	}

}
