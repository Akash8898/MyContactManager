
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.contacts.contact.Contact;
import com.contacts.utilities.Utils;

@RunWith(MockitoJUnitRunner.class)
public class TestUtilities {

	@Mock
	private Contact contact;


//	@InjectMocks
//	private Utilities util;

	@Test
	public void testWrite() throws IOException {

		when(contact.getEmail()).thenReturn("test.tester@email.com");
//		util.write(contact);
		Utils.write(contact);

	}

	@Test
	public void testFormatNumberFalse() {

		assertEquals("Invalid Phone Number", Utils.formatNumber(5552125478l, 1));
		assertEquals("Invalid Phone Number", Utils.formatNumber(824521256l, 91));
		assertEquals("Invalid Phone Number", Utils.formatNumber(55212547l, 63));
		assertEquals("Invalid Phone Number", Utils.formatNumber(875423141451l, 404));
		assertEquals("Invalid Phone Number", Utils.formatNumber(0l, 1));
	}

	@Test
	public void testFormatNumberTrue() {

		assertEquals("+91 87540 64243", Utils.formatNumber(8754064243l, 91));
		assertEquals("+1 202-555-8965", Utils.formatNumber(2025558965l, 1));
		assertEquals("+91 89399 04119", Utils.formatNumber(8939904119l, 91));
		assertEquals("+63 956 840 6494", Utils.formatNumber(9568406494l, 63));
		assertEquals("+1 864-633-9049", Utils.formatNumber(8646339049l, 1));
	}

	@Test
	public void testSort() throws IOException {

//		util.sort();
		Utils.sort();
	}

	@Test
	public void testSearchTrue() throws IOException {

		Utils.search("akash");

	}
	
	@Test
	public void testSearchFalse() throws IOException {

		Utils.search("9876543722214");

	}

	@Test
	public void testExport() throws IOException {

		Utils.export(25);
		
	}

}
