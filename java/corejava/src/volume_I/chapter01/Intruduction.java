/**
 * 
 */
package volume_I.chapter01;

/**
 * @author Jizhen Zhao
 * 
 * 1.1. Java As a Programming Platform
 *   Java was never just a language. Java is a whole platform, with a huge library, containing lots of reusable code, and an execution environment that provides
 *   services such as security, portability across operating systems, and automatic garbage collection.
 *   
 * 1.2. The Java “White Paper” Buzzwords
 *   
 *   1. Simple
 *      
 *      The syntax for Java is, indeed, a cleaned-up version of the syntax for C++. There is no need for
 *      header files, pointer arithmetic (or even a pointer syntax), structures, unions, operator overloading,
 *      virtual base classes, and so on.
 *      
 *      Another aspect of being simple is being small. The size of the basic interpreter and class support is 
 *      about 40K; the basic standard libraries and thread support (essentially a self-contained microkernel) add another 175K.
 *      
 *      There is now a separate Java Micro Edition with a smaller library, suitable for embedded devices.
 *      
 *   2. Object-Oriented
 *      
 *      Simply stated, object-oriented design is a technique for programming that focuses on the data
 *      (= objects) and on the interfaces to that object. To make an analogy with carpentry, an
 *      “object-oriented” carpenter would be mostly concerned with the chair he was building, and
 *      secondarily with the tools used to make it; a “non-object-oriented” carpenter would think
 *      primarily of his tools. The object-oriented facilities of Java are essentially those of C++.
 *      
 *      The major difference between Java and C++ lies in multiple inheritance, which Java
 *      has replaced with the simpler concept of interfaces, and in the Java metaclass model
 *      
 *   3. Network-Savvy
 *      
 *      Java has an extensive library of routines for coping with TCP/IP protocols like HTTP and
 *      FTP. Java applications can open and access objects across the Net via URLs with the same
 *      ease as when accessing a local file system.
 *      
 *      This will be covered in Volume II.
 *      
 *   4. Robust
 *      
 *      Java is intended for writing programs that must be reliable in a variety of ways. Java puts a
 *      lot of emphasis on early checking for possible problems, later dynamic (runtime) checking,
 *      and eliminating situations that are error-prone. . . . The single biggest difference between
 *      Java and C/C++ is that Java has a pointer model that eliminates the possibility of
 *      overwriting memory and corrupting data.
 *      
 *      The Java compiler detects many problems that, in other languages,
 *      would show up only at runtime. As for the second point, anyone who has spent hours chasing memory
 *      corruption caused by a pointer bug will be very happy with this feature of Java.
 *            
 *   5. Secure
 *      
 *      Java is intended to be used in networked/distributed environments. Toward that end, a lot of
 *      emphasis has been placed on security. Java enables the construction of virus-free, tamper free
 *      systems.
 *      
 *      Java was designed to make certain kinds of attacks impossible, among them:
 *      • Overrunning the runtime stack—a common attack of worms and viruses
 *      • Corrupting memory outside its own process space
 *      • Reading or writing files without permission
 *      
 *      Java has the notion of digitally signed classes (see Volume II). With a signed class, you can be sure of who wrote
 *      it. If you trust the author of the class, the class can be allowed more privileges on your machine.
 *      
 *   6. Architecture-Neutral
 *   
 *     The compiler generates an architecture-neutral object file format—the compiled code is
 *     executable on many processors, given the presence of the Java runtime system. The Java
 *     compiler does this by generating bytecode instructions which have nothing to do with a
 *     particular computer architecture. Rather, they are designed to be both easy to interpret on
 *     any machine and easily translated into native machine code on the fly.
 *     
 *     Of course, interpreting bytecodes is necessarily slower than running machine instructions at full speed. 
 *     However, virtual machines have the option of translating the most frequently executed bytecode sequences 
 *     into machine code—a process called just-in-time compilation.
 *     
 *     Java’s virtual machine has other advantages. It increases security because it can check the behavior of instruction sequences.
 *   
 *   7. Portable
 *      
 *      Unlike C and C++, there are no “implementation-dependent” aspects of the specification.
 *      The sizes of the primitive data types are specified, as is the behavior of arithmetic on them.
 *      
 *      For example, an int in Java is always a 32-bit integer. In C/C++, int can mean a 16-bit integer, a
 *      32-bit integer, or any other size that the compiler vendor likes.
 *      
 *      The libraries that are a part of the system define portable interfaces. For example, there is an
 *      abstract Window class and implementations of it for UNIX, Windows, and the Macintosh.
 *      
 *   8. Interpreted
 *      
 *      The Java interpreter can execute Java byte codes directly on any machine to which the
 *      interpreter has been ported. Since linking is a more incremental and lightweight process, the
 *      development process can be much more rapid and exploratory.
 *      
 *      And today, the byte codes are translated into machine code by the just-in-time compiler.
 *      
 *   9. High-Performance
 *      
 *      While the performance of interpreted bytecodes is usually more than adequate, there are
 *      situations where higher performance is required. The bytecodes can be translated on the fly
 *      (at runtime) into machine code for the particular CPU the application is running on.
 *      
 *      Today, the just-in-time compilers have become so good that they are
 *      competitive with traditional compilers and, in some cases, even outperform them because they have
 *      more information available. For example, a just-in-time compiler can monitor which code is executed
 *      frequently and optimize just that code for speed. A more sophisticated optimization is the elimination
 *      (or “inlining”) of function calls. The just-in-time compiler knows which classes have been loaded. It
 *      can use inlining when, based upon the currently loaded collection of classes, a particular function is
 *      never overridden, and it can undo that optimization later if necessary.
 *      
 *   10. Multithreaded
 *   
 *       [The] benefits of multithreading are better interactive responsiveness and real-time behavior.
 *       
 *       Threads in Java can take advantage of multiprocessor systems if the base operating system does so.
 *   
 *   11. Dynamic
 *       
 *       In a number of ways, Java is a more dynamic language than C or C++. It was designed to
 *       adapt to an evolving environment. Libraries can freely add new methods and instance
 *       variables without any effect on their clients. In Java, finding out runtime type information is
 *       straightforward.
 *       
 *       This is an important feature in the situations where code needs to be added to a running program.
 *
 * 1.3. Java Applets and the Internet
 *      
 *      skip.
 *      
 * 1.4. A Short History of Java
 * 
 *      1991: Patrick Naughton and James Gosling wanted to design a small computer language 
 *            that could be used for consumer devices like cable TV switchboxes. The project was code-named “Green.”
 *            The requirements for small, tight, and platform-neutral code led to hypothetical machine (e.g JVM).
 *      1992: the Green project delivered its first product, called “*7.” But no one was interested in it.
 *      1993 - 1994: looking for people to buy its technology, No one was found.
 *      1995, May 23: HotJava browser was shown at SunWorld ’95.
 *      1996: Java 1.0, the language itself. 211 classes/interfaces.
 *      1997: Java 1.1, inner classes.
 *      1998: Java SE 1.2, ME 1.2, EE 1.2
 *      2000: Java 1.3, improving 1.2.
 *      2002: Java 1.4: assertions.
 *      2004: Java 1.5 (renamed to 5.0): generic types, enhanced for loop, autoboxing, varargs, enum, static import and metadata
 *      2006: Java 6 (w/o .0). Improving 5.0.
 *      2011: Java 7: switch with strings, diamond operator, binary literals, enhanced exception handling.
 *            4024 classes/interfaces.
 * 
 * 1.5. Common Misconceptions about Java
 *      
 *      skip.
 *      
 */
public class Intruduction {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Chapter 1: An Introduction to Java");
	}

}
