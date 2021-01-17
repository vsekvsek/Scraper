package model; 
import java.util.ArrayList; 
import java.util.Collections;
import java.util.List;

public class States {

	public List<String> getAllCities(){
		List<String> cityList = Collections.synchronizedList(new ArrayList<String>());
	 	cityList.addAll(getWashington());
		cityList.addAll(getOregon());
		cityList.addAll(getIdaho());
		cityList.addAll(getMontana());
		cityList.addAll(getCalifornia());
		cityList.addAll(getNevada());
		cityList.addAll( getArizon());
		cityList.addAll(getUtah());	 
		cityList.addAll(getColorado());
		cityList.add("wyoming");
		cityList.addAll(getNewMexico());
		cityList.addAll(getTexas());
		cityList.addAll(getOaklahoma());
		cityList.addAll(getKansas());
		cityList.addAll(getSouthDakota());
		cityList.addAll(getNorthDakota());
		cityList.addAll(getNebraska());
		cityList.addAll(getMinnesota());
		cityList.addAll(getIowa());
		cityList.addAll(getMissouri());
		cityList.addAll(getArkansas());
		cityList.addAll(getLousiana());
		cityList.addAll(getWisconsin());
		cityList.addAll(getIllinois());
		cityList.addAll(getMississippi());		
		cityList.addAll(getMichigan());
		cityList.addAll(getIndiana());
		cityList.addAll(getKentucky());
		cityList.addAll(getTennesse());
		cityList.addAll(getAlabama());
		cityList.addAll(getOhio());
		cityList.addAll(getGeorgia());
		cityList.addAll(getFlorida());
		cityList.addAll(getSouthCarolina());
		cityList.addAll(getNorthCarolina());
		cityList.addAll(getVirginia());
		cityList.addAll(getWestVirginia());
		cityList.addAll(getMaryland());		
		cityList.addAll(getDC());
		cityList.addAll(getNJ());
		cityList.addAll(getPennylvania());
		cityList.addAll(getNewYork());
		cityList.addAll(getConnecticut());
		cityList.addAll(getMassachusetts());
		cityList.addAll(getRhodeIsland());
		cityList.addAll(getVermont());		
		cityList.addAll(getNewHampshire());
		cityList.addAll(getMaine());
		cityList.addAll(getDeleware());
		return cityList;
	}
	
	public List<String> getWesternCities(){
		List<String> cityList = Collections.synchronizedList(new ArrayList<String>());
	 	cityList.addAll(getWashington());
		cityList.addAll(getOregon());
		cityList.addAll(getIdaho());
		return cityList;
	}
	public List<String> getWesternCities2(){
		List<String> cityList = Collections.synchronizedList(new ArrayList<String>());
	 	cityList.addAll(getMontana());
		cityList.addAll(getCalifornia()); 
		return cityList;
	}
	
	public List<String> getMidWesternCities(){
		List<String> cityList = Collections.synchronizedList(new ArrayList<String>());	 	 
		cityList.addAll(getNevada());
		cityList.addAll( getArizon());
		cityList.addAll(getUtah());	 
		cityList.addAll(getColorado());
		cityList.add("wyoming");
		cityList.addAll(getNewMexico());		
		return cityList;
	}
	public List<String> getMidWesternCities2(){
		List<String> cityList = Collections.synchronizedList(new ArrayList<String>());	 	
	
		cityList.addAll(getTexas());
		cityList.addAll(getOaklahoma());
		cityList.addAll(getKansas()); 	 
		return cityList;
	}
	
	public List<String> getMidWesternCities3(){
		List<String> cityList = Collections.synchronizedList(new ArrayList<String>());	 	
		cityList.addAll(getSouthDakota());
		cityList.addAll(getNorthDakota());
		cityList.addAll(getNebraska());
		cityList.addAll(getMinnesota());		 
		return cityList;
	}
	
	public List<String> getMidAtlanticCities(){
		List<String> cityList = Collections.synchronizedList(new ArrayList<String>());  
		cityList.addAll(getIowa());
		cityList.addAll(getMissouri());
		cityList.addAll(getArkansas());
		cityList.addAll(getLousiana());
		cityList.addAll(getWisconsin());
		cityList.addAll(getIllinois());
		cityList.addAll(getMississippi());		
		
		return cityList;
	}
	public List<String> getMidAtlanticCities2(){
		List<String> cityList = Collections.synchronizedList(new ArrayList<String>());  
		cityList.addAll(getMichigan());
		cityList.addAll(getIndiana());
		cityList.addAll(getKentucky());
		cityList.addAll(getTennesse());
		cityList.addAll(getAlabama());
		cityList.addAll(getOhio());
		cityList.addAll(getGeorgia());		 
		return cityList;
	}
	public List<String> getEasternCities(){
		List<String> cityList = Collections.synchronizedList(new ArrayList<String>());
		cityList.addAll(getFlorida());
		cityList.addAll(getSouthCarolina());
		cityList.addAll(getNorthCarolina());
		cityList.addAll(getVirginia());
		cityList.addAll(getWestVirginia());
		cityList.addAll(getMaryland());		
		cityList.addAll(getDC());
		cityList.addAll(getNJ());
		cityList.addAll(getPennylvania());
		return cityList;
	}
	public List<String> getEasternCities2(){
		List<String> cityList = Collections.synchronizedList(new ArrayList<String>());
		cityList.addAll(getNewYork());
		cityList.addAll(getConnecticut());
		cityList.addAll(getMassachusetts()); 
		return cityList;
	}
	public List<String> getEasternCities3(){
		List<String> cityList = Collections.synchronizedList(new ArrayList<String>());
		cityList.addAll(getRhodeIsland());
		cityList.addAll(getVermont());		
		cityList.addAll(getNewHampshire());
		cityList.addAll(getMaine());
		cityList.addAll(getDeleware());
		return cityList;
	}
	public List<String> getDeleware() {
		List<String> cityList = Collections.synchronizedList(new ArrayList<String>());
		cityList.add("delaware"); 
		return cityList;
	}
	public List<String> getMaine() {
		List<String> cityList = Collections.synchronizedList(new ArrayList<String>());
		cityList.add("maine"); 
		return cityList;
	}
	public List<String> getNewHampshire() {
		List<String> cityList = Collections.synchronizedList(new ArrayList<String>());
		cityList.add("nh");
		return cityList;
	}
	public List<String> getVermont() {
		List<String> cityList = Collections.synchronizedList(new ArrayList<String>());
		cityList.add("vermont"); 
		return cityList;
	}
	public List<String> getRhodeIsland() {
		List<String> cityList = Collections.synchronizedList(new ArrayList<String>());
		cityList.add("providence"); 
		return cityList;
	}
	public List<String> getMassachusetts() {
		List<String> cityList = Collections.synchronizedList(new ArrayList<String>());
		cityList.add("boston"); 
		cityList.add("capecod");
		cityList.add("southcoast");
		cityList.add("westernmass");
		cityList.add("worcester");
		return cityList;
	}
	public List<String> getConnecticut() {
		List<String> cityList = Collections.synchronizedList(new ArrayList<String>());
		cityList.add("newlondon"); 
		cityList.add("hartford");
		cityList.add("newhaven");
		cityList.add("nwct");
		return cityList;
	}
	public List<String> getNewYork() {
		List<String> cityList = Collections.synchronizedList(new ArrayList<String>());
		cityList.add("albany"); 
		cityList.add("binghamton");
		cityList.add("buffalo");
		cityList.add("catskills");
		cityList.add("chautauqua");
		cityList.add("elmira");
		cityList.add("fingerlakes");
		cityList.add("glensfalls");
		cityList.add("hudsonvalley");
		cityList.add("ithaca");
		cityList.add("longisland");
		cityList.add("newyork");
		cityList.add("oneonta");
		cityList.add("plattsburgh");
		cityList.add("potsdam");
		cityList.add("rochester");
		cityList.add("syracuse");
		cityList.add("twintiers");
		cityList.add("utica");
		cityList.add("watertown");
		return cityList;
	}
	public List<String> getPennylvania() {
		List<String> cityList = Collections.synchronizedList(new ArrayList<String>());
		cityList.add("altoona"); 
		cityList.add("chambersburg");
		cityList.add("erie");
		cityList.add("harrisburg");
		cityList.add("lancaster");
		cityList.add("allentown");
		cityList.add("meadville");
		cityList.add("philadelphia");
		cityList.add("pittsburgh");
		cityList.add("poconos");
		cityList.add("reading");
		cityList.add("scranton");
		cityList.add("pennstate");
		cityList.add("twintiers");
		cityList.add("williamsport");
		cityList.add("york");
		return cityList;
	}
	public List<String> getNJ() {
		List<String> cityList = Collections.synchronizedList(new ArrayList<String>());
		cityList.add("cnj"); 
		cityList.add("jerseyshore");
		cityList.add("newjersey");
		cityList.add("southjersey");
		return cityList;
	}
	public List<String> getDC() {
		List<String> cityList = Collections.synchronizedList(new ArrayList<String>());
		cityList.add("washingtondc"); 
		return cityList;
	}
	
	public List<String> getWyoming() {
		List<String> cityList = Collections.synchronizedList(new ArrayList<String>());
		cityList.add("wyoming"); 
		return cityList;
	} 
	public List<String> getMaryland() {
		List<String> cityList = Collections.synchronizedList(new ArrayList<String>());
		cityList.add("annapolis"); 
		cityList.add("baltimore");
		cityList.add("chambersburg");
		cityList.add("easternshore");
		cityList.add("frederick");
		cityList.add("smd");
		cityList.add("westmd");
		return cityList;
	}
	public List<String> getWestVirginia() {
		List<String> cityList = Collections.synchronizedList(new ArrayList<String>());
		cityList.add("charlestonwv"); 
		cityList.add("martinsburg");
		cityList.add("huntington");
		cityList.add("morgantown");
		cityList.add("parkersburg");
		cityList.add("swv");
		cityList.add("wv");
		return cityList;
	}
	public List<String> getVirginia() {
		List<String> cityList = Collections.synchronizedList(new ArrayList<String>());
		cityList.add("charlottesville"); 
		cityList.add("danville");
		cityList.add("easternshore");
		cityList.add("fredericksburg");
		cityList.add("harrisonburg");
		cityList.add("lynchburg");
		cityList.add("blacksburg");
		cityList.add("norfolk");
		cityList.add("richmond");
		cityList.add("roanoke");
		cityList.add("swva");
		cityList.add("winchester");
		return cityList;
	}
	
	public List<String> getNorthCarolina() {
		List<String> cityList = Collections.synchronizedList(new ArrayList<String>());
		cityList.add("asheville"); 
		cityList.add("boone");
		cityList.add("charlotte");
		cityList.add("eastnc");
		cityList.add("fayetteville");
		cityList.add("greensboro");
		cityList.add("hickory");
		cityList.add("onslow");
		cityList.add("outerbanks");
		cityList.add("raleigh");
		cityList.add("wilmington");
		cityList.add("winstonsalem");
		return cityList;
	}
	public List<String> getSouthCarolina() {
		List<String> cityList = Collections.synchronizedList(new ArrayList<String>());
		cityList.add("charleston"); 
		cityList.add("columbia");
		cityList.add("florencesc");
		cityList.add("greenville");
		cityList.add("hiltonhead");
		cityList.add("myrtlebeach");
		return cityList;
	}
	public List<String> getFlorida() {
		List<String> cityList = Collections.synchronizedList(new ArrayList<String>());
		cityList.add("daytona"); 
		cityList.add("keys");
		cityList.add("fortmyers");
		cityList.add("gainesville");
		cityList.add("cfl");
		cityList.add("jacksonville");
		cityList.add("lakeland");
		cityList.add("lakecity");
		cityList.add("ocala");
		cityList.add("okaloosa");
		cityList.add("orlando");
		cityList.add("panamacity");
		cityList.add("pensacola");
		cityList.add("sarasota");
		cityList.add("miami");
		cityList.add("spacecoast");
		cityList.add("staugustine");
		cityList.add("tallahassee");
		cityList.add("tampa");
		cityList.add("treasure");
		return cityList;
	}
	public List<String> getGeorgia() {
		List<String> cityList = Collections.synchronizedList(new ArrayList<String>());
		cityList.add("albanyga"); 
		cityList.add("athensga");
		cityList.add("atlanta");
		cityList.add("augusta");
		cityList.add("brunswick");
		cityList.add("columbusga");
		cityList.add("macon");
		cityList.add("nwga");
		cityList.add("savannah");
		cityList.add("statesboro");
		cityList.add("valdosta");
		return cityList;
	}
	public List<String> getOhio() {
		List<String> cityList = Collections.synchronizedList(new ArrayList<String>());
		cityList.add("akroncanton"); 
		cityList.add("ashtabula");
		cityList.add("athensohio");
		cityList.add("chillicothe");
		cityList.add("cincinnati");
		cityList.add("cleveland");
		cityList.add("columbus");
		cityList.add("dayton");
		cityList.add("huntington");
		cityList.add("limaohio");
		cityList.add("mansfield");
		cityList.add("wheeling");
		cityList.add("parkersburg");
		cityList.add("sandusky"); 
		cityList.add("toledo");
		cityList.add("tuscarawas");
		cityList.add("youngstown");
		cityList.add("zanesville");
		return cityList;
	}
	public List<String> getAlabama() {
		List<String> cityList = Collections.synchronizedList(new ArrayList<String>());
		cityList.add("auburn"); 
		cityList.add("bham");
		cityList.add("columbusga");
		cityList.add("dothan");
		cityList.add("shoals");
		cityList.add("gadsden");
		cityList.add("huntsville");
		cityList.add("mobile");
		cityList.add("montgomery");
		cityList.add("tuscaloosa");
		return cityList;
	}
	public List<String> getTennesse() {
		List<String> cityList = Collections.synchronizedList(new ArrayList<String>());
		cityList.add("chattanooga"); 
		cityList.add("clarksville");
		cityList.add("cookeville");
		cityList.add("jacksontn");
		cityList.add("knoxville");
		cityList.add("memphis");
		cityList.add("nashville");
		cityList.add("tricities");
		return cityList;
	}
	public List<String> getKentucky() {
		List<String> cityList = Collections.synchronizedList(new ArrayList<String>());
		cityList.add("bgky"); 
		cityList.add("cincinnati");
		cityList.add("eastky");
		cityList.add("huntington");
		cityList.add("lexington");
		cityList.add("louisville");
		cityList.add("owensboro");
		cityList.add("westky");
		return cityList;
	}
	public List<String> getIndiana() {
		List<String> cityList = Collections.synchronizedList(new ArrayList<String>());
		cityList.add("bloomington"); 
		cityList.add("evansville");
		cityList.add("fortwayne");
		cityList.add("indianapolis");
		cityList.add("kokomo");
		cityList.add("tippecanoe");
		cityList.add("muncie");
		cityList.add("richmondin");
		cityList.add("southbend");
		cityList.add("terrehaute");
		return cityList;
	}
	public List<String> getMichigan() {
		List<String> cityList = Collections.synchronizedList(new ArrayList<String>());
		cityList.add("annarbor"); 
		cityList.add("battlecreek");
		cityList.add("centralmich");
		cityList.add("detroit");
		cityList.add("flint");
		cityList.add("grandrapids");
		cityList.add("holland");
		cityList.add("jxn");
		cityList.add("kalamazoo");
		cityList.add("lansing");
		cityList.add("monroemi");
		cityList.add("muskegon");
		cityList.add("nmi");
		cityList.add("porthuron");
		cityList.add("saginaw");
		cityList.add("southbend");
		cityList.add("swmi");
		cityList.add("thumb");
		cityList.add("up");
		return cityList;
	}
	public List<String> getMississippi() {
		List<String> cityList = Collections.synchronizedList(new ArrayList<String>());
		cityList.add("gulfport"); 
		cityList.add("hattiesburg");
		cityList.add("jackson");
		cityList.add("meridian");
		cityList.add("northmiss");
		cityList.add("natchez");
		return cityList;
	}
	public List<String> getIllinois() {
		List<String> cityList = Collections.synchronizedList(new ArrayList<String>());
		cityList.add("bn"); 
		cityList.add("chambana");
		cityList.add("chicago");
		cityList.add("decatur");
		cityList.add("lasalle");
		cityList.add("mattoon");
		cityList.add("peoria");
		cityList.add("quadcities");
		cityList.add("rockford");
		cityList.add("carbondale");
		cityList.add("springfieldil");
		cityList.add("stlouis");
		cityList.add("quincy");
		return cityList;
	}
	public List<String> getWisconsin() {
		List<String> cityList = Collections.synchronizedList(new ArrayList<String>());
		cityList.add("appleton"); 
		cityList.add("duluth");
		cityList.add("eauclaire");
		cityList.add("greenbay");
		cityList.add("janesville");
		cityList.add("racine");
		cityList.add("lacrosse");
		cityList.add("madison");
		cityList.add("milwaukee");
		cityList.add("northernwi");
		cityList.add("sheboygan");
		cityList.add("wausau");
		return cityList;
	}
	public List<String> getLousiana() {
		List<String> cityList = Collections.synchronizedList(new ArrayList<String>());
		cityList.add("batonrouge"); 
		cityList.add("cenla"); 
		cityList.add("houma"); 
		cityList.add("lafayette"); 
		cityList.add("lakecharles"); 
		cityList.add("monroe"); 
		cityList.add("neworleans"); 
		cityList.add("shreveport"); 
		return cityList;
	}
	public List<String> getArkansas() {
		List<String> cityList = Collections.synchronizedList(new ArrayList<String>());
		cityList.add("fayar"); 
		cityList.add("fortsmith"); 
		cityList.add("jonesboro"); 
		cityList.add("littlerock"); 
		cityList.add("memphis"); 
		cityList.add("texarkana"); 
		return cityList;
	}
	public List<String> getMissouri() {
		List<String> cityList = Collections.synchronizedList(new ArrayList<String>());
		cityList.add("columbiamo"); 
		cityList.add("joplin"); 
		cityList.add("kansascity"); 
		cityList.add("kirksville"); 
		cityList.add("loz"); 
		cityList.add("semo"); 
		cityList.add("springfield"); 
		cityList.add("stjoseph"); 
		cityList.add("stlouis");
		return cityList;
	}
	public List<String> getIowa() {
		List<String> cityList = Collections.synchronizedList(new ArrayList<String>());
		cityList.add("ames"); 
		cityList.add("cedarrapids"); 
		cityList.add("desmoines"); 
		cityList.add("dubuque"); 
		cityList.add("fortdodge"); 
		cityList.add("iowacity"); 
		cityList.add("masoncity"); 
		cityList.add("omaha"); 
		cityList.add("quadcities");
		cityList.add("siouxcity"); 
		cityList.add("ottumwa"); 
		cityList.add("waterloo");
		return cityList;
	}
	public List<String> getMinnesota() {
		List<String> cityList = Collections.synchronizedList(new ArrayList<String>());
		cityList.add("bemidji"); 
		cityList.add("brainerd"); 
		cityList.add("duluth"); 
		cityList.add("fargo"); 
		cityList.add("mankato"); 
		cityList.add("minneapolis"); 
		cityList.add("rmn"); 
		cityList.add("marshall"); 
		cityList.add("stcloud");
		return cityList;
	}
	public List<String> getNebraska() {
		List<String> cityList = Collections.synchronizedList(new ArrayList<String>());
		cityList.add("grandisland"); 
		cityList.add("lincoln"); 
		cityList.add("northplatte"); 
		cityList.add("omaha"); 
		cityList.add("scottsbluff"); 
		cityList.add("siouxcity"); 
		return cityList;
	}
	public List<String> getNorthDakota() {
		List<String> cityList = Collections.synchronizedList(new ArrayList<String>());
		cityList.add("bismarck"); 
		cityList.add("fargo"); 
		cityList.add("grandforks"); 
		cityList.add("nd");
		return cityList;
	}
	public List<String> getSouthDakota() {
		List<String> cityList = Collections.synchronizedList(new ArrayList<String>());
		cityList.add("nesd"); 
		cityList.add("csd"); 
		cityList.add("rapidcity"); 
		cityList.add("siouxfalls"); 
		cityList.add("sd"); 
		return cityList;
	}
	public List<String> getKansas() {
		List<String> cityList = Collections.synchronizedList(new ArrayList<String>());
		cityList.add("kansascity"); 
		cityList.add("lawrence"); 
		cityList.add("ksu"); 
		cityList.add("nwks"); 
		cityList.add("salina");  
		cityList.add("seks"); 
		cityList.add("topeka"); 
		cityList.add("wichita"); 
		cityList.add("swks"); 
		return cityList;
	}
	public List<String> getOaklahoma() {
		List<String> cityList = Collections.synchronizedList(new ArrayList<String>());
		cityList.add("fortsmith");
		cityList.add("lawton");
		cityList.add("enid");
		cityList.add("oklahomacity");
		cityList.add("stillwater"); 
		cityList.add("texoma"); 
		cityList.add("tulsa"); 
		return cityList;
	}
	public List<String> getTexas() {
		List<String> cityList = Collections.synchronizedList(new ArrayList<String>());
		cityList.add("abilene");
		cityList.add("amarillo");
		cityList.add("austin");
		cityList.add("beaumont");
		cityList.add("brownsville");
		cityList.add("collegestation");
		cityList.add("corpuschristi");
		cityList.add("dallas");
		cityList.add("nacogdoches");
		cityList.add("delrio");
		cityList.add("elpaso");
		cityList.add("galveston");
		cityList.add("houston");
		cityList.add("killeen");
		cityList.add("laredo");
		cityList.add("lubbock");
		cityList.add("mcallen");
		cityList.add("odessa");
		cityList.add("sanangelo");
		cityList.add("sanantonio");
		cityList.add("sanmarcos");
		cityList.add("bigbend");
		cityList.add("texarkana");
		cityList.add("texoma");
		cityList.add("easttexas");
		cityList.add("victoriatx");
		cityList.add("waco");
		cityList.add("wichitafalls");
		
		return cityList;
	}
	public List<String>  getWashington(){
		List<String> cityList = Collections.synchronizedList(new ArrayList<String>());
		cityList.add("seattle");
		cityList.add("spokane");		
		cityList.add("bellingham");
		cityList.add("kpr");
		cityList.add("lewiston");
		cityList.add("moseslake");
		cityList.add("olympic");
		cityList.add("pullman");
		cityList.add("skagit");
		cityList.add("wenatchee");
		cityList.add("yakima"); 
		cityList.add("olympic"); 
		cityList.add("pullman"); 
		return cityList;
	}

	public  List<String> getOregon() {
		List<String> cityList = Collections.synchronizedList(new ArrayList<String>());
		cityList.add("portland"); 
		cityList.add("bend");
		cityList.add("corvallis");
		cityList.add("eastoregon");
		cityList.add("eugene");
		cityList.add("salem");
		cityList.add("humboldt");
		cityList.add("klamath");
		cityList.add("medford");
		cityList.add("oregoncoast");
		return cityList;
	}

	public  List<String> getIdaho() {
		List<String> cityList = Collections.synchronizedList(new ArrayList<String>());
		cityList.add("lewiston");
		cityList.add("boise");
		cityList.add("eastidaho");
		cityList.add("twinfalls"); 
		return cityList;
	}
	public  List<String> getMontana() {
		List<String> cityList = Collections.synchronizedList(new ArrayList<String>());
		cityList.add("billings");
		cityList.add("bozeman");
		cityList.add("butte");
		cityList.add("montana");
		cityList.add("greatfalls");
		cityList.add("helena");
		cityList.add("kalispell");
		cityList.add("missoula");
		return cityList;
	}
	public  List<String> getCalifornia() {
		List<String> cityList = Collections.synchronizedList(new ArrayList<String>());
		cityList.add("bakersfield") ;
		cityList.add("chico") ; 
		cityList.add("fresno") ; 
		cityList.add("goldcountry") ; 
		cityList.add("hanford") ;
		cityList.add("humboldt") ; 
		cityList.add("imperial") ; 
		cityList.add("inlandempire") ; 
		cityList.add("losangeles") ; 
		cityList.add("merced") ; 
		cityList.add("modesto") ; 
		cityList.add("monterey") ; 
		cityList.add("orangecounty") ;
		cityList.add("palmsprings") ; 
		cityList.add("redding") ; 
		cityList.add("reno") ; 
		cityList.add("sacramento") ; 
		cityList.add("sandiego") ; 
		cityList.add("slo") ; 
		cityList.add("santabarbara") ; 
		cityList.add("santamaria") ; 
		cityList.add("sfbay") ; 
		cityList.add("siskiyou") ; 
		cityList.add("susanville") ; 
		cityList.add("ventura") ; 
		cityList.add("visalia") ; 
		cityList.add("yubasutter");
		return cityList;
	}
	public  List<String> getNevada() {
		List<String> cityList = Collections.synchronizedList(new ArrayList<String>());
		cityList.add("elko");
		cityList.add("lasvegas");
		cityList.add("reno");	
		return cityList;
	}

	public  List<String> getArizon() {
		List<String> cityList = Collections.synchronizedList(new ArrayList<String>());
		cityList.add("flagstaff");
		cityList.add("mohave");
		cityList.add("phoenix");
		cityList.add("prescott");
		cityList.add("showlow");
		cityList.add("sierravista");
		cityList.add("tucson");
		cityList.add("yuma");
		return cityList;
	}
	
	public  List<String> getUtah() {
		List<String> cityList = Collections.synchronizedList(new ArrayList<String>());
		cityList.add("logan");
		cityList.add("ogden");
		cityList.add("provo");
		cityList.add("saltlakecity");
		cityList.add("stgeorge");
		return cityList;
	}
	public  List<String> getColorado(){
		List<String> cityList = Collections.synchronizedList(new ArrayList<String>());
		cityList.add("boulder");
		cityList.add("cosprings");
		cityList.add("denver");
		cityList.add("eastco");
		cityList.add("fortcollins");
		cityList.add("rockies");
		cityList.add("pueblo");
		cityList.add("westslope");
		return cityList;
	}
	
	public  List<String> getNewMexico() {
		List<String> cityList = Collections.synchronizedList(new ArrayList<String>());
		cityList.add("albuquerque");
		cityList.add("clovis");
		cityList.add("farmington");
		cityList.add("lascruces");
		cityList.add("roswell");
		cityList.add("santafe");
		return cityList;
	}

	public String getStateFor(String aCity) {
		if ((aCity.equalsIgnoreCase("flagstaff")) || 
				(aCity.equalsIgnoreCase("mohave")) || 
				(aCity.equalsIgnoreCase("phoenix")) || 
				(aCity.equalsIgnoreCase("prescott")) || 
				(aCity.equalsIgnoreCase("showlow")) || 
				(aCity.equalsIgnoreCase("sierravista")) || 
				(aCity.equalsIgnoreCase("tucson")) ||
				(aCity.equalsIgnoreCase("yuma") )){
			return "AZ";
		}
		if ((aCity.equalsIgnoreCase("elko")) || 
				(aCity.equalsIgnoreCase("lasvegas")) || 
				(aCity.equalsIgnoreCase("reno") )){
			return "NV";
		}
		if ((aCity.equalsIgnoreCase("bakersfield")) ||
				(aCity.equalsIgnoreCase("chico")) || 
				(aCity.equalsIgnoreCase("fresno")) || 
				(aCity.equalsIgnoreCase("goldcountry")) || 
				(aCity.equalsIgnoreCase("hanford")) || 
				(aCity.equalsIgnoreCase("humboldt")) || 
				(aCity.equalsIgnoreCase("imperial")) || 
				(aCity.equalsIgnoreCase("inlandempire")) || 
				(aCity.equalsIgnoreCase("losangeles")) || 
				(aCity.equalsIgnoreCase("merced")) || 
				(aCity.equalsIgnoreCase("modesto")) || 
				(aCity.equalsIgnoreCase("monterey")) || 
				(aCity.equalsIgnoreCase("orangecounty")) ||
				(aCity.equalsIgnoreCase("palmsprings")) || 
				(aCity.equalsIgnoreCase("redding")) || 
				(aCity.equalsIgnoreCase("reno")) || 
				(aCity.equalsIgnoreCase("sacramento")) || 
				(aCity.equalsIgnoreCase("sandiego")) || 
				(aCity.equalsIgnoreCase("slo")) || 
				(aCity.equalsIgnoreCase("santabarbara")) || 
				(aCity.equalsIgnoreCase("santamaria")) || 
				(aCity.equalsIgnoreCase("sfbay")) || 
				(aCity.equalsIgnoreCase("siskiyou")) || 
				(aCity.equalsIgnoreCase("susanville")) || 
				(aCity.equalsIgnoreCase("ventura")) || 
				(aCity.equalsIgnoreCase("visalia")) || 
				(aCity.equalsIgnoreCase("yubasutter") )){
			return "CA";
		}
		if ((aCity.equalsIgnoreCase("billings")) || 
				(aCity.equalsIgnoreCase("bozeman")) || 
				(aCity.equalsIgnoreCase("butte")) || 
				(aCity.equalsIgnoreCase("montana")) || 
				(aCity.equalsIgnoreCase("greatfalls")) || 
				(aCity.equalsIgnoreCase("helena")) || 
				(aCity.equalsIgnoreCase("missoula")) || 
				(aCity.equalsIgnoreCase("kalispell") )){
			return "MT";
		}
		if ((aCity.equalsIgnoreCase("lewiston")) || 
				(aCity.equalsIgnoreCase("boise")) || 
				(aCity.equalsIgnoreCase("eastidaho")) || 
				(aCity.equalsIgnoreCase("twinfalls") )){
			return "ID";
		}
		if ((aCity.equalsIgnoreCase("portland")) || 
				(aCity.equalsIgnoreCase("bend")) || 
				(aCity.equalsIgnoreCase("corvallis")) || 
				(aCity.equalsIgnoreCase("eastoregon")) || 
				(aCity.equalsIgnoreCase("eugene")) || 
				(aCity.equalsIgnoreCase("salem")) || 
				(aCity.equalsIgnoreCase("humboldt")) || 
				(aCity.equalsIgnoreCase("klamath")) || 
				(aCity.equalsIgnoreCase("medford")) || 
				(aCity.equalsIgnoreCase("oregoncoast") )){
			return "OR";
		}
		if ((aCity.equalsIgnoreCase("seattle")) || 
				(aCity.equalsIgnoreCase("spokane")) || 
				(aCity.equalsIgnoreCase("bellingham")) || 
				(aCity.equalsIgnoreCase("kpr")) || 
				(aCity.equalsIgnoreCase("lewiston")) || 
				(aCity.equalsIgnoreCase("moseslake")) || 
				(aCity.equalsIgnoreCase("olympic")) || 
				(aCity.equalsIgnoreCase("pullman")) || 
				(aCity.equalsIgnoreCase("skagit")) || 
				(aCity.equalsIgnoreCase("wenatchee")) || 
				(aCity.equalsIgnoreCase("yakima")) || 
				(aCity.equalsIgnoreCase("olympic")) || 
				(aCity.equalsIgnoreCase("pullman") )){
			return "WA";
		}
		if((aCity.equalsIgnoreCase("logan")) ||
				(aCity.equalsIgnoreCase("ogden")) ||
				(aCity.equalsIgnoreCase("provo"))||
				(aCity.equalsIgnoreCase("saltlakecity")) ||
				(aCity.equalsIgnoreCase("stgeorge"))) {
			return "UT";
		}
		if((aCity.equalsIgnoreCase("boulder")) ||
				(aCity.equalsIgnoreCase("cosprings")) ||
				(aCity.equalsIgnoreCase("denver"))||
				(aCity.equalsIgnoreCase("eastco")) ||
				(aCity.equalsIgnoreCase("fortcollins")) ||
				(aCity.equalsIgnoreCase("rockies")) ||
				(aCity.equalsIgnoreCase("pueblo")) ||
				(aCity.equalsIgnoreCase("westslope"))) {
			return "CO";
		}
		if(aCity.equalsIgnoreCase("wyoming")) {
			return "WY";
		}

		if((aCity.equalsIgnoreCase("albuquerque")) ||
				(aCity.equalsIgnoreCase("clovis")) ||
				(aCity.equalsIgnoreCase("farmington"))||
				(aCity.equalsIgnoreCase("lascruces")) ||
				(aCity.equalsIgnoreCase("roswell")) ||
				(aCity.equalsIgnoreCase("santafe"))) {
			return "NM";
		}
		if((aCity.equalsIgnoreCase("abilene")) ||
				(aCity.equalsIgnoreCase("amarillo")) ||
				(aCity.equalsIgnoreCase("austin")) ||
				(aCity.equalsIgnoreCase("beaumont")) ||
				(aCity.equalsIgnoreCase("brownsville")) ||
				(aCity.equalsIgnoreCase("collegestation")) ||
				(aCity.equalsIgnoreCase("corpuschristi")) ||
				(aCity.equalsIgnoreCase("dallas")) ||
				(aCity.equalsIgnoreCase("nacogdoches")) ||
				(aCity.equalsIgnoreCase("delrio")) ||
				(aCity.equalsIgnoreCase("elpaso")) ||
				(aCity.equalsIgnoreCase("galveston")) ||
				(aCity.equalsIgnoreCase("houston")) ||
				(aCity.equalsIgnoreCase("killeen")) ||
				(aCity.equalsIgnoreCase("laredo")) ||
				(aCity.equalsIgnoreCase("lubbock")) ||
				(aCity.equalsIgnoreCase("mcallen")) ||
				(aCity.equalsIgnoreCase("odessa")) ||
				(aCity.equalsIgnoreCase("sanangelo")) ||
				(aCity.equalsIgnoreCase("sanantonio")) ||
				(aCity.equalsIgnoreCase("sanmarcos")) ||
				(aCity.equalsIgnoreCase("bigbend")) ||
				(aCity.equalsIgnoreCase("texarkana")) ||
				(aCity.equalsIgnoreCase("texoma")) ||
				(aCity.equalsIgnoreCase("easttexas")) ||
				(aCity.equalsIgnoreCase("victoriatx")) ||
				(aCity.equalsIgnoreCase("waco")) ||
				(aCity.equalsIgnoreCase("wichitafalls")) ) {
			return "TX";
		}
		if((aCity.equalsIgnoreCase("fortsmith")) ||
				(aCity.equalsIgnoreCase("lawton")) ||
				(aCity.equalsIgnoreCase("enid")) ||
				(aCity.equalsIgnoreCase("oklahomacity")) ||
				(aCity.equalsIgnoreCase("stillwater")) || 
				(aCity.equalsIgnoreCase("texoma")) ||
				(aCity.equalsIgnoreCase("tulsa"))) {
			return "OK";
		}
		if((aCity.equalsIgnoreCase("kansascity")) ||
				(aCity.equalsIgnoreCase("lawrence")) ||
				(aCity.equalsIgnoreCase("ksu")) ||
				(aCity.equalsIgnoreCase("nwks")) ||
				(aCity.equalsIgnoreCase("salina")) || 
				(aCity.equalsIgnoreCase("seks")) ||
				(aCity.equalsIgnoreCase("topeka")) ||
				(aCity.equalsIgnoreCase("wichita")) ||
				(aCity.equalsIgnoreCase("swks"))) {
			return "KS";
		}
		if((aCity.equalsIgnoreCase("nesd")) || 
				(aCity.equalsIgnoreCase("csd")) ||
				(aCity.equalsIgnoreCase("rapidcity")) || 
				(aCity.equalsIgnoreCase("siouxfalls")) || 
				(aCity.equalsIgnoreCase("sd"))  
				) {
			return "SD";
		}
		if((aCity.equalsIgnoreCase("bismarck")) || 
				(aCity.equalsIgnoreCase("fargo")) ||
				(aCity.equalsIgnoreCase("grandforks")) ||  
				(aCity.equalsIgnoreCase("nd"))  
				) {
			return "ND";
		}
		if((aCity.equalsIgnoreCase("grandisland")) || 
				(aCity.equalsIgnoreCase("lincoln")) ||
				(aCity.equalsIgnoreCase("northplatte")) ||  
				(aCity.equalsIgnoreCase("omaha")) ||  
				(aCity.equalsIgnoreCase("scottsbluff")) ||  
				(aCity.equalsIgnoreCase("siouxcity"))  
				) {
			return "NE";
		}
		
		if((aCity.equalsIgnoreCase("bemidji")) || 
				(aCity.equalsIgnoreCase("brainerd")) ||
				(aCity.equalsIgnoreCase("duluth")) ||  
				(aCity.equalsIgnoreCase("fargo")) ||  
				(aCity.equalsIgnoreCase("mankato")) ||  
				(aCity.equalsIgnoreCase("minneapolis")) ||  
				(aCity.equalsIgnoreCase("rmn")) ||  
				(aCity.equalsIgnoreCase("marshall")) ||  
				(aCity.equalsIgnoreCase("stcloud"))  
				) {
			return "MN";
		}
		
		if((aCity.equalsIgnoreCase("ames")) || 
				(aCity.equalsIgnoreCase("cedarrapids")) ||
				(aCity.equalsIgnoreCase("desmoines")) ||  
				(aCity.equalsIgnoreCase("dubuque")) ||  
				(aCity.equalsIgnoreCase("fortdodge")) ||  
				(aCity.equalsIgnoreCase("iowacity")) ||  
				(aCity.equalsIgnoreCase("masoncity")) ||  
				(aCity.equalsIgnoreCase("omaha")) ||  
				(aCity.equalsIgnoreCase("quadcities")) ||  
				(aCity.equalsIgnoreCase("siouxcity")) ||  
				(aCity.equalsIgnoreCase("ottumwa")) ||  
				(aCity.equalsIgnoreCase("waterloo"))  
				) {
			return "IA";
		}
		
		if((aCity.equalsIgnoreCase("columbiamo")) || 
				(aCity.equalsIgnoreCase("joplin")) ||
				(aCity.equalsIgnoreCase("kansascity")) ||  
				(aCity.equalsIgnoreCase("kirksville")) ||  
				(aCity.equalsIgnoreCase("loz")) ||  
				(aCity.equalsIgnoreCase("semo")) ||  
				(aCity.equalsIgnoreCase("springfield")) ||  
				(aCity.equalsIgnoreCase("stjoseph")) || 
				(aCity.equalsIgnoreCase("stlouis"))  
				) {
			return "MO";
		}
		if((aCity.equalsIgnoreCase("fayar")) || 
				(aCity.equalsIgnoreCase("fortsmith")) ||
				(aCity.equalsIgnoreCase("jonesboro")) ||  
				(aCity.equalsIgnoreCase("littlerock")) ||  
				(aCity.equalsIgnoreCase("memphis")) ||  
				(aCity.equalsIgnoreCase("texarkana"))  
				) {
			return "AR";
		}
		
		if((aCity.equalsIgnoreCase("batonrouge")) || 
				(aCity.equalsIgnoreCase("cenla")) ||
				(aCity.equalsIgnoreCase("houma")) ||  
				(aCity.equalsIgnoreCase("lafayette")) ||  
				(aCity.equalsIgnoreCase("lakecharles")) || 
				(aCity.equalsIgnoreCase("monroe")) ||  
				(aCity.equalsIgnoreCase("neworleans")) ||  
				(aCity.equalsIgnoreCase("shreveport"))  
				) {
			return "LA";
		}
	
		if((aCity.equalsIgnoreCase("appleton")) || 
				(aCity.equalsIgnoreCase("duluth")) ||
				(aCity.equalsIgnoreCase("eauclaire")) ||  
				(aCity.equalsIgnoreCase("greenbay")) ||  
				(aCity.equalsIgnoreCase("janesville")) || 
				(aCity.equalsIgnoreCase("racine")) ||  
				(aCity.equalsIgnoreCase("lacrosse")) ||  
				(aCity.equalsIgnoreCase("madison")) || 
				(aCity.equalsIgnoreCase("milwaukee")) || 
				(aCity.equalsIgnoreCase("northernwi")) || 
				(aCity.equalsIgnoreCase("sheboygan")) || 
				(aCity.equalsIgnoreCase("wausau"))  
				) {
			return "WI";
		}
		if((aCity.equalsIgnoreCase("bn")) || 
				(aCity.equalsIgnoreCase("chambana")) ||
				(aCity.equalsIgnoreCase("chicago")) ||  
				(aCity.equalsIgnoreCase("decatur")) ||  
				(aCity.equalsIgnoreCase("lasalle")) || 
				(aCity.equalsIgnoreCase("mattoon")) ||  
				(aCity.equalsIgnoreCase("peoria")) ||  
				(aCity.equalsIgnoreCase("quadcities")) || 
				(aCity.equalsIgnoreCase("rockford")) || 
				(aCity.equalsIgnoreCase("carbondale")) || 
				(aCity.equalsIgnoreCase("springfieldil")) || 
				(aCity.equalsIgnoreCase("stlouis")) || 
				(aCity.equalsIgnoreCase("quincy"))  
				) {
			return "IL";
		}
		if((aCity.equalsIgnoreCase("gulfport")) || 
				(aCity.equalsIgnoreCase("hattiesburg")) ||
				(aCity.equalsIgnoreCase("jackson")) ||  
				(aCity.equalsIgnoreCase("meridian")) ||  
				(aCity.equalsIgnoreCase("northmiss")) || 
				(aCity.equalsIgnoreCase("natchez"))  
				) {
			return "MS";
		}
		
		if((aCity.equalsIgnoreCase("annarbor")) || 
				(aCity.equalsIgnoreCase("battlecreek")) ||
				(aCity.equalsIgnoreCase("centralmich")) ||  
				(aCity.equalsIgnoreCase("detroit")) ||  
				(aCity.equalsIgnoreCase("flint")) || 
				(aCity.equalsIgnoreCase("grandrapids")) ||  
				(aCity.equalsIgnoreCase("holland")) ||  
				(aCity.equalsIgnoreCase("jxn")) || 
				(aCity.equalsIgnoreCase("kalamazoo")) || 
				(aCity.equalsIgnoreCase("lansing")) || 
				(aCity.equalsIgnoreCase("monroemi")) || 
				(aCity.equalsIgnoreCase("muskegon")) || 
				(aCity.equalsIgnoreCase("nmi")) || 
				(aCity.equalsIgnoreCase("porthuron")) || 
				(aCity.equalsIgnoreCase("muskegon")) || 
				(aCity.equalsIgnoreCase("saginaw")) || 
				(aCity.equalsIgnoreCase("southbend")) || 
				(aCity.equalsIgnoreCase("swmi")) || 
				(aCity.equalsIgnoreCase("thumb")) || 
				(aCity.equalsIgnoreCase("up"))  
				) {
			return "MI";
		}
		
		if((aCity.equalsIgnoreCase("bloomington")) || 
				(aCity.equalsIgnoreCase("evansville")) ||
				(aCity.equalsIgnoreCase("fortwayne")) ||  
				(aCity.equalsIgnoreCase("indianapolis")) ||  
				(aCity.equalsIgnoreCase("kokomo")) || 
				(aCity.equalsIgnoreCase("tippecanoe")) || 
				(aCity.equalsIgnoreCase("muncie")) || 
				(aCity.equalsIgnoreCase("richmondin")) || 
				(aCity.equalsIgnoreCase("southbend")) || 
				(aCity.equalsIgnoreCase("terrehaute"))  
				) {
			return "IN";
		}
		
		if((aCity.equalsIgnoreCase("bgky")) || 
				(aCity.equalsIgnoreCase("cincinnati")) ||
				(aCity.equalsIgnoreCase("eastky")) ||  
				(aCity.equalsIgnoreCase("huntington")) ||  
				(aCity.equalsIgnoreCase("lexington")) || 
				(aCity.equalsIgnoreCase("louisville")) ||  
				(aCity.equalsIgnoreCase("owensboro")) || 
				(aCity.equalsIgnoreCase("westky"))  
				) {
			return "KY";
		}
		
		if((aCity.equalsIgnoreCase("chattanooga")) || 
				(aCity.equalsIgnoreCase("clarksville")) ||
				(aCity.equalsIgnoreCase("cookeville")) ||  
				(aCity.equalsIgnoreCase("jacksontn")) ||  
				(aCity.equalsIgnoreCase("knoxville")) || 
				(aCity.equalsIgnoreCase("memphis")) ||  
				(aCity.equalsIgnoreCase("nashville")) ||  
				(aCity.equalsIgnoreCase("tricities"))  
				) {
			return "TN";
		}
		
		if((aCity.equalsIgnoreCase("auburn")) || 
				(aCity.equalsIgnoreCase("bham")) ||
				(aCity.equalsIgnoreCase("columbusga")) ||  
				(aCity.equalsIgnoreCase("dothan")) ||  
				(aCity.equalsIgnoreCase("shoals")) || 
				(aCity.equalsIgnoreCase("gadsden")) ||  
				(aCity.equalsIgnoreCase("huntsville")) ||  
				(aCity.equalsIgnoreCase("mobile")) || 
				(aCity.equalsIgnoreCase("montgomery")) || 
				(aCity.equalsIgnoreCase("tuscaloosa"))  
				) {
			return "AL";
		}
		
		if((aCity.equalsIgnoreCase("akroncanton")) || 
				(aCity.equalsIgnoreCase("ashtabula")) ||
				(aCity.equalsIgnoreCase("athensohio")) ||  
				(aCity.equalsIgnoreCase("chillicothe")) ||  
				(aCity.equalsIgnoreCase("cincinnati")) || 
				(aCity.equalsIgnoreCase("cleveland")) ||
				(aCity.equalsIgnoreCase("columbus")) ||  
				(aCity.equalsIgnoreCase("dayton")) ||  
				(aCity.equalsIgnoreCase("huntington")) || 
				(aCity.equalsIgnoreCase("limaohio")) ||
				(aCity.equalsIgnoreCase("mansfield")) ||  
				(aCity.equalsIgnoreCase("wheeling")) ||  
				(aCity.equalsIgnoreCase("parkersburg")) || 
				(aCity.equalsIgnoreCase("sandusky")) ||
				(aCity.equalsIgnoreCase("toledo")) ||  
				(aCity.equalsIgnoreCase("tuscarawas")) ||  
				(aCity.equalsIgnoreCase("youngstown")) || 
				(aCity.equalsIgnoreCase("zanesville"))  
				) {
			return "OH";
		}
		if((aCity.equalsIgnoreCase("albanyga")) || 
				(aCity.equalsIgnoreCase("athensga")) ||
				(aCity.equalsIgnoreCase("atlanta")) ||  
				(aCity.equalsIgnoreCase("augusta")) ||  
				(aCity.equalsIgnoreCase("brunswick")) || 
				(aCity.equalsIgnoreCase("columbusga")) ||
				(aCity.equalsIgnoreCase("macon")) ||  
				(aCity.equalsIgnoreCase("nwga")) ||  
				(aCity.equalsIgnoreCase("savannah")) || 
				(aCity.equalsIgnoreCase("statesboro")) || 
				(aCity.equalsIgnoreCase("valdosta"))  
				) {
			return "GA";
		}
		
		
		if((aCity.equalsIgnoreCase("daytona")) || 
				(aCity.equalsIgnoreCase("keys")) ||
				(aCity.equalsIgnoreCase("fortmyers")) ||  
				(aCity.equalsIgnoreCase("gainesville")) ||  
				(aCity.equalsIgnoreCase("cfl")) || 
				(aCity.equalsIgnoreCase("jacksonville")) ||
				(aCity.equalsIgnoreCase("lakeland")) ||  
				(aCity.equalsIgnoreCase("lakecity")) ||  
				(aCity.equalsIgnoreCase("ocala")) || 
				(aCity.equalsIgnoreCase("okaloosa")) ||
				(aCity.equalsIgnoreCase("orlando")) ||  
				(aCity.equalsIgnoreCase("panamacity")) ||  
				(aCity.equalsIgnoreCase("pensacola")) || 
				(aCity.equalsIgnoreCase("sarasota")) ||
				(aCity.equalsIgnoreCase("miami")) ||  
				(aCity.equalsIgnoreCase("spacecoast")) ||  
				(aCity.equalsIgnoreCase("staugustine")) || 
				(aCity.equalsIgnoreCase("tallahassee")) ||  
				(aCity.equalsIgnoreCase("tampa")) || 
				(aCity.equalsIgnoreCase("treasure"))  
				) {
			return "FL";
		}
		
		if((aCity.equalsIgnoreCase("charleston")) || 
				(aCity.equalsIgnoreCase("columbia")) ||
				(aCity.equalsIgnoreCase("florencesc")) ||  
				(aCity.equalsIgnoreCase("greenville")) ||  
				(aCity.equalsIgnoreCase("hiltonhead")) || 
				(aCity.equalsIgnoreCase("myrtlebeach"))  
				) {
			return "SC";
		}
		
		if((aCity.equalsIgnoreCase("asheville")) || 
				(aCity.equalsIgnoreCase("boone")) ||
				(aCity.equalsIgnoreCase("charlotte")) ||  
				(aCity.equalsIgnoreCase("eastnc")) ||  
				(aCity.equalsIgnoreCase("fayetteville")) || 
				(aCity.equalsIgnoreCase("greensboro")) ||
				(aCity.equalsIgnoreCase("hickory")) ||
				(aCity.equalsIgnoreCase("onslow")) ||
				(aCity.equalsIgnoreCase("outerbanks")) ||
				(aCity.equalsIgnoreCase("raleigh")) ||
				(aCity.equalsIgnoreCase("wilmington")) ||
				(aCity.equalsIgnoreCase("winstonsalem"))  
				) {
			return "NC";
		}
		
		if((aCity.equalsIgnoreCase("charlottesville")) || 
				(aCity.equalsIgnoreCase("danville")) || 
				(aCity.equalsIgnoreCase("easternshore")) || 
				(aCity.equalsIgnoreCase("fredericksburg")) ||
				(aCity.equalsIgnoreCase("harrisonburg")) ||  
				(aCity.equalsIgnoreCase("lynchburg")) ||  
				(aCity.equalsIgnoreCase("blacksburg")) || 
				(aCity.equalsIgnoreCase("norfolk")) ||
				(aCity.equalsIgnoreCase("richmond")) ||  
				(aCity.equalsIgnoreCase("roanoke")) ||  
				(aCity.equalsIgnoreCase("swva")) || 
				(aCity.equalsIgnoreCase("winchester"))  
				) {
			return "VA";
		}
		if((aCity.equalsIgnoreCase("washingtondc")) )  
				{
			return "DC";
		}
		if((aCity.equalsIgnoreCase("charlestonwv")) || 
				(aCity.equalsIgnoreCase("martinsburg")) ||
				(aCity.equalsIgnoreCase("huntington")) ||  
				(aCity.equalsIgnoreCase("morgantown")) ||  
				(aCity.equalsIgnoreCase("parkersburg")) || 
				(aCity.equalsIgnoreCase("swv")) || 
				(aCity.equalsIgnoreCase("wv"))  
				) {
			return "WV";
		}
		if((aCity.equalsIgnoreCase("annapolis")) || 
				(aCity.equalsIgnoreCase("baltimore")) ||
				(aCity.equalsIgnoreCase("chambersburg")) ||  
				(aCity.equalsIgnoreCase("easternshore")) ||  
				(aCity.equalsIgnoreCase("frederick")) || 
				(aCity.equalsIgnoreCase("smd")) || 
				(aCity.equalsIgnoreCase("westmd"))  
				) {
			return "MD";
		}
		if((aCity.equalsIgnoreCase("cnj")) || 
				(aCity.equalsIgnoreCase("jerseyshore")) ||  
				(aCity.equalsIgnoreCase("newjersey")) || 
				(aCity.equalsIgnoreCase("southjersey"))  
				) {
			return "NJ";
		}
		
		if((aCity.equalsIgnoreCase("altoona")) || 
				(aCity.equalsIgnoreCase("chambersburg")) ||
				(aCity.equalsIgnoreCase("erie")) ||  
				(aCity.equalsIgnoreCase("harrisburg")) ||  
				(aCity.equalsIgnoreCase("lancaster")) || 
				(aCity.equalsIgnoreCase("allentown")) ||
				(aCity.equalsIgnoreCase("meadville")) ||  
				(aCity.equalsIgnoreCase("philadelphia")) ||  
				(aCity.equalsIgnoreCase("pittsburgh")) || 
				(aCity.equalsIgnoreCase("poconos")) ||
				(aCity.equalsIgnoreCase("reading")) ||  
				(aCity.equalsIgnoreCase("scranton")) ||  
				(aCity.equalsIgnoreCase("pennstate")) || 
				(aCity.equalsIgnoreCase("twintiers")) || 
				(aCity.equalsIgnoreCase("williamsport")) || 
				(aCity.equalsIgnoreCase("york"))  
				) {
			return "PA";
		}
		if((aCity.equalsIgnoreCase("albany")) || 
				(aCity.equalsIgnoreCase("binghamton")) ||
				(aCity.equalsIgnoreCase("buffalo")) ||  
				(aCity.equalsIgnoreCase("catskills")) ||  
				(aCity.equalsIgnoreCase("chautauqua")) || 
				(aCity.equalsIgnoreCase("elmira")) ||
				(aCity.equalsIgnoreCase("fingerlakes")) ||  
				(aCity.equalsIgnoreCase("glensfalls")) ||  
				(aCity.equalsIgnoreCase("hudsonvalley")) || 
				(aCity.equalsIgnoreCase("ithaca")) ||
				(aCity.equalsIgnoreCase("longisland")) ||  
				(aCity.equalsIgnoreCase("newyork")) ||  
				(aCity.equalsIgnoreCase("oneonta")) || 
				(aCity.equalsIgnoreCase("plattsburgh")) ||
				(aCity.equalsIgnoreCase("potsdam")) ||  
				(aCity.equalsIgnoreCase("rochester")) ||  
				(aCity.equalsIgnoreCase("syracuse")) || 
				(aCity.equalsIgnoreCase("twintiers")) || 
				(aCity.equalsIgnoreCase("utica")) || 
				(aCity.equalsIgnoreCase("watertown"))  
				) {
			return "NY";
		}
		if((aCity.equalsIgnoreCase("newlondon")) || 
				(aCity.equalsIgnoreCase("hartford")) ||  
				(aCity.equalsIgnoreCase("newhaven")) || 
				(aCity.equalsIgnoreCase("nwct"))  
				) {
			return "CT";
		}
		
		if((aCity.equalsIgnoreCase("boston")) || 
				(aCity.equalsIgnoreCase("capecod")) ||
				(aCity.equalsIgnoreCase("southcoast")) ||  
				(aCity.equalsIgnoreCase("westernmass")) ||  
				(aCity.equalsIgnoreCase("worcester"))  
				) {
			return "MA";
		}
		if((aCity.equalsIgnoreCase("providence"))
				) {
			return "RI";
		}
		if((aCity.equalsIgnoreCase("vermont")) 
				) {
			return "VT";
		}
		if((aCity.equalsIgnoreCase("nh")) 
				) {
			return "NH";
		}
		if((aCity.equalsIgnoreCase("maine")) 
				) {
			return "ME";
		}if((aCity.equalsIgnoreCase("delaware"))
				) {
			return "DE";
		}
		
		return "";
	}
}
