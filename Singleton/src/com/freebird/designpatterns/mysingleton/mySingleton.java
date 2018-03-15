package com.freebird.designpatterns.mysingleton;

public class mySingleton {

    //BELONGS TO:
    // https://www.javatpoint.com/singleton-design-pattern-in-java

    //This pattern defines a class that has only one instance and provides a global access point to this instance
    //So this class must ensure that only one single instance can be created, and single object can be used by all other
    //classes.

    //We can have a singleton with early instantiation, which is created at load time
    //Or we can have a singleton with lazy instantiation, which means instance can be created when it's required

    //Advantage of singletons is saving memory, because you don't need to create an object at each request.
    //The one singleton is used over and over again.

    //This pattern is mostly used in multi-threaded and database applications. It is used in logging, caching,
    //thread pools, config settings...

    //I don't want the constructor to be public, because I don't want anyone to create more instances of this.
    private mySingleton(){}

    //Sits in one memory location because it's static. This is where we create the singleton on load,
    //i.e., early instantiation.
    //private static mySingleton theSingleton = new mySingleton();

    //the following would be how we would handle lazy instantiation along with the commented code in the getSingleton()
    private static mySingleton theSingleton;


    //static factory method to get the created object. It's accessible globally
    public static mySingleton getSingleton(){
        //lazy instantiation with synchronized so that we ensure just 1 is created
        //if we would go for early instantiation, we would just use the return statement because the above commented out
        //instantiation already created the object upon load
        if(theSingleton==null){
            synchronized (mySingleton.class){
                if(theSingleton==null){
                    theSingleton=new mySingleton();
                }
            }
        }

       return theSingleton;
    };

    public void doSomething(){}

    /*
    If singleton class is Serializable, you can serialize the singleton instance. Once it is serialized,
    you can deserialize it but it will not return the singleton object.

    To resolve this issue, you need to override the readResolve() method that enforces the singleton.
    It is called just after the object is deserialized. It returns the singleton object.

    public class A implements Serializable {
        //your code of singleton
        protected Object readResolve() {
            return getA();
        }

    }
     */





}
