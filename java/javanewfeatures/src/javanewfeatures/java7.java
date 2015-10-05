/**
 * 
 */
package javanewfeatures;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.TimeUnit;


/**
 * @author Jizhen Zhao
 * based on Luke Hutteman's javaone_2012.pptx file
 *
 */
public class java7 {
	
	/*
	 * Consistency & Clarity: Improved numeric literals
	 */
	public static void improvedNumericLiterals() {
		
		// Binary integral literals: new 0b prefix
		int b = 0b100101101; // 301
		System.out.println(b);
		b = 0b1111; // 15
		System.out.println(b);
		
		// Underscores in numeric literals
		b = 5_000_000; //5000000
		System.out.println(b);
		// Not necessarily just for thousands-separators
		long social = 123_45_6789;
		System.out.println(social);
		long hexValue = 0xCAFE_BABE;
		System.out.println(hexValue);
		Long maxLong = 0x7fff_ffff_ffff_ffffL;
		System.out.println(maxLong);
		byte bt = 0b0001_1101;
		System.out.println(bt);
		// Multiple underscores allowed
		// Courtesy Josh Bloch
		int bond =
       0000_____________0000________0000000000000000__000000000000000000+
     00000000_________00000000______000000000000000__0000000000000000000+
    000____000_______000____000_____000_______0000__00______0+
   000______000_____000______000_____________0000___00______0+
  0000______0000___0000______0000___________0000_____0_____0+
  0000______0000___0000______0000__________0000___________0+
  0000______0000___0000______0000_________0000__0000000000+
  0000______0000___0000______0000________0000+
  000______000_____000______000________0000+
   000____000_______000____000_______00000+
    00000000_________00000000_______0000000+
     0000_____________0000________000000007; // 7
		System.out.println(bond);

	}
	
	/*
	 * Consistency & Clarity: Strings in switch
	 * Implementation:
	 *   Relies on String.hashCode
	 *   On average faster than if-else chain with > 3 cases
	 */
	public static void swithWithString(String nodeType) {
		switch (nodeType) {
		    case "INVENTORY":
		    	System.out.println(nodeType);
		        break;
		    case "DESK":
		    	System.out.println(nodeType);
		        break;
		    case "TRADER":
		    	System.out.println(nodeType);
		        break;
		    case "trader":
		    	System.out.println("Lowercase: " + nodeType);
		        break;
		    default:
		        throw new IllegalArgumentException(
		                "Unknown node type: " + nodeType);
		}
	}
	
	public static void testSwithWithString() {
		String [] types = {
			"INVENTORY",
			"DESK",
			"TRADER",
			"trader",   // case sensitive
			"BAD_TYPE", 
			null        // null cannot be a case label, NullPointerException
		};
		for (String type : types) {
			try {
				swithWithString(type);
			} catch (IllegalArgumentException e) {
				System.out.println(e.getStackTrace());
				System.out.println(e);
				e.printStackTrace();
			}
		}
	}
	
	/*
	 * Easier to use Generics: SafeVarargs (fixes varargs compiler warnings)
	 * With Java 7 you can annotate your vararg method with SafeVararg annotation and 
	 * your clients won’t get these nasty warnings any more.
	 */
	@SafeVarargs //Type Safety warning is suppressed
	public static <T> List<T> asList(T... array) {
		for (T element : array) {
		    System.out.println(element.getClass().getName() + ": " + element);
		}
		return null;
	}
	
	public static void testSafeVarargs() {
		List<String> strList = new ArrayList<String>();
		strList.add("One");
		strList.add("Two");
		strList.add("Three");
		asList(strList.toArray(new String [0]));
		List<Float> list = new ArrayList<Float>();
		list.add(new Float(1.1));
		list.add(new Float(2.2));
		list.add(new Float(3.3));
		list.add(4.4f);
		asList(list.toArray(new Float [0]));
	}
	
	/*
	 * Easier to use Generics: Diamond Operator
	 */
	public static void diamond() {
		
		// No more repetition of generic arguments
		Map<String, List<Double>> map  = new HashMap<String, List<Double>>();
		Map<String, List<Double>> map2 = new HashMap<>();
		map.put("list1", Arrays.asList(new Double[]{1.1,2.2,3.3}));
		map2.put("list1_1", Arrays.asList(new Double[]{0.1,0.2,0.3}));
		print(map);
		print(map2);
		Map<String, Map<String, Map<String, Map<String, float[]>>>> deskGroupPnlMap  = new HashMap<String, Map<String, Map<String, Map<String, float[]>>>>();
		Map<String, Map<String, Map<String, Map<String, float[]>>>> deskGroupPnlMap2 = new HashMap<>();
		Map<String, float[]> mp4 = new  HashMap<>();
		mp4.put("key_1_1_1_1", new float[]{0.1f,0.2f,0.3f,0.4f,0.5f});
		Map<String, Map<String, float[]>> mp3 = new  HashMap<>();
		mp3.put("key_1_1_1", mp4);
		Map<String, Map<String, Map<String, float[]>>> mp2 = new  HashMap<>();
		mp2.put("key_1_1", mp3);
		deskGroupPnlMap.put("key_1", mp2);
		deskGroupPnlMap2.put("key_2", mp2);
		print2(deskGroupPnlMap);
		print2(deskGroupPnlMap2);
		
		// Not just for initialization
		Map<String, Integer> map3 = new HashMap<>();
		map3.put("key1", 1);
		map3.put("key2", 2);
		map3.put("key3", 3);
		List<Map<String, Integer>> listOfMaps;
		listOfMaps = new ArrayList<>();
		listOfMaps.add(map3);
		print(listOfMaps);
		listOfMaps = compute();
		listOfMaps.add(map3);
		print(listOfMaps);

	}
	
	private static List<Map<String, Integer>> compute() {
	    return new ArrayList<>();
	}
	
	private static void print(List<Map<String, Integer>> list) {
		if (list == null) {
			return;
		}
		for (Map<String, Integer> map : list) {
			Iterator<Map.Entry<String, Integer>> it = map.entrySet().iterator();
			while (it.hasNext()) {
		        Map.Entry<String, Integer> pairs = (Map.Entry<String, Integer>)it.next();
		        System.out.println(pairs.getKey() + " = " + pairs.getValue());
			}
		}
	}
	
	private static void print(Map<String, List<Double>> map) {
		if (map == null) {
			return;
		}
		for (Map.Entry<String, List<Double>> entry : map.entrySet()) {
			System.out.println(entry.getKey() + ": " + Arrays.toString(entry.getValue().toArray(new Double[0])));
		}
	}
	
	private static void print2(Map<String, Map<String, Map<String, Map<String, float[]>>>> map) {
		if (map == null) {
			return;
		}
		for (Map.Entry<String, Map<String, Map<String, Map<String, float[]>>>> entry : map.entrySet()) {
			System.out.println(entry.getKey() + ":"); 
			Map<String, Map<String, Map<String, float[]>>> map2 = entry.getValue();
			for (Map.Entry<String, Map<String, Map<String, float[]>>> entry2 : map2.entrySet()) {
				System.out.println(entry2.getKey() + ":"); 
				Map<String, Map<String, float[]>> map3 = entry2.getValue();
				for (Map.Entry<String, Map<String, float[]>> entry3 : map3.entrySet()) {
					System.out.println(entry3.getKey() + ":"); 
					Map<String, float[]> map4 = entry3.getValue();
					for (Map.Entry<String, float[]> entry4 : map4.entrySet()) {
						System.out.println(entry4.getKey() + ": " + Arrays.toString(entry4.getValue()));
					}					
				}
			}
		}
	}

	
	/*
	 * More Concise Error handling: Multi-catch and precise rethrow
	 */
	// Ability to catch multiple exceptions in a single catch clause
	public static void multiCatch() {
		try {
			throwException(1);
		} catch(FileNotFoundException | EOFException e) {
			e.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}
		try {
			throwException(2);
		} catch(FileNotFoundException | EOFException e) {
			e.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}
		try {
			throwException(3);
		} catch(FileNotFoundException | EOFException e) {
			e.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void throwException(int option) throws FileNotFoundException, EOFException, Exception {
		switch (option) {
		case 1:
			throw new FileNotFoundException();
		case 2:
			throw new EOFException();
		default:
			throw new Exception();
		}
	}
	
	// Precise rethrow:
	//   Change can-throw analysis of a catch clause
	//   Rethrow based on exceptions that can be thrown by the try-block, instead of the caught exception type

	
	public static void exampleMethod(Future<Integer> future) throws InterruptedException,
			ExecutionException, TimeoutException {
		Object result = future.get(1, TimeUnit.SECONDS);
		System.out.println(result);
	}
	
	public static void exampleMethodJava6(Future<Integer> future) throws InterruptedException,
			ExecutionException, TimeoutException {
		try {
			Object result = future.get(1, TimeUnit.SECONDS);
			System.out.println(result);
		} catch (InterruptedException ex) {
			throw ex;
		} catch (ExecutionException ex) {
			throw ex;
		} catch (TimeoutException ex) {
			// cleanup();
			throw ex;
		}
	}

	public static void exampleMethodJava6SigleCatch(Future<Integer> future) throws Exception { // POOR
																		// style
		try {
			Object result = future.get(1, TimeUnit.SECONDS);
			System.out.println(result);
		} catch (Exception ex) {
			// cleanup();
			throw ex;
		}
	}

	public static void exampleMethodJava7Multicatch(Future<Integer> future)
			throws InterruptedException, ExecutionException, TimeoutException {
		try {
			Object result = future.get(1, TimeUnit.SECONDS);
			System.out.println(result);
		} catch (InterruptedException | ExecutionException | TimeoutException ex) {
			// cleanup();
			throw ex;
		}
	}

	public static void exampleMethodJava7PreciseRethrow(Future<Integer> future)
			throws InterruptedException, ExecutionException, TimeoutException {
		try {
			Object result = future.get(1, TimeUnit.SECONDS);
			System.out.println(result);
		} catch (Throwable th) {
			// cleanup();
			throw th;
		}
	}
	
	public static void testPreciseRethrow() {
		Future<Integer> future = new FutureTask<Integer>(new Callable<Integer>() {
			@Override
			public Integer call() {
				return 111;
			}
		});
		try {
			exampleMethod(future);
		} catch (InterruptedException | ExecutionException | TimeoutException ex) {
			ex.printStackTrace();;
		}
		try {
			exampleMethodJava6(future);
		} catch (InterruptedException | ExecutionException | TimeoutException ex) {
			ex.printStackTrace();;
		}
		try {
			exampleMethodJava6SigleCatch(future);
		} catch (Exception ex) {
			ex.printStackTrace();;
		}
		try {
			exampleMethodJava7Multicatch(future);
		} catch (InterruptedException | ExecutionException | TimeoutException ex) {
			ex.printStackTrace();;
		}
		try {
			exampleMethodJava7PreciseRethrow(future);
		} catch (InterruptedException | ExecutionException | TimeoutException ex) {
			ex.printStackTrace();;
		}
	}

	
	/*
	 * More Concise Error handling: Try-with-resources
	 * 
	 * A variation of the try-catch-finally statement
	 * Allows initialization of a resource variable
	 *   Must be of type AutoCloseable
	 *   close() method will be called from generated finally block
	 *   Exceptions thrown by close() will be added to a suppressed exception list
	 * Useful for avoiding leaks of external objects
	 *   Files, SQL statements, resultsets, …
	 *   Many JDK classes retrofitted to be AutoCloseable
	 */
	
	// you type this
	static String readFirstLineFromFile(String path) {
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			return br.readLine();
		} catch (IOException e) {
			// handleException(e);
			e.printStackTrace();
		} finally {
			// cleanup();
		}
		return null;
	}

	// Compiler generates this:
	static String readFirstLineFromFileOld(String path) {
		try {
			BufferedReader br = null;
			try {
				br = new BufferedReader(new FileReader(path));
				return br.readLine();
			} finally {
				if (br != null)
					br.close(); // actually a bit more complicated
			}
		} catch (IOException e) {
			// handleException(e);
			e.printStackTrace();
		} finally {
			// cleanup();
		}
		return null;
	}
	
	// test
	public static void testTryWithResources() {
		readFirstLineFromFile("badpath");
		readFirstLineFromFileOld("badpath");
	}


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//improvedNumericLiterals();
		//testSwithWithString();
		//testSafeVarargs();
		//diamond();
		//multiCatch();
		//testPreciseRethrow();
		testTryWithResources();
	}

}
