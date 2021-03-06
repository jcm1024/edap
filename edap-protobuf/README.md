## edap-protobuf

edap-protobuf 为protocol buffer协议的实现框架，可以直接序列化反序列化Javabean。

1. 添加以下依赖：

    ```xml
    <dependency>
        <groupId>io.edap</groupId>
        <artifactId>edap-protobuf</artifactId>
        <version>0.1-SNAPSHOT</version>
    </dependency>
    ```

2. 使用方法：

    ```java
    
    public class User {
       private Long uid;
       private String username;
       public Long getUid() {
        return uid;
       }
       
       public void setUid(Long uid) {
           this.uid = uid;
       }
       
       public String getUsername() {
           return username;
       }
    
       public void setUsername(String username) {
           this.username = username; 
       }
    }
 
    User user = new User();
    user.setUid(10000L);
    user.setUsername("louis");
 
    //将Javabean序列化为protobuf的二进制数据
    byte[] bs = ProtoBuf.toByteArray(user);
    
    //将protobuf协议的数据反序列化为java对象
    User userInfo = ProtoBuf.toObject(byte[] bs, User.class);
    ```
    
    该代码等同于:

    ```java
    
    public class User {
       @ProtoField(tag = 1, type = Field.Type.INT64)
       private Long uid;
       @ProtoField(tag = 2, type = Field.Type.STRING)
       private String username;
       public Long getUid() {
        return uid;
       }
       
       public void setUid(Long uid) {
           this.uid = uid;
       }
       
       public String getUsername() {
           return username;
       }
    
       public void setUsername(String username) {
           this.username = username; 
       }
    }
    ```

    对应的proto文件描述为：
    
    ```proto
    syntax = "proto3";
    
    
    package test.message;
    
    option java_package = "io.edap.protobuf.test.message.v3";
    //option java_outer_classname = "MessageOuter";
    
    message User {
        int64 uid = 1;
        string username = 2;
    }
    ```
    
3. 如果Field没有添加ProtoField的注解，框架将使用Javabean的class中Field的声明顺序作为protobuf的tag，从1开始进行编码。
4. 该框架对protobuf协议做了扩展，可以作为序列化反序列化框架来使用，编码方式类似hession。

```java
// 序列化对象为
byte[] bs = ProtoBuf.ser(Object obj);
// 反序列化为java对象，由于编码时将类型信息写入序列化的数据中，所以可以直接反序列化为相应类型的对象，只需强转为相应类型即可
Object obj = ProtoBuf.der(byte[] bs);
```