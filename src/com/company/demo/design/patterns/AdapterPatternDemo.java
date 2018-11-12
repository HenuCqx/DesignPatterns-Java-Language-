package com.company.demo.design.patterns;


import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

// JDK1.1之前提供的容器有Arrays,Vector,Stack,Hashtable,Properties,BitSet，
// 其中定义了一种访问群集内各元素的标准方式，称为Enumeration（列举器）接口。
// JDK1.2版本中引入了Iterator接口，新版本的集合对（HashSet,HashMap,WeakHeahMap,
// ArrayList,TreeSet,TreeMap,LinkedList）是通过Iterator接口访问集合元素。
// 这样，如果将老版本的程序运行在新的Java编译器上就会出错。因为	List接口中已经
// 没有elements(),而只有iterator()了。那么如何将老版本的程序运行在新的Java编译器
// 上呢?如果不加修改，是肯定不行的，但是修改要遵循“开－闭”原则。我们可以用Java
// 设计模式中的适配器模式解决这个问题。
public class AdapterPatternDemo {

    // NewEnumeration是一个适配器类，通过它实现了从Iterator接口到Enumeration
    // 接口的适配，这样我们就可以使用老版本的代码来使用新的集合对象了。
    public class NewEnumeration implements Enumeration {

        Iterator mIterator;

        public NewEnumeration(Iterator iterator){
            this.mIterator = iterator;
        }

        @Override
        public boolean hasMoreElements() {
            return mIterator.hasNext();
        }

        @Override
        public Object nextElement() {
            return mIterator.next();
        }
    }

    //在新版本的客户端上实现Enumeration的功能
    public class Client{
        public Client(){
            List<Integer> list = new ArrayList<>();
            list.add(1);list.add(3);list.add(4);list.add(9);
            list.add(7);list.add(6);list.add(46);list.add(33);
            //利用适配器模式，在新版本的JDK上使用Enumeration的功能
            System.out.println("利用适配器模式，在新版本的JDK上使用Enumeration的功能");
            for (NewEnumeration newEnumeration = new NewEnumeration(list.iterator());
                 newEnumeration.hasMoreElements();){
                System.out.println(newEnumeration.nextElement());
            }
        }
    }
}
