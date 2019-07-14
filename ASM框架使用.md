# 使用
https://asm.ow2.io/
> sping默认使用6版本使用例子为SimpleMetadataReader

什么是ASM 参考：（https://blog.csdn.net/u014534808/article/details/81071452）

ASM 是一个可以操作Java 字节码的框架。可以读取/修改class中的字节码。ASM可以直接产生二进制class文件，
也可以在类被加载Java虚拟机之前动态改变类行为，Java class被存储在严格格式定义的.class文件里，
这些文件拥有足够的元数据来解析勒种的所有元素：类名称， 方法，属性以及Java字节码（指令）。
ASM从类文件中读入信息后，能够改变类行为，分析类信息，甚至能够根据用户要求生成新类。 

与 BCEL 和 SERL 不同，ASM 提供了更为现代的编程模型。对于 ASM 来说，Java class 被描述为一棵树；
使用 “Visitor” 模式遍历整个二进制结构；事件驱动的处理方式使得用户只需要关注于对其编程有意义的部分，
而不必了解 Java 类文件格式的所有细节：ASM 框架提供了默认的 “response taker”处理这一切。
