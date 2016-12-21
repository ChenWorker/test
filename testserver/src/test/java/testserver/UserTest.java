package testserver;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.guotv.chen.testserver.entity.User;
import com.guotv.chen.testserver.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)//注解让测试运行于Spring测试环境
@ContextConfiguration(locations="classpath:/spring/applicationContext.xml")//注解加载的是Spring的配置文件
public class UserTest {
	@Autowired
	private UserService userService;
	@Test
	public void test(){
		User user1=new User();
		user1.setName("nana");
		user1.setPwd("nana");
		userService.addUser(user1);
		User user2=new User();
		user2.setName("nana");
		user2.setPwd("nana");
		userService.addUser(user2);
		User user3=new User();
		user3.setName("nana");
		user3.setPwd("nana");
		userService.addUser(user3);
		User user4=new User();
		user4.setName("nana");
		user4.setPwd("nana");
		userService.addUser(user4);
		User user5=new User();
		user5.setName("nana");
		user5.setPwd("nana");
		userService.addUser(user5);
		User user6=new User();
		user6.setName("nana");
		user6.setPwd("nana");
		userService.addUser(user6);
		User user7=new User();
		user7.setName("nana");
		user7.setPwd("nana");
		userService.addUser(user7);
		User user8=new User();
		user8.setName("nana");
		user8.setPwd("nana");
		userService.addUser(user8);
		User user9=new User();
		user9.setName("nana");
		user9.setPwd("nana");
		userService.addUser(user9);
		User user10=new User();
		user10.setName("nana");
		user10.setPwd("nana");
		userService.addUser(user10);
		List<User> list=userService.getUsers();
		for(User u:list){
			System.out.print(u.getName());
		}
	}
}
