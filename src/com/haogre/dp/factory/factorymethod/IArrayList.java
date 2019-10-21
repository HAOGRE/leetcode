package com.haogre.dp.factory.factorymethod;

//方便演示而实现的简陋的数组list
public class IArrayList<T> implements List<T> {
    private static final int defaultLength = 10;//默认长度
    private int size;                //存放的元素个数,会默认初始化为0
    private Object[] defaultList;    //使用数组存放元素

    public IArrayList() {                //默认构造函数
        defaultList = new Object[defaultLength];
    }

    @Override
    public Iterator<T> iterator() {
        return new MyIterator();
    }

    //添加元素
    @Override
    public boolean add(T t) {
        if (size <= defaultLength) {
            defaultList[size++] = t;
            return true;
        }
        return false;
    }

    //遍历器
    private class MyIterator implements Iterator<T> {
        private int next;

        @Override
        public boolean hasNext() {
            return next < size;
        }

        @SuppressWarnings("unchecked")
        @Override
        public T next() {
            return (T) defaultList[next++];
        }
    }
}