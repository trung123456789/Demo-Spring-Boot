package bqtrung.demospring.obj;

import bqtrung.demospring.impl.FuntionalInterfaceTest;
import bqtrung.demospring.impl.FuntionalInterfaceTest1;
import bqtrung.demospring.impl.FuntionalInterfaceTest12;

public class LambdaExpressionTest {
	public static void main(String[] args) {
		// Type 0:
		FuntionalInterfaceTest1 s0 = () -> {
			return "Hello world";
		};
		System.out.println(s0.sayHello());
		
		// Type 1.0:
        FuntionalInterfaceTest s1 = (str) -> {
            return str;
        };
        System.out.println(s1.sayHello("Hello world!"));
        
        // Type 1.1:
        FuntionalInterfaceTest s2 = name -> "Hello " + name;
        System.out.println(s2.sayHello("world!"));
        
        // Type 2:
        // Note: 1. Tham sô cách nhau bằng dấu phẩy
        //		 2. Nếu có 2 tham số trở lên thì phải đặt trong ngoặc tròn, còn 1 thì không cần cũng được
        //       3. Không bắt buộc khai báo kiểu dữ liệu của biến
        // 		 4. Trường hợp code chỉ có một dòng thì k yêu cầu cặp ngoặc nhọn
        // 		 5. Biểu thức lambda không nên chứa nhiều dòng code(2-5 line)
        FuntionalInterfaceTest12 s3 = (hellomsg, name) -> {
        	return hellomsg + "--" + name;
        };
        System.out.println(s3.sayHello("Hello", "world!!"));
        
        
    }
}
