// These notes were written in an ad-hoc nature during a lecture, and not
// intended as compileable code


// A is an abstract class and can therefore have all of the components of a
// class (members, functions), but also abstract functions that do not have
// declrataion
abstract class A {

    // a member, like a class
    private int x = 0;

    // a function that can modify members, like a class
    public void setX(int y) {
        this.x = y;
    }


    // an abstract function, that makes it so that this class cannot be
    // instantiated
    public abstract int f(int y);


    // members are allowed to use abstract functions because whenever the class
    // is instantiated an implementation of the function will exist
    public void squareF(int y) {
        int v = this.f(y);
        return v * v;
    }
}


// By making B abstract we can ignore implementing f, and also declare more members or functions
abstract class B extends A {
    private int x = 3;
}

// By finally implementing f we can create a non-abstract (i.e concrete) class.
// This class inherits all of hte members and functions from its parents (just like in normal inheritance)
class C extends B {
    public int f(int y) {
        return y;
    }
}

// ======================================================================
// ======================================================================
// ======================================================================

public class A {
// ======================================================================
// ======================================================================
// ======================================================================
// A minor digression on public/private/protected
    // public members can be directly accessed by anyone
    public int x;
    // private members can only be directly accessed within the A class
    private int y;
    // protected members can be modified by A or any class that inherits from it
    protected int z;

    // final members cannot be modified after construction
    private final int u = 4;

    // getter enables indirect access to z
    public int getZ() {
        return z;
    }

}

class B extends A {
    void f() {
        // this is allowed because z is protected
        this.z = this.x + this.z;
        // this is not allowed because y is private
        this.z = this.x + this.y;
    }
}
class C {
    void f(A a) {
        // not allowed because C does not inherit from A
        a.x + a.z;
        // allowed because the getter was public
        a.x + a.getZ();
    }
}
// ======================================================================
// ======================================================================
// ======================================================================
// Example using multiple interfaces and abstract classes

// AA is set up like A above, but declared as an abstract class so can't be
// constructed, even though it has no abstract methods
abstract class AA {
    public int x;
    private int y;
    protected int z;

    private final int u = 4;

    public int getZ() {
        return z;
    }
}

// interface with a single function
interface IFace {
    int getFour();
}
interface DFace {
}

// another abstract class that's empty, therefore can't be constructed
abstract class AAA {}

// abstract classes can inherit other abstract classes. IF AAA weren't empty
// then AA would have inherited the requirements that any class inheriting from
// AA must implement the abstract methods in AAA. It can also inherit from an
// interface like DFace to absorb any of its requirements as well.
class AA extends AAA implements DFace {}


// our class Impl implements all of the abstract classes required, and
// therefore can be made concrete. Note that we can only inherit from a single
// class (abstract or concrete), but inherit from multiple interfaces. We can
// also inherit from the same interface (like DFace) multiple times without any
// issues
class Impl extends AA implements IFace, IFace2, IFace3, DFace {
    int getFour() {
        // abstract functions simply declare that an implementation needs to exist to make a concrete class. But this has nothing to do with how efficiently that function is implemented.
        // For instance, here we hav a function that clearly should return the number 4, but we can implement it very awkwardly.
        int count = 0;
        for (int j = 0; j < 20; ++j) {
            if (j == 4) {
                return j;
            }
        }
    }

    public static void main(String[] args) {

        // If Impl implements three interfaces (IFace,IFace2,IFace3), implements an
        // abstract class called AA we can assign Impl objects to variables typed after those interface and abstract type
        // noote that of course we cannot define more than one variable with a single name in a single scope.
        IFace iface = new Impl();
        IFace2 iface = new Impl();
        IFace3 iface = new Impl();
        AA iface = new Impl();

        DFace df = new Impl();

        AAA iface = new Impl();

        IFace iface = new IFace();

        // For IFace or Impl we could call this function, but not for the others.
        int x = iface.getFour();
    }
}


// ======================================================================
// ======================================================================
// ======================================================================

// digression on public/private between classes and interfaces
class D {
    // by default classes set variables to be private, so this member is private
    int x;

    // this member is also private
    int f(int y) {...}
    public int g() {...}
    public int h() {...}
}

interface IFace {
    // in an interface methods are by default public and abstract
    int f(int y);
    int g();
    int h();
}

// interfaces actually act quite a bit like an interface. AClass and AClass2
// are actually the "same"class in the sense that all they do is generate the
// requirements for f,g,h being implemented for anything that implements AClass
// or AClass2. 
//
// In that sense IFace,AClass, AClass2 all do the same thing, but you can only
// inherit from one class (abstract or otherwise) but can inherit from multiple
// interfaces so it's better to use interfaces when just specifying the
// interface
abstract class AClass implements IFace {

    // by implementing IFace these 3 functions are implicitly declared
    // public abstract int f(int y);
    // public abstract void g();
    // public abstract int h();
}
abstract class AClass2 {
    public abstract int f(int y);
    public abstract void g();
    public abstract int h();
}

// impl could implement either AClass or AClass2, but not both beause you can
// only inherit from one class
class Impl extends AClass //, AClass2
{
    public int f(int y) {
        return y;
    }

    public void g() {}
    public int g() {
        return 3;
    }

}

class Impl2 extends Impl {
    public int f(int y) {
        return 2 * y;
    }
}

// ======================================================================
// ======================================================================
// ======================================================================
// Example of why we'd want to use interfaces at all
public class Test

{
    public static void main(String[] args) {
        // one advantage is that we can write code without caring about what
        // the underlying data is - just by caring that it satisfies this
        // particular interface  (like having this f function)
        IFace iface = new Impl();
        Impl2 iface = new Impl();
        AClass iface = new Impl();
        System.out.println(iface.f(3));

        IFace iface2 = new Impl2();
        Impl iface2 = new Impl2();
        AClass iface2 = new Impl2();
        System.out.println(iface2.f(3));


        // Rather than write how to print the result of f(3) twice, we can
        // write a function that only takes things that implement the interface
        // IFace, and pass an Impl or Impl2 object in
        Impl iface = new Impl();
        Impl2 iface2 = new Impl2();
        callF(iface);
        callF(iface2);
    }

    public static void callF(IFace a) {
        System.out.println(a.f(3));
    }
}
// ======================================================================
// ======================================================================
// ======================================================================



// A Cipher should be able to convert some plain text to encrypted text, and decrypt it
public interface Cipher {
    public abstract String encode(String);
    public abstract String decode(String);
}


// We are implementing a cipher that works on one character at a time - one
// could imagine working on ciphers that work on more than just a single
// character at a time, or processes the characters out of order
//
public abstract class CharacterCipher implements Cipher {

    // implement code that processes each character one at a time (both encode and decode)
    public String encode(String input) {
        char[] d = new char[input.length()];

        for (int j = 0; j < d.length; ++j) {
            d[j] = encode(input.charAt(j));
        }
    }
    public String decode(String input) {
        char[] d = new char[input.length()];

        // I made a weird change after lecture to make this process things
        // backwards for the RollingCipher type example
        for (int j = 0; j < d.length; ++j) {
            d[d.length - j - 1] = decode(input.charAt(d.length - j - 1));
        }
    }

    // the encode/decode functions depend on a character encoding function
    public abstract char encode(char);
    public abstract char decode(char);
}


// A caesar cicpher "rotates" characters by N values. For this example we are
// saying 0 = A, Z = 25 rather than ASCII and only allowing capital characters
// for simplicity.
public class CaesarCipher extends CharacterCipher {
    private char N;
    public CaesarCicpher(int n) {
        this.N = n;
    }

    // implements the per-char encode/decode
    public char encode(char c) {
        return (c + N) % 26;
    }
    public char decode(char c) {
        return (c - N) % 26;
    }
}

// Even though the example was built around using caesar ciphers, we could
// someday want to use a better cipher (Caesar ciphers are really bad)
public class RollingCipher extends CharacterCipher {
    private char N;
    public RollingCicpher(int n) {
        this.N = n;
    }

    // some way to update the cipher
    int f(int a, int b) {...}
    public char encode(char c) {
        char j = (c + N) % 26;

        // update the cipher so it changes between characters
        this.N = f(j,N);

        return j;
    }
    public char decode(char c) {
        ...
    }
}

class CipherTest {
    public static void main(String[] args) {
        // example at how to break a caeasr cipher - if the text contains a
        // word like mississipi then people can guess the N easily
        Cipher c = new CaesarCicpher(3);

        System.out.println(c.encode(" mississipi "));
    }

    // If we want to test a cipher without using inheritance / interfaces then we have to pass in a caeasrcipher into our test functions
    boolean testCipher(CeasarCipher c) {
        String[] testText = {"hi", "byE" ....};

        for (String t : testText) {
            if (!testCipher(c, t)) {
                return false;
            }
        }
        return true;
    }
    // we are checking that the cipher can decode any text it encodes, and
    // encode any text it decodes (i.e checks that encode/decode are inverses)
    boolean testCipher(CeasrCipher c, String t) {
        return c.decode(c.encode(t)).equals(t) && c.encode(c.decode(t)).equals(t);
    }

    // without inheritance we would have to copy the above functions to make a rollingcipher
    boolean testCipher(RollingCipher c) {
        // if we add some new test data, like fancytext, then we have to copy paste it to all of the other examples (which would be bade because it maens our testing doesn't test on every challenging example we've come up with). We want to just have one copy of this testTExt, rather than one copy here and one for the CaesarCipher test
        String[] testText = {"hi", "byE", "fancyText" ....};

        for (String t : testText) {
            if (!testCipher(c, t)) {
                return false;
            }
        }
        return true;
    }
    // this is the exact same as the CaesarCipher one, isn't that wasteful to copy paste this?
    boolean testCipher(RollingCipher c, String t) {
        return c.decode(c.encode(t)).equals(t) && c.encode(c.decode(t)).equals(t);
    }


    // with inheritance we can just test the Cipher class, and pass a CaesarCipher or RollingCipher into this function to get access to all of the test examplse at once
    boolean testCipher(Cipher c) {
        String[] testText = {"hi", "byE" ....};

        for (String t : testText) {
            if (!testCipher(c, t)) {
                return false;
            }
        }
        return true;
    }
    // everything that inherits the cipher class gets to use this function
    boolean testCipher(Cipher c, String t) {
        return c.decode(c.encode(t)).equals(t) && c.encode(c.decode(t)).equals(t);
    }
}

