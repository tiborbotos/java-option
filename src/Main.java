import com.tiborbotos.patterns.Option;
import com.tiborbotos.patterns.Option.ValueEmpty;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Option<Long> number = Option.none();
		
		if (number.isEmpty()) {
			System.out.println("Number is not presented!");
		} else {
			System.err.println(String.format("Number is %d", number.get()));
		}
		
		
		Option<Double> pi = Option.of(3.141592);
		
		if (pi.isEmpty()) {
			System.out.println("Number is not presented!");
		} else {
			System.err.println(String.format("Pi is %f", pi.get()));
		}
		
		Option<String> str = Option.of(null); // that is bad
		System.out.println(String.format("String is %s",str.getOrElse("<not presented>")));
		
		pi = Option.none();
		Double pi2 = pi.getOrElse(new ValueEmpty<Double>() {
			@Override
			public Double get() {
				throw new RuntimeException("Pi has no value, life is useless!");
			}
		});
		System.out.println(String.format("Pi2 is %f", pi2));
	}

}
