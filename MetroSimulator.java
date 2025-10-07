public class MetroSimulator{
	
		// make all stations
		public static EndStation va_square;
		public static Station clarendon;
		public static Station court_house;
		public static Station rosslyn;
		public static Station foggy_bottom;
		public static Station farragut_west;
		public static Station mcpherson_square;
		public static TransferStation metro_center;
		public static Station federal_triangle;
		public static EndStation smithsonian;

		public static EndStation woodley_park;
		public static Station dupont_circle;
		public static Station farragut_north;
		// Metro Center defined above
		public static Station gallery_place;
		public static EndStation judiciary_square;

		public static EndStation s1;
		public static Station s2;
		public static Station s3;
		// Metro Center defined above
		public static Station s4;
		public static EndStation s5;

	public static void main(String[] args){
		initialize();
		makeOrangeLine();
		makeRedLine();
		makePurpleLine();

		int stops = va_square.tripLength(metro_center);
		System.out.println("There are " + stops + " stops between Virginia Square and Metro Center");
	}

	public static void initialize(){
		va_square = new EndStation("orange", "Virginia Square");
		clarendon = new Station("orange", "Clarendon");
		court_house = new Station("orange", "Court House");
		rosslyn = new Station("orange", "Rosslyn");
		foggy_bottom = new Station("orange", "Foggy Bottom");
		farragut_west = new Station("orange", "Farragut West");
		mcpherson_square = new Station("orange", "McPherson Square");
		metro_center = new TransferStation("orange/red/purple", "Metro Center");
		federal_triangle = new Station("orange", "Federal Triangle");
		smithsonian = new EndStation("orange", "Smithsonian");

		woodley_park = new EndStation("red", "Woodley Park");
		dupont_circle = new Station("red", "Dupont Circle");
		farragut_north = new Station("red", "Farragut North");
		// Metro Center defined above
		gallery_place = new Station("red", "Gallery Place");
		judiciary_square = new EndStation("red", "Judiciary Square");

		s1 = new EndStation("purple", "S1");
		s2 = new Station("purple", "S2");
		s3 = new Station("purple", "S3");
		// Metro Center defined above
		s4 = new Station("purple", "S4");
		s5 = new EndStation("purple", "S5");
	}

	public static EndStation makeOrangeLine(){
		va_square.connect(clarendon);

		va_square.makeEnd(clarendon);

		court_house.connect(claredon);

		rosslyn.connect(court_house);

		foggy_bottom.connect(rosslyn);

		farragut_west.connect(foggy_bottom);

		mcpherson_square.connect(farragut_west);

		metro_center.connect(mcpherson_square);

		federal_triangle.connect(metro_center);

		smithsonian.connect(metro_center);

		smithsonian.makeEnd(federal_triangle)
		return va_square;

	}
è
	public static EndStation makeRedLine() {
		woodley_park.connect(dupont_circle);
		dupont_circle.connect(farragut_north);
		farragut_north.connect(metro_center);
		metro_center.connect(judiciary_square);
		judiciary_square.connect(gallery_place);
		metro_center.addTransfer(gallery_place);
		metro_center.addTransfer(farragut_north);

		return (EndStation) woodley_park;
	}

	public static EndStation makePurpleLine(){
		s1.connect(s2);
		
		//connect the other stations here

		return s1;
	}
}