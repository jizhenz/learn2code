/**
 * 
 */
package volume_I.chapter03;

/**
 * ***********************************
 * C++ Notes: the class
 * ***********************************
 * 
 * Java classes are similar to C++ classes, but there are a few differences that can trap you. For example:
 * 
 *  1. In Java all functions are methods of some class. (The standard terminology refers to them as methods, not member functions.) 
 *     Thus, in Java you must have a shell class for the main method. 
 *  2. You may also be familiar with the idea of static member functions in C++. These are member functions defined inside a class 
 *     that do not operate on objects. The main method in Java is always static. 
 *  3. Finally, as in C/C++, the void keyword indicates that this method does not return a value. Unlike C/C++, the main method does 
 *     not return an “exit code” to the operating system. If the main method exits normally, the Java program has the exit code 0, 
 *     indicating successful completion. To terminate the program with a different exit code, use the System.exit method.
 * 
 * ***********************************
 * Data Types
 * ***********************************
 * 
 * 1. Java is a strongly typed language. This means that every variable must have a declared type.
 * 
 * 2. There are eight primitive types in Java:
 *    4 integer types: int, short, long, byte
 *    2 floating point types: float, double
 *    1 character type: char
 *    1 boolean type: boolean
 *    
 * 3. Integer Types
 * 
 *    1). Bypes:
 *    int: 4 bytes
 *    short: 2 bytes
 *    byte: 1 byte
 *    long: 8 bytes
 *    
 *    2). Number of bytes is machine independent
 *    This is different from C/C++.
 *    
 *    3). Suffix/Prefix:
 *    Long: suffix L, e.g. 10000L
 *    Hexadecimal: prefix 0x, e.g. 0xCAFE
 *    Octal: prefix 0, e.g. 010 (==8)
 *    Binary: from Java 7, prefix 0b, e.g. 0b0011 (==3)
 *    
 *    4). Underscores: you can add underscores to make the numbers more readable, e.g.
 *    0b1111_0001_1000_1010 (==0b1111000110001010)
 *    111_11_1111 (==111111111)
 *    Java compiler will remove the underscores.
 *    
 *    Java 7 do not have unsigned types. Java 8 introduced it.
 *    
 * 4. Floating-Point Types
 * 
 *    1). The floating-point types denote numbers with fractional parts.
 *    2). The name double refers to the fact that these numbers have twice the precision of the float type.
 *        float:  4 bytes 6~7 significant decimal digits
 *        double: 8 bytes 15 significant decimal digits
 *    3). Suffix:
 *        float: F, e.g. 3.14F
 *        double: D, e.g. 3.14D
 *        Floating-point numbers without an F suffix (such as 3.14) are always considered to be of type double.
 *    4). Scientific notation: 1.24e10, 3.57E-3
 *    5). Hexadecimal notation: e.g. 0.125 = 2–3 can be written as 0x1.0p-3. Note: use p, not e for exponent, base is 2, not 10.
 *    6). Special values:
 *        
 *        Positive infinity
 *        Negative infinity        
 *        NaN (not a number)
 *        
 *        The constants Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, and Double.NaN (as well as corresponding Float constants) 
 *        represent these special values, but they are rarely used in practice. e.g. instead of 
 *        
 *            if (x == Double.NaN) // is never true
 *            
 *        we can use:
 *        
 *            if (Double.isNaN(x)) // check whether x is "not a number"
 *            
 *    7). ! CAUTION:
 *        Floating-point numbers are not suitable for financial calculations in which roundoff errors cannot be tolerated. 
 *        For example, the command 
 *            System.out.println(2.0 -1.1) 
 *        prints 0.8999999999999999, not 0.9 as you would expect.
 *        
 *        Such roundoff errors are caused by the fact that floating-point numbers are represented in the binary number system. 
 *        There is no precise binary representation of the fraction 1/10, just as there is no accurate representation of 
 *        the fraction 1/3 in the decimal system.
 *        
 *        If you need precise numerical computations without roundoff errors, use the BigDecimal class.
 *        
 *        In database tables, it is similar. Use DECIMAL instead of FLOAT or DOUBLE, for money etc.
 *        
 * 5. Underscore Usage:
 *    
 *    // Invalid: cannot put underscores adjacent to a decimal point
 *    float pi1 = 3_.1415F;
 *    
 *    // Invalid: cannot put underscores adjacent to a decimal point
 *    float pi2 = 3._1415F;
 *    
 *    // Invalid: cannot put underscores prior to an L suffix
 *    long socialSecurityNumber1 = 999_99_9999_L;
 *    
 *    // OK (decimal literal)
 *    int x1 = 5_2;
 *    
 *    // Invalid: cannot put underscores At the end of a literal
 *    int x2 = 52_;
 *    
 *    // OK (decimal literal)
 *    int x3 = 5_______2;
 *    
 *    // Invalid: cannot put underscores in the 0x radix prefix
 *    int x4 = 0_x52;
 *    
 *    // Invalid: cannot put underscores at the beginning of a number
 *    int x5 = 0x_52;
 *    
 *    // OK (hexadecimal literal)
 *    int x6 = 0x5_2;
 *    
 *    // Invalid: cannot put underscores at the end of a number
 *    int x7 = 0x52_;
 *    
 * 6. The char Type
 * 
 *    1). Before Unicode, there were many different standards: ASCII in the United States, ISO 8859-1 for Western European languages, 
 *        KOI-8 for Russian, GB18030 and BIG-5 for Chinese, and so on.
 *    2). This causes two problems: 
 *        (1). A particular code value corresponds to different letters in the different encoding schemes. 
 *        (2). Moreover, the encodings for languages with large character sets have variable length: Some common characters are encoded as 
 *             single bytes, others require two or more bytes.
 *    3). Unicode was designed to solve these problems:
 *        (1). When the unification effort started in the 1980s, a fixed 2-byte code was more than sufficient to encode all characters used 
 *             in all languages in the world, with room to spare for future expansion—or so everyone thought at the time. 
 *        (2). In 1991, Unicode 1.0 was released, using slightly less than half of the available 65,536 code values. 
 *        (3). Java was designed from the ground up to use 16-bit Unicode characters, which was a major advance over other programming languages 
 *             that used 8-bit characters.
 *        (4). Unfortunately, over time, the inevitable happened. Unicode grew beyond 65,536 characters, primarily due to the addition of a very 
 *             large set of ideographs used for Chinese, Japanese, and Korean. 
 *        (5). Now, the 16-bit char type is insufficient to describe all Unicode characters.
 *    4). We need a bit of terminology to explain how this problem is resolved in Java, beginning with Java SE 5.0:
 *        (1). A code point is a code value that is associated with a character in an encoding scheme. 
 *        (2). In the Unicode standard, code points are written in hexadecimal and prefixed with U+, such as U+0041 for the code point of the Latin letter A. 
 *        (3). Unicode has code points that are grouped into 17 code planes:
 *             a. The first code plane, called the basic multilingual plane, consists of the “classic” Unicode characters with code points U+0000 to U+FFFF. 
 *             b. Sixteen additional planes, with code points U+10000 to U+10FFFF, hold the supplementary characters.
 *        (4). The UTF-16 encoding represents all Unicode code points in a variable-length code: 
 *             a. The characters in the basic multilingual plane are represented as 16-bit values, called code units.
 *             b. The supplementary characters are encoded as consecutive pairs of code units. 
 *             c. Each of the values in such an encoding pair falls into a range of 2048 unused values of the basic multilingual plane, called the surrogates area 
 *                (U+D800 to U+DBFF for the first code unit, U+DC00 to U+DFFF for the second code unit). 
 *             d. This is rather clever, because you can immediately tell whether a code unit encodes a single character or it is the first or second part of a
 *                supplementary character. 
 *             e. For example, the mathematical symbol for the set of integers ZZ has code point U+1D56B and is encoded by the two code units U+D835 and U+DD6B. 
 *                (See http://en.wikipedia.org/wiki/UTF-16 for a description of the encoding algorithm.)
 *    5). In Java, the char type describes a code unit in the UTF-16 encoding. Our strong recommendation is not to use the char type in your programs unless 
 *        you are actually manipulating UTF-16 code units. You are almost always better off treating strings as abstract data types.
 * 
 * 7. The boolean Type
 * 
 *    1). The boolean type has two values, false and true. It is used for evaluating logical conditions. 
 *    2). You cannot convert between integers and boolean values.
 * 
 *    ***********************************
 *    C++ Notes: 
 *    ***********************************
 *    
 *        In C++, numbers and even pointers can be used in place of boolean values. The value 0 is equivalent to the bool value false, and a non-zero value is 
 *        equivalent to true. This is not the case in Java. Thus, Java programmers are shielded from accidents such as
 *        
 *            if (x = 0) // oops... meant x == 0
 *            
 *        In C++, this test compiles and runs, always evaluating to false. In Java, the test does not compile because the integer expression x = 0 cannot be 
 *        converted to a boolean value.
 * 
 * ***********************************
 * Variables
 * ***********************************
 * 
 * 1. Every variable has a type.
 * 2. A variable name must begin with a letter and must be a sequence of letters or digits.
 * 3. A letter is defined as:
 *        'A'–'Z', 
 *        'a'–'z', 
 *        '_', 
 *        '$', 
 *        or any Unicode character that denotes a letter in a language, e.g. 'ä' in German.
 *        
 *    1). Check what Unicode characters are “letters” in Java: use the isJavaIdentifierStart and isJavaIdentifierPart methods in the Character class
 *    2). Even though $ is a valid Java letter, you should not use it in your own code. It is intended for names that are generated by the Java compiler and other tools.
 * 
 * 4. You also cannot use a Java reserved word for a variable name.
 * 5. Initializing: After you declare a variable, you must explicitly initialize it by means of an assignment statement—you can never use the value of an uninitialized variable.
 * 
 *    ***********************************
 *    C++ Notes: 
 *    ***********************************
 *          C and C++ distinguish between the declaration and definition of a variable. For example,
 *              int i = 10;
 *          is a definition, whereas
 *              extern int i;
 *          is a declaration. 
 *          In Java, no declarations are separate from definitions.
 *          
 * 6. Constants
 *    Use the keyword final to denote a constant. e.g.
 *        
 *        final double CM_PER_INCH = 2.54;
 *        
 *    Class constant can be setup with  static final, e.g.
 *    
 *        public static final double CM_PER_INCH = 2.54;
 *        
 *    ***********************************
 *    C++ Notes: 
 *    ***********************************
 *    
 *        const is a reserved Java keyword, but it is not currently used for anything. You must use final for a constant.
 * 
 * ***********************************
 * Operators
 * ***********************************
 * 1. operators +, -, *, /, % are used in Java for addition, subtraction, multiplication, division and modulus.
 * 
 *    ***********************************
 *    Note: floating-point numbers arithmetic, portability and keyword strictfp
 *    ***********************************
 *    1). One of the stated goals of the Java programming language is portability. A computation should yield the same results no matter which virtual 
 *        machine executes it. For arithmetic computations with floating-point numbers, it is surprisingly difficult to achieve this portability.
 *    2). The double type uses 64 bits to store a numeric value, but some processors use 80-bit floating-point registers. These registers yield added
 *        precision in intermediate steps of a computation.
 *    3). For example, consider the following computation:
 *            double w = x * y / z;
 *        Many Intel processors compute x * y, leave the result in an 80-bit register, then divide by z, and finally truncate the result back to 64 bits.
 *        That can yield a more accurate result, and it can avoid exponent overflow.
 *    4). But the result may be different from a computation that uses 64 bits throughout.
 *    5). For that reason, the initial specification of the Java virtual machine mandated that all intermediate computations must be truncated. The numeric 
 *        community hated it:
 *        a. Not only can the truncated computations cause overflow, 
 *        b. they are actually slower than the more precise computations because the truncation operations take time.
 *    6). For that reason, the Java programming language was updated to recognize the conflicting demands for optimum performance and perfect reproducibility:
 *        a. By default, virtual machine designers are now permitted to use extended precision for intermediate computations. 
 *        b. However, methods tagged with the strictfp keyword must use strict floating-point operations that yield reproducible results.
 *    7). For example, you can tag main as
 *            public static strictfp void main(String[] args)
 *        Then all instructions inside the main method will use strict floating-point computations. 
 *        If you tag a class as strictfp, then all of its methods must use strict floating-point computations.
 *    8). The gory details are very much tied to the behavior of the Intel processors. In the default mode, intermediate results are allowed to use an 
 *        extended exponent, but not an extended mantissa. (The Intel chips support truncation of the mantissa without loss of performance.) Therefore, 
 *        the only difference between the default and strict modes is that strict computations may overflow when default computations don’t.
 *        
 * 2. Operator Precedence
 *  
 *     Operators	                               Associativity
 *     [] . () (method call)                       Left to right
 *     ++ -- +(unary) -(unary) ~ ! () (cast) new   Right to left
 *     * / %                                       Left to right
 *     + -                                         Left to right
 *     << >> >>>                                   Left to right
 *     < > <= >= instanceof                        Left to right
 *     == !=                                       Left to right
 *     &                                           Left to right
 *     ^                                           Left to right
 *     |                                           Left to right
 *     &&                                          Left to right
 *     ||                                          Left to right
 *     ? :                                         Right to left
 *     = += -= *= /= %= &= ^= |= <<= >>= >>>=      Right to left
 * 
 *    ***********************************
 *    Note: & | for boolean values
 *    *********************************** 
 *    1). When applied to boolean values, the & and | operators yield a boolean value. 
 *    2). These operators are similar to the && and || operators, except that the & and | operators are not evaluated in “short circuit” fashion. 
 *    3). That is, both arguments are evaluated before the result is computed.
 * 
 *    ***********************************
 *    Note: shift operators
 *    *********************************** 
 *    1). >>> operator fills the top bits with zero, unlike >> which extends the sign bit into the top bits. 
 *    2). There is no <<< operator.
 *    
 *    3). The right-hand side argument of the shift operators is reduced modulo 32 (unless the left-hand side is a long, 
 *        in which case the right-hand side is reduced modulo 64). For example, the value of 1 << 35 is the same as 1 << 3 or 8.
 * 
 *        ***********************************
 *        C++ Notes: 
 *        ***********************************
 *        1). In C/C++, there is no guarantee as to whether >> performs an arithmetic shift (extending the sign bit) or a logical shift (filling in with zeroes). 
 *            Implementors are free to choose whatever is more efficient. 
 *        2). That means the C/C++ >> operator is really only defined for non-negative numbers. 
 *        3). Java removes that ambiguity.
 *    
 *    ***********************************
 *    Note: StrictMath
 *    *********************************** 
 *    1). The methods in the Math class use the routines in the computer’s floating-point unit for fastest performance. 
 *    2). If completely predictable results are more important than fast performance, use the StrictMath class instead. It implements the algorithms from the 
 *        “Freely Distributable Math Library” fdlibm, guaranteeing identical results on all platforms. These algorithms, which are written in the C programming 
 *        language, are then to be understood as executed with all floating-point operations following the rules of Java floating-point arithmetic.
 *        See www.netlib.org/fdlibm for the source code of these algorithms.
 *    3). The Java math library is defined with respect to fdlibm version 5.3. Where fdlibm provides more than one definition for a function (such as acos), use 
 *        the "IEEE 754 core function" version (residing in a file whose name begins with the letter e). The methods which require fdlibm semantics are sin, cos, 
 *        tan, asin, acos, atan, exp, log, log10, cbrt, atan2, pow, sinh, cosh, tanh, hypot, expm1, and log1p.
 *    4). See: http://docs.oracle.com/javase/7/docs/api/java/lang/StrictMath.html
 *    
 *    ***********************************
 *    Note: cast
 *    *********************************** 
 *    1). Caution:
 *        If you try to cast a number of one type to another that is out of the range for the target type, the result will be a truncated number that has a different 
 *        value. For example, (byte) 300 is actually 44.
 *    2). You cannot cast between boolean values and any numeric type. This convention prevents common errors. In the rare case when you want to convert a boolean 
 *        value to a number, you can use a conditional expression such as b ? 1 : 0.
 *    
 *    ***********************************
 *    C++ Notes: , operator
 *    ***********************************
 *        Unlike C or C++, Java does not have a comma operator. However, you can use a comma-separated list of expressions in the first and third slot of a for statement.
 *        
 *        ***********************************
 *        , operator in C++:
 *        ***********************************
 *        
 *        Take care to notice that the comma operator may be overloaded in C++. The actual behaviour may thus be very different from the one expected.
 *        As an example, Boost.Spirit uses the comma operator quite cleverly to implement list initializers for symbol tables. Thus, it makes the following 
 *        syntax possible and meaningful:
 *        
 *            keywords = "and", "or", "not", "xor";
 *            
 *        Notice that due to operator precedence, the code is (intentionally!) identical to
 *            
 *            (((keywords = "and"), "or"), "not"), "xor";
 *            
 *        That is, the first operator called is keywords.operator =("and") which returns a proxy object on which the remaining operator,s are invoked:
 *            
 *            keywords.operator =("and").operator ,("or").operator ,("not").operator ,("xor");
 *            
 * 3. Enumerated Types
 *    1). To hold a restricted set of values.
 *    2). Example: enum Size { SMALL, MEDIUM, LARGE, EXTRA_LARGE };
 *    
 * ***********************************
 * Strings
 * ***********************************
 * 
 * 1. Conceptually, Java strings are sequences of Unicode characters. For example, the string "Java\u2122" consists of the five Unicode characters J, a, v, a, and ™.
 * 2. Java does not have a built-in string type. Instead, the standard Java library contains a predefined class called, naturally enough, String.
 * 3. Strings Are Immutable: the String class gives no methods that let you change a character in an existing string. 
 *    1). Just as the number 3 is always 3, the string "Hello" will always contain the code-unit sequence for the characters H, e, l, l, o. 
 *    2). You cannot change these values. 
 *    3). Yet you can, change the contents of the string variable and make it refer to a different string.
 * 4. String editing is inefficient, but immutable strings have one great advantage: The compiler can arrange that strings are shared:
 *    1). Think of the various strings as sitting in a common pool. String variables then point to locations in the pool. 
 *    2). If you copy a string variable, both the original and the copy share the same characters.
 * 5. Overall, the designers of Java decided that the efficiency of sharing outweighs the inefficiency of string editing by extracting substrings and concatenating:
 *    1). Look at your own programs; we suspect that most of the time, you don’t change strings—you just compare them.
 *    2). For assembling strings from individual characters or from shorter strings, we have StringBuilder (or StringBuffer - not recommended). 
 * 
 *    ***********************************
 *    C++ Notes: 
 *    ***********************************
 *        A Java string is NOT an array of characters, like in C:
 *            
 *            char greeting[] = "Hello";
 *            
 *        it is roughly analogous to a char* pointer: 
 *        
 *            char* greeting = "Hello";
 *            
 *        When you replace greeting with another string, the Java code does roughly the following:
 *        
 *            char* temp = malloc(6);
 *            strncpy(temp, greeting, 3);
 *            strncpy(temp + 3, "p!", 3);
 *            greeting = temp;
 *            
 *        Now greeting points to the string "Help!".
 *        
 *        But what if we make another assignment to greeting? 
 *        
 *            greeting = "Howdy";
 *            
 *        Don’t we have a memory leak? After all, the original string was allocated on the heap. Fortunately, Java does automatic garbage collection.
 *        This is similar to C++ class string: C++ string objects also perform automatic allocation and deallocation of memory. The memory management
 *        is performed explicitly by constructors, assignment operators, copy constructors and destructors.
 *        
 *        However, C++ strings are mutable—you can modify individual characters in a string.
 *        
 * 6. Testing Strings for Equality
 *    1). use the equals method, e.g.
 *    
 *        s.equals(t)
 *        "Hello".equals(greeting)
 *        "Hello".equalsIgnoreCase("hello")
 *        
 *    2).  Do NOT use the == operator to test whether two strings are equal! It only determines whether or not the strings are stored in the same location.
 *         a. Sure, if strings are in the same location, they must be equal. But it is entirely possible to store multiple copies of identical strings in 
 *            different places:
 *            
 *                String greeting = "Hello"; //initialize greeting to a string
 *                if (greeting == "Hello") . . . // probably true
 *                if (greeting.substring(0, 3) == "Hel") . . . // probably false
 *                
 *         b. If the virtual machine always arranges for equal strings to be shared, then you could use the == operator for testing equality. But only string 
 *            constants are shared, NOT strings that are the result of operations like + or substring. 
 *         c. Therefore, never use == to compare strings lest you end up with a program with the worst kind of bug—an intermittent one that seems to occur randomly.
 * 
 *    ***********************************
 *    C++ Notes: 
 *    ***********************************
 *        a. C++ string class DOES overload the == operator to test for equality of the string contents.
 *        b. Java could have redefined == for strings, just as a special arrangement for +. Oh well, every language has its share of inconsistencies.
 *        c. C never use == to compare strings but use strcmp instead.
 *        d. Java has method compareTo that is the exact analog to strcmp. You can use 
 *           
 *               if (greeting.compareTo("Hello") == 0) . . .
 *           
 *           but it seems clearer to use equals instead.
 * 
 * 7. Empty and Null Strings
 *    1). An empty string is a Java object which holds the string length (namely 0) and an empty contents. 
 *    2). However, a String variable can also hold a special value, null, that indicates that no object is currently associated with the variable.
 *    3). Sometime need to test if a string is null first:
 *            
 *            if (str != null && str.length() != 0)
 * 
 * 8. Code Points and Code Units
 *    1). Java strings are implemented as sequences of char values. 
 *    2). The char data type is a code unit for representing Unicode code points in the UTF-16 encoding: 
 *        a. The most commonly used Unicode characters can be represented with a single code unit. 
 *        b. The supplementary characters require a pair of code units.
 *    3). The length method yields the number of code units required for a given string in the UTF-16 encoding. For example:
 *            
 *            String greeting = "Hello";
 *            int n = greeting.length(); // is 5.
 *            
 *        To get the true length—that is, the number of code points—call 
 *        
 *            int cpCount = greeting.codePointCount(0, greeting.length());
 *            
 *        The call s.charAt(n) returns the code unit at position n, where n is between 0 and s.length() – 1. For example:
 *        
 *            char first = greeting.charAt(0); // first is 'H'
 *            char last = greeting.charAt(4); // last is 'o'
 *            
 *        To get at the ith code point, use the statements
 *        
 *            int index = greeting.offsetByCodePoints(0, i);
 *            int cp = greeting.codePointAt(index);
 *            
 *    4). Like C and C++, Java counts code units and code points in strings starting with 0.
 *    5). Why need code units? Consider the sentence
 *    
 *             𪈍 is code point with a pair of UTF-16 code units
 *             
 *        The character 𪈍 requires two code units in the UTF-16 encoding. Calling
 *        
 *            char ch = sentence.charAt(1)
 *            
 *        doesn’t return a space but the second code unit of 𪈍. To avoid this problem, you should not use the char type. It is too low-level.
 *        
 *        If your code traverses a string, and you want to look at each code point in turn, use these statements:
 *        
 *            int cp = sentence.codePointAt(i);
 *            if (Character.isSupplementaryCodePoint(cp)) i += 2;
 *            else i++;
 *            
 *        You can move backwards with the following statements:
 *        
 *            i--;
 *            if (Character.isSurrogate(sentence.charAt(i))) i--;
 *            int cp = sentence.codePointAt(i);
 * 
 * 9.  The String API: see testStringAPI() below in code
 * 10. Build Strings:
 *     Inefficient to use string concatenation
 *     StringBuilder: non thread safe, but efficient
 *     StringBuffer: thread safe
 *      
 * 
 * @author jizhen
 *
 */
public class CH03 {
	
	public static void testShiftOperators() {
		int i = 4; //0b00000100
		System.out.println("i     = " + i);
		System.out.println("i     = " + Integer.toBinaryString(i));
		System.out.println("i<<3  = " + Integer.toBinaryString(i<<3));
		System.out.println("i<<35 = " + Integer.toBinaryString(i<<35));
		System.out.println("i>>2  = " + Integer.toBinaryString(i>>2));
		System.out.println("i>>5  = " + Integer.toBinaryString(i>>5));
		System.out.println("i>>>5 = " + Integer.toBinaryString(i>>>5));
		i = -4; 
		System.out.println("i     = " + i);
		System.out.println("i     = " + Integer.toBinaryString(i));
		System.out.println("i<<3  = " + Integer.toBinaryString(i<<3));
		System.out.println("i<<35 = " + Integer.toBinaryString(i<<35));
		System.out.println("i>>2  = " + Integer.toBinaryString(i>>2));
		System.out.println("i>>5  = " + Integer.toBinaryString(i>>5));
		System.out.println("i>>>5 = " + Integer.toString((i>>>5),2));
	}
	
	public static void testString() {
		
		System.out.println("\"Hello\" == \"Hello\":                " + ("Hello" == "Hello"));
		System.out.println("\"Hello\".equals(\"Hello\"):           " + "Hello".equals("Hello"));
		System.out.println("\"Hello\".equals(\"hello\"):           " + "Hello".equals("hello"));
		System.out.println("\"Hello\".equalsIgnoreCase(\"hello\"): " + "Hello".equalsIgnoreCase("hello"));

		String strHello = "Hello";
		System.out.println("strHello = "                    + strHello);
		System.out.println("\"Hello\" == strHello:         " + ("Hello" == strHello));
		System.out.println("\"Hello\"'s identityHashCode:  " + System.identityHashCode("Hello"));
		System.out.println("strHello's identityHashCode: " + System.identityHashCode(strHello));

		//System.out.println(strHello[2]); // compiling error, string is not array

		System.out.println(strHello.substring(0,3) == "Hel");
		String strHelp = strHello.substring(0,3) + "p!";
		System.out.println(strHelp);
		System.out.println(System.identityHashCode(strHelp));
		System.out.println("Hello" == strHelp);
		System.out.println(strHello == strHelp);
		System.out.println("Help!" == strHelp);
		strHelp = "Help!";
		System.out.println("Help!" == strHelp); // true

		
		final String strConst1 = "aaa";
		final String strConst2 = "a" + "aa";
		System.out.println(strConst1 == strConst2); // true

		final String strConst3 = "b" + "bb";
		final String strConst4 = "bbb";
		System.out.println(strConst3 == strConst4); // true
		
		String strConst5 = "ccc";
		String strConst6 = "cc" + "c";
		System.out.println(strConst5 == strConst6); // true
		
		String strConst7 = "dd" + "d";
		String strConst8 = "ddd";
		System.out.println(strConst7 == strConst8); // true
		
		String strConst9 = "ddd".substring(0,2) + "dd";
		String strConst10 = "dddd";
		System.out.println(strConst9 == strConst10); // false
		
		
	}
	
	public static void testSupplementaryCodePoints() {
		System.out.println("𪈍".length());
		System.out.println("𪈍".charAt(1));
		System.out.println();
		
		String sentence = "𪈍 is code point with a pair of UTF-16 code units";
		
		System.out.println("Code unit  length: " + sentence.length());
		System.out.println("Code point length: " + sentence.codePointCount(0, sentence.length()));
		
		int index = sentence.offsetByCodePoints(0, 0);
		int cp = sentence.codePointAt(index);
		System.out.println(java.lang.Character.toChars(cp));         //𪈍
		
		// traverse forward
		for (int i=0; i<sentence.length(); ) {
			cp = sentence.codePointAt(i);
			System.out.println(java.lang.Character.toChars(cp));     //𪈍
			if (Character.isSupplementaryCodePoint(cp)) i += 2;
			else i++;
		}
		for (int i=0; i<sentence.length(); ) {
			cp = sentence.codePointAt(i);
			System.out.println(java.lang.Character.toLowerCase(cp)); //172557
			if (Character.isSupplementaryCodePoint(cp)) i += 2;
			else i++;
		}
		for (int i=0; i<sentence.length(); ) {
			cp = sentence.codePointAt(i);
			System.out.println(java.lang.Character.toUpperCase(cp)); //172557
			if (Character.isSupplementaryCodePoint(cp)) i += 2;
			else i++;
		}
		for (int i=0; i<sentence.length(); ) {
			cp = sentence.codePointAt(i);
			System.out.println(java.lang.Character.toTitleCase(cp)); //172557
			if (Character.isSupplementaryCodePoint(cp)) i += 2;
			else i++;
		}
		
		// traverse backward
		for (int i=sentence.length(); i>0; ) {
			i--;
			if (Character.isSurrogate(sentence.charAt(i))) i--;
			cp = sentence.codePointAt(i);
			System.out.println(java.lang.Character.toChars(cp));     //𪈍
		}
		
	}
	
	public static void testStringAPI() {
		String s = "𪈍 is code point with a pair of UTF-16 code units";
		System.out.println(s.charAt(3));                                   // char 'i'
		System.out.println(s.codePointAt(0));                              // int 172557
		System.out.println(java.lang.Character.toChars(s.codePointAt(0))); // 𪈍
		System.out.println(s.offsetByCodePoints(0,0));                     // int 0 parameters: int startIndex, int cpCount
		System.out.println(s.offsetByCodePoints(0,1));                     // int 2
		System.out.println(s.offsetByCodePoints(0,3));                     // int 4
		/*
		 * public int compareTo(String anotherString)
		 * 
		 * This is the definition of lexicographic ordering. If two strings are different, then either they have different characters at some index that is a valid index 
		 * for both strings, or their lengths are different, or both. If they have different characters at one or more index positions, let k be the smallest such index; 
		 * then the string whose character at position k has the smaller value, as determined by using the < operator, lexicographically precedes the other string. In 
		 * this case, compareTo returns the difference of the two character values at position k in the two string -- that is, the value:
		 * 
		 *     this.charAt(k)-anotherString.charAt(k)
		 *     
		 * If there is no index position at which they differ, then the shorter string lexicographically precedes the longer string. In this case, compareTo returns the 
		 * difference of the lengths of the strings -- that is, the value:
		 * 
		 *     this.length()-anotherString.length()
		 */
		System.out.println(s.compareTo("The apple is red."));                                               // 55316 > 0, s is after "The apple is red." in dictionary order.
		System.out.println(s.charAt(0) - "The apple is red.".charAt(0));                                    // 55316
		System.out.println(s.compareTo("𪈍 is code point with a pair of UTF-16 code units"));               // = 0, same
		System.out.println(s.compareTo("𪈍𪈍 are code points with pairs of UTF-16 code units"));            // -55368 < 0, after s in dictionary order.
		System.out.println(s.charAt(2) - "𪈍𪈍 are code points with pairs of UTF-16 code units".charAt(2)); // -55368
		System.out.println(s.compareTo("𪈍 is code point with a pair of UTF-16 code units..."));            // -3
		System.out.println(s.length() - "𪈍 is code point with a pair of UTF-16 code units...".length());   // -3
		System.out.println(s.compareTo("𪈍 is code point with"));                                           // 28
		System.out.println(s.length() - "𪈍 is code point with".length());                                  // 28
		/*
		 * boolean endsWith(String suffix)
		 * boolean equals(Object other)
		 * boolean equalsIgnoreCase(String other)
		 * 
		 * int indexOf(String str)
		 * int indexOf(String str, int fromIndex)
		 * int indexOf(int cp)
		 * int indexOf(int cp, int fromIndex)
		 *     -1 if not occur
		 *     
		 * int lastIndexOf(String str)
		 * int lastIndexOf(String str, int fromIndex)
		 * int lastindexOf(int cp)
		 * int lastindexOf(int cp, int fromIndex)
		 *     
		 * int length()
		 * 
		 * int codePointCount(int startIndex, int endIndex)
		 *     startIndex - inclusive, endindex - exclusive 
		 */
		System.out.println(s.codePointCount(0, 2));                // 1
		System.out.println(s.codePointCount(0, s.length()));       // 48
		try {                                                      //
			System.out.println(s.codePointCount(0, s.length()+1)); // IndexOutOfBoundsException
		} catch (java.lang.IndexOutOfBoundsException e) {
			e.printStackTrace();
		}
		/*
		 * String replace(CharSequence oldString, CharSequence newString)
		 * boolean startsWith(String prefix)
		 * String substring(int beginIndex)
		 * String substring(int beginIndex, int endIndex)
		 *     startIndex - inclusive, endindex - exclusive 
		 */
		try {                                                     
			System.out.println(s.substring(0, s.length()+1)); // IndexOutOfBoundsException
		} catch (java.lang.IndexOutOfBoundsException e) {
			e.printStackTrace();
		}
		/*
		 * String toLowerCase()
		 * String toUpperCase()
		 * String trim()
		 */
	}
	
	public static void testStringBuilder() { // StringBuffer is similar
		StringBuilder sb = new StringBuilder();
		System.out.println(sb.length());
		System.out.println(sb.toString() + ".EOL");
		sb.append('A');
		System.out.println(sb.length());
		System.out.println(sb.toString() + ".EOL");
		sb.append(" code point: ");
		System.out.println(sb.length());
		System.out.println(sb.toString() + ".EOL"); 
		sb.appendCodePoint(172557);
		System.out.println(sb.length());
		System.out.println(sb.toString() + ".EOL"); 
		sb.appendCodePoint(172557);
		System.out.println(sb.length());
		System.out.println(sb.toString() + ".EOL"); 
		sb.delete(16, 16+2);
		System.out.println(sb.length());
		System.out.println(sb.toString() + ".EOL"); 
		sb.delete(14, 14+20);      // note no exception thrown, just delete to end
		System.out.println(sb.length());
		System.out.println(sb.toString() + ".EOL"); 
		sb.insert(14, "𪈍");
		System.out.println(sb.length());
		System.out.println(sb.toString() + ".EOL"); 
		sb.insert(16, 'e');
		System.out.println(sb.length());
		System.out.println(sb.toString() + ".EOL");
		sb.setCharAt(16, '.');
		System.out.println(sb.length());
		System.out.println(sb.toString() + ".EOL"); 
		try {
			sb.setCharAt(17, '.'); // note StringIndexOutOfBoundsException thrown
		} catch (java.lang.StringIndexOutOfBoundsException e) {
			e.printStackTrace();
		}
	}

	/**
	 * ***********************************
	 * About main method:
	 * ***********************************
	 * 
	 * 1. According to the Java Language Specification, the main method must be declared public (http://docs.oracle.com/javase/specs).
	 * 2. However, several versions of the Java launcher were willing to execute Java programs even when the main method was not public.
	 *    A Sun engineer added an explanation that the Java Virtual Machine Specification (at http://docs.oracle.com/javase/specs/jvms/se7/html) 
	 *    does not mandate that main is public.
	 * 3. The Java launcher in Java SE 1.4 and beyond enforces that the main method is public.
	 * 4. Sun made the bug reports and their resolutions available for anyone to scrutinize. You can even vote for your
	 *    favorite bug. Bugs with lots of votes have a higher chance of being fixed in the next JDK release.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
//		System.out.println("We will not use 'Hello, World!'");
//		testShiftOperators();
//		testString();
//		testSupplementaryCodePoints();
//		testStringAPI();
		testStringBuilder();
	}

}