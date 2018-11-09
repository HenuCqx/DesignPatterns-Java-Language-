package com.company.creational.pattern;


/*单例模式*/
public class SingletonPattern {

    public SingletonPattern(){}

    /*//①懒汉式，线程不安全
    既然懒，那么在创建对象实例的时候就不着 急。会一直等到马上要使用对象实例的时候
    才会创建，懒人嘛，总是推脱不开的时 候才会真正去执行工作，因此在装载对象的时候
    不创建对象实例。
    存在致命的问题。当有多个线 程并行调用getInstance()的时候，就会创建多个
    实例。也就是说在多线程下不能正 常工作。
    private static SingletonPattern instance;
    public static SingletonPattern getInstance(){
        if(instance == null){
            instance = new SingletonPattern();
        }
        return instance;
    }*/

    /*//①懒汉式，线程安全 ,利用Synchronized避免多线程情况下创建多个实例
    为了解决上面的问题，最简单的方法是将整个getInstance()方法设为同步（synchronized）
    虽然做到了线程安全，并且解决了多实例的问题，但是它并不高效。因为在任何时候
    只能有一个线程调用getInstance()方法。但是同步操作只需要在第一次调用时才被需要，
    即第一次创建单例实例对象时。
    private static SingletonPattern instance;
    public static synchronized SingletonPattern getInstance(){
        if(instance == null){
            instance = new SingletonPattern();
        }
        return instance;
    }*/

    /*//③双重检验锁
    双重检验锁模式（double checked locking pattern），是一种使用同步块加锁的方法。
    程序员称其为双重检查锁，因为会有两次检查 instance == null，一次是在同步块外，
    一次是在同步块内。为什么在同步块内还要再检验一次？因为可能会有多个线程一起进
    入同步块外的if，如果在同步块内不进行二次检验的话就会生成多个实例了。
    这段代码看起来很完美，很可惜，它是有问题。主要在于instance = new Singleton()
    这句，这并非是一个原子操作，事实上在JVM	中这句话大概做了下面3件事情:
    1.给 instance 分配内存
    2.调用 Singleton 的构造函数来初始化成员变量
    3.将instance对象指向分配的内存空间（执行完这步 instance	就为非 null	了）。
    但是在 JVM 的即时编译器中存在指令重排序的优化。也就是说上面的第二步和第三步
    的顺序是不能保证的，最终的执行顺序可能是1-2-3，也可能是1-3-2。如果是后者，
    则在 3 执行完毕、2 未执行之前，被线程二抢占了，这时	instance 已经是非 null 了
    （但却没有初始化），所以线程二会直接返回instance，然后使用，然后顺理成章地报错。
    我们只需要将 instance 变量声明成 volatile就可以了。
    使用volatile的主要原因是其另一个特性：禁止指令重排序优化。也就是说，在volatile
    变量的赋值操作后面会有一个内存屏障（生成的汇编代码上），读操作不会被重排序到
    内存屏障之前。比如上面的例子，取操作必须在执行完1-2-3之后或者1-3-2之后，不存在
    执行到1-3然后取到值的情况。
    从「先行发生原则」的角度理解的话，就是对于一个volatile变量的写操作都先行发生于
    后面对这个变量的读操作（这里的“后面”是时间上的先后顺序）。但是特别注意在Java5
    以前的版本使用了volatile的双检锁还是有问题的。其原因是Java5以前的JMM
    （Java内存模型）是存在缺陷的，即时将变量声明成 volatile	也不能完全避免重排序，
    主要是volatile变量前后的代码仍然存在重排序问题。这个volatile屏蔽重排序的问题
    在Java5中才得以修复，所以在这之后才可以放心使用volatile。相信你不会喜欢这种
    复杂又隐含问题的方式，当然我们有更好的实现线程安全的单例模式的办法。

    //注意：必须加volatile的关键字
    private volatile static SingletonPattern instance;
    public static SingletonPattern getInstance(){
        if(instance == null){
            synchronized (SingletonPattern.class){
                if(instance == null){
                    instance = new SingletonPattern();
                }
            }
        }
        return instance;
    }*/

    /*//饿汉式	static final field
    饿汉式其实是一种比较形象的称谓。既然饿，那么在创建对象实例的时候就比较着急，
    饿了嘛，于是在装载类的时候就创建对象实例。这种方法非常简单，因为单例的实例
    被声明成static和final变量了，在第一次加载类到内存中时就会初始化，所以创建
    实例本身是线程安全的。
    缺点是它不是一种懒加载模式（lazy initialization），单例会在加载类后一开始
    就被初始化，即使客户端没有调用getInstance()方法。
    饿汉式的创建方式在一些场景中将无法使用：譬如Singleton实例的创建是依赖参数
    或者配置文件的，在getInstance()之前必须调用某个方法设置参数给它，那样这种
    单例写法就无法使用了。
    private final static SingletonPattern instance = new SingletonPattern();
    public static SingletonPattern getInstance(){
        return instance;
    }*/


    /*//⑤静态内部类	static nested class
    这种写法仍然使用JVM本身机制保证了线程安全问题。由于静态单例对象没有作为
    Singleton的成员变量直接实例化，因此类加载时不会实例化Singleton，第一次
    调用getInstance()时将加载内部类SingletonHolder，在该内部类中定义了一个
    static类型的变量INSTANCE，此时会首先初始化这个成员变量，由Java虚拟机来
    保证其线程安全性，确保该成员变量只能初始化一次。由于getInstance()方法
    没有任何线程 锁定，因此其性能不会造成任何影响。由于SingletonHolder是
    私有的，除了getInstance()之外没有办法访问它，因此它是懒汉式的；同时
    读取实例的时候不会进行同步，没有性能缺陷；也不依赖JDK版本。

    private static class SingletonHolder{
        private final static SingletonPattern instance = new SingletonPattern();
    }
    public static SingletonPattern getInstance(){
        return SingletonHolder.instance;
    }*/

    //⑥枚举 Enum
    //Android官方不建议使用枚举，因为枚举的内存比普通变量大


    /*总结
    一般来说，单例模式有五种写法：懒汉、饿汉、双重检验锁、静态内部类、枚举。
    上述所说都是线程安全的实现，上文中第一种方式线程不安全，排除。
    一般情况下直接使用饿汉式就好了，如果明确要求要懒加载（lazy	initialization）
    倾向于使用静态内部类。如果涉及到反序列化创建对象时会试着使用枚举的方式来
    实现单例。
    */
}

