
public class Main {

	public static void main(String[] args) throws DuplicatedSampleException, InconsistentSampleSizeException {
		Sample s1 = new Sample("Cars", new float[] { 187.2f, 201.4f, 88.2f, 75.8f, 156.1f } );
		Sample s2 = new Sample("Bikes", new float[] { 91.3f, 98.7f, 111.3f, 120.4f, 100.2f } );		
		Sample s3 = new Sample("Motorbikes", new float[] { 122.3f, 118.7f, 144.0f, 125.4f, 88.9f } );		
		Sample s4 = new Sample("Skateboards", new float[] { 21.3f, 6.3f, 44.0f, 24.3f, 18.9f } );		

		Plot p1 = new SequentialPlot();
		p1.add(s1);
		p1.add(s2);
		p1.add(s3);
		p1.add(s4);

		Sample s5 = new Sample("Cars", new float[] { 187.2f, 201.4f, 88.2f, 75.8f, 156.1f } );
		Sample s6 = new Sample("Bikes", new float[] { 91.3f, 98.7f, 111.3f, 120.4f, 100.2f } );		
		Sample s7 = new Sample("Motorbikes", new float[] { 122.3f, 118.7f, 144.0f, 125.4f, 88.9f } );		

		Plot p2 = new AlternatePlot();
		p2.add(s5);
		p2.add(s6);
		p2.add(s7);
		p2.add(s4);

		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p1.equals(p2));
	}

}
