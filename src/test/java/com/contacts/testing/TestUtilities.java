package com.contacts.testing;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import com.contacts.View.Contact;
import com.contacts.interfaces.Utilities;
import com.contacts.utilities.FileUtilities;

@RunWith(MockitoJUnitRunner.Silent.class)
public class TestUtilities {

	@Mock
	private Contact contact;

	@Mock
	List<String> oplist;

	@Mock
	private File file = Mockito.mock(File.class);

	@InjectMocks
	private FileUtilities util;

	private Utilities utils;

	@Before
	public void setup() throws IOException {
		FileUtilities fileUtil = new FileUtilities();
		utils = spy(fileUtil);
	}

	@Test
	public void testInvalidMailWrite() throws IOException {

		when(contact.getEmail()).thenReturn("invalidmail");
//		util.write(contact);
		utils.fileWrite(contact);

	}

	@Test
	public void testValidMailWrite() throws IOException {

		when(contact.getEmail()).thenReturn("valid.email@somemail.com");
//		util.write(contact);
		utils.fileWrite(contact);

	}

	@Test
	public void testFormatNumberFalse() {

		assertEquals("Invalid Phone Number", utils.formatNumber(5552125478l, 1));
		assertEquals("Invalid Phone Number", utils.formatNumber(824521256l, 91));
		assertEquals("Invalid Phone Number", utils.formatNumber(55212547l, 63));
		assertEquals("Invalid Phone Number", utils.formatNumber(875423141451l, 404));
		assertEquals("Invalid Phone Number", utils.formatNumber(0l, 1));
	}

	@Test
	public void testFormatNumberTrue() {

		assertEquals("+91 87540 64243", utils.formatNumber(8754064243l, 91));
		assertEquals("+1 202-555-8965", utils.formatNumber(2025558965l, 1));
		assertEquals("+91 89399 04119", utils.formatNumber(8939904119l, 91));
		assertEquals("+63 956 840 6494", utils.formatNumber(9568406494l, 63));
		assertEquals("+1 864-633-9049", utils.formatNumber(8646339049l, 1));
	}

	@Test
	public void testEmptyView() throws IOException {

//		when(util.file.length()).thenReturn(0l);
//		utils.fileView();
		utils.fileExport(300);
		File testfile = new File("PhoneBook.txt");
		testfile.delete();
		when(file.length()).thenReturn(0l);
		utils.fileView();
		Files.write(Paths.get("PhoneBook.txt"),Files.readAllLines(Paths.get("Contacts300.txt")),Charset.defaultCharset());
	}

	@Test
	public void testView() throws IOException {

		when(file.length()).thenReturn(5l);
		utils.fileView();
		
	}

	@Test
	public void testSearchTrue() throws IOException {

		when(oplist.isEmpty()).thenReturn(false);
		utils.fileSearch("akash");

	}

	@Test
	public void testSearchFalse() throws IOException {

		when(oplist.isEmpty()).thenReturn(true);
		utils.fileSearch("9876543722214");

	}

	@Test
	public void testExport() throws IOException {

		File testFile = new File("Contacts25.txt");
		utils.fileExport(25);
		if (testFile.exists())
			System.out.println("Pass");

	}

}
