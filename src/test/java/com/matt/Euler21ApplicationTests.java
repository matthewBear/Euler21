package com.matt;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.matt.utils.Euler21Utils;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Euler21Application.class)
public class Euler21ApplicationTests {

	@Before
    public void setup() throws Exception {
        Euler21Utils.flushCache();
    }
	
	@Test
    public void testSumOfDivisors() throws Exception {
		assertEquals(284,Euler21Utils.sumOfDivisors(220));
    }
	
	@Test
	public void testIsAmicibleNumber(){
		assertEquals(true,Euler21Utils.isAmicibleNumber(220));
		assertEquals(true,Euler21Utils.isAmicibleNumber(284));
	}
	
}
