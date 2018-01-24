package perf;

import org.junit.Test;

import com.dp.common.utils.PasswordUtil;

public class PasswordTest {
	@Test
	public void test1(){
		Object encrypt = PasswordUtil.encrypt("!q2w3e4r", "gljinjia");
		System.out.println(encrypt.toString());
	}
}
