package com.tiborbotos.patterns;

/**
 * Option pattern implementation. Option model is basically a wrapper around a given type
 * forcing the user of the class to check is it empty or not. The value is immutable.
 * 
 * Use {@link #of(Object)} to instantiate new value, or {@link #none()} to mark object as 
 * empty.
 * 
 * @author Tibor Botos
 * @param <T> Type parameter of the wrapped value
 */
public abstract class Option<T> {

	/**
	 * Creates an empty value
	 * @return an empty option
	 */
	@SuppressWarnings("unchecked")
	public static <T> Option<T> none() {
		return (Option<T>) None.instance;
	}
	
	/**
	 * Creates a wrapped value
	 * @param value a non null value
	 * @return an option with a value
	 */
	@SuppressWarnings("unchecked")
	public static <T> Option<T> of(T value) {
		if (value == null){
			return none();
		}
		return (Option<T>) new Some(value);
	}
	
	private final static class None extends Option<Object> {
		static final None instance = new None();
		private None(){}
		@Override
		public boolean isEmpty() {
			return true;
		}
	}

	private final static class Some extends Option<Object> {
		public Some(Object value) {
			this.value = value;
		}

		@Override
		public boolean isEmpty() {
			return (value == null);
		}
	}

	/**
	 * Helper class for retrieving empty value. 
	 * If a wrapped value is null, and getOrElse is called, the orElse branch will return
	 * a value of this interface's implementation 
	 * @author Tibor Botos
	 * @param <TYPE>
	 */
	public static interface ValueEmpty<TYPE> {
		public TYPE get();
	}
	
	protected T value = null;
	
	protected Option(){
	}
	
	
	/**
	 * @return the stored value, no null checking
	 */
	public T get()
	{
		return value;
	}
	
	/**
	 * @param orElse what happens if the stored value is null
	 * @return the stored value or the orElse defined value
	 */
	public T getOrElse(ValueEmpty<T> orElse) {
		if (value == null) {
			return orElse.get();
		}
		return value;
	}

	public T getOrElse(T defaultValue) {
		if (value == null) {
			return defaultValue;
		}
		return value;
	}
	
	/**
	 * @return is the value not presented
	 */
	public abstract boolean isEmpty();
	
	/**
	 * @return is the value presented
	 */
	public boolean isDefined() {
		return !isEmpty();
	}
}