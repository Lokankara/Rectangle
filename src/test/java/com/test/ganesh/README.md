E. Have the class declare that it implements java.io.Externalizable, which defines two
methods: readExternal and writeExternal
B. Have the class declare that it implements java.io.Serializable. There are no methods in
the interface.
21. B, E. There are two ways to ensure that a class can be serialized: you can implement Serializable,
which is a tagging interface that defines no methods, or you can implement Externalizable, which
defines the readExternal and writeExternal methods.

22. Default deserialization is only bypassed if the readObject() method has private access.

B. If the class implements java.io.Externalizable, it must have a no-args constructor.
C. If the class implements java.io.Serializable and does not implement
java.io.Externalizable, its nearest superclass that doesn’t implement Serializable
must have a no-args constructor.

23. B, C. If a class implements Externalizable, it must have a no-args constructor. If a class
implements Serializable and does not implement java.io.Externalizable, its nearest
non-externalizable superclass must have a no-args constructor.

When an object is serialized, the class name, non-static data, and non-transient data are saved.
FileInputStream and FileReader are low-level streams and can be directly connected to a file.
FileInputStream reads the data in binary format, but it can read the text files.

a) A serializable interface declares two methods, readObject() and writeObject(). To support serialization in
your class, you need to implement the Serializable interface and define these two methods.
b) When serializing an object that has references to other objects, the serialization mechanism also includes the
referenced objects as part of the serialized bytes.
c) When an object is serialized, the class members that are declared as transient will not be serialized (and hence
their values are lost after deserialization).
d) The Externalizable interface is a marker interface; in other words, it’s an empty interface that does not declare
any methods.
e) If you attempt to serialize or persist an object that does not implement the Externalizable interface, you’ll get a
NotExternalizableException.

Option b) and c) are true regarding object serialization.
Option a) is wrong because the Serializable interface is a marker interface; in other words, the Serializable
interface is an empty interface and it does not declare any methods in it.
Option d) is wrong because the Externalizable interface declares two methods, writeExternal() and
readExternal().
Option e) is wrong because there is no such exception as NotExternalizableException.
Here are the noteworthy points to help you grasp Java I/O concepts:

• When you use buffered streams, you should call flush() once you are done with data
transmission. The internal buffer might be holding some data that will be cleared and sent
to the destination once you call flush(). However, the method close() on the stream will
automatically call flush().

• You might have observed that you can combine stream objects. You can create an object of
BufferedInputStream that takes a FileInputStream object. In this way, the output of one
stream is chained to the filtered stream. This is the important, useful, and beautiful way to
customize the stream in a desired way.

• The Serializable interface is a marker interface. That means the Serializable interface
does not declare any method inside it.

• If you want to customize the process of serialization, you can implement readObject() and
writeObject(). Note that both of these methods are private methods, which means you
are not overriding or overloading these methods. JVM checks the implementation of these
methods and calls them instead of the usual methods. It sounds weird but it is the way the
customization of serialization process is implemented in the JVM.

• As discussed in earlier sections, a serialized object can be communicated over the network
and deserialized on another machine. However, the class file of the object must be in the path
of the destination machine, otherwise only the state of the object will be restored—not the
whole object (i.e., you cannot invoke a method on the restored object).

• You can create your own protocol for serialization. For that, you just need to implement the
Externalizable interface instead of the Serializable interface.

• When you are not specifying serialVersionUID in a serialized class, JVM computes it for
you. However, each JVM implementation has different mechanism to compute it; hence, it is
not guaranteed that your serialized class will work on two different JVMs when you have not
specified the serialVersionUID explicitly. Therefore, it is strongly recommended that you
provide serialVersionUID in a class implementing the Serializable interface.
