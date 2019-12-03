Lambda表达式

* java8引入得函数式编程风格（支持将函数做为参数进行传递）

* 可以理解为一种匿名函数得代替

* 通过行为参数化传递

表达式形式
###### 形式一 ：没有参数 (没有参数左边小括号不能省略)
()-> System.out.println("hello world")
###### 形式二 ：有参数 (有参数左边小括号可以省略)
name -> System.out.println("hello world from "+ name)

###### 形式三 ：没有参数 逻辑复杂需要将逻辑得部分使用大括号
()-> {
System.out.println("hello");
System.out.println("world");
}
###### 形式四 包含两个参数得方法（执行apply才触发lambda）

    @org.junit.Test
    public void testLambda() {
        BinaryOperator<Long> functionAdd = (x,y)-> {
            System.out.println("test");
            return x+y;
        };

        Long result = functionAdd.apply(1L,2L);
    }

######  形式五 参数显示申明
     @org.junit.Test
     public void testLambda2() {
         BinaryOperator<Long> functionAdd = (Long x,Long y)-> x+y;
         Long result = functionAdd.apply(1L,2L);
     }
  
#### 定义符合Lambda表达式规范得函数式接口

* 接口中只有一个抽象方法

* JAVA8 得函数式接口注解 @FunctionInterface （不是必须有，只是辅助编译器校验是否符合函数式接口的定义：是否只有一个抽象方法）

* 函数式接口的抽象方法签名：函数描述符 

#### 常用的函数接口和使用
java.util.function包下的函数接口


#### 方法引用
>定义：调用特定方法的Lambda表达式的一种快捷写法，可以让你重复使用现有的方法定义，并像Lambda表达式一样传递他们

##### 指向静态方法的方法引用
        /**
         * (args) -> ClassName.staticMethod(args)
         * ClassName::staticMethod;
         */
        Consumer<String>
                consumer = (String number)->Integer.parseInt(number);

        Consumer<String>
                consumer1 = Integer::parseInt;

##### 指向任意类型实例方法的方法引用
        /**
         * (ClassName args) ->args.instanceMethod();
         * ClassName::instanceMethod;
         */
        Consumer<String>
                consumer = (String str) -> str.length();

        Consumer<String>
                consumer1 = String::length;
##### 指向现有对象的实例方法的方法引用
        /**
         * (args) ->object.instanceMethod(args);
         * object::instanceMethod;
         */
        StringBuilder stringBuilder = new StringBuilder();
        Consumer<String>
                consumer = (String str) -> stringBuilder.append(str);

        Consumer<String>
                consumer1 = stringBuilder::append;